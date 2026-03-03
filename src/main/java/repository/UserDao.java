package repository;

import model.entities.User;

import java.sql.SQLException;

public interface UserDao extends DaoBase<User, Integer>{
    public <T> User findBy(String column_label, T any) throws SQLException;
}
