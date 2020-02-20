package SADI.app1.list;

import SADI.app1.manager.StudentEnrolmentManager;
import SADI.app1.unit.StudentEnrolment;

import java.util.ArrayList;

public class StudentEnrolmentList implements StudentEnrolmentManager {
    private static StudentEnrolmentList enrolmentList;
    private ArrayList<StudentEnrolment> enrolments;

    public static StudentEnrolmentList getInstance() {
        if (enrolmentList == null) {
            enrolmentList = new StudentEnrolmentList();
        }
        return enrolmentList;
    }

    public StudentEnrolmentList() {
        enrolments = new ArrayList<>();
    }

    public void add(StudentEnrolment enrolment) {

    }

    public void update() {

    }

    public void getOne() {

    }

    public ArrayList<StudentEnrolment> getAll() {
        return this.enrolments;
    }

    public StudentEnrolment getByStudent(String name) {
        for (StudentEnrolment enrolment : enrolments) {
            if (enrolment.getStudent().getName().equals(name)) {
                return enrolment;
            }
        }
        return null;
    }
}
