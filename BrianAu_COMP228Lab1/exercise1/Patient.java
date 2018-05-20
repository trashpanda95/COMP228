package exercise1;/*
 *
 * Centennial College
 * Created By: Brian Au
 * Student No.: 300962933
 * COMP 228 - Java Programming - Lab 01 / Assignment 1
 * Exercise 1
 *
 * Due: May/20/2018
 */

import javax.swing.JOptionPane;
public class Patient {

    // Variable Declarations
    private int id;
    private String fName, lName, address, city, province, postalCode;

    // Multiple Argument Constructor
    public Patient (int id, String first, String last, String address, String city, String prov, String postal)
    {
        this.id = id;
        this.fName = first;
        this.lName = last;
        this.address = address;
        this.city = city;
        this.province = prov;
        this.postalCode = postal;
    }

    // Default Constructor
    public Patient ()
    {
    }

    // Getter Methods for exercise1.Patient
    public int getID(){ return this.id; }
    public String getFirstName(){ return this.fName; }
    public String getLastName(){ return this.lName; }
    public String getAddress(){ return this.address; }
    public String getCity(){ return this.city; }
    public String getProvince(){ return this.province; }
    public String getPostalCode(){ return this.postalCode; }

    // Setter Methods for exercise1.Patient
    public void setID (int id) { this.id = id; }
    public void setfName (String newFirst) { this.fName = newFirst; }
    public void setlName (String newLast) { this.lName = newLast; }
    public void setAddress (String newAddress) { this.address = newAddress; }
    public void setCity (String newCity) { this.city = newCity; }
    public void setProvince (String newProv) { this.province = newProv; }
    public void setPostalCode (String newPostal) { this.postalCode = newPostal; }

    // Organizing exercise1.Patient's Data
    public String getPatientInfo ()
    {
        String patientInfo;
        patientInfo = ("exercise1.Patient ID: " + this.getID() + "\nFirst Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() + "\nAddress: " + this.getAddress() + "\nCity: " + this.getCity() + "\nProvince: " + this.getProvince() + "\nPostal Code: " + this.getPostalCode());
        return (patientInfo);
    }

    // Driver Class
    public static void main(String[] args)
    {
        String patientInformation;

        // Variable Declaration & Store User Inputted Data
        int id = Integer.parseInt(JOptionPane.showInputDialog("exercise1.Patient's ID: "));
        String firstName = JOptionPane.showInputDialog("exercise1.Patient's First Name: ");
        String lastName = JOptionPane.showInputDialog("exercise1.Patient's Last Name: ");
        String address = JOptionPane.showInputDialog("exercise1.Patient's Current Address: ");
        String city = JOptionPane.showInputDialog("exercise1.Patient's Residing City: ");
        String province = JOptionPane.showInputDialog("exercise1.Patient's Residing Province: ");
        String postal = JOptionPane.showInputDialog("exercise1.Patient's Postal Code: ");

        // Create firstPatient with User Inputted Data
        Patient firstPatient = new Patient (id,firstName,lastName,address,city,province,postal);

        // Get the exercise1.Patient's data
        patientInformation = firstPatient.getPatientInfo();

        // Display exercise1.Patient's Data
        JOptionPane.showMessageDialog(null, patientInformation, "exercise1.Patient Records",JOptionPane.INFORMATION_MESSAGE);

        // Changes to exercise1.Patient's Data [ first & last Name)
        firstName = JOptionPane.showInputDialog("Update First Name: ");
        lastName = JOptionPane.showInputDialog("Update Last Name: ");

        // Update exercise1.Patient's Data
        firstPatient.setfName(firstName);
        firstPatient.setlName(lastName);

        // Display Updated Name
        JOptionPane.showMessageDialog(null, firstPatient.getFirstName(), "Updated First Name",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, firstPatient.getLastName(), "Updated Last Name",JOptionPane.INFORMATION_MESSAGE);

        // Changes to the Other Fields
        address = JOptionPane.showInputDialog("Update Address: ");
        city = JOptionPane.showInputDialog("Update City: ");
        province = JOptionPane.showInputDialog("Update Province: ");
        postal = JOptionPane.showInputDialog("Update Postal Code: ");

        // Update exercise1.Patient's Data
        firstPatient.setAddress(address);
        firstPatient.setCity(city);
        firstPatient.setProvince(province);
        firstPatient.setPostalCode(postal);

        // Display updated information
        patientInformation = firstPatient.getPatientInfo();
        JOptionPane.showMessageDialog(null, patientInformation, "Updated exercise1.Patient Records",JOptionPane.INFORMATION_MESSAGE);
    }
}
