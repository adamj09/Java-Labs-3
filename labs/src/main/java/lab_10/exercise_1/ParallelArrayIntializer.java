package lab_10.exercise_1;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelArrayIntializer {
    public static void main(String[] args) {
        final int SIZE = 9000000;
        double[] list1 = new double[SIZE];
        double[] list2 = new double[SIZE];

        long startTime = System.nanoTime();
        assignValues(list1);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Sequential time [ms]: " + (double) elapsedTime / (1000000));

        startTime = System.nanoTime();
        parallelAssignValues(list2);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Parallel time [ms]: " + (double) elapsedTime / (1000000));
    }

    public static void parallelAssignValues(double[] list) {
        RecursiveAction mainTask = new AssignTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    public static void assignValues(double[] list) {
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextDouble();
        }
    }

    private static class AssignTask extends RecursiveAction {
        private final int THRESHOLD = 500;
        private int high, low;
        private double[] list;

        AssignTask(double[] list, int low, int high) {
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
            } else {
                int mid = (low + high) / 2;
                invokeAll(new AssignTask(list, low, mid), new AssignTask(list, mid, high));
            }
        }

    }
}
