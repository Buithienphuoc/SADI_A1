package SADI.app1.manager;

import SADI.app1.unit.StudentEnrolment;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    void add();

    void update();

    StudentEnrolment getOne(StudentEnrolment userInput);

    ArrayList<StudentEnrolment> getAll();
}
