package repository;

import model.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends DaoBase<User, Integer>{
    public <T> User findByProperty(String column_label, T any) throws SQLException;
    public List<User> findAllPaged(int offset) throws SQLException;
    public long count() throws SQLException;
}

