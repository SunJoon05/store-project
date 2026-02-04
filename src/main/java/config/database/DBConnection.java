package config.database;

// Class to get the connection with the database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "store-bd";
    private static final String URL = "jdbc:mysql://" + HOST + ":"+ PORT + "/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "1234a";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
