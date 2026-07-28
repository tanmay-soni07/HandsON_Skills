/**
 * Test class to verify the Singleton Pattern implementation
 * Tests that only one instance of Logger is created and used across the application
 */
public class SingletonPatternTest {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Testing Eager Singleton Pattern (Logger)");
        System.out.println("========================================\n");
        testEagerSingleton();
        
        System.out.println("\n========================================");
        System.out.println("Testing Lazy Singleton Pattern (LoggerLazy)");
        System.out.println("========================================\n");
        testLazySingleton();
        
        System.out.println("\n========================================");
        System.out.println("Testing Bill Pugh Singleton Pattern (LoggerBillPugh)");
        System.out.println("========================================\n");
        testBillPughSingleton();
        
        System.out.println("\n========================================");
        System.out.println("Testing Thread Safety with Logger");
        System.out.println("========================================\n");
        testThreadSafety();
    }
    
    /**
     * Test eager singleton implementation
     */
    public static void testEagerSingleton() {
        System.out.println("Test 1: Getting first instance of Logger");
        Logger logger1 = Logger.getInstance();
        logger1.info("First logger instance obtained");
        
        System.out.println("\nTest 2: Getting second instance of Logger");
        Logger logger2 = Logger.getInstance();
        logger2.warning("Second logger instance obtained");
        
        System.out.println("\nTest 3: Verifying both instances are the same");
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger1.equals(logger2): " + (logger1.equals(logger2)));
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        
        System.out.println("\nTest 4: Logging different messages");
        logger1.debug("This is a debug message from logger1");
        logger2.error("This is an error message from logger2");
    }
    
    /**
     * Test lazy singleton implementation
     */
    public static void testLazySingleton() {
        System.out.println("Test 1: Getting first instance of LoggerLazy");
        LoggerLazy loggerLazy1 = LoggerLazy.getInstance();
        loggerLazy1.info("First LoggerLazy instance obtained");
        
        System.out.println("\nTest 2: Getting second instance of LoggerLazy");
        LoggerLazy loggerLazy2 = LoggerLazy.getInstance();
        loggerLazy2.warning("Second LoggerLazy instance obtained");
        
        System.out.println("\nTest 3: Verifying both instances are the same");
        System.out.println("loggerLazy1 == loggerLazy2: " + (loggerLazy1 == loggerLazy2));
        System.out.println("loggerLazy1 hashCode: " + loggerLazy1.hashCode());
        System.out.println("loggerLazy2 hashCode: " + loggerLazy2.hashCode());
        
        System.out.println("\nTest 4: Logging messages");
        loggerLazy1.debug("Debug message from loggerLazy1");
        loggerLazy2.error("Error message from loggerLazy2");
    }
    
    /**
     * Test Bill Pugh singleton implementation
     */
    public static void testBillPughSingleton() {
        System.out.println("Test 1: Getting first instance of LoggerBillPugh");
        LoggerBillPugh loggerBP1 = LoggerBillPugh.getInstance();
        loggerBP1.info("First LoggerBillPugh instance obtained");
        
        System.out.println("\nTest 2: Getting second instance of LoggerBillPugh");
        LoggerBillPugh loggerBP2 = LoggerBillPugh.getInstance();
        loggerBP2.warning("Second LoggerBillPugh instance obtained");
        
        System.out.println("\nTest 3: Verifying both instances are the same");
        System.out.println("loggerBP1 == loggerBP2: " + (loggerBP1 == loggerBP2));
        System.out.println("loggerBP1 hashCode: " + loggerBP1.hashCode());
        System.out.println("loggerBP2 hashCode: " + loggerBP2.hashCode());
        
        System.out.println("\nTest 4: Logging messages");
        loggerBP1.debug("Debug message from loggerBP1");
        loggerBP2.error("Error message from loggerBP2");
    }
    
    /**
     * Test thread safety of the singleton implementations
     */
    public static void testThreadSafety() {
        System.out.println("Creating multiple threads to verify thread-safety...\n");
        
        Thread[] threads = new Thread[5];
        
        for (int i = 0; i < 5; i++) {
            final int threadNum = i + 1;
            threads[i] = new Thread(() -> {
                Logger logger = Logger.getInstance();
                logger.info("Message from Thread-" + threadNum + 
                           " (HashCode: " + logger.hashCode() + ")");
            });
        }
        
        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\nAll threads completed. If all hashcodes are the same,");
        System.out.println("the Singleton pattern is thread-safe!");
    }
}
