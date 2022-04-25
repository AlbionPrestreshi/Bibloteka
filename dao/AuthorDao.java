package bibloteka.dao;

import bibloteka.domain.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class AuthorDao implements Dao<Author> {
    @Override
    public ArrayList<Author> getAll() throws Exception {

        ArrayList<Author> list = null;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();// PreparedStatement

            String sql = "SELECT * FROM authors";
            rs = stmt.executeQuery(sql);

            list = new ArrayList<>();

            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setLastName(rs.getString("lastname"));
                author.setCountry(rs.getString("country"));
                list.add(author);

            }
        } finally {

            if (rs != null) rs.close();

            if (stmt != null) stmt.close();

            if (conn != null) conn.close();
        }
        return list;

    }

    @Override
    public int save(Author author) throws Exception {

        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();

            String query = "INSERT INTO authors(name,lastname,country) " + " VALUES( ?,?,?)";

// Statement.RETURN_GENERATED_KEYS -> per me kthy ID qe gjenerohet

// nga MySQL
            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getLastName());
            stmt.setString(3, author.getCountry());
            result = stmt.executeUpdate(); // ekstraktimi i ID-se se gjeneruar nga DB
            ResultSet insertedId = stmt.getGeneratedKeys();
            if (insertedId.next()) {
                author.setId(insertedId.getInt(1));
            }
        } finally {
            stmt.close();
            conn.close();
        }
        return result;

    }

    @Override
    public int update(Author author) throws Exception {

        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            conn = ConnectionFactory.getConnection();

            String sql = "UPDATE authors SET name=?, last_name=? , country =?WHERE id = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getLastName());
            stmt.setString(3, author.getCountry());
            stmt.setInt(4, author.getId());
            result = stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return result;

    }

    @Override
    public int delete(Author record) throws Exception {
        int result = 0;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM authors WHERE id = '" + record.getId() + "'";
            result = stmt.executeUpdate(sql);
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return result;

    }

    @Override
    public Author get(long id) throws Exception {

        Author author = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();// PreparedStatement

            String sql = "SELECT * FROM authors WHERE id = " + id;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {

                author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setLastName(rs.getString("last_name"));
                author.setCountry(rs.getString("country"));

            }
        } finally {

            if (rs != null) rs.close();

            if (stmt != null) stmt.close();

            if (conn != null) conn.close();
        }
        return author;

    }

}