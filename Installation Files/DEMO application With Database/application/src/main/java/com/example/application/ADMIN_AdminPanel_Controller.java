package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.application.Constructors.Modalities;
import com.example.application.Constructors.OrderStatuses;
import com.example.application.Constructors.Patient;
import com.example.application.Constructors.ReferralDoctor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;
import org.yaml.snakeyaml.emitter.Emitable;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Modality;

import javafx.stage.StageStyle;

import javafx.event.EventHandler;
import javafx.application.*;

public class ADMIN_AdminPanel_Controller implements Initializable {

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

    @FXML
    private Button NewPatient;

    @FXML
    private TableView<TABLESystemUsersTableController> SystemUsersTable;

    @FXML
    private TableColumn<TABLESystemUsersTableController, Integer> Users_UserId;

    @FXML
    private TableColumn<TABLESystemUsersTableController, String> UsersUsername;

    @FXML
    private TableColumn<TABLESystemUsersTableController, String> UsersDisplayName;

    @FXML
    private TableColumn<TABLESystemUsersTableController, String> UsersEmail;

    @FXML
    private TableColumn<TABLESystemUsersTableController, Integer> UsersRole;

    @FXML
    private TableColumn<TABLESystemUsersTableController, Button> UsersModifyButton;

    @FXML
    private TextField searchUsers;

    @FXML
    private Button NewUserButton;

    ObservableList<TABLESystemUsersTableController> UsersTableObservableList = FXCollections
            .observableArrayList();

    // Modalities imports
    @FXML
    private TableView<TABLEModalitiesTableController> ModalitiesTable;

    @FXML
    private TableColumn<TABLEModalitiesTableController, String> ModalitiesIDColumn;

    @FXML
    private TableColumn<TABLEModalitiesTableController, String> ModalitiesNameColumn;

    @FXML
    private TableColumn<TABLEModalitiesTableController, Integer> ModalityPriceColumn;

    @FXML
    private TableColumn<TABLEModalitiesTableController, Button> ModalitiesModify;

    @FXML
    private TextField searchModalities;

    ObservableList<TABLEModalitiesTableController> ModalitiesTableObservableList = FXCollections
            .observableArrayList();

    // Patient alerts imports
    @FXML
    private TableView<TABLEPatientAlertsTableController> PatientAlertsTable;

    @FXML
    private TableColumn<TABLEPatientAlertsTableController, Integer> PatientAlertsIDColulm;

    @FXML
    private TableColumn<TABLEModalitiesTableController, Integer> PatientsAlertsColumn;

    @FXML
    private TableColumn<TABLEPatientAlertsTableController, Button> PatientAlertsModifyColumn;

    @FXML
    private TextField searchAlerts;

    ObservableList<TABLEPatientAlertsTableController> AlertsTableObservableList = FXCollections
            .observableArrayList();

    // Patient table imports
    @FXML
    private TableView<TABLEPatientsTableController> PatientsTable;

    @FXML
    private TableColumn<TABLEPatientsTableController, Integer> PatientIDColumn;

    @FXML
    private TableColumn<TABLEPatientsTableController, Date> PatientdobColumn;

    @FXML
    private TableColumn<TABLEPatientsTableController, String> PatientFirstNameColumn;

    @FXML
    private TableColumn<TABLEPatientsTableController, String> PatientLastNameColumn;

    @FXML
    private TableColumn<TABLEPatientsTableController, Button> PatientModifyColumn;

    @FXML
    private TextField searchPatients;

    ObservableList<TABLEPatientsTableController> PatientsTableObservableList = FXCollections
            .observableArrayList();

    // Orders table imports
    @FXML
    private Button NewOrder;
     @FXML
     private Button NewAppointment;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


