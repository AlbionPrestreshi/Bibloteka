package bibloteka.dao;

import java.util.List;

public interface BibliotekaDao<T> {

    public T get(String id) throws Exception;

    public List<T> getAll() throws Exception;

    public int save(T record) throws Exception;

    public int update(T record) throws Exception;

    public int delete(T record) throws Exception;

}
