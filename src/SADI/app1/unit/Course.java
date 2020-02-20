package SADI.app1.unit;

public class Course {
    private String id;
    private String name;
    private int numberOfCredit;

    private static Course course;

    public Course(String id, String name, int numberOfCredit) {
        this.id = id;
        this.name = name;
        this.numberOfCredit = numberOfCredit;
    }

    public static Course getInstance(String id, String name, int numberOfCredit) {
        if (null == course) {
            course = new Course(id, name, numberOfCredit);
        }
        return course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(int numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }
}
