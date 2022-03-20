package com.example.application;

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

public class ADMINREFERRALS_CONTROLLER implements Initializable {


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
    private TableView<TABLEReferralsTableController> AllPatientsTable;

    @FXML
    private TableColumn<TABLEReferralsTableController, Date> patients_date;

    @FXML
    private TableColumn<TABLEReferralsTableController, Integer> patients_firstName;

    @FXML
    private TableColumn<TABLEReferralsTableController, Integer> patients_lastName;

    @FXML
    private TableColumn<TABLEReferralsTableController, Button> ModifyButton;
    

    @FXML
    private TextField searchPlacedOrders;

    ObservableList<TABLEReferralsTableController> ReferralsTableObservableList = FXCollections
            .observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        

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
              String patientsex  = queryOutput.getString("sex");
           String patientrace= queryOutput.getString("race");
           String patientethnicity = queryOutput.getString("ethnicity");


    

    
           
           


                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {



                       

                        VBox vbox = new VBox();

                            Pane newPane = new Pane();
                                newPane.setLayoutX(0);
                                newPane.setLayoutY(0);
                                newPane.setPrefHeight(109);
                                newPane.setPrefWidth(800);
                             

                                Label PatientOverviewLabe = new Label("Patient Overview");
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
                                    firstNameField.setText(firstnamequery);
                                    firstNameField.setEditable(false);


                                TextField lastNamefield = new TextField();
                                    lastNamefield.setMinHeight(35);
                                    lastNamefield.setMinWidth(210);
                                    lastNamefield.setLayoutX(287);
                                    lastNamefield.setLayoutY(43);
                                    lastNamefield.setText(lastnamequery);
                                    lastNamefield.setEditable(false);

                                    TextField dateofbirth = new TextField();
                                    dateofbirth.setMinHeight(35);
                                    dateofbirth.setMinWidth(210);
                                    dateofbirth.setLayoutX(543);
                                    dateofbirth.setLayoutY(43);
                                    dateofbirth.setText(dobquery.toLocalDate().toString());
                                    dateofbirth.setEditable(false);
    
                       

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
                                    sexChange.setValue(patientsex);
                                    sexChange.setDisable(true);



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
                                    RaceChange.setValue(patientrace);
                                    RaceChange.setDisable(true);

                                ChoiceBox<String> EthnicityChange = new ChoiceBox<String>();
                                    EthnicityChange.setPrefHeight(35);
                                    EthnicityChange.setPrefWidth(259);
                                    EthnicityChange.setLayoutX(493);
                                    EthnicityChange.setLayoutY(43);

                                    EthnicityChange.getItems().add("Hispanic or Latino");
                                    EthnicityChange.getItems().add("Not Hispanic or Latino");
                                    EthnicityChange.setValue(patientethnicity);
                                    EthnicityChange.setDisable(true);
                            
                            SexPane.getChildren().add(Sex);
                            SexPane.getChildren().add(Race);
                            SexPane.getChildren().add(Ethnicity);
                            SexPane.getChildren().add(sexChange);
                            SexPane.getChildren().add(RaceChange);
                            SexPane.getChildren().add(EthnicityChange);


                            Pane BottomPane = new Pane();
                                BottomPane.setPrefHeight(223);
                                NamesPane.setPrefWidth(800);

                                Button StartOrderButton = new Button("Start Order");
                                StartOrderButton.setPrefHeight(42);
                                StartOrderButton.setPrefWidth(102);
                                StartOrderButton.setLayoutX(509);
                                StartOrderButton.setLayoutY(147);
                                StartOrderButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                StartOrderButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override public void handle(ActionEvent e) {
                                        Stage stage = (Stage) StartOrderButton.getScene().getWindow();
                                        stage.close();

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
                                                firstNameField.setText(firstnamequery);
                                                firstNameField.setEditable(false);
            
            
                                            TextField lastNamefield = new TextField();
                                                lastNamefield.setMinHeight(35);
                                                lastNamefield.setMinWidth(210);
                                                lastNamefield.setLayoutX(287);
                                                lastNamefield.setLayoutY(43);
                                                lastNamefield.setText(lastnamequery);
                                                lastNamefield.setEditable(false);
            
                                                TextField dateofbirth = new TextField();
                                                dateofbirth.setMinHeight(35);
                                                dateofbirth.setMinWidth(210);
                                                dateofbirth.setLayoutX(543);
                                                dateofbirth.setLayoutY(43);
                                                dateofbirth.setText(dobquery.toLocalDate().toString());
                                                dateofbirth.setEditable(false);
                
                                   
            
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
                                                sexChange.setValue(patientsex);
                                                sexChange.setDisable(true);
            
            
            
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
                                                RaceChange.setValue(patientrace);
                                                RaceChange.setDisable(true);
            
                                            ChoiceBox<String> EthnicityChange = new ChoiceBox<String>();
                                                EthnicityChange.setPrefHeight(35);
                                                EthnicityChange.setPrefWidth(259);
                                                EthnicityChange.setLayoutX(493);
                                                EthnicityChange.setLayoutY(43);
            
                                                EthnicityChange.getItems().add("Hispanic or Latino");
                                                EthnicityChange.getItems().add("Not Hispanic or Latino");
                                                EthnicityChange.setValue(patientethnicity);
                                                EthnicityChange.setDisable(true);
                                        
                                        SexPane.getChildren().add(Sex);
                                        SexPane.getChildren().add(Race);
                                        SexPane.getChildren().add(Ethnicity);
                                        SexPane.getChildren().add(sexChange);
                                        SexPane.getChildren().add(RaceChange);
                                        SexPane.getChildren().add(EthnicityChange);
            
            
                                        Pane BottomPane = new Pane();
                                            BottomPane.setPrefHeight(223);
                                            NamesPane.setPrefWidth(800);
            
                                            Button StartOrderButton = new Button("Start Order");
                                            StartOrderButton.setPrefHeight(42);
                                            StartOrderButton.setPrefWidth(102);
                                            StartOrderButton.setLayoutX(509);
                                            StartOrderButton.setLayoutY(147);
                                            StartOrderButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");
            
                                            StartOrderButton.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override public void handle(ActionEvent e) {
                                                    StartOrderButton.setText("Submitted");
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
                });

                ReferralsTableObservableList.add(new TABLEReferralsTableController(dobquery, firstnamequery, lastnamequery, button));
            }

