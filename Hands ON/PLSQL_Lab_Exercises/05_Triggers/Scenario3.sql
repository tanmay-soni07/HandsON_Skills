CREATE OR REPLACE TRIGGER CheckTransactionRules

BEFORE INSERT
ON Transactions

FOR EACH ROW

DECLARE

    v_balance NUMBER;

BEGIN

    SELECT Balance

    INTO v_balance

    FROM Accounts

    WHERE AccountID = :NEW.AccountID;

    IF :NEW.TransactionType = 'Withdrawal' THEN

        IF :NEW.Amount > v_balance THEN

            RAISE_APPLICATION_ERROR(
            -20010,
            'Insufficient Balance');

        END IF;

    ELSIF :NEW.TransactionType = 'Deposit' THEN

        IF :NEW.Amount <= 0 THEN

            RAISE_APPLICATION_ERROR(
            -20011,
            'Deposit Amount Must Be Positive');

        END IF;

    END IF;

END;
/