package dao.impl;

import dao.api.ComicDAO;
import datasource.DataSource;
import entity.Comic;
import entity.ComicType;
import entity.Status;
import holder.PropertyHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.ConnectionPoolDataSource;
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
            /* Comic comic = new Comic();
            while (resultSet.next()) {
                comic.setId(resultSet.getInt("id"));
                comic.setName(resultSet.getString("name"));
                comic.setDescription(resultSet.getString("description"));
                comic.setStatus(Status.values()[resultSet.getInt("status")]);
                comicTypes.add(ComicType.values()[resultSet.getInt("type")]);
            }
            comic.setComicTypeList(comicTypes);


        return comic;
        */
        return createComicFromResultSet(resultSet);

    }

    @Override
    public Comic findByName(String name) throws SQLException{

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM comics C JOIN comic_types CT ON C.id = CT.id_comic  where name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        /* Comic comic = new Comic();
        List<ComicType> comicTypes = new ArrayList<ComicType>();
        while (resultSet.next()) {
            comic.setId(resultSet.getInt("id"));
            comic.setName(resultSet.getString("name"));
            comic.setDescription(resultSet.getString("description"));
            comic.setStatus(Status.values()[resultSet.getInt("status")]);
            comicTypes.add(ComicType.values()[resultSet.getInt("type")]);
        }
        comic.setComicTypeList(comicTypes);
        */
        return createComicFromResultSet(resultSet);
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
    public boolean update(Comic comic) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE comics SET id = ?, name = ?, description = ?, status = ?");
        statement.setInt(1, comic.getId());
        statement.setString(2, comic.getName());
        statement.setString(3, comic.getDescription());
        statement.setInt(4, comic.getStatus().ordinal());
        for (ComicType ct : comic.getComicTypeList()) {

        }
        boolean executionResult = statement.execute();
        connection.close();
        return executionResult;
    }

    @Override
    public boolean delete(Comic comic) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE * FROM comics where id = ?");
        statement.setInt(1, comic.getId());
        boolean executionResult = statement.execute();
        connection.close();
        return executionResult;
    }

    private Comic createComicFromResultSet(ResultSet resultSet) throws SQLException{
        Comic comic = new Comic();
        List<ComicType> comicTypes = new ArrayList<ComicType>();
        while (resultSet.next()) {
            comic.setId(resultSet.getInt("id"));
            comic.setName(resultSet.getString("name"));
            comic.setDescription(resultSet.getString("description"));
            comic.setStatus(Status.values()[resultSet.getInt("status")]);
            comicTypes.add(ComicType.values()[resultSet.getInt("type")]);
        }
        comic.setComicTypeList(comicTypes);
        return comic;
    }
}
