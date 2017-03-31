package service.impl;

import dao.api.ComicDAO;
import dao.impl.ComicDAOImpl;
import dto.ComicDTO;
import entity.Comic;
import entity.Status;
import helper.Transformer;
import service.api.ComicService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Boo on 13.03.2017.
 */
public class ComicServiceImpl implements ComicService {
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
    public boolean create(ComicDTO comicDTO) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        Comic comic = Transformer.transformComicDTOToComic(comicDTO);
        return comicDAO.create(comic);
    }

    @Override
    public boolean update(ComicDTO comicDTO) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        Comic comic = Transformer.transformComicDTOToComic(comicDTO);
        return comicDAO.update(comic);
    }

    @Override
    public boolean delete(ComicDTO comicDTO) throws SQLException{
        ComicDAO comicDAO = new ComicDAOImpl();
        Comic comic = Transformer.transformComicDTOToComic(comicDTO);
        return comicDAO.delete(comic);
    }
}
