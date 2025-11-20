package lab_09_part_1.exercise_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoSyncDemo {
    private static Integer sum = 0;

    public static int runDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executor.execute(new Add());
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        return sum;
    }

    public static void reset() {
        sum = 0;
    }

    private static class Add implements Runnable {
        @Override
        public void run() {
            sum++;
        }
    }
}
