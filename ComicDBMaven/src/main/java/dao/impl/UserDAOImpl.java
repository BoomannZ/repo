package dao.impl;

import dao.api.UserDAO;
import entity.User;

/**
 * Created by Boo on 12.03.2017.
 */
public class UserDAOImpl implements UserDAO {
    public User findByLoginAndPassword(String login) {
        return null;
    }

    public boolean create(User user) {
        return false;
    }

    public User update(User user) {
        return null;
    }

    public boolean delete(User user) {
        return false;
    }
}
