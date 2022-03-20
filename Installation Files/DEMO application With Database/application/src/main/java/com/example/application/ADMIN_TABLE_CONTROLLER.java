package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

public class ADMIN_TABLE_CONTROLLER implements Initializable {

    String user_id1 = LoginController.LoggedInUserID;
   
    
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
        FXApp.setRoot("LOGIN");
    }

    public void admin(ActionEvent e) throws IOException {
        FXApp.setRoot("login");
    }

    public void referrals(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMINREFERRALS");
    }

    public void orders(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_AllOrders");
    }

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMINAPPOINTMENTS");
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
        String CheckedInAppointmentsTableQuery = "select a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id where checked_in = 1 order by date_time;"; // change
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

                CheckedInAppointmentsObservableList.add(new TABLECheckedInAppointmentsTableController(patientquery,
                        modalityquery, date_timequery, radiologistquery, pricequery));
            }

            CheckedInAppointments_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            CheckedInAppointments_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            CheckedInAppointments_DateandTime.setCellValueFactory(new PropertyValueFactory<>("date_time")); // price

            CheckedInAppointments_Radiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));

            CheckedInAppointments_Price.setCellValueFactory(new PropertyValueFactory<>("price"));

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

                    if (TABLECheckedInAppointmentsTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLECheckedInAppointmentsTableController.getModality().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } /*else if (TABLECheckedInAppointmentsTableController.getDate_time().indexOf(searchKeyword) > -1) {
                        return true;

                    }*/ else if (TABLECheckedInAppointmentsTableController.getRadiologist().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    }
                      else if (TABLECheckedInAppointmentsTableController.getPrice().toLowerCase().indexOf(searchKeyword) > -1) {
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

                    } /*else if (TABLETodaysAppointmentsTableController.getDate_time().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    }*/ else if (TABLETodaysAppointmentsTableController.getRadiologist().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    }
                        else if (TABLETodaysAppointmentsTableController.getPrice().toLowerCase().indexOf(searchKeyword) > -1) {
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

                    } /*else if (TABLEUnscheduledOrdersTableController.getDate_time().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    }*/ else if (TABLEUnscheduledOrdersTableController.getReferral_md().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    }
                        else if (TABLEUnscheduledOrdersTableController.getNotes().toLowerCase().indexOf(searchKeyword) > -1) {
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
        String ReviewImagingOrdersTableQuery = "SELECT patient, referral_md, modality, notes FROM db_ris.orders"; // change
                                                                                                                  // to
                                                                                                                  // just
                                                                                                                  // like
                                                                                                                  // orders
                                                                                                                  // select
                                                                                                                  // statement

        try {

            Statement statement5 = connectDB.createStatement();
            ResultSet queryOutput = statement5.executeQuery(ReviewImagingOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("patient");
                String referral_mdquery = queryOutput.getString("referral_md");
                String modalityquery = queryOutput.getString("modality"); // might need to change types
                String notesquery = queryOutput.getString("notes");

                ReviewImagingOrdersObservableList.add(new TABLEReviewImagingOrdersTableController(patientquery,
                        referral_mdquery, modalityquery, notesquery));
            }

            ReviewImagingOrdersTable_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            ReviewImagingOrdersTable_RefferalMD.setCellValueFactory(new PropertyValueFactory<>("referral_md"));

            ReviewImagingOrdersTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            ReviewImagingOrdersTable_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));

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

                    if (TABLEReviewImagingOrdersTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEReviewImagingOrdersTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } /*else if (TABLEReviewImagingOrdersTableController.getDate_time().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    }*/ else if (TABLEReviewImagingOrdersTableController.getReferral_md().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    }
                        else if (TABLEReviewImagingOrdersTableController.getNotes().toLowerCase().indexOf(searchKeyword) > -1) {
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