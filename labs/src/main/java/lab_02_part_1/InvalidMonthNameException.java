package lab_02_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 * Exception designed for the Month2 class, thrown when an invalid month name is given as input.
 */
public class InvalidMonthNameException extends Exception {
    private String monthName;

    public InvalidMonthNameException() {
        super("InvalidMonthNameException: Month does not exist!\n");
    }

    public InvalidMonthNameException(String monthName) {
        super("InvalidMonthNameException: Month does not exist!\n");
        this.monthName = monthName;
    }

    public String getMonthName() {
        return monthName;
    }
}
