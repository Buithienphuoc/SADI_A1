package SADI.app1.unit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class StudentTest {
    private Student testStudent = new Student("s3634831", "Phuoc", "26/12/1998");
    @AfterAll
    public static void endTest(){
        System.out.println("End Student test!!");
    }
    @Test
    void getId() {
        // I expected the student ID is correct
        assertEquals("s3634831", testStudent.getId());
    }

    @Test
    void getName() {
        // I expected the student name is correct
        assertEquals("Phuoc", testStudent.getName());
    }

    @Test
    void getBirthday() {
        // I expected the birthday is NOT true
        assertNotEquals("15/1/2000", testStudent.getBirthday());
    }
}