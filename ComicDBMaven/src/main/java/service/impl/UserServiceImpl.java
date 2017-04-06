package service.impl;

import dao.api.UserDAO;
import dao.impl.UserDAOImpl;
import dto.UserDTO;
import entity.User;
import helper.Transformer;
import service.api.UserService;

/**
 * Created by Boo on 13.03.2017.
 */
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO findByLoginAndPassword(String login) {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.findByLoginAndPassword(login);
        return Transformer.transformUserToUserDTO(user);
    }

    @Override
    public void create(UserDTO userDTO) {
        UserDAO userDAO = new UserDAOImpl();
        User user = Transformer.transformUserDTOToUser(userDTO);
        userDAO.create(user);
    }

    @Override
    public void update(UserDTO userDTO) {
        UserDAO userDAO = new UserDAOImpl();
        User user = Transformer.transformUserDTOToUser(userDTO);
        userDAO.update(user);
    }

    @Override
    public void delete(UserDTO userDTO) {
        UserDAO userDAO = new UserDAOImpl();
        User user = Transformer.transformUserDTOToUser(userDTO);
        userDAO.delete(user);
    }
}
