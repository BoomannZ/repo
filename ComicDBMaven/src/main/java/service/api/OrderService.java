package service.api;

import dto.OrderDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by Boo on 13.03.2017.
 */
public interface OrderService {
    OrderDTO findByExactDate(Date date);
    List<OrderDTO> findByDateRange(Date beginDate, Date endDate);

    void create(OrderDTO orderDTO);
    void update(OrderDTO orderDTO);
    void delete(OrderDTO orderDTO);
}
