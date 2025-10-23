package lab_02_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 * Exception designed for the Month2 class, thrown when an invalid month number is given as input.
 */
public class InvalidMonthNumberException extends Exception {
    private int monthNumber;

    public InvalidMonthNumberException() {
        super("InvalidMonthNumberException: Month number must be between 1 and 12, inclusive.\n");
    }

    public InvalidMonthNumberException(int monthNumber) {
        super("InvalidMonthNumberException: Month number must be between 1 and 12, inclusive.\n");
        this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }
}
