package lab_01_part_1;

/**
 * @author Adam Johnston 2332003
 * 
 * Represents a researcher at the University.
 */
public class Researcher extends Employee {
    private String field;
    private Integer publications;

    public Researcher(String name, Integer age, Double salary, String field, Integer publications) {
        super(name, age, salary);
        this.field = field;
        this.publications = publications;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getPublications() {
        return publications;
    }

    public void setPublications(Integer publications) {
        this.publications = publications;
    }

    @Override
    public String toString() {
        return "Researcher {" +
                " name = \"" + getName() + "\"" +
                ", age = " + getAge() +
                ", salary = " + getSalary() +
                " field = \"" + getField() + "\"" +
                ", publications = \"" + getPublications() + "\"" +
                " }";
    }
}
