package service.api;

import dto.OrderDTO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Boo on 13.03.2017.
 */
public interface OrderService {
    OrderDTO findByExactDate(Date date) throws SQLException;
    List<OrderDTO> findByDateRange(Date beginDate, Date endDate) throws SQLException;

    void create(OrderDTO orderDTO) throws SQLException;
    void update(OrderDTO orderDTO) throws SQLException;
    void delete(OrderDTO orderDTO) throws SQLException;
}
