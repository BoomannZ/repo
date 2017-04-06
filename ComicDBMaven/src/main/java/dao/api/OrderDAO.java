package dao.api;

import entity.Order;

import java.util.Date;

/**
 * Created by Boo on 12.03.2017.
 */
public interface OrderDAO {
    Order findByDate(Date date);
    Order findById(int id);

    void create(Order order);
    void update(Order order);
    void delete(Order order);
}
