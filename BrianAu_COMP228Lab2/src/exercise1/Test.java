package exercise1;
/*
 * Centennial College
 * Created By: Brian Au
 * Student No.: 300962933
 * COMP 228 - Java Programming - Lab 02 / Assignment 2
 * Exercise 1
 *
 * Due: Jun/03/2018
 */

import javax.swing.JOptionPane;
import java.util.Random;
public class Test {

    // Variable Declarations
    private String [] correctAns;
    private String [][] questions;

    // Constructor Test
    public Test ()
    {
        // Initialize Variables
        questions = new String [5][5];      // 5 Questions, 1 Question + 4 Answers
        correctAns = new String[5];

        // Setting up the Questions
        questions[0][0] = "1. What data type cannot be promoted to a 'Higher Type'?";                                                                   // Q1
        questions[1][0] = "2. _____________ provides a layer of security in accessing and modifying ___________ instance variables";                    // Q2
        questions[2][0] = "3. ____________ cannot return a value.";                                                                                     // Q3
        questions[3][0] = "4. A _____________ converts a argument value (if possible) to the type that the parameter expects to receive";               // Q4
        questions[4][0] = "5. A _____________ is a class that can have a reference to objects of other classes as members;";                            // Q5

        // Setting up the index for the correct answer
        correctAns[0] = "a"; correctAns[1] = "c"; correctAns[2] = "a"; correctAns[3] = "b"; correctAns[4] = "d";

        // Setting up the Answers per Question
        // Q1
        questions[0][1] = "a. Double"; questions[0][2] = "b. Boolean"; questions[0][3] = "c. String"; questions[0][4] = "d. Float";
        // Q2
        questions[1][1] = "a. No Modifier, Private"; questions[1][2] = "b. Protected Methods, Public"; questions[1][3] = "c. Public Methods, Private"; questions[1][4] = "d. Private Methods, Private";
        // Q3
        questions[2][1] = "a. Constructors"; questions[2][2] = "b. Protected Methods"; questions[2][3] = "c. Exceptions"; questions[2][4] = "d. Methods";
        // Q4
        questions[3][1] = "a. Positive Promotion"; questions[3][2] = "b. Argument Promotion"; questions[3][3] = "c. Promotion Rules"; questions[3][4] = "d. All of the Above";
        // Q5
        questions[4][1] = "a. Public Methods"; questions[4][2] = "b. Garbage Collector"; questions[4][3] = "c. Decomposition"; questions[4][4] = "d. Composition";
    }

    // Turns the Question Array into a readable String for Display
    private String arrayToString (String [] text)
    {
        // Local Variable Declaration
        String newString;

        // Format String
        newString = text[0] + "\n" + text[1] + "\n" + text[2] + "\n" + text[3] + "\n" + text[4];

        // Return the new String
        return newString;
    }

    // Generates a Message
    private String generateMessage (boolean isCorrect)
    {
        Random randNum = new Random ();
        String message = "";
        if (isCorrect){
            switch (randNum.nextInt(4)) {
                case 0:
                    message = "Very Good!";
                    break;
                case 1:
                    message = "Keep up the Good Work!";
                    break;
                case 2:
                    message = "Excellent!";
                    break;
                case 3:
                    message = "Nice Work!";
                    break;
            }
        } else {
            switch (randNum.nextInt(4)) {
                case 0:
                    message = "No. Please Try Again";
                    break;
                case 1:
                    message = "Wrong. Try Once More.";
                    break;
                case 2:
                    message = "Don't Give Up!";
                    break;
                case 3:
                    message = "No. Keep Trying!";
                    break;
            }
        }
        return message;
    }

    // Gathers the Input from User
    private String inputAnswer (int questionNumber)
    {
        // Display Question
        String input = JOptionPane.showInputDialog(this.arrayToString(questions[questionNumber])+"\nAnswer: ");

        // Debugger
        System.out.println(input);

        // Returns the Input
        return input;
    }

    // Checks the Answer and returns a Bool value
    private boolean checkAnswer (String iAnswer, int questionNum)
    {
        // Debugger
        System.out.println("User: "+iAnswer+"|| System: "+this.correctAns[questionNum]);

        // Checks if User Answer is the Correct Answer
        if (iAnswer.contentEquals(this.correctAns[questionNum]))
        {
            return true;
        } else {
            return false;
        }
    }

    // Simulates the Questions for the Test
    private void simulateQuestion()
    {
        // Local Variable Declarations
        String userAnswer;
        boolean isCorrect;
        int questionNumber = 0;
        int numberCorrect = 0;
        int testScore;

        while (questionNumber < 5) {

            // Gather User's Answer
            userAnswer = inputAnswer(questionNumber);

            // Check if the Answer is correct
            isCorrect = checkAnswer(userAnswer, questionNumber);

            // Debugger
            System.out.println(isCorrect);

            // Display Message to User
            JOptionPane.showMessageDialog(null,generateMessage(isCorrect),"Test",JOptionPane.INFORMATION_MESSAGE);

            // If the Answer is correct, increment total Correct
            if (isCorrect)
                numberCorrect++;

            // Increment Question number to display next question
            questionNumber++;
        }

        // Calculate the Test Score
        testScore = (numberCorrect * 100) / 5;

        // Debugger
        System.out.println(testScore);

        // Display Test Results
        JOptionPane.showMessageDialog(null, "Correct Answers: "+numberCorrect+"\nIncorrect Answers: "+(5-numberCorrect)+"\nTest Score: "+testScore+"%", "Test Score", JOptionPane.INFORMATION_MESSAGE);

    }

    // Method to Start the Test -> calls simulateQuestion
    public void startTest () { simulateQuestion(); }
}
