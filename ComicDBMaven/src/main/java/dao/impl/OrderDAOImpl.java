package dao.impl;

import dao.api.OrderDAO;
import entity.Order;

import java.util.Date;

/**
 * Created by Boo on 12.03.2017.
 */
public class OrderDAOImpl implements OrderDAO{
    @Override
    public Order findByDate(Date date) {
        return null;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public boolean create(Order order) {
        return false;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(Order order) {
        return false;
    }
}
