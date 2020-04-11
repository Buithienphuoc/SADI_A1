package SADI.app1.list;

import SADI.app1.manager.StudentEnrolmentManager;
import SADI.app1.unit.Course;
import SADI.app1.unit.Student;
import SADI.app1.unit.StudentEnrolment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import SADI.app1.CSVreport;

/* 3 This is an associate class. To keep all enrollments, there must be a list that keeps all enrollments.  */
public class StudentEnrolmentList implements StudentEnrolmentManager{
    private Scanner userInput = new Scanner(System.in);
    private static StudentEnrolmentList enrolmentList;
    private StudentList students = StudentList.getInstance();
    private CourseList courses = CourseList.getInstance();
    private CSVreport csvReport = CSVreport.getInstance();

    protected ArrayList<StudentEnrolment> enrolments = new ArrayList<>();

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
        // 4. ask allow delete or add new courses from the list.
        System.out.print(" 1 to Add Course for a student \n"
                +" 2 to Delete:");
        String userChoice = userInput.nextLine();
        try {
            int choice = Integer.parseInt(userChoice);
            if (choice == 1) {
                add();
            }
            else if (choice == 2){
                delete();
            }
            else {
                System.out.println("Must be 1 or 2");
            }
        }
        catch (Exception e){
            System.out.println("Must be 1 or 2");
        }

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
        try {
            System.out.print("Type student id:");
            String studentId = userInput.nextLine();
            System.out.print("Type course id:");
            String courseId = userInput.nextLine();
            enrolments.removeIf(enrolment -> enrolment.getStudentID().equals(studentId)
                    && enrolment.getCourseID().equals(courseId));
        }
        catch (Exception e){
            System.out.println("Something wrong!!");
        }
    }

    public StudentEnrolment userInputEnrolment() {
        Student student = students.userInput();
        Course course = courses.userInput();
        System.out.print("Semester:");
        String semester = userInput.nextLine();
        return new StudentEnrolment(student, course, semester);
    }

    public void coursesOfStudent() {
        System.out.print("Please type student id to check:");
        String studentId = userInput.nextLine();
        if (!isExistStudent(studentId)) {
            System.out.println("Cannot find this student!!");
        }
        else {
            System.out.print("Choose semester:");
            String semester = userInput.nextLine();
            if (!isExistSemester(semester)){
                System.out.println("Cannot find the Semester !!");
            }
            else {
                showCourseList(studentId, semester);
            }
        }
    }

    public void studentsOfCourse() {
        System.out.print("Please type course id to check:");
        String courseId = userInput.nextLine();
        if (!isExistCourse(courseId)) {
            System.out.println("Cannot find this course!!");
        }
        else {
            System.out.print("Choose semester:");
            String semester = userInput.nextLine();
            if (!isExistSemester(semester)){
                System.out.println("Cannot find the Semester !!");
            }
            else {
                showStudentList(courseId, semester);
            }
        }
    }

    public void coursesOfSemester() {
        System.out.print("Which semester do you want to check?:");
        String semester = userInput.nextLine();
        if(!isExistSemester(semester)){
            System.out.println("Cannot find the semester");
        }
        else {
            showCoursesOfSemester(semester);
        }
    }

    public Boolean isExistStudent(String studentId){
        for (StudentEnrolment enrolment : enrolments) {
            if (enrolment.getStudentID().equals(studentId)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isExistCourse(String courseId){
        for (StudentEnrolment enrolment : enrolments) {
            if (enrolment.getCourseID().equals(courseId)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isExistSemester(String semester){
        for (StudentEnrolment enrolment : enrolments) {
            if (enrolment.getSemester().equals(semester)) {
                return true;
            }
        }
        return false;
    }

    public void showCourseList(String studentId, String semester){
        System.out.println("The course list:");
        List<Course> courses = new ArrayList<>();
        for (StudentEnrolment enrolment : getAll()) {
            if (studentId.equals(enrolment.getStudentID()) && semester.equals(enrolment.getSemester())){
                courses.add(enrolment.getCourse());
            }
        }
        showCoursesFormat(courses);
        csvReport.coursesOfStudent(courses, "reports/CoursesOfStudentInSemester/"+studentId+"_"+semester+".csv" );
    }

    public void showStudentList(String courseId, String semester){
        System.out.println("The student list:");
        List<Student> students = new ArrayList<>();
        for (StudentEnrolment enrolment : enrolments) {
            if (courseId.equals(enrolment.getCourseID()) && semester.equals(enrolment.getSemester())){
                students.add(enrolment.getStudent());
            }
        }
        showStudentsFormat(students);
        csvReport.studentsOfCourse(students, "reports/StudentsOfCourseInSemester/"+courseId+"_"+semester+".csv");
    }

    public void showCoursesOfSemester(String semester) {
        System.out.println("The course list:");
        List<Course> courses = new ArrayList<>();
        for (StudentEnrolment enrolment : enrolments) {
            if (semester.equals(enrolment.getSemester())) {
                courses.add(enrolment.getCourse());
            }
        }
        showCoursesFormat(courses);
        csvReport.coursesOfStudent(courses, "reports/CoursesOfferedInSemester/"+semester+".csv");
    }

    public void addExamples(StudentEnrolment sample){
        enrolments.add(sample);
    }

    public void showCoursesFormat(List<Course> courseList){
        System.out.println("CourseID CourseName NumberOfCredit");
        for (Course course: courseList){
            System.out.println(course.getId()+" "+course.getName()+" "+ course.getNumberOfCredit() );
        }
    }

    public void showStudentsFormat(List<Student> studentList){
        System.out.println("StudentID StudentName Birthday");
        for (Student student: studentList){
            System.out.println(student.getId()+" "+student.getName()+" "+ student.getBirthday());
        }
    }
}
