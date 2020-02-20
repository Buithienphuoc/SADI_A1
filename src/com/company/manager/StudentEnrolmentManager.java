package com.company.manager;

import com.company.unit.StudentEnrolment;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    void add(StudentEnrolment enrolment);

    void update();

    void getOne();

    ArrayList<StudentEnrolment> getAll();
}
