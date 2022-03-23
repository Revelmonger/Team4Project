package com.example.application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
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
    private TableView<TABLEPlacedOrdersTableController> PlacedOrdersTable;

    @FXML
    private TableColumn<TABLEPlacedOrdersTableController, Integer> placed_orders_Patient;

    @FXML
    private TableColumn<TABLEPlacedOrdersTableController, Integer> placed_orders_Modality;

    @FXML
    private TableColumn<TABLEPlacedOrdersTableController, String> placed_orders_Notes;

    @FXML
    private TableColumn<TABLEPlacedOrdersTableController, Integer> placed_orders_Status;

    @FXML
    private TextField searchPlacedOrders;

    ObservableList<TABLEPlacedOrdersTableController> PlacedOrdersTableObservableList = FXCollections
            .observableArrayList();
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
        String PlacedOrdersTableQuery = "select patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.status,  order_status.order_name  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PlacedOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                String statusquery = queryOutput.getString("order_name");

                PlacedOrdersTableObservableList.add(
                        new TABLEPlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery));
            }

            placed_orders_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            placed_orders_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            placed_orders_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));

            placed_orders_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

            PlacedOrdersTable.setItems(null);
            PlacedOrdersTable.setItems(PlacedOrdersTableObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLEPlacedOrdersTableController> PlacedOrdersFilteredData = new FilteredList<>(
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

            SortedList<TABLEPlacedOrdersTableController> PlacedOrdersSortedData = new SortedList<>(
                    PlacedOrdersFilteredData);

            // Binds the sorted resultswith the Table
            PlacedOrdersSortedData.comparatorProperty().bind(PlacedOrdersTable.comparatorProperty());

            PlacedOrdersTable.setItems(PlacedOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            System.out.println("error");
        }

        /*
         * 
         * Checked-In Appointments Table
         * 
         */

        // join price modalities.price
        String CheckedInAppointmentsTableQuery = "select a.checked_in, a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id where checked_in = 1 order by date_time;"; // change
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
                

                CheckedInAppointmentsObservableList.add(new TABLECheckedInAppointmentsTableController(patientquery,
                        modalityquery, date_timequery, radiologistquery, pricequery, checkedinquestion));
            }

            CheckedInAppointments_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            CheckedInAppointments_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            CheckedInAppointments_DateandTime.setCellValueFactory(new PropertyValueFactory<>("date_time")); 

            CheckedInAppointments_Radiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));

            CheckedInAppointments_Price.setCellValueFactory(new PropertyValueFactory<>("price"));

            statusColumn.setCellValueFactory(new PropertyValueFactory<>("checked_in"));

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
            System.out.println("error");
        }

        /*
         * 
         * Today's Appointments Table
         * 
         */

        String TodaysAppointmentsTableQuery = "select a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id where date(date_time) = (select date(now()))  order by date_time;";

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

                TodaysAppointmentsObservableList.add(new TABLETodaysAppointmentsTableController(patientquery,
                        modalityquery, date_timequery, radiologistquery, pricequery));
            }

            TodaysAppointments_Patient1.setCellValueFactory(new PropertyValueFactory<>("patient"));

            TodaysAppointmentsTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            TodaysAppointmentsTable_DateandTime.setCellValueFactory(new PropertyValueFactory<>("date_time")); // price

            TodaysAppointmentsTable_Radiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));

            TodaysAppointmentsTable_Prices.setCellValueFactory(new PropertyValueFactory<>("price"));

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

                    } /*
                       * else if
                       * (TABLETodaysAppointmentsTableController.getDate_time().toLowerCase().indexOf(
                       * searchKeyword) > -1) {
                       * return true;
                       * 
                       * }
                       */ else if (TABLETodaysAppointmentsTableController.getRadiologist().toLowerCase()
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
            System.out.println("error");
        }

        /*
         * 
         * Unscheduled Appointments Table
         * 
         */

        String UnscheduledOrdersTableQuery = "select p.first_name, p.last_name, md.full_name, m.name, o.notes from orders as o left join patients as p on o.patient = p.patient_id left join order_status as os on o.status = os.order_status_id left join referralmds as md on o.referral_md = md.id left join modalities as m on m.modality_id = o.modality where o.status = 4;"; // change
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

                UnscheduledOrdersObservableList.add(new TABLEUnscheduledOrdersTableController(patientquery,
                        referral_mdquery, modalityquery, notesquery));
            }

            UnscheduledOrdersTable_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            UnscheduledOrdersTable_ReferralMD.setCellValueFactory(new PropertyValueFactory<>("referral_md"));

            UnscheduledOrdersTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            UnscheduledOrdersTable_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));

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

                    } /*
                       * else if
                       * (TABLEUnscheduledOrdersTableController.getDate_time().toLowerCase().indexOf(
                       * searchKeyword) > -1) {
                       * return true;
                       * 
                       * }
                       */ else if (TABLEUnscheduledOrdersTableController.getReferral_md().toLowerCase()
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
        String ReviewImagingOrdersTableQuery = "SELECT patient, referral_md, modality, order_id, notes FROM db_ris.orders"; 
        try {

            Statement statement5 = connectDB.createStatement();
            ResultSet queryOutput = statement5.executeQuery(ReviewImagingOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("patient");
                String referral_mdquery = queryOutput.getString("referral_md");
                String modalityquery = queryOutput.getString("modality"); // might need to change types
                String notesquery = queryOutput.getString("notes");
                Button button = new Button("Review Order");
                Integer OrderID = queryOutput.getInt("order_id");
                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

                    queryOutput.close();

                    String ImagePathStatement = "SELECT upload_path FROM db_ris.file_uploads WHERE order_id ='" + OrderID+ "'"; 
                    statement5 = connectDB.createStatement();
                    queryOutput = statement5.executeQuery(ImagePathStatement);

                    while (queryOutput.next()) {
                        String UploadPath = queryOutput.getString("upload_path");
                      BufferedImage  img = ImageIO.read(new File(UploadPath));
                    }
                    queryOutput.close();


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
        ReportLabel.setLayoutX(459);
        ReportLabel.setLayoutY(192);
     

        
        TextArea ReportArea = new TextArea();
        ReportArea.setPrefHeight(100);
        ReportArea.setPrefWidth(260);
        ReportArea.setLayoutX(459);
        ReportArea.setLayoutY(227);


        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

  
       
Button showImage = new Button();


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
    
        
                        String InsertIntoUsersTableQuery = "insert into diagnostic_reports (order_id,  patient,radiologist, diagnostic) values ('"+ OrderID+ "', '" + patientquery + "', '" + user_id1 + "', '"+ ReportArea.getText() + "');";
                        Statement statement = connectDB.createStatement();
                        statement.execute(InsertIntoUsersTableQuery);
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

                    } else if (TABLEReviewImagingOrdersTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } /*
                       * else if
                       * (TABLEReviewImagingOrdersTableController.getDate_time().toLowerCase().indexOf
                       * (searchKeyword) > -1) {
                       * return true;
                       * 
                       * }
                       */ else if (TABLEReviewImagingOrdersTableController.getReferral_md().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (TABLEReviewImagingOrdersTableController.getNotes().toLowerCase()
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
            System.out.println("error");
        }

    }

}