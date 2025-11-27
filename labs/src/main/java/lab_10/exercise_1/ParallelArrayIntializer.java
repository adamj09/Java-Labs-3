package lab_10.exercise_1;

import java.util.Random;

public class ParallelArrayIntializer {
    public static void main(String[] args) {
        double[] list1 = new double[9000000];
        double[] list2 = new double[9000000];
        
        long startTime = System.nanoTime();
        assignValues(list1);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Sequential array initialization elapsed time (ms): " + (double)elapsedTime / (1000000));

        startTime = System.nanoTime();
        parallelAssignValues(list2);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Parallel array initialization elapsed time (ms): " + (double)elapsedTime / (1000000));
    }

    public static void parallelAssignValues(double[] list) {
        //TODO: implement parallel value assignment
    }

    public static void assignValues(double[] list) {
        Random random = new Random();
        for(int i = 0; i < list.length; i++) {
            list[i] = random.nextDouble() * 100; // Assign a random value between 0 and 100 (inclusive).
        }
    }
}
