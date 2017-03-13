package service.impl;

import dao.api.OrderDAO;
import dao.impl.OrderDAOImpl;
import dto.OrderDTO;
import entity.Order;
import helper.Transformer;
import service.api.OrderService;

import java.util.Date;

/**
 * Created by Boo on 13.03.2017.
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO findByDate(Date date) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = orderDAO.findByDate(date);
        return Transformer.transformOrderToOrderDTO(order);
    }

    @Override
    public OrderDTO findById(Integer id) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = orderDAO.findById(id);
        return Transformer.transformOrderToOrderDTO(order);
    }

    @Override
    public boolean create(OrderDTO orderDTO) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = Transformer.transformOrderDTOToOrder(orderDTO);
        return orderDAO.create(order);
    }

    @Override
    public boolean update(OrderDTO orderDTO) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = Transformer.transformOrderDTOToOrder(orderDTO);
        return orderDAO.update(order);
    }

    @Override
    public boolean delete(OrderDTO orderDTO) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = Transformer.transformOrderDTOToOrder(orderDTO);
        return orderDAO.delete(order);
    }
}
