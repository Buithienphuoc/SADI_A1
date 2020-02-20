package com.company.list;

import com.company.unit.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseList {
    private Scanner userInput = new Scanner(System.in);
    private static CourseList courseList;
    private ArrayList<Course> courses;

    public static CourseList getInstance() {
        if (courseList == null)
            courseList = new CourseList();

        return courseList;
    }

    private CourseList() {
        courses = new ArrayList<>();
    }

    public String getName(int index) {
        return this.courses.get(index).getName();
    }

    public Course getByName(String name){
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }

    public void addToList() {
        Course userInput = userInput();
        courses.add(userInput);
        System.out.println(userInput.getName() + " course was added!!");
    }
    public Course userInput() {
        System.out.println("Type course id");
        String courseId = userInput.nextLine();
        System.out.println("Type course name:");
        String courseName = userInput.nextLine();
        System.out.println("Type number of credit");
        int numberOfCredit = userInput.nextInt();
        return new Course(courseId, courseName, numberOfCredit);
    }

    public void showAll(){
        System.out.println("There are " + courses.size()+ " courses in this list");
        for (int i = 0; i < courses.size(); i++){
            System.out.println(getName(i));
        }
    }
}
