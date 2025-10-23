package lab_02_part_2.exercise_2;

/**
 * @author Adam Johnston
 *         Tests the calculateInterest() method on CheckingAccount and
 *         SavingsAccount classes.
 */
public class BankSystem {
    public static void main(String[] args) {
        // Create some accounts to test.
        Account[] accounts = new Account[4];
        accounts[0] = new CheckingAccount(11, 1000);
        accounts[1] = new CheckingAccount(12, 2000);
        accounts[2] = new SavingsAccount(13, 3000);
        accounts[3] = new SavingsAccount(14, 4000);

        // Test all accounts' calculateInterest() method
        for (Account account : accounts) {
            // Print info before applying interest.
            System.out.printf("Account #%s\nBalance: $%.2f\n", account.getAccountNumber(), account.getBalance());
            // Apply interest.
            account.calculateInterest();
            System.out.println("\tInterest applied...");
            // Print info after applying interest.
            System.out.printf("Balance after interest: $%.2f\n\n", account.getBalance());
        }
    }
}