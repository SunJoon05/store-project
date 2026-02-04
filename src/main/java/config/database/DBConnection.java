package config.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String DATABASE = "store-bd";
    private static String HOST = "127.0.0.1";
    private static String PORT = "3306";
    private static String USER = "root";
    private static String PASS = "1234a";
    private static String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private static Connection connection; // static instance apply the singleton pattern

    private DBConnection(){}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASS);
        }

        return connection;
    }
}
