CREATE OR REPLACE PROCEDURE UpdateSalary(

    p_employeeId NUMBER,
    p_percentage NUMBER

)
AS

BEGIN

    UPDATE Employees

    SET Salary = Salary + (Salary * p_percentage / 100)

    WHERE EmployeeID = p_employeeId;

    IF SQL%ROWCOUNT = 0 THEN

        RAISE_APPLICATION_ERROR(-20002,'Employee Not Found');

    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary Updated Successfully.');

EXCEPTION

    WHEN OTHERS THEN

        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(SQLERRM);

END;
/