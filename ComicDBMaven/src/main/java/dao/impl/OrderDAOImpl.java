package dao.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.api.ComicDAO;
import dao.api.OrderDAO;
import datasource.DataSource;
import entity.Comic;
import entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Boo on 12.03.2017.
 */
public class OrderDAOImpl implements OrderDAO{
    @Override
    public Order findByExactDate(Date date) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM orders O JOIN orders_comics ON O.id = OC.id_order WHERE O.date = ?");
        selectStatement.setDate(1, new java.sql.Date(date.getTime()));
        ResultSet resultSet = selectStatement.executeQuery();
        Order order = new Order();
        List<Comic> comicList = new ArrayList<Comic>();
        ComicDAO comicDAO = new ComicDAOImpl();
        while(resultSet.next()) {
            order.setId(resultSet.getInt("id"));
            order.setDate(resultSet.getDate("date"));
            order.setComment(resultSet.getString("comment"));
            order.setPaid(resultSet.getBoolean("paid"));
            comicList.add(comicDAO.findById(resultSet.getInt("id_comic")));
        }
        return order;
    }

    @Override
    public List<Order> findByDateRange(Date beginDate, Date endDate) throws SQLException {
        Map<Integer, Order> resultMap = new TreeMap<Integer, Order>();
        List<Order> resultList = new ArrayList<Order>();
        ComicDAO comicDAO = new ComicDAOImpl();
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM orders O JOIN orders_comics ON O.id = OC.id_order WHERE O.date BETWEEN ? AND ?");
        selectStatement.setDate(1, new java.sql.Date(beginDate.getTime()));
        selectStatement.setDate(2, new java.sql.Date(endDate.getTime()));
        ResultSet resultSet = selectStatement.executeQuery();
        while (resultSet.next()) {
            Integer orderId = resultSet.getInt("id");
            Order order = resultMap.get(orderId);
            if (order == null) {
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setDate(resultSet.getDate("date"));
                order.setComment(resultSet.getString("comment"));
                order.setPaid(resultSet.getBoolean("paid"));
                List<Comic> comicList = new ArrayList<Comic>();
                comicList.add(comicDAO.findById(resultSet.getInt("id_comic")));
                order.setComicList(comicList);
                resultMap.put(orderId, order);
            } else {
                List<Comic> comicList = order.getComicList();
                comicList.add(comicDAO.findById(resultSet.getInt("id_comic")));
                order.setComicList(comicList);
            }
            resultList = new ArrayList<Order>(resultMap.values());
        }
        return resultList;
    }

    @Override
    public void create(Order order) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO orders (paid, date, comment) VALUES (?, ?, ?)");
        insertStatement.setBoolean(1, order.isPaid());
        insertStatement.setDate(2, new java.sql.Date(order.getDate().getTime()));
        insertStatement.setString(3, order.getComment());
        insertStatement.execute();
        PreparedStatement lastInsertedId = connection.prepareStatement("SELECT LAST_INSERT_ID()");
        ResultSet lastInsertedIdResultSet = lastInsertedId.executeQuery();
        insertRelated(order, lastInsertedIdResultSet.getInt(0));
    }

    @Override
    public void update(Order order) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement updateStatement = connection.prepareStatement("UPDATE orders SET paid = ?, date = ?, comment = ? WHERE id = ?");
        updateStatement.setBoolean(1, order.isPaid());
        updateStatement.setDate(2, new java.sql.Date(order.getDate().getTime()));
        updateStatement.setString(3, order.getComment());
        updateStatement.setInt(4, order.getId());
        updateStatement.execute();

        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM orders_comics WHERE id_order = ?");
        deleteStatement.setInt(1, order.getId());
        deleteStatement.execute();
        insertRelated(order);

    }

    @Override
    public void delete(Order order) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");
        deleteStatement.setInt(1, order.getId());
        deleteStatement.execute();

    }
    private void insertRelated(Order order) throws SQLException {
        for(Comic comic : order.getComicList()) {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement insertRelatedStatement = connection.prepareStatement("INSERT INTO orders_comics VALUES (?, ?)");
            insertRelatedStatement.setInt(1, order.getId());
            insertRelatedStatement.setInt(2, comic.getId());
            insertRelatedStatement.execute();
        }
    }
    private void insertRelated(Order order, Integer idParent) throws SQLException {
        for(Comic comic : order.getComicList()) {
            Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement insertRelatedStatement = connection.prepareStatement("INSERT INTO orders_comics VALUES (?, ?)");
            insertRelatedStatement.setInt(1, idParent);
            insertRelatedStatement.setInt(2, comic.getId());
            insertRelatedStatement.execute();
        }
    }
}
