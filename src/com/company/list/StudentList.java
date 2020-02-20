package com.company.list;

import com.company.unit.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    private Scanner userInput = new Scanner(System.in);
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

    public void addToList() {
        Student userInput = userInput();
        students.add(userInput);
        System.out.println(userInput.getName() + " was added!!");
    }

    public Student userInput() {
        System.out.print("Type student id:");
        String studentId = userInput.nextLine();
        System.out.print("Type student name:");
        String studentName = userInput.nextLine();
        System.out.print("Type student birthday:");
        String studentBirthday = userInput.nextLine();
        return new Student(studentId, studentName, studentBirthday);
    }

    public void showAll(){
        System.out.println("There are " + studentList.getStudents().size()+ " students in this list");
        for (int i = 0; i < studentList.getStudents().size(); i++) {
            System.out.println(studentList.getStudentName(i));
        }
    }

}
