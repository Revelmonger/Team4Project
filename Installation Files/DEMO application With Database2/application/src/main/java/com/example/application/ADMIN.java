package com.example.application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.UnsupportedLookAndFeelException;

import com.example.application.Constructors.Orders;
import com.example.application.Constructors.Radiologists;
import com.example.application.TableConstructors.TABLECheckedInAppointmentsTableController;
import com.example.application.TableConstructors.TABLEPlacedOrdersTableController;
import com.example.application.TableConstructors.TABLEReviewImagingOrdersTableController;
import com.example.application.TableConstructors.TABLETodaysAppointmentsTableController;
import com.example.application.TableConstructors.TABLEUnscheduledOrdersTableController;
import com.example.application.TableConstructors.TECHCheckedInAppointmentsTableController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ADMIN implements Initializable {


@FXML
private ScrollPane BlurBox;

    @ FXML
    private TableColumn<TABLECheckedInAppointmentsTableController, Boolean> statusColumn;
    @FXML
    private TableColumn<TABLETodaysAppointmentsTableController, Button> TodaysAppointmentsCheckedIN;
    @FXML
    private TableColumn<TABLEUnscheduledOrdersTableController, Button> UnscheduledOrdersSchedule;
    @FXML
    private TableColumn<TABLECheckedInAppointmentsTableController, Button> TechCheckedInCompleteOrder;
    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, Button> ReviewOrderColumn;





    String user_id1 = LOGIN.LoggedInUserID;

    /*
     * 
     * Button Imports
     * 
     */
    @FXML
    private Button logoutButton;
    @FXML
    private Button HomeButton;
    @FXML
    private Button UserInfoButton;
    @FXML
    private Button AdminButton;
    @FXML
    private Button ReferralsButton;
    @FXML
    private Button AppointmentsButton;
    @FXML
    private Button OrdersButton;

    /*
     * 
     * Button Logic
     * 
     */

    public void logout(ActionEvent e) throws IOException {

        FXApp.setRoot("LOGIN");
    }

    public void home(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN");
    }

    public void userInfo(ActionEvent e) throws IOException {
        System.out.println("The Current user is " + user_id1);
        FXApp.setRoot("ADMIN");
    }

    public void admin(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_AdminPanel");
    }

    public void referrals(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_Referrals");
    }

    public void orders(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_AllOrders");
    }

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_Apppointments");
    }

    /*
     * 
     * Button Listener Events
     * 
     */

    @FXML
    public void HomeButtonEntered() {

        HomeButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void HomeButtonExited() {

        HomeButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void UserInfoButtonEntered() {

        UserInfoButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void UserInfoButtonExited() {

        UserInfoButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void AdminButtonEntered() {

        AdminButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void AdminButtonExited() {

        AdminButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void ReferralsButtonEntered() {

        ReferralsButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void ReferralsButtonExited() {

        ReferralsButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void AppointentsButtonEntered() {

        AppointmentsButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void AppointmentsButtonExited() {

        AppointmentsButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void OrdersButtonEntered() {

        OrdersButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void OrdersButtonExited() {

        OrdersButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void LogoutButtonOnMouseEntered() {

        logoutButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void LogoutButtonOnMouseExited() {

        logoutButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    /*
     * 
     * Placed Orders Imports
     * 
     */
    @FXML
    private TableView<PlacedOrdersTableController> PlacedOrdersTable;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Patient;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Modality;

    @FXML
    private TableColumn<PlacedOrdersTableController, String> placed_orders_Notes;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Status;
    @FXML
    private TableColumn<PlacedOrdersTableController, Button> ResultsTable;

    @FXML
    private TextField searchPlacedOrders;

    ObservableList<PlacedOrdersTableController> PlacedOrdersTableObservableList = FXCollections
            .observableArrayList();
////////////////////////////








    /*
     * 
     * Completed Orders Imports
     * 
     */
    @FXML
    private TableView<PlacedOrdersTableController> CompletedOrdersTable;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> CompletedOrdersPatient;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> CompletedOrdersModality;

    @FXML
    private TableColumn<PlacedOrdersTableController, String> CompletedOrdersNotes;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> CompletedOrdersStatus;
    @FXML
    private TableColumn<PlacedOrdersTableController, Button> CompletedOrdersResults;

    @FXML
    private TextField searchCompletedOrders;

    ObservableList<PlacedOrdersTableController> completedOrdersObservableList = FXCollections
            .observableArrayList();
    
     /*
     * 
     * Closed Orders
     * 
     */
    @FXML
    private TableView<PlacedOrdersTableController> OldOrdersTable;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> OldOrdersPatients;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> OldOrdersModality;

    @FXML
    private TableColumn<PlacedOrdersTableController, String> OldOrdersNotes;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> OldOrdersStatus;
    @FXML
    private TableColumn<PlacedOrdersTableController, Button> OldOrdersResults;

    @FXML
    private TextField ClosedOrdersSearch;

    ObservableList<PlacedOrdersTableController> closedOrdersObservableList = FXCollections
            .observableArrayList();
    




























//////////////////////////////

    /*
     * 
     * Checked-In Appointments Imports
     * 
     */
    @FXML
    private TableView<TABLECheckedInAppointmentsTableController> CheckedInAppointmentsTable;

    @FXML
    private TableColumn<TABLECheckedInAppointmentsTableController, Integer> CheckedInAppointments_Patient;

    @FXML
    private TableColumn<TABLECheckedInAppointmentsTableController, Integer> CheckedInAppointments_Modality;

    @FXML
    private TableColumn<TABLECheckedInAppointmentsTableController, String> CheckedInAppointments_Price;

    @FXML
    private TableColumn<TABLECheckedInAppointmentsTableController, Date> CheckedInAppointments_DateandTime;

    @FXML
    private TableColumn<TABLECheckedInAppointmentsTableController, Integer> CheckedInAppointments_Radiologist;

    @FXML
    private TextField searchCheckedInAppointments;

    ObservableList<TABLECheckedInAppointmentsTableController> CheckedInAppointmentsObservableList = FXCollections
            .observableArrayList();
    
        /*
     * 
     * TECH Checked-In Appointments Imports
     * 
     */
    @FXML
    private TableView<TECHCheckedInAppointmentsTableController> TECHNICIANCheckedInAppointmentsTable1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Integer> CheckedInAppointments_Patient1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Integer> CheckedInAppointments_Modality1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, String> CheckedInAppointments_Price1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Date> CheckedInAppointments_DateandTime1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Integer> CheckedInAppointments_Radiologist1;

    @FXML
    private TextField searchCheckedInAppointments1;

    ObservableList<TECHCheckedInAppointmentsTableController> TECHCheckedInAppointmentsObservableList = FXCollections
            .observableArrayList();
    
            
    /*
     * 
     * Todays Appointments Imports
     * 
     */
    @FXML
    private TableView<TABLETodaysAppointmentsTableController> TodaysAppointmentsTable;

    @FXML
    private TableColumn<TABLETodaysAppointmentsTableController, Integer> TodaysAppointments_Patient1;

    @FXML
    private TableColumn<TABLETodaysAppointmentsTableController, Integer> TodaysAppointmentsTable_Modality;

    @FXML
    private TableColumn<TABLETodaysAppointmentsTableController, String> TodaysAppointmentsTable_Prices;

    @FXML
    private TableColumn<TABLETodaysAppointmentsTableController, Date> TodaysAppointmentsTable_DateandTime;

    @FXML
    private TableColumn<TABLETodaysAppointmentsTableController, Integer> TodaysAppointmentsTable_Radiologist;

    @FXML
    private TableColumn<TABLETodaysAppointmentsTableController, Integer> TodaysAppointmentsTable_Technician;

    @FXML
    private TextField searchTodaysAppointments;

    ObservableList<TABLETodaysAppointmentsTableController> TodaysAppointmentsObservableList = FXCollections
            .observableArrayList();

    /*
     * 
     * Unscheduled Orders Imports
     * 
     */
    @FXML
    private TableView<TABLEUnscheduledOrdersTableController> UnscheduledOrdersTable;

    @FXML
    private TableColumn<TABLEUnscheduledOrdersTableController, Integer> UnscheduledOrdersTable_Patient;

    @FXML
    private TableColumn<TABLEUnscheduledOrdersTableController, Integer> UnscheduledOrdersTable_ReferralMD;

    @FXML
    private TableColumn<TABLEUnscheduledOrdersTableController, Integer> UnscheduledOrdersTable_Modality;

    @FXML
    private TableColumn<TABLEUnscheduledOrdersTableController, String> UnscheduledOrdersTable_Notes;

    @FXML
    private TextField searchUnscheduledOrders;

    ObservableList<TABLEUnscheduledOrdersTableController> UnscheduledOrdersObservableList = FXCollections
            .observableArrayList();

    /*
     * 
     * Review Imaging Orders Imports
     * 
     */

    @FXML
    private TableView<TABLEReviewImagingOrdersTableController> ReviewImagingOrdersTable;

    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_Patient;

    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_RefferalMD;

    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_Modality;

    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, String> ReviewImagingOrdersTable_Notes;

    @FXML
    private TextField searchReviewImagineOrders;

    ObservableList<TABLEReviewImagingOrdersTableController> ReviewImagingOrdersObservableList = FXCollections
            .observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();



        /*
         * 
         * Placed Orders Table
         * 
         */
        String PlacedOrdersTableQuery = "select patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.status,  order_status.order_name  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id WHERE status = 4 || status = 1;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PlacedOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                String statusquery = queryOutput.getString("order_name");
                Integer patients_id = queryOutput.getInt("patient_id");

                String DoesThisPatientHaveAnAlert = "Select * from patients_alerts where patient_id = '"+ patients_id+ "'";
                statement = connectDB.createStatement();
                ResultSet queryOutput2 = statement.executeQuery(DoesThisPatientHaveAnAlert);
               
                Button button;

                if(!queryOutput2.isBeforeFirst()){
                    button = new Button("");
                    button.setStyle(
                        "-fx-background-color: transparent; ");
                } 
                
                else {
                    button = new Button("Alert!");
                    button.setStyle(
                        "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #d32525;");



                        button.setOnAction(new EventHandler<ActionEvent>() {

   
                            @Override
                            public void handle(ActionEvent event) {
                                BlurBox.setEffect(new BoxBlur(5, 10, 10));
                        
                                 
                                Stage newWindow = new Stage();
                             
                                AnchorPane anchorpane = new AnchorPane();
                               
                        
                                Label CreateNewPatientAlertLabel = new Label("Patient Alert History");
                                CreateNewPatientAlertLabel.setLayoutX(46);
                                CreateNewPatientAlertLabel.setLayoutY(47);
                                CreateNewPatientAlertLabel.setStyle("-fx-font: normal bold 36px 'arial';");
                         
                        
                                Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                                horizontalline.setOpacity(.3);
                                horizontalline.setTranslateY(100);




                                TableView tableView = new TableView();
                                
                                tableView.setPrefWidth(500);
                                tableView.setPrefHeight(400);
                                tableView.setLayoutX(47);
                                tableView.setLayoutY(150);
                                tableView.setEditable(false);
                                tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

                                
                                TableColumn<PatientsAlertsTableController, String> column1 = new TableColumn<>("Alerts");
                                column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                                column1.setPrefWidth(500);                                
                               
                                
                                
                                tableView.getColumns().add(column1);
                                try {
                                DatabaseConnection connectNow = new DatabaseConnection();
                                Connection connectDB = connectNow.getConnection();
                                
                                String alert_nameTableQuery = " select * from patients_alerts as pa join alerts as a on a.alert_id = pa.alert_id where patient_id = " + patients_id + ";";
                                
                                
                                    Statement statement = connectDB.createStatement();
                                    ResultSet queryOutput = statement.executeQuery(alert_nameTableQuery);
                                
                                    while (queryOutput.next()) {
                                        Integer AlertID = queryOutput.getInt("alert_id");
                                      String  AlertName = queryOutput.getString("alert_name");

   
                                      tableView.getItems().add(new PatientsAlertsTableController(AlertName));
                                    
                                    }
                                
                                
                                } catch (Exception e) {
                                e.printStackTrace();        }
                                
                            
        
                                Button CancelButton = new Button("Close");
                                CancelButton.setPrefHeight(42);
                                CancelButton.setPrefWidth(102);
                                CancelButton.setLayoutX(447);
                                CancelButton.setLayoutY(585);
                                CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");
                        
                                CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent e) {
                                        Stage stage = (Stage) CancelButton.getScene().getWindow();
                                        stage.close();
                                        BlurBox.setEffect(new BoxBlur(0, 0, 0));
                        
                                    }
                                });
                        
                                        anchorpane.getChildren().add(CreateNewPatientAlertLabel);
                                       
                                        anchorpane.getChildren().add(horizontalline);
                                     
                                        anchorpane.getChildren().add(CancelButton);
                                        anchorpane.getChildren().add(tableView);
                                Scene scene = new Scene(anchorpane, 600, 700);
                        
                                
                                newWindow.setScene(scene);
                                newWindow.initStyle(StageStyle.UNDECORATED);
                                newWindow.setResizable(false);
                                newWindow.initModality(Modality.APPLICATION_MODAL);
                        
                                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                    @Override
                                    public void handle(KeyEvent t) {
                                        KeyCode key = t.getCode();
                                        if (key == KeyCode.ESCAPE) {
                                            newWindow.close();
                                            BlurBox.setEffect(new BoxBlur(0, 0, 0));
                                        }
                                    }
                                });
                                newWindow.show();
                              }
                        });// Closes New Patient Alert















                        /////////////////////////////
                        
                }


             






                PlacedOrdersTableObservableList.add(
                        new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery, button));
            }

            placed_orders_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            placed_orders_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            placed_orders_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));

            placed_orders_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

            ResultsTable.setCellValueFactory(new PropertyValueFactory<>("button"));

            PlacedOrdersTable.setItems(null);
            PlacedOrdersTable.setItems(PlacedOrdersTableObservableList);

            // Search Bar Functionality Start
            FilteredList<PlacedOrdersTableController> PlacedOrdersFilteredData = new FilteredList<>(
                    PlacedOrdersTableObservableList);

            searchPlacedOrders.textProperty().addListener((observable, oldValue, newValue) -> {
                PlacedOrdersFilteredData.setPredicate(TABLEPlacedOrdersTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLEPlacedOrdersTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEPlacedOrdersTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEPlacedOrdersTableController.getNotes().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEPlacedOrdersTableController.getStatus().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else {
                        return false; // no match found
                    }

                });

            });

            SortedList<PlacedOrdersTableController> PlacedOrdersSortedData = new SortedList<>(
                    PlacedOrdersFilteredData);

            // Binds the sorted resultswith the Table
            PlacedOrdersSortedData.comparatorProperty().bind(PlacedOrdersTable.comparatorProperty());

            PlacedOrdersTable.setItems(PlacedOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
e.printStackTrace();        }









        


        /*************Completed Orders Table***********************/
        
        String CompletedOrdersTableQuery = "select diagnostic, patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.order_id, orders.status,  order_status.order_name  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id join diagnostic_reports on orders.order_id = diagnostic_reports.order_id where status = 3;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(CompletedOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                Integer OrderID = queryOutput.getInt("order_id");
                String statusquery = queryOutput.getString("order_name");
                Integer patients_id = queryOutput.getInt("patient_id");
                Button button = new Button("Review Order");
                String diagnostic = queryOutput.getString("diagnostic");
                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

                
                button.setOnAction(new EventHandler<ActionEvent>() {

    
   
                    @Override
                    public void handle(ActionEvent event) {
                        BlurBox.setEffect(new BoxBlur(5, 10, 10));
                
                         
                           Stage newWindow = new Stage();
                     
                        AnchorPane anchorpane = new AnchorPane();
                      
                
                        Label CreateFileLabel = new Label("Create Diagnostic Report");
                        CreateFileLabel.setLayoutX(46);
                        CreateFileLabel.setLayoutY(47);
                        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");
                        
                
                      
                
                        Label ReportLabel = new Label("Report:");
                        ReportLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                        ReportLabel.setLayoutX(275);
                        ReportLabel.setLayoutY(120);
                     
                
                        
                        TextArea ReportArea = new TextArea();
                        ReportArea.setPrefHeight(200);
                        ReportArea.setPrefWidth(400);
                        ReportArea.setLayoutX(350);
                        ReportArea.setLayoutY(120);
                        ReportArea.setEditable(false);
                        ReportArea.setText(diagnostic);
                
                
                        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                        horizontalline.setOpacity(.3);
                        horizontalline.setTranslateY(100);
                
                  
                       
                        Button showImage = new Button("Show Image");
                        showImage.setPrefHeight(42);
                        showImage.setPrefWidth(100);
                        showImage.setLayoutX(70);
                        showImage.setLayoutY(120);
                        showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");
                
                        showImage.setOnAction(new EventHandler<ActionEvent>() {
                
                            /**************  SHOWS IMAGE IN NEW WINDOW *********************************/
                            @Override
                            public void handle(ActionEvent e){
                
                                String ImagePathStatement = "SELECT upload_path FROM db_ris.file_uploads WHERE order_id ='" + OrderID+ "'"; 
                                   
                                    try {
                
                                        Statement statement5 = connectDB.createStatement();
                                        ResultSet queryOutput;
                                        queryOutput = statement5.executeQuery(ImagePathStatement);
                                   
                                    while (queryOutput.next()) {
                
                                      String UploadPath = queryOutput.getString("upload_path");
                                      File file = new File(UploadPath);
                                      Image  img = new Image(file.toURI().toString());
                                      double width = img.getWidth();
                                      double height = img.getHeight();;
                
                                        Stage stage = new Stage();
                                        AnchorPane pane = new AnchorPane();
                                        ImageView imgView = new ImageView(img);
                                        
                                        imgView.setFitHeight(height);
                                        imgView.setFitWidth(width);
                                        pane.getChildren().add(imgView);
                
                                        Scene scene = new Scene(pane, width, height);
                
                                        stage.setScene(scene);
                                      
                                        stage.setResizable(false);
                                        stage.initModality(Modality.APPLICATION_MODAL);
                
                                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                            @Override
                                            public void handle(KeyEvent t) {
                                                KeyCode key = t.getCode();
                                                if (key == KeyCode.ESCAPE) {
                                                    stage.close();
                                                    BlurBox.setEffect(new BoxBlur(0, 0, 0));
                
                                                }
                                            }
                                        });
                                        stage.show();
                
                                    }
                                } catch (SQLException e1) {
                
                                    e1.printStackTrace();
                                }
                
                            }
                        });
                //WORKING HERE
                        
                
                        Button CancelButton = new Button("Cancel");
                        CancelButton.setPrefHeight(42);
                        CancelButton.setPrefWidth(102);
                        CancelButton.setLayoutX(680);
                        CancelButton.setLayoutY(338);
                        CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");
                
                        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                Stage stage = (Stage) CancelButton.getScene().getWindow();
                                stage.close();
                                BlurBox.setEffect(new BoxBlur(0, 0, 0));
                
                            }
                        });
                
                                anchorpane.getChildren().add(CreateFileLabel);
                
                                anchorpane.getChildren().add(horizontalline);
                          
                                anchorpane.getChildren().add(CancelButton);
                                anchorpane.getChildren().add(showImage);
                                anchorpane.getChildren().add(ReportArea);
                                anchorpane.getChildren().add(ReportLabel);
                                
                        Scene scene = new Scene(anchorpane, 800, 400);
                
                        
                        newWindow.setScene(scene);
                        newWindow.initStyle(StageStyle.UNDECORATED);
                        newWindow.setResizable(false);
                        newWindow.initModality(Modality.APPLICATION_MODAL);
                
                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent t) {
                                KeyCode key = t.getCode();
                                if (key == KeyCode.ESCAPE) {
                                    newWindow.close();
                                    BlurBox.setEffect(new BoxBlur(0, 0, 0));
                
                                }
                            }
                        });
                        newWindow.show();
                      }
                });//


                completedOrdersObservableList.add(
                        new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery, button));
            }

            CompletedOrdersPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            CompletedOrdersModality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            CompletedOrdersNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));

            CompletedOrdersStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            CompletedOrdersResults.setCellValueFactory(new PropertyValueFactory<>("button"));

            CompletedOrdersTable.setItems(null);
            CompletedOrdersTable.setItems(completedOrdersObservableList);

            // Search Bar Functionality Start
            FilteredList<PlacedOrdersTableController> CompletedOrdersFilteredData = new FilteredList<>(
                completedOrdersObservableList);

            searchPlacedOrders.textProperty().addListener((observable, oldValue, newValue) -> {
                CompletedOrdersFilteredData.setPredicate(TABLEPlacedOrdersTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLEPlacedOrdersTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEPlacedOrdersTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEPlacedOrdersTableController.getNotes().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEPlacedOrdersTableController.getStatus().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else {
                        return false; // no match found
                    }

                });

            });

            SortedList<PlacedOrdersTableController> CompletedOrdersSortedData = new SortedList<>(
                CompletedOrdersFilteredData);

            // Binds the sorted resultswith the Table
            CompletedOrdersSortedData.comparatorProperty().bind(CompletedOrdersTable.comparatorProperty());

            CompletedOrdersTable.setItems(CompletedOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
e.printStackTrace();        }



