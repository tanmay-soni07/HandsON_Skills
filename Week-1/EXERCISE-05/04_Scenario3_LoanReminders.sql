-- ============================================================
-- SCENARIO 3: Loan Due Reminders
-- Fetch all loans due in the next 30 days and send reminders
-- Control Structure: WHILE loop with conditional logic
-- ============================================================

-- Procedure: SendLoanDueReminders
-- Uses WHILE loop to iterate through loans due in next 30 days
CREATE OR REPLACE PROCEDURE SendLoanDueReminders IS
    v_reminder_count NUMBER := 0;
    v_total_due NUMBER := 0;
    v_loop_counter NUMBER := 1;
    v_max_reminders NUMBER;
    
    CURSOR loan_reminder_cursor IS
        SELECT 
            l.LoanID,
            c.CustomerID,
            c.CustomerName,
            l.LoanAmount,
            l.InterestRate,
            l.DueDate,
            TRUNC(l.DueDate - SYSDATE) as days_until_due
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30
        ORDER BY l.DueDate ASC;
    
    loan_rec loan_reminder_cursor%ROWTYPE;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('SCENARIO 3: Loan Due Reminders');
    DBMS_OUTPUT.PUT_LINE('Sending reminders for loans due within 30 days');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    -- Get count of reminders to send
    SELECT COUNT(*) INTO v_max_reminders
    FROM Loans
    WHERE DueDate BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30;
    
    IF v_max_reminders = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due in the next 30 days.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Found ' || v_max_reminders || ' loans due in next 30 days');
        DBMS_OUTPUT.PUT_LINE('');
        
        -- Open cursor
        OPEN loan_reminder_cursor;
        
        -- WHILE loop approach
        FETCH loan_reminder_cursor INTO loan_rec;
        
        WHILE loan_reminder_cursor%FOUND LOOP
            v_reminder_count := v_reminder_count + 1;
            v_total_due := v_total_due + loan_rec.LoanAmount;
            
            -- Format reminder message with conditional priority
            DBMS_OUTPUT.PUT_LINE('┌─────────────────────────────────────────────────');
            DBMS_OUTPUT.PUT_LINE('│ REMINDER #' || v_loop_counter);
            DBMS_OUTPUT.PUT_LINE('├─────────────────────────────────────────────────');
            DBMS_OUTPUT.PUT_LINE('│ Loan ID: ' || loan_rec.LoanID);
            DBMS_OUTPUT.PUT_LINE('│ Customer: ' || loan_rec.CustomerName);
            DBMS_OUTPUT.PUT_LINE('│ Loan Amount: $' || TO_CHAR(loan_rec.LoanAmount, '999,999.99'));
            DBMS_OUTPUT.PUT_LINE('│ Interest Rate: ' || loan_rec.InterestRate || '%');
            DBMS_OUTPUT.PUT_LINE('│ Due Date: ' || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY'));
            DBMS_OUTPUT.PUT_LINE('│ Days Until Due: ' || loan_rec.days_until_due || ' days');
            
            -- Conditional priority message
            IF loan_rec.days_until_due <= 7 THEN
                DBMS_OUTPUT.PUT_LINE('│ ⚠️  URGENT: Due within 1 week!');
            ELSIF loan_rec.days_until_due <= 14 THEN
                DBMS_OUTPUT.PUT_LINE('│ ⚠️  IMPORTANT: Due within 2 weeks');
            ELSE
                DBMS_OUTPUT.PUT_LINE('│ ℹ️  Reminder: Loan due soon');
            END IF;
            
            DBMS_OUTPUT.PUT_LINE('│ Status: Reminder Sent');
            DBMS_OUTPUT.PUT_LINE('└─────────────────────────────────────────────────');
            DBMS_OUTPUT.PUT_LINE('');
            
            v_loop_counter := v_loop_counter + 1;
            FETCH loan_reminder_cursor INTO loan_rec;
        END LOOP;
        
        CLOSE loan_reminder_cursor;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('Summary:');
    DBMS_OUTPUT.PUT_LINE('  Total Reminders Sent: ' || v_reminder_count);
    DBMS_OUTPUT.PUT_LINE('  Total Amount Due: $' || TO_CHAR(v_total_due, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        IF loan_reminder_cursor%ISOPEN THEN
            CLOSE loan_reminder_cursor;
        END IF;
END SendLoanDueReminders;
/

-- Alternative: Using simple LOOP with conditional EXIT
CREATE OR REPLACE PROCEDURE SendRemindersWithSimpleLoop IS
    v_reminder_count NUMBER := 0;
    
    CURSOR due_loans_cursor IS
        SELECT 
            l.LoanID,
            c.CustomerName,
            l.LoanAmount,
            l.DueDate,
            TRUNC(l.DueDate - SYSDATE) as days_until_due
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN TRUNC(SYSDATE) AND TRUNC(SYSDATE) + 30
        ORDER BY l.DueDate ASC;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('ALTERNATIVE: Using Simple LOOP with EXIT Condition');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    OPEN due_loans_cursor;
    
    LOOP
        declare
            due_loan due_loans_cursor%ROWTYPE;
        begin
            FETCH due_loans_cursor INTO due_loan;
            EXIT WHEN due_loans_cursor%NOTFOUND;
            
            v_reminder_count := v_reminder_count + 1;
            
            DBMS_OUTPUT.PUT_LINE('REMINDER ' || v_reminder_count || ':');
            DBMS_OUTPUT.PUT_LINE('  Customer: ' || due_loan.CustomerName);
            DBMS_OUTPUT.PUT_LINE('  Amount: $' || due_loan.LoanAmount);
            DBMS_OUTPUT.PUT_LINE('  Due: ' || TO_CHAR(due_loan.DueDate, 'DD-MON-YYYY') || 
                               ' (' || due_loan.days_until_due || ' days)');
            DBMS_OUTPUT.PUT_LINE('');
        end;
    END LOOP;
    
    CLOSE due_loans_cursor;
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('Total: ' || v_reminder_count || ' loan reminders generated');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        IF due_loans_cursor%ISOPEN THEN
            CLOSE due_loans_cursor;
        END IF;
END SendRemindersWithSimpleLoop;
/

-- Execute the procedures
BEGIN
    SendLoanDueReminders;
END;
/

BEGIN
    SendRemindersWithSimpleLoop;
END;
/
