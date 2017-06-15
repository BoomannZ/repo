package controller;

import entity.Comic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import service.api.ComicService;

public class Main {

    public static void main(String[] args) throws SQLException {
        /* Initialize logger*/
        Logger log = LogManager.getLogger("Main");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object obj = context.getBean("comicService");
        if (obj instanceof ComicService) {
            ComicService comicService = (ComicService) context.getBean("comicService");
            System.out.println(comicService.findById(1).getName());
            log.info("Class cast is successful");
        }


        log.info("Finished");


    }
}
