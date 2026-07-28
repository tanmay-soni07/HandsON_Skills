-- ============================================================
-- SCENARIO 3: Fund Transfer Between Accounts
-- Transfer funds from one account to another with validation
-- Stored Procedure: TransferFunds
-- ============================================================

-- Procedure: TransferFunds
-- Transfers amount from source to destination account with validation
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_from_balance NUMBER;
    v_to_balance NUMBER;
    v_from_exists NUMBER;
    v_to_exists NUMBER;
    v_new_from_balance NUMBER;
    v_new_to_balance NUMBER;
    v_from_customer_name VARCHAR2(100);
    v_to_customer_name VARCHAR2(100);
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('SCENARIO 3: Fund Transfer');
    DBMS_OUTPUT.PUT_LINE('From Account: ' || p_from_account);
    DBMS_OUTPUT.PUT_LINE('To Account: ' || p_to_account);
    DBMS_OUTPUT.PUT_LINE('Amount: $' || TO_CHAR(p_amount, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    -- Validation: Check if amount is positive
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Transfer amount must be greater than 0');
    END IF;
    
    -- Validation: Check if accounts are different
    IF p_from_account = p_to_account THEN
        RAISE_APPLICATION_ERROR(-20004, 'Source and destination accounts must be different');
    END IF;
    
    -- Validation: Check if source account exists and get balance
    BEGIN
        SELECT Balance, CustomerID INTO v_from_balance, v_from_customer_name
        FROM Accounts
        WHERE AccountID = p_from_account
        FOR UPDATE;
        v_from_exists := 1;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            v_from_exists := 0;
    END;
    
    IF v_from_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Source account does not exist');
    END IF;
    
    -- Validation: Check if destination account exists and get balance
    BEGIN
        SELECT Balance INTO v_to_balance
        FROM Accounts
        WHERE AccountID = p_to_account
        FOR UPDATE;
        v_to_exists := 1;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            v_to_exists := 0;
    END;
    
    IF v_to_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20006, 'Destination account does not exist');
    END IF;
    
    -- Validation: Check if source account has sufficient balance
    IF v_from_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('✗ TRANSFER FAILED - Insufficient Funds');
        DBMS_OUTPUT.PUT_LINE('  Current Balance: $' || TO_CHAR(v_from_balance, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('  Transfer Amount: $' || TO_CHAR(p_amount, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('  Shortfall: $' || TO_CHAR(p_amount - v_from_balance, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('');
        RAISE_APPLICATION_ERROR(-20007, 'Insufficient balance in source account');
    END IF;
    
    -- Calculate new balances
    v_new_from_balance := v_from_balance - p_amount;
    v_new_to_balance := v_to_balance + p_amount;
    
    -- Update source account
    UPDATE Accounts
    SET Balance = v_new_from_balance
    WHERE AccountID = p_from_account;
    
    -- Update destination account
    UPDATE Accounts
    SET Balance = v_new_to_balance
    WHERE AccountID = p_to_account;
    
    -- Record source transaction
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
        p_from_account,
        p_to_account,
        'Transfer',
        p_amount,
        SYSDATE,
        'Transfer from Account ' || p_from_account || ' to Account ' || p_to_account,
        'Completed'
    );
    
    -- Display transfer details
    DBMS_OUTPUT.PUT_LINE('✓ TRANSFER SUCCESSFUL');
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('FROM ACCOUNT: ' || p_from_account);
    DBMS_OUTPUT.PUT_LINE('  Previous Balance: $' || TO_CHAR(v_from_balance, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('  Amount Transferred: -$' || TO_CHAR(p_amount, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('  New Balance: $' || TO_CHAR(v_new_from_balance, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('TO ACCOUNT: ' || p_to_account);
    DBMS_OUTPUT.PUT_LINE('  Previous Balance: $' || TO_CHAR(v_to_balance, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('  Amount Received: +$' || TO_CHAR(p_amount, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('  New Balance: $' || TO_CHAR(v_new_to_balance, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('✗ ERROR: ' || SQLERRM);
        DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
        ROLLBACK;
END TransferFunds;
/

-- Execute the procedure - Successful transfer
PROMPT Executing TransferFunds (Successful scenario)...
PROMPT
BEGIN
    TransferFunds(1001, 1002, 1000.00);
END;
/

-- Execute the procedure - Failed transfer (insufficient funds)
PROMPT
PROMPT Executing TransferFunds (Insufficient funds scenario)...
PROMPT
BEGIN
    TransferFunds(1004, 1001, 50000.00);
END;
/

-- Execute the procedure - Successful transfer 2
PROMPT
PROMPT Executing TransferFunds (Another successful transfer)...
PROMPT
BEGIN
    TransferFunds(1005, 1003, 5000.00);
END;
/

-- Show results
PROMPT
PROMPT --- ACCOUNT BALANCES AFTER TRANSFERS ---
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
PROMPT --- TRANSFER TRANSACTIONS ---
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

-- Alternative procedure with transfer limit validation
CREATE OR REPLACE PROCEDURE TransferFundsWithLimit (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER,
    p_daily_limit IN NUMBER DEFAULT 50000
) IS
    v_daily_transfer_total NUMBER;
    v_from_balance NUMBER;
    v_to_balance NUMBER;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('ALTERNATIVE: Transfer with Daily Limit Validation');
    DBMS_OUTPUT.PUT_LINE('Daily Limit: $' || TO_CHAR(p_daily_limit, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    -- Check daily transfer total
    SELECT NVL(SUM(Amount), 0) INTO v_daily_transfer_total
    FROM Transactions
    WHERE FromAccountID = p_from_account
    AND TransactionType = 'Transfer'
    AND TRUNC(TransactionDate) = TRUNC(SYSDATE);
    
    IF v_daily_transfer_total + p_amount > p_daily_limit THEN
        DBMS_OUTPUT.PUT_LINE('✗ Transfer exceeds daily limit');
        DBMS_OUTPUT.PUT_LINE('  Daily Limit: $' || TO_CHAR(p_daily_limit, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('  Already Transferred Today: $' || TO_CHAR(v_daily_transfer_total, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('  Available Today: $' || TO_CHAR(p_daily_limit - v_daily_transfer_total, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('');
        RAISE_APPLICATION_ERROR(-20008, 'Daily transfer limit exceeded');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('✓ Daily limit check passed');
    DBMS_OUTPUT.PUT_LINE('  Today''s transfers: $' || TO_CHAR(v_daily_transfer_total, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('  Remaining today: $' || TO_CHAR(p_daily_limit - v_daily_transfer_total - p_amount, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('');
    
    -- Call main transfer procedure
    TransferFunds(p_from_account, p_to_account, p_amount);
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFundsWithLimit;
/

PROMPT
PROMPT Executing TransferFundsWithLimit...
PROMPT
BEGIN
    TransferFundsWithLimit(1001, 1002, 2000.00, 50000);
END;
/
