package service;

import jakarta.servlet.http.HttpSession;
import model.entities.Permission;
import repository.PermissionRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionService {

    private final PermissionRepo DAO;

    public PermissionService(PermissionRepo DAO) {
        this.DAO = DAO;
    }

    public List<Permission> userPermissionsById(int role_id) {
        List<Permission> permissions = new ArrayList<>();

        try {
            permissions = this.DAO.findPermissionsById(role_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return permissions;
    }

    public static boolean can(HttpSession session, Permission permission) {
        List<Permission> permissions = (List<Permission>) session.getAttribute("permissions");
        return permissions != null && permissions.contains(permission);
    }

}
