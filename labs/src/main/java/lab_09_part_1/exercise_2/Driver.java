package lab_09_part_1.exercise_2;

/**
 * @author Adam Johnston 2332003
 * 
 *         Class that runs both SyncDemo and NoSyncDemo 10 times each to
 *         demonstrate the effects of implementing versus not implementing
 *         synchronization across threads.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("Sum with sync: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("\tRun " + i + ": " + SyncDemo.runDemo());
            SyncDemo.reset(); // Reset sum to 0.
        }

        System.out.println("Sum without sync: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("\tRun " + i + ": " + NoSyncDemo.runDemo());
            NoSyncDemo.reset(); // Reset sum to 0.
        }
    }
}
