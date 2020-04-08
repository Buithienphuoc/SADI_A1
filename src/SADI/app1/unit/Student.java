package SADI.app1.unit;


/* 1. Student class: id, name, birthday */
public class Student extends AbstractUnit{
    private String birthday;

    public Student(String id, String name, String birthday) {
        super(id, name);
        this.birthday = birthday;
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

    public String getBirthday() {
        return birthday;
    }
}
