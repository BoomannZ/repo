package dao.api;

import entity.Comic;
import entity.Status;

import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
public interface ComicDAO {
    Comic findById(int id);
    Comic findByName(String name);
    List<Comic> findAllByStatus(Status status);

    boolean create(Comic comic);
    Comic update(Comic comic);
    boolean delete(Comic comic);
}
