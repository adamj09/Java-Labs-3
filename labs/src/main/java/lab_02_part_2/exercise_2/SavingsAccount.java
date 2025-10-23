package lab_02_part_2.exercise_2;

/**
 * @author Adam Johnston 2332003
 *         Represents a savings account, implementing the missing functionality
 *         of the Account class.
 */
public class SavingsAccount extends Account {
    SavingsAccount(int accountNumber, int balance) throws IllegalArgumentException {
        super(accountNumber, balance);
    }

    /**
     * Deposits an additional 5% of interest into the account.
     */
    @Override
    public void calculateInterest() {
        deposit(getBalance() * 0.05);
    }
}