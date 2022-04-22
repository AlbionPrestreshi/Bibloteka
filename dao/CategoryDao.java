package bibloteka.dao;

import bibloteka.domain.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class CategoryDao implements Dao<Category> {

    // cache categories
    private static HashMap<Integer, Category> cachedCategories;

    private ArrayList<Category> getFromDB() throws Exception {

        ArrayList<Category> list = null;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();// PreparedStatement

            String sql = "SELECT * FROM categories";
            rs = stmt.executeQuery(sql);

            list = new ArrayList<>();

            while (rs.next()) {

                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                list.add(category);

            }
        } finally {

            if (rs != null) rs.close();

            if (stmt != null) stmt.close();

            if (conn != null) conn.close();
        }
        return list;

    }

    @Override
    public Category get(long id) throws Exception {

        if (cachedCategories != null) {
            return cachedCategories.get(id);

        } else {
            getAll();
            return cachedCategories.get(id);

        }
    }

    @Override
    public ArrayList<Category> getAll() throws Exception {

        ArrayList<Category> categories = null;

        if (cachedCategories == null) {

            cachedCategories = new HashMap<>();

            categories = getFromDB();
            for (Category category : categories) {
                cachedCategories.put(category.getId(), category);
            }
        } else {

            categories = new ArrayList<>();

            for (Category category : cachedCategories.values()) {
                categories.add(category);
            }

        }
        return categories;

    }

    @Override
    public int save(Category category) throws Exception {

        int result = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();

            String query = "INSERT INTO categories(id,name) VALUES(?,?)";

            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, category.getId());
            stmt.setString(2, category.getName());

            result = stmt.executeUpdate();

            ResultSet insertedId = stmt.getGeneratedKeys();
            if (insertedId.next()) {
                category.setId(insertedId.getInt(1));

            }
        } finally {

            stmt.close();

            conn.close();
        }
        return result;

    }

    @Override
    public int update(Category category) throws Exception {

        int result = 0;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = "UPDATE categories SET name = ? WHERE id = ?";
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, category.getName());
            prepStmt.setInt(2, category.getId());
            result = prepStmt.executeUpdate();
        } finally {
            prepStmt.close();
            conn.close();
        }
        return result;

    }

    @Override
    public int delete(Category category) throws Exception {

        int result = 0;
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {

            conn = ConnectionFactory.getConnection();

            String sql = "DELETE FROM categories WHERE id = ?";

            prepStmt = conn.prepareStatement(sql);

            prepStmt.setInt(1, category.getId());

            result = prepStmt.executeUpdate();
        } finally {

            prepStmt.close();

            conn.close();
        }
        return result;

    }

}