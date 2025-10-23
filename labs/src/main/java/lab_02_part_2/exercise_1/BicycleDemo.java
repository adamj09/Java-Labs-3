package lab_02_part_2.exercise_1;

/**
 * @author Adam Johnston 2332003
 * 
 *         Class to test all methods for MountainBike and RaceBike.
 */
public class BicycleDemo {
    public static void main(String[] args) {
        RaceBike raceBike = new RaceBike();
        MountainBike mountainBike = new MountainBike();

        // Test all methods in RaceBike class
        raceBike.setColour("Red");
        raceBike.setSize(27);
        raceBike.speedUp(10);
        raceBike.changeGear(5);
        raceBike.applyBrakes(3);

        // Print raceBike safety info and states.
        System.out.println("\nRaceBike Information:");
        raceBike.showSafetyInfo();
        raceBike.printStates();

        // Test all methods in MountainBike class
        mountainBike.setColour("Blue");
        mountainBike.setSize(27);
        mountainBike.speedUp(8);
        mountainBike.changeGear(3);
        mountainBike.applyBrakes(2);

        // Print mountainBike safety info and states.
        System.out.println("\nMountainBike Information:");
        mountainBike.showSafetyInfo();
        mountainBike.printStates();
    }
}
