package SADI.app1;

import SADI.app1.unit.Course;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/* 5. Allow to save these reports to CSV files. */
public class CSVreport {
    private static CSVreport report;

    public static CSVreport getInstance() {
        if (report == null)
             report = new CSVreport();
        return report;
    }
    public void coursesOfStudent(List<Course> courseList, String semester){
        FileWriter csvWriter;
        try {
            csvWriter = new FileWriter("reports/"+semester+".csv");
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
            e.printStackTrace();
        }
    }
}
