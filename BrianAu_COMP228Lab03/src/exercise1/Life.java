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


public class Life extends Insurance {

    // Constructor
    public Life()
    {
        super("Life", 35.00);
    }

    // Constructor w/ Params
    public Life(Double cost)
    {
        super("Life", cost);
    }

    // Override OG setInsuranceCost
    @Override
    public void setInsuranceCost(Double cost) { this.setMonthlyCost(cost); }


    // Override OG displayInfo
    @Override
    public String displayInfo() {
        return("Type: "+this.getClass().getName()+"\nMonthly Cost: $"+String.format("%.2f%n",this.getMonthlyCost()));
    }
}
