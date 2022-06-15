package bibloteka.dao;

import bibloteka.domain.Author;

import java.sql.SQLException;



public class AuthorDao extends BibliotekaAbstractDao<Author> {

    public AuthorDao(Class<Author> cls) throws SQLException {
        super(Author.class);
    }
}
