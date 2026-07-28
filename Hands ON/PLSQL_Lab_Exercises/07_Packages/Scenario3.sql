CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountId NUMBER,
        p_customerId NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_accountId NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customerId NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/



CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountId NUMBER,
        p_customerId NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    )
    IS
    BEGIN

        INSERT INTO Accounts
        VALUES(
            p_accountId,
            p_customerId,
            p_type,
            p_balance,
            SYSDATE
        );

        COMMIT;

    END;

    PROCEDURE CloseAccount(
        p_accountId NUMBER
    )
    IS
    BEGIN

        DELETE FROM Accounts
        WHERE AccountID = p_accountId;

        COMMIT;

    END;

    FUNCTION GetTotalBalance(
        p_customerId NUMBER
    )
    RETURN NUMBER
    IS
        v_total NUMBER;
    BEGIN

        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customerId;

        RETURN NVL(v_total,0);

    END;

END AccountOperations;
/
