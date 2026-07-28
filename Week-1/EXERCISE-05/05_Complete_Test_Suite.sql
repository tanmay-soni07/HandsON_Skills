-- ============================================================
-- EXERCISE 1: Control Structures - Complete Test Suite
-- Testing all three banking scenarios with detailed output
-- ============================================================

-- Script to run all scenarios in sequence
SET ECHO ON;
SET FEEDBACK ON;
SET PAGESIZE 100;
SET LINESIZE 120;

PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT EXERCISE 1: PL/SQL CONTROL STRUCTURES
PROMPT Banking System Scenarios
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

-- Enable output
SET SERVEROUTPUT ON SIZE 20000;

PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT RUNNING ALL SCENARIOS
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

-- Show current data before scenarios
PROMPT 
PROMPT --- INITIAL CUSTOMER DATA ---
PROMPT
SELECT CustomerID, CustomerName, Age, Balance, IsVIP 
FROM Customers
ORDER BY CustomerID;

PROMPT
PROMPT --- INITIAL LOAN DATA ---
PROMPT
SELECT LoanID, CustomerID, LoanAmount, InterestRate, 
       TO_CHAR(DueDate, 'DD-MON-YYYY') as DueDate
FROM Loans
ORDER BY LoanID;

-- ============================================================
PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT SCENARIO 1: SENIOR CITIZEN DISCOUNT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

-- Reset database for fresh scenario test
BEGIN
    UPDATE Customers SET IsVIP = 'N';
    UPDATE Loans SET InterestRate = 
        CASE LoanID
            WHEN 101 THEN 5.5
            WHEN 102 THEN 6.0
            WHEN 103 THEN 5.8
            WHEN 104 THEN 6.5
            WHEN 105 THEN 5.2
            WHEN 106 THEN 5.9
            WHEN 107 THEN 6.0
            WHEN 108 THEN 5.7
        END;
    COMMIT;
END;
/

-- Execute Scenario 1
EXECUTE ApplySeniorDiscountWithLoop;

-- Show results after Scenario 1
PROMPT
PROMPT --- LOAN INTEREST RATES AFTER SENIOR DISCOUNT ---
PROMPT
SELECT LoanID, CustomerID, InterestRate 
FROM Loans
ORDER BY LoanID;

-- ============================================================
PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT SCENARIO 2: VIP CUSTOMER PROMOTION
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

-- Reset IsVIP status
BEGIN
    UPDATE Customers SET IsVIP = 'N';
    COMMIT;
END;
/

-- Execute Scenario 2
EXECUTE PromoteVIPCustomersWithIfElse;

-- Show results after Scenario 2
PROMPT
PROMPT --- CUSTOMER VIP STATUS AFTER PROMOTION ---
PROMPT
SELECT CustomerID, CustomerName, Balance, IsVIP
FROM Customers
ORDER BY Balance DESC;

-- ============================================================
PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT SCENARIO 3: LOAN DUE REMINDERS
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

-- Execute Scenario 3
EXECUTE SendLoanDueReminders;

-- Show summary of due loans
PROMPT
PROMPT --- LOANS DUE IN NEXT 30 DAYS ---
PROMPT
SELECT 
    LoanID, 
    CustomerID, 
    LoanAmount,
    TO_CHAR(DueDate, 'DD-MON-YYYY') as DueDate,
    TRUNC(DueDate - SYSDATE) as DaysUntilDue
FROM Loans
WHERE DueDate BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30
ORDER BY DueDate;

-- ============================================================
PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT CONTROL STRUCTURES USED IN THIS EXERCISE
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT

-- Display control structures documentation
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('CONTROL STRUCTURES IN PL/SQL');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('1. IF-THEN-ELSE STATEMENT');
    DBMS_OUTPUT.PUT_LINE('   ├─ Used in: Scenario 1 & 2');
    DBMS_OUTPUT.PUT_LINE('   ├─ Syntax: IF condition THEN ... ELSE ... END IF;');
    DBMS_OUTPUT.PUT_LINE('   └─ Purpose: Make decisions based on conditions');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('2. LOOP STRUCTURES');
    DBMS_OUTPUT.PUT_LINE('   ├─ LOOP ... END LOOP (Simple Loop)');
    DBMS_OUTPUT.PUT_LINE('   │  └─ Used in: Scenario 3');
    DBMS_OUTPUT.PUT_LINE('   ├─ FOR loop (Cursor-based)');
    DBMS_OUTPUT.PUT_LINE('   │  └─ Used in: Scenario 1 & 2');
    DBMS_OUTPUT.PUT_LINE('   └─ WHILE loop (Conditional)');
    DBMS_OUTPUT.PUT_LINE('      └─ Used in: Scenario 3');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('3. CASE STATEMENT');
    DBMS_OUTPUT.PUT_LINE('   ├─ Used in: Scenario 2 (Alternative)');
    DBMS_OUTPUT.PUT_LINE('   ├─ Syntax: CASE WHEN ... THEN ... ELSE ... END CASE;');
    DBMS_OUTPUT.PUT_LINE('   └─ Purpose: Multiple condition handling (cleaner than nested IF)');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('4. CURSOR OPERATIONS');
    DBMS_OUTPUT.PUT_LINE('   ├─ OPEN: Opens cursor to fetch data');
    DBMS_OUTPUT.PUT_LINE('   ├─ FETCH: Retrieves one row at a time');
    DBMS_OUTPUT.PUT_LINE('   ├─ %FOUND: Returns TRUE if FETCH retrieved a row');
    DBMS_OUTPUT.PUT_LINE('   ├─ %NOTFOUND: Returns TRUE if FETCH did not find a row');
    DBMS_OUTPUT.PUT_LINE('   └─ CLOSE: Closes cursor after processing');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('SCENARIO IMPLEMENTATION SUMMARY:');
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Scenario 1 - Senior Discount:');
    DBMS_OUTPUT.PUT_LINE('  ✓ Uses: FOR loop with cursor, IF condition');
    DBMS_OUTPUT.PUT_LINE('  ✓ Action: Loops through customers, checks age > 60');
    DBMS_OUTPUT.PUT_LINE('  ✓ Updates: Applies 1% discount to interest rates');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('Scenario 2 - VIP Promotion:');
    DBMS_OUTPUT.PUT_LINE('  ✓ Uses: FOR loop with cursor, IF-ELSE condition');
    DBMS_OUTPUT.PUT_LINE('  ✓ Action: Loops through customers, checks balance > $10,000');
    DBMS_OUTPUT.PUT_LINE('  ✓ Updates: Sets IsVIP flag to Y or N');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('Scenario 3 - Loan Reminders:');
    DBMS_OUTPUT.PUT_LINE('  ✓ Uses: WHILE loop with cursor, IF condition for priority');
    DBMS_OUTPUT.PUT_LINE('  ✓ Action: Loops through loans due in next 30 days');
    DBMS_OUTPUT.PUT_LINE('  ✓ Output: Generates reminder messages with priority levels');
    DBMS_OUTPUT.PUT_LINE('');
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
END;
/

PROMPT
PROMPT ════════════════════════════════════════════════════════════════════════════════
PROMPT EXERCISE 1 COMPLETE
PROMPT All control structure scenarios have been executed successfully
PROMPT ════════════════════════════════════════════════════════════════════════════════
