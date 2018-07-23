/*
 * Created By: Brian Au
 * Student ID: 300962933
 * S2018 - COMP 228 - Programming 2 - Assignment 4 - Lab04
 * Wallace Balaniuc
 *
 */

package exercise1;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame{
    private JButton btnConfirm;
    private JLabel lblName, lblAddress, lblProvince, lblCity, lblPostalCode, lblPhone, lblEmail;
    private JTextField txtName, txtAddress, txtProvince, txtCity, txtPostalCode, txtPhone, txtEmail;

    private JRadioButton radBusinessProgram, radSoftwareProgram;
    private JCheckBox cbStudentCouncil, cbVolunteerWork;
    private DefaultListModel <String> displayCourses,displayInformation;
    private JList<String> displayC, displayData;
    private static JComboBox<String> courses;
    private static final String [] emptyCourses = {"","","","","",""};

    // JPanels
    private JPanel pTextBoxes,pCheckBoxes, pRight, pDisplay,pRadioButtons;

    // Constructor for GUI
    public GUI (){
        super("COMP 228 - Lab 04 - Assignment 4");

        // Initializing the Stages
        this.pTextBoxes = new JPanel();
        this.pCheckBoxes = new JPanel();
        this.pRight = new JPanel();
        this.pDisplay = new JPanel();
        this.pRadioButtons = new JPanel();

        this.pTextBoxes.setLayout(new GridLayout(7,2,1,1));
        this.pCheckBoxes.setLayout(new GridLayout(7,1,1,1));
        this.pRadioButtons.setLayout(new GridLayout(1,2,1,1));
        this.pRight.setLayout(new GridLayout(7,2,1,1));
        this.pDisplay.setLayout(new GridLayout(2,1,1,1));

        // Initialize CourseJList
        this.courses = new JComboBox<String>(emptyCourses);

        this.displayCourses = new DefaultListModel<>();
        this.displayInformation = new DefaultListModel<>();
        // Initialize Text Fields
        this.txtName = new JTextField(20);
        this.txtAddress = new JTextField(20);
        this.txtProvince = new JTextField(20);
        this.txtCity = new JTextField(15);
        this.txtPostalCode = new JTextField(7);
        this.txtPhone = new JTextField(10);
        this.txtEmail = new JTextField(20);

        // Initialize Labels
        this.lblName = new JLabel("Name: ");
        this.lblAddress = new JLabel("Address: ");
        this.lblProvince = new JLabel("Province: ");
        this.lblCity = new JLabel("City: ");
        this.lblPostalCode = new JLabel("Postal Code: ");
        this.lblPhone = new JLabel("Phone: ");
        this.lblEmail = new JLabel("Email: ");

        // Initialize Radio Buttons
        this.radBusinessProgram = new JRadioButton("Business");
        this.radSoftwareProgram = new JRadioButton("Software");

        // Add RadioButtons to a Group
        ButtonGroup programSelection = new ButtonGroup();
        programSelection.add(this.radBusinessProgram);
        programSelection.add(this.radSoftwareProgram);
        this.radSoftwareProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCoursesToList();
            }
        });
        this.radBusinessProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCoursesToList();
            }
        });
        courses.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    addSelectedCourseToList();
                }
            }
        });
        this.displayC = new JList<>(this.displayCourses);                                   // Converts the DefaultModelList to a JList for Display
        this.displayC.setVisibleRowCount(10);
        this.displayC.setFixedCellWidth(20);
        this.displayC.setFixedCellHeight(14);
        this.displayC.setBackground(Color.white);



        // Initialize Button
        this.btnConfirm = new JButton("Confirm");
        this.btnConfirm.setSize(5,2);
        this.btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllInformation();
            }
        });

        this.displayData = new JList<>(this.displayInformation);
        this.displayData.setVisibleRowCount(6);
        this.displayData.setFixedCellHeight(14);
        this.displayData.setFixedCellWidth(100);
        this.displayData.setBackground(Color.white);

        // Initialize Checkbox Buttons
        this.cbStudentCouncil = new JCheckBox("Student Council");
        this.cbVolunteerWork = new JCheckBox("Volunteer Work");

        // ADDING LABELS AND TEXTFIELDS TO LEFT STAGE OF THE GUI
        this.pTextBoxes.add(this.lblName);
        this.pTextBoxes.add(this.txtName);
        this.pTextBoxes.add(this.lblAddress);
        this.pTextBoxes.add(this.txtAddress);
        this.pTextBoxes.add(this.lblCity);
        this.pTextBoxes.add(this.txtCity);
        this.pTextBoxes.add(this.lblProvince);
        this.pTextBoxes.add(this.txtProvince);
        this.pTextBoxes.add(this.lblPostalCode);
        this.pTextBoxes.add(this.txtPostalCode);
        this.pTextBoxes.add(this.lblPhone);
        this.pTextBoxes.add(this.txtPhone);
        this.pTextBoxes.add(this.lblEmail);
        this.pTextBoxes.add(this.txtEmail);
        this.pTextBoxes.add(this.cbStudentCouncil);
        this.pTextBoxes.add(this.cbVolunteerWork);

        // ADDING CHECKBOXES TO CENTER STAGE OF THE GUI
        this.pCheckBoxes.add(this.cbVolunteerWork);
        this.pCheckBoxes.add(this.cbStudentCouncil);

        // ADDING RADIO GROUP AND COURSE SELECTION TO RIGHT STAGE
        this.pRadioButtons.add(this.radBusinessProgram);
        this.pRadioButtons.add(this.radSoftwareProgram);
        this.pRight.add(this.pRadioButtons);
        this.pRight.add(this.courses);
        this.pRight.add(new JScrollPane(this.displayC));

        // ADDING DISPLAY BUTTON AND DISPLAY TEXTBOX TO BOTTOM STAGE
        this.pDisplay.add(this.btnConfirm);
        this.pDisplay.add(new JScrollPane(this.displayData));
        //this.pDisplay.add(this.)
        // ADDING STAGES ONTO GUI
        add(this.pTextBoxes,BorderLayout.WEST);
        add(this.pCheckBoxes,BorderLayout.CENTER);
        add(this.pRight,BorderLayout.EAST);
        add(this.pDisplay,BorderLayout.SOUTH);

    }

    // Adds the Courses to the Program Selected
    private void addCoursesToList(){
        displayCourses.removeAllElements();
        courses.removeAllItems();
        courses.addItem("");
        if (radSoftwareProgram.isSelected()) {
            courses.addItem("Java Programming");
            courses.addItem("Programming 1");
            courses.addItem("Programming 2");
            courses.addItem("Programming 3");
            courses.addItem("Mobile Application Design");
            courses.addItem("Unix/Linux");
        } else if (radBusinessProgram.isSelected()){
            courses.addItem("Accounting 101");
            courses.addItem("Management");
            courses.addItem("Business English");
            courses.addItem("Intermediate Accounting");
            courses.addItem("Taxation");
            courses.addItem("Finance");
        }
    }

    // Adds the Selected Course to A List to be Displayed
    private void addSelectedCourseToList (){
        if ((courses.getSelectedItem().toString() != "") && (!displayCourses.contains(courses.getSelectedItem().toString())))     // Checks to see if course was already in the list
            displayCourses.addElement(courses.getSelectedItem().toString());    // Adds Item to the List
    }

    // Displays the Information submitted by the User into the DisplayInformation DefaultModelList
    private void displayAllInformation(){
        this.displayInformation.removeAllElements();        // This Ensures that the previous information is "erased" and will not generate multiple copies of information
        this.displayInformation.addElement("Name: "+this.txtName.getText());
        this.displayInformation.addElement("Address: "+this.txtAddress.getText()+", City: "+this.txtCity.getText()+", Province: "+this.txtProvince.getText()+", Postal Code: "+this.txtPostalCode.getText());
        this.displayInformation.addElement("Phone Number: "+this.txtPhone.getText());
        this.displayInformation.addElement("Email: "+this.txtEmail.getText());
        this.displayInformation.addElement("Volunteer Work: "+this.cbVolunteerWork.isSelected());
        this.displayInformation.addElement("Student Council: "+this.cbStudentCouncil.isSelected());
        this.displayInformation.addElement("Courses: "+this.displayCourses.toString());
    }
}
