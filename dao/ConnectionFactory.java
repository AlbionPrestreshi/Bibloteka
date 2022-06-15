package bibloteka.dao;

import java.sql.*;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class ConnectionFactory {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Drive";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookrent?serverTimezone=EST5EDT";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root";

    public static ConnectionSource getConnection() throws SQLException {
        return new JdbcConnectionSource(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}

