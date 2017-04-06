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
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Boo on 12.03.2017.
 */
public class ComicDAOImpl implements ComicDAO {

    Logger log = LogManager.getLogger("ComicDAOImpl");

    @Override
    public Comic findById(int id) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM comics C JOIN comic_types CT ON C.id = CT.id_comic  where id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        return createComicFromResultSet(resultSet);
    }

    @Override
    public Comic findByName(String name) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM comics C JOIN comic_types CT ON C.id = CT.id_comic  where name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        return createComicFromResultSet(resultSet);
    }

    @Override
    public List<Comic> findAllByStatus(Status status) throws SQLException {
        Map<Integer, Comic> resultMap = new TreeMap<Integer, Comic>();
        List<Comic> resultList = new ArrayList<Comic>();

        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM comics C JOIN comic_types CT ON C.id = CT.id_comic WHERE status = ?");
        selectStatement.setInt(1, status.ordinal());
        ResultSet resultSet = selectStatement.executeQuery();
        while (resultSet.next()) {
            Integer comicId = resultSet.getInt("id");
            Comic comic = resultMap.get(comicId);
            if (comic == null) {
                comic = new Comic();
                comic.setName(resultSet.getString("name"));
                comic.setDescription(resultSet.getString("description"));
                resultMap.put(comicId, comic);
                List<ComicType> comicTypesList = new ArrayList<ComicType>();
                comicTypesList.add(ComicType.values()[resultSet.getInt("type")]);
                comic.setComicTypeList(comicTypesList);
                resultMap.put(comicId, comic);
            } else {
                List<ComicType> comicTypesList = comic.getComicTypeList();
                comicTypesList.add(ComicType.values()[resultSet.getInt("type")]);
                comic.setComicTypeList(comicTypesList);
            }
            resultList = new ArrayList<Comic>(resultMap.values());

        }
        return resultList;
    }

    @Override
    public void create(Comic comic) throws SQLException {

        Integer idOfInsertedComic = 0;
        Connection connection = DataSource.getInstance().getConnection();
        connection.setAutoCommit(false);
        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO comics(name, description, status) VALUES (?,?,?)");
        insertStatement.setString(1, comic.getName());
        insertStatement.setString(2, comic.getDescription());
        insertStatement.setInt(3, comic.getStatus().ordinal());
        boolean insertExecutionResult = insertStatement.execute();
        log.info("Insert statement is successful: " + insertExecutionResult);
        PreparedStatement getInsertedIdStatement = connection.prepareStatement("SELECT id FROM comics WHERE name = ? AND description = ? AND status = ?");
        getInsertedIdStatement.setString(1, comic.getName());
        getInsertedIdStatement.setString(2, comic.getDescription());
        getInsertedIdStatement.setInt(3, comic.getStatus().ordinal());
        ResultSet resultSet = getInsertedIdStatement.executeQuery();
        while (resultSet.next()) {
            idOfInsertedComic = resultSet.getInt("id");
        }
        PreparedStatement insertStatement2 = connection.prepareStatement("INSERT INTO comic_types VALUES (?,?)");
        for (ComicType ct : comic.getComicTypeList()) {

            insertStatement2.setInt(1, idOfInsertedComic);
            insertStatement2.setInt(2, ct.ordinal());
            System.out.println(insertStatement2);
            insertStatement2.execute();
        }
        connection.commit();
        connection.close();


    }

    @Override
    public void update(Comic comic) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        connection.setAutoCommit(false);
        Integer comicId = findByName(comic.getName()).getId();
        PreparedStatement updateStatement = connection.prepareStatement("UPDATE comics SET name = ?, description = ?, status = ? WHERE id = ?");
        updateStatement.setString(1, comic.getName());
        updateStatement.setString(2, comic.getDescription());
        updateStatement.setInt(3, comic.getStatus().ordinal());
        updateStatement.setInt(4, comicId);
        updateStatement.execute();
        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM comic_types WHERE id_comic = ?");
        deleteStatement.setInt(1, comicId);
        deleteStatement.execute();
        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO comic_types VALUES (?,?)");
        for (ComicType ct : comic.getComicTypeList()) {
            insertStatement.setInt(1, comicId);
            insertStatement.setInt(2, ct.ordinal());
            insertStatement.execute();
        }
        connection.commit();
        connection.close();
    }

    @Override
    public void delete(Comic comic) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        Integer comicId = findByName(comic.getName()).getId();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM comics where id = ?");
        statement.setInt(1, comicId);
        statement.execute();
        connection.close();
    }

    private Comic createComicFromResultSet(ResultSet resultSet) throws SQLException {
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
