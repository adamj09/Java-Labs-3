package lab_09_part_1.exercise_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Adam Johnston 2332003
 * 
 *         Demo class that initializes 1000 threads and uses each thread to add 1 to
 *         an integer. Uses a synchronized method for addition.
 */
public class SyncDemo {
    private static Integer sum = 0;

    public static int runDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executor.execute(new AddTask());
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        return sum;
    }

    public static void reset() {
        sum = 0;
    }

    private static class AddTask implements Runnable {
        @Override
        public void run() {
            add();
        }
    }

    private static synchronized void add() {
        sum++;
    }
}
