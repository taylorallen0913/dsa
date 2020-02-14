// BankAccount.java
package cse41321.examples.lesson2.ex1;

public class BankAccount {
    public static final double MAX_WITHDRAWAL = 500.00;
    private long accountNumber;
    private double balance;

    public BankAccount(long accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        // Check pre-conditions
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }

        balance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        // Check pre-conditions
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }
        if (amount > MAX_WITHDRAWAL) {
            throw new IllegalArgumentException(
                    "The maximum allowed withdrawal is " + MAX_WITHDRAWAL);
        }
        if (balance - amount < 0) {
            throw new IllegalArgumentException(
                    "Amount is greater than the balance in your account");
        }

        balance -= amount;
    }
}