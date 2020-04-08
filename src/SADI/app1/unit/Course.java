package SADI.app1.unit;

/* 2. Course class: id, name, number of credits */
public class Course extends AbstractUnit{
    private int numberOfCredit;

    public Course(String id, String name, int numberOfCredit) {
        super(id,name);
        this.numberOfCredit = numberOfCredit;
    }

    @Override
    public boolean equals(Object o){
        // self check
        if(this == o){ return true; } else
            // null check
            // field comparison
            if(o == null){ return false;} else
                // type check and cast
                return getClass() == o.getClass();
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
