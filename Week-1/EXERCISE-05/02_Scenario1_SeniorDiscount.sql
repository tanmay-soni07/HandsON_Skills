-- ============================================================
-- SCENARIO 1: Senior Citizen Loan Discount
-- Apply 1% discount to loan interest rates for customers above 60 years old
-- Control Structure: IF condition with LOOP
-- ============================================================

-- Procedure: ApplySeniorDiscountWithLoop
-- Uses explicit LOOP to iterate through customers
CREATE OR REPLACE PROCEDURE ApplySeniorDiscountWithLoop IS
    v_customer_id Customers.CustomerID%TYPE;
    v_customer_name Customers.CustomerName%TYPE;
    v_age Customers.Age%TYPE;
    v_discount_applied NUMBER := 0;
    
    CURSOR customer_cursor IS
        SELECT CustomerID, CustomerName, Age
        FROM Customers
        ORDER BY CustomerID;
    
    customer_rec customer_cursor%ROWTYPE;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('SCENARIO 1: Senior Citizen Loan Discount');
    DBMS_OUTPUT.PUT_LINE('Applying 1% discount to customers above 60 years old');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    -- Open cursor and loop through customers
    OPEN customer_cursor;
    
    LOOP
        FETCH customer_cursor INTO customer_rec;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        -- Check if customer is above 60 years old
        IF customer_rec.Age > 60 THEN
            -- Update interest rate: apply 1% discount
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = customer_rec.CustomerID;
            
            v_discount_applied := v_discount_applied + SQL%ROWCOUNT;
            
            DBMS_OUTPUT.PUT_LINE('✓ Customer: ' || customer_rec.CustomerName || 
                               ' (Age: ' || customer_rec.Age || ')');
            DBMS_OUTPUT.PUT_LINE('  Action: 1% discount applied to loan interest rate');
            DBMS_OUTPUT.PUT_LINE('');
        ELSE
            DBMS_OUTPUT.PUT_LINE('✗ Customer: ' || customer_rec.CustomerName || 
                               ' (Age: ' || customer_rec.Age || ')');
            DBMS_OUTPUT.PUT_LINE('  Action: No discount (below 60 years)');
            DBMS_OUTPUT.PUT_LINE('');
        END IF;
    END LOOP;
    
    CLOSE customer_cursor;
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('Summary: Discount applied to ' || v_discount_applied || ' loans');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END ApplySeniorDiscountWithLoop;
/

-- Alternative: Using FOR LOOP with cursor
CREATE OR REPLACE PROCEDURE ApplySeniorDiscountWithForLoop IS
    v_discount_count NUMBER := 0;
    
    CURSOR senior_customers IS
        SELECT c.CustomerID, c.CustomerName, c.Age
        FROM Customers c
        WHERE c.Age > 60
        ORDER BY c.Age DESC;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('ALTERNATIVE: Using FOR LOOP (Implicitly Opens/Closes)');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    FOR senior IN senior_customers LOOP
        UPDATE Loans
        SET InterestRate = InterestRate * 0.99
        WHERE CustomerID = senior.CustomerID;
        
        v_discount_count := v_discount_count + SQL%ROWCOUNT;
        
        DBMS_OUTPUT.PUT_LINE('✓ Senior Citizen: ' || senior.CustomerName || 
                           ' (Age: ' || senior.Age || ')');
        DBMS_OUTPUT.PUT_LINE('  Loans Updated: ' || SQL%ROWCOUNT);
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('Total: ' || v_discount_count || ' loan interest rates reduced');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END ApplySeniorDiscountWithForLoop;
/

-- Execute the procedures
BEGIN
    ApplySeniorDiscountWithLoop;
END;
/

BEGIN
    ApplySeniorDiscountWithForLoop;
END;
/
