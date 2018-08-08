/*
 * By: Brian Au
 * Student ID: 300962933
 * COMP228 - Assignment 5 - Lab05 - Wallace B.
 * Due: 06 AUG 2018
 */

package exercise1;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class A5 extends Application {

    boolean newEntry = true;
    //============================= JAVAFX RELATED VARIABLE DECLARATIONS ============================
    private BorderPane brdrPane;
    private GridPane txtPanel, btnPanel, gamePanel;
    private Label lblFirstName, lblLastName, lblAddress, lblCity, lblProvince, lblPostalCode, lblPhone, lblGame, lblGamePlayDate, lblGameScore;
    private TextField txtFirstName, txtLastName, txtAddress, txtCity, txtProvince, txtPostalCode, txtPhone, txtGame, txtGamePlayDate, txtGameScore;
    private Button btnSubmitPlayerInformation, btnSubmitGameInformation, btnDisplayTable;
    private int selectedPlayerID = 0;
    private JTable dbTable;
    // ============================= TABLE VIEW ===============================

    //============================= SQL JDBC RELATED VARIABLE DECLARATIONS ==========================
    private PreparedStatement newItemInsert;
    private Connection con;

    // JDBC driver name and database URL
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;database=COMP228;integratedSecurity=true";
    private static int playerIDCount, gameIDCount, playerGameIDCount = 0;
    public A5 (){
    }

    @Override
    public void start (Stage primaryStage){
        this.brdrPane = new BorderPane();

        // INITIALIZE TEXTFIELD/LABEL PANEL
        this.txtPanel = new GridPane();
        this.txtPanel.setHgap(5);
        this.txtPanel.setVgap(5);

        this.gamePanel = new GridPane();
        this.gamePanel.setHgap(5);
        this.gamePanel.setVgap(5);
        // =================== TEXTBOX / LABEL RELATED ====================

        // LABEL INITALIZATIONS
        this.lblFirstName = new Label ("First Name: ");
        this.lblLastName = new Label ("Last Name: ");
        this.lblAddress = new Label("Address: ");
        this.lblCity = new Label("City: ");
        this.lblProvince = new Label("Province: ");
        this.lblPostalCode = new Label("Postal Code: ");
        this.lblPhone = new Label("Phone: ");

        this.lblGame = new Label ("Online Game currently playing: ");
        this.lblGamePlayDate = new Label ("Last Played Date: ");
        this.lblGameScore = new Label ("Game Score (leave blank if no score): ");

        // TEXTFIELD INITIALIZATIONS
        this.txtFirstName = new TextField();
        this.txtLastName = new TextField();
        this.txtAddress = new TextField();
        this.txtCity = new TextField();
        this.txtProvince = new TextField();
        this.txtPostalCode = new TextField();

        this.txtPhone = new TextField();

        // GAME RELATED INFORMATION
        this.txtGame = new TextField();
        this.txtGamePlayDate = new TextField();
        this.txtGameScore = new TextField();

        // ADD LABELS AND TEXTFIELDS TO SCENE
        this.txtPanel.add(this.lblFirstName,0,0);
        this.txtPanel.add(this.txtFirstName,1,0);
        this.txtPanel.add(this.lblLastName,0,1);
        this.txtPanel.add(this.txtLastName,1,1);
        this.txtPanel.add(this.lblAddress,0,2);
        this.txtPanel.add(this.txtAddress,1,2);
        this.txtPanel.add(this.lblCity,0,3);
        this.txtPanel.add(this.txtCity,1,3);
        this.txtPanel.add(this.lblProvince,0,4);
        this.txtPanel.add(this.txtProvince,1,4);
        this.txtPanel.add(this.lblPostalCode,0,5);
        this.txtPanel.add(this.txtPostalCode,1,5);
        this.txtPanel.add(this.lblPhone,0,6);
        this.txtPanel.add(this.txtPhone,1,6);
        if (this.selectedPlayerID == 0) {
            this.gamePanel.add(this.lblGame, 0, 0);
            this.gamePanel.add(this.txtGame, 1, 0);
            this.gamePanel.add(this.lblGamePlayDate, 0, 1);
            this.gamePanel.add(this.txtGamePlayDate, 1, 1);
            this.gamePanel.add(this.lblGameScore, 0, 2);
            this.gamePanel.add(this.txtGameScore, 1, 2);
        }
        // ========================== BUTTON RELATED =============================

        // BUTTON PANEL INITIALIZATION
        this.btnPanel = new GridPane();
        this.btnPanel.setHgap(5);
        this.btnPanel.setVgap(5);

        // BUTTON INITIALIZATION
        if (this.newEntry)
            this.btnSubmitPlayerInformation = new Button ("Submit Player Info");
        else
            this.btnSubmitPlayerInformation = new Button("Update Player Info");
        this.btnDisplayTable = new Button ("Display Information");

        // SET ON CLICK ACTIONS
        this.btnSubmitPlayerInformation.setOnAction(e -> checkPlayerFields());
        this.btnDisplayTable.setOnAction(e-> displayDatabaseQuery(primaryStage));

        // ADD BUTTON INTO PANEL
        this.btnPanel.add(btnSubmitPlayerInformation,0,0);
        this.btnPanel.add(btnDisplayTable,1,0);

        if ((this.selectedPlayerID == 0) && (this.newEntry)) {
            this.btnSubmitGameInformation = new Button("Add Game");
            this.btnSubmitGameInformation.setOnAction(e -> checkGameFields());
            this.btnPanel.add(btnSubmitGameInformation,2,0);
        }
        // ALIGN BUTTON IN GRID SPACE
        GridPane.setHalignment(btnSubmitPlayerInformation,HPos.LEFT);
        GridPane.setHalignment(btnDisplayTable, HPos.CENTER);
        GridPane.setHalignment(btnSubmitGameInformation,HPos.RIGHT);


        // =============================== BORDERPANE RELATED ===============================
        ScrollPane scrollPane = new ScrollPane(brdrPane);
        // SET PANELS ON STAGE
        this.brdrPane.setLeft(txtPanel);
        this.brdrPane.setBottom(btnPanel);
        this.brdrPane.setRight(gamePanel);


        // SETS THE SIZE OF THE SCENE AND DISPLAYS IT
        Scene scene = new Scene (brdrPane, 600,250);
        primaryStage.setTitle("COMP 228 - Java Programming - Assignment 5 - Lab 05");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // INCREASE GAME ID, PLAYER ID AND PLAYERGAMEID COUNTS
    private void increaseGameIDCount () { this.gameIDCount ++; }
    private void increasePlayerIDCount () { this.playerIDCount ++; }
    private void increasePlayerGameIDCount () { this.playerGameIDCount ++; }

    // ADD PLAYER INFORMATION TO THE DATABASE
    private void addToDatabasePlayerInfo () {
        // INCREASE PLAYER ID COUNT
        this.increasePlayerIDCount();
        try {

            Class.forName(this.DRIVER);

            // Establish connection
            this.con = DriverManager.getConnection(DATABASE_URL);

            // ADD PLAYER'S INFORMATION TO DATABASE
            this.newItemInsert = this.con.prepareStatement("INSERT into Player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?,?,?,?,?,?,?)");
            this.newItemInsert.setInt(1,this.playerIDCount);
            this.newItemInsert.setString(2,txtFirstName.getText());
            this.newItemInsert.setString(3,txtLastName.getText());
            this.newItemInsert.setString(4,txtAddress.getText());
            this.newItemInsert.setString(5,txtPostalCode.getText());
            this.newItemInsert.setString(6,txtProvince.getText());
            this.newItemInsert.setString(7,txtPhone.getText());

            // UPDATE PLAYER DATABASE
            this.newItemInsert.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Player Information Added!");
            try {
                this.newItemInsert.close();
                this.con.close();
            }
            catch (Exception e) {}
        }
    }

    // ADD GAME INFORMATION TO THE DATABASE
    private void addToDatabaseGame () {
        // INCREASE ID COUNT
        this.increaseGameIDCount();

        try {
            Class.forName(this.DRIVER);

            // Establish connection
            this.con = DriverManager.getConnection(DATABASE_URL);
            // ADD ITEMS TO DATABASE AND UPDATE
            this.newItemInsert = this.con.prepareStatement("INSERT into Game (game_id, game_title) VALUES(?,?)");
            this.newItemInsert.setInt(1, this.gameIDCount);
            this.newItemInsert.setString(2, this.txtGame.getText());

            // UPDATE PLAYER DATABASE
            this.newItemInsert.executeUpdate();

            // UPDATE PLAYER GAME RELATIONSHIP
            this.insertDatabaseRelationship();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done!");
            try {
                this.newItemInsert.close();
                this.con.close();
            } catch (Exception e) {
            }
        }
    }

    // UPDATE THE PLAYERGAME RELATIONSHIP
    private void insertDatabaseRelationship (){
        // INCREASE ID COUNT
        this.increasePlayerGameIDCount();
        try {
            Class.forName(this.DRIVER);

            // Establish connection
            this.con = DriverManager.getConnection(DATABASE_URL);
            // ADD ITEMS TO DATABASE AND UPDATE
            this.newItemInsert = this.con.prepareStatement("INSERT into PlayerAndGame (player_game_id, player_id, game_id, playing_date, score) VALUES(?,?,?,?,?)");
            this.newItemInsert.setInt(1, this.playerGameIDCount);
            this.newItemInsert.setInt(2, this.playerIDCount);
            this.newItemInsert.setInt(3, this.gameIDCount);
            this.newItemInsert.setString(4, this.txtGamePlayDate.getText());
            if (!this.txtGameScore.getText().isEmpty())
                this.newItemInsert.setInt(5,Integer.parseInt(this.txtGameScore.getText()));
            else
                this.newItemInsert.setNull(5, Types.INTEGER);

            // UPDATE PLAYER DATABASE
            this.newItemInsert.executeUpdate();

            // RESET GAME INFORMATION FIELDS
            this.txtGame.clear();
            this.txtGamePlayDate.clear();
            this.txtGameScore.clear();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Updated Database Relationship!!");
            try {
                this.newItemInsert.close();
                this.con.close();
            } catch (Exception e) {
            }
        }
    }

    // DISPLAYS THE TABLE TO THE USER
    private void displayDatabaseQuery (Stage pStage){
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(this.DRIVER);
            // Establish connection
            this.con = DriverManager.getConnection(DATABASE_URL);

            String SQL = "SELECT a.player_id, d.first_name, d.last_name, b.game_title, a.playing_date, a.score " +
                    "FROM PlayerAndGame a " +
                    "LEFT JOIN Game b ON a.game_id = b.game_id " +
                    "LEFT JOIN Player d ON a.player_id = d.player_id";

            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            dbTable = new JTable(buildTableModel(rs));
            this.displayNewStage(pStage);

         } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Displaying Database Relationship!!");
            try {
                this.newItemInsert.close();
                this.con.close();
            } catch (Exception e) {
            }
        }
    }

    // NEW WINDOW
    private void displayNewStage (Stage pStage){
        BorderPane bp = new BorderPane();
        Button newEntry = new Button ("New Entry");
        GridPane txtUpdatePanel = new GridPane();
        Label lblUpdateID = new Label("Enter Player id to Update: ");
        TextField updateID = new TextField();

        GridPane btnPanel2 = new GridPane();
        btnPanel2.setHgap(5);
        btnPanel2.setVgap(5);


        // JTable INTO JAVAFX
        SwingNode sn = new SwingNode();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                sn.setContent(new JScrollPane(dbTable));
            }
        });
        txtUpdatePanel.add(lblUpdateID,0,0);
        txtUpdatePanel.add(updateID,1,0);

        bp.setPrefWidth(600);
        bp.setPrefHeight(400);
        bp.setTop(txtUpdatePanel);
        bp.setCenter(sn);

        btnSubmitPlayerInformation = new Button("Update Player Information");
        btnSubmitPlayerInformation.setOnAction(e->this.readInputID(pStage, updateID));
        newEntry.setOnAction(e->this.newEntry(pStage));
        btnPanel2.add(btnSubmitPlayerInformation,0,0);
        btnPanel2.add(newEntry,1,0);

        bp.setBottom(btnPanel2);
        pStage.setScene(new Scene (bp));


        pStage.show();
    }
    private void newEntry (Stage pStage){
        this.newEntry = true;
        this.selectedPlayerID = 0;
        start(pStage);
    }
    // STORES THE ID THE USER INPUT
    private void readInputID (Stage stage, TextField txtBox){
        this.newEntry = false;
        if (!txtBox.getText().isEmpty())
            this.selectedPlayerID = Integer.parseInt(txtBox.getText());
        System.out.println(this.selectedPlayerID);

        this.start(stage);
    }

    // PROVIDES AN UPDATE WINDOW FOR USER TO UPDATE EXISTING INFORMATION
    private void updatePlayerInformation (){
        try {
            Class.forName(this.DRIVER);

            // Establish connection
            this.con = DriverManager.getConnection(DATABASE_URL);
            // ADD ITEMS TO DATABASE AND UPDATE
            this.newItemInsert = this.con.prepareStatement("UPDATE Player set first_name=?, last_name=?, address=?, province=?,postal_code=?,phone_number=? WHERE player_id=?");
            this.newItemInsert.setString(1, this.txtFirstName.getText());
            this.newItemInsert.setString(2, this.txtLastName.getText());
            this.newItemInsert.setString(3, this.txtAddress.getText());
            this.newItemInsert.setString(4, this.txtProvince.getText());
            this.newItemInsert.setString(5, this.txtPostalCode.getText());
            this.newItemInsert.setString(6, this.txtPhone.getText());
            this.newItemInsert.setInt(7, this.selectedPlayerID);

            // UPDATE PLAYER DATABASE
            this.newItemInsert.executeUpdate();

            JOptionPane.showMessageDialog(null,"Update Completed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Updated Database Relationship!!");
            try {
                this.newItemInsert.close();
                this.con.close();
            } catch (Exception e) {
            }
        }
    }

    // CHECK THE PLAYER TEXTFIELDS IF EMPTY
    private void checkPlayerFields (){
        if (this.newEntry) {
            if ((this.txtFirstName.getText().isEmpty()) && (this.txtLastName.getText().isEmpty()))
                JOptionPane.showMessageDialog(null, "ERROR: Missing First Name and Last Name");
            else if ((this.txtFirstName.getText().isEmpty()) && (!this.txtLastName.getText().isEmpty()))
                JOptionPane.showMessageDialog(null, "ERROR: Missing First Name");
            else if ((!this.txtFirstName.getText().isEmpty()) && (this.txtLastName.getText().isEmpty()))
                JOptionPane.showMessageDialog(null, "ERROR: Missing Last Name");
            else
                JOptionPane.showMessageDialog(null,"Player Information Sumbitted");
                addToDatabasePlayerInfo();
        } else {
            if ((this.txtFirstName.getText().isEmpty()) && (this.txtLastName.getText().isEmpty()))
                JOptionPane.showMessageDialog(null, "ERROR: Missing First Name and Last Name");
            else if ((this.txtFirstName.getText().isEmpty()) && (!this.txtLastName.getText().isEmpty()))
                JOptionPane.showMessageDialog(null, "ERROR: Missing First Name");
            else if ((!this.txtFirstName.getText().isEmpty()) && (this.txtLastName.getText().isEmpty()))
                JOptionPane.showMessageDialog(null, "ERROR: Missing Last Name");
            else
                updatePlayerInformation ();
        }
    }

    // CHECK THE GAME TEXTFIELDS IF EMPTY
    private void checkGameFields (){
        if (this.txtGame.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"ERROR: Missing Game Title");
        else
            JOptionPane.showMessageDialog(null, "Game Entry Submitted");
            addToDatabaseGame();
    }

    /* ================================================================================================
     * Borrowed / Taken from Stackoverflow - Not Original Code
     * https://stackoverflow.com/questions/10620448/most-simple-code-to-populate-jtable-from-resultset
     * ================================================================================================
     */
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }


    public static void main (String[] args){
        launch(args);
    }
}
