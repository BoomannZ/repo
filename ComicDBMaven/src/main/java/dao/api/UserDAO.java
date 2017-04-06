package dao.api;

import entity.User;

/**
 * Created by Boo on 12.03.2017.
 */
public interface UserDAO {
    User findByLoginAndPassword(String login);

    void create(User user);
    void update(User user);
    void delete(User user);
}
