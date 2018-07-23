/*
 * Created By: Brian Au
 * Student ID: 300962933
 * S2018 - COMP 228 - Programming 2 - Assignment 4 - Lab04
 * Wallace Balaniuc
 *
 */
package exercise2;
import javafx.application.Application;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
    private BorderPane brdrPane;
    private GridPane txtPanel, cbPanel, btnPanel;
    private Label lblName, lblAddress, lblCity, lblProvince, lblPostalCode, lblPhone, lblEmail;
    private TextField txtName, txtAddress, txtCity, txtProvince, txtPostalCode, txtPhone, txtEmail;
    private TextArea txtDisplayInformation;
    private Button btnDisplay;
    private RadioButton radSoftware, radBusiness;
    private CheckBox cbVolunteer, cbStudentCouncil;

    private ToggleGroup radProgramGroup;
    private VBox selectedCoursesBox;

    private ComboBox selectedCourses;

    private ListView listCoursesSelected;

    private String [] softwareCourses = {"Programming 1","Programming 2","Programming 3","Mobile Application Design","Linux/Unix","Java Programming"};
    private String [] businessCourses = {"Finance","Business English","Presentation 101","Accounting 101","Intermediate Accounting","Taxataion"};
    public GUI (){
    }

    @Override
    public void start (Stage primaryStage){
        this.brdrPane = new BorderPane();

        this.listCoursesSelected = new ListView();

        // INITIALIZE TEXTFIELD/LABEL PANEL
        this.txtPanel = new GridPane();
        this.txtPanel.setHgap(5);
        this.txtPanel.setVgap(5);

        // INITIALIZE TEXTAREA
        this.txtDisplayInformation = new TextArea();

        // ================== CHECKBOX RELATED =======================

        // INITIALIZE CHECKBOX PANEL
        this.cbPanel = new GridPane();
        this.cbPanel.setHgap(5);
        this.cbPanel.setVgap(5);

        // INITIALIZE CHECKBOXES
        this.cbStudentCouncil = new CheckBox("Student Council");
        this.cbVolunteer = new CheckBox("Volunteer Work");

        // ADD CHECKBOXES TO PANEL
        this.cbPanel.add(cbStudentCouncil,0,0);
        this.cbPanel.add(cbVolunteer,0,1);

        // =================== TEXTBOX / LABEL RELATED ====================

        // LABEL INITALIZATIONS
        this.lblName = new Label ("Name: ");
        this.lblAddress = new Label("Address: ");
        this.lblCity = new Label("City: ");
        this.lblProvince = new Label("Province: ");
        this.lblPostalCode = new Label("Postal Code: ");
        this.lblPhone = new Label("Phone: ");
        this.lblEmail = new Label("Email: ");

        // TEXTFIELD INITIALIZATIONS
        this.txtName = new TextField();
        this.txtAddress = new TextField();
        this.txtCity = new TextField();
        this.txtProvince = new TextField();
        this.txtPostalCode = new TextField();
        this.txtPhone = new TextField();
        this.txtEmail = new TextField();

        // ADD LABELS AND TEXTFIELDS TO SCENE
        this.txtPanel.add(this.lblName,0,0);
        this.txtPanel.add(this.txtName,1,0);
        this.txtPanel.add(this.lblAddress,0,1);
        this.txtPanel.add(this.txtAddress,1,1);
        this.txtPanel.add(this.lblCity,0,2);
        this.txtPanel.add(this.txtCity,1,2);
        this.txtPanel.add(this.lblProvince,0,3);
        this.txtPanel.add(this.txtProvince,1,3);
        this.txtPanel.add(this.lblPostalCode,0,4);
        this.txtPanel.add(this.txtPostalCode,1,4);
        this.txtPanel.add(this.lblPhone,0,5);
        this.txtPanel.add(this.txtPhone,1,5);
        this.txtPanel.add(this.lblEmail,0,6);
        this.txtPanel.add(this.txtEmail,1,6);

        // ========================== BUTTON RELATED =============================

        // BUTTON PANEL INITIALIZATION
        this.btnPanel = new GridPane();
        this.btnPanel.setHgap(5);
        this.btnPanel.setVgap(10);

        // BUTTON INITIALIZATION
        this.btnDisplay = new Button ("Display");

        // ADD BUTTON INTO PANEL
        this.btnPanel.add(btnDisplay,0,0);
        // ALIGN BUTTON IN GRID SPACE
        GridPane.setHalignment(btnDisplay,HPos.CENTER);

        this.btnPanel.add(txtDisplayInformation,0,1);
        // Action Listener for Button Click
        this.btnDisplay.setOnAction(e -> displayInformation());

        // ==================== RADIO BUTTON RELATED ==========================

        // CREATE RADIO BUTTON TOGGLE GROUP
        this.radProgramGroup = new ToggleGroup();

        // INITIALIZE RADIO BUTTONS AND ADD TO TOGGLE GROUP
        this.radBusiness = new RadioButton("Business");
        this.radSoftware = new RadioButton("Software");
        this.radBusiness.setToggleGroup(this.radProgramGroup);
        this.radSoftware.setToggleGroup(this.radProgramGroup);

        //======================== COMBO BOX RELATED =============================

        // INITIALIZE COMBOBOX
        this.selectedCourses = new ComboBox();

        // ========================= VBOX RELATED ================================

        // PROGRAM SELECTION
        this.selectedCoursesBox = new VBox();

        // SETS A BORDER AROUND THE PROGRAM SELECT
        this.selectedCoursesBox.setStyle("-fx-padding: 5;"+"-fx-border-style: solid inside;"+ "-fx-border-width: 2;"+"-fx-border-insets: 2;"+"-fx-border-radius: 5;"+"-fx-border-color: black;");
        Text title = new Text("Select Program");

        // ADD A TITLE
        this.selectedCoursesBox.getChildren().add(title);

        // ADD RADIO BUTTONS INTO THE GROUP
        this.selectedCoursesBox.getChildren().addAll(radBusiness,radSoftware,selectedCourses,listCoursesSelected);
        this.selectedCourses.setOnMouseClicked(e -> displayCourses());
        this.selectedCourses.setOnAction(e -> addToCourseList());

        // =============================== BORDERPANE RELATED ===============================
        ScrollPane scrollPane = new ScrollPane(brdrPane);
        // SET PANELS ON STAGE
        this.brdrPane.setLeft(txtPanel);
        this.brdrPane.setCenter(cbPanel);
        this.brdrPane.setRight(selectedCoursesBox);
        this.brdrPane.setBottom(btnPanel);


        // SETS THE SIZE OF THE SCENE AND DISPLAYS IT
        Scene scene = new Scene (brdrPane, 600,500);
        primaryStage.setTitle("COMP 228 - Java Programming - Assignment 4 - Lab 04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // APPENDS ALL INFORMATION FROM USER INTO THE TEXT AREA
    private void displayInformation(){
        this.txtDisplayInformation.appendText("Name: " + this.txtName.getText() + "\nAddress: " + this.txtAddress.getText() + ", " + this.txtCity.getText() + ", " + this.txtProvince.getText() + ", " + this.txtPostalCode.getText()
                    + "\nPhone: " + this.txtPhone.getText() + "\nEmail: " + this.txtEmail.getText() + "\nVolunteer Work: " + this.cbVolunteer.isSelected() + "\nStudent Council: " + this.cbStudentCouncil.isSelected()
                    + "\nCourses Taken: " + this.listCoursesSelected.getItems().toString()+"\n");
    }

    // DISPLAYS COURSES AVAILABLE TO THAT PROGRAM
    private void displayCourses(){
        this.selectedCourses.getItems().removeAll(this.softwareCourses);
        this.selectedCourses.getItems().removeAll(this.businessCourses);
        if (this.radSoftware.isSelected())
            this.selectedCourses.getItems().addAll(this.softwareCourses);
        else if (this.radBusiness.isSelected())
            this.selectedCourses.getItems().addAll(this.businessCourses);
    }

    // ADDS THE COURSE SELECTED FROM COMBO BOX INTO A LIST
    private void addToCourseList(){
        if ((selectedCourses.getSelectionModel().getSelectedItem() != "") && (selectedCourses.getSelectionModel().getSelectedItem() != null) && (!this.listCoursesSelected.getItems().contains(selectedCourses.getSelectionModel().getSelectedItem())))
            this.listCoursesSelected.getItems().add(this.selectedCourses.getSelectionModel().getSelectedItem());
    }

    public static void main (String[] args){
        launch(args);
    }
}
