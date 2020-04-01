package SADI.app1;


import SADI.app1.list.StudentEnrolmentList;
import SADI.app1.unit.Course;
import SADI.app1.unit.Student;
import SADI.app1.unit.StudentEnrolment;

import java.util.Scanner;

public class User {

    private Scanner userInput = new Scanner(System.in);
    private StudentEnrolmentList enrolmentList = StudentEnrolmentList.getInstance();

    public void Use() {
        addExamples();
        int choice;
        label:
        while (true) {
            try{
            /* 4. Build functionality to enroll students in courses. */
                System.out.print("Type 1 enrol student \n" +
                        "Type 2 to update enrolment\n" +
                        "Type 3 to delete enrolment \n" +
                        "Type 4 to show course list of a student in 1 semester \n"+
                        "Type 5 to show student list of a course in 1 semester \n"+
                        "Type 6 to show all courses in 1 semester\n" +
                        "Type 0 to exit \n" +
                        "Choice:");
                String user_choice = userInput.nextLine();
                choice = Integer.parseInt(user_choice);
                switch (choice) {
                    case 0:
                        break label;
            /* 4. This functionality will basically add/update/delete into StudentEnrollment list.  */
                    case 1:
                        enrolmentList.add();
                        break;
                    case 2:
                        enrolmentList.update();
                        break;
                    case 3:
                        enrolmentList.delete();
                        break;
            /* 5. Print all courses for 1 student in 1 semester.*/
                    case 4:
                        enrolmentList.showCoursesOfStudent();
                        break;
            /* 5. Print all students of 1 course in 1 semester. */
                    case 5:
                        enrolmentList.showStudentsOfCourse();
                        break;
            /* 5. Prints all courses offered in 1 semester.*/
                }
            }
            catch (Exception e) {
                System.out.println("Something wrong please try again");
            }
        }
    }

    /* 6. When starting the program, sample students and courses should be populated.
     There is no need to build CRUD functionality for student and course
     */
    public void addExamples(){
        Student student1 = new Student("s123456", "Phuoc","26/12/1998");
        Student student2 = new Student("s123455", "An","12/12/1998");
        Student student3 = new Student("s345678", "Minh","1/12/1998");
        Course course1 = new Course("a144433","SADI", 25);
        Course course2 = new Course("a144233","SEPM", 25);
        Course course3 = new Course("a331221","PP1", 25);
        Course course4 = new Course("a456789", "PP2", 25);
        StudentEnrolment enrolment1 = new StudentEnrolment(student1, course1 , "2019A");
        enrolmentList.addExamples(enrolment1);
        StudentEnrolment enrolment2 = new StudentEnrolment(student2, course2 , "2019A");
        enrolmentList.addExamples(enrolment2);
        StudentEnrolment enrolment3 = new StudentEnrolment(student3, course3 , "2020A");
        enrolmentList.addExamples(enrolment3);
        StudentEnrolment enrolment4 = new StudentEnrolment(student3, course2 , "2020A");
        enrolmentList.addExamples(enrolment4);
        StudentEnrolment enrolment5 = new StudentEnrolment(student2, course3 , "2019A");
        enrolmentList.addExamples(enrolment5);
        StudentEnrolment enrolment6 = new StudentEnrolment(student1, course3 , "2019A");
        enrolmentList.addExamples(enrolment6);
        StudentEnrolment enrolment7 = new StudentEnrolment(student3, course1 , "2019A");
        enrolmentList.addExamples(enrolment7);
        StudentEnrolment enrolment8 = new StudentEnrolment(student1, course4 , "2020A");
        enrolmentList.addExamples(enrolment8);
        StudentEnrolment enrolment9 = new StudentEnrolment(student3, course4 , "2020A");
        enrolmentList.addExamples(enrolment9);
    }
}
