package lab_02_part_2.exercise_2;

/**
 * @author Adam Johnston 2332003
 *         Represents a checking account, implementing the missing functionality
 *         of the Account class.
 */
public class CheckingAccount extends Account {
    CheckingAccount(int accountNumber, int balance) throws IllegalArgumentException {
        super(accountNumber, balance);
    }

    /**
     * Deposits an additional 2% of interest into the account.
     */
    @Override
    public void calculateInterest() {
        deposit(getBalance() * 0.02);
    }
}