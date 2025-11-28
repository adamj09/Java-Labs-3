package lab_10.exercise_2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Adam Johnston 2332003
 * 
 *         Class used to demonstrate the computation of the sum of an array of
 *         doubles using both multi-processing and sequential execution.
 */
public class ParallelSum {
    public static void main(String[] args) {
        final int SIZE = 9000000;
        double[] list = new double[SIZE];

        // Populate the array.
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        long startTime = System.nanoTime();
        double parallelSum = parallelSum(list);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Parallel sum: " + parallelSum + " computed in " + (double) elapsedTime / 1000000 + "ms");

        startTime = System.nanoTime();
        double sum = sum(list);
        elapsedTime = System.nanoTime() - startTime;

        // Note: sequential time only seems to be slower for very large arrays
        // (>> 9,000,000 items), this may be due to starting new tasks and recursion
        // being more expensive than performing additions.
        System.out.println("Sum: " + sum + " computed in " + (double) elapsedTime / 1000000 + "ms");
    }

    /**
     * Sums the elements of the given array in parallel.
     * @param list The array to sum.
     * @return The sum of the array elements.
     */
    public static double parallelSum(double[] list) {
        RecursiveTask<Double> mainTask = new SumTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(mainTask);
    }

    /**
     * Sums the elements of the given array sequentially.
     * @param list The array to sum.
     * @return The sum of the array elements.
     */
    public static double sum(double[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum;
    }

    /**
     * A RecursiveTask to compute the sum of an array.
     */
    private static class SumTask extends RecursiveTask<Double> {
        private static final int THRESHOLD = 500;
        private int high, low;
        private double[] list;

        public SumTask(double[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        public Double compute() {
            if (high - low < THRESHOLD) {
                double sum = 0;
                for (int i = low; i < high; i++) {
                    sum += list[i];
                }
                return sum;
            } else { // Split array in two if the threshold is met.
                int mid = (high + low) / 2;
                RecursiveTask<Double> left = new SumTask(list, low, mid);
                RecursiveTask<Double> right = new SumTask(list, mid, high);

                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }
}
