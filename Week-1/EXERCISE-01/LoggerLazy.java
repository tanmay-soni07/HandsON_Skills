/**
 * Logger class implementing the Singleton Design Pattern
 * with Lazy Initialization and Double-Checked Locking
 * Ensures only one instance of Logger exists and is created on first use
 */
public class LoggerLazy {
    
    // Private static volatile instance (volatile ensures visibility across threads)
    private static volatile LoggerLazy instance = null;
    
    // Private constructor to prevent instantiation from outside
    private LoggerLazy() {
        System.out.println("LoggerLazy instance created successfully!");
    }
    
    /**
     * Public static method to get the singleton instance with lazy initialization
     * Uses double-checked locking for thread-safety and performance
     * @return the single instance of LoggerLazy class
     */
    public static LoggerLazy getInstance() {
        if (instance == null) {
            synchronized (LoggerLazy.class) {
                if (instance == null) {
                    instance = new LoggerLazy();
                }
            }
        }
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
