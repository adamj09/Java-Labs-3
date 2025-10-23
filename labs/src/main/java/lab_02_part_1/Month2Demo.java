package lab_02_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 *         Class used to demonstrate the methods of the Month2 class.
 */
public class Month2Demo {
    public static void main(String[] args) {
        Month2 month1 = new Month2(); // Try-catch not needed here since no-arg throws no exception

        // Try-catch for valid month creation (should not throw exceptions).
        try {
            Month2 month2 = new Month2(4);
            Month2 month3 = new Month2("october");
            demo(month1, month2, month3);
        } catch (InvalidMonthNumberException e) {
            System.err.println(e.getMessage() + "\tInvalid month number was: " + e.getMonthNumber());
        } catch (InvalidMonthNameException e) {
            System.err.println(e.getMessage() + "\tInvalid month name was: " + e.getMonthName());
        }

        // Creating invalid months (should both throw an exception).
        try {
            Month2 invalidMonth1 = new Month2("septober");
        } catch (InvalidMonthNameException e) {
            System.err.println(e.getMessage() + "\tInvalid month name was: " + e.getMonthName());
        }

        try {
            Month2 invalidMonth2 = new Month2(-3);
        } catch (InvalidMonthNumberException e) {
            System.err.println(e.getMessage() + "\tInvalid month number was: " + e.getMonthNumber());
        }
    }

    public static void demo(Month2 month1, Month2 month2, Month2 month3) throws InvalidMonthNumberException {
        // toString method demo.
        System.out.printf("%s\n%s\n%s\n", month1.toString(), month2.toString(), month3.toString());

        // Equals demo.
        System.out.printf("%s equals %s: %s\n", month1.toString(), month1.toString(), month1.equals(month1));
        System.out.printf("%s equals %s: %s\n", month1.toString(), month2.toString(), month1.equals(month2));

        // Greater than demo.
        System.out.printf("%s greater than %s: %s\n", month1.toString(), month3.toString(), month1.greaterThan(month3));
        System.out.printf("%s greater than %s: %s\n", month2.toString(), month1.toString(), month2.greaterThan(month1));

        // less than demo.
        System.out.printf("%s less than %s: %s\n", month1.toString(), month3.toString(), month1.lessThan(month3));
        System.out.printf("%s less than %s: %s\n", month2.toString(), month1.toString(), month2.lessThan(month1));

        // getMonthName method demo.
        System.out.printf("Valid: %s\nInvalid: %s\n", month1.getMonthName(3), month1.getMonthName(-6));

        // Set invalid month demo (should print "January").
        month2.setMonthNumber(13);
        System.out.println(month2.toString());
    }
}
