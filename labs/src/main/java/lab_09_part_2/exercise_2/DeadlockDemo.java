package lab_09_part_2.exercise_2;

/**
 * @author Adam Johnston 2332003
 * 
 *         Class demonstrating deadlock between two threads.
 */
public class DeadlockDemo {
    private static Object obj1 = new Object(), obj2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());

        // Program should keep running (but do nothing) due to deadlock.
        thread1.start();
        thread2.start();
    }

    private static class Task1 implements Runnable {
        @Override
        public void run() {
            method1();
        }
    }

    private static class Task2 implements Runnable {
        @Override
        public void run() {
            method2();
        }
    }

    private static void method1() {
        synchronized (obj1) {
            System.out.println("Object 1 locked");
            synchronized (obj2) {
                System.out.println("Object 2 locked");
            }
        }
    }

    private static void method2() {
        synchronized (obj2) {
            System.out.println("Object 2 locked");
            synchronized (obj1) {
                System.out.println("Object 1 locked");
            }
        }
    }
}
