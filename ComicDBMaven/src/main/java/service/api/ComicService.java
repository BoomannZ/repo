package service.api;

import dto.ComicDTO;
import entity.Status;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Boo on 13.03.2017.
 */
public interface ComicService {
    ComicDTO findById(Integer id) throws SQLException;
    ComicDTO findByName(String name) throws SQLException;
    List<ComicDTO> findAllByStatus(Status status) throws SQLException;

    boolean create(ComicDTO comicDTO) throws SQLException;
    boolean update(ComicDTO comicDTO) throws SQLException;
    boolean delete(ComicDTO comicDTO) throws SQLException;
}
