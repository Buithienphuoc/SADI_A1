package com.company;

import java.util.Scanner;

public class User {

    private Scanner userInput = new Scanner(System.in);

    public void Use() {
        StudentList studentList = StudentList.getInstance();
        CourseList courseList = CourseList.getInstance();

        int choice;
        while (true) {
            System.out.print("Type 1 to add a student \n" +
                    "Type 2 to add a course \n" +
                    "Type 0 to exit:");
            choice = userInput.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                Student studentInfo = studentInfo();
                studentList.addToStudents(studentInfo);
                System.out.println(studentInfo.getName() + " was added!!");
            } else if (choice == 2) {
                Course courseInfo = courseInfo();
                courseList.addToCourses(courseInfo);
                System.out.println(courseInfo.getName() + " course was added");
            } else {
                System.out.println("Invalid number please type again");
            }
        }
    }

    public Student studentInfo() {
        String nothing = userInput.nextLine();
        System.out.print("Type student id:");
        String studentId = userInput.nextLine();
        System.out.print("Type student name:");
        String studentName = userInput.nextLine();
        System.out.print("Type student birthday:");
        String studentBirthday = userInput.nextLine();
        return Student.getInstance(studentId, studentName, studentBirthday);
    }

    public Course courseInfo(){
        System.out.println("Type course id");
        String courseId = userInput.nextLine();
        System.out.println("Type course name:");
        String courseName = userInput.nextLine();
        System.out.println("Type number of credit");
        int numberOfCredit = userInput.nextInt();
        return Course.getInstance(courseId,courseName,numberOfCredit);
    }
}