            patients_date.setCellValueFactory(new PropertyValueFactory<>("dob"));

            patients_firstName.setCellValueFactory(new PropertyValueFactory<>("firstname"));

            patients_lastName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            ModifyButton.setCellValueFactory(new PropertyValueFactory<>("button"));




            AllPatientsTable.setItems(null);
            AllPatientsTable.setItems(ReferralsTableObservableList);

            
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

        //setCurrentUser(null)
        FXApp.setRoot("LOGIN");
    }

    public void home(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN");
    }

    public void userInfo(ActionEvent e) throws IOException {
        FXApp.setRoot("LOGIN");
    }

    public void admin(ActionEvent e) throws IOException {
        FXApp.setRoot("LOGIN");
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


    public void NewPatientGeneration() throws IOException {
        





           

            VBox vbox = new VBox();

                Pane newPane = new Pane();
                    newPane.setLayoutX(0);
                    newPane.setLayoutY(0);
                    newPane.setPrefHeight(109);
                    newPane.setPrefWidth(800);
                 

                    Label PatientOverviewLabe = new Label("Patient Overview");
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
                    
                        firstNameField.setEditable(true);


                    TextField lastNamefield = new TextField();
                        lastNamefield.setMinHeight(35);
                        lastNamefield.setMinWidth(210);
                        lastNamefield.setLayoutX(287);
                        lastNamefield.setLayoutY(43);
                 
                        lastNamefield.setEditable(true);

                        DatePicker dateofbirth = new DatePicker();
                        dateofbirth.setMinHeight(35);
                        dateofbirth.setMinWidth(210);
                        dateofbirth.setLayoutX(543);
                        dateofbirth.setLayoutY(43);
                        dateofbirth.setEditable(true);

           

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
                     
                        sexChange.setDisable(false);



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
                 
                        RaceChange.setDisable(false);

                    ChoiceBox<String> EthnicityChange = new ChoiceBox<String>();
                        EthnicityChange.setPrefHeight(35);
                        EthnicityChange.setPrefWidth(259);
                        EthnicityChange.setLayoutX(493);
                        EthnicityChange.setLayoutY(43);

                        EthnicityChange.getItems().add("Hispanic or Latino");
                        EthnicityChange.getItems().add("Not Hispanic or Latino");
                     
                        EthnicityChange.setDisable(false);
                
                SexPane.getChildren().add(Sex);
                SexPane.getChildren().add(Race);
                SexPane.getChildren().add(Ethnicity);
                SexPane.getChildren().add(sexChange);
                SexPane.getChildren().add(RaceChange);
                SexPane.getChildren().add(EthnicityChange);


                Pane BottomPane = new Pane();
                    BottomPane.setPrefHeight(223);
                    NamesPane.setPrefWidth(800);

                    Button StartOrderButton = new Button("Add Patient");
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
                                    } catch (SQLException e1) {
                                       
                                        e1.printStackTrace();
                                    }
                        
                        
                        
                    }});


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
}

