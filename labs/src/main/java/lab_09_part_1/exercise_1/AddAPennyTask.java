package lab_09_part_1.exercise_1;

/**
 * @author Adam Johnston 2332003
 * 
 * Task that adds a penny to the given Account.
 */
public class AddAPennyTask implements Runnable {
    Account account;

    public AddAPennyTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.deposit(1);
    }
    
}
