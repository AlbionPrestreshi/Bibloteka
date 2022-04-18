package bibloteka.dao;

import java.sql.*;

public class ConnectionFactory {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookrent?serverTimezone=EST5EDT";

    public static final String JDBC_USER = "root";

    public static final String JDBC_PASSWORD = "root";

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        }catch (SQLException ex){
            throw new RuntimeException("Nuk mund te krijohet lidhje", ex);

        }

    }

}
