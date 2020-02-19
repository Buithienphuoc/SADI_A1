package com.company;

import java.util.ArrayList;

public class CourseList {
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

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public String getCourseName(int index) {
        return this.courses.get(index).getName();
    }

    public Course getCourseByName(String name){
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }

    public void addToCourses(Course course) {
        courses.add(course);
    }
}
