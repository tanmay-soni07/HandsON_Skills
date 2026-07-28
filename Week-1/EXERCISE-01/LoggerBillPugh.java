/**
 * Logger class implementing the Singleton Design Pattern
 * using Bill Pugh's approach with Static Inner Class Holder
 * Best balance between thread-safety, performance, and simplicity
 */
public class LoggerBillPugh {
    
    // Private constructor to prevent instantiation from outside
    private LoggerBillPugh() {
        System.out.println("LoggerBillPugh instance created successfully!");
    }
    
    /**
     * Static inner class responsible for holding the singleton instance
     * This class is loaded only when getInstance() is called (lazy initialization)
     */
    private static class LoggerHolder {
        // Static variable stores the instance
        private static final LoggerBillPugh INSTANCE = new LoggerBillPugh();
    }
    
    /**
     * Public static method to get the singleton instance
     * Thread-safe due to the class loading mechanism in Java
     * @return the single instance of LoggerBillPugh class
     */
    public static LoggerBillPugh getInstance() {
        return LoggerHolder.INSTANCE;
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
