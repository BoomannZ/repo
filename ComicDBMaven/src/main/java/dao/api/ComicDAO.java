package dao.api;

import entity.Comic;
import entity.Status;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
public interface ComicDAO {
    Comic findById(int id) throws SQLException;
    Comic findByName(String name) throws SQLException;
    List<Comic> findAllByStatus(Status status) throws SQLException;

    void create(Comic comic) throws SQLException;
    void update(Comic comic) throws SQLException;
    void delete(Comic comic) throws SQLException;
}
