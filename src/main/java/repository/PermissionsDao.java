package repository;


import model.entities.Permission;

import java.sql.SQLException;
import java.util.List;

public interface PermissionsDao extends DaoBase<Permission, Integer>{
    public List<Permission> findPermissionsById(Integer role_id) throws SQLException;
}
