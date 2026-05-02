package repository;

import static database.DataSource.getConnection;
import model.entities.Permission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionsImplementation implements PermissionsDao {

    // devolver los permisos de la base de datos de todos los usuarios
    @Override
    public List<Permission> findPermissionsById(Integer role_id) throws SQLException {
        String query = "SELECT id, name, action FROM permissions p INNER JOIN role_permissions rp ON p.id = rp.permission_id WHERE rp.role_id = ?";
        List<Permission> permissions = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Permission permission = normalizePermission(rs);
                permissions.add(permission);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return permissions;
    }

    @Override
    public List<Permission> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public Boolean insert(Permission entity) throws SQLException {
        return null;
    }

    @Override
    public Boolean update(Permission entity) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {
        return null;
    }

    private Permission normalizePermission(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String resource = rs.getString("resource");
        String action = rs.getString("action");
        return new Permission(id, name, resource, action);
    }
}
