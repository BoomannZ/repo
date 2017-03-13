package service.api;

import dto.UserDTO;

/**
 * Created by Boo on 13.03.2017.
 */
public interface UserService {
    UserDTO findByLoginAndPassword(String login);

    boolean create(UserDTO userDTO);
    boolean update(UserDTO userDTO);
    boolean delete(UserDTO userDTO);
}
