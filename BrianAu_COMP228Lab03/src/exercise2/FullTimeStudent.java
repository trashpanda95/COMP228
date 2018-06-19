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
public class FullTimeStudent extends Student
{
    // Variable Declaration
    private Double tuitionFee;

    // Constructor
    public FullTimeStudent (String name)
    {
        super (true,name);

        // Initialize TutitionFee
        this.tuitionFee = 2000.00;
    }


    // Getter method
    public Double getTuitionFee (){ return this.tuitionFee; }

    // Setter method
    public void setTuitionFee (Double newFee) { this.tuitionFee = newFee; }

    // Calculate Tutition Cost
    public Double determineTuition()
    {
        return this.getTuitionFee();
    }
}
