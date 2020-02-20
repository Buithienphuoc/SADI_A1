package SADI.app1.manager;

import SADI.app1.unit.StudentEnrolment;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    void add(StudentEnrolment enrolment);

    void update();

    void getOne();

    ArrayList<StudentEnrolment> getAll();
}
