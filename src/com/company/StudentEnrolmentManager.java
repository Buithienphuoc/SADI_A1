package com.company;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    void add(StudentEnrolment enrolment);

    void update();

    void getOne();

    ArrayList<StudentEnrolment> getAll();
}
