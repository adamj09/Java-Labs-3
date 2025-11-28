package lab_10.exercise_3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Adam Johnston 2332003
 * 
 *         Class used to demonstrate the computation of the addition of square
 *         matrices of doubles using both multi-processing and sequential
 *         execution.
 */
public class ParallelMatrixAddition {
    public static void main(String[] args) {
        final int SIZE = 2000;
        double[][] matrix1 = new double[SIZE][SIZE], matrix2 = new double[SIZE][SIZE];

        // Assign values to matrices
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = i;
                matrix2[i][j] = j;
            }
        }

        if (!canAddMatrices(matrix1, matrix2)) {
            return;
        }

        long startTime = System.nanoTime();
        parallelAddMatrix(matrix1, matrix2);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Parallel time [ms]: " + (double) elapsedTime / 1000000);

        startTime = System.nanoTime();
        addMatrix(matrix1, matrix2);
        elapsedTime = System.nanoTime() - startTime;

        // Note: sequential time only seems to be slower for very large matrices (>=
        // 10000 x 10000), this may be due to starting new tasks and recursion being
        // more expensive than performing additions.
        System.out.println("Sequential time [ms]: " + (double) elapsedTime / 1000000);
    }

    /**
     * Check if two matrices can be added.
     * 
     * @param matrix1 First matrix.
     * @param matrix2 Second matrix.
     * @return True if the matrices can be added, false otherwise.
     */
    public static boolean canAddMatrices(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add two matrices sequentially.
     * 
     * @param matrix1 First matrix.
     * @param matrix2 Second matrix.
     * @return Resulting matrix.
     */
    public static double[][] addMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    /**
     * Add two matrices in parallel.
     * 
     * @param matrix1 First matrix.
     * @param matrix2 Second matrix.
     * @return Resulting matrix.
     */
    public static double[][] parallelAddMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];

        RecursiveAction task = new SumTask(matrix1, matrix2, result);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        return result;
    }

    /**
     * Task that adds two matrices using multi-processing.
     */
    private static class SumTask extends RecursiveAction {
        private double[][] a, b, result;

        public SumTask(double[][] a, double[][] b, double[][] result) {
            this.a = a;
            this.b = b;
            this.result = result;
        }

        @Override
        public void compute() {
            RecursiveAction[] tasks = new RecursiveAction[a.length];
            for (int i = 0; i < a.length; i++) // Create a new task for each row.
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
