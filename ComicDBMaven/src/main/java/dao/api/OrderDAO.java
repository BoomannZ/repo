package dao.api;

import entity.Order;

import java.util.Date;

/**
 * Created by Boo on 12.03.2017.
 */
public interface OrderDAO {
    Order findByDate(Date date);
    Order findById(int id);

    boolean create(Order order);
    Order update(Order order);
    boolean delete(Order order);
}
