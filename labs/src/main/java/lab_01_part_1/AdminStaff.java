package lab_01_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 * Represents an adminstrative staff member at the university.
 */
public class AdminStaff extends Employee {
    private String department, position;

    public AdminStaff(String name, Integer age, Double salary, String department, String position) {
        super(name, age, salary);
        this.department = department;
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "AdminStaff {" +
                " name = \"" + getName() + "\"" +
                ", age = " + getAge() +
                ", salary = " + getSalary() +
                " department = \"" + getDepartment() + "\"" +
                ", position = \"" + getPosition() + "\"" +
                " }";
    }
}
