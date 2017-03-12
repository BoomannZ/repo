package dao.api;

import entity.User;

/**
 * Created by Boo on 12.03.2017.
 */
public interface UserDAO {
    User findByLoginAndPassword(String login);

    boolean create(User user);
    User update(User user);
    boolean delete(User user);
}
