package database;

import config.ApplicationConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static final String DATABASE = ApplicationConfiguration.getProperty("database.name");
    private static final String HOST = ApplicationConfiguration.getProperty("database.host");
    private static final String PORT = ApplicationConfiguration.getProperty("database.port");
    private static final String USER = ApplicationConfiguration.getProperty("database.user");
    private static final String PASS = ApplicationConfiguration.getProperty("database.pass");
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private static final String DRIVER =  "com.mysql.cj.jdbc.Driver";
    private static Connection connection;

    private DataSource(){}

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        }

        return connection;
    }
}
