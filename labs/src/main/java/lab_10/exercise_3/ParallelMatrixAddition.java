package lab_10.exercise_3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import lab_10.exercise_1.ParallelArrayIntializer;

public class ParallelMatrixAddition {
    public static void main(String[] args) {
        final int SIZE = 10;
        double[][] matrix1 = new double[SIZE][SIZE], matrix2 = new double[SIZE][SIZE];

        // Assign values to matrices
        for(int i = 0; i < matrix1.length; i++) {
            ParallelArrayIntializer.parallelAssignValues(matrix1[i]);
            ParallelArrayIntializer.parallelAssignValues(matrix2[i]);
        }

        long startTime = System.nanoTime();
        double[][] result1 = parallelAddMatrix(matrix1, matrix2);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Parallel time [ms]: " + (double)elapsedTime / 1000000);
        for(int i = 0; i < result1.length; i++) {
            for(int j = 0; j < result1[i].length; j++) {
                System.out.print(result1[i][j] + " ");
            }
            System.out.println();
        }

        startTime = System.nanoTime();
        double[][] result2 = addMatrix(matrix1, matrix2);
        elapsedTime = System.nanoTime() - startTime;

        System.out.println("Sequential time [ms]: " + (double)elapsedTime / 1000000);
        for(int i = 0; i < result2.length; i++) {
            for(int j = 0; j < result2[i].length; j++) {
                System.out.print(result2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] addMatrix(double[][] matrix1, double[][] matrix2) {
        // Make sure matrices have the same dimensions.
        if(matrix1.length != matrix2.length) {
            return null;
        }
        for(int i = 0; i < matrix1.length; i++) {
            if(matrix1[i].length != matrix2[i].length) {
                return null;
            }
        }

        // Make sure matrices are not staggered
        for(int i = 0; i < matrix1.length; i++) {
            if(matrix1[i].length != matrix1[0].length) {
                return null;
            }
        }

        double[][] result = new double[matrix1.length][matrix1[0].length];
        for(int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static double[][] parallelAddMatrix(double[][] matrix1, double[][] matrix2) {
        // Make sure matrices have the same dimensions.
        if(matrix1.length != matrix2.length) {
            return null;
        }
        for(int i = 0; i < matrix1.length; i++) {
            if(matrix1[i].length != matrix2[i].length) {
                return null;
            }
        }

        // Make sure matrices are not staggered
        for(int i = 0; i < matrix1.length; i++) {
            if(matrix1[i].length != matrix1[0].length) {
                return null;
            }
        }

        double[][] result = new double[matrix1.length][matrix1[0].length];
        RecursiveAction task = new SumTask(matrix1, matrix2, result);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        return result;
    }

    private static class SumTask extends RecursiveAction {
        private double[][] a, b, result;
        // constructor

        public SumTask(double[][] a, double[][] b, double[][] result) {
            this.a = a;
            this.b = b;
            this.result = result;
        }

        @Override
        public void compute() {
            RecursiveAction[] tasks = new RecursiveAction[a.length];
            for (int i = 0; i < a.length; i++)
                tasks[i] = new AddOneRow(i);
            invokeAll(tasks);
        }

        public class AddOneRow extends RecursiveAction {
            int i;

            public AddOneRow(int i) {
                this.i = i;
            }

            @Override
            public void compute() {
                for (int j = 0; j < a[0].length; j++)
                    result[i][j] = a[i][j] + b[i][j];
            }
        }
    }

}
