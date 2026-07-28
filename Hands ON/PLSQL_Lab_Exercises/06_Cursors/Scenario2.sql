SET SERVEROUTPUT ON;

DECLARE

    CURSOR ApplyAnnualFee IS
        SELECT AccountID
        FROM Accounts;

    v_accountId Accounts.AccountID%TYPE;

BEGIN

    OPEN ApplyAnnualFee;

    LOOP

        FETCH ApplyAnnualFee
        INTO v_accountId;

        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = v_accountId;

        DBMS_OUTPUT.PUT_LINE(
            'Annual Fee Applied to Account : ' || v_accountId
        );

    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

END;
/