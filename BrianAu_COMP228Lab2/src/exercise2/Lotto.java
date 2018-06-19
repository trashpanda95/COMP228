package exercise2;
/*
 * Centennial College
 * Created By: Brian Au
 * Student No.: 300962933
 * COMP 228 - Java Programming - Lab 02 / Assignment 2
 * Exercise 2
 *
 * Due: Jun/03/2018
 */

import javax.swing.JOptionPane;

public class Lotto {

    // Variable Declarations
    private Integer lottoArray [];

    // exercise2.Lotto Constructor
    public Lotto ()
    {
        // Variable Initialization
        lottoArray = new Integer [3];

        // Populate Array with Random Values ( 1 -> 9 )
        for (int i = 0; i < 3; i ++)
        {
            lottoArray[i] = (int)(Math.random()* 9) + 1;

            // Debugger
            System.out.println ("Random Number "+ i +": "+lottoArray[i]);
        }
    }

    // Getter Method -> Returns lottoArray
    public Integer [] getLottoArray () { return this.lottoArray; }

    // Calculate the sum of the lottoSum
    private Integer calculateLottoSum (Integer [] lottoArray)
    {
        int lottoSum = lottoArray[0] + lottoArray[1] + lottoArray [2];
        return lottoSum;
    }

    // Randomizes the Array Values
    private Integer [] randomizeArray (Integer [] array)
    {
        // Populate Array with Random Values ( 1 -> 9 )
        for (int i = 0; i < 3; i ++)
        {
            array[i] = (int)(Math.random()* 8) + 1;

            // Debugger
            System.out.println ("Random Number "+ i +": "+array[i]);
        }
        return array;
    }

    // exercise2.Lotto Game Simulation
    private void lottoGame ()
    {
        // Local Variable Declaration & Initialization
        int numGame = 0;
        boolean correctGuess = false;
        int lottoSum;
        int userLotto;

        while ((numGame != 5) && (correctGuess == false))
        {
            // Increment Game Number
            numGame ++;

            // Calculate the Sum of the exercise2.Lotto
            lottoSum = calculateLottoSum(getLottoArray());

            // Debugger
            System.out.println("Calculated Sum: "+lottoSum);

            // Gather User's Guess
            userLotto = Integer.parseInt(JOptionPane.showInputDialog("Choose a number between 3 and 27"));

            if (userLotto == lottoSum)
                correctGuess = true;

            // Creates a new set of values for the array
            this.lottoArray = randomizeArray(this.lottoArray);
        }

        if (correctGuess == true)
        {
            JOptionPane.showMessageDialog(null, "You Won! You've Guessed the Correct Number!", "exercise2.Lotto Game Results", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "You Lost! You've Guessed the Incorrect Number 5 Times.", "exercise2.Lotto Game Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void runGame () { this.lottoGame(); }
}
