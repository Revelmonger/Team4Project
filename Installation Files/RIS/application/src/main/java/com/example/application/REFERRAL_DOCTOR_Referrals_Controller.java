package com.example.application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ResourceBundle;



import com.example.application.Constructors.AllAlertsChoiceBoxController;
import com.example.application.Constructors.Modalities;
import com.example.application.Constructors.OrderStatuses;

import com.example.application.Constructors.ReferralDoctor;
import com.example.application.TableConstructors.ClosedOrders;
import com.example.application.TableConstructors.PatientsAlertsTableController;
import com.example.application.TableConstructors.TABLEPlacedOrdersTableController;
import com.example.application.TableConstructors.TABLEReferralsTableController;



import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.control.SelectionMode;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.beans.value.ObservableValue;

public class REFERRAL_DOCTOR_Referrals_Controller implements Initializable {
    ObservableList<String> selectedItems;
    String userid = LOGIN.LoggedInUserID;
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

    @FXML
    private AnchorPane BlurBox;












//Help Button Logic
@FXML
private Button HelpButton;

@FXML
public void HelpButtonEntered() {

    HelpButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");

}

@FXML
public void HelpButtonExited() {

    HelpButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
}

public void HelpButtonPressed(ActionEvent e) throws IOException {

    FXApp.setRoot("REFERRAL_DOCTOR_Tutorial");
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
    private TextField searchAdminReferrals;

    ObservableList<TABLEReferralsTableController> ReferralsTableObservableList = FXCollections
            .observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String SelectAllFromPatientsQuery = "select * from patients;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(SelectAllFromPatientsQuery);

            while (queryOutput.next()) {

                Integer patient_id = queryOutput.getInt("patient_id");
                java.sql.Date dobquery = queryOutput.getDate("dob");
                String firstnamequery = queryOutput.getString("first_name");
                String lastnamequery = queryOutput.getString("last_name");
                Button button = new Button("Select");
                String patientsex = queryOutput.getString("sex");
                String patientrace = queryOutput.getString("race");
                String patientethnicity = queryOutput.getString("ethnicity");

                button.setStyle(
                        "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

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
                        BottomPane.setPrefWidth(800);


try {
    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();
    
    String DoesThisPatientHaveAnAlert = "Select * from patients_alerts where patient_id = '"+ patient_id+ "'";
    
    Statement statement = connectDB.createStatement();
    ResultSet queryOutput2 = statement.executeQuery(DoesThisPatientHaveAnAlert);


    Button button2 = new Button("History");
    button2.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");
    button2.setPrefHeight(42);
    button2.setPrefWidth(128);
    button2.setLayoutX(200);
    button2.setLayoutY(35);
    BottomPane.getChildren().add(button2);
    button2.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {
    BlurBox.setEffect(new BoxBlur(5, 10, 10));

    Stage newWindow = new Stage();
    newWindow.setWidth(1000);

    AnchorPane anchorpane = new AnchorPane();

    Label CreateNewPatientAlertLabel = new Label("Imaging History");
    CreateNewPatientAlertLabel.setLayoutX(46);
    CreateNewPatientAlertLabel.setLayoutY(47);
    CreateNewPatientAlertLabel.setStyle("-fx-font: normal bold 36px 'arial';");

    Line horizontalline = new Line(50.0f, 0.0f, 850.0f, 0.0f);
    horizontalline.setOpacity(.3);
    horizontalline.setTranslateY(100);

    TableView tableView = new TableView();

    tableView.setPrefWidth(800);
    tableView.setPrefHeight(400);
    tableView.setLayoutX(47);
    tableView.setLayoutY(150);
    tableView.setEditable(false);
    tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

 
                TableColumn<TABLEPlacedOrdersTableController, String> column1 = new TableColumn<>(
                    "Patient");
                TableColumn<TABLEPlacedOrdersTableController, Integer> column2 = new TableColumn<>(
                    "Modality");
                    TableColumn<TABLEPlacedOrdersTableController, Integer> column3 = new TableColumn<>(
                    "Notes");
                    TableColumn<TABLEPlacedOrdersTableController, Integer> column4 = new TableColumn<>(
                    "Status");
                    TableColumn<TABLEPlacedOrdersTableController, Integer> column5 = new TableColumn<>(
                    "Results");
               
    column1.setCellValueFactory(new PropertyValueFactory<>("patient"));
    column1.setPrefWidth(500);
    column2.setCellValueFactory(new PropertyValueFactory<>("modality"));
    column2.setPrefWidth(500);
    column3.setCellValueFactory(new PropertyValueFactory<>("notes"));
    column3.setPrefWidth(500);
    column4.setCellValueFactory(new PropertyValueFactory<>("status"));
    column4.setPrefWidth(500);
    column5.setCellValueFactory(new PropertyValueFactory<>("button"));
    column5.setPrefWidth(500);
   


    tableView.getColumns().add(column1);
    tableView.getColumns().add(column2);
    tableView.getColumns().add(column3);
    tableView.getColumns().add(column4);
    tableView.getColumns().add(column5);

    try {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String alert_nameTableQuery = "select * from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id where patient_id = '"+ patient_id+ "' and orders.status = 2";

        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(alert_nameTableQuery);

        while (queryOutput.next()) {
            String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
            String modalityquery = queryOutput.getString("name");
            String notesquery = queryOutput.getString("notes").trim();
            String statusquery = queryOutput.getString("order_name");
            Button button = new Button("Review Order");
            button.setStyle(
                "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");
            Integer OrderID = queryOutput.getInt("order_id");

            button.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    BlurBox.setEffect(new BoxBlur(5, 10, 10));

                    Stage newWindow = new Stage();
                    newWindow.setWidth(1000);
                    newWindow.setHeight(800);
                    

                    AnchorPane anchorpane = new AnchorPane();

                    Label CreateFileLabel = new Label("View Old Report");
                    CreateFileLabel.setLayoutX(46);
                    CreateFileLabel.setLayoutY(47);
                    CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                    Label ReportLabel = new Label("Report:");
                    ReportLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                    ReportLabel.setLayoutX(120);
                    ReportLabel.setLayoutY(120);

                    TextArea ReportArea = new TextArea();
                    ReportArea.setPrefHeight(400);
                    ReportArea.setPrefWidth(600);
                    ReportArea.setLayoutX(200);
                    ReportArea.setLayoutY(120);
                    ReportArea.setEditable(false);

                    String DiagnosticQuery = "select diagnostic from diagnostic_reports where order_id = " + OrderID
                            + ";";

                    try {
                        ResultSet DiagnosticReport = statement.executeQuery(DiagnosticQuery);

                        while (DiagnosticReport.next()) {
                            String diagnostic = DiagnosticReport.getString("diagnostic");
                            ReportArea.setText(diagnostic);
                            ReportArea.setEditable(false);
                        }
                    } catch (SQLException e2) {

                        e2.printStackTrace();
                    }

                    Line horizontalline = new Line(50.0f, 0.0f, 850.0f, 0.0f);
                    horizontalline.setOpacity(.3);
                    horizontalline.setTranslateY(100);

                    Button showImage = new Button("Show Image");
                    showImage.setPrefHeight(42);
                    showImage.setPrefWidth(100);
                    showImage.setLayoutX(560);
                    showImage.setLayoutY(560);
                    showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                    showImage.setOnAction(new EventHandler<ActionEvent>() {

                        /************** SHOWS IMAGE IN NEW WINDOW *********************************/
                        @Override
                        public void handle(ActionEvent e) {

                            String ImagePathStatement = "SELECT upload_path FROM db_ris.file_uploads WHERE order_id ='"
                                    + OrderID + "'";

                            try {

                                Statement statement5 = connectDB.createStatement();
                                ResultSet queryOutput;
                                queryOutput = statement5.executeQuery(ImagePathStatement);

                                while (queryOutput.next()) {

                                    String UploadPath = queryOutput.getString("upload_path");
                                    File file = new File(UploadPath);
                                    Image img = new Image(file.toURI().toString());
                                    double width = img.getWidth();
                                    double height = img.getHeight();
                                    ;

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
                    // WORKING HERE

                    Button CancelButton = new Button("Cancel");
                    CancelButton.setPrefHeight(42);
                    CancelButton.setPrefWidth(102);
                    CancelButton.setLayoutX(700);
                    CancelButton.setLayoutY(560);
                    CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

                    CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            Stage stage = (Stage) CancelButton.getScene().getWindow();
                            stage.close();
                            BlurBox.setEffect(new BoxBlur(5, 10, 10));

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

            tableView.getItems().add(new ClosedOrders(patientquery, modalityquery,notesquery,statusquery,button));
            

        }

        

        

    } catch (Exception e) {
        e.printStackTrace();
    }

    Button CancelButton = new Button("Cancel");
    CancelButton.setPrefHeight(42);
    CancelButton.setPrefWidth(102);
    CancelButton.setLayoutX(740);
    CancelButton.setLayoutY(585);
    CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

    CancelButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Stage stage = (Stage) CancelButton.getScene().getWindow();
            stage.close();
            BlurBox.setEffect(new BoxBlur(5, 10, 10));

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











    while (queryOutput2.next()) {


        Button button = new Button("Patient Alerts");
        button.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");
        button.setPrefHeight(42);
        button.setPrefWidth(128);
        button.setLayoutX(35);
        button.setLayoutY(35);
                BottomPane.getChildren().add(button);



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
                        
                        String alert_nameTableQuery = " select * from patients_alerts as pa join alerts as a on a.alert_id = pa.alert_id where patient_id = " + patient_id + ";";
                        
                        
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
                                BlurBox.setEffect(new BoxBlur(5, 10, 10));
                
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











        


     






       
    }

   
   

} catch (Exception e) {
e.printStackTrace();        }




                        Button StartOrderButton = new Button("Begin Order");
                        StartOrderButton.setPrefHeight(42);
                        StartOrderButton.setPrefWidth(102);
                        StartOrderButton.setLayoutX(509);
                        StartOrderButton.setLayoutY(147);
                        StartOrderButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                        StartOrderButton.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                Stage stage = (Stage) StartOrderButton.getScene().getWindow();

                                stage.close();
                                VBox vbox = new VBox();

                                Pane newPane = new Pane();
                                newPane.setLayoutX(0);
                                newPane.setLayoutY(0);
                                newPane.setPrefHeight(109);
                                newPane.setPrefWidth(800);

                                Label PatientOverviewLabe = new Label("Create New Order");
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





                                //ADD QUERY HERE

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
                                SelectedPatientField.setValue(firstnamequery + " " + lastnamequery);
                                SelectedPatientField.setDisable(true);

                                ChoiceBox<String> SelectedDoctorField = new ChoiceBox<String>();
                                SelectedDoctorField.setStyle("-fx-font: normal bold 16px 'arial';");
                                SelectedDoctorField.setMinHeight(35);
                                SelectedDoctorField.setMaxWidth(210);
                                SelectedDoctorField.setLayoutX(287);
                                SelectedDoctorField.setLayoutY(43);
                                SelectedDoctorField.setPrefWidth(210);


      // Adds Doctors
      try {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String GetChoiceBoxQuery = "select * from users as u join users_roles as ur on ur.user_id = u.user_id where role_id = 3 and u.user_id = "+ userid +";";
        Statement statement = connectDB.createStatement();
        ResultSet DoctorQueryOutput = statement.executeQuery(GetChoiceBoxQuery);

        while (DoctorQueryOutput.next()) {
            ReferralDoctor currentReferralDoctor = new ReferralDoctor(
                    DoctorQueryOutput.getString("full_name"),
                    DoctorQueryOutput.getInt("user_id"));


            SelectedDoctorField.getItems().add(currentReferralDoctor.getReferraldoctor());
            SelectedDoctorField.setValue(currentReferralDoctor.getReferraldoctor());
            SelectedDoctorField.setDisable(true);
        }

    } catch (SQLException e1) {

        e1.printStackTrace();
    }









                                ChoiceBox<String> SelectedStatusField = new ChoiceBox<String>();
                                SelectedStatusField.setStyle("-fx-font: normal bold 16px 'arial';");
                                SelectedStatusField.setMinHeight(35);
                                SelectedStatusField.setMaxWidth(210);
                                SelectedStatusField.setLayoutX(543);
                                SelectedStatusField.setLayoutY(43);
                                SelectedStatusField.setPrefHeight(210);
                                SelectedStatusField.setMaxHeight(35);
                                SelectedStatusField.setPrefWidth(210);
                                SelectedStatusField.setDisable(true);     
                                SelectedStatusField.setValue("In Progress");

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

                                SelectedPatientField.getItems().add(firstnamequery + " " + lastnamequery);

                                // Adds Modalities to Modalities Box
                                try {
                                    DatabaseConnection connectNow = new DatabaseConnection();
                                    Connection connectDB = connectNow.getConnection();

                                    String GetChoiceBoxQuery = "Select * from modalities";
                                    Statement statement = connectDB.createStatement();
                                    ResultSet ModalitiesOutput = statement.executeQuery(GetChoiceBoxQuery);

                                    while (ModalitiesOutput.next()) {
                                        Modalities currentitterationpatient = new Modalities(
                                                ModalitiesOutput.getInt("modality_id"),
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
                          

                                Label RefNotes = new Label("Referral Notes:");
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

                                            String[] firstandlastnames = SelectedPatientField.getValue().toString()
                                                    .split(" ", 2);

                                            String InsertQueries = "Select patient_id from patients where first_name = '"
                                                    + firstandlastnames[0] + "' and last_name = '"
                                                    + firstandlastnames[1] + "'";
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
                                                    + ReferralTextField.getText().trim() + "', '4');";
                                            Statement statement = connectDB.createStatement();

                                            statement.execute(insertheorder);

                                            Stage stage = (Stage) CreateOrderButton.getScene().getWindow();
                                            stage.close();
                                            BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                            FXApp.setRoot("REFERRAL_DOCTOR_Referrals");

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
                                CancelButton.setLayoutX(654);
                                CancelButton.setLayoutY(147);
                                CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

                                CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent e) {
                                        Stage stage = (Stage) CancelButton.getScene().getWindow();
                                        stage.close();
                                        BlurBox.setEffect(new BoxBlur(0, 0, 0));

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
                                            BlurBox.setEffect(new BoxBlur(0, 0, 0));

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
                            @Override
                            public void handle(ActionEvent e) {
                                Stage stage = (Stage) CancelButton.getScene().getWindow();
                                stage.close();
                                BlurBox.setEffect(new BoxBlur(0, 0, 0));

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
                                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                }
                            }
                        });
                        newWindow.show();
                    }
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                });

                ReferralsTableObservableList
                        .add(new TABLEReferralsTableController(dobquery, firstnamequery, lastnamequery, button));
            }

            patients_date.setCellValueFactory(new PropertyValueFactory<>("dob"));

            patients_firstName.setCellValueFactory(new PropertyValueFactory<>("firstname"));

            patients_lastName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            ModifyButton.setCellValueFactory(new PropertyValueFactory<>("button"));

            AllPatientsTable.setItems(null);
            AllPatientsTable.setItems(ReferralsTableObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLEReferralsTableController> ReferralsTableFilteredData = new FilteredList<>(
                    ReferralsTableObservableList);

            searchAdminReferrals.textProperty().addListener((observable, oldValue, newValue) -> {
                ReferralsTableFilteredData.setPredicate(TABLEReferralsTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLEReferralsTableController.getDob().toString().indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEReferralsTableController.getFirstname().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } /*
                       * else if
                       * (TABLEReferralsTableController.getDate_time().toLowerCase().indexOf(
                       * searchKeyword) > -1) {
                       * return true;
                       * 
                       * }
                       */ else if (TABLEReferralsTableController.getLastname().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TABLEReferralsTableController> ReferralsSortedData = new SortedList<>(
                    ReferralsTableFilteredData);

            // Binds the sorted resultswith the Table
            ReferralsSortedData.comparatorProperty().bind(AllPatientsTable.comparatorProperty());

            AllPatientsTable.setItems(ReferralsSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            e.printStackTrace();
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
        FXApp.setRoot("REFERRAL_DOCTOR");
    }

    public void userInfo(ActionEvent e) throws IOException {

        FXApp.setRoot("REFERRAL_DOCTOR_UserInfo");
    }

    public void admin(ActionEvent e) throws IOException {
        FXApp.setRoot("");
    }

    public void referrals(ActionEvent e) throws IOException {
        FXApp.setRoot("REFERRAL_DOCTOR_Referrals");
    }

    public void orders(ActionEvent e) throws IOException {
        FXApp.setRoot("");
    }

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("");
    }

    public int patients_id;
    public int alertid;

    // Creates New Patient
    public void NewPatientGeneration() throws IOException {

        BlurBox.setEffect(new BoxBlur(5, 10, 10));

        VBox vbox = new VBox();

        Pane newPane = new Pane();
        newPane.setLayoutX(0);
        newPane.setLayoutY(0);
        newPane.setPrefHeight(109);
        newPane.setPrefWidth(800);

        Label PatientOverviewLabe = new Label("Create New Patient");
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
        SexPane.setPrefHeight(114);
        SexPane.setPrefWidth(800);

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

        Label Alert = new Label("Alert:");
        Alert.setStyle("-fx-font: normal bold 16px 'arial';");
        Alert.setMinHeight(55);
        Alert.setMinWidth(128);
        Alert.setLayoutX(35);

        Label SelectedItems = new Label("");
        SelectedItems.setStyle("-fx-font: normal bold 16px 'arial';");
        SelectedItems.setMinHeight(55);
        SelectedItems.setMinWidth(128);
        SelectedItems.setLayoutX(170);
        SelectedItems.setLayoutY(50);

        ListView<String> listView = new ListView<>();
        listView.setPrefHeight(100);
        listView.setPrefWidth(128);
        listView.setLayoutX(35);
        listView.setLayoutY(50);

        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            String GetAllAlerts = "select * from alerts";
            Statement statement = connectDB.createStatement();
            ResultSet AlertQueryOutput = statement.executeQuery(GetAllAlerts);

            while (AlertQueryOutput.next()) {
                AllAlertsChoiceBoxController CurrentAlert = new AllAlertsChoiceBoxController(
                        AlertQueryOutput.getInt("alert_id"), AlertQueryOutput.getString("alert_name"));

                listView.getItems().add(CurrentAlert.getalertName());
                //alertid = AlertQueryOutput.getInt("alert_id");

            }

        } catch (SQLException e1) {

            e1.printStackTrace();
        }
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    selectedItems = listView.getSelectionModel().getSelectedItems();

                    StringBuilder builder = new StringBuilder("");

                    for (String name : selectedItems) {
                        builder.append(name + "\n");
                    }

                    SelectedItems.setText(builder.toString());

                });

        Button AddPatientButton = new Button("Add Patient");
        AddPatientButton.setPrefHeight(42);
        AddPatientButton.setPrefWidth(102);
        AddPatientButton.setLayoutX(509);
        AddPatientButton.setLayoutY(147);
        AddPatientButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        AddPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                if(firstNameField.getText().isEmpty() || lastNamefield.getText().isEmpty() || dateofbirth.getValue() == null || sexChange.getValue().isEmpty() || RaceChange.getValue().isEmpty() || EthnicityChange.getValue().isEmpty())
                {

                }

                else{

                    try {
                        DatabaseConnection connectNow = new DatabaseConnection();
                        Connection connectDB = connectNow.getConnection();
                        String InsertIntoPatientsTableQuery = "insert into patients (first_name, last_name, dob, sex, race, ethnicity) values ('"
                                + firstNameField.getText().trim() + "', '" + lastNamefield.getText().trim() + "', '"
                                + dateofbirth.getValue() + "', '" + sexChange.getValue() + "', '" + RaceChange.getValue()
                                + "', '" + EthnicityChange.getValue() + "');";
    
                        String listviewContent =   listView.getSelectionModel().getSelectedItems().toString();
                        String FindPatientID = " SELECT LAST_INSERT_ID();";
                        
    
                        Statement statement = connectDB.createStatement();
                        Statement statement2 = connectDB.createStatement();
                        statement.execute(InsertIntoPatientsTableQuery);
                        ResultSet PatientIDOutput = statement.executeQuery(FindPatientID);
                        
    
                     
                        //IF the ListView Has no selections
                        if (listviewContent.equals("[]")){
    
                            
                            // If there are selections
                        } else {
    
                            while (PatientIDOutput.next()) {
                                patients_id = PatientIDOutput.getInt("LAST_INSERT_ID()");
                               
                            }
        
                                for (String name : selectedItems) {
                                    connectNow = new DatabaseConnection();
                                    connectDB = connectNow.getConnection();
                                    
                                    String GetAllAlerts = "select * from alerts where alert_name = '" + name + "';";
                                    ResultSet AlertQueryOutput = statement2.executeQuery(GetAllAlerts);
    
                                    while(AlertQueryOutput.next()){
                                        alertid = AlertQueryOutput.getInt("alert_id");
    
                                        String InsertIntoAlertsTableQuery = "insert into patients_alerts (patient_id, alert_id) values ('"
                                            + patients_id + "', '" + alertid + "');";
                                        statement = connectDB.createStatement();
                                        statement.execute(InsertIntoAlertsTableQuery);
                                    }
    
                                }
                        }
    
                        
                    
                      
                    
                        Stage stage = (Stage) AddPatientButton.getScene().getWindow();
                        stage.close();
                        BlurBox.setEffect(new BoxBlur(0, 0, 0));
    
                        FXApp.setRoot("REFERRAL_DOCTOR_Referrals");
    
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
        CancelButton.setLayoutX(654);
        CancelButton.setLayoutY(147);
        CancelButton.setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = (Stage) CancelButton.getScene().getWindow();
                BlurBox.setEffect(new BoxBlur(0, 0, 0));
                stage.close();
            }
        });

        BottomPane.getChildren().add(AddPatientButton);
        BottomPane.getChildren().add(CancelButton);
        BottomPane.getChildren().add(Alert);
        BottomPane.getChildren().add(listView);
        BottomPane.getChildren().add(SelectedItems);

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
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));
                    newWindow.close();
                }
            }
        });
        newWindow.show();

    }
}
