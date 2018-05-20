package exercise2;/*
 *
 * Centennial College
 * Created By: Brian Au
 * Student No.: 300962933
 * COMP 228 - Java Programming - Lab 01 / Assignment 1
 * Exercise 2
 *
 * Due: May/20/2018
 */

import javax.swing.JOptionPane;
public class BankAccount {

    // Variable Declarations
    private int accountNumber;
    private String clientName;
    private double currentBalance;
    private static int idCounter = 1;

    // Constructor
    public BankAccount (String name, double balance)
    {
        this.accountNumber = idCounter ++;
        this.clientName = name;
        this.currentBalance = balance;
    }

    // Setter Methods
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }
    public void setClientName (String name){ this.clientName = name; }
    public void setCurrentBalance (double newBalance) { this.currentBalance = newBalance; }

    // Getter Methods
    public int getAccountNumber () { return this.accountNumber; }
    public String getClientName () { return this.clientName; }
    public double getCurrentBalance () { return this.currentBalance; }


    // Method for Depositing Funds into Account
    public void depositFunds (double amount)
    {
        double balance = this.getCurrentBalance();
        this.setCurrentBalance(balance+amount);
    }

    // Method for Withdrawing Funds from Account
    public void withdrawFunds (double amount)
    {
        double balance = this.getCurrentBalance();
        this.setCurrentBalance(balance-amount);
    }

    public String getAccountInfo ()
    {
        return ("Account Number: "+this.getAccountNumber()+"\nClient's Name: "+this.getClientName()+"\nCurrent Balance: $"+this.getCurrentBalance());
    }

    // Driver Class
    public static void main(String[] args)
    {
        String accountInfo;
        Double amount;
        // Variable Declaration & Store User Inputted Data
        String firstName = JOptionPane.showInputDialog("Client's First Name: ");
        String lastName = JOptionPane.showInputDialog("Client's Last Name: ");
        String clientName = firstName + " " + lastName;
        Double balance = Double.parseDouble(JOptionPane.showInputDialog("Current Balance: "));


        // Create firstAccount with User Inputted Data
        BankAccount firstAccount = new BankAccount (clientName, balance);


        // Withdraw some Funds from Account
        amount = Double.parseDouble(JOptionPane.showInputDialog("Withdraw Amount: "));
        firstAccount.withdrawFunds(amount);

        // Display Updated Balance
        JOptionPane.showMessageDialog(null, firstAccount.getCurrentBalance(), "Updated Balance",JOptionPane.INFORMATION_MESSAGE);

        // Deposit some Funds into Account
        amount = Double.parseDouble(JOptionPane.showInputDialog("Deposit Amount: "));
        firstAccount.depositFunds(amount);

        // Display Updated Balance
        JOptionPane.showMessageDialog(null, firstAccount.getCurrentBalance(), "Updated Balance",JOptionPane.INFORMATION_MESSAGE);

        // Change Client's Name
        firstName = JOptionPane.showInputDialog("New First Name: ");
        lastName = JOptionPane.showInputDialog("New Last Name: ");
        clientName = firstName + " " + lastName;

        // Update Client's Name
        firstAccount.setClientName(clientName);

        // Display Updated Name
        JOptionPane.showMessageDialog(null, firstAccount.getClientName(), "Updated Name",JOptionPane.INFORMATION_MESSAGE);


        // Get the Client's data
        accountInfo = firstAccount.getAccountInfo();

        // Display Client's Data
        JOptionPane.showMessageDialog(null, accountInfo, "Client's Account Records",JOptionPane.INFORMATION_MESSAGE);

    }
}