 // CREATES NEW Appointment
 NewAppointment.setOnAction(new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {

       

        VBox vbox = new VBox();

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(800, 800);
        scroll.setContent(vbox);
        scroll.setFitToWidth(true);

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

      ////  contactInfoPane.getChildren().add(EmailAddressField);

      Pane OfficeInfoPane = new Pane();
      OfficeInfoPane.setPrefHeight(198);
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

      Label OrderLabel = new Label("Order:");
      OrderLabel.setStyle("-fx-font: normal bold 16px 'arial';");
      OrderLabel.setMinHeight(27);
      OrderLabel.setMinWidth(128);
      OrderLabel.setLayoutX(22);
      OrderLabel.setLayoutY(119);

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

      OfficeInfoPane.getChildren().add(OrderLabel);
      OfficeInfoPane.getChildren().add(OfficeInfoLabel);
      OfficeInfoPane.getChildren().add(HorizontalLineOfficeIn);
      OfficeInfoPane.getChildren().add(ModalityLabel);
      OfficeInfoPane.getChildren().add(RadiologistLabel);
      OfficeInfoPane.getChildren().add(EstimatedCostsLabel);

     
        Pane BottomPane = new Pane();
        BottomPane.setPrefHeight(223);
        BottomPane.setPrefWidth(800);

        Button SaveUserButton = new Button("Save Changes");
        SaveUserButton.setPrefHeight(42);
        SaveUserButton.setPrefWidth(102);
        SaveUserButton.setLayoutX(509);
        SaveUserButton.setLayoutY(147);
        SaveUserButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        SaveUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            
            }
        });
        

        Button CancelButton = new Button("Cancel");
        CancelButton.setPrefHeight(42);
        CancelButton.setPrefWidth(102);
        CancelButton.setLayoutX(654);
        CancelButton.setLayoutY(147);
        CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = (Stage) CancelButton.getScene().getWindow();
                stage.close();
            }
        });

        BottomPane.getChildren().add(SaveUserButton);
        BottomPane.getChildren().add(CancelButton);

        vbox.getChildren().add(newPane);

        vbox.getChildren().add(contactInfoPane);
        vbox.getChildren().add(OfficeInfoPane);
        vbox.getChildren().add(BottomPane);

        Scene scene = new Scene(scroll , 800, 800);

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
                }
            }
        });
        newWindow.show();
    }
});// CLOSES NEW User




























































        // CREATES NEW USER
        NewUserButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                VBox vbox = new VBox();

                Pane newPane = new Pane();
                newPane.setLayoutX(0);
                newPane.setLayoutY(0);
                newPane.setPrefHeight(109);
                newPane.setPrefWidth(800);

                Label PatientOverviewLabe = new Label("Create New User");
                PatientOverviewLabe.setStyle("-fx-font: normal bold 32px 'arial';");
                PatientOverviewLabe.setLayoutX(25);
                PatientOverviewLabe.setLayoutY(27);
                PatientOverviewLabe.setMinHeight(55);
                PatientOverviewLabe.setMinWidth(281);

                Line horizontalline = new Line(-100.0f, 0.0f, 700.0f, 0.0f);
                horizontalline.setTranslateX(100);
                horizontalline.setTranslateY(110);

                newPane.getChildren().add(PatientOverviewLabe);
                newPane.getChildren().add(horizontalline);

                Pane Filler = new Pane();
                Filler.setLayoutX(0);
                Filler.setLayoutY(0);
                Filler.setPrefHeight(41);

                Pane NamesPane = new Pane();
                NamesPane.setPrefHeight(114);
                NamesPane.setPrefWidth(800);

                Label Username = new Label("Username:");
                Username.setStyle("-fx-font: normal bold 16px 'arial';");
                Username.setMinHeight(55);
                Username.setMinWidth(128);
                Username.setLayoutX(35);

                Label Displayname = new Label("Display Name:");
                Displayname.setStyle("-fx-font: normal bold 16px 'arial';");
                Displayname.setMinHeight(55);
                Displayname.setMinWidth(128);
                Displayname.setLayoutX(287);

                Label EmailAddress = new Label("Email Address:");
                EmailAddress.setStyle("-fx-font: normal bold 16px 'arial';");
                EmailAddress.setMinHeight(55);
                EmailAddress.setMinWidth(128);
                EmailAddress.setLayoutX(543);

                TextField UsernameField = new TextField();
                UsernameField.setMinHeight(35);
                UsernameField.setMinWidth(210);
                UsernameField.setLayoutX(35);
                UsernameField.setLayoutY(43);

                TextField displayNameField = new TextField();
                displayNameField.setMinHeight(35);
                displayNameField.setMinWidth(210);
                displayNameField.setLayoutX(287);
                displayNameField.setLayoutY(43);

                TextField EmailAddressField = new TextField();
                EmailAddressField.setMinHeight(35);
                EmailAddressField.setMinWidth(210);
                EmailAddressField.setLayoutX(543);
                EmailAddressField.setLayoutY(43);

                NamesPane.getChildren().add(Username);
                NamesPane.getChildren().add(Displayname);
                NamesPane.getChildren().add(EmailAddress);
                NamesPane.getChildren().add(UsernameField);
                NamesPane.getChildren().add(displayNameField);
                NamesPane.getChildren().add(EmailAddressField);

                Pane RolePane = new Pane();
                RolePane.setPrefHeight(114);
                RolePane.setPrefWidth(800);

                Label UserRoleLabel = new Label("User Role:");
                UserRoleLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                UserRoleLabel.setMinHeight(55);
                UserRoleLabel.setMinWidth(100);
                UserRoleLabel.setLayoutX(35);


                ChoiceBox<String> UserRole = new ChoiceBox<String>();
                UserRole.setStyle("-fx-font: normal bold 16px 'arial'; -fx-wrap-text: true;");
                UserRole.setMaxHeight(35);
                UserRole.setPrefHeight(35);   
                UserRole.setMinHeight(35);   
                            
                UserRole.setMinWidth(100);
                UserRole.setMaxWidth(100);
                UserRole.setPrefWidth(100);
                UserRole.setLayoutX(35);
                UserRole.setLayoutY(45);

                UserRole.getItems().add("ADMIN");
                UserRole.getItems().add("USER");
                UserRole.getItems().add("REFERRAL_DOCTOR");
                UserRole.getItems().add("RECEPTIONIST");
                UserRole.getItems().add("TECHNICIAN");
                UserRole.getItems().add("RADIOLOGIST");

                Label UserPassword = new Label("Change Password:");
                UserPassword.setStyle("-fx-font: normal bold 16px 'arial';");
                UserPassword.setMinHeight(55);
                UserPassword.setMinWidth(128);
                UserPassword.setLayoutX(196);

                TextField PasswordField = new TextField();
                PasswordField.setPrefHeight(35);
                PasswordField.setPrefWidth(259);
                PasswordField.setLayoutX(196);
                PasswordField.setLayoutY(43);

                RolePane.getChildren().add(UserPassword);
                RolePane.getChildren().add(UserRole);
                RolePane.getChildren().add(PasswordField);
                RolePane.getChildren().add(UserRoleLabel);

                Pane BottomPane = new Pane();
                BottomPane.setPrefHeight(223);
                NamesPane.setPrefWidth(800);

                Button SaveUserButton = new Button("Save Changes");
                SaveUserButton.setPrefHeight(42);
                SaveUserButton.setPrefWidth(102);
                SaveUserButton.setLayoutX(509);
                SaveUserButton.setLayoutY(147);
                SaveUserButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                SaveUserButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        try {
                            DatabaseConnection connectNow = new DatabaseConnection();
                            Connection connectDB = connectNow.getConnection();

                            String InsertIntoUsersTableQuery = "insert into users (username, full_name, email, password) values ('"
                                    + UsernameField.getText() + "', '" + displayNameField.getText() + "', '"
                                    + EmailAddressField.getText() + "', '" + PasswordField.getText() + "');";
                            Statement statement = connectDB.createStatement();
                            statement.execute(InsertIntoUsersTableQuery);

                            String GetUserID = "Select user_id, full_name from users where username = '"
                                    + UsernameField.getText() + "' AND password = '" + PasswordField.getText() + "';";
                            try {

                                statement = connectDB.createStatement();
                                ResultSet queryOutput = statement.executeQuery(GetUserID);

                                while (queryOutput.next()) {

                                    Integer userIDquery = queryOutput.getInt("user_id");
                                    String namequery = queryOutput.getString("full_name");

                                    System.out.println(UserRole.getValue());
                                    if (UserRole.getValue().equals("ADMIN")) {
                                        String UpdateUsersRole = "insert into users_roles (user_id, role_id)values ('"
                                                + userIDquery + "', '1');";
                                        statement = connectDB.createStatement();
                                        statement.execute(UpdateUsersRole);
                                    } else if (UserRole.getValue().equals("USER")) {
                                        String UpdateUsersRole = "insert into users_roles (user_id, role_id)values ('"
                                                + userIDquery + "', '2');";
                                        statement = connectDB.createStatement();
                                        statement.execute(UpdateUsersRole);

                                    } else if (UserRole.getValue().equals("REFERRAL_DOCTOR")) {
                                        String UpdateUsersRole = "insert into users_roles (user_id, role_id)values ('"
                                                + userIDquery + "', '3');";
                                        String UpdateReferralMDTable = "insert into referralmds (full_name, user_id) values ('"
                                                + namequery + "', '" + userIDquery + "');";
                                        statement = connectDB.createStatement();
                                        statement.execute(UpdateUsersRole);
                                        statement.execute(UpdateReferralMDTable);
                                    } else if (UserRole.getValue().equals("RECEPTIONIST")) {
                                        String UpdateUsersRole = "insert into users_roles (user_id, role_id)values ('"
                                                + userIDquery + "', '4');";
                                        statement = connectDB.createStatement();
                                        statement.execute(UpdateUsersRole);
                                    } else if (UserRole.getValue().equals("TECHNICAN")) {
                                        String UpdateUsersRole = "insert into users_roles (user_id, role_id)values ('"
                                                + userIDquery + "', '5');";
                                        statement = connectDB.createStatement();
                                        statement.execute(UpdateUsersRole);
                                    } else if (UserRole.getValue().equals("RADIOLOGIST")) {
                                        String UpdateUsersRole = "insert into users_roles (user_id, role_id)values ('"
                                                + userIDquery + "', '6');";
                                        String UpdateRadiologistTable = "insert into radiologists (full_name, user_id) values ('"
                                                + namequery + "', '" + userIDquery + "');";
                                        statement = connectDB.createStatement();
                                        statement.execute(UpdateUsersRole);
                                        statement.execute(UpdateRadiologistTable);
                                    } else {

                                        System.out.println("Error in if statement");
                                    }

                                }

                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }

                            Stage stage = (Stage) SaveUserButton.getScene().getWindow();

                            stage.close();
                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }

                    }
                });
                

                Button CancelButton = new Button("Cancel");
                CancelButton.setPrefHeight(42);
                CancelButton.setPrefWidth(102);
                CancelButton.setLayoutX(654);
                CancelButton.setLayoutY(147);
                CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

                CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Stage stage = (Stage) CancelButton.getScene().getWindow();
                        stage.close();
                    }
                });

                BottomPane.getChildren().add(SaveUserButton);
                BottomPane.getChildren().add(CancelButton);

                vbox.getChildren().add(newPane);
                vbox.getChildren().add(Filler);
                vbox.getChildren().add(NamesPane);
                vbox.getChildren().add(RolePane);
                vbox.getChildren().add(BottomPane);

                Scene scene = new Scene(vbox, 800, 600);

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
                        }
                    }
                });
                newWindow.show();
            }
        });// CLOSES NEW User

        // CREATES NEW ORDER
        NewOrder.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                VBox vbox = new VBox();

                Pane newPane = new Pane();
                newPane.setLayoutX(0);
                newPane.setLayoutY(0);
                newPane.setPrefHeight(109);
                newPane.setPrefWidth(800);

                Label PatientOverviewLabe = new Label("Create New ORDER");
                PatientOverviewLabe.setStyle("-fx-font: normal bold 32px 'arial';");
                PatientOverviewLabe.setLayoutX(25);
                PatientOverviewLabe.setLayoutY(27);
                PatientOverviewLabe.setMinHeight(55);
                PatientOverviewLabe.setMinWidth(281);

                Line horizontalline = new Line(-100.0f, 0.0f, 700.0f, 0.0f);
                horizontalline.setTranslateX(100);
                horizontalline.setTranslateY(110);

                newPane.getChildren().add(PatientOverviewLabe);
                newPane.getChildren().add(horizontalline);

                Pane Filler = new Pane();
                Filler.setLayoutX(0);
                Filler.setLayoutY(0);
                Filler.setPrefHeight(41);

                Pane NamesPane = new Pane();
                NamesPane.setPrefHeight(114);
                NamesPane.setPrefWidth(800);

                Label Username = new Label("Patient:");
                Username.setStyle("-fx-font: normal bold 16px 'arial';");
                Username.setMinHeight(55);
                Username.setMinWidth(128);
                Username.setLayoutX(35);

                Label Displayname = new Label("Referral Doctor:");
                Displayname.setStyle("-fx-font: normal bold 16px 'arial';");
                Displayname.setMinHeight(55);
                Displayname.setMinWidth(128);
                Displayname.setLayoutX(287);

                Label EmailAddress = new Label("Status:");
                EmailAddress.setStyle("-fx-font: normal bold 16px 'arial';");
                EmailAddress.setMinHeight(55);
                EmailAddress.setMinWidth(128);
                EmailAddress.setLayoutX(543);

                ChoiceBox<String> SelectedPatientField = new ChoiceBox<String>();
                SelectedPatientField.setStyle("-fx-font: normal bold 16px 'arial';");
                SelectedPatientField.setMinHeight(35);
                SelectedPatientField.setMaxWidth(210);
                SelectedPatientField.setLayoutX(35);
                SelectedPatientField.setLayoutY(43);
                SelectedPatientField.setPrefWidth(210);

                ChoiceBox<String> SelectedDoctorField = new ChoiceBox<String>();
                SelectedDoctorField.setStyle("-fx-font: normal bold 16px 'arial';");
                SelectedDoctorField.setMinHeight(35);
                SelectedDoctorField.setMaxWidth(210);
                SelectedDoctorField.setLayoutX(287);
                SelectedDoctorField.setLayoutY(43);
                SelectedDoctorField.setPrefWidth(210);

                ChoiceBox<String> SelectedStatusField = new ChoiceBox<String>();
                SelectedStatusField.setStyle("-fx-font: normal bold 16px 'arial';");
                SelectedStatusField.setMinHeight(35);
                SelectedStatusField.setMaxWidth(210);
                SelectedStatusField.setLayoutX(543);
                SelectedStatusField.setLayoutY(43);
                SelectedStatusField.setPrefHeight(210);
                SelectedStatusField.setMaxHeight(35);
                SelectedStatusField.setPrefWidth(210);

                NamesPane.getChildren().add(Username);
                NamesPane.getChildren().add(Displayname);
                NamesPane.getChildren().add(EmailAddress);
                NamesPane.getChildren().add(SelectedDoctorField);
                NamesPane.getChildren().add(SelectedPatientField);
                NamesPane.getChildren().add(SelectedStatusField);

                Pane RolePane = new Pane();
                RolePane.setPrefHeight(114);
                RolePane.setPrefWidth(800);

                Label ModalityLabel = new Label("Modality:");
                ModalityLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                ModalityLabel.setMinHeight(55);
                ModalityLabel.setMinWidth(128);
                ModalityLabel.setLayoutX(35);

                ChoiceBox<String> ModalityChoiceBox = new ChoiceBox<String>();
                ModalityChoiceBox.setStyle("-fx-font: normal bold 16px 'arial';");
                ModalityChoiceBox.setMaxHeight(35);
                ModalityChoiceBox.setMinHeight(35);
                ModalityChoiceBox.setMaxWidth(160);
                ModalityChoiceBox.setLayoutX(35);
                ModalityChoiceBox.setLayoutY(50);
                ModalityChoiceBox.setPrefWidth(160);
                ;

                // Adds Patients to the Box
                try {
                    DatabaseConnection connectNow = new DatabaseConnection();
                    Connection connectDB = connectNow.getConnection();

                    String GetChoiceBoxQuery = "Select * from patients";
                    Statement statement = connectDB.createStatement();
                    ResultSet PatientsOutput = statement.executeQuery(GetChoiceBoxQuery);

                    while (PatientsOutput.next()) {
                        Patient currentitterationpatient = new Patient(PatientsOutput.getInt("patient_id"),
                                PatientsOutput.getString("first_name"), PatientsOutput.getString("last_name"));
                        SelectedPatientField.getItems().add(
                                currentitterationpatient.getFirstname() + " " + currentitterationpatient.getLastname());
                    }

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
                // Adds Modalities to Modalities Box
                try {
                    DatabaseConnection connectNow = new DatabaseConnection();
                    Connection connectDB = connectNow.getConnection();

                    String GetChoiceBoxQuery = "Select * from modalities";
                    Statement statement = connectDB.createStatement();
                    ResultSet ModalitiesOutput = statement.executeQuery(GetChoiceBoxQuery);

                    while (ModalitiesOutput.next()) {
                        Modalities currentitterationpatient = new Modalities(ModalitiesOutput.getInt("modality_id"),
                                ModalitiesOutput.getString("name"));
                        ModalityChoiceBox.getItems().add(currentitterationpatient.getModalityname());
                    }

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
                // Adds Status
                try {
                    DatabaseConnection connectNow = new DatabaseConnection();
                    Connection connectDB = connectNow.getConnection();

                    String GetChoiceBoxQuery = "Select * from order_status";
                    Statement statement = connectDB.createStatement();
                    ResultSet OrderStatusOutput = statement.executeQuery(GetChoiceBoxQuery);

                    while (OrderStatusOutput.next()) {
                        OrderStatuses currentOrderStatusOutput = new OrderStatuses(
                                OrderStatusOutput.getString("order_name"));
                        SelectedStatusField.getItems().add(currentOrderStatusOutput.getOrderstatus());
                    }

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
                // Adds Doctors
                try {
                    DatabaseConnection connectNow = new DatabaseConnection();
                    Connection connectDB = connectNow.getConnection();

                    String GetChoiceBoxQuery = "select * from users as u join users_roles as ur on ur.user_id = u.user_id where role_id = 3;";
                    Statement statement = connectDB.createStatement();
                    ResultSet DoctorQueryOutput = statement.executeQuery(GetChoiceBoxQuery);

                    while (DoctorQueryOutput.next()) {
                        ReferralDoctor currentReferralDoctor = new ReferralDoctor(
                                DoctorQueryOutput.getString("full_name"), DoctorQueryOutput.getInt("user_id"));

                        SelectedDoctorField.getItems().add(currentReferralDoctor.getReferraldoctor());
                    }

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

                Label RefNotes = new Label("Refferral Notes:");
                RefNotes.setStyle("-fx-font: normal bold 16px 'arial';");
                RefNotes.setMinHeight(55);
                RefNotes.setMinWidth(128);
                RefNotes.setLayoutX(226);

                TextArea ReferralTextField = new TextArea();
                ReferralTextField.setPrefHeight(150);
                ReferralTextField.setPrefWidth(520);
                ReferralTextField.setLayoutX(226);
                ReferralTextField.setLayoutY(43);

                RolePane.getChildren().add(ModalityLabel);
                RolePane.getChildren().add(ModalityChoiceBox);
                RolePane.getChildren().add(ReferralTextField);
                RolePane.getChildren().add(RefNotes);

                Pane BottomPane = new Pane();
                BottomPane.setPrefHeight(223);
                NamesPane.setPrefWidth(800);

                Button CreateOrderButton = new Button("Create Order");
                CreateOrderButton.setPrefHeight(42);
                CreateOrderButton.setPrefWidth(102);
                CreateOrderButton.setLayoutX(509);
                CreateOrderButton.setLayoutY(147);
                CreateOrderButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                CreateOrderButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        // Find OrderStatusID
                        Integer Status_id = null;
                        try {
                            DatabaseConnection connectNow = new DatabaseConnection();
                            Connection connectDB = connectNow.getConnection();

                            String InsertQueries = "Select order_status_id from order_status where order_name = '"
                                    + SelectedStatusField.getValue() + "'";
                            Statement statement = connectDB.createStatement();
                            ResultSet StatusIDOutput = statement.executeQuery(InsertQueries);

                            while (StatusIDOutput.next()) {
                                Status_id = StatusIDOutput.getInt("order_status_id");
                            }

                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }
                        // Gets Modality ID
                        Integer modality_id = null;
                        try {
                            DatabaseConnection connectNow = new DatabaseConnection();
                            Connection connectDB = connectNow.getConnection();

                            String InsertQueries = "Select modality_id from modalities where name = '"
                                    + ModalityChoiceBox.getValue() + "'";
                            Statement statement = connectDB.createStatement();
                            ResultSet modalityIDOutput = statement.executeQuery(InsertQueries);

                            while (modalityIDOutput.next()) {
                                modality_id = modalityIDOutput.getInt("modality_id");

                            }

                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }
                        // Finds Doctor ID
                        Integer user_id = null;
                        try {
                            DatabaseConnection connectNow = new DatabaseConnection();
                            Connection connectDB = connectNow.getConnection();

                            String InsertQueries = "Select id from referralmds where full_name = '"
                                    + SelectedDoctorField.getValue() + "'";
                            Statement statement = connectDB.createStatement();
                            ResultSet DoctorIDOutput = statement.executeQuery(InsertQueries);

                            while (DoctorIDOutput.next()) {
                                user_id = DoctorIDOutput.getInt("id");

                            }

                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }

                        Integer patient_id = 1;
                        try {
                            DatabaseConnection connectNow = new DatabaseConnection();
                            Connection connectDB = connectNow.getConnection();

                            String[] firstandlastnames = SelectedPatientField.getValue().toString().split(" ", 2);

                            String InsertQueries = "Select patient_id from patients where first_name = '"
                                    + firstandlastnames[0] + "' and last_name = '" + firstandlastnames[1] + "'";
                            Statement statement = connectDB.createStatement();
                            ResultSet PatientIDOutput = statement.executeQuery(InsertQueries);

                            while (PatientIDOutput.next()) {
                                patient_id = PatientIDOutput.getInt("patient_id");

                            }

                        } catch (SQLException e1) {

                            e1.printStackTrace();

                        }

                        // ADDING THE ORDDER TO THE database
                        try {
                            DatabaseConnection connectNow = new DatabaseConnection();
                            Connection connectDB = connectNow.getConnection();

                            String insertheorder = "insert into orders (patient, referral_md, modality, notes, status)values ('"
                                    + patient_id + "', '" + user_id + "', '" + modality_id + "', '"
                                    + ReferralTextField.getText() + "', '" + Status_id + "');";
                            Statement statement = connectDB.createStatement();

                            statement.execute(insertheorder);

                            Stage stage = (Stage) CreateOrderButton.getScene().getWindow();
                            stage.close();

                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }

                    }

                });

                Button CancelButton = new Button("Cancel");
                CancelButton.setPrefHeight(42);
                CancelButton.setPrefWidth(102);
                CancelButton.setLayoutX(654);
                CancelButton.setLayoutY(147);
                CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

                CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Stage stage = (Stage) CancelButton.getScene().getWindow();
                        stage.close();
                    }
                });

                BottomPane.getChildren().add(CreateOrderButton);
                BottomPane.getChildren().add(CancelButton);

                vbox.getChildren().add(newPane);
                vbox.getChildren().add(Filler);
                vbox.getChildren().add(NamesPane);
                vbox.getChildren().add(RolePane);
                vbox.getChildren().add(BottomPane);

                Scene scene = new Scene(vbox, 800, 600);

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
                        }
                    }
                });
                newWindow.show();
            }
        });// CLOSES NEW ORDER

        // ALL USERES TABLE POPULATION
        String UsersTableQuery = "select u.user_id, u.full_name, u.username, u.email, ur.role_id, r.name from users as u left join users_roles as ur on ur.user_id = u.user_id left join roles as r on r.role_id = ur.role_id;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(UsersTableQuery);

            while (queryOutput.next()) {

                Integer userIDquery = queryOutput.getInt("user_id");

                String usernamequery = queryOutput.getString("username");
                String displaynamequery = queryOutput.getString("full_name");
                String emailquery = queryOutput.getString("email");
                String rolequery = queryOutput.getString("name");
                Button button = new Button("Modify");

                UsersTableObservableList.add(

                        new TABLESystemUsersTableController(userIDquery, usernamequery, displaynamequery, emailquery,
                                rolequery, button));
            }

            Users_UserId.setCellValueFactory(new PropertyValueFactory<>("Userid"));
            UsersUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
            UsersDisplayName.setCellValueFactory(new PropertyValueFactory<>("displayname"));
            UsersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            UsersRole.setCellValueFactory(new PropertyValueFactory<>("role"));
            UsersModifyButton.setCellValueFactory(new PropertyValueFactory<>("button"));

            SystemUsersTable.setItems(null);
            SystemUsersTable.setItems(UsersTableObservableList);

        } catch (Exception e) {
            System.out.println("error");
        }

        // CREATES NEW PATIENT AND WINDOW
        NewPatient.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                VBox vbox = new VBox();

                Pane newPane = new Pane();
                newPane.setLayoutX(0);
                newPane.setLayoutY(0);
                newPane.setPrefHeight(109);
                newPane.setPrefWidth(800);

                Label PatientOverviewLabe = new Label("Start Order");
                PatientOverviewLabe.setStyle("-fx-font: normal bold 32px 'arial';");
                PatientOverviewLabe.setLayoutX(25);
                PatientOverviewLabe.setLayoutY(27);
                PatientOverviewLabe.setMinHeight(55);
                PatientOverviewLabe.setMinWidth(281);

                Line horizontalline = new Line(-100.0f, 0.0f, 700.0f, 0.0f);
                horizontalline.setTranslateX(100);
                horizontalline.setTranslateY(110);

                newPane.getChildren().add(PatientOverviewLabe);
                newPane.getChildren().add(horizontalline);

                Pane Filler = new Pane();
                Filler.setLayoutX(0);
                Filler.setLayoutY(0);
                Filler.setPrefHeight(41);

                Pane NamesPane = new Pane();
                NamesPane.setPrefHeight(114);
                NamesPane.setPrefWidth(800);

                Label FirstName = new Label("First Name:");
                FirstName.setStyle("-fx-font: normal bold 16px 'arial';");
                FirstName.setMinHeight(55);
                FirstName.setMinWidth(128);
                FirstName.setLayoutX(35);

                Label LastName = new Label("Last Name:");
                LastName.setStyle("-fx-font: normal bold 16px 'arial';");
                LastName.setMinHeight(55);
                LastName.setMinWidth(128);
                LastName.setLayoutX(287);

                Label Date_of_Birth = new Label("Date of Birth:");
                Date_of_Birth.setStyle("-fx-font: normal bold 16px 'arial';");
                Date_of_Birth.setMinHeight(55);
                Date_of_Birth.setMinWidth(128);
                Date_of_Birth.setLayoutX(543);

                TextField firstNameField = new TextField();
                firstNameField.setMinHeight(35);
                firstNameField.setMinWidth(210);
                firstNameField.setLayoutX(35);
                firstNameField.setLayoutY(43);

                TextField lastNamefield = new TextField();
                lastNamefield.setMinHeight(35);
                lastNamefield.setMinWidth(210);
                lastNamefield.setLayoutX(287);
                lastNamefield.setLayoutY(43);

                DatePicker dateofbirth = new DatePicker();
                dateofbirth.setMinHeight(35);
                dateofbirth.setMinWidth(210);
                dateofbirth.setLayoutX(543);
                dateofbirth.setLayoutY(43);

                NamesPane.getChildren().add(FirstName);
                NamesPane.getChildren().add(LastName);
                NamesPane.getChildren().add(Date_of_Birth);
                NamesPane.getChildren().add(firstNameField);
                NamesPane.getChildren().add(lastNamefield);
                NamesPane.getChildren().add(dateofbirth);

                Pane SexPane = new Pane();
                NamesPane.setPrefHeight(114);
                NamesPane.setPrefWidth(800);

                Label Sex = new Label("Sex:");
                Sex.setStyle("-fx-font: normal bold 16px 'arial';");
                Sex.setMinHeight(55);
                Sex.setMinWidth(128);
                Sex.setLayoutX(35);

                Label Race = new Label("Race:");
                Race.setStyle("-fx-font: normal bold 16px 'arial';");
                Race.setMinHeight(55);
                Race.setMinWidth(128);
                Race.setLayoutX(196);

                Label Ethnicity = new Label("Ethnicity:");
                Ethnicity.setStyle("-fx-font: normal bold 16px 'arial';");
                Ethnicity.setMinHeight(55);
                Ethnicity.setMinWidth(128);
                Ethnicity.setLayoutX(493);

                ChoiceBox<String> sexChange = new ChoiceBox<String>();
                sexChange.setPrefHeight(35);
                sexChange.setPrefWidth(128);
                sexChange.setLayoutX(35);
                sexChange.setLayoutY(43);

                sexChange.getItems().add("Male");
                sexChange.getItems().add("Female");
                sexChange.getItems().add("Other");

                ChoiceBox<String> RaceChange = new ChoiceBox<String>();
                RaceChange.setPrefHeight(35);
                RaceChange.setPrefWidth(259);
                RaceChange.setLayoutX(196);
                RaceChange.setLayoutY(43);

                RaceChange.getItems().add("White");
                RaceChange.getItems().add("African American");
                RaceChange.getItems().add("American Indian");
                RaceChange.getItems().add("Asian");
                RaceChange.getItems().add("Native Hawaiian");

                ChoiceBox<String> EthnicityChange = new ChoiceBox<String>();
                EthnicityChange.setPrefHeight(35);
                EthnicityChange.setPrefWidth(259);
                EthnicityChange.setLayoutX(493);
                EthnicityChange.setLayoutY(43);

                EthnicityChange.getItems().add("Hispanic or Latino");
                EthnicityChange.getItems().add("Not Hispanic or Latino");

                SexPane.getChildren().add(Sex);
                SexPane.getChildren().add(Race);
                SexPane.getChildren().add(Ethnicity);
                SexPane.getChildren().add(sexChange);
                SexPane.getChildren().add(RaceChange);
                SexPane.getChildren().add(EthnicityChange);

                Pane BottomPane = new Pane();
                BottomPane.setPrefHeight(223);
                NamesPane.setPrefWidth(800);

                Button StartOrderButton = new Button("Save Patient");
                StartOrderButton.setPrefHeight(42);
                StartOrderButton.setPrefWidth(102);
                StartOrderButton.setLayoutX(509);
                StartOrderButton.setLayoutY(147);
                StartOrderButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                StartOrderButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        try {
                            DatabaseConnection connectNow = new DatabaseConnection();
                            Connection connectDB = connectNow.getConnection();
                            String PlacedOrdersTableQuery = "insert into patients (first_name, last_name, dob, sex, race, ethnicity) values ('"
                                    + firstNameField.getText() + "', '" + lastNamefield.getText() + "', '"
                                    + dateofbirth.getValue() + "', '" + sexChange.getValue() + "', '"
                                    + RaceChange.getValue() + "', '" + EthnicityChange.getValue() + "');";

                            Statement statement = connectDB.createStatement();
                            statement.execute(PlacedOrdersTableQuery);
                            Stage stage = (Stage) StartOrderButton.getScene().getWindow();
                            stage.close();
                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }

                    }
                });

                Button CancelButton = new Button("Cancel");
                CancelButton.setPrefHeight(42);
                CancelButton.setPrefWidth(102);
                CancelButton.setLayoutX(654);
                CancelButton.setLayoutY(147);
                CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

                CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Stage stage = (Stage) CancelButton.getScene().getWindow();
                        stage.close();
                    }
                });

                BottomPane.getChildren().add(StartOrderButton);
                BottomPane.getChildren().add(CancelButton);

                vbox.getChildren().add(newPane);
                vbox.getChildren().add(Filler);
                vbox.getChildren().add(NamesPane);
                vbox.getChildren().add(SexPane);
                vbox.getChildren().add(BottomPane);

                Scene scene = new Scene(vbox, 800, 600);

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
                        }
                    }
                });
                newWindow.show();
            }
        });// CLOSES NEW PATIENT AND WINDOW

        /*
         *
         * Modalities table
         * 
         */

        String ModalitiesTableQuery = "select*from modalities;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ModalitiesTableQuery);

            while (queryOutput.next()) {

                Integer modalityidquery = queryOutput.getInt("modality_id");
                String modalitynamequery = queryOutput.getString("name");
                String modalitypricequery = queryOutput.getString("price");
                Button button = new Button("Modify");

                ModalitiesTableObservableList.add(

                        new TABLEModalitiesTableController(modalityidquery, modalitynamequery, modalitypricequery,
                                button));
            }

            ModalitiesIDColumn.setCellValueFactory(new PropertyValueFactory<>("Modalityid"));
            ModalitiesNameColumn.setCellValueFactory(new PropertyValueFactory<>("Modalityname"));
            ModalityPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Modalityprice"));
            ModalitiesModify.setCellValueFactory(new PropertyValueFactory<>("Button"));

            ModalitiesTable.setItems(null);
            ModalitiesTable.setItems(ModalitiesTableObservableList);

        } catch (Exception e) {
            System.out.println("error");
        }

        /*
         *
         * Patient alerts table
         * 
         */

        String AlertsTableQuery = "select*from alerts;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(AlertsTableQuery);

            while (queryOutput.next()) {

                Integer alertidquery = queryOutput.getInt("alert_id");
                String alertnamequery = queryOutput.getString("alert_name");
                Button button = new Button("Modify");

                AlertsTableObservableList.add(

                        new TABLEPatientAlertsTableController(alertidquery, alertnamequery, button));
            }

            PatientAlertsIDColulm.setCellValueFactory(new PropertyValueFactory<>("Alertid"));
            PatientsAlertsColumn.setCellValueFactory(new PropertyValueFactory<>("Alertname"));
            PatientAlertsModifyColumn.setCellValueFactory(new PropertyValueFactory<>("Button"));

            PatientAlertsTable.setItems(null);
            PatientAlertsTable.setItems(AlertsTableObservableList);

        } catch (Exception e) {
            System.out.println("error");
        }

        /*
         *
         * Patients table
         * 
         */

        String PlacedOrdersTableQuery = "select * from patients;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PlacedOrdersTableQuery);

            while (queryOutput.next()) {

                Integer patient_id = queryOutput.getInt("patient_id");
                java.sql.Date dobquery = queryOutput.getDate("dob");
                String firstnamequery = queryOutput.getString("first_name");
                String lastnamequery = queryOutput.getString("last_name");
                Button button = new Button("Modify");

                PatientsTableObservableList.add(

                        new TABLEPatientsTableController(patient_id, dobquery, firstnamequery, lastnamequery, button));
            }

            PatientIDColumn.setCellValueFactory(new PropertyValueFactory<>("patientID"));
            PatientdobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
            PatientFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            PatientLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            PatientModifyColumn.setCellValueFactory(new PropertyValueFactory<>("Button"));

            PatientsTable.setItems(null);
            PatientsTable.setItems(PatientsTableObservableList);

        } catch (Exception e) {
            System.out.println("error");
        }

        /*
         *
         * Orders
         * 
         */

    }

}
