package bibloteka.dao;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;


public class BibliotekaAbstractDao<T> implements BibliotekaDao<T> {
    protected ConnectionSource connection;
    protected Dao<T, String> dao;

    public BibliotekaAbstractDao(Class<T> cls) throws SQLException {
        connection = ConnectionFactory.getConnection();
        dao = DaoManager.createDao(connection, cls);
    }

    public T get(String id) throws Exception {
        T record = null;
        List<T> records = dao.query(dao.queryBuilder()
                .where()
                .idEq(id)
                .prepare());
        if (records.size() > 0)
            record = records.get(0);
        return record;
    }

    public List<T> getAll() throws Exception {
        return dao.queryForAll();
    }

    public int save(T record) throws Exception {
        return dao.create(record);
    }

    public int update(T record) throws Exception {
        return dao.update(record);
    }

    public int delete(T record) throws Exception {
        return dao.delete(record);
    }
}
