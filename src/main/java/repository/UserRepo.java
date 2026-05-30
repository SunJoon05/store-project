package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.entities.User;
import static database.DataSource.getConnection;

public class UserRepo implements UserDao {
    public static final String TABLE = "users";

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT users.*, user_roles.role_id FROM users INNER JOIN user_roles ON users.id = user_roles.user_id";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User current_user = createUser(rs);
                users.add(current_user);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public List<User> findAllPaged(int offset) throws SQLException {
        List<User> page = new ArrayList<>();
        String query = """
                SELECT users.*, role_id FROM users
                INNER JOIN user_roles ON users.id = user_roles.user_id
                LIMIT 10 OFFSET %s
                """.formatted(offset);

        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                User current_user = createUser(rs);
                page.add(current_user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (page.isEmpty()) {
            return List.of();
        }

        return page;
    }

    @Override
    public long count() throws SQLException {
        String query = "SELECT COUNT(*) FROM users";
        long count = 0;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getLong(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return count;
    }

    @Override
    public Boolean insert(User entity) throws SQLException {

        if (findByProperty("email", entity.getEmail()) != null) {
            return false;
        }

        String query = "INSERT INTO "+ TABLE +" (first_name, last_name, email, password_hash, phone, birth_date, register_date, last_login, state) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            pstmt.setBoolean(9,entity.getState());

            if (pstmt.executeUpdate() > 0) {
                is_success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return is_success;
    }

    @Override
    public Boolean update(User entity) throws SQLException {
        User old_user = findByProperty("id", entity.getId());
        // podemos realizar el inner join para actualizar el role en la bd

        if (old_user == null) {
            return false;
        }

        // realizar la actualización de la tabla en user y el valor asociado a su role
        String query = "UPDATE users " +
                "INNER JOIN user_roles ON users.id = user_roles.user_id " +
                "SET " +
                "  users.profile_picture = ?, " +
                "  users.first_name = ?, " +
                "  users.last_name = ?, " +
                "  users.email = ?, " +
                "  users.password_hash = ?, " +
                "  users.phone = ?, " +
                "  users.birth_date = ?, " +
                "  users.register_date = ?, " +
                "  users.last_login = ?, " +
                "  users.state = ?, " +
                "  user_roles.role_id = ? " +
                "WHERE users.id = ?;";

        try (Connection conn = getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getProfilePicture());
            pstmt.setObject(2, entity.getFirstName(), Types.VARCHAR);
            pstmt.setObject(3, entity.getLastName(), Types.VARCHAR);
            pstmt.setObject(4, entity.getEmail(), Types.VARCHAR);
            pstmt.setObject(5, entity.getPasswordHash(), Types.VARCHAR);
            pstmt.setObject(6, entity.getPhone(), Types.VARCHAR);
            pstmt.setObject(7, entity.getBirthDate(), Types.VARCHAR);
            pstmt.setObject(8, entity.getRegisterDate(), Types.VARCHAR);
            pstmt.setObject(9, entity.getLastLogin(), Types.VARCHAR);
            pstmt.setBoolean(10, entity.getState());
            pstmt.setInt(11, entity.getRole().getId());
            pstmt.setInt(12, entity.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Boolean delete(Integer id) throws SQLException {
        boolean result = false;
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);

            if (pstmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public <T> User findByProperty(String column_label, T any) throws SQLException {
        User found_user = null;
        String query = "SELECT users.*, user_roles.role_id FROM users INNER JOIN user_roles ON users.id = user_roles.user_id WHERE "+ column_label +" = ?";

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
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

    public static User createUser(ResultSet current_row) throws SQLException {
        int id = current_row.getInt("id");
        String profile_picture = current_row.getString("profile_picture");
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

        return new User(id, profile_picture, first_name, last_name, email, password_hash, phone, birth_date, register_date, last_login, role, state);
    }
}
