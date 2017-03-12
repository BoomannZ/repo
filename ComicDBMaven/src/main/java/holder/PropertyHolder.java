package holder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Boo on 12.03.2017.
 */
public class PropertyHolder {
    private PropertyHolder() {

        try {
            fis = new FileInputStream("C:\\Git\\repo\\ComicDBMaven\\src\\main\\resources\\app.properties");
            properties.load(fis);
        }
        catch (IOException e) {

        }

    }

    private static PropertyHolder instance;
    private FileInputStream fis;
    private Properties properties = new Properties();
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
