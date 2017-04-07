package dao.api;

import entity.Order;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
public interface OrderDAO {
    Order findByExactDate(Date date) throws SQLException;
    List<Order> findByDateRange(Date beginDate, Date endDate);

    void create(Order order) throws SQLException;
    void update(Order order) throws SQLException;
    void delete(Order order) throws SQLException;
}
