package controller;

import dto.ComicDTO;
import entity.Comic;
import entity.ComicType;
import holder.PropertyHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.api.ComicService;
import service.impl.ComicServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /* Initialize logger*/
        Logger log = LogManager.getLogger("Main");

        PropertyHolder ph = PropertyHolder.getInstance();
        System.out.println(ph.getProperty("db.login"));

        Comic comic = new Comic();
        comic.setName("Action Comics #21");

        List<ComicType> comicTypes = new ArrayList<ComicType>();
        comicTypes.add(ComicType.OTHER);
        System.out.println(comicTypes.get(0));

        /*Driver initialization*/
        try {

            Class.forName("com.mysql.jdbc.Driver");

        }
        catch (ClassNotFoundException e) {

            log.warn(e);
        }
        /* end of driver initialization */
        ComicService comicService = new ComicServiceImpl();
        ComicDTO targetedComic;
        try {
            targetedComic = comicService.findById(1);
            System.out.println("id: " + targetedComic.getId());
            System.out.println("name: " + targetedComic.getName());
            System.out.println("description: " + targetedComic.getDescription());
            System.out.println("status: " + targetedComic.getStatus());
            for(ComicType ct : targetedComic.getComicTypeList()) {

                System.out.println("type: " + ct);

            }
        }
        catch (SQLException e) {
            log.error(e);
        }
        /* delay to imitate work on HDD */
        try {
            Thread.sleep(2000);
            log.info("Waiting...");
            Thread.sleep(2000);
            log.info("Waiting...");

        } catch (InterruptedException e) {
            log.warn(e);
        }
        /* end of delay imitation block */
        log.info("Finished");

    }
}
