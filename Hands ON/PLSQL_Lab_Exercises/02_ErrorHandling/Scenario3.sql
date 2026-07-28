CREATE OR REPLACE PROCEDURE AddNewCustomer(

    p_customerId NUMBER,
    p_name VARCHAR2,
    p_dob DATE,
    p_balance NUMBER

)
AS

    v_count NUMBER;

BEGIN

    SELECT COUNT(*)

    INTO v_count

    FROM Customers

    WHERE CustomerID = p_customerId;

    IF v_count > 0 THEN

        RAISE_APPLICATION_ERROR(-20003,'Customer Already Exists');

    END IF;

    INSERT INTO Customers

    VALUES(

        p_customerId,
        p_name,
        p_dob,
        p_balance,
        SYSDATE

    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer Added Successfully.');

EXCEPTION

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(SQLERRM);

END;
/