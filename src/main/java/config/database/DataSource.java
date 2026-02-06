package config.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static final String DATABASE = "store-bd";
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASS = "1234a";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private static final String DRIVER =  "com.mysql.cj.jdbc.Driver";
    private static Connection connection; // static instance apply the singleton pattern

    private DataSource(){}

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        }

        return connection;
    }
}
