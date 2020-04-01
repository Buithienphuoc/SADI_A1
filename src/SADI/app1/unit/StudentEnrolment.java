package SADI.app1.unit;

/* 3. StudentEnrollment class that has 3 properties: student , course, semester (2018A, 2018B etc. This is a string) */
public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;

    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public String getStudentID(){
        return getStudent().getId();
    }

    public String getStudentName(){
        return getStudent().getName();
    }

    public String getCourseID(){
        return getCourse().getId();
    }

    public String getCourseName(){
        return getCourse().getName();
    }
}
