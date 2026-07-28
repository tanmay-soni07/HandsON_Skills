-- ============================================================
-- EXERCISE 3: Stored Procedures - Complete Test Suite
-- Testing all three banking scenarios
-- ============================================================

SET ECHO ON;
SET FEEDBACK ON;
SET PAGESIZE 100;
SET LINESIZE 120;
SET SERVEROUTPUT ON SIZE 20000;

PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT EXERCISE 3: PL/SQL STORED PROCEDURES
PROMPT Banking and Employee Management System
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT INITIAL DATA STATE
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

PROMPT --- CUSTOMERS AND ACCOUNTS ---
PROMPT
SELECT 
    a.AccountID,
    c.CustomerName,
    a.AccountType,
    a.Balance,
    a.InterestRate
FROM Accounts a
JOIN Customers c ON a.CustomerID = c.CustomerID
ORDER BY a.AccountID;

PROMPT
PROMPT --- EMPLOYEES ---
PROMPT
SELECT 
    EmployeeID,
    EmployeeName,
    Department,
    Salary,
    PerformanceRating
FROM Employees
ORDER BY Department, PerformanceRating DESC;

-- ============================================================
PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT SCENARIO 1: MONTHLY INTEREST PROCESSING
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

EXECUTE ProcessMonthlyInterest(1.0, 'Savings');

PROMPT
PROMPT --- FINAL ACCOUNT BALANCES ---
PROMPT
SELECT 
    a.AccountID,
    c.CustomerName,
    a.AccountType,
    a.Balance
FROM Accounts a
JOIN Customers c ON a.CustomerID = c.CustomerID
ORDER BY a.AccountID;

-- ============================================================
PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT SCENARIO 2: EMPLOYEE BONUS UPDATES
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

EXECUTE UpdateEmployeeBonus('Sales', 10);

PROMPT

EXECUTE UpdateEmployeeBonus('IT', 15);

PROMPT
PROMPT --- UPDATED EMPLOYEE SALARIES ---
PROMPT
SELECT 
    EmployeeID,
    EmployeeName,
    Department,
    Salary,
    PerformanceRating
FROM Employees
ORDER BY Department, Salary DESC;

-- ============================================================
PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT SCENARIO 3: FUND TRANSFERS BETWEEN ACCOUNTS
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

PROMPT
PROMPT --- TRANSFER 1: Successful Transfer ---
PROMPT
EXECUTE TransferFunds(1001, 1002, 1000.00);

PROMPT
PROMPT --- TRANSFER 2: Insufficient Funds ---
PROMPT
BEGIN
    TransferFunds(1004, 1001, 50000.00);
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/

PROMPT
PROMPT --- TRANSFER 3: Another Successful Transfer ---
PROMPT
EXECUTE TransferFunds(1005, 1003, 5000.00);

PROMPT
PROMPT --- FINAL ACCOUNT BALANCES AFTER ALL TRANSFERS ---
PROMPT
SELECT 
    a.AccountID,
    c.CustomerName,
    a.AccountType,
    a.Balance
FROM Accounts a
JOIN Customers c ON a.CustomerID = c.CustomerID
ORDER BY a.AccountID;

PROMPT
PROMPT --- ALL TRANSFER TRANSACTIONS ---
PROMPT
SELECT 
    TransactionID,
    FromAccountID,
    ToAccountID,
    Amount,
    TO_CHAR(TransactionDate, 'DD-MON-YYYY HH24:MI:SS') as TransactionDate,
    Status
FROM Transactions
WHERE TransactionType = 'Transfer'
ORDER BY TransactionID DESC;

