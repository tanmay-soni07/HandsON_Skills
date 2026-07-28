package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Arrange: Initialize test fixture
        account = new BankAccount(100.0);
        System.out.println("Test setup: Account created with balance 100.0");
    }

    @After
    public void tearDown() {
        // Cleanup: Reset after each test
        account.reset();
        System.out.println("Test teardown: Account reset");
    }

    @Test
    public void testDeposit() {
        // Arrange: Initial balance is 100.0 (done in @Before)

        // Act: Deposit 50.0
        account.deposit(50.0);

        // Assert: Balance should be 150.0
        assertEquals(150.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        // Arrange: Initial balance is 100.0 (done in @Before)

        // Act: Withdraw 30.0
        account.withdraw(30.0);

        // Assert: Balance should be 70.0
        assertEquals(70.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        // Arrange: Initial balance is 100.0 (done in @Before)

        // Act: Try to withdraw 150.0 (more than balance)
        account.withdraw(150.0);

        // Assert: Balance should remain 100.0 (withdrawal rejected)
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void testDepositAndWithdraw() {
        // Arrange: Initial balance is 100.0 (done in @Before)

        // Act: Deposit 50.0, then withdraw 30.0
        account.deposit(50.0);
        account.withdraw(30.0);

        // Assert: Balance should be 120.0
        assertEquals(120.0, account.getBalance(), 0.01);
    }
}
