package dao.impl;

import dao.api.ComicDAO;
import entity.Comic;
import entity.ComicType;
import entity.Status;
import holder.PropertyHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
public class ComicDAOImpl implements ComicDAO{

    @Override
    public Comic findById(int id) throws SQLException {
        Logger log = LogManager.getLogger("ComicDAOImpl");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/comicdb?" +
        "user="+ PropertyHolder.getInstance().getProperty("db.login") + "&password=" + PropertyHolder.getInstance().getProperty("db.password"));

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM comics C JOIN comic_types CT ON C.id = CT.id_comic  where id = ?");
        List<ComicType> comicTypes = new ArrayList<ComicType>();
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Comic comic = new Comic();
            while (resultSet.next()) {
                comic.setId(resultSet.getInt("id"));
                comic.setName(resultSet.getString("name"));
                comic.setDescription(resultSet.getString("description"));
                comic.setStatus(Status.values()[resultSet.getInt("status")]);
                comicTypes.add(ComicType.values()[resultSet.getInt("type")]);
            }
            comic.setComicTypeList(comicTypes);

        connection.close();
        return comic;
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
