package SADI.app1;

import SADI.app1.unit.Course;
import SADI.app1.unit.Student;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/* 5. Allow to save these reports to CSV files. */
public class CSVreport {
    private static CSVreport report;
    private static FileWriter csvWriter;

    public static CSVreport getInstance() {
        if (report == null)
             report = new CSVreport();
        return report;
    }
    public void coursesOfStudent(List<Course> courseList, String filename){
        try {
            csvWriter = new FileWriter(filename);
            csvWriter.append("ID,Name,NumberOfCredits\n");
            for (Course course : courseList) {
                csvWriter.append(String.join(",", course.getId()));
                csvWriter.append(",");
                csvWriter.append(String.join(",", course.getName()));
                csvWriter.append(",");
                csvWriter.append(String.join(",", Integer.toString(course.getNumberOfCredit())));
                csvWriter.append("\n");
            }
            csvWriter.close();
            JOptionPane.showMessageDialog(null, "Record saved !!");
        } catch (IOException e) {
            System.out.println("Please check again!!");
            JOptionPane.showMessageDialog(null, "Fail to report!!");
        }
    }
    public void studentsOfCourse(List<Student> studentList, String filename){
        try {
            csvWriter = new FileWriter(filename);
            csvWriter.append("ID,Name,Birthday\n");
            for (Student student : studentList) {
                csvWriter.append(String.join(",", student.getId()));
                csvWriter.append(",");
                csvWriter.append(String.join(",", student.getName()));
                csvWriter.append(",");
                csvWriter.append(String.join(",", student.getBirthday()));
                csvWriter.append("\n");
            }
            csvWriter.close();
            JOptionPane.showMessageDialog(null, "Record saved !!");
        } catch (IOException e) {
            System.out.println("Please check again!!");
            JOptionPane.showMessageDialog(null, "Fail to report!!");
        }
    }
}
