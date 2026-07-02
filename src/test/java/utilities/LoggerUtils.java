package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for creating Log4j logger instances.
 * Provides centralized logger creation across the framework.
 */
public class LoggerUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private LoggerUtils() {
    }

    /**
     * Returns logger instance for the specified class.
     * @param clazz Class for which logger is required
     * @return Logger instance
     */
    public static Logger getLogger(Class<?> clazz) {

        return LogManager.getLogger(clazz);
    }
}