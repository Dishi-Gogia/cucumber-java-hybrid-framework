package utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Utility class for reading configuration values from
 * config.properties file.
 *
 * Also supports overriding properties using JVM parameters.
 *
 * Example:
 * mvn test -Dbrowser=edge
 */
public class ConfigReader {

    private static Properties properties;

    static {

        try {

            FileInputStream fis =  new FileInputStream( "src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties",e);
        }
    }

    /**
     * Returns property value from system property
     * if provided, otherwise from config.properties.
     *
     * @param key Property name
     * @return Property value
     */
    public static String getProperty(String key) {
        String systemValue = System.getProperty(key);
        if (systemValue != null  && !systemValue.trim().isEmpty()) {
            return systemValue;
        }

        return properties.getProperty(key);
    }
}