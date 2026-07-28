CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(

    p_department VARCHAR2,
    p_bonus NUMBER

)
AS
BEGIN

    UPDATE Employees

    SET Salary = Salary + (Salary * p_bonus / 100)

    WHERE Department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee Bonus Updated Successfully.');

END;
/