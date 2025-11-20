package lab_09_part_1.exercise_1;

import java.util.concurrent.*;

/**
 * Class from Introduction to Java Programming and Data Structures, 12th
 * Edition, by Daniel Liang. Modified by Adam Johnston for learning purposes.
 */
public class AccountWithoutSync {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask(account));
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("What is balance? " + account.getBalance());
    }
}
