package utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by akravchenko on 05.02.19.
 */
public class PropertyLoader {
    public static String loadProperty(String propertyName) throws IOException {
        Properties props = new Properties();
        props.load(PropertyLoader.class.getResourceAsStream("/application.properties"));
        props.entrySet();
        String propertyValue = props.getProperty(propertyName);
        return propertyValue;
    }
}
