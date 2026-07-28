-- ============================================================
-- DATABASE SETUP - Banking and Employee Management System
-- Exercise 3: Stored Procedures
-- ============================================================

-- Drop existing tables if they exist
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Transactions';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

-- Create Customers Table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100) NOT NULL,
    Email VARCHAR2(100),
    Phone VARCHAR2(15)
);

-- Create Accounts Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER NOT NULL REFERENCES Customers(CustomerID),
    AccountType VARCHAR2(20) CHECK (AccountType IN ('Savings', 'Checking', 'Investment')),
    Balance NUMBER(12, 2) NOT NULL,
    InterestRate NUMBER(5, 2),
    CreatedDate DATE DEFAULT SYSDATE,
    LastInterestDate DATE
);

-- Create Transactions Table
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    FromAccountID NUMBER REFERENCES Accounts(AccountID),
    ToAccountID NUMBER REFERENCES Accounts(AccountID),
    TransactionType VARCHAR2(20) CHECK (TransactionType IN ('Transfer', 'Interest', 'Deposit', 'Withdrawal')),
    Amount NUMBER(12, 2),
    TransactionDate DATE DEFAULT SYSDATE,
    Description VARCHAR2(200),
    Status VARCHAR2(20) DEFAULT 'Completed'
);

-- Create Employees Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100) NOT NULL,
    Department VARCHAR2(50),
    Salary NUMBER(12, 2),
    PerformanceRating NUMBER(3, 1) CHECK (PerformanceRating BETWEEN 1 AND 5),
    HireDate DATE DEFAULT SYSDATE
);

-- Create sequence for IDs
CREATE SEQUENCE seq_transaction_id START WITH 1001 INCREMENT BY 1;
CREATE SEQUENCE seq_customer_id START WITH 101 INCREMENT BY 1;
CREATE SEQUENCE seq_account_id START WITH 1001 INCREMENT BY 1;
CREATE SEQUENCE seq_employee_id START WITH 501 INCREMENT BY 1;

-- Insert Sample Customers
INSERT INTO Customers (CustomerID, CustomerName, Email, Phone)
VALUES (seq_customer_id.NEXTVAL, 'John Smith', 'john.smith@email.com', '555-0101');

INSERT INTO Customers (CustomerID, CustomerName, Email, Phone)
VALUES (seq_customer_id.NEXTVAL, 'Sarah Johnson', 'sarah.j@email.com', '555-0102');

INSERT INTO Customers (CustomerID, CustomerName, Email, Phone)
VALUES (seq_customer_id.NEXTVAL, 'Robert Williams', 'robert.w@email.com', '555-0103');

INSERT INTO Customers (CustomerID, CustomerName, Email, Phone)
VALUES (seq_customer_id.NEXTVAL, 'Maria Garcia', 'maria.g@email.com', '555-0104');

INSERT INTO Customers (CustomerID, CustomerName, Email, Phone)
VALUES (seq_customer_id.NEXTVAL, 'James Brown', 'james.b@email.com', '555-0105');

-- Insert Sample Accounts (Savings Accounts for Monthly Interest Processing)
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, InterestRate, CreatedDate)
VALUES (seq_account_id.NEXTVAL, 101, 'Savings', 5000.00, 1.0, SYSDATE - 90);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, InterestRate, CreatedDate)
VALUES (seq_account_id.NEXTVAL, 102, 'Savings', 15000.00, 1.0, SYSDATE - 90);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, InterestRate, CreatedDate)
VALUES (seq_account_id.NEXTVAL, 103, 'Savings', 8500.00, 1.0, SYSDATE - 90);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, InterestRate, CreatedDate)
VALUES (seq_account_id.NEXTVAL, 104, 'Checking', 3000.00, 0.5, SYSDATE - 90);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, InterestRate, CreatedDate)
VALUES (seq_account_id.NEXTVAL, 105, 'Savings', 25000.00, 1.0, SYSDATE - 90);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, InterestRate, CreatedDate)
VALUES (seq_account_id.NEXTVAL, 101, 'Checking', 7500.00, 0.5, SYSDATE - 90);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, InterestRate, CreatedDate)
VALUES (seq_account_id.NEXTVAL, 102, 'Investment', 50000.00, 2.5, SYSDATE - 90);

-- Insert Sample Employees
INSERT INTO Employees (EmployeeID, EmployeeName, Department, Salary, PerformanceRating, HireDate)
VALUES (seq_employee_id.NEXTVAL, 'Alice Cooper', 'Sales', 50000, 4.5, SYSDATE - 365);

INSERT INTO Employees (EmployeeID, EmployeeName, Department, Salary, PerformanceRating, HireDate)
VALUES (seq_employee_id.NEXTVAL, 'Bob Martin', 'Sales', 48000, 4.0, SYSDATE - 365);

INSERT INTO Employees (EmployeeID, EmployeeName, Department, Salary, PerformanceRating, HireDate)
VALUES (seq_employee_id.NEXTVAL, 'Carol White', 'IT', 60000, 4.8, SYSDATE - 365);

INSERT INTO Employees (EmployeeID, EmployeeName, Department, Salary, PerformanceRating, HireDate)
VALUES (seq_employee_id.NEXTVAL, 'David Lee', 'IT', 58000, 3.5, SYSDATE - 365);

INSERT INTO Employees (EmployeeID, EmployeeName, Department, Salary, PerformanceRating, HireDate)
VALUES (seq_employee_id.NEXTVAL, 'Emma Davis', 'HR', 52000, 4.2, SYSDATE - 365);

INSERT INTO Employees (EmployeeID, EmployeeName, Department, Salary, PerformanceRating, HireDate)
VALUES (seq_employee_id.NEXTVAL, 'Frank Johnson', 'Sales', 49000, 3.8, SYSDATE - 365);

COMMIT;

DBMS_OUTPUT.PUT_LINE('Database setup complete!');
DBMS_OUTPUT.PUT_LINE('Tables created and sample data inserted.');
/
