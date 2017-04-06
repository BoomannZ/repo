package service.api;

import dto.UserDTO;

/**
 * Created by Boo on 13.03.2017.
 */
public interface UserService {
    UserDTO findByLoginAndPassword(String login);

    void create(UserDTO userDTO);
    void update(UserDTO userDTO);
    void delete(UserDTO userDTO);
}
