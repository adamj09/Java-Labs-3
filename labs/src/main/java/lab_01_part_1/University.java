package lab_01_part_1;

/**
 * @author Adam Johnston 2332003
 */
public class University {
    public static void main(String[] args) {
        // Example use of each class' constructor.
        Employee employee = new Employee("John Smith", 30, 50000.0);
        Professor professor = new Professor("Jane Doe", 40, 60000.0, "Computer Science", "9am-12pm");
        Researcher researcher = new Researcher("Bob Johnson", 35, 60000.0, "Biology", 10);
        AdminStaff adminStaff = new AdminStaff("Samantha Brown", 25, 45000.0, "Human Resources", "Manager");

        // Example use of each class' ToString() method
        System.out.printf("%s\n%s\n%s\n%s\n", employee.toString(), professor.toString(), researcher.toString(), adminStaff.toString());
    }
}