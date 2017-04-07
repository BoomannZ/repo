package service.impl;

import dao.api.OrderDAO;
import dao.impl.OrderDAOImpl;
import dto.OrderDTO;
import entity.Order;
import helper.Transformer;
import service.api.OrderService;

import java.util.Date;
import java.util.List;

/**
 * Created by Boo on 13.03.2017.
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO findByExactDate(Date date) {
        OrderDAO orderDAO = new OrderDAOImpl();
        Order order = orderDAO.findByExactDate(date);
        return Transformer.transformOrderToOrderDTO(order);
    }

    @Override
    public List<OrderDTO> findByDateRange(Date beginDate, Date endDate) {
        OrderDAO orderDAO = new OrderDAOImpl();
        List<Order> orderList = orderDAO.findByDateRange(beginDate, endDate);
        return Transformer.transformOrderListToOrderDTOList(orderList);
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
