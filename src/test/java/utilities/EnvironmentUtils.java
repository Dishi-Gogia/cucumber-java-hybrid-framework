package utilities;

/**
 * Utility class for retrieving environment-specific URLs.
 * Supports execution against QA, UAT, and PROD environments.
 */
public class EnvironmentUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private EnvironmentUtils() {
    }

    /**
     * Returns the application URL based on the environment
     * configured in config.properties.
     *
     * Supported environments:
     * qa
     * uat
     * prod
     *
     * @return Environment-specific URL
     * @throws RuntimeException if environment is invalid
     */
    public static String getEnvironmentUrl() {

        String environment =
                ConfigReader.getProperty("environment");

        switch (environment.toLowerCase()) {

        case "qa":
            return ConfigReader.getProperty("qaUrl");

        case "uat":
            return ConfigReader.getProperty("uatUrl");

        case "prod":
            return ConfigReader.getProperty("prodUrl");

        default:

            throw new RuntimeException(
                    "Invalid Environment: "
                    + environment);
        }
    }
}