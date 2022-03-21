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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
import javafx.application.*;

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



public class ADMIN_AdminPanel_Controller implements Initializable{

   
 
   
    
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

    ObservableList<TABLESystemUsersTableController> UsersTableObservableList = FXCollections
            .observableArrayList();

    //Modalities imports
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

    //Patient alerts imports
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
    
    //Patient table imports
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

    //Orders table imports
    




    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        

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
                            
                new TABLESystemUsersTableController(userIDquery, usernamequery, displaynamequery, emailquery, rolequery, button));
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




        //CREATES NEW PATIENT AND WINDOW
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
                        @Override public void handle(ActionEvent e) {
                           
                   
                            try {
                                DatabaseConnection connectNow = new DatabaseConnection();
                                Connection connectDB = connectNow.getConnection();
                                String PlacedOrdersTableQuery = "insert into patients (first_name, last_name, dob, sex, race, ethnicity) values ('"+ firstNameField.getText() +"', '"+ lastNamefield.getText() +"', '"+ dateofbirth.getValue()+"', '"+sexChange.getValue() +"', '"+RaceChange.getValue() +"', '"+ EthnicityChange.getValue()+"');";
                        
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
                        @Override public void handle(ActionEvent e) {
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
                    if (key == KeyCode.ESCAPE){
                        newWindow.close();
                    }
                }
            });
            newWindow.show();
            }
        });//CLOSES NEW PATIENT AND WINDOW

        
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
                            
                new TABLEModalitiesTableController(modalityidquery, modalitynamequery, modalitypricequery, button));
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
                Button  button = new Button("Modify");

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

    

   
    
