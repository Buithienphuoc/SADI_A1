package com.company;

import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String birthday;

    private static Student student;

    public Student(String id, String name, String birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public static Student getInstance(String id, String name, String birthday) {
        if (null == student) {
            student = new Student(id, name, birthday);
        }
        return student;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
