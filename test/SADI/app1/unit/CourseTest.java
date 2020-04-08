package SADI.app1.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    private Course testCourse = new Course("COSC1111", "Intro", 24);
    @Test
    void getId() {
        // I expect the ID is true
        assertEquals("COSC1111", testCourse.getId());
    }

    @Test
    void getName() {
        // I expect the Name is NOT true
        assertNotEquals("intre", testCourse.getName());
    }

    @Test
    void getNumberOfCredit() {
        // I expect the number is true
        assertEquals(24, testCourse.getNumberOfCredit());
    }
}