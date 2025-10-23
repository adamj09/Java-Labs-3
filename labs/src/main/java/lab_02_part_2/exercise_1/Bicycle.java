package lab_02_part_2.exercise_1;

/**
 * @author Adam Johnston 2332003
 *         Defines methods to be implemented by all bicycle types.
 */
public interface Bicycle {
    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);

    void showSafetyInfo();
}
