package helper;

import dto.ComicDTO;
import dto.OrderDTO;
import dto.UserDTO;
import entity.Comic;
import entity.Order;
import entity.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbushui on 3/13/2017.
 */
public class Transformer {
    /*Comic <-> ComicDTO*/
    public static Comic transformComicDTOToComic(ComicDTO comicDTO) {
        Mapper mapper = new DozerBeanMapper();
        Comic comic = mapper.map(comicDTO,Comic.class);
        return comic;
    }

    public static ComicDTO transformComicToComicDTO(Comic comic) {
        Mapper mapper = new DozerBeanMapper();
        ComicDTO comicDTO = mapper.map(comic,ComicDTO.class);
        return comicDTO;
    }

    /*Order <-> OrderDTO*/
    public static Order transformOrderDTOToOrder(OrderDTO orderDTO) {
        Mapper mapper = new DozerBeanMapper();
        Order order = mapper.map(orderDTO, Order.class);
        return order;
    }

    public static OrderDTO transformOrderToOrderDTO(Order order) {
        Mapper mapper = new DozerBeanMapper();
        OrderDTO orderDTO = mapper.map(order , OrderDTO.class);
        return orderDTO;
    }

    /*User <-> UserDTO */
    public static User transformUserDTOToUser(UserDTO userDTO) {
        Mapper mapper = new DozerBeanMapper();
        User user = mapper.map(userDTO, User.class);
        return user;
    }

    public static UserDTO transformUserToUserDTO(User user) {
        Mapper mapper = new DozerBeanMapper();
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }

    /*ComicList <-> UserDTOList */
    public static List<ComicDTO> transformComicListToComicDTOList(List<Comic> comicList) {
        List<ComicDTO> comicDTOList = new ArrayList<ComicDTO>();
        for(Comic comic : comicList) {
            comicDTOList.add(Transformer.transformComicToComicDTO(comic));
        }
        return comicDTOList;
    }

    public static List<Comic> transformComicDTOListToComicList(List<ComicDTO> comicDTOList) {
        List<Comic> comicList = new ArrayList<Comic>();
        for(ComicDTO comicDTO : comicDTOList) {
            comicList.add(Transformer.transformComicDTOToComic(comicDTO));
        }
        return comicList;
    }
}
