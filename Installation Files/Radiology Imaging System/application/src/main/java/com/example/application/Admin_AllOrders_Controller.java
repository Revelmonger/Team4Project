package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.example.application.TableConstructors.TABLEPlacedOrdersTableController;
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

public class Admin_AllOrders_Controller implements Initializable {

    /*
     * 
     * Button Functionality
     * 
     */
    @FXML
    private Button logoutButton;

    public void logout(ActionEvent e) throws IOException {

        FXApp.setRoot("LOGIN");
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
    private Button HomeButton;

    public void home(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN");
    }

    @FXML
    public void HomeButtonEntered() {

        HomeButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void HomeButtonExited() {

        HomeButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    private Button UserInfoButton;

    public void userInfo(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_UserInfo");
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
    private Button AdminButton;

    public void admin(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_AdminPanel");
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
    private Button ReferralsButton;

    public void referrals(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_Referrals");
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
    private Button AppointmentsButton;

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_Apppointments");
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
    private Button OrdersButton;

    public void orders(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_AllOrders");
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
    private TableView<TABLEPlacedOrdersTableController> AllAppointmentsTable;

    @FXML
    private TableColumn<TABLEPlacedOrdersTableController, Integer> AllOrdersPatient;

    @FXML
    private TableColumn<TABLEPlacedOrdersTableController, Integer> AllOrdersModality;

    @FXML
    private TableColumn<TABLEPlacedOrdersTableController, String> AllOrdersNotes;

    @FXML
    private TableColumn<TABLEPlacedOrdersTableController, Integer> AllOrdersStatus;

    @FXML
    private TextField searchOrders;

    ObservableList<TABLEPlacedOrdersTableController> PlacedOrdersTableObservableList = FXCollections
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
        String AllOrdersTableQuery = "select patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.status,  order_status.order_name  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(AllOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                String statusquery = queryOutput.getString("order_name");

                PlacedOrdersTableObservableList.add(
                        new TABLEPlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery));
            }

            AllOrdersPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            AllOrdersModality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            AllOrdersNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));

            AllOrdersStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            AllAppointmentsTable.setItems(null);
            AllAppointmentsTable.setItems(PlacedOrdersTableObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLEPlacedOrdersTableController> PlacedOrdersFilteredData = new FilteredList<>(
                    PlacedOrdersTableObservableList);

            searchOrders.textProperty().addListener((observable, oldValue, newValue) -> {
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
            PlacedOrdersSortedData.comparatorProperty().bind(AllAppointmentsTable.comparatorProperty());

            AllAppointmentsTable.setItems(PlacedOrdersSortedData);
            // Search Bar Functionality End
            connectDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}