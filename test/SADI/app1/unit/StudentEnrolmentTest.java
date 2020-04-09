package SADI.app1.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentEnrolmentTest {
    private Student testStudent = new Student("s3634831", "Phuoc", "26/12/1998");
    private Course testCourse = new Course("COSC1111", "Intro", 24);
    private StudentEnrolment testEnrolment = new StudentEnrolment(testStudent, testCourse, "2019C");
    @BeforeAll
    static void start(){
        System.out.println("This is enrolment test !!");
    }
    @Test
    void getStudent() {
        // I expect the student information will not be changed after enrollment
        assertEquals(testStudent, testEnrolment.getStudent());
    }

    @Test
    void getCourse() {
        // I expect the course information is true
        assertEquals(testCourse,testEnrolment.getCourse());
    }

    @Test
    void getSemester() {
        // I expect the semester is NOT true
        assertNotEquals("2019A", testEnrolment.getSemester());
    }

    @Test
    void getStudentID() {
        assertEquals("s3634831", testEnrolment.getStudentID());
    }

    @Test
    void getCourseID() {
        assertEquals("COSC1111",testEnrolment.getCourseID());
    }
}