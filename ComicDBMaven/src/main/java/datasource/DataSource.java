package datasource;

import holder.PropertyHolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Boo on 12.03.2017.
 */
public class DataSource {
    private DataSource()
    {
        PropertyHolder ph = PropertyHolder.getInstance();
        driverName = ph.getProperty("db.driverName");
        url = ph.getProperty("db.host");
        user = ph.getProperty("db.login");
        password = ph.getProperty("db.password");
    }
    private static DataSource instance;
    /*поля data source*/
    private static String driverName;
    private static String url;
    private static String user;
    private static String password ;

    public static DataSource getInstance() {
        if(instance == null)
        {
            instance = new DataSource();
        }
        return instance;
    }
    /* методы data source */
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException e) {

        }
        catch (SQLException e){

        }

        return conn;
    }
}
