package lab_02_part_2.exercise_1;

/**
 * @author Adam Johnston 2332003
 */
public class RaceBike implements Bicycle {
    /**
     * Colour of the bike.
     */
    private String colour;
    /**
     * Diameter of the wheels in inches.
     */
    private double size;

    /**
     * Speed of the bike in km/h.
     */
    private int speed = 0;

    /**
     * Gear the bike is set to.
     */
    private int gear = 0;

    /**
     * Changes the gear to the absolute value of the argument provided.
     * 
     * @param gear Gear to set the bike to.
     */
    public void changeGear(int gear) {
        this.gear = Math.abs(gear); // Cannot have negative gears, use abs to ensure this.
    }

    /**
     * Increments the speed.
     * 
     * @param increment Number by which to increase the speed (in km/h)
     */
    public void speedUp(int increment) {
        speed += Math.abs(increment); // Set increment to be absolute value (to avoid decrementing using this
                                      // function).
    }

    /**
     * Decrements the speed.
     * 
     * @param increment Number by which to decrease the speed (in km/h)
     */
    public void applyBrakes(int decrement) {
        if (speed - decrement >= 0) { // Make sure speed can't become negative
            speed -= Math.abs(decrement); // Set decrement to be absolute value (to avoid incrementing using this
                                          // function).
        }
    }

    /**
     * Prints the speed and gear of the bike.
     */
    public void printStates() {
        System.out.println("Current state: Speed = " + speed + ", Gear = " + gear);
    }

    /**
     * Prints relevant safety information.
     */
    public void showSafetyInfo() {
        System.out.println(
                """
                        IMPORTANT SAFETY INFORMATION:
                        To prevent injury to the rider and/or damage to the bicycle, ride only on well-paved roads with no obstructions.
                        Helmet required, gloves, as well as clothing that covers up knees and and elbows, are recommended to prevent scrapes in
                        the case of a fall.
                        Take sharp turns slowly.

                        Do not ride under the influence of drugs or alcohol.""");
    }

    /**
     * @return Colour.
     */
    public String getColour() {
        return this.colour;
    }

    /**
     * Sets the colour of the bike.
     * 
     * @param colour Colour to set.
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * @return Size.
     */
    public double getSize() {
        return this.size;
    }

    /**
     * Sets the diameter of the bike's wheels.
     * 
     * @param size Size of the wheels in inches.
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * @return Speed of the bike.
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * @return Gear of the bike.
     */
    public int getGear() {
        return this.gear;
    }
}
