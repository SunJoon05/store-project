package repository;

import model.entities.user;

import java.sql.SQLException;

public interface UserDao extends DaoBase<user, Integer>{
    public <T> user findBy(String column_label, T any) throws SQLException;
}
