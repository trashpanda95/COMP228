package exercise1;

/*
 * Centennial College
 * Created By: Brian Au
 * Student No.: 300962933
 * COMP 228 - Java Programming - Lab 03 / Assignment 3
 * Exercise 1
 *
 * Due: JUN/17/2018
 */
import javax.swing.JOptionPane;
public class Driver {
    public static void main (String [] args)
    {
        int insuranceSelection = 0;
        Double monthlyCost = 0.00;
        Insurance [] allInsurances = new Insurance [5];

        for (int i = 0; i < 5; i++) {

            // Gather Insurance Type from User
            insuranceSelection = Integer.parseInt(JOptionPane.showInputDialog("Pick from the Following Selection: \n1. Health Insurance\n2. Life Insurance"));

            // Gather Monthly Cost from User
            monthlyCost = Double.parseDouble(JOptionPane.showInputDialog("Monthly Cost: "));

            // Decide on which Insurance to make an instance of
            if (insuranceSelection == 1){
                allInsurances[i] = new Health(monthlyCost);
            } else if (insuranceSelection == 2){
                allInsurances [i] = new Life (monthlyCost);
            }
        }

        String allInsuranceInfo = "";
        for ( Insurance currentInsurances : allInsurances) {


            if (currentInsurances instanceof Health)
            {
                Health healthInsurance = (Health) currentInsurances;    // Casting
                healthInsurance.setMonthlyCost(95.00);          // Set Amount for Health Insurance
            } else if (currentInsurances instanceof Life) {
                Life lifeInsurance = (Life) currentInsurances; // Casting
                lifeInsurance.setInsuranceCost(125.00);         // Set Amount for Life Insurance
            }
            allInsuranceInfo += currentInsurances.displayInfo() + "\n";
        }
        JOptionPane.showMessageDialog(null,allInsuranceInfo,"Insurance Information",JOptionPane.INFORMATION_MESSAGE);
    }
}
