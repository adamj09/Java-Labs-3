package lab_10.exercise_1;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Adam Johnston 2332003
 * 
 *         Class used to demonstrate the initialization of an array with
 *         random doubles using both multi-processing and sequential execution.
 */
public class ParallelArrayIntializer {
    public static void main(String[] args) {
        final int SIZE = 9000000;
        double[] list1 = new double[SIZE], list2 = new double[SIZE];

        // Assign values sequentially
        long startTime = System.nanoTime();
        assignValues(list1);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Sequential time [ms]: " + (double) elapsedTime / (1000000));

        // Assign values in parallel
        startTime = System.nanoTime();
        parallelAssignValues(list2);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Parallel time [ms]: " + (double) elapsedTime / (1000000));
    }

    /**
     * Assigns random double values to the given array in parallel.
     * @param list The array to assign values to.
     */
    public static void parallelAssignValues(double[] list) {
        RecursiveAction mainTask = new AssignTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    /**
     * Assigns random double values to the given array sequentially.
     * @param list The array to assign values to.
     */
    public static void assignValues(double[] list) {
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextDouble();
        }
    }

    /**
     * A Task to assign random double values to an array.
     */
    private static class AssignTask extends RecursiveAction {
        private final int THRESHOLD = 500;
        private int high, low;
        private double[] list;

        public AssignTask(double[] list, int low, int high) {
            this.list = list;
            this.high = high;
            this.low = low;
        }

        @Override
        protected void compute() {
            Random random = new Random();
            if (high - low < THRESHOLD) {
                for(int i = low; i < high; i++) {
                    list[i] = random.nextDouble();
                }
            } else { // Split array in two if the threshold is met.
                int mid = (low + high) / 2;
                invokeAll(new AssignTask(list, low, mid), new AssignTask(list, mid, high));
            }
        }

    }
}
