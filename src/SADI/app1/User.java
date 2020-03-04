package SADI.app1;


import SADI.app1.list.StudentEnrolmentList;

import java.util.Scanner;

public class User {

    private Scanner userInput = new Scanner(System.in);
    private StudentEnrolmentList enrolmentList = StudentEnrolmentList.getInstance();

    public void Use() {
        String choice;
        label:
        while (true) {
            System.out.print("Type 1 enrol student \n" +
                    "Type 2 to show all enrolment\n" +
                    "Type 3 to show an enrolment \n" +
                    "Type 4 to delete enrolment \n" +
                    "Type 5 to show enrolments of a student \n"+
                    "Type 6 to show enrolments in 1 semester \n"+
                    "Type 0 to exit \n"+
                    "Choice:");
            choice = userInput.nextLine();
            switch (choice) {
                case "0":
                    break label;
                case "1":
                    enrolmentList.add();
                    break;
                case "2":
                    enrolmentList.showAll();
                    break;
                case "3":
                    enrolmentList.showOne();
                    break;
                case "4":
                    enrolmentList.delete();
                    break;
                case "5":
                    enrolmentList.showByStudent();
                default:
                    System.out.println("Invalid number please type again");
                    break;
            }
        }
    }
}
