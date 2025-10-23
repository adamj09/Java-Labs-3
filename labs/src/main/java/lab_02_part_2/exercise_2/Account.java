package lab_02_part_2.exercise_2;

/**
 * @author Adam Johnston 2332003
 *         Represents a bank account and its basic functions.
 */
public abstract class Account {
    private final int ACCOUNT_NUMBER;
    private double balance;

    Account(int accountNumber, double balance) throws IllegalArgumentException {
        if (accountNumber < 0) { // Make sure account number is valid.
            throw new IllegalArgumentException("Account number cannot be negative.");
        }
        ACCOUNT_NUMBER = accountNumber;
        this.balance = balance;
    }

    /**
     * Deposit a sum from the account.
     * 
     * @param amount Amount of money to be deposited.
     * @throws IllegalArgumentException If the amount specified is less than 0.
     */
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            System.err.println("Amount to be deposited must be greater than or equal to 0.");
            return;
        }
        this.balance += amount;
    }

    /**
     * Withdraw a sum.
     * 
     * @param amount Amount of money to be withdrawn.
     * @throws IllegalArgumentException If the amount specified is less than 0.
     */
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            System.err.println("Amount to be withdrawn must be greater than or equal to 0.");
            return;
        }
        this.balance -= amount;
    }

    public abstract void calculateInterest();

    /**
     * @return Account number.
     */
    public int getAccountNumber() {
        return ACCOUNT_NUMBER;
    }

    /**
     * @return Balance.
     */
    public double getBalance() {
        return balance;
    }
}
