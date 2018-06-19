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
public class BusinessMortgage extends Mortgage {

    // Constructor
    public BusinessMortgage (String name, Double amount, Double interest, int term){
        super(name, amount, interest, term);
        super.setInterestRate(0.01);    // Set Interest Rate to 1%
    }
}
