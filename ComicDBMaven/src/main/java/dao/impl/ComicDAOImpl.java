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
public class ComicDAOImpl implements ComicDAO{

    @Override
    public Comic findById(int id) throws SQLException {
        Logger log = LogManager.getLogger("ComicDAOImpl");

        Connection connection = DataSource.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM comics C JOIN comic_types CT ON C.id = CT.id_comic  where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
        return createComicFromResultSet(resultSet);

    }

    @Override
    public Comic findByName(String name) throws SQLException{

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
            }
            else {
                List<ComicType> comicTypesList = comic.getComicTypeList();
                comicTypesList.add(ComicType.values()[resultSet.getInt("type")]);
                comic.setComicTypeList(comicTypesList);
            }
            resultList = new ArrayList<Comic>(resultMap.values());

        }
        return resultList;
    }

    @Override
    public boolean create(Comic comic) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        connection.setAutoCommit(false);
        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO comics VALUES name = ?, description = ?, status = ?");
        insertStatement.setString(1, comic.getName());
        insertStatement.setString(2, comic.getDescription());
        Logger log = LogManager.getLogger();
        log.info(comic.getStatus());
        insertStatement.setInt(3, comic.getStatus().ordinal());
        boolean insertExecutionResult = insertStatement.execute();

        PreparedStatement insertStatement2 = connection.prepareStatement("INSERT INTO comic_types VALUES id_comic = ?, type = ?");
        for(ComicType ct : comic.getComicTypeList()) {

            insertStatement2.setInt(1, comic.getId());
            insertStatement2.setInt(2, ct.ordinal());
            insertStatement2.addBatch();
        }
        boolean insert2ExecutionResult = insertStatement2.execute();
        connection.commit();
        connection.close();
        return insertExecutionResult && insert2ExecutionResult;
    }

    @Override
    public boolean update(Comic comic) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();
        connection.setAutoCommit(false);

        PreparedStatement updateStatement = connection.prepareStatement("UPDATE comics SET name = ?, description = ?, status = ? WHERE id = ?");
        updateStatement.setString(1, comic.getName());
        updateStatement.setString(2, comic.getDescription());
        updateStatement.setInt(3, comic.getStatus().ordinal());
        updateStatement.setInt(1, comic.getId());
        boolean updateExecutionResult = updateStatement.execute();

        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM comic_types WHERE id_comic = ?");
        deleteStatement.setInt(1, comic.getId());
        boolean deleteExecutionResult = deleteStatement.execute();

        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO comic_types VALUES id_comic = ?, type = ?");
        for (ComicType ct : comic.getComicTypeList()) {
            insertStatement.setInt(1, comic.getId());
            insertStatement.setInt(2, ct.ordinal());
            insertStatement.addBatch();
        }
        boolean insertExecutionResult = insertStatement.execute();
        connection.commit();
        connection.close();
        return updateExecutionResult && deleteExecutionResult && insertExecutionResult;
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
