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
public abstract class Student {

    // Variable Declaration
    public boolean fulltimeStatus;
    private String studentName;


    public Student (boolean status, String studentName)
    {
        this.fulltimeStatus = status;
        this.studentName = studentName;
    }


    public boolean getStatus(){ return this.fulltimeStatus; }
    public void setStatus (boolean status) { this.fulltimeStatus = status; }
    public String getName(){ return this.studentName; }
    public abstract Double determineTuition();

}
