package SADI.app1.manager;

import SADI.app1.unit.StudentEnrolment;

import java.util.ArrayList;


/* 3. You are supposed to define an interface StudentEnrollmentManager to take care of this list.
Refer to the lectures on class relationship and interface. */
public interface StudentEnrolmentManager {
    void add();

    void update();

    StudentEnrolment getOne(StudentEnrolment userInput);

    ArrayList<StudentEnrolment> getAll();
}
