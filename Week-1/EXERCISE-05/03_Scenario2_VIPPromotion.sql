-- ============================================================
-- SCENARIO 2: VIP Customer Promotion
-- Set IsVIP flag to TRUE for customers with balance over $10,000
-- Control Structure: IF-ELSE condition with LOOP
-- ============================================================

-- Procedure: PromoteVIPCustomersWithIfElse
-- Uses IF-ELSE condition to determine VIP status
CREATE OR REPLACE PROCEDURE PromoteVIPCustomersWithIfElse IS
    v_vip_count NUMBER := 0;
    v_regular_count NUMBER := 0;
    
    CURSOR customer_cursor IS
        SELECT CustomerID, CustomerName, Balance, IsVIP
        FROM Customers
        ORDER BY Balance DESC;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('SCENARIO 2: VIP Customer Promotion');
    DBMS_OUTPUT.PUT_LINE('Promoting customers with balance > $10,000 to VIP');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    FOR customer_rec IN customer_cursor LOOP
        
        -- IF condition to check balance
        IF customer_rec.Balance > 10000 THEN
            
            -- Update to VIP status
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = customer_rec.CustomerID;
            
            v_vip_count := v_vip_count + 1;
            
            DBMS_OUTPUT.PUT_LINE('⭐ VIP PROMOTION');
            DBMS_OUTPUT.PUT_LINE('   Customer: ' || customer_rec.CustomerName);
            DBMS_OUTPUT.PUT_LINE('   Balance: $' || TO_CHAR(customer_rec.Balance, '999,999.99'));
            DBMS_OUTPUT.PUT_LINE('   Status: PROMOTED to VIP');
            DBMS_OUTPUT.PUT_LINE('');
            
        ELSE
            -- Keep as regular customer
            v_regular_count := v_regular_count + 1;
            
            DBMS_OUTPUT.PUT_LINE('• REGULAR CUSTOMER');
            DBMS_OUTPUT.PUT_LINE('  Customer: ' || customer_rec.CustomerName);
            DBMS_OUTPUT.PUT_LINE('  Balance: $' || TO_CHAR(customer_rec.Balance, '999,999.99'));
            DBMS_OUTPUT.PUT_LINE('  Status: Regular (Balance below threshold)');
            DBMS_OUTPUT.PUT_LINE('');
            
        END IF;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('Summary:');
    DBMS_OUTPUT.PUT_LINE('  VIP Customers: ' || v_vip_count);
    DBMS_OUTPUT.PUT_LINE('  Regular Customers: ' || v_regular_count);
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END PromoteVIPCustomersWithIfElse;
/

-- Alternative: Using CASE statement instead of IF-ELSE
CREATE OR REPLACE PROCEDURE PromoteVIPCustomersWithCase IS
    v_vip_count NUMBER := 0;
    
    CURSOR customer_cursor IS
        SELECT CustomerID, CustomerName, Balance
        FROM Customers
        ORDER BY Balance DESC;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('ALTERNATIVE: Using CASE Statement');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    FOR customer_rec IN customer_cursor LOOP
        
        -- CASE statement for VIP determination
        CASE
            WHEN customer_rec.Balance > 10000 THEN
                UPDATE Customers
                SET IsVIP = 'Y'
                WHERE CustomerID = customer_rec.CustomerID;
                v_vip_count := v_vip_count + 1;
                DBMS_OUTPUT.PUT_LINE('⭐ ' || customer_rec.CustomerName || 
                                   ' - VIP (Balance: $' || customer_rec.Balance || ')');
                
            WHEN customer_rec.Balance > 5000 THEN
                DBMS_OUTPUT.PUT_LINE('◆ ' || customer_rec.CustomerName || 
                                   ' - Premium Customer (Balance: $' || customer_rec.Balance || ')');
                
            ELSE
                DBMS_OUTPUT.PUT_LINE('• ' || customer_rec.CustomerName || 
                                   ' - Regular Customer (Balance: $' || customer_rec.Balance || ')');
        END CASE;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('Total VIP Customers: ' || v_vip_count);
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
    COMMIT;
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END PromoteVIPCustomersWithCase;
/

-- Execute the procedures
BEGIN
    PromoteVIPCustomersWithIfElse;
END;
/

BEGIN
    PromoteVIPCustomersWithCase;
END;
/
