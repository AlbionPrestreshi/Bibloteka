package bibloteka.dao;

import bibloteka.domain.Book;

import java.util.List;

public class BookDao implements Dao<Book> {


    @Override
    public Book get(long id) throws Exception {
        throw new Exception("Nuk eshte implementuar ende!");
    }

    @Override
    public List<Book> getAll() throws Exception {
        throw new Exception("Nuk eshte implementuar ende!");
    }

    @Override
    public int save(Book record) throws Exception {
        throw new Exception("Nuk eshte implementuar ende!");
    }

    @Override
    public int update(Book record) throws Exception {
        throw new Exception("Nuk eshte implementuar ende!");
    }

    @Override
    public int delete(Book record) throws Exception {
        throw new Exception("Nuk eshte implementuar ende!");
    }

}