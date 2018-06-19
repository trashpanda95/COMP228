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


public class Health extends Insurance {

    // Constructor
    public Health()
    {
        super("Health", 30.00);
    }
    public Health(Double cost)
    {
        super("Health", cost);
    }
    // Constructor w/ Params
    public Health(String type, Double cost)
    {
        super(type, cost);
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
