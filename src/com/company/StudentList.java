package com.company;

import java.util.ArrayList;

public class StudentList {
    private static StudentList studentList;
    private ArrayList<Student> students;

    public static StudentList getInstance() {
        if (studentList == null)
            studentList = new StudentList();

        return studentList;
    }

    private StudentList() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public String getStudentName(int index) {
        return this.students.get(index).getName();
    }

    public void addToStudents(Student student) {
        students.add(student);
    }
}
