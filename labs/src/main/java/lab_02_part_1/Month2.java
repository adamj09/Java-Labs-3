package lab_02_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 *         Represents a month.
 */
public class Month2 {
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
    public Month2() {
        this.monthNumber = 1;
    }

    /**
     * Constructor that initializes Month1 with a given monthNumber.
     * 
     * @param monthNumber An integer between 1 and 12 inclusive, representing the
     *                    desired month.
     * @throws InvalidMonthNumberException if monthNumber is not between 1 and 12
     *                                     inclusive.
     */
    public Month2(int monthNumber) throws InvalidMonthNumberException {
        setMonthNumber(monthNumber);
    }

    /**
     * Constructor that initializes Month1 with a given month name.
     * 
     * @param month A string corresponding to the desired month, case-insensitive.
     * @throws InvalidMonthNameException if month cannot be found in the months
     *                                   array.
     */
    public Month2(String month) throws InvalidMonthNameException {
        for (int i = 0; i < months.length; i++) {
            if (month.equalsIgnoreCase(months[i])) {
                this.monthNumber = i + 1;
                return;
            }
        }
        throw new InvalidMonthNameException(month);
    }

    /**
     * Sets the month number.
     * 
     * @param monthNumber An integer between 1 and 12 inclusive, representing the
     *                    desired month.
     * @throws InvalidMonthNumberException if monthNumber is not between 1 and 12
     *                                     inclusive.
     */
    public void setMonthNumber(int monthNumber) throws InvalidMonthNumberException {
        this.monthNumber = monthNumber;
        // If month specified is invalid, set to 1.
        if (monthNumber < 1 || monthNumber > 12)
            throw new InvalidMonthNumberException(monthNumber);
    }

    /**
     * @return monthNumber
     */
    public int getMonthNumber() {
        return monthNumber;
    }

    /**
     * 
     * @param monthNumber An integer between 1 and 12 inclusive, representing the
     *                    desired month.
     * @return Month name.
     * @throws InvalidMonthNumberException if monthNumber is not between 1 and 12
     *                                     inclusive.
     */
    public String getMonthName(int monthNumber) throws InvalidMonthNumberException {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new InvalidMonthNumberException(monthNumber);
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
     * Checks if this object is has the same month number as another Month2 object.
     * 
     * @param month2 Month2 object to be compared to.
     * @return True if the month numbers are equal, false otherwise.
     */
    public boolean equals(Month2 month2) {
        return month2.getMonthNumber() == monthNumber;
    }

    /**
     * Checks if this object is has a greater month number than another Month2
     * object.
     * 
     * @param month2 Month2 object to be compared to.
     * @return True if this object has a greater month number, false otherwise.
     */
    public boolean greaterThan(Month2 month2) {
        return month2.getMonthNumber() < monthNumber;
    }

    /**
     * Checks if this object is has a lesser month number than another Month2
     * object.
     * 
     * @param month2 Month2 object to be compared to.
     * @return True if this object has a lesser month number, false otherwise.
     */
    public boolean lessThan(Month2 month2) {
        return month2.getMonthNumber() > monthNumber;
    }
}
