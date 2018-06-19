package exercise3;
/*
 * Centennial College
 * Created By: Brian Au
 * Student No.: 300962933
 * COMP 228 - Java Programming - Lab 03 / Assignment 3
 * Exercise 3
 *
 * Due: JUN/17/2018
 */
import javax.swing.JOptionPane;
public class ProcessMortgage {

    public static void main (String [] args)
    {
        Mortgage [] mortgages = new Mortgage[3];
        Double currentInterestRate = Double.parseDouble(JOptionPane.showInputDialog("Current Interest Rate (ie. 1% = 0.01): "));
        int mortgageTypeSelection = 0;

        // Populate the Mortgage Array
        for (int i = 0; i < 3; i++)
        {
            // Get User's input on Mortgage Type
            mortgageTypeSelection = Integer.parseInt(JOptionPane.showInputDialog("Select Mortgage Type: \n1. Personal Mortgage\n2. Business Mortgage"));

            // Personal Mortgage
            if (mortgageTypeSelection == 1){
                mortgages[i] = new PersonalMortgage(JOptionPane.showInputDialog("Client Name: "),Double.parseDouble(JOptionPane.showInputDialog("Mortgage Amount (Max. $300,000): ")),
                                        currentInterestRate, Integer.parseInt(JOptionPane.showInputDialog("Enter Mortgage Term Length By Years: ")));

            // Business Mortgage
            } else if (mortgageTypeSelection == 2){
                mortgages[i] = new BusinessMortgage(JOptionPane.showInputDialog("Client Name: "),Double.parseDouble(JOptionPane.showInputDialog("Mortgage Amount (Max. $300,000): ")),
                                        currentInterestRate, Integer.parseInt(JOptionPane.showInputDialog("Enter Mortgage Term Length By Years: ")));
            }
            // Debugger
            System.out.println("Interest: "+mortgages[i].getInterestRate());
            System.out.println("Amount: "+mortgages[i].getMortgageTotalAmount());
            System.out.println("Term: "+mortgages[i].getMortgageTerm());
        }

        // Used to store cancatenated mortgage information
        String allMortgageData = "";

        // Concatentate Mortgage Data into one String
        for (Mortgage currentMortgages : mortgages){
            allMortgageData += currentMortgages.getMortgageInfo();
            allMortgageData += "Mortgage Type: "+ currentMortgages.getClass().getName();
            allMortgageData += "\n"+"\n"; // Creates a spacing between the data
        }

        // Display all the data on JOptionPane GUI
        JOptionPane.showMessageDialog(null,allMortgageData,"Current Mortgage Data",JOptionPane.INFORMATION_MESSAGE);
    }
}
