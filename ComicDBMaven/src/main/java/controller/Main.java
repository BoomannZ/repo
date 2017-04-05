package controller;

import dto.ComicDTO;
import entity.Comic;
import entity.ComicType;
import entity.Status;
import holder.PropertyHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.api.ComicService;
import service.impl.ComicServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
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
//        try {
//
//            Class.forName("com.mysql.jdbc.Driver");
//
//        }
//        catch (ClassNotFoundException e) {
//
//            log.warn(e);
//        }
        /* end of driver initialization */
        /* findById test */
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
        /* end of findById test */
        /* findByName test */
        try {
            targetedComic = comicService.findByName("Klaus");
            System.out.println("Found: " + targetedComic.getName());
            System.out.println("Where: " + targetedComic.getStatus());
        }
        catch (SQLException e) {
            log.error(e);
        }
        /* end of findByName test */

        /* findAllByStatus test */
        List<ComicDTO> comics = null;
        try {
            comics = comicService.findAllByStatus(Status.IN_COLLECTION);

        } catch (SQLException e) {
            log.error(e);
        }
        for (ComicDTO comicDTO : comics) {
            System.out.println(comicDTO.getName() + " " + comicDTO.getDescription());
        }
        /* end of findAllByStatus test */

        /* create test */
            ComicDTO comicToAdd = new ComicDTO();
            List<ComicType> ct = new ArrayList<ComicType>();
            comic.setId(11);
            comic.setName("Маус");
            comic.setDescription("на русском");
            comic.setStatus(Status.IN_COLLECTION);
            ct.add(ComicType.OTHER);
            ct.add(ComicType.HC);
            comic.setComicTypeList(ct);
        boolean isSusccesful = comicService.create(comicToAdd);
        /* end of create test */
        /* update test */
        /* end of update test */
        /* delete test */
        /* end of delete test */
        log.info("Finished");

    }
}