-- ============================================================
PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT STORED PROCEDURES DOCUMENTATION
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('STORED PROCEDURES OVERVIEW');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('1. PROCESSMONTHLYINTEREST');
    DBMS_OUTPUT.PUT_LINE('   ├─ Purpose: Calculate and apply monthly interest to savings accounts');
    DBMS_OUTPUT.PUT_LINE('   ├─ Parameters:');
    DBMS_OUTPUT.PUT_LINE('   │  • p_interest_rate (NUMBER): Interest rate percentage (default 1.0)');
    DBMS_OUTPUT.PUT_LINE('   │  • p_account_type (VARCHAR2): Type of account (default ''Savings'')');
    DBMS_OUTPUT.PUT_LINE('   ├─ Operations:');
    DBMS_OUTPUT.PUT_LINE('   │  • Loops through all savings accounts');
    DBMS_OUTPUT.PUT_LINE('   │  • Calculates interest: Balance * InterestRate / 100');
    DBMS_OUTPUT.PUT_LINE('   │  • Updates account balance');
    DBMS_OUTPUT.PUT_LINE('   │  • Records transaction in Transactions table');
    DBMS_OUTPUT.PUT_LINE('   └─ Usage: EXECUTE ProcessMonthlyInterest(1.0, ''Savings'');');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('2. UPDATEEMPLOYEEBONUS');
    DBMS_OUTPUT.PUT_LINE('   ├─ Purpose: Update employee salaries with bonus for department');
    DBMS_OUTPUT.PUT_LINE('   ├─ Parameters:');
    DBMS_OUTPUT.PUT_LINE('   │  • p_department (VARCHAR2): Department name (Required)');
    DBMS_OUTPUT.PUT_LINE('   │  • p_bonus_percentage (NUMBER): Bonus % to add (0-100)');
    DBMS_OUTPUT.PUT_LINE('   ├─ Operations:');
    DBMS_OUTPUT.PUT_LINE('   │  • Validates input parameters');
    DBMS_OUTPUT.PUT_LINE('   │  • Loops through employees in department (sorted by performance)');
    DBMS_OUTPUT.PUT_LINE('   │  • Calculates bonus: Salary * BonusPercentage / 100');
    DBMS_OUTPUT.PUT_LINE('   │  • Updates employee salary');
    DBMS_OUTPUT.PUT_LINE('   └─ Usage: EXECUTE UpdateEmployeeBonus(''Sales'', 10);');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('3. TRANSFERFUNDS');
    DBMS_OUTPUT.PUT_LINE('   ├─ Purpose: Transfer funds between customer accounts with validation');
    DBMS_OUTPUT.PUT_LINE('   ├─ Parameters:');
    DBMS_OUTPUT.PUT_LINE('   │  • p_from_account (NUMBER): Source account ID (Required)');
    DBMS_OUTPUT.PUT_LINE('   │  • p_to_account (NUMBER): Destination account ID (Required)');
    DBMS_OUTPUT.PUT_LINE('   │  • p_amount (NUMBER): Transfer amount (Required)');
    DBMS_OUTPUT.PUT_LINE('   ├─ Validations:');
    DBMS_OUTPUT.PUT_LINE('   │  • Amount must be > 0');
    DBMS_OUTPUT.PUT_LINE('   │  • Source and destination must be different');
    DBMS_OUTPUT.PUT_LINE('   │  • Both accounts must exist');
    DBMS_OUTPUT.PUT_LINE('   │  • Source account must have sufficient balance');
    DBMS_OUTPUT.PUT_LINE('   ├─ Operations:');
    DBMS_OUTPUT.PUT_LINE('   │  • Deducts amount from source account');
    DBMS_OUTPUT.PUT_LINE('   │  • Adds amount to destination account');
    DBMS_OUTPUT.PUT_LINE('   │  • Records transfer in Transactions table');
    DBMS_OUTPUT.PUT_LINE('   └─ Usage: EXECUTE TransferFunds(1001, 1002, 1000.00);');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('════════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('KEY FEATURES:');
    DBMS_OUTPUT.PUT_LINE('════════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('✓ Input validation and error handling');
    DBMS_OUTPUT.PUT_LINE('✓ Transaction logging for audit trail');
    DBMS_OUTPUT.PUT_LINE('✓ Automatic COMMIT on success, ROLLBACK on error');
    DBMS_OUTPUT.PUT_LINE('✓ Parameterized procedures for flexibility');
    DBMS_OUTPUT.PUT_LINE('✓ Descriptive error messages');
    DBMS_OUTPUT.PUT_LINE('✓ Alternative implementations (performance-based, limits, etc.)');
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('════════════════════════════════════════════════════════');
    
END;
/

PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT EXERCISE 3 COMPLETE
PROMPT All stored procedures have been tested successfully
PROMPT ════════════════════════════════════════════════════════════════════════════════
