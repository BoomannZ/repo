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

    void create(ComicDTO comicDTO) throws SQLException;
    void update(ComicDTO comicDTO) throws SQLException;
    void delete(ComicDTO comicDTO) throws SQLException;
}
