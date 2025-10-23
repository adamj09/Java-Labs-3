package lab_02_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 *         Represents a month.
 */
public class Month1 {
    /**
     * Number representing the month, i.e. January = 1, February = 2, and so forth.
     */
    private int monthNumber;

    /**
     * Possible month names.
     */
    private static String[] months = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
            "November", "December"
    };

    /**
     * No-arg constructor sets month to January as a default.
     */
    public Month1() {
        this.monthNumber = 1;
    }

    /**
     * Constructor that initializes Month1 with a given monthNumber.
     * 
     * @param monthNumber An integer between 1 and 12 inclusive, representing the
     *                    desired month.
     */
    public Month1(int monthNumber) {
        setMonthNumber(monthNumber);
    }

    /**
     * Constructor that initializes Month1 with a given month name.
     * 
     * @param month A string corresponding to the desired month, case-insensitive.
     */
    public Month1(String month) {
        for (int i = 0; i < months.length; i++) {
            if (month.equalsIgnoreCase(months[i])) {
                this.monthNumber = i + 1;
                return;
            }
        }
        this.monthNumber = 1; // Input month not found in array of months; set month number to default.
    }

    /**
     * Sets the month number.
     * 
     * @param monthNumber An integer between 1 and 12 inclusive, representing the
     *                    desired month.
     */
    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
        // If month specified is invalid, set to 1.
        if (monthNumber < 1 || monthNumber > 12)
            this.monthNumber = 1;
    }

    /**
     * @return monthNumber
     */
    public int getMonthNumber() {
        return monthNumber;
    }

    /**
     * Given a month number, returns the corresponding month name as a String.
     * 
     * @param monthNumber An integer between 1 and 12 inclusive, representing the
     *                    desired month.
     * @return Month name.
     */
    public String getMonthName(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            return null;
        }
        return months[monthNumber - 1];
    }

    /**
     * Returns this object's month name.
     */
    @Override
    public String toString() {
        return months[monthNumber - 1];
    }

    /**
     * Checks if this object is has the same month number as another Month1 object.
     * 
     * @param month1 Month1 object to be compared to.
     * @return True if the month numbers are equal, false otherwise.
     */
    public boolean equals(Month1 month1) {
        return month1.getMonthNumber() == monthNumber;
    }

    /**
     * Checks if this object is has a greater month number than another Month1
     * object.
     * 
     * @param month1 Month1 object to be compared to.
     * @return True if this object has a greater month number, false otherwise.
     */
    public boolean greaterThan(Month1 month1) {
        return month1.getMonthNumber() < monthNumber;
    }

    /**
     * Checks if this object is has a lesser month number than another Month1
     * object.
     * 
     * @param month1 Month1 object to be compared to.
     * @return True if this object has a lesser month number, false otherwise.
     */
    public boolean lessThan(Month1 month1) {
        return month1.getMonthNumber() > monthNumber;
    }
}
