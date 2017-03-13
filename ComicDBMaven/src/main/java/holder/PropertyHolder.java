package holder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Boo on 12.03.2017.
 */
public class PropertyHolder {
    private PropertyHolder() {

        try {
            fis = new FileInputStream("src\\main\\resources\\app.properties");
            properties.load(fis);
            log.info("Reading properties...");
        }
        catch (IOException e) {
            log.warn(e);
        }
        log.info("Success!");
    }

    private static PropertyHolder instance;
    private FileInputStream fis;
    private Properties properties = new Properties();
    /* Logger */
    Logger log = LogManager.getLogger(this.getClass().getName());
    public static PropertyHolder getInstance() {
        if(instance == null) {
            instance = new PropertyHolder();
        }
        return instance;
    }
    public String getProperty(Object key) {


        return (String)properties.get(key);
    }
}
