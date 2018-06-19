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
public class PartTimeStudent extends Student {

    // Variable Declarations
    private int creditHours;
    private Double tuitionFee;

    // Constructor
    public PartTimeStudent (String name, int creditHours)
    {
        super (false, name);

        // Initialize Variables
        this.creditHours = creditHours;
        this.tuitionFee = 100.00;
    }

    // Getter method
    public Double getTuitionFee() { return this.tuitionFee; }

    // Setter method
    public void setTuitionFee (Double newFee){ this.tuitionFee = newFee; }

    // Calculate Tutition Costs
    public Double determineTuition()
    {
        return (this.creditHours * this.tuitionFee);
    }
}
