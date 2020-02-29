package SADI.app1.list;

import SADI.app1.manager.StudentEnrolmentManager;
import SADI.app1.unit.Course;
import SADI.app1.unit.Student;
import SADI.app1.unit.StudentEnrolment;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolmentList implements StudentEnrolmentManager {
    private Scanner userInput = new Scanner(System.in);
    private static StudentEnrolmentList enrolmentList;
    private ArrayList<StudentEnrolment> enrolments;
    private StudentList students = StudentList.getInstance();
    private CourseList courses = CourseList.getInstance();

    public static StudentEnrolmentList getInstance() {
        if (enrolmentList == null) {
            enrolmentList = new StudentEnrolmentList();
        }
        return enrolmentList;
    }

    public StudentEnrolmentList() {
        enrolments = new ArrayList<>();
    }

    public void add() {
        StudentEnrolment newEnrolment = userInput();
        enrolments.add(newEnrolment);
    }

    public void update() {

    }

    public StudentEnrolment getOne(StudentEnrolment userInput) {
        for (StudentEnrolment enrolment : enrolments) {
            if (userInput == enrolment) {
                return enrolment;
            }
        }
        return null;
    }

    public ArrayList<StudentEnrolment> getAll() {
        return enrolments;
    }

    public void delete() {
        StudentEnrolment userInput = userInput();
        enrolments.remove(userInput);
    }

    public StudentEnrolment userInput() {
        Student student = students.userInput();
        Course course = courses.userInput();
        String semester = userInput.nextLine();
        return new StudentEnrolment(student, course, semester);
    }

    public void showAll() {
        for (int i = 0; i < enrolments.size(); i++) {
            System.out.println("Enrolment " + i + ": \n"
                    + "Student name:" + enrolments.get(i).getStudent().getName() + "\n"
                    + "Course:" + enrolments.get(i).getCourse().getName() + "\n"
                    + "Semester:" + enrolments.get(i).getSemester());
        }
    }

    public void showOne() {
        StudentEnrolment userInput = userInput();
        if (getOne(userInput) != null) {
            System.out.println("Enrolment information: \n"
                    + "Student ID:" + userInput.getStudentID() + "\n"
                    + "Student name:" + userInput.getStudent().getName() + "\n"
                    + "Course ID" + userInput.getCourseID() + "\n"
                    + "Course name:" + userInput.getCourse().getName());
        }
        ;
    }
}
