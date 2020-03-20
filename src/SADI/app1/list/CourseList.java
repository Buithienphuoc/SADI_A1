package SADI.app1.list;

import SADI.app1.unit.Course;

import java.util.Scanner;

public class CourseList {
    private Scanner userInput = new Scanner(System.in);
    private static CourseList courseList;

    public static CourseList getInstance() {
        if (courseList == null)
            courseList = new CourseList();

        return courseList;
    }

    public Course userInput() {
        System.out.print("Type course id:");
        String courseId = userInput.nextLine();
        System.out.print("Type course name:");
        String courseName = userInput.nextLine();
        System.out.print("Type number of credit:");
        String numberOfCredit = userInput.nextLine();
        int credit = Integer.parseInt(numberOfCredit);
        return new Course(courseId, courseName, credit);
    }
}
