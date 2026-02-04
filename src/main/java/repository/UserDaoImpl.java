package repository;

import java.sql.*;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.ConnectionFeatureNotAvailableException;
import config.database.DataSource;
import model.entities.user;
import static config.database.DataSource.getConnection;


public class UserDaoImpl implements UserDao{
    private static String TABLE = "users";

    @Override
    public List<user> findAll() throws SQLException {
        String query = "SELECT * FROM " + TABLE;

        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return List.of();
    }


    @Override
    public void insert(user entity) throws SQLException {

    }

    @Override
    public void update(user entity) throws SQLException {

    }

    @Override
    public void delete(Integer integer) throws SQLException {

    }
}
