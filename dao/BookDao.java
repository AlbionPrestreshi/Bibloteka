package bibloteka.dao;

import bibloteka.domain.Book;

import java.sql.SQLException;



public class BookDao extends BibliotekaAbstractDao<Book> {

    public BookDao(Class<Book> cls) throws SQLException {
        super(Book.class);
    }
}