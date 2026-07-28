SET SERVEROUTPUT ON;

DECLARE

    CURSOR UpdateLoanInterestRates IS

        SELECT LoanID,
               InterestRate
        FROM Loans;

    v_loanId Loans.LoanID%TYPE;
    v_rate Loans.InterestRate%TYPE;

BEGIN

    OPEN UpdateLoanInterestRates;

    LOOP

        FETCH UpdateLoanInterestRates
        INTO v_loanId,
             v_rate;

        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans

        SET InterestRate = InterestRate + 0.5

        WHERE LoanID = v_loanId;

        DBMS_OUTPUT.PUT_LINE(
            'Loan ID '
            || v_loanId
            || ' Updated.'
        );

    END LOOP;

    CLOSE UpdateLoanInterestRates;

    COMMIT;

END;
/