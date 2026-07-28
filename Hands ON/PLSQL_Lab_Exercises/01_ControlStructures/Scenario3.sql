SET SERVEROUTPUT ON;

BEGIN

    FOR l IN (

        SELECT CustomerID, LoanID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30

    ) LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ID '
            || l.CustomerID ||
            ' has Loan ID '
            || l.LoanID ||
            ' due on '
            || TO_CHAR(l.EndDate, 'DD-MON-YYYY')
        );

    END LOOP;

END;
/