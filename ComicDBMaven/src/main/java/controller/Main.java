package controller;

import dto.ComicDTO;
import dto.UserDTO;
import entity.Comic;
import entity.ComicType;
import entity.Status;
import holder.PropertyHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.api.ComicService;
import service.api.UserService;
import service.impl.ComicServiceImpl;
import service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        /* Initialize logger*/
        Logger log = LogManager.getLogger("Main");

        PropertyHolder ph = PropertyHolder.getInstance();
        log.info("Started");
        UserService userService = new UserServiceImpl();

        UserDTO userOne = userService.findByLoginAndPassword("bob", "qwerty");
        userOne.setName("Bobby");
        userService.update(userOne);
        log.info("Name:" + userOne.getName());
        log.info("Finished");

    }
}
