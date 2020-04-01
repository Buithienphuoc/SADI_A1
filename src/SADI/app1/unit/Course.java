package SADI.app1.unit;

/* 2. Course class: id, name, number of credits */
public class Course extends AbstractUnit{
    private int numberOfCredit;

    public Course(String id, String name, int numberOfCredit) {
        super(id,name);
        this.numberOfCredit = numberOfCredit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfCredit() {
        return numberOfCredit;
    }
}
