package com.company;

import com.company.list.CourseList;
import com.company.list.StudentList;

import java.util.Scanner;

public class User {

    private Scanner userInput = new Scanner(System.in);
    private StudentList studentList = StudentList.getInstance();
    private CourseList courseList = CourseList.getInstance();

    public void Use() {
        String choice;
        label:
        while (true) {
            System.out.print("Type 1 to add a student \n" +
                    "Type 2 to add a course \n" +
                    "Type 3 to show all students \n" +
                    "Type 4 to show all courses \n" +
                    "Type 0 to exit:");
            choice = userInput.nextLine();
            switch (choice) {
                case "0":
                    break label;
                case "1":
                    studentList.addToList();
                    break;
                case "2":
                    courseList.addToList();
                    break;
                case "3":
                    studentList.showAll();
                    break;
                case "4":
                    courseList.showAll();
                    break;
                default:
                    System.out.println("Invalid number please type again");
                    break;
            }
        }
    }
}
