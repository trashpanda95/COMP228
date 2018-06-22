/*
 * Created By: Brian Au
 * Student No.: 300962933
 * Course: COMP228
 * Test 1
 * Driver Class
 * 22 JUN 2018
 */

import javax.swing.JOptionPane;
public class Driver {
    public static void main (String [] args){
        Integer selection = 0;
        selection = Integer.parseInt(JOptionPane.showInputDialog("What type of Movie? \n1. Action Movie\n2. ComedyMovie"));
        if (selection == 1) {
            // Create Instance variable of type ActionMovie with User Inputs
            Movie newMovie = new ActionMovie(JOptionPane.showInputDialog("Title of the Movie: "), JOptionPane.showInputDialog("Studio Name: "), JOptionPane.showInputDialog("Lead Actor's Name: "), Double.parseDouble(JOptionPane.showInputDialog("Movie Budget: ")), Integer.parseInt(JOptionPane.showInputDialog("Year of Release: ")));

            // Displays the Movie Information
            JOptionPane.showMessageDialog(null,newMovie.toString() + "\nGenre: "+newMovie.getGenre(), "Movie Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (selection == 2) {
            // Create Instance variable of type ComedyMovie with User Inputs
            Movie newMovie = new ComedyMovie(JOptionPane.showInputDialog("Title of the Movie: "), JOptionPane.showInputDialog("Studio Name: "), JOptionPane.showInputDialog("Lead Actor's Name: "), Double.parseDouble(JOptionPane.showInputDialog("Movie Budget: ")), Integer.parseInt(JOptionPane.showInputDialog("Year of Release: ")));

            // Displays the Movie Information
            JOptionPane.showMessageDialog(null,newMovie.toString() + "\nGenre: "+newMovie.getGenre(), "Movie Information", JOptionPane.INFORMATION_MESSAGE);
        }


    }
}
