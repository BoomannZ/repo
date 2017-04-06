package service.impl;

import dao.api.ComicDAO;
import dao.impl.ComicDAOImpl;
import dto.ComicDTO;
import entity.Comic;
import entity.Status;
import helper.Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.api.ComicService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Boo on 13.03.2017.
 */
public class ComicServiceImpl implements ComicService {

    Logger log = LogManager.getLogger();

    @Override
    public ComicDTO findById(Integer id) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        Comic comic = comicDAO.findById(id);
        return Transformer.transformComicToComicDTO(comic);
    }

    @Override
    public ComicDTO findByName(String name) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        Comic comic = comicDAO.findByName(name);
        return Transformer.transformComicToComicDTO(comic);
    }

    @Override
    public List<ComicDTO> findAllByStatus(Status status) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        List<Comic> comicList = comicDAO.findAllByStatus(status);
        return Transformer.transformComicListToComicDTOList(comicList);
    }

    @Override
    public void create(ComicDTO comicDTO) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        Comic comic = Transformer.transformComicDTOToComic(comicDTO);
        comicDAO.create(comic);
    }

    @Override
    public void update(ComicDTO comicDTO) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        Comic comic = Transformer.transformComicDTOToComic(comicDTO);
        comicDAO.update(comic);

    }

    @Override
    public void delete(ComicDTO comicDTO) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        Comic comic = Transformer.transformComicDTOToComic(comicDTO);
        comicDAO.delete(comic);
    }
}
