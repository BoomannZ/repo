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
    public void create(OrderDTO orderDTO) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = Transformer.transformOrderDTOToOrder(orderDTO);
        orderDAO.create(order);

    }

    @Override
    public void update(OrderDTO orderDTO) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = Transformer.transformOrderDTOToOrder(orderDTO);
        orderDAO.update(order);
    }

    @Override
    public void delete(OrderDTO orderDTO) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = Transformer.transformOrderDTOToOrder(orderDTO);
        orderDAO.delete(order);
    }
}
