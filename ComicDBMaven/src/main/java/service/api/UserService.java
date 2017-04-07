package service.api;

import dto.UserDTO;

import java.sql.SQLException;

/**
 * Created by Boo on 13.03.2017.
 */
public interface UserService {
    UserDTO findByLoginAndPassword(String login, String password) throws SQLException;

    void create(UserDTO userDTO) throws SQLException;
    void update(UserDTO userDTO) throws SQLException;
    void delete(UserDTO userDTO) throws SQLException;
}
