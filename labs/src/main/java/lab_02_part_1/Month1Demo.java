package lab_02_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 *         Class used to demonstrate the methods of the Month1 class.
 */
public class Month1Demo {
    public static void main(String[] args) {
        // Create some Month1 objects for testing.
        Month1 month1 = new Month1();
        Month1 month2 = new Month1(4);
        Month1 month3 = new Month1("october");

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

        // Creating invalid months.
        Month1 invalidMonth1 = new Month1("septober");
        Month1 invalidMonth2 = new Month1(-3);

        // Should print "January\nJanuary".
        System.out.printf("%s\n%s\n", invalidMonth1, invalidMonth2);
    }
}
