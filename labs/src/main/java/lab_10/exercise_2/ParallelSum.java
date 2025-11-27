package lab_10.exercise_2;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import lab_10.exercise_1.ParallelArrayIntializer;

public class ParallelSum {
    public static void main(String[] args) {
        final int SIZE = 9000000;
        double[] list = new double[SIZE];

        ParallelArrayIntializer.parallelAssignValues(list);

        long startTime = System.nanoTime();
        double parallelSum = parallelSum(list);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Parallel sum: " + parallelSum + " computed in " + (double)elapsedTime / 1000000 + "ms");

        startTime = System.nanoTime();
        double sum = sum(list);
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("Sum: " + sum + " computed in " + (double)elapsedTime / 1000000 + "ms");
    }

    public static double parallelSum(double[] list) {
        RecursiveTask<Double> mainTask = new SumTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(mainTask);
    }

    public static double sum(double[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum;
    }

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
            } else {
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
