package bibloteka.dao;

import bibloteka.domain.Category;

import java.sql.SQLException;

public class CategoryDao extends BibliotekaAbstractDao<Category> {

    public CategoryDao(Class<Category> cls) throws SQLException {
        super(Category.class);
    }
}
