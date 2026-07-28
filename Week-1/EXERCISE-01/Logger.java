/**
 * Logger class implementing the Singleton Design Pattern
 * Ensures only one instance of Logger exists throughout the application lifecycle
 * Uses eager initialization (thread-safe by default in Java)
 */
public class Logger {
    
    // Private static instance of the Logger class
    private static final Logger instance = new Logger();
    
    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created successfully!");
    }
    
    /**
     * Public static method to get the singleton instance of Logger
     * @return the single instance of Logger class
     */
    public static Logger getInstance() {
        return instance;
    }
    
    /**
     * Log an info level message
     * @param message the message to log
     */
    public void info(String message) {
        System.out.println("[INFO] " + getCurrentTimestamp() + " - " + message);
    }
    
    /**
     * Log a warning level message
     * @param message the message to log
     */
    public void warning(String message) {
        System.out.println("[WARNING] " + getCurrentTimestamp() + " - " + message);
    }
    
    /**
     * Log an error level message
     * @param message the message to log
     */
    public void error(String message) {
        System.out.println("[ERROR] " + getCurrentTimestamp() + " - " + message);
    }
    
    /**
     * Log a debug level message
     * @param message the message to log
     */
    public void debug(String message) {
        System.out.println("[DEBUG] " + getCurrentTimestamp() + " - " + message);
    }
    
    /**
     * Get current timestamp for logging
     * @return formatted timestamp string
     */
    private String getCurrentTimestamp() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
}
