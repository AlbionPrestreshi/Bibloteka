package bibloteka.dao;

import java.sql.SQLException;
import java.util.List;

import bibloteka.domain.User;


public class UserDao extends BibliotekaAbstractDao<User> {

    public UserDao() throws SQLException {
        super(User.class);

    }

    public User login(String username, String password) throws Exception {
        User user = null; .
        query(dao.queryBuilder().where().eq("username",
                username).and().eq("password", password).prepare());
        if (users.size() > 0) user = users.get(0);
        return user;

        List<User> users = dao;

    }
}