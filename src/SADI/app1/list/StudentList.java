package SADI.app1.list;

import SADI.app1.unit.Student;

import java.util.Scanner;

public class StudentList {
    private Scanner userInput = new Scanner(System.in);
    private static StudentList studentList;

    public static StudentList getInstance() {
        if (studentList == null)
            studentList = new StudentList();

        return studentList;
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
}