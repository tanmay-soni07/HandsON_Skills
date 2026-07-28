-- ============================================================
-- SCENARIO 2: Employee Bonus Scheme
-- Update employee salaries based on performance bonus
-- Stored Procedure: UpdateEmployeeBonus
-- ============================================================

-- Procedure: UpdateEmployeeBonus
-- Updates salary of employees in a department by adding bonus percentage
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
    v_employees_updated NUMBER := 0;
    v_total_bonus_amount NUMBER := 0;
    v_old_salary NUMBER;
    v_new_salary NUMBER;
    v_bonus_amount NUMBER;
    
    CURSOR department_employees_cursor IS
        SELECT 
            EmployeeID,
            EmployeeName,
            Department,
            Salary,
            PerformanceRating
        FROM Employees
        WHERE UPPER(Department) = UPPER(p_department)
        ORDER BY PerformanceRating DESC;
    
    employee_rec department_employees_cursor%ROWTYPE;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('SCENARIO 2: Employee Bonus Scheme');
    DBMS_OUTPUT.PUT_LINE('Department: ' || p_department);
    DBMS_OUTPUT.PUT_LINE('Bonus Percentage: ' || p_bonus_percentage || '%');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    -- Validate inputs
    IF p_department IS NULL THEN
        RAISE_APPLICATION_ERROR(-20001, 'Department parameter cannot be NULL');
    END IF;
    
    IF p_bonus_percentage < 0 OR p_bonus_percentage > 100 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Bonus percentage must be between 0 and 100');
    END IF;
    
    OPEN department_employees_cursor;
    
    LOOP
        FETCH department_employees_cursor INTO employee_rec;
        EXIT WHEN department_employees_cursor%NOTFOUND;
        
        v_old_salary := employee_rec.Salary;
        v_bonus_amount := (v_old_salary * p_bonus_percentage) / 100;
        v_new_salary := v_old_salary + v_bonus_amount;
        
        -- Update employee salary
        UPDATE Employees
        SET Salary = v_new_salary
        WHERE EmployeeID = employee_rec.EmployeeID;
        
        v_employees_updated := v_employees_updated + 1;
        v_total_bonus_amount := v_total_bonus_amount + v_bonus_amount;
        
        -- Display update details
        DBMS_OUTPUT.PUT_LINE('✓ Employee: ' || employee_rec.EmployeeName);
        DBMS_OUTPUT.PUT_LINE('  Performance Rating: ' || employee_rec.PerformanceRating || '/5.0');
        DBMS_OUTPUT.PUT_LINE('  Old Salary: $' || TO_CHAR(v_old_salary, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('  Bonus: $' || TO_CHAR(v_bonus_amount, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('  New Salary: $' || TO_CHAR(v_new_salary, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    
    CLOSE department_employees_cursor;
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('Bonus Summary:');
    DBMS_OUTPUT.PUT_LINE('  Employees Updated: ' || v_employees_updated);
    DBMS_OUTPUT.PUT_LINE('  Total Bonus Paid: $' || TO_CHAR(v_total_bonus_amount, '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('  Average Bonus per Employee: $' || 
                         TO_CHAR(v_total_bonus_amount / NULLIF(v_employees_updated, 0), '999,999.99'));
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
    COMMIT;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in UpdateEmployeeBonus: ' || SQLERRM);
        ROLLBACK;
END UpdateEmployeeBonus;
/

-- Execute the procedure for different departments
PROMPT Executing UpdateEmployeeBonus for Sales department...
PROMPT
BEGIN
    UpdateEmployeeBonus('Sales', 10);
END;
/

PROMPT
PROMPT Executing UpdateEmployeeBonus for IT department...
PROMPT
BEGIN
    UpdateEmployeeBonus('IT', 15);
END;
/

-- Show results
PROMPT
PROMPT --- EMPLOYEE SALARIES AFTER BONUS APPLICATION ---
PROMPT
SELECT 
    EmployeeID,
    EmployeeName,
    Department,
    PerformanceRating,
    Salary,
    TO_CHAR(HireDate, 'DD-MON-YYYY') as HireDate
FROM Employees
ORDER BY Department, PerformanceRating DESC;

-- Alternative procedure with performance-based bonus multiplier
CREATE OR REPLACE PROCEDURE UpdatePerformanceBonus (
    p_department IN VARCHAR2,
    p_base_bonus IN NUMBER
) IS
    v_bonus_multiplier NUMBER;
    v_adjusted_bonus NUMBER;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('ALTERNATIVE: Performance-Based Bonus');
    DBMS_OUTPUT.PUT_LINE('Department: ' || p_department);
    DBMS_OUTPUT.PUT_LINE('Base Bonus: ' || p_base_bonus || '%');
    DBMS_OUTPUT.PUT_LINE('Multiplied by Performance Rating');
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    DBMS_OUTPUT.PUT_LINE('');
    
    FOR emp IN (SELECT EmployeeID, EmployeeName, Salary, PerformanceRating 
                FROM Employees 
                WHERE UPPER(Department) = UPPER(p_department)) LOOP
        
        -- Bonus multiplied by performance rating (1.0 to 5.0)
        v_adjusted_bonus := (p_base_bonus * emp.PerformanceRating) / 5;
        v_bonus_multiplier := (emp.Salary * v_adjusted_bonus) / 100;
        
        DBMS_OUTPUT.PUT_LINE('✓ ' || emp.EmployeeName || ' (Rating: ' || emp.PerformanceRating || ')');
        DBMS_OUTPUT.PUT_LINE('  Base Bonus: ' || p_base_bonus || '% → Adjusted: ' || 
                           TO_CHAR(v_adjusted_bonus, '9.9') || '%');
        DBMS_OUTPUT.PUT_LINE('  Bonus Amount: $' || TO_CHAR(v_bonus_multiplier, '999,999.99'));
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('═══════════════════════════════════════════════════════');
    
END UpdatePerformanceBonus;
/

PROMPT
PROMPT Executing UpdatePerformanceBonus...
PROMPT
BEGIN
    UpdatePerformanceBonus('HR', 12);
END;
/
