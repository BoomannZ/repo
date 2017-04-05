package datasource;

import holder.PropertyHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    /* Логгер*/
    Logger log = LogManager.getLogger(this.getClass().getName());

    public static DataSource getInstance() {
        if(instance == null)
        {
            instance = new DataSource();
        }
        return instance;
    }
    /* методы data source */
    public Connection getConnection() throws NullPointerException {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection("jdbc:mysql://"+ url +"?" +
                    "user="+ user + "&password=" + password);
            log.info("Establishing connection...");
        }
        catch (ClassNotFoundException e) {
            log.warn(e);
        }
        catch (SQLException e){
            log.warn(e);
        }
        log.info("Connection successful.");
        return conn;
    }
}
