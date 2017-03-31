package dao.impl;

import dao.api.ComicDAO;
import entity.Comic;
import entity.ComicType;
import entity.EnumComicType;
import entity.Status;

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
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM comics C where id = ? JOIN comicTypes  CT ON C.id = CT.comic_id");
        List<EnumComicType> comicTypes = new ArrayList<EnumComicType>();
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Comic comic = new Comic();
            comic.setId(resultSet.getInt("id"));
            comic.setName(resultSet.getString("name"));
            comic.setDescription(resultSet.getString("description"));
            comic.setStatus(Status.values()[resultSet.getInt("status")]);
            while (resultSet.next()) {
                comicTypes.add(EnumComicType.values()[resultSet.getInt("name of id column from joined table")]); //change accordingly to name in DB!
            }
            comic.setComicTypeList(comicTypes);


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
