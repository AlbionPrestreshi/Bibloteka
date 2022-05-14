package bibloteka.dao;

import java.sql.*;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class ConnectionFactory {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookrent";
    public static final String JDBC_USER = "???";
    public static final String JDBC_PASSWORD = "???";

    public static ConnectionSource getConnection() throws SQLException {
        return new JdbcConnectionSource(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

}