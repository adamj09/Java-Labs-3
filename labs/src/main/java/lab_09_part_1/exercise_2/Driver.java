package lab_09_part_1.exercise_2;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Sum with sync: ");
        for(int i = 0; i < 10; i++) {
            System.out.println("\tRun " + i + ": " + SyncDemo.runDemo());
            SyncDemo.reset();
        }

        System.out.println("Sum without sync: ");
        for(int i = 0; i < 10; i++) {
            System.out.println("\tRun " + i + ": " + NoSyncDemo.runDemo());
            NoSyncDemo.reset();
        }
    }
}
