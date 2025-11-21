package lab_09_part_2.exercise_1;

import java.util.concurrent.*;

/**
 * Class from Introduction to Java Programming and Data Structures, 12th
 * Edition, by Daniel Liang. Modified by Adam Johnston for learning purposes.
 * 
 * Demonstrates synchronization between two threads using the wait() and
 * notifyAll() methods.
 */
public class ThreadCooperation {
    private static Account account = new Account();

    public static void main(String[] args) {
        // Create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();

        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    /**
     * Task that runs the deposit method every 3 seconds on this account.
     */
    public static class DepositTask implements Runnable {
        @Override // Keep adding an amount to the account
        public void run() {
            try {
                while (true) {
                    account.deposit((int) (Math.random() * 10) + 1);
                    Thread.sleep(3000); // Put thread to sleep so results are easier to see in the terminal.
                }
            } catch (InterruptedException ex) {
                System.err.println(ex.getStackTrace());
            }

        }
    }

    /**
     * Task that runs the withdraw method on this account.
     */
    public static class WithdrawTask implements Runnable {
        @Override // Keep subtracting an amount from the account
        public void run() {
            while (true) {
                account.withdraw((int) (Math.random() * 10) + 1);
            }
        }
    }

    /**
     * Class representing a bank account with deposit and withdraw methods.
     */
    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        /**
         * Withdraws the given amount from the account. Waits until a deposit has been
         * made is the balance is less than the amount to withdraw.
         * 
         * @param amount Amount to withdraw.
         */
        public synchronized void withdraw(int amount) {
            try {
                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    this.wait(); // Wait until a deposit has been made.
                }
            } catch (InterruptedException ex) {
                System.err.println(ex.getLocalizedMessage());
            }

            balance -= amount;
            System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
        }

        /**
         * Deposits the given amount to the account. Notifies threads that a deposit has
         * been made (thus a withdraw is allowed to attempt to proceed).
         * 
         * @param amount Amount to deposit.
         */
        public synchronized void deposit(int amount) {
            balance += amount;
            System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
            this.notifyAll(); // Notify threads when deposit has been made (allows for withdrawl)
        }
    }
}
