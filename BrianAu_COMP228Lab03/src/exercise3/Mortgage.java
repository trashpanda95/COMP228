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
import javax.swing.JOptionPane;
public class Mortgage implements MortgageConstants {

    // Variable Declarations
    private static int id = 1;      // ID Counter
    private int mortgageID;
    private String custName;
    private Double mortgageAmount;
    private Double interestRate;
    private Double mortgageTotalAmount;
    private int mortgageTerm;

    // Constructor Mortgage
    public Mortgage (String name, Double amount, Double interest, int term){

        // Debugger
        System.out.println(this.id);

        // Variable Initialization
        this.mortgageID = this.id;
        this.custName = name;
        this.mortgageAmount = amount;
        this.interestRate = interest;
        this.mortgageTerm = term;

        // Update the id counter
        this.id ++;

        // Debugger
        System.out.println(this.id);

        // Check if the Term Length is Valid
        this.checkMortgageTerm();

        // Check if the Mortgage Amount is Allowed
        this.checkMortgageAmount();

        // Calculate and Store the Total Mortgage Amount with Interest Added
        this.mortgageTotalAmount = calculateTotalMortgage();
    }

    // Checks if the mortgage Amount goes over $300,000
    private void checkMortgageAmount (){
        if (this.mortgageAmount > this.maximumMortgageAmount)
        {
            JOptionPane.showMessageDialog(null,"ERROR: Exceeded Maximum Amount of $300,000.00. Amount Set to $300,000.00");
            this.setMortgageAmount(this.maximumMortgageAmount);
        }
    }

    // Checks the Term of the Mortgage
    private void checkMortgageTerm (){
        if (this.mortgageTerm > this.longTerm){                                                         // Term Exceeds the Maximum of 5 Years
            JOptionPane.showMessageDialog(null,"ERROR: Exceeded Maximum Term Length Allowed. Rounding down to the nearest Term Length. (5Years).");
            this.setMortgageTerm(this.longTerm);
        } else if ((this.mortgageTerm > this.mediumTerm) && (this.mortgageTerm < this.longTerm)) {      // Term is in between Medium & Long Term Length, Round Down to Medium Term
            JOptionPane.showMessageDialog(null,"ERROR: Incorrect Term Option. Rounding down to the nearest Term Length. (3 Years).");
            this.setMortgageTerm(this.mediumTerm);
        } else if ((this.mortgageTerm > this.shortTerm) && (this.mortgageTerm < this.mediumTerm)){      // Term is in between Short & Medium Term Length, Round Down to Short Term
            JOptionPane.showMessageDialog(null,"ERROR: Incorrect Term Option. Rounding down to the nearest Term Length. (1 Year).");
            this.setMortgageTerm(this.shortTerm);
        } else if (this.mortgageTerm < shortTerm) {                                                                                        // Term is not a Valid Term Length, Changed the Term Length to Default (Short)
            JOptionPane.showMessageDialog(null,"ERROR: Invalid Term Length Entered. Defaulting to Short-Term Length (1 Year).");
            this.setMortgageTerm(this.shortTerm);
        }
    }

    // Calculates the Total Amount of Mortgage with Interest Included
    private Double calculateTotalMortgage ()
    {
        // Debugger
        System.out.println((this.getMortgageAmount() * this.getInterestRate())+this.getMortgageAmount());
        System.out.println("Mortgage * Interest: "+(this.getMortgageAmount() * this.getInterestRate()));
        return ((this.getMortgageAmount() * this.getInterestRate())+this.getMortgageAmount());
    }

    // Returns a String that contains all the Mortgage Information
    public String getMortgageInfo(){

        return ("Bank Name: "+this.bankName+"\nMortgage ID: "+this.getMortgageID() +"\nClient's Name: "+this.getCustName()
                + "\nMortgage Term: "+this.getMortgageTerm() +"\nInterest Rate: "+this.getInterestRate()
                + "\nMortgage Initial Amount: $"+String.format("%.2f%n",getMortgageAmount()) +"Total Amount Owed: $"+String.format("%.2f%n",getMortgageTotalAmount()));
    }


    // Getter Methods
    public int getMortgageID() { return this.mortgageID; }
    public String getCustName() { return this.custName; }
    public Double getMortgageAmount() { return this.mortgageAmount; }
    public Double getInterestRate() { return this.interestRate; }
    public int getMortgageTerm() { return this.mortgageTerm; }
    public Double getMortgageTotalAmount() { return this.mortgageTotalAmount; }


    // Setter Methods
    public void setCustName(String custName) { this.custName = custName; }
    public void setMortgageAmount(Double newAmount) { this.mortgageAmount = newAmount; this.updateMortgageTotal(); }   // Updates the Total Mortgage Cost as well
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; this.updateMortgageTotal(); } // Updates the Interest Rate & Total Mortgage Cost as well
    public void setMortgageTerm(int mortgageTerm) { this.mortgageTerm = mortgageTerm; }

    // Used to Update the total of the Mortgage after Interest Rate  OR  Mortgage Amount is changed
    private void updateMortgageTotal()
    {
        this.mortgageTotalAmount = this.calculateTotalMortgage();
    }
}
