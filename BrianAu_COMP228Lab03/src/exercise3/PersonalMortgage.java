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
public class PersonalMortgage extends Mortgage {

    // Constructor
    public PersonalMortgage (String name, Double amount, Double interest, int term){
        super(name, amount, interest, term);
        super.setInterestRate(0.02);        // Sets the Interest Rate to 2%
    }
}
