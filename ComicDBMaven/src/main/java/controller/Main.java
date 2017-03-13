package controller;

import dto.ComicDTO;
import entity.Comic;
import entity.ComicType;
import helper.Transformer;
import holder.PropertyHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Logger log = LogManager.getLogger("Main");

        PropertyHolder ph = PropertyHolder.getInstance();
        System.out.println(ph.getProperty("db.login"));

        Comic comic = new Comic();
        comic.setName("Action Comics #21");
        List<ComicType> comicTypes = new ArrayList<ComicType>();
        comicTypes.add(ComicType.DELUXE);
        comicTypes.add(ComicType.OTHER);
        comic.setComicTypeList(comicTypes);

        ComicDTO comicDTO = Transformer.transformComicToComicDTO(comic);
        System.out.println(comicDTO.getName());

        List<ComicType> comicDTOTypes = comicDTO.getComicTypeList();
        System.out.println(comicDTOTypes.get(0));
        System.out.println(comicDTOTypes.get(1));

        try {
            Thread.sleep(2000);
            log.info("Waiting...");
            Thread.sleep(2000);
            log.info("Waiting...");

        } catch (InterruptedException e) {
            log.warn(e);
        }

        log.info("Finished");

    }
}
