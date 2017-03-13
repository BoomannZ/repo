package service.api;

import dto.ComicDTO;
import entity.Status;

import java.util.List;

/**
 * Created by Boo on 13.03.2017.
 */
public interface ComicService {
    ComicDTO findById(Integer id);
    ComicDTO findByName(String name);
    List<ComicDTO> findAllByStatus(Status status);

    boolean create(ComicDTO comicDTO);
    boolean update(ComicDTO comicDTO);
    boolean delete(ComicDTO comicDTO);
}
