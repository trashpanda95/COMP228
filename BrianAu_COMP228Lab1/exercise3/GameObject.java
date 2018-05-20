package exercise3;/*
 *
 * Centennial College
 * Created By: Brian Au
 * Student No.: 300962933
 * COMP 228 - Java Programming - Lab 01 / Assignment 1
 * Exercise 3
 *
 * Due: May/20/2018
 */

import javax.swing.JOptionPane;
public class GameObject {

    // Variable Declarations
    private String center,state;
    private double velo;
    private double rotation;


    public GameObject (double x, double y, double velocity, String state, double rotation)
    {
        // Variable Initializations
        this.center = "("+x+", "+y+")";
        this.velo = velocity;
        this.state = state;
        this.rotation = rotation;
    }

    // Setter Methods
    public void setCenter (double x, double y) { this.center= "("+x+", "+y+")"; }
    public void setState (String state) { this.state = state; }
    public void setVelo (double velocity) { this.velo = velocity; }
    public void setRotation (double rotation) { this.rotation = rotation; }

    // Getter Methods
    public String getCenter () { return this.center; }
    public String getState () { return this.state; }
    public double getVelo () { return this.velo; }
    public double getRotation () { return this.rotation; }

    public String getGameObject ()
    {
        return "Center: "+this.getCenter()+"\nState: "+this.getState()+"\nVelocity: "+this.getVelo()+"\nRotation: "+this.getRotation();
    }
    // Driver Class
    public static void main(String[] args)
    {
        // Declare exercise3.GameObject game
        GameObject game;

        // Declare Locals and Store User Input
        double x = Double.parseDouble(JOptionPane.showInputDialog("Center X Coordinate: "));
        double y = Double.parseDouble(JOptionPane.showInputDialog("Center Y Coordinate: "));
        String currentState = JOptionPane.showInputDialog("Current State (Alive/Dead): ");
        double currentVelocity = Double.parseDouble(JOptionPane.showInputDialog("Current Velocity: "));
        double currentRotation = Double.parseDouble(JOptionPane.showInputDialog("Current Rotation "));

        // Initialize exercise3.GameObject game
        game = new GameObject(x,y,currentVelocity,currentState,currentRotation);

        // Display Initialized Game Object
        JOptionPane.showMessageDialog(null,game.getGameObject(),"Game Object Data",JOptionPane.INFORMATION_MESSAGE);

        // Update Center Coordinates
        x = Double.parseDouble(JOptionPane.showInputDialog("New Center X Coordinate: "));
        y = Double.parseDouble(JOptionPane.showInputDialog("New Center Y Coordinate: "));

        // Update game Center Coordinate
        game.setCenter(x,y);
        JOptionPane.showMessageDialog(null,game.getCenter(),"Updated Center Coordinate",JOptionPane.INFORMATION_MESSAGE);

        // Update Velocity
        currentVelocity = Double.parseDouble(JOptionPane.showInputDialog("Current Velocity: "));
        game.setVelo(currentVelocity);

        //Display Changes
        JOptionPane.showMessageDialog(null,game.getVelo(),"Updated Velocity",JOptionPane.INFORMATION_MESSAGE);

        // Update State
        currentState = JOptionPane.showInputDialog("Current State (Alive/Dead): ");
        game.setState(currentState);

        // Display Changes
        JOptionPane.showMessageDialog(null,game.getState(),"Updated State",JOptionPane.INFORMATION_MESSAGE);

        // Update Rotation
        currentRotation = Double.parseDouble(JOptionPane.showInputDialog("Current Rotation "));
        game.setRotation(currentRotation);

        // Display Changes
        JOptionPane.showMessageDialog(null,game.getRotation(),"Updated Rotation",JOptionPane.INFORMATION_MESSAGE);

        // Display Updated exercise3.GameObject Data
        JOptionPane.showMessageDialog(null,game.getGameObject(),"Updated exercise3.GameObject",JOptionPane.INFORMATION_MESSAGE);
    }
}
