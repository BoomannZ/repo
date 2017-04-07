package dao.impl;

import dao.api.UserDAO;
import datasource.DataSource;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Boo on 12.03.2017.
 */
public class UserDAOImpl implements UserDAO {
    public User findByLoginAndPassword(String login, String password) throws SQLException {
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement selectStatement = connection.prepareStatement("SELECT id FROM users WHERE login = ? AND password = ?");
        selectStatement.setString(1, login);
        selectStatement.setString(2, password);
        ResultSet  resultSet = selectStatement.executeQuery();
        User user = new User();
        while (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
        }
        return user;
    }

    public void create(User user) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users(login, password, name ) VALUES (?, ?, ?)");
        insertStatement.setString(1, user.getLogin());
        insertStatement.setString(2, user.getPassword());
        insertStatement.setString(3, user.getName());
        insertStatement.execute();

    }

    public void update(User user) throws SQLException {

        Integer userId = findByLoginAndPassword(user.getLogin(), user.getPassword()).getId();
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement updateStatement = connection.prepareStatement("UPDATE users SET login = ?, password = ?, name = ? WHERE id = ?");
        updateStatement.setString(1, user.getLogin());
        updateStatement.setString(2, user.getPassword());
        updateStatement.setString(3, user.getName());
        updateStatement.setInt(4, userId);
    }

    public void delete(User user) throws SQLException {

        Integer userId = findByLoginAndPassword(user.getLogin(), user.getPassword()).getId();
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
        deleteStatement.setInt(1, userId);
    }
}
