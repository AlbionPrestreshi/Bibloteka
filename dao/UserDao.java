package bibloteka.dao;

import bibloteka.domain.User;

import java.util.List;


import java.sql.*;
import java.util.*;

public class UserDao implements Dao<User> {

    @Override
    public User get(long id) throws Exception {
        User user = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();// PreparedStatement

            String sql = "SELECT * FROM users WHERE id = " + id;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                user = createUser(rs);

            }
        } finally {

            if (rs != null) rs.close();

            if (stmt != null) stmt.close();

            if (conn != null) conn.close();
        }
        return user;

    }

    @Override
    public List<User> getAll() throws Exception {

        ArrayList<User> list = null;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();// PreparedStatement

            String sql = "SELECT * FROM users";
            rs = stmt.executeQuery(sql);

            list = new ArrayList<>();

            while (rs.next()) {
                User user = createUser(rs);
                list.add(user);

            }
        } finally {

            if (rs != null) rs.close();

            if (stmt != null) stmt.close();

            if (conn != null) conn.close();
        }
        return list;

    }

    private User createUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setLastLogin(rs.getTimestamp("last_login"));
        return user;
    }

    @Override
    public int save(User user) throws Exception {

        if (user.getId() > 0) {
            return update(user);
        } else {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = ConnectionFactory.getConnection();

                stmt = conn.createStatement();// PreparedStatement

                String sql = "INSERT INTO users (id,username,password) VALUES(NULL,'" + user.getUsername() + "','" + user.getPassword() + "')";
                return stmt.executeUpdate(sql);

            } finally {
                if (stmt != null) stmt.close();

                if (conn != null) conn.close();
            }

        }

    }

    @Override
    public int update(User user) throws Exception {

        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();// PreparedStatement

            String sql = "UPDATE users SET username='" + user.getUsername() + "' , password = '" + user.getPassword() + "' WHERE id=" + user.getId();
            return stmt.executeUpdate(sql);

        } finally {
            if (stmt != null) stmt.close();

            if (conn != null) conn.close();
        }

    }

    @Override
    public int delete(User user) throws Exception {

        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();// PreparedStatement

            String sql = "DELETE FROM users WHERE id=" + user.getId();
            return stmt.executeUpdate(sql);

        } finally {
            if (stmt != null) stmt.close();

            if (conn != null) conn.close();
        }

    }

    public User login(String username, String password) throws Exception {
        User user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            String query = "SELECT * FROM users WHERE username=? AND password=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = createUser(rs);
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        return user;

    }

}