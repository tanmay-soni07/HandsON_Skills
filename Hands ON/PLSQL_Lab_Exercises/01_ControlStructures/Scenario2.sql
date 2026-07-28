SET SERVEROUTPUT ON;

BEGIN

    FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP

        IF c.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = c.CustomerID;

            DBMS_OUTPUT.PUT_LINE('VIP Customer: ' || c.CustomerID);

        ELSE

            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = c.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

END;
/