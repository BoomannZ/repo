package controller;

import dto.ComicDTO;
import entity.Comic;
import entity.ComicType;
import entity.EnumComicType;
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
        ComicType absolute = new ComicType();
        absolute.setId(2);
        absolute.setDescription("frequently slipcased");
        absolute.setType(EnumComicType.ABSOLUTE);
        List<ComicType> comicTypes = new ArrayList<ComicType>();
        comicTypes.add(absolute);
        System.out.println(comicTypes.get(0).getDescription());

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
