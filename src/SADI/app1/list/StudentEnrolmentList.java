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
    private StudentList students = StudentList.getInstance();
    private CourseList courses = CourseList.getInstance();
    private ArrayList<StudentEnrolment> enrolments = new ArrayList<>();

    public static StudentEnrolmentList getInstance() {
        if (enrolmentList == null) {
            enrolmentList = new StudentEnrolmentList();
        }
        return enrolmentList;
    }

    public void add() {
        StudentEnrolment newEnrolment = userInputEnrolment();
        try {
            enrolments.add(newEnrolment);
            System.out.println("Added successfully!!");
        }
        catch(Exception e){
            System.out.println("Something wrong");
        }
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

    public Boolean isExistStudent(Student student){
        for (StudentEnrolment enrolment : enrolments) {
            if (enrolment.getStudent() == student) {
                return true;
            }
        }
        return false;
    }

    public void delete() {
        StudentEnrolment userInput = userInputEnrolment();
        enrolments.remove(userInput);
    }

    public StudentEnrolment userInputEnrolment() {
        Student student = students.userInput();
        Course course = courses.userInput();
        System.out.print("Semester:");
        String semester = userInput.nextLine();
        return new StudentEnrolment(student, course, semester);
    }

    public void showAll() {
        for (int i = 0; i < getAll().size(); i++) {
            if (enrolments.isEmpty()){
                System.out.println("There is no enrolment, cannot display !!");
            }
            else {
                System.out.println("Enrolment " + i + ": \n"
                        + "Student name:" + enrolments.get(i).getStudentName() + "\n"
                        + "Course:" + enrolments.get(i).getCourseName() + "\n"
                        + "Semester:" + enrolments.get(i).getSemester());
            }
        }
    }

    public void showOne() {
        StudentEnrolment userInput = userInputEnrolment();
        if (getOne(userInput) != null) {
            System.out.println("Enrolment information: \n"
                    + "Student ID:" + userInput.getStudentID() + "\n"
                    + "Student name:" + userInput.getStudent().getName() + "\n"
                    + "Course ID" + userInput.getCourseID() + "\n"
                    + "Course name:" + userInput.getCourse().getName());
        }
    }

    public void showEnrolmentByStudent(Student student){
        System.out.println("The course list:");
        for (StudentEnrolment enrolment : enrolments) {
            if (student == enrolment.getStudent()){
                System.out.println("ID:"+ enrolment.getCourseID() +"\n"
                    + " Name:" + enrolment.getCourseName() +"\n"
                    + " Number of credit:" + enrolment.getCourse().getNumberOfCredit() +"\n"
                    + " Semester:" +enrolment.getSemester());
            }
        }
    }

    public void showByStudent() {
        System.out.println("Please type student information to check:");
        Student student = students.userInput();
        if (!isExistStudent(student)) {
            System.out.println("Cannot find this student!!");
        }
        else {
            showEnrolmentByStudent(student);
        }
    }

    public void showBySemester(){
        System.out.print("Semester you want to find");
        String inputSemester = userInput.nextLine();
        for (StudentEnrolment enrolment : enrolments) {
            if (inputSemester.equals(enrolment.getSemester())) {
                System.out.println("Enrolment information in" + inputSemester +"semester" + ":\n" +
                        "StudentID:" + enrolment.getStudentID() + "\n" +
                        "CourseID:" + enrolment.getCourseID());
            }
        }
    }
}
