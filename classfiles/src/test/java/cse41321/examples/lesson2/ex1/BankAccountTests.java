// BankAccountTests.java
package cse41321.examples.lesson2.ex1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class BankAccountTests {
    @Test
    public void constructorSetsAccountNumber() {
        BankAccount account = new BankAccount(1234);

        assertEquals(account.getAccountNumber(), 1234);
    }

    @Test
    public void constructorSetsBalanceToZero() {
        BankAccount account = new BankAccount(1234);

        assertEquals(account.getBalance(), 0.0);
    }

    @Test
    public void depositUpdatesBalance() {
        BankAccount account = new BankAccount(1234);
        account.deposit(50);

        assertEquals(account.getBalance(), 50.0);
    }

    @Test
    public void withdrawUpdatesBalance() {
        BankAccount account = new BankAccount(1234);
        account.deposit(50);
        account.withdraw(25);

        assertEquals(account.getBalance(), 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void negativeDepositNotAllowed() {
        BankAccount account = new BankAccount(1234);
        account.deposit(-50);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void negativeWithdrawalNotAllowed() {
        BankAccount account = new BankAccount(1234);
        account.deposit(50);
        account.withdraw(-25);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void withdrawResultingInNegativeBalanceNotAllowed() {
        BankAccount account = new BankAccount(1234);
        account.deposit(50);
        account.withdraw(75);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void withdrawLargerThanMaxNotAllowed() {
        BankAccount account = new BankAccount(1234);
        account.deposit(BankAccount.MAX_WITHDRAWAL + 1);
        account.withdraw(BankAccount.MAX_WITHDRAWAL + 1);
    }
}