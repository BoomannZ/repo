package service.api;

import dto.OrderDTO;

import java.util.Date;

/**
 * Created by Boo on 13.03.2017.
 */
public interface OrderService {
    OrderDTO findByDate(Date date);
    OrderDTO findById(Integer id);

    void create(OrderDTO orderDTO);
    void update(OrderDTO orderDTO);
    void delete(OrderDTO orderDTO);
}
