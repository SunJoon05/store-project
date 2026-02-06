package repository;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import model.entities.user;
import static config.database.DataSource.getConnection;


public class UserDaoImpl implements UserDao{
    private static final String TABLE = "users";

    @Override
    public List<user> findAll() throws SQLException {
        String query = "SELECT * FROM " + TABLE;
        List<user> users = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                user current_user = createUser(rs);
                users.add(current_user);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }


    @Override
    public Boolean insert(user entity) throws SQLException {

        if (findBy("email", entity.getEmail()) != null) {
            return false;
        }

        String query = "INSERT INTO "+ TABLE +" (first_name, last_name, email, password_hash, phone, birth_date, register_date, last_login, role_id, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Boolean is_success = false;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);) {
            pstmt.setString(1, entity.getFirstName());
            pstmt.setString(2, entity.getLastName());
            pstmt.setString(3, entity.getEmail());
            pstmt.setString(4, entity.getPasswordHash());
            pstmt.setString(5, entity.getPhone());
            pstmt.setString(6, entity.getBirthDate());
            pstmt.setString(7, entity.getRegisterDate());
            pstmt.setString(8, entity.getLastLogin());
            pstmt.setInt(9, entity.getRoleId());
            pstmt.setBoolean(10, entity.getState());

            if (pstmt.executeUpdate() > 0) {
                is_success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return is_success;
    }

    @Override
    public Boolean update(user entity) throws SQLException {
        user old_user = findBy("id", entity.getId()); // retornamos el dato para comparar, id es un dato inmutable

        if (old_user == null) {
            return false;
        }

        // asignación de reglas dinamicas
        Class<?> props = old_user.getClass(); // Clase
        Field[] fields = props.getDeclaredFields(); // Propiedades
        List<BiConsumer<user, user>> scheme = new ArrayList<>(); // Reglas definidas

        for (Field field : fields) { // Crear reglas por cada prop
            final Field f  = field;
            field.setAccessible(true);
            scheme.add((old, current) -> {
                try {
                    if (f.get(current) == null) {
                        f.set(current, f.get(old));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // ejecutar las reglas
        scheme.forEach((rule) -> {
            rule.accept(old_user, entity);
        });

        return true;
    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {
        return false;
    }

    @Override
    public <T> user findBy(String column_label, T any) throws SQLException {
        user found_user = null;
        String query = "SELECT * FROM " + TABLE + " WHERE " + column_label + " = ?";

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setObject(1, (Object) any);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                found_user = createUser(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return found_user;
    }

    private user createUser(ResultSet current_row) throws SQLException {
        // Crear variables locales para almacenar los datos de todas las tablas por cada fila creamos un nuevo usuario

        int id = current_row.getInt("id");
        String first_name = current_row.getString("first_name");
        String last_name = current_row.getString("last_name");
        String email = current_row.getString("email");
        String password_hash = current_row.getString("password_hash");
        String phone = current_row.getString("phone");
        String birth_date = current_row.getString("birth_date");
        String register_date = current_row.getString("register_date");
        String last_login = current_row.getString("last_login");
        int role  = current_row.getInt("role_id");
        Boolean state = current_row.getBoolean("state");

        return new user(id, first_name, last_name, email, password_hash, phone, birth_date, register_date, last_login, role, state);
    }
}
