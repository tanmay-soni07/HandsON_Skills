-- ============================================================
-- SCENARIO 1: Monthly Interest Processing
-- Process monthly interest for all savings accounts
-- Stored Procedure: ProcessMonthlyInterest
-- ============================================================

-- Procedure: ProcessMonthlyInterest
-- Calculates and updates balance of all savings accounts with 1% interest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest (
    p_interest_rate IN NUMBER DEFAULT 1.0,
    p_account_type IN VARCHAR2 DEFAULT 'Savings'
) IS
    v_accounts_processed NUMBER := 0;
    v_total_interest_paid NUMBER := 0;
    v_processing_date DATE := TRUNC(SYSDATE);
    
    CURSOR savings_accounts_cursor IS
        SELECT 
            AccountID,
            CustomerID,
            Balance,
            InterestRate
        FROM Accounts
        WHERE AccountType = p_account_type
        AND Balance > 0
        ORDER BY AccountID;
    
    account_rec savings_accounts_cursor%ROWTYPE;
    v_interest_amount NUMBER;
    v_new_balance NUMBER;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('SCENARIO 1: Monthly Interest Processing');
    DBMS_OUTPUT.PUT_LINE('Processing ' || p_account_type || ' accounts with ' || p_interest_rate || '% interest');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    OPEN savings_accounts_cursor;
    
    LOOP
        FETCH savings_accounts_cursor INTO account_rec;
        EXIT WHEN savings_accounts_cursor%NOTFOUND;
        
        -- Calculate interest amount
        v_interest_amount := (account_rec.Balance * account_rec.InterestRate) / 100;
        v_new_balance := account_rec.Balance + v_interest_amount;
        
        -- Update account balance
        UPDATE Accounts
        SET Balance = v_new_balance,
            LastInterestDate = v_processing_date
        WHERE AccountID = account_rec.AccountID;
        
        -- Record transaction
        INSERT INTO Transactions (
            TransactionID, 
            FromAccountID,
            ToAccountID,
            TransactionType,
            Amount,
            TransactionDate,
            Description,
            Status
        ) VALUES (
            seq_transaction_id.NEXTVAL,
            account_rec.AccountID,
            account_rec.AccountID,
            'Interest',
            v_interest_amount,
            v_processing_date,
            'Monthly interest credit at ' || account_rec.InterestRate || '%',
            'Completed'
        );
        
        v_accounts_processed := v_accounts_processed + 1;
        v_total_interest_paid := v_total_interest_paid + v_interest_amount;
        
        -- Display processing details
        DBMS_OUTPUT.PUT_LINE('✓ Account ID: ' || account_rec.AccountID);
        DBMS_OUTPUT.PUT_LINE('  Previous Balance: $' || TO_CHAR(account_rec.Balance, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('  Interest Applied: $' || TO_CHAR(v_interest_amount, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('  New Balance: $' || TO_CHAR(v_new_balance, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    
    CLOSE savings_accounts_cursor;
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('Processing Summary:');
    DBMS_OUTPUT.PUT_LINE('  Accounts Processed: ' || v_accounts_processed);
    DBMS_OUTPUT.PUT_LINE('  Total Interest Paid: $' || TO_CHAR(v_total_interest_paid, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('  Processing Date: ' || TO_CHAR(v_processing_date, 'DD-MON-YYYY'));
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in ProcessMonthlyInterest: ' || SQLERRM);
        ROLLBACK;
END ProcessMonthlyInterest;
/

-- Execute the procedure
PROMPT Executing ProcessMonthlyInterest...
PROMPT
BEGIN
    ProcessMonthlyInterest(1.0, 'Savings');
END;
/

-- Show results
PROMPT
PROMPT --- ACCOUNT BALANCES AFTER INTEREST PROCESSING ---
PROMPT
SELECT 
    a.AccountID,
    c.CustomerName,
    a.AccountType,
    a.Balance,
    a.InterestRate,
    TO_CHAR(a.LastInterestDate, 'DD-MON-YYYY') as LastInterestDate
FROM Accounts a
JOIN Customers c ON a.CustomerID = c.CustomerID
WHERE a.AccountType = 'Savings'
ORDER BY a.AccountID;

PROMPT
PROMPT --- INTEREST TRANSACTIONS RECORDED ---
PROMPT
SELECT 
    TransactionID,
    FromAccountID,
    TransactionType,
    Amount,
    TO_CHAR(TransactionDate, 'DD-MON-YYYY HH24:MI:SS') as TransactionDate,
    Description
FROM Transactions
WHERE TransactionType = 'Interest'
ORDER BY TransactionID;
