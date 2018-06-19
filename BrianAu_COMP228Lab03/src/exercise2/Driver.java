package exercise2;
/*
 * Centennial College
 * Created By: Brian Au
 * Student No.: 300962933
 * COMP 228 - Java Programming - Lab 03 / Assignment 3
 * Exercise 2
 *
 * Due: JUN/17/2018
 */
import javax.swing.JOptionPane;
public class Driver {
    public static void main (String [] args)
    {
        int userChoice = 0;
        String userName;
        String userStatus = "";
        userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter the option number: "+"\n1. Full-Time Student\n2. Part-Time Student"));
        userName = JOptionPane.showInputDialog("Enter Student Name: ");

        if (userChoice == 1){

            // Variable Declaration and Initialization
            FullTimeStudent student = new FullTimeStudent(userName);

            // Get Status of Student
            if (student.getStatus())
                userStatus = "Full-Time";

            // Display the information
            JOptionPane.showMessageDialog(null,"Student Name: "+student.getName()+"\nStatus: "+userStatus+"\nTuition Total: "+ student.determineTuition(),"Student Information",JOptionPane.INFORMATION_MESSAGE);
        } else if (userChoice == 2){

            // Gather User Information for Credit Hours taken for Part-Time Students only
            int creditHours = Integer.parseInt(JOptionPane.showInputDialog("Enter the total amount of Credit Hours: "));

            // Variable Declaration and Initialization
            PartTimeStudent student = new PartTimeStudent(userName, creditHours);

            // Get Status of Student
            if (!student.getStatus())
                userStatus = "Part-Time";

            // Display the information
            JOptionPane.showMessageDialog(null,"Student Name: "+student.getName()+"\nStatus: "+userStatus+"\nTuition Total: "+ student.determineTuition(),"Student Information",JOptionPane.INFORMATION_MESSAGE);
        }


    }
}
