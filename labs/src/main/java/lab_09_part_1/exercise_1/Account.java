package lab_09_part_1.exercise_1;

/**
 * Class from Introduction to Java Programming and Data Structures, 12th
 * Edition, by Daniel Liang. Modified by Adam Johnston for learning purposes.
 * 
 * Represents a bank account, with ability to deposit to a balance.
 */
public class Account {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    /**
     * Not Thread-safe
     * 
     * @param amount
     */
    public void deposit(int amount) {

        int newBalance = balance + amount;

        // This delay is deliberately added to magnify the
        // data-corruption problem and make it easy to see.
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }

        balance = newBalance;
    }
}
