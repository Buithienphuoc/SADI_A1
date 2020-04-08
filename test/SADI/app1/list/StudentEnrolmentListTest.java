package SADI.app1.list;

import SADI.app1.CSVreport;
import SADI.app1.unit.Course;
import SADI.app1.unit.Student;
import SADI.app1.unit.StudentEnrolment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class StudentEnrolmentListTest {
    private static StudentEnrolmentList testList = new StudentEnrolmentList();
    private CSVreport csvReport = CSVreport.getInstance();
    @BeforeAll
    public static void init(){
        Student student1 = new Student("s123456", "Phuoc","26/12/1998");
        Student student2 = new Student("s123455", "An","12/12/1998");
        Student student3 = new Student("s345678", "Minh","1/12/1998");
        Course course1 = new Course("a144433","SADI", 25);
        Course course2 = new Course("a144233","SEPM", 25);
        Course course3 = new Course("a331221","PP1", 25);
        Course course4 = new Course("a456789", "PP2", 25);
        StudentEnrolment enrolment1 = new StudentEnrolment(student1, course1 , "2019A");
        testList.addExamples(enrolment1);
        StudentEnrolment enrolment2 = new StudentEnrolment(student2, course2 , "2019A");
        testList.addExamples(enrolment2);
        StudentEnrolment enrolment3 = new StudentEnrolment(student3, course3 , "2020A");
        testList.addExamples(enrolment3);
        StudentEnrolment enrolment4 = new StudentEnrolment(student3, course2 , "2020A");
        testList.addExamples(enrolment4);
        StudentEnrolment enrolment5 = new StudentEnrolment(student2, course3 , "2019A");
        testList.addExamples(enrolment5);
        StudentEnrolment enrolment6 = new StudentEnrolment(student1, course3 , "2019A");
        testList.addExamples(enrolment6);
        StudentEnrolment enrolment7 = new StudentEnrolment(student3, course1 , "2019A");
        testList.addExamples(enrolment7);
        StudentEnrolment enrolment8 = new StudentEnrolment(student1, course4 , "2020A");
        testList.addExamples(enrolment8);
        StudentEnrolment enrolment9 = new StudentEnrolment(student3, course4 , "2020A");
        testList.addExamples(enrolment9);
    }
    @AfterAll
    static void afterAllTest(){
        System.out.println("End of Testing");
    }
    @Test
    void addTest() {
        // I expect new enrolment exists in the list
        StudentEnrolment mockNewEnrolment = new StudentEnrolment(
                new Student("s129999", "Hung", "15/4/2000"),
                new Course("a199999","SERR", 24),
                "2019A");
        try {
            testList.getAll().add(mockNewEnrolment);
            System.out.println("Added successfully!!");
            assertTrue(testList.getAll().contains(mockNewEnrolment));
        }
        catch(Exception e){
            System.out.println("Something wrong");
        }
    }

    @Test
    void updateTest1() {
        System.out.print(" 1 to Add Course for a student \n"
                +" 2 to Delete:");
        String mockUserChoice = "1";
        try {
            int choice = Integer.parseInt(mockUserChoice);
            if (choice == 1) {
                addTest();
            }
            else if (choice == 2){
                deleteTest();
            }
            else {
                System.out.println("Must be 1 or 2");
            }
        }
        catch (Exception e){
            System.out.println("Must be 1 or 2");
        }
    }

    @Test
    void getOneTest() {
        // I expect this enrolment does not exist in the list
        StudentEnrolment mockGetEnrolment = new StudentEnrolment(
                new Student("s129999", "Hung", "15/4/2000"),
                new Course("a199999","SERR", 24),
                "2019A");
        assertNotEquals(testList.getOne(mockGetEnrolment),mockGetEnrolment);
    }

    @Test
    void getAllTest() {
        // I expect I can get all the enrolment with getAll()
        assertEquals(testList.getAll(),testList.enrolments);
    }

    @Test
    void deleteTest() {
        try {
            // I expect no enrollment contains both of these student id and course id
            String studentId = "s123456";
            String courseId = "a144433";
            testList.enrolments.removeIf(enrolment -> enrolment.getStudentID().equals(studentId)
                    && enrolment.getCourseID().equals(courseId));
            assertFalse(testList.getAll().contains(new StudentEnrolment(
                    new Student("s123456", "Phuoc","26/12/1998"),
                    new Course("a144433","SADI", 25), "2019A")));
        }
        catch (Exception e){
            System.out.println("Something wrong!!");
        }
    }

    @Test
    void coursesOfStudentTest() {
        // Just test how many ms for executing this method
        String mockStudentId = "s123456";
        String mockSemester = "2019A";
        if (!testList.isExistStudent(mockStudentId)) {
            System.out.println("Cannot find this student!!");
        }
        else {
            if (!testList.isExistSemester(mockSemester)){
                System.out.println("Cannot find the Semester !!");
            }
            else {
                testList.showCourseList(mockStudentId, mockSemester);
            }
        }
    }

    @Test
    void studentsOfCourseTest() {
        // Just test how many ms for executing this method
        String mockCourseId = "a144433";
        String mockSemester = "2019A";
        if (!testList.isExistCourse(mockCourseId)) {
            System.out.println("Cannot find this course!!");
        }
        else {
            if (!testList.isExistSemester(mockSemester)){
                System.out.println("Cannot find the Semester !!");
            }
            else {
                testList.showStudentList(mockCourseId, mockSemester);
            }
        }
    }

    @Test
    void coursesOfSemesterTest() {
        // Just test how many ms for executing this method
        String testInput = "2019A";
        if(!testList.isExistSemester(testInput)){
            System.out.println("Cannot find the semester");
        }
        else {
            testList.showCoursesOfSemester(testInput);
        }
    }

    @Test
    void isExistStudentTest() {
        // I expect this list contains at least 1 enrollment has this student id
        assertTrue(testList.isExistStudent("s123456"));
    }

    @Test
    void isExistCourseTest() {
        assertTrue(testList.isExistCourse("a144433"));
    }

    @Test
    void isExistSemesterTest() {
        assertTrue(testList.isExistSemester("2019A"));
    }

    @Test
    void showCourseListTest() {
        String mockStudentID = "s123456";
        String mockSemester = "2019A";
        System.out.println("The course list:");
        List<Course> courses = new ArrayList<>();
        for (StudentEnrolment enrolment : testList.getAll()) {
            if (mockStudentID.equals(enrolment.getStudentID()) && mockSemester.equals(enrolment.getSemester())){
                courses.add(enrolment.getCourse());
            }
        }
        System.out.println("CourseID CourseName NumberOfCredit");
        for (Course course: courses){
            System.out.println(course.getId()+" "+course.getName()+" "+ course.getNumberOfCredit() );
        }
        csvReport.coursesOfStudent(courses, "reports/CoursesOfStudentInSemester/"+mockSemester+".csv" );
    }

    @Test
    void showStudentListTest() {
        String mockCourseId = "s123456";
        String mockSemester = "2019A";
        System.out.println("The student list:");
        List<Student> students = new ArrayList<>();
        for (StudentEnrolment enrolment : testList.getAll()) {
            if (mockCourseId.equals(enrolment.getCourseID()) && mockSemester.equals(enrolment.getSemester())){
                students.add(enrolment.getStudent());
            }
        }
        System.out.println("StudentID StudentName Birthday");
        for (Student student: students){
            System.out.println(student.getId()+" "+student.getName()+" "+ student.getBirthday());
        }
        csvReport.studentsOfCourse(students, "reports/StudentsOfCourseInSemester/"+mockSemester+".csv");
    }

    @Test
    void showCoursesOfSemesterTest() {
        String mockSemester = "2019A";
        System.out.println("The course list:");
        List<Course> courses = new ArrayList<>();
        for (StudentEnrolment enrolment : testList.getAll()) {
            if (mockSemester.equals(enrolment.getSemester())){
                courses.add(enrolment.getCourse());
            }
        }
        System.out.println("CourseID CourseName NumberOfCredit");
        for (Course course: courses){
            System.out.println(course.getId()+" "+course.getName()+" "+ course.getNumberOfCredit() );
        }
        csvReport.coursesOfStudent(courses, "reports/CoursesOfferedInSemester/"+mockSemester+".csv");
    }

    @Test
    void addExamplesTest() {
        // I expect after add the new example, it can exist in the list
        StudentEnrolment exampleEnrolment = new StudentEnrolment(
                new Student("s103812", "Thinh", "11/11/2000"),
                new Course("a987865", "SEPT", 12),"2020B");
        testList.addExamples(exampleEnrolment);
        assertTrue(testList.getAll().contains(exampleEnrolment));
        System.out.println("Add successfully!!");
    }
}