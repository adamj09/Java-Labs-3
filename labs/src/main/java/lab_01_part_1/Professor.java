package lab_01_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 * Represents a professor at the University.
 */
public class Professor extends Employee {
    private String department, officeHours;

    public Professor(String name, Integer age, Double salary, String department, String officeHours) {
        super(name, age, salary);
        this.department = department;
        this.officeHours = officeHours;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public String toString() {
        return "Professor {" +
                " name = \"" + getName() + "\"" +
                ", age = " + getAge() +
                ", salary = " + getSalary() +
                " department = \"" + getDepartment() + "\"" +
                ", officeHours = \"" + getOfficeHours() + "\"" +
                " }";
    }
}
