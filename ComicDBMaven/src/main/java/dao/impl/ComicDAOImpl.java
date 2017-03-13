package dao.impl;

import dao.api.ComicDAO;
import entity.Comic;
import entity.Status;

import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
public class ComicDAOImpl implements ComicDAO{

    @Override
    public Comic findById(int id) {
        return null;
    }

    @Override
    public Comic findByName(String name) {
        return null;
    }

    @Override
    public List<Comic> findAllByStatus(Status status) {
        return null;
    }

    @Override
    public boolean create(Comic comic) {
        return false;
    }

    @Override
    public boolean update(Comic comic) {
        return false;
    }

    @Override
    public boolean delete(Comic comic) {
        return false;
    }
}
