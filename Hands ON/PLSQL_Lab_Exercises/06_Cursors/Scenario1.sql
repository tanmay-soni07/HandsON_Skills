SET SERVEROUTPUT ON;

DECLARE

    CURSOR GenerateMonthlyStatements IS

        SELECT CustomerID,
               TransactionID,
               Amount,
               TransactionDate
        FROM Transactions T
        JOIN Accounts A
        ON T.AccountID = A.AccountID
        WHERE TO_CHAR(TransactionDate,'MMYYYY') =
              TO_CHAR(SYSDATE,'MMYYYY');

    v_customerId Customers.CustomerID%TYPE;
    v_transactionId Transactions.TransactionID%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_date Transactions.TransactionDate%TYPE;

BEGIN

    OPEN GenerateMonthlyStatements;

    LOOP

        FETCH GenerateMonthlyStatements
        INTO v_customerId,
             v_transactionId,
             v_amount,
             v_date;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID : ' || v_customerId ||
            ' | Transaction ID : ' || v_transactionId ||
            ' | Amount : ' || v_amount ||
            ' | Date : ' || TO_CHAR(v_date,'DD-MON-YYYY')
        );

    END LOOP;

    CLOSE GenerateMonthlyStatements;

END;
/