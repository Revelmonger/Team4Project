package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.example.application.Constructors.Radiologists;
import com.example.application.TableConstructors.TABLECheckedInAppointmentsTableController;
import com.example.application.TableConstructors.TABLETodaysAppointmentsTableController;
import com.example.application.TableConstructors.TABLEUnscheduledOrdersTableController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RECEPTIONIST implements Initializable {

    @FXML
    private ScrollPane BlurBox;

    @FXML
    private TableColumn<TABLECheckedInAppointmentsTableController, Boolean> statusColumn;
    @FXML
    private TableColumn<TABLETodaysAppointmentsTableController, Button> TodaysAppointmentsCheckedIN;
    @FXML
    private TableColumn<TABLEUnscheduledOrdersTableController, Button> UnscheduledOrdersSchedule;

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
        FXApp.setRoot("RECEPTIONIST");
    }

    public void userInfo(ActionEvent e) throws IOException {
        FXApp.setRoot("RECEPTIONIST_UserInfo");
    }

    public void orders(ActionEvent e) throws IOException {
        FXApp.setRoot("RECEPTIONIST_AllOrders");
    }

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("RECEPTIONIST_Apppointments");
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

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        /*
         * 
         * Checked-In Appointments Table
         * 
         */

        String CheckedInAppointmentsTableQuery = "select a.appointment_id, a.checked_in, a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name, a.order_id from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id where checked_in = 1 AND (closed = 0 || closed IS NULL) order by date_time;"; // change

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

                    } else if (TABLECheckedInAppointmentsTableController.getRadiologist().toLowerCase()
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
            e.printStackTrace();
        }

        /*
         * 
         * Today's Appointments Table
         * 
         */

        String TodaysAppointmentsTableQuery = "select a.appointment_id, a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id where date(date_time) = (select date(now())) AND (a.checked_in = false || a.checked_in IS NULL  )order by date_time;";

        try {

            Statement statement3 = connectDB.createStatement();
            ResultSet queryOutput = statement3.executeQuery(TodaysAppointmentsTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                Date date_timequery = queryOutput.getDate("date_time");
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

                            String CheckInAppoint = "UPDATE appointments set checked_in = true where appointment_id = "
                                    + appointmentID + ";";
                            Statement statement4 = connectDB.createStatement();
                            statement4.execute(CheckInAppoint);
                            try {
                                FXApp.setRoot("RECEPTIONIST");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } catch (SQLException e) {

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

                    } else if (TABLETodaysAppointmentsTableController.getRadiologist().toLowerCase()
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
            e.printStackTrace();
        }

        /*
         * 
         * Unscheduled Appointments Table
         * 
         */

        String UnscheduledOrdersTableQuery = "select m.price, p.first_name, p.last_name, md.full_name, m.name, o.notes, o.order_id from orders as o left join patients as p on o.patient = p.patient_id left join order_status as os on o.status = os.order_status_id left join referralmds as md on o.referral_md = md.id left join modalities as m on m.modality_id = o.modality where o.appointment IS NULL;"; // change

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
                Integer price = queryOutput.getInt("price");
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
                        PatientLabel.setLayoutX(22);
                        PatientLabel.setLayoutY(119);

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
                        patientfortheorder.setLayoutX(22);
                        patientfortheorder.setLayoutY(160);
                        patientfortheorder.setEditable(false);
                        patientfortheorder.setText(patientquery);

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
                                Radiologists currentRadiologist = new Radiologists(radiologistsQuery.getInt("id"),
                                        radiologistsQuery.getString("full_name"));
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
                        EstinatedCosts.setText(price.toString());

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
                        SaveUserButton.setPrefWidth(132);
                        SaveUserButton.setLayoutX(472);
                        SaveUserButton.setLayoutY(15);
                        SaveUserButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                        SaveUserButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {

                                if (phoneNumberField.getText().isEmpty() || emailAddressField.getText().isEmpty()
                                        || AppointmentDatePicker.getValue() == null
                                        || SelectedAppointmentTime.getValue().isEmpty()
                                        || RadiologistChoiceBox.getValue().isEmpty()) {
                                }

                                else {

                                    try {
                                        DatabaseConnection connectNow = new DatabaseConnection();
                                        Connection connectDB = connectNow.getConnection();

                                        String GetRadiologistIDQuery = "select * from radiologists where full_name = '"
                                                + RadiologistChoiceBox.getValue() + "';";
                                        String GetPatientQuery = "select order_id, patient, modality from orders where order_id = '"
                                                + OrderID + "';";

                                        Statement RadiologistStatement = connectDB.createStatement();
                                        Statement PatientStatement = connectDB.createStatement();
                                        ResultSet queryOutput = RadiologistStatement
                                                .executeQuery(GetRadiologistIDQuery);
                                        ResultSet queryOutput2 = PatientStatement.executeQuery(GetPatientQuery);

                                        while (queryOutput.next() && queryOutput2.next()) {

                                            Integer radioID = queryOutput.getInt("id");
                                            Integer patientID = queryOutput2.getInt("patient");
                                            Integer modality = queryOutput2.getInt("modality");

                                            String InsertIntoUsersTableQuery = "insert into appointments (patient, order_id, modality, date_time, radiologist, phone_number, email_address) values ('"
                                                    + patientID + "', '" + OrderID + "', '" + modality + "', '"
                                                    + AppointmentDatePicker.getValue() + " "
                                                    + SelectedAppointmentTime.getValue() + "', '" + radioID + "', '"
                                                    + phoneNumberField.getText().trim() + "', '"
                                                    + emailAddressField.getText().trim() + "')";
                                            String GetAppointmentID = "select appointment_id from appointments where order_id = '"
                                                    + OrderID + "';";

                                            Statement NewAppointmentStatemnet = connectDB.createStatement();
                                            NewAppointmentStatemnet.execute(InsertIntoUsersTableQuery);

                                            Statement AppointmentIDStatement = connectDB.createStatement();
                                            ResultSet queryOutput3 = AppointmentIDStatement
                                                    .executeQuery(GetAppointmentID);

                                            while (queryOutput3.next()) {

                                                Integer appointmentID = queryOutput3.getInt("appointment_id");

                                                String InsertAppointmentID = "update orders set appointment = '"
                                                        + appointmentID + "' where order_id = '" + OrderID + "';";

                                                Statement InsertAppointmentIDStatement = connectDB.createStatement();
                                                InsertAppointmentIDStatement.execute(InsertAppointmentID);
                                            }

                                        }

                                        Stage stage = (Stage) SaveUserButton.getScene().getWindow();

                                        stage.close();
                                        BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                        FXApp.setRoot("RECEPTIONIST");

                                    } catch (SQLException e1) {

                                        e1.printStackTrace();
                                    } catch (IOException e1) {

                                        e1.printStackTrace();
                                    }

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

                        Scene scene = new Scene(vbox, 800, 800);

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
                }); // Closes Create Appointment for order

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
            e.printStackTrace();
        }

    }

}