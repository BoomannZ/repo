package dao.api;

import entity.User;

import java.sql.SQLException;

/**
 * Created by Boo on 12.03.2017.
 */
public interface UserDAO {
    User findByLoginAndPassword(String login, String password) throws SQLException;

    void create(User user) throws SQLException;
    void update(User user) throws SQLException;
    void delete(User user) throws SQLException;
}