/******************************Old Orders Table******************************************/

String OldOrdersTableQuery = "select patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.order_id, orders.status,  order_status.order_name  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id where status = 2;";


try {

    Statement statement = connectDB.createStatement();
    ResultSet queryOutput = statement.executeQuery(OldOrdersTableQuery);

    while (queryOutput.next()) {

        String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
        String modalityquery = queryOutput.getString("name");
        String notesquery = queryOutput.getString("notes").trim();
        Integer OrderID = queryOutput.getInt("order_id");
        String statusquery = queryOutput.getString("order_name");
        Integer patients_id = queryOutput.getInt("patient_id");
        Button button = new Button("Review Order");
        button.setStyle(
            "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

        
        button.setOnAction(new EventHandler<ActionEvent>() {



            @Override
            public void handle(ActionEvent event) {
                BlurBox.setEffect(new BoxBlur(5, 10, 10));
        
                 
                   Stage newWindow = new Stage();
             
                AnchorPane anchorpane = new AnchorPane();
              
        
                Label CreateFileLabel = new Label("Create Diagnostic Report");
                CreateFileLabel.setLayoutX(46);
                CreateFileLabel.setLayoutY(47);
                CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");
                
        
              
        
                Label ReportLabel = new Label("Report:");
                ReportLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                ReportLabel.setLayoutX(275);
                ReportLabel.setLayoutY(120);



                TextArea ReportArea = new TextArea();
                ReportArea.setPrefHeight(200);
                ReportArea.setPrefWidth(400);
                ReportArea.setLayoutX(350);
                ReportArea.setLayoutY(120);
                ReportArea.setEditable(false);
            
                String DiagnosticQuery = "select diagnostic from diagnostic_reports where order_id = " + OrderID + ";";

                try {
                    ResultSet DiagnosticReport = statement.executeQuery(DiagnosticQuery);

                    while(DiagnosticReport.next()){
                       String diagnostic = DiagnosticReport.getString("diagnostic");
                       ReportArea.setText(diagnostic);
                       ReportArea.setEditable(false);
                    }
                } catch (SQLException e2) {
   
                    e2.printStackTrace();
                }



        
        
                Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                horizontalline.setOpacity(.3);
                horizontalline.setTranslateY(100);
        
          
               
                Button showImage = new Button("Show Image");
                showImage.setPrefHeight(42);
                showImage.setPrefWidth(100);
                showImage.setLayoutX(70);
                showImage.setLayoutY(120);
                showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");
        
                showImage.setOnAction(new EventHandler<ActionEvent>() {
        
                    /**************  SHOWS IMAGE IN NEW WINDOW *********************************/
                    @Override
                    public void handle(ActionEvent e){
        
                        String ImagePathStatement = "SELECT upload_path FROM db_ris.file_uploads WHERE order_id ='" + OrderID+ "'"; 
                           
                            try {
        
                                Statement statement5 = connectDB.createStatement();
                                ResultSet queryOutput;
                                queryOutput = statement5.executeQuery(ImagePathStatement);
                           
                            while (queryOutput.next()) {
        
                              String UploadPath = queryOutput.getString("upload_path");
                              File file = new File(UploadPath);
                              Image  img = new Image(file.toURI().toString());
                              double width = img.getWidth();
                              double height = img.getHeight();;
        
                                Stage stage = new Stage();
                                AnchorPane pane = new AnchorPane();
                                ImageView imgView = new ImageView(img);
                                
                                imgView.setFitHeight(height);
                                imgView.setFitWidth(width);
                                pane.getChildren().add(imgView);
        
                                Scene scene = new Scene(pane, width, height);
        
                                stage.setScene(scene);
                              
                                stage.setResizable(false);
                                stage.initModality(Modality.APPLICATION_MODAL);
        
                                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                    @Override
                                    public void handle(KeyEvent t) {
                                        KeyCode key = t.getCode();
                                        if (key == KeyCode.ESCAPE) {
                                            stage.close();
                                            BlurBox.setEffect(new BoxBlur(0, 0, 0));
        
                                        }
                                    }
                                });
                                stage.show();
        
                            }
                        } catch (SQLException e1) {
        
                            e1.printStackTrace();
                        }
        
                    }
                });
        //WORKING HERE
                
        
                Button CancelButton = new Button("Cancel");
                CancelButton.setPrefHeight(42);
                CancelButton.setPrefWidth(102);
                CancelButton.setLayoutX(680);
                CancelButton.setLayoutY(338);
                CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");
        
                CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Stage stage = (Stage) CancelButton.getScene().getWindow();
                        stage.close();
                        BlurBox.setEffect(new BoxBlur(0, 0, 0));
        
                    }
                });
        
                        anchorpane.getChildren().add(CreateFileLabel);
        
                        anchorpane.getChildren().add(horizontalline);
                  
                        anchorpane.getChildren().add(CancelButton);
                        anchorpane.getChildren().add(showImage);
                        anchorpane.getChildren().add(ReportArea);
                        anchorpane.getChildren().add(ReportLabel);
                        
                Scene scene = new Scene(anchorpane, 800, 400);
        
                
                newWindow.setScene(scene);
                newWindow.initStyle(StageStyle.UNDECORATED);
                newWindow.setResizable(false);
                newWindow.initModality(Modality.APPLICATION_MODAL);
        
                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent t) {
                        KeyCode key = t.getCode();
                        if (key == KeyCode.ESCAPE) {
                            newWindow.close();
                            BlurBox.setEffect(new BoxBlur(0, 0, 0));
        
                        }
                    }
                });
                newWindow.show();
              }
        });//


        closedOrdersObservableList.add(
                new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery, button));
    }

    OldOrdersPatients.setCellValueFactory(new PropertyValueFactory<>("patient"));

    OldOrdersModality.setCellValueFactory(new PropertyValueFactory<>("modality"));

    OldOrdersNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));

    OldOrdersStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

    OldOrdersResults.setCellValueFactory(new PropertyValueFactory<>("button"));

    OldOrdersTable.setItems(null);
    OldOrdersTable.setItems(closedOrdersObservableList);

    // Search Bar Functionality Start
    FilteredList<PlacedOrdersTableController> ClosedOrdersFilteredData = new FilteredList<>(
        closedOrdersObservableList);

        ClosedOrdersSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        ClosedOrdersFilteredData.setPredicate(TABLEPlacedOrdersTableController -> {
            if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                return true;
            }

            String searchKeyword = newValue.toLowerCase();

            if (TABLEPlacedOrdersTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                return true;

            } else if (TABLEPlacedOrdersTableController.getModality().toLowerCase()
                    .indexOf(searchKeyword) > -1) {
                return true;

            } else if (TABLEPlacedOrdersTableController.getNotes().toLowerCase().indexOf(searchKeyword) > -1) {
                return true;

            } else if (TABLEPlacedOrdersTableController.getStatus().toLowerCase().indexOf(searchKeyword) > -1) {
                return true;

            } else {
                return false; // no match found
            }

        });

    });

    SortedList<PlacedOrdersTableController> ClosedOrdersSortedData = new SortedList<>(
        ClosedOrdersFilteredData);

    // Binds the sorted resultswith the Table
    ClosedOrdersSortedData.comparatorProperty().bind(OldOrdersTable.comparatorProperty());

    OldOrdersTable.setItems(ClosedOrdersSortedData);
    // Search Bar Functionality End

} catch (Exception e) {
e.printStackTrace();        }




        /*
         * 
         * Checked-In Appointments Table
         * 
         */

        // join price modalities.price
        String CheckedInAppointmentsTableQuery = "select a.appointment_id, a.checked_in, a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name, a.order_id from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id where checked_in = 1 AND (closed = 0 || closed IS NULL) order by date_time;"; // change
        // to
        // just
        // like
        // orders
        // select
        // statement
        // still need price
        try {

            Statement statement2 = connectDB.createStatement();
            ResultSet queryOutput = statement2.executeQuery(CheckedInAppointmentsTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String pricequery = queryOutput.getString("price");
                Date date_timequery = queryOutput.getDate("date_time"); // price //may need to change types
                String radiologistquery = queryOutput.getString("full_name");
                Boolean checkedinquestion = queryOutput.getBoolean("checked_in");
                String inProgress = String.valueOf(checkedinquestion);
                inProgress = "In Progress";
                

                CheckedInAppointmentsObservableList.add(new TABLECheckedInAppointmentsTableController(patientquery,
                        modalityquery, date_timequery, radiologistquery, pricequery, checkedinquestion, inProgress));
            }

            CheckedInAppointments_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            CheckedInAppointments_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            CheckedInAppointments_DateandTime.setCellValueFactory(new PropertyValueFactory<>("date_time")); 

            CheckedInAppointments_Radiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));

            CheckedInAppointments_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
            statusColumn.setCellValueFactory(new PropertyValueFactory<>("inprogress"));

            CheckedInAppointmentsTable.setItems(null);
            CheckedInAppointmentsTable.setItems(CheckedInAppointmentsObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLECheckedInAppointmentsTableController> CheckedInAppointmentsFilteredData = new FilteredList<>(
                    CheckedInAppointmentsObservableList);

            searchCheckedInAppointments.textProperty().addListener((observable, oldValue, newValue) -> {
                CheckedInAppointmentsFilteredData.setPredicate(TABLECheckedInAppointmentsTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLECheckedInAppointmentsTableController.getPatient().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLECheckedInAppointmentsTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } /*
                       * else if (TABLECheckedInAppointmentsTableController.getDate_time().indexOf(
                       * searchKeyword) > -1) {
                       * return true;
                       * 
                       * }
                       */ else if (TABLECheckedInAppointmentsTableController.getRadiologist().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (TABLECheckedInAppointmentsTableController.getPrice().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    }

                    else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TABLECheckedInAppointmentsTableController> CheckedInAppointmentsSortedData = new SortedList<>(
                    CheckedInAppointmentsFilteredData);

            // Binds the sorted resultswith the Table
            CheckedInAppointmentsSortedData.comparatorProperty().bind(CheckedInAppointmentsTable.comparatorProperty());

            CheckedInAppointmentsTable.setItems(CheckedInAppointmentsSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
e.printStackTrace();        }

         /*
         * 
         * Checked-In Appointments TECH Table
         * 
         */

        // join price modalities.price
        String TECHCheckedInAppointmentsTableQuery = "select a.appointment_id, a.checked_in, a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name, a.order_id from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id where checked_in = 1 AND (closed = 0 || closed IS NULL) order by date_time;"; 
        // to
        // just
        // like
        // orders
        // select
        // statement
        // still need price
        try {

            Statement statement2 = connectDB.createStatement();
            ResultSet queryOutput = statement2.executeQuery(TECHCheckedInAppointmentsTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String pricequery = queryOutput.getString("price");
                Date date_timequery = queryOutput.getDate("date_time"); // price //may need to change types
                String radiologistquery = queryOutput.getString("full_name");
                Boolean checkedinquestion = queryOutput.getBoolean("checked_in");
                Integer Order_id = queryOutput.getInt("order_id");
                Button button = new Button("Complete Order");
                Integer appointment_id = queryOutput.getInt("appointment_id");

                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");
    

//Completes Order
button.setOnAction(new EventHandler<ActionEvent>() {

    String extension;
    String fileName;
   
    @Override
    public void handle(ActionEvent event) {
        BlurBox.setEffect(new BoxBlur(5, 10, 10));
         
           Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
       

        Label CreateFileLabel = new Label("Upload Files to Order");
        CreateFileLabel.setLayoutX(46);
        CreateFileLabel.setLayoutY(47);
        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label UploadLabel = new Label("Upload:");
        UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        UploadLabel.setLayoutX(47);
        UploadLabel.setLayoutY(192);

    
     

        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);


        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");

        FileChooser fil_chooser = new FileChooser();
        fil_chooser.getExtensionFilters().add(extFilter);

        Label label = new Label("No file chosen");
        label.setPrefHeight(30);
        label.setPrefWidth(340);
        label.setLayoutX(127);
        label.setLayoutY(227);
        Button button = new Button("Select File");
        button.setPrefHeight(30);
        button.setPrefWidth(70);
        button.setLayoutX(47);
        button.setLayoutY(227);

       
        EventHandler<ActionEvent> event1 =
        new EventHandler<ActionEvent>() {

           
            public void handle(ActionEvent e)
            {
 
               
                File file = fil_chooser.showOpenDialog(newWindow);
 
                if (file != null) {

                    label.setText(file.getAbsolutePath());               
                }
            }
        };
        button.setOnAction(event1);
        

        Button showImage = new Button("Show Image");
        showImage.setPrefHeight(42);
        showImage.setPrefWidth(100);
        showImage.setLayoutX(170);
        showImage.setLayoutY(280);
        showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        showImage.setOnAction(new EventHandler<ActionEvent>() {

            /**************  SHOWS IMAGE IN NEW WINDOW *********************************/
            @Override
            public void handle(ActionEvent e){


                      String UploadPath = label.getText();
                      File file = new File(UploadPath);
                      Image  img = new Image(file.toURI().toString());
                      double width = img.getWidth();
                      double height = img.getHeight();;

                        Stage stage = new Stage();
                        AnchorPane pane = new AnchorPane();
                        ImageView imgView = new ImageView(img);
                        
                        imgView.setFitHeight(height);
                        imgView.setFitWidth(width);
                        pane.getChildren().add(imgView);

                        Scene scene = new Scene(pane, width, height);

                        stage.setScene(scene);
                      
                        stage.setResizable(false);
                        stage.initModality(Modality.APPLICATION_MODAL);

                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent t) {
                                KeyCode key = t.getCode();
                                if (key == KeyCode.ESCAPE) {
                                    stage.close();
                                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                }
                            }
                        });
                        stage.show();
   

            }
        });

      Button UploadFileButton = new Button("Complete Order");
        UploadFileButton.setPrefHeight(42);
        UploadFileButton.setPrefWidth(102);
        UploadFileButton.setLayoutX(565);
        UploadFileButton.setLayoutY(338);
        UploadFileButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        UploadFileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                  


                    
                  


                    try {

                       
                        int index =  label.getText().lastIndexOf('.');
                 
                        if(index > 0) {
                          extension  = label.getText().substring(index + 1);
                    
                        } 
                        if(index > 0) {
                       
                            java.nio.file.Path path = Paths.get(label.getText());         
                           fileName = path.getFileName().toString();
                        }
    

                        DatabaseConnection connectNow = new DatabaseConnection();
                        Connection connectDB = connectNow.getConnection();
    
                        String UpdateAppointmentsTable = "update appointments set closed = true where appointment_id = " + appointment_id + ";";
                        Statement statement = connectDB.createStatement();
                        PreparedStatement statement2 = null;

                        statement2 = connectDB.prepareStatement("insert into file_uploads (order_id, file_name, file_type, is_active, upload_path) values (?, ?, ?, ?, ?)");
                        statement2.setInt(1, Order_id);
                        statement2.setString(2, fileName);
                        statement2.setString(3, extension);
                        statement2.setBoolean(4, true);
                        statement2.setString(5, label.getText());
                        statement2.executeUpdate();

                        statement.execute(UpdateAppointmentsTable); 
                        
                        Stage stage = (Stage) UploadFileButton.getScene().getWindow();
    
                        stage.close();
                        BlurBox.setEffect(new BoxBlur(0, 0, 0));


                        FXApp.setRoot("ADMIN");

                    } catch (SQLException e1) {
    
                        e1.printStackTrace();
                    }
    







                 
                } catch (Exception e2) {
                        e2.printStackTrace();
                    }

            }
        });
        

        Button CancelButton = new Button("Cancel");
        CancelButton.setPrefHeight(42);
        CancelButton.setPrefWidth(102);
        CancelButton.setLayoutX(680);
        CancelButton.setLayoutY(338);
        CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = (Stage) CancelButton.getScene().getWindow();
                stage.close();
                BlurBox.setEffect(new BoxBlur(0, 0, 0));

            }
        });

                anchorpane.getChildren().add(CreateFileLabel);
                anchorpane.getChildren().add(UploadLabel);
             
                anchorpane.getChildren().add(horizontalline);
             
                anchorpane.getChildren().add(button);
                anchorpane.getChildren().add(label);
                anchorpane.getChildren().add(CancelButton);
                anchorpane.getChildren().add(UploadFileButton);
                anchorpane.getChildren().add(showImage);

        Scene scene = new Scene(anchorpane, 800, 400);

        
        newWindow.setScene(scene);
        newWindow.initStyle(StageStyle.UNDECORATED);
        newWindow.setResizable(false);
        newWindow.initModality(Modality.APPLICATION_MODAL);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                KeyCode key = t.getCode();
                if (key == KeyCode.ESCAPE) {
                    newWindow.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                }
            }
        });
        newWindow.show();
      }
});// CLOSES Complete Order




                

                TECHCheckedInAppointmentsObservableList.add(new TECHCheckedInAppointmentsTableController(patientquery,
                        modalityquery, date_timequery, radiologistquery, pricequery, checkedinquestion, button));
            }

            CheckedInAppointments_Patient1.setCellValueFactory(new PropertyValueFactory<>("patient"));

            CheckedInAppointments_Modality1.setCellValueFactory(new PropertyValueFactory<>("modality"));

            CheckedInAppointments_DateandTime1.setCellValueFactory(new PropertyValueFactory<>("date_time")); // price

            CheckedInAppointments_Radiologist1.setCellValueFactory(new PropertyValueFactory<>("radiologist"));

            CheckedInAppointments_Price1.setCellValueFactory(new PropertyValueFactory<>("price"));
            TechCheckedInCompleteOrder.setCellValueFactory(new PropertyValueFactory<>("button"));

            TECHNICIANCheckedInAppointmentsTable1.setItems(null);
            TECHNICIANCheckedInAppointmentsTable1.setItems(TECHCheckedInAppointmentsObservableList);

            // Search Bar Functionality Start
            FilteredList<TECHCheckedInAppointmentsTableController> TECHCheckedInAppointmentsFilteredData = new FilteredList<>(
                TECHCheckedInAppointmentsObservableList);

                    searchCheckedInAppointments1.textProperty().addListener((observable, oldValue, newValue) -> {
                        TECHCheckedInAppointmentsFilteredData.setPredicate(TECHCheckedInAppointmentsTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TECHCheckedInAppointmentsTableController.getPatient().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TECHCheckedInAppointmentsTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } /*
                       * else if (TABLECheckedInAppointmentsTableController.getDate_time().indexOf(
                       * searchKeyword) > -1) {
                       * return true;
                       * 
                       * }
                       */ else if (TECHCheckedInAppointmentsTableController.getRadiologist().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (TECHCheckedInAppointmentsTableController.getPrice().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    }

                    else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TECHCheckedInAppointmentsTableController> TECHCheckedInAppointmentsSortedData = new SortedList<>(
                TECHCheckedInAppointmentsFilteredData);

            // Binds the sorted resultswith the Table
            TECHCheckedInAppointmentsSortedData.comparatorProperty().bind(TECHNICIANCheckedInAppointmentsTable1.comparatorProperty());

            TECHNICIANCheckedInAppointmentsTable1.setItems(TECHCheckedInAppointmentsSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
e.printStackTrace();        }
       
/*
         * 
         * Today's Appointments Table
         * 
         */

        String TodaysAppointmentsTableQuery = "select a.appointment_id, a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id where date(date_time) = (select date(now())) AND (a.checked_in = false || a.checked_in IS NULL  )order by date_time;";

        // date time for todays date!

        try {

            Statement statement3 = connectDB.createStatement();
            ResultSet queryOutput = statement3.executeQuery(TodaysAppointmentsTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                Date date_timequery = queryOutput.getDate("date_time"); // price //may need to change types
                String radiologistquery = queryOutput.getString("full_name");
                String pricequery = queryOutput.getString("price");
                Button button = new Button("Check-in");
                Integer appointmentID = queryOutput.getInt("appointment_id");
                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");


                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                   
                        try {
                            DatabaseConnection connectNow = new DatabaseConnection();
                            Connection connectDB = connectNow.getConnection();
                            
                            String CheckInAppoint = "UPDATE appointments set checked_in = true where appointment_id = " +appointmentID + ";";
                            Statement statement4 = connectDB.createStatement();
                           statement4.execute(CheckInAppoint);
                           try {
                            FXApp.setRoot("ADMIN");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        }
                            catch (SQLException e) {
                             
                                e.printStackTrace();
                            }
                

        
                    }
                
        

                });























                TodaysAppointmentsObservableList.add(new TABLETodaysAppointmentsTableController(patientquery,
                        modalityquery, date_timequery, radiologistquery, pricequery, button));
            }

            TodaysAppointments_Patient1.setCellValueFactory(new PropertyValueFactory<>("patient"));

            TodaysAppointmentsTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            TodaysAppointmentsTable_DateandTime.setCellValueFactory(new PropertyValueFactory<>("date_time")); // price

            TodaysAppointmentsTable_Radiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));

            TodaysAppointmentsTable_Prices.setCellValueFactory(new PropertyValueFactory<>("price"));

            TodaysAppointmentsCheckedIN.setCellValueFactory(new PropertyValueFactory<>("button"));

            TodaysAppointmentsTable.setItems(null);
            TodaysAppointmentsTable.setItems(TodaysAppointmentsObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLETodaysAppointmentsTableController> TodaysAppointmentsFilteredData = new FilteredList<>(
                    TodaysAppointmentsObservableList);

            searchTodaysAppointments.textProperty().addListener((observable, oldValue, newValue) -> {
                TodaysAppointmentsFilteredData.setPredicate(TABLETodaysAppointmentsTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLETodaysAppointmentsTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLETodaysAppointmentsTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    }  else if (TABLETodaysAppointmentsTableController.getRadiologist().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (TABLETodaysAppointmentsTableController.getPrice().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TABLETodaysAppointmentsTableController> TodaysAppointmentsSortedData = new SortedList<>(
                    TodaysAppointmentsFilteredData);

            // Binds the sorted resultswith the Table
            TodaysAppointmentsSortedData.comparatorProperty().bind(TodaysAppointmentsTable.comparatorProperty());

            TodaysAppointmentsTable.setItems(TodaysAppointmentsSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
e.printStackTrace();        }



        /*
         * 
         * Unscheduled Appointments Table
         * 
         */

        String UnscheduledOrdersTableQuery = "select p.first_name, p.last_name, md.full_name, m.name, o.notes, o.order_id from orders as o left join patients as p on o.patient = p.patient_id left join order_status as os on o.status = os.order_status_id left join referralmds as md on o.referral_md = md.id left join modalities as m on m.modality_id = o.modality where o.appointment IS NULL;"; // change
        // to
        // just
        // like
        // orders
        // select
        // statement

        try {

            Statement statement4 = connectDB.createStatement();
            ResultSet queryOutput = statement4.executeQuery(UnscheduledOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String referral_mdquery = queryOutput.getString("full_name");
                String modalityquery = queryOutput.getString("name"); // might need to change types
                String notesquery = queryOutput.getString("notes");
                Integer OrderID = queryOutput.getInt("order_id");
                Button button = new Button("Schedule");
                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

 // Create Appointment for order
 button.setOnAction(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {

        BlurBox.setEffect(new BoxBlur(5, 10, 10));



        VBox vbox = new VBox();

        

        Pane newPane = new Pane();
        newPane.setLayoutX(0);
        newPane.setLayoutY(0);
        newPane.setPrefHeight(109);
        newPane.setPrefWidth(800);

        Label CreateNewAppointmentsLabel = new Label("Create New Appointment");
        CreateNewAppointmentsLabel.setStyle("-fx-font: normal bold 32px 'arial';");
        CreateNewAppointmentsLabel.setLayoutX(25);
        CreateNewAppointmentsLabel.setLayoutY(0);
        CreateNewAppointmentsLabel.setMinHeight(90);
        CreateNewAppointmentsLabel.setMinWidth(410);

        Line horizontalline = new Line(22.0f, 0.0f, 769.0f, 0.0f);
        horizontalline.setTranslateY(100);
        horizontalline.setOpacity(.3);
        
        newPane.getChildren().add(CreateNewAppointmentsLabel);
        newPane.getChildren().add(horizontalline);

       

        Pane contactInfoPane = new Pane();
        contactInfoPane.setPrefHeight(198);
        contactInfoPane.setPrefWidth(800);

        Label ContactInfoLable = new Label("Contact Info");
        ContactInfoLable.setStyle("-fx-font: normal bold 20px 'arial';");
        ContactInfoLable.setMinHeight(38);
        ContactInfoLable.setMinWidth(128);
        ContactInfoLable.setLayoutX(22);
        ContactInfoLable.setLayoutY(47);

        Line horizontallineContactINfo = new Line(22.0f, 0.0f, 769.0f, 0.0f);
        horizontallineContactINfo.setTranslateY(100);
        horizontallineContactINfo.setOpacity(.3);



        Label phoneNumberLabel = new Label("Phone Number:");
        phoneNumberLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        phoneNumberLabel.setMinHeight(27);
        phoneNumberLabel.setMinWidth(128);
        phoneNumberLabel.setLayoutX(22);
        phoneNumberLabel.setLayoutY(119);

        Label EmailAddressLabel = new Label("Email Address:");
        EmailAddressLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        EmailAddressLabel.setMinHeight(27);
        EmailAddressLabel.setMinWidth(128);
        EmailAddressLabel.setLayoutX(209);
        EmailAddressLabel.setLayoutY(119);

        Label DateLabel = new Label("Appointment Date:");
        DateLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        DateLabel.setMinHeight(27);
        DateLabel.setMinWidth(128);
        DateLabel.setLayoutX(396);
        DateLabel.setLayoutY(119);

        Label TimeLabel = new Label("Appointment Time:");
        TimeLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        TimeLabel.setMinHeight(27);
        TimeLabel.setMinWidth(128);
        TimeLabel.setLayoutX(605);
        TimeLabel.setLayoutY(119);


        TextField phoneNumberField = new TextField();
        phoneNumberField.setMinHeight(35);
        phoneNumberField.setMinWidth(145);
        phoneNumberField.setLayoutX(22);
        phoneNumberField.setLayoutY(160);
        phoneNumberField.setPromptText("    000-000-0000");

        TextField emailAddressField = new TextField();
        emailAddressField.setMinHeight(35);
        emailAddressField.setMinWidth(145);
        emailAddressField.setLayoutX(209);
        emailAddressField.setLayoutY(160);
        emailAddressField.setPromptText("demo@example.com");

        DatePicker AppointmentDatePicker = new DatePicker();
        AppointmentDatePicker.setMinHeight(35);
        AppointmentDatePicker.setMinWidth(166);
        AppointmentDatePicker.setLayoutX(396);
        AppointmentDatePicker.setLayoutY(160);


        ChoiceBox<String> SelectedAppointmentTime = new ChoiceBox<String>();
        SelectedAppointmentTime.setStyle("-fx-font: normal bold 16px 'arial';");
        SelectedAppointmentTime.setMinHeight(35);
        SelectedAppointmentTime.setMaxWidth(170);
        SelectedAppointmentTime.setLayoutX(599);
        SelectedAppointmentTime.setLayoutY(160);
        SelectedAppointmentTime.setPrefHeight(210);
        SelectedAppointmentTime.setMaxHeight(35);
        SelectedAppointmentTime.setPrefWidth(170);


        SelectedAppointmentTime.getItems().add("1:00");
        SelectedAppointmentTime.getItems().add("2:00");
        SelectedAppointmentTime.getItems().add("3:00");
        SelectedAppointmentTime.getItems().add("4:00");
        SelectedAppointmentTime.getItems().add("5:00");
        SelectedAppointmentTime.getItems().add("6:00");
        SelectedAppointmentTime.getItems().add("7:00");
        SelectedAppointmentTime.getItems().add("8:00");
        SelectedAppointmentTime.getItems().add("9:00");
        SelectedAppointmentTime.getItems().add("10:00");
        SelectedAppointmentTime.getItems().add("11:00");
        SelectedAppointmentTime.getItems().add("12:00");
        SelectedAppointmentTime.getItems().add("13:00");
        SelectedAppointmentTime.getItems().add("14:00");
        SelectedAppointmentTime.getItems().add("15:00");
        SelectedAppointmentTime.getItems().add("16:00");
        SelectedAppointmentTime.getItems().add("17:00");
        SelectedAppointmentTime.getItems().add("18:00");
        SelectedAppointmentTime.getItems().add("19:00");
        SelectedAppointmentTime.getItems().add("20:00");
        SelectedAppointmentTime.getItems().add("21:00");
        SelectedAppointmentTime.getItems().add("22:00");
        SelectedAppointmentTime.getItems().add("23:00");
        SelectedAppointmentTime.getItems().add("24:00");




        contactInfoPane.getChildren().add(ContactInfoLable);
        contactInfoPane.getChildren().add(horizontallineContactINfo);
        contactInfoPane.getChildren().add(phoneNumberLabel);
        contactInfoPane.getChildren().add(EmailAddressLabel);
        contactInfoPane.getChildren().add(DateLabel);
        contactInfoPane.getChildren().add(TimeLabel);
        contactInfoPane.getChildren().add(phoneNumberField);
        contactInfoPane.getChildren().add(emailAddressField);
        contactInfoPane.getChildren().add(SelectedAppointmentTime);
        contactInfoPane.getChildren().add(AppointmentDatePicker);

  
      Pane OfficeInfoPane = new Pane();
      OfficeInfoPane.setPrefHeight(425);
      OfficeInfoPane.setPrefWidth(800);

      Label OfficeInfoLabel = new Label("Office Info");
      OfficeInfoLabel.setStyle("-fx-font: normal bold 20px 'arial';");
      OfficeInfoLabel.setMinHeight(38);
      OfficeInfoLabel.setMinWidth(128);
      OfficeInfoLabel.setLayoutX(22);
      OfficeInfoLabel.setLayoutY(47);

      Line HorizontalLineOfficeIn = new Line(22.0f, 0.0f, 769.0f, 0.0f);
      HorizontalLineOfficeIn.setTranslateY(100);
      HorizontalLineOfficeIn.setOpacity(.3);
/*
      Label OrderLabel = new Label("Order:");
      OrderLabel.setStyle("-fx-font: normal bold 16px 'arial';");
      OrderLabel.setMinHeight(27); Leave Commented for Box Layout
      OrderLabel.setMinWidth(128);
      OrderLabel.setLayoutX(22);
      OrderLabel.setLayoutY(119);
*/
      Label ModalityLabel = new Label("Modality:");
      ModalityLabel.setStyle("-fx-font: normal bold 16px 'arial';");
      ModalityLabel.setMinHeight(27);
      ModalityLabel.setMinWidth(128);
      ModalityLabel.setLayoutX(260);
      ModalityLabel.setLayoutY(119);

      Label RadiologistLabel = new Label("Radiologist:");
      RadiologistLabel.setStyle("-fx-font: normal bold 16px 'arial';");
      RadiologistLabel.setMinHeight(27);
      RadiologistLabel.setMinWidth(128);
      RadiologistLabel.setLayoutX(522);
      RadiologistLabel.setLayoutY(119);

      Label EstimatedCostsLabel = new Label("Estimated Costs:");
      EstimatedCostsLabel.setStyle("-fx-font: normal bold 16px 'arial';");
      EstimatedCostsLabel.setMinHeight(27);
      EstimatedCostsLabel.setMinWidth(128);
      EstimatedCostsLabel.setLayoutX(22);
      EstimatedCostsLabel.setLayoutY(225);

      Label PatientLabel = new Label("Patient:");
      PatientLabel.setStyle("-fx-font: normal bold 16px 'arial';");
      PatientLabel.setMinHeight(27);
      PatientLabel.setMinWidth(128);
      PatientLabel.setLayoutX(260);
      PatientLabel.setLayoutY(225);

    
      TextField ModalityField = new TextField();
      ModalityField.setMinHeight(35);
      ModalityField.setMinWidth(170);
      ModalityField.setLayoutX(260);
      ModalityField.setLayoutY(160);
      ModalityField.setEditable(false);
      ModalityField.setText(modalityquery);
      


      TextField patientfortheorder = new TextField();
      patientfortheorder.setPrefHeight(35);
      patientfortheorder.setPrefWidth(170);
      patientfortheorder.setLayoutX(260);
      patientfortheorder.setLayoutY(270);
      patientfortheorder.setEditable(false);
      patientfortheorder.setText(patientquery);
      

  

        
       
        

/*
      ChoiceBox<String> OrdersChoiceBox = new ChoiceBox<String>();
      OrdersChoiceBox.setPrefHeight(35);
      OrdersChoiceBox.setPrefWidth(170);
      OrdersChoiceBox.setLayoutX(22);
      OrdersChoiceBox.setLayoutY(160);

      // Adds Orders to the Box
      try {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
 Leave Commented for Box Layout
        String GetChoiceBoxQuery = "SELECT * FROM orders where appointment IS NULL";
        Statement statement = connectDB.createStatement();
        ResultSet OrdersOutput = statement.executeQuery(GetChoiceBoxQuery);

        while (OrdersOutput.next()) {
            Orders currentitterationpatient = new Orders(OrdersOutput.getInt("order_id"));
            OrdersChoiceBox.getItems().add(currentitterationpatient.getOrders().toString());
        }

    } catch (SQLException e1) {

        e1.printStackTrace();
    }
*/
      
      ChoiceBox<String> RadiologistChoiceBox = new ChoiceBox<String>();
      RadiologistChoiceBox.setPrefHeight(35);
      RadiologistChoiceBox.setPrefWidth(170);
      RadiologistChoiceBox.setLayoutX(522);
      RadiologistChoiceBox.setLayoutY(160);

// Adds Radiologists to the Box
try {
    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    String GetChoiceBoxQuery = "Select * from radiologists";
    Statement statement = connectDB.createStatement();
    ResultSet radiologistsQuery = statement.executeQuery(GetChoiceBoxQuery);

    while (radiologistsQuery.next()) {
        Radiologists currentRadiologist = new Radiologists(radiologistsQuery.getInt("id"), radiologistsQuery.getString("full_name"));
        RadiologistChoiceBox.getItems().add(currentRadiologist.getRadiologistName());
    }

} catch (SQLException e1) {

    e1.printStackTrace();
}



TextField EstinatedCosts = new TextField();
EstinatedCosts.setMinHeight(35);
EstinatedCosts.setMinWidth(170);
EstinatedCosts.setLayoutX(22);
EstinatedCosts.setLayoutY(270);
EstinatedCosts.setEditable(false);






        OfficeInfoPane.getChildren().add(OfficeInfoLabel);
        OfficeInfoPane.getChildren().add(HorizontalLineOfficeIn);
        OfficeInfoPane.getChildren().add(ModalityLabel);
        OfficeInfoPane.getChildren().add(RadiologistLabel);
        OfficeInfoPane.getChildren().add(EstimatedCostsLabel);
        OfficeInfoPane.getChildren().add(RadiologistChoiceBox);
        OfficeInfoPane.getChildren().add(PatientLabel);
        OfficeInfoPane.getChildren().add(patientfortheorder);
        OfficeInfoPane.getChildren().add(EstinatedCosts);
        OfficeInfoPane.getChildren().add(ModalityField);
     
        Pane BottomPane = new Pane();
        BottomPane.setPrefHeight(70);
        BottomPane.setPrefWidth(800);

        Button SaveUserButton = new Button("Create Appointment");
        SaveUserButton.setPrefHeight(42);
        SaveUserButton.setPrefWidth(102);
        SaveUserButton.setLayoutX(472);
        SaveUserButton.setLayoutY(15);
        SaveUserButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        SaveUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                try {
                    DatabaseConnection connectNow = new DatabaseConnection();
                    Connection connectDB = connectNow.getConnection();
                    
                    String GetRadiologistIDQuery = "select * from radiologists where full_name = '" + RadiologistChoiceBox.getValue() + "';";
                    String GetPatientQuery = "select order_id, patient, modality from orders where order_id = '" + OrderID + "';";
                    
                    Statement RadiologistStatement = connectDB.createStatement();
                    Statement PatientStatement = connectDB.createStatement();
                    ResultSet queryOutput = RadiologistStatement.executeQuery(GetRadiologistIDQuery);
                    ResultSet queryOutput2 = PatientStatement.executeQuery(GetPatientQuery);

                    while (queryOutput.next() && queryOutput2.next()){ 
                        
                    Integer radioID = queryOutput.getInt("id");
                    Integer patientID = queryOutput2.getInt("patient");  
                    Integer modality = queryOutput2.getInt("modality");

                    String InsertIntoUsersTableQuery = "insert into appointments (patient, order_id, modality, date_time, radiologist, phone_number, email_address) values ('" + patientID + "', '" + OrderID + "', '" + modality + "', '"+ AppointmentDatePicker.getValue() + " " + SelectedAppointmentTime.getValue() + "', '" + radioID + "', '"+ phoneNumberField.getText() +"', '"+ emailAddressField.getText() +"')";
                    String GetAppointmentID = "select appointment_id from appointments where order_id = '" + OrderID + "';";

                    Statement NewAppointmentStatemnet = connectDB.createStatement();
                    NewAppointmentStatemnet.execute(InsertIntoUsersTableQuery);

                    Statement AppointmentIDStatement = connectDB.createStatement();
                    ResultSet queryOutput3 = AppointmentIDStatement.executeQuery(GetAppointmentID);

                    while(queryOutput3.next()){

                        Integer appointmentID = queryOutput3.getInt("appointment_id");

                        String InsertAppointmentID = "update orders set appointment = '" + appointmentID + "' where order_id = '" + OrderID + "';";

                        Statement InsertAppointmentIDStatement = connectDB.createStatement();
                        InsertAppointmentIDStatement.execute(InsertAppointmentID);
                    }
                    
                }

                    Stage stage = (Stage) SaveUserButton.getScene().getWindow();

                    stage.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));



                    FXApp.setRoot("ADMIN");
                    
                } catch (SQLException e1) {

                    e1.printStackTrace();
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                
               
            }

        });
        

        Button CancelButton = new Button("Cancel");
        CancelButton.setPrefHeight(42);
        CancelButton.setPrefWidth(102);
        CancelButton.setLayoutX(644);
        CancelButton.setLayoutY(15);
        CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = (Stage) CancelButton.getScene().getWindow();
                stage.close();
                BlurBox.setEffect(new BoxBlur(0, 0, 0));

            }
        });

        BottomPane.getChildren().add(SaveUserButton);
        BottomPane.getChildren().add(CancelButton);

        vbox.getChildren().add(newPane);

        vbox.getChildren().add(contactInfoPane);
        vbox.getChildren().add(OfficeInfoPane);
        vbox.getChildren().add(BottomPane);

        Scene scene = new Scene(vbox , 800, 800);

        Stage newWindow = new Stage();
        newWindow.setScene(scene);
        newWindow.initStyle(StageStyle.UNDECORATED);
        newWindow.setResizable(false);
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.setTitle("Edit User INfo");

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                KeyCode key = t.getCode();
                if (key == KeyCode.ESCAPE) {
                    newWindow.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                }
            }
        });
        newWindow.show();
    }
}); //Closes Create Appointment for order







                UnscheduledOrdersObservableList.add(new TABLEUnscheduledOrdersTableController(patientquery,
                        referral_mdquery, modalityquery, notesquery, button));
            }

            UnscheduledOrdersTable_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            UnscheduledOrdersTable_ReferralMD.setCellValueFactory(new PropertyValueFactory<>("referral_md"));

            UnscheduledOrdersTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            UnscheduledOrdersTable_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));

            UnscheduledOrdersSchedule.setCellValueFactory(new PropertyValueFactory<>("button"));

            UnscheduledOrdersTable.setItems(null);
            UnscheduledOrdersTable.setItems(UnscheduledOrdersObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLEUnscheduledOrdersTableController> UnscheduledOrdersFilteredData = new FilteredList<>(
                    UnscheduledOrdersObservableList);

            searchUnscheduledOrders.textProperty().addListener((observable, oldValue, newValue) -> {
                UnscheduledOrdersFilteredData.setPredicate(TABLEUnscheduledOrdersTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLEUnscheduledOrdersTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEUnscheduledOrdersTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEUnscheduledOrdersTableController.getReferral_md().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (TABLEUnscheduledOrdersTableController.getNotes().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TABLEUnscheduledOrdersTableController> UnscheduledOrdersSortedData = new SortedList<>(
                    UnscheduledOrdersFilteredData);

            // Binds the sorted resultswith the Table
            UnscheduledOrdersSortedData.comparatorProperty().bind(UnscheduledOrdersTable.comparatorProperty());

            UnscheduledOrdersTable.setItems(UnscheduledOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            System.out.println("error");
        }

        /*
         * 
         * Review Imaging Orders Table
         * 
         */
        String ReviewImagingOrdersTableQuery = "select *  from orders as o join patients as p on p.patient_id = o.patient  join appointments as a on a.appointment_id = o.appointment  where a.closed = true and report IS NULL;"; 
        try {

            Statement statement5 = connectDB.createStatement();
            ResultSet queryOutput = statement5.executeQuery(ReviewImagingOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                Integer referral_mdquery = queryOutput.getInt("referral_md");
                Integer radiologistID = queryOutput.getInt("radiologist");
                Integer modalityquery = queryOutput.getInt("modality"); // might need to change types
                String notesquery = queryOutput.getString("notes");
                Button button = new Button("Review Order");
                Integer OrderID = queryOutput.getInt("order_id");
                Integer patientID = queryOutput.getInt("patient");
                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

                 
/*
                    String ImagePathStatement = "SELECT upload_path FROM db_ris.file_uploads WHERE order_id ='" + OrderID+ "'"; 
                    statement5 = connectDB.createStatement();
                    queryOutput = statement5.executeQuery(ImagePathStatement);
                    while (queryOutput.next()) {
                        String UploadPath = queryOutput.getString("upload_path");
                      BufferedImage  img = ImageIO.read(new File(UploadPath));
                    }*/
            


/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////// NOT FINISHED

/////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////
button.setOnAction(new EventHandler<ActionEvent>() {

    
   
    @Override
    public void handle(ActionEvent event) {
        BlurBox.setEffect(new BoxBlur(5, 10, 10));

         
           Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
      

        Label CreateFileLabel = new Label("Create Diagnostic Report");
        CreateFileLabel.setLayoutX(46);
        CreateFileLabel.setLayoutY(47);
        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

      

        Label ReportLabel = new Label("Report:");
        ReportLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        ReportLabel.setLayoutX(275);
        ReportLabel.setLayoutY(120);
     

        
        TextArea ReportArea = new TextArea();
        ReportArea.setPrefHeight(200);
        ReportArea.setPrefWidth(400);
        ReportArea.setLayoutX(350);
        ReportArea.setLayoutY(120);


        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

  
       
        Button showImage = new Button("Show Image");
        showImage.setPrefHeight(42);
        showImage.setPrefWidth(100);
        showImage.setLayoutX(70);
        showImage.setLayoutY(120);
        showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        showImage.setOnAction(new EventHandler<ActionEvent>() {

            /**************  SHOWS IMAGE IN NEW WINDOW *********************************/
            @Override
            public void handle(ActionEvent e){

                String ImagePathStatement = "SELECT upload_path FROM db_ris.file_uploads WHERE order_id ='" + OrderID+ "'"; 
                   
                    try {

                        Statement statement5 = connectDB.createStatement();
                        ResultSet queryOutput;
                        queryOutput = statement5.executeQuery(ImagePathStatement);
                   
                    while (queryOutput.next()) {

                      String UploadPath = queryOutput.getString("upload_path");
                      File file = new File(UploadPath);
                      Image  img = new Image(file.toURI().toString());
                      double width = img.getWidth();
                      double height = img.getHeight();;

                        Stage stage = new Stage();
                        AnchorPane pane = new AnchorPane();
                        ImageView imgView = new ImageView(img);
                        
                        imgView.setFitHeight(height);
                        imgView.setFitWidth(width);
                        pane.getChildren().add(imgView);

                        Scene scene = new Scene(pane, width, height);

                        stage.setScene(scene);
                      
                        stage.setResizable(false);
                        stage.initModality(Modality.APPLICATION_MODAL);

                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent t) {
                                KeyCode key = t.getCode();
                                if (key == KeyCode.ESCAPE) {
                                    stage.close();
                                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                }
                            }
                        });
                        stage.show();

                    }
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

            }
        });
//WORKING HERE

      Button CreateDiagnosticReportButton = new Button("Create Report");
        CreateDiagnosticReportButton.setPrefHeight(42);
        CreateDiagnosticReportButton.setPrefWidth(102);
        CreateDiagnosticReportButton.setLayoutX(565);
        CreateDiagnosticReportButton.setLayoutY(338);
        CreateDiagnosticReportButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        CreateDiagnosticReportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
           
                try {
                    DatabaseConnection connectNow = new DatabaseConnection();
                    Connection connectDB = connectNow.getConnection();
    
                    String InsertIntoOrdersReport = "update orders set report = '1', status = '3' where order_id = '"+ OrderID+ "';" ;

                
                        String InsertIntoUsersTableQuery = "insert into diagnostic_reports (order_id,  patient,radiologist, diagnostic) values ('"+ OrderID+ "', '" + patientID + "', '" + radiologistID + "', '"+ ReportArea.getText() + "');";
                        Statement statement = connectDB.createStatement();
                        Statement  statement2 = connectDB.createStatement();

                        statement.execute(InsertIntoUsersTableQuery);

                        statement2.execute(InsertIntoOrdersReport);


                        Stage stage = (Stage) CreateDiagnosticReportButton.getScene().getWindow();
            



                        stage.close();
                        BlurBox.setEffect(new BoxBlur(0, 0, 0));
        
                        FXApp.setRoot("ADMIN");
        
              
        
        
                  
        
                }
                catch (SQLException e2){
        
                    e2.printStackTrace();
                } catch (IOException e1) {
           
                    e1.printStackTrace();
                }
            }
        });
        

        Button CancelButton = new Button("Cancel");
        CancelButton.setPrefHeight(42);
        CancelButton.setPrefWidth(102);
        CancelButton.setLayoutX(680);
        CancelButton.setLayoutY(338);
        CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = (Stage) CancelButton.getScene().getWindow();
                stage.close();
                BlurBox.setEffect(new BoxBlur(0, 0, 0));

            }
        });

                anchorpane.getChildren().add(CreateFileLabel);

                anchorpane.getChildren().add(horizontalline);
          
                anchorpane.getChildren().add(CancelButton);
                anchorpane.getChildren().add(CreateDiagnosticReportButton);
                anchorpane.getChildren().add(showImage);
                anchorpane.getChildren().add(ReportArea);
                anchorpane.getChildren().add(ReportLabel);
                
        Scene scene = new Scene(anchorpane, 800, 400);

        
        newWindow.setScene(scene);
        newWindow.initStyle(StageStyle.UNDECORATED);
        newWindow.setResizable(false);
        newWindow.initModality(Modality.APPLICATION_MODAL);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                KeyCode key = t.getCode();
                if (key == KeyCode.ESCAPE) {
                    newWindow.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                }
            }
        });
        newWindow.show();
      }
});//




                ReviewImagingOrdersObservableList.add(new TABLEReviewImagingOrdersTableController(patientquery,referral_mdquery, modalityquery, notesquery, button));
            }

            ReviewImagingOrdersTable_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            ReviewImagingOrdersTable_RefferalMD.setCellValueFactory(new PropertyValueFactory<>("referral_md"));

            ReviewImagingOrdersTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            ReviewImagingOrdersTable_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
            ReviewOrderColumn.setCellValueFactory(new PropertyValueFactory<>("button"));

            ReviewImagingOrdersTable.setItems(null);
            ReviewImagingOrdersTable.setItems(ReviewImagingOrdersObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLEReviewImagingOrdersTableController> ReviewImagingOrdersFilteredData = new FilteredList<>(
                    ReviewImagingOrdersObservableList);

            searchReviewImagineOrders.textProperty().addListener((observable, oldValue, newValue) -> {
                ReviewImagingOrdersFilteredData.setPredicate(TABLEReviewImagingOrdersTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLEReviewImagingOrdersTableController.getPatient().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } /*else if (TABLEReviewImagingOrdersTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } 
                        else if
                       (TABLEReviewImagingOrdersTableController.getDate_time().toLowerCase().indexOf
                       (searchKeyword) > -1) {
                        return true;
                       
                       }
                        else if (TABLEReviewImagingOrdersTableController.getReferral_md().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } */else if (TABLEReviewImagingOrdersTableController.getNotes().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TABLEReviewImagingOrdersTableController> ReviewImagingOrdersSortedData = new SortedList<>(
                    ReviewImagingOrdersFilteredData);

            // Binds the sorted resultswith the Table
            ReviewImagingOrdersSortedData.comparatorProperty().bind(ReviewImagingOrdersTable.comparatorProperty());

            ReviewImagingOrdersTable.setItems(ReviewImagingOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
e.printStackTrace();        }

    }

}