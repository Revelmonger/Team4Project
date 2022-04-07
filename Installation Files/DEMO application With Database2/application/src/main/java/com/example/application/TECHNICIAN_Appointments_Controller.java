package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.application.TableConstructors.TABLEAllAppointmentsTableController;

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

public class TECHNICIAN_Appointments_Controller implements Initializable {

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

    @FXML
    private TableView<TABLEAllAppointmentsTableController> AllAppointmentsTable;

    @FXML
    private TableColumn<TABLEAllAppointmentsTableController, Integer> all_appointments_patient;

    @FXML
    private TableColumn<TABLEAllAppointmentsTableController, Integer> all_appointments_Modality;

    @FXML
    private TableColumn<TABLEAllAppointmentsTableController, Date> all_appointments_dateandtime;

    @FXML
    private TableColumn<TABLEAllAppointmentsTableController, Integer> all_appointments_radiologist;

    @FXML
    private TextField searchAllAppointments;

    ObservableList<TABLEAllAppointmentsTableController> PlacedOrdersTableObservableList = FXCollections
            .observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PlacedOrdersTableQuery = "select p.first_name, p.last_name, m.name, a.date_time, r.full_name from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PlacedOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                Date datequery = queryOutput.getDate("date_time");
                String radiologistquery = queryOutput.getString("full_name");

                PlacedOrdersTableObservableList.add(
                        new TABLEAllAppointmentsTableController(patientquery, modalityquery, datequery,
                                radiologistquery));
            }

            all_appointments_patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            all_appointments_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            all_appointments_dateandtime.setCellValueFactory(new PropertyValueFactory<>("date_time"));

            all_appointments_radiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));

            AllAppointmentsTable.setItems(null);
            AllAppointmentsTable.setItems(PlacedOrdersTableObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLEAllAppointmentsTableController> AllAppointmentsFilteredList = new FilteredList<>(
                    PlacedOrdersTableObservableList);

            searchAllAppointments.textProperty().addListener((observable, oldValue, newValue) -> {
                AllAppointmentsFilteredList.setPredicate(TABLEAllAppointmentsTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String searchKeyword = newValue.toLowerCase();

                    if (TABLEAllAppointmentsTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEAllAppointmentsTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEAllAppointmentsTableController.getDate_time().toString()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEAllAppointmentsTableController.getRadiologist().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TABLEAllAppointmentsTableController> AllPatientsSortedData = new SortedList<>(
                    AllAppointmentsFilteredList);

            // Binds the sorted resultswith the Table
            AllPatientsSortedData.comparatorProperty().bind(AllAppointmentsTable.comparatorProperty());

            AllAppointmentsTable.setItems(AllPatientsSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            System.out.println("error");
        }

    }

    /*
     * 
     * Button Logic
     * 
     */

    public void logout(ActionEvent e) throws IOException {

        FXApp.setRoot("LOGIN");
    }

    public void home(ActionEvent e) throws IOException {
        FXApp.setRoot("TECHNICIAN");
    }

    public void userInfo(ActionEvent e) throws IOException {
        FXApp.setRoot("TECHNICIAN_UserInfo");
    }

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("TECHNICIAN_Apppointments");
    }
}