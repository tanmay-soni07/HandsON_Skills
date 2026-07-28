-- ============================================================
-- DATABASE SETUP - Banking System Tables
-- Exercise 1: Control Structures
-- ============================================================

-- Drop existing tables if they exist
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Loans';
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
    Age NUMBER(3),
    Balance NUMBER(10, 2),
    IsVIP CHAR(1) DEFAULT 'N' CHECK (IsVIP IN ('Y', 'N'))
);

-- Create Loans Table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER NOT NULL REFERENCES Customers(CustomerID),
    LoanAmount NUMBER(12, 2),
    InterestRate NUMBER(5, 2),
    DueDate DATE,
    CONSTRAINT fk_loans_customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Insert Sample Customers
INSERT INTO Customers (CustomerID, CustomerName, Age, Balance, IsVIP)
VALUES (1, 'John Smith', 65, 5000, 'N');

INSERT INTO Customers (CustomerID, CustomerName, Age, Balance, IsVIP)
VALUES (2, 'Sarah Johnson', 45, 15000, 'N');

INSERT INTO Customers (CustomerID, CustomerName, Age, Balance, IsVIP)
VALUES (3, 'Robert Williams', 62, 8000, 'N');

INSERT INTO Customers (CustomerID, CustomerName, Age, Balance, IsVIP)
VALUES (4, 'Maria Garcia', 38, 3500, 'N');

INSERT INTO Customers (CustomerID, CustomerName, Age, Balance, IsVIP)
VALUES (5, 'James Brown', 70, 25000, 'N');

INSERT INTO Customers (CustomerID, CustomerName, Age, Balance, IsVIP)
VALUES (6, 'Patricia Martinez', 55, 12000, 'N');

INSERT INTO Customers (CustomerID, CustomerName, Age, Balance, IsVIP)
VALUES (7, 'Michael Davis', 61, 7500, 'N');

INSERT INTO Customers (CustomerID, CustomerName, Age, Balance, IsVIP)
VALUES (8, 'Jennifer Wilson', 48, 9000, 'N');

-- Insert Sample Loans
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (101, 1, 50000, 5.5, TRUNC(SYSDATE) + 15);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (102, 2, 75000, 6.0, TRUNC(SYSDATE) + 25);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (103, 3, 60000, 5.8, TRUNC(SYSDATE) + 20);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (104, 4, 40000, 6.5, TRUNC(SYSDATE) + 35);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (105, 5, 100000, 5.2, TRUNC(SYSDATE) + 10);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (106, 6, 80000, 5.9, TRUNC(SYSDATE) + 28);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (107, 7, 55000, 6.0, TRUNC(SYSDATE) + 18);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (108, 8, 65000, 5.7, TRUNC(SYSDATE) + 40);

COMMIT;

DBMS_OUTPUT.PUT_LINE('Database setup complete!');
DBMS_OUTPUT.PUT_LINE('Tables created and sample data inserted.');
/
