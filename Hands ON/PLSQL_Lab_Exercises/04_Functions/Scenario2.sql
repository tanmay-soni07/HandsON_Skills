CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(

    p_loanAmount NUMBER,
    p_interestRate NUMBER,
    p_years NUMBER

)
RETURN NUMBER
AS

    v_installment NUMBER;

BEGIN

    v_installment :=

    (p_loanAmount +
    (p_loanAmount * p_interestRate / 100))
    / (p_years * 12);

    RETURN ROUND(v_installment,2);

END;
/
