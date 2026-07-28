/**
 * Practical application example demonstrating the Logger Singleton
 * Simulates a banking application with multiple operations
 */
public class BankingApplication {
    
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("Banking Application - Logger Singleton Demo");
        System.out.println("====================================================\n");
        
        // Create banking service instances
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
        ReportService reportService = new ReportService();
        
        // Simulate banking operations
        System.out.println("--- Starting Banking Operations ---\n");
        
        accountService.createAccount("ACC001", "John Doe");
        System.out.println();
        
        accountService.deposit("ACC001", 5000);
        System.out.println();
        
        transactionService.transfer("ACC001", "ACC002", 1000);
        System.out.println();
        
        accountService.withdraw("ACC001", 500);
        System.out.println();
        
        reportService.generateDailyReport();
        System.out.println();
        
        System.out.println("--- Banking Operations Completed ---");
    }
}

/**
 * Account Service class that uses the Logger singleton
 */
class AccountService {
    private Logger logger = Logger.getInstance();
    
    public void createAccount(String accountId, String accountHolder) {
        logger.info("Creating account: " + accountId + " for " + accountHolder);
        // Simulate account creation
        logger.info("Account created successfully");
    }
    
    public void deposit(String accountId, double amount) {
        logger.info("Depositing $" + amount + " to account: " + accountId);
        // Simulate deposit operation
        logger.info("Deposit completed. New balance: $" + amount);
    }
    
    public void withdraw(String accountId, double amount) {
        logger.info("Withdrawing $" + amount + " from account: " + accountId);
        // Simulate withdrawal
        logger.warning("Withdrawal initiated. Please wait...");
        logger.info("Withdrawal completed. Remaining balance: $" + (5000 - amount));
    }
}

/**
 * Transaction Service class that uses the Logger singleton
 */
class TransactionService {
    private Logger logger = Logger.getInstance();
    
    public void transfer(String fromAccount, String toAccount, double amount) {
        logger.info("Initiating transfer of $" + amount + 
                   " from " + fromAccount + " to " + toAccount);
        
        // Simulate transfer process
        logger.debug("Validating accounts...");
        logger.debug("Checking funds availability...");
        logger.info("Transfer completed successfully");
    }
}

/**
 * Report Service class that uses the Logger singleton
 */
class ReportService {
    private Logger logger = Logger.getInstance();
    
    public void generateDailyReport() {
        logger.info("Generating daily banking report...");
        logger.debug("Collecting transaction data...");
        logger.debug("Calculating account balances...");
        logger.info("Daily report generated and saved");
    }
}
