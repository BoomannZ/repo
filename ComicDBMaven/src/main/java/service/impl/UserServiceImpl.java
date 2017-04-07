package service.impl;

import dao.api.UserDAO;
import dao.impl.UserDAOImpl;
import dto.UserDTO;
import entity.User;
import helper.Transformer;
import service.api.UserService;

import java.sql.SQLException;

/**
 * Created by Boo on 13.03.2017.
 */
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO findByLoginAndPassword(String login, String password) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.findByLoginAndPassword(login, password);
        return Transformer.transformUserToUserDTO(user);
    }

    @Override
    public void create(UserDTO userDTO) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        User user = Transformer.transformUserDTOToUser(userDTO);
        userDAO.create(user);
    }

    @Override
    public void update(UserDTO userDTO) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        User user = Transformer.transformUserDTOToUser(userDTO);
        userDAO.update(user);
    }

    @Override
    public void delete(UserDTO userDTO) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        User user = Transformer.transformUserDTOToUser(userDTO);
        userDAO.delete(user);
    }
}
