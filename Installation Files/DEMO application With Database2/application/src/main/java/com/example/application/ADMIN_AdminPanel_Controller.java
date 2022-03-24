package com.example.application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ResourceBundle;

import javax.management.Query;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.example.application.Constructors.Modalities;
import com.example.application.Constructors.OrderStatuses;
import com.example.application.Constructors.Orders;
import com.example.application.Constructors.Patient;
import com.example.application.Constructors.Radiologists;
import com.example.application.Constructors.ReferralDoctor;
import com.example.application.TableConstructors.TABLEAppointmentsTableController;
import com.example.application.TableConstructors.TABLEDiagnosticReportsTableController;
import com.example.application.TableConstructors.TABLEFileUploadsTableController;
import com.example.application.TableConstructors.TABLEModalitiesTableController;
import com.example.application.TableConstructors.TABLEOrdersTableController;
import com.example.application.TableConstructors.TABLEPatientAlertsTableController;
import com.example.application.TableConstructors.TABLEPatientsTableController;
import com.example.application.TableConstructors.TABLESystemUsersTableController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DisplacementMap;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.util.Strings;
import org.hibernate.cache.spi.QueryResultsCache;
import org.hibernate.sql.Select;
import org.hibernate.type.SerializableToBlobType;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.Modality;

import javafx.stage.StageStyle;
import javafx.util.FXPermission;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.ForArray.ReadOnly;
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

    @FXML
   private ScrollPane BlurBox;
   
   @FXML
   private Button NewPatientAlerts;
   
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
    private Button NewDiagnosticReport;

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
    private TextField searchSystemUsers;

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
    private TextField searchPatientAlerts;

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

//Orders table imports
@FXML
private TableView<TABLEOrdersTableController> OrdersTable;

@FXML
private TableColumn<TABLEOrdersTableController, Integer> OrdersIDColumn;

@FXML
private TableColumn<TABLEOrdersTableController, String> OrdersPatientNameColumn;

@FXML
private TableColumn<TABLEOrdersTableController, String> OrdersReferralDoctorColumn;

@FXML
private TableColumn<TABLEOrdersTableController, String> OrdersModalityColumn;

@FXML
private TableColumn<TABLEOrdersTableController, String> OrdersNotesColumn;

@FXML
private TableColumn<TABLEOrdersTableController, String> OrdersStatusColumn;

@FXML
private TableColumn<TABLEOrdersTableController, Button> OrdersModifyColumn;

@FXML
private TextField searchOrders;

ObservableList<TABLEOrdersTableController> OrdersTableObservableList = FXCollections
        .observableArrayList();










//Appointments table imports
@FXML
private TableView<TABLEAppointmentsTableController> AppointmentsTable;

@FXML
private TableColumn<TABLEAppointmentsTableController, Integer> AppointmentID;

@FXML
private TableColumn<TABLEAppointmentsTableController, String> AppintmentPatient;

@FXML
private TableColumn<TABLEAppointmentsTableController, Integer> AppopintmentsOrderNumber;

@FXML
private TableColumn<TABLEAppointmentsTableController, Date> AppointmentsDateandtime;

@FXML
private TableColumn<TABLEAppointmentsTableController, String> AppointmentsRadiologist;

@FXML
private TableColumn<TABLEAppointmentsTableController, Button> AppointmentsModify;

@FXML
private TextField searchAppointments;

ObservableList<TABLEAppointmentsTableController> AppointmentsTableObservableList = FXCollections
        .observableArrayList();
     @FXML
     private Button NewAppointment;



//File Upload table imports
@FXML
private TableView<TABLEFileUploadsTableController> FileUploadsTable;

@FXML
private TableColumn<TABLEFileUploadsTableController, Integer> FilesUploadsID;

@FXML
private TableColumn<TABLEFileUploadsTableController, String> FileUploadsName;

@FXML
private TableColumn<TABLEFileUploadsTableController, String> FileUploadsType;

@FXML
private TableColumn<TABLEFileUploadsTableController, Integer> FileUploadsOrderNumber;

@FXML
private TableColumn<TABLEFileUploadsTableController, String> FileUploadsOpenNewWindow;

@FXML
private TableColumn<TABLEFileUploadsTableController, Button> FileUploadsModify;

@FXML
private TextField searchFileUploads;

ObservableList<TABLEFileUploadsTableController> FileUploadsObservableList = FXCollections
        .observableArrayList();

// Diagnostic Reports table imports       
@FXML
private TableView<TABLEDiagnosticReportsTableController> DiagnosticReportsTable;

@FXML
private TableColumn<TABLEDiagnosticReportsTableController, Integer> ReportsID;

@FXML
private TableColumn<TABLEDiagnosticReportsTableController, String> ReportsRadiologist;

@FXML
private TableColumn<TABLEDiagnosticReportsTableController, Integer> ReportsOrderNumber;

@FXML
private TableColumn<TABLEDiagnosticReportsTableController, String> ReportsReport;

@FXML
private TableColumn<TABLEDiagnosticReportsTableController, Button> ReportsModify;

@FXML
private TextField searchDiagnosticReports;

ObservableList<TABLEDiagnosticReportsTableController> DiagnosticReportsObservableList = FXCollections
                .observableArrayList();
        




@FXML
private Button NewFileUpload;

@FXML
private Button NewModalities;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {



        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();




//Creates New Patient Alert
NewPatientAlerts.setOnAction(new EventHandler<ActionEvent>() {

   
    @Override
    public void handle(ActionEvent event) {
        BlurBox.setEffect(new BoxBlur(5, 10, 10));

         
        Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
       

        Label CreateNewPatientAlertLabel = new Label("Create New Patient Alert");
        CreateNewPatientAlertLabel.setLayoutX(46);
        CreateNewPatientAlertLabel.setLayoutY(47);
        CreateNewPatientAlertLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label ModalityName = new Label("Patient Alert Name:");
        ModalityName.setStyle("-fx-font: normal bold 16px 'arial';");
        ModalityName.setLayoutX(47);
        ModalityName.setLayoutY(192);



        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

  
    
        TextField PatientAlertNameField = new TextField();
        PatientAlertNameField.setMinHeight(35);
        PatientAlertNameField.setMinWidth(145);
        PatientAlertNameField.setLayoutX(47);
        PatientAlertNameField.setLayoutY(227);



       
        
        
     




      Button CreateNewModalityButton = new Button("Save Alert");
        CreateNewModalityButton.setPrefHeight(42);
        CreateNewModalityButton.setPrefWidth(102);
        CreateNewModalityButton.setLayoutX(565);
        CreateNewModalityButton.setLayoutY(338);
        CreateNewModalityButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        CreateNewModalityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
  
           

                try {
                    String InsertIntoAlerts = "insert into alerts (alert_name) values ('" + PatientAlertNameField.getText() + " ');";
                    Statement statement = connectDB.createStatement();
                    statement.execute(InsertIntoAlerts);

                    Stage stage = (Stage) CreateNewModalityButton.getScene().getWindow();
                    stage.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                    FXApp.setRoot("ADMIN_AdminPanel");
                    
                } catch (SQLException e1) {

                    e1.printStackTrace();
          
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
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

                anchorpane.getChildren().add(CreateNewPatientAlertLabel);
                anchorpane.getChildren().add(ModalityName);
               
                anchorpane.getChildren().add(horizontalline);
             
                anchorpane.getChildren().add(CancelButton);
                anchorpane.getChildren().add(CreateNewModalityButton);
                anchorpane.getChildren().add(PatientAlertNameField);

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
});// Closes New Patient Alert




//Creates New Modality
NewModalities.setOnAction(new EventHandler<ActionEvent>() {

   
    @Override
    public void handle(ActionEvent event) {
        BlurBox.setEffect(new BoxBlur(5, 10, 10));

         
        Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
       

        Label CreateNewModalityLabel = new Label("Create New Modality");
        CreateNewModalityLabel.setLayoutX(46);
        CreateNewModalityLabel.setLayoutY(47);
        CreateNewModalityLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label ModalityName = new Label("Modality Name:");
        ModalityName.setStyle("-fx-font: normal bold 16px 'arial';");
        ModalityName.setLayoutX(47);
        ModalityName.setLayoutY(192);

        Label modalityPriceLabel = new Label("Modality Price:");
        modalityPriceLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        modalityPriceLabel.setLayoutX(350);
        modalityPriceLabel.setLayoutY(192);
     

        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

  
    
        TextField ModalityNameTextField = new TextField();
        ModalityNameTextField.setMinHeight(35);
        ModalityNameTextField.setMinWidth(145);
        ModalityNameTextField.setLayoutX(47);
        ModalityNameTextField.setLayoutY(227);



       
        
        
        
        TextField ModalityPriceTextField = new TextField();
        ModalityPriceTextField.setMinHeight(35);
        ModalityPriceTextField.setMinWidth(145);
        ModalityPriceTextField.setLayoutX(350);
        ModalityPriceTextField.setLayoutY(227);
  
     




      Button CreateNewModalityButton = new Button("Save Modality");
        CreateNewModalityButton.setPrefHeight(42);
        CreateNewModalityButton.setPrefWidth(102);
        CreateNewModalityButton.setLayoutX(565);
        CreateNewModalityButton.setLayoutY(338);
        CreateNewModalityButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        CreateNewModalityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
  
                try {
                    String InstertIntoModalitiesTable = "insert into modalities (name, price) values ('" + ModalityNameTextField.getText() + "', '"+ ModalityPriceTextField.getText() +"')";
                    Statement statement = connectDB.createStatement();
                    statement.execute(InstertIntoModalitiesTable);

                  


                    Stage stage = (Stage) CreateNewModalityButton.getScene().getWindow();
                    stage.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                    FXApp.setRoot("ADMIN_AdminPanel");
                    
                } catch (SQLException e1) {

                    e1.printStackTrace();
          
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
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

                anchorpane.getChildren().add(CreateNewModalityLabel);
                anchorpane.getChildren().add(ModalityName);
                anchorpane.getChildren().add(modalityPriceLabel);
                anchorpane.getChildren().add(horizontalline);
                anchorpane.getChildren().add(ModalityPriceTextField);
      
                anchorpane.getChildren().add(ModalityNameTextField);
                anchorpane.getChildren().add(CancelButton);
                anchorpane.getChildren().add(CreateNewModalityButton);

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
});// Closes New Modality































 // CREATES NEW Appointment
 NewAppointment.setOnAction(new EventHandler<ActionEvent>() {

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


      TextField patientfortheorder = new TextField();
      patientfortheorder.setPrefHeight(35);
      patientfortheorder.setPrefWidth(170);
      patientfortheorder.setLayoutX(260);
      patientfortheorder.setLayoutY(270);
      patientfortheorder.setEditable(false);
      

  

        
       
        


      ChoiceBox<String> OrdersChoiceBox = new ChoiceBox<String>();
      OrdersChoiceBox.setPrefHeight(35);
      OrdersChoiceBox.setPrefWidth(170);
      OrdersChoiceBox.setLayoutX(22);
      OrdersChoiceBox.setLayoutY(160);

      // Adds Orders to the Box
      try {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

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




// Adds Costs to the Box
/*try {
DatabaseConnection connectNow = new DatabaseConnection();
Connection connectDB = connectNow.getConnection();

String GetChoiceBoxQuery = "Select  price from modatlities where name = '"+  + "'";
Statement statement = connectDB.createStatement();
ResultSet radiologistsQuery = statement.executeQuery(GetChoiceBoxQuery);

while (radiologistsQuery.next()) {
  Radiologists currentRadiologist = new Radiologists(radiologistsQuery.getInt("id"), radiologistsQuery.getString("full_name"));
  RadiologistChoiceBox.getItems().add(currentRadiologist.getRadiologistName());
}

} catch (SQLException e1) {

e1.printStackTrace();
}
*/


        OfficeInfoPane.getChildren().add(OrderLabel);
        OfficeInfoPane.getChildren().add(OfficeInfoLabel);
        OfficeInfoPane.getChildren().add(HorizontalLineOfficeIn);
        OfficeInfoPane.getChildren().add(ModalityLabel);
        OfficeInfoPane.getChildren().add(RadiologistLabel);
        OfficeInfoPane.getChildren().add(EstimatedCostsLabel);
        OfficeInfoPane.getChildren().add(OrdersChoiceBox);
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
                    String GetPatientQuery = "select order_id, patient, modality from orders where order_id = '" + OrdersChoiceBox.getValue() + "';";
                    
                    Statement RadiologistStatement = connectDB.createStatement();
                    Statement PatientStatement = connectDB.createStatement();
                    ResultSet queryOutput = RadiologistStatement.executeQuery(GetRadiologistIDQuery);
                    ResultSet queryOutput2 = PatientStatement.executeQuery(GetPatientQuery);

                    while (queryOutput.next() && queryOutput2.next()){ 
                        
                    Integer radioID = queryOutput.getInt("id");
                    Integer patientID = queryOutput2.getInt("patient");  
                    Integer modality = queryOutput2.getInt("modality");

                    String InsertIntoUsersTableQuery = "insert into appointments (patient, order_id, modality, date_time, radiologist, phone_number, email_address) values ('" + patientID + "', '" + OrdersChoiceBox.getValue() + "', '" + modality + "', '"+ AppointmentDatePicker.getValue() + " " + SelectedAppointmentTime.getValue() + "', '" + radioID + "', '"+ phoneNumberField.getText() +"', '"+ emailAddressField.getText() +"')";
                    String GetAppointmentID = "select appointment_id from appointments where order_id = '" + OrdersChoiceBox.getValue() + "';";

                    Statement NewAppointmentStatemnet = connectDB.createStatement();
                    NewAppointmentStatemnet.execute(InsertIntoUsersTableQuery);

                    Statement AppointmentIDStatement = connectDB.createStatement();
                    ResultSet queryOutput3 = AppointmentIDStatement.executeQuery(GetAppointmentID);

                    while(queryOutput3.next()){

                        Integer appointmentID = queryOutput3.getInt("appointment_id");

                        String InsertAppointmentID = "update orders set appointment = '" + appointmentID + "' where order_id = '" + OrdersChoiceBox.getValue() + "';";

                        Statement InsertAppointmentIDStatement = connectDB.createStatement();
                        InsertAppointmentIDStatement.execute(InsertAppointmentID);
                    }
                    
                }

                    Stage stage = (Stage) SaveUserButton.getScene().getWindow();

                    stage.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));



                    FXApp.setRoot("ADMIN_AdminPanel");
                    
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
}); //Closes New Appointments











//Create New File Upload
NewFileUpload.setOnAction(new EventHandler<ActionEvent>() {

    String extension;
    String fileName;
   
    @Override
    public void handle(ActionEvent event) {
        BlurBox.setEffect(new BoxBlur(5, 10, 10));
         
           Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
       

        Label CreateFileLabel = new Label("Create New File Upload");
        CreateFileLabel.setLayoutX(46);
        CreateFileLabel.setLayoutY(47);
        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label UploadLabel = new Label("Upload:");
        UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        UploadLabel.setLayoutX(47);
        UploadLabel.setLayoutY(192);

        Label OrderLabel = new Label("Order:");
        OrderLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        OrderLabel.setLayoutX(459);
        OrderLabel.setLayoutY(192);
     

        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

        FileChooser fil_chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");

       
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
        
        
        ChoiceBox<String> OrdersChoiceBox = new ChoiceBox<String>();
        OrdersChoiceBox.setPrefHeight(30);
        OrdersChoiceBox.setPrefWidth(150);
        OrdersChoiceBox.setLayoutX(459);
        OrdersChoiceBox.setLayoutY(227);
  
        // Adds Orders to the Box
        try {
          DatabaseConnection connectNow = new DatabaseConnection();
          Connection connectDB = connectNow.getConnection();
  
          String GetChoiceBoxQuery = "Select * from orders";
          Statement statement = connectDB.createStatement();
          ResultSet OrdersOutput = statement.executeQuery(GetChoiceBoxQuery);
  
          while (OrdersOutput.next()) {
              Orders currentitterationpatient = new Orders(OrdersOutput.getInt("order_id"));
              OrdersChoiceBox.getItems().add(currentitterationpatient.getOrders().toString());
          }
  
      } catch (SQLException e1) {
  
          e1.printStackTrace();
      }




      Button UploadFileButton = new Button("Upload File");
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
    
           
                        String InsertIntoUploadsTable = "insert into file_uploads (order_id, file_name, file_type, is_active, upload_path)values ('"+ OrdersChoiceBox.getValue() + "', '"+ fileName + "', '"+ extension + "', true , '"+ label.getText() + "');";
                        Statement statement = connectDB.createStatement();

                        statement.execute(InsertIntoUploadsTable);
                        Stage stage = (Stage) UploadFileButton.getScene().getWindow();
    
                        stage.close();
                        BlurBox.setEffect(new BoxBlur(0, 0, 0));


                        FXApp.setRoot("ADMIN_AdminPanel");

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
                anchorpane.getChildren().add(OrderLabel);
                anchorpane.getChildren().add(horizontalline);
                anchorpane.getChildren().add(OrdersChoiceBox);
                anchorpane.getChildren().add(button);
                anchorpane.getChildren().add(label);
                anchorpane.getChildren().add(CancelButton);
                anchorpane.getChildren().add(UploadFileButton);

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
});// CLOSES NEW File Upload






//Creates New Diagnostic Report
NewDiagnosticReport.setOnAction(new EventHandler<ActionEvent>() {

    
   
    @Override
    public void handle(ActionEvent event) {
        BlurBox.setEffect(new BoxBlur(5, 10, 10));

         
           Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
      

        Label CreateFileLabel = new Label("Create New Diagnostic Report");
        CreateFileLabel.setLayoutX(46);
        CreateFileLabel.setLayoutY(47);
        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label UploadLabel = new Label("Radiologist:");
        UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        UploadLabel.setLayoutX(47);
        UploadLabel.setLayoutY(192);

        Label OrderLabel = new Label("Order:");
        OrderLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        OrderLabel.setLayoutX(247);
        OrderLabel.setLayoutY(192);

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

        ChoiceBox<String> RadiologistChoiceBox = new ChoiceBox<String>();
        RadiologistChoiceBox.setPrefHeight(30);
        RadiologistChoiceBox.setPrefWidth(150);
        RadiologistChoiceBox.setLayoutX(47);
        RadiologistChoiceBox.setLayoutY(227);
  
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
        



        ChoiceBox<String> OrdersChoiceBox = new ChoiceBox<String>();
        OrdersChoiceBox.setPrefHeight(30);
        OrdersChoiceBox.setPrefWidth(150);
        OrdersChoiceBox.setLayoutX(247);
        OrdersChoiceBox.setLayoutY(227);
  
        // Adds Orders to the Box
        try {
          DatabaseConnection connectNow = new DatabaseConnection();
          Connection connectDB = connectNow.getConnection();
  
          String GetChoiceBoxQuery = "Select * from orders";
          Statement statement = connectDB.createStatement();
          ResultSet OrdersOutput = statement.executeQuery(GetChoiceBoxQuery);
  
          while (OrdersOutput.next()) {
              Orders currentitterationpatient = new Orders(OrdersOutput.getInt("order_id"));
              OrdersChoiceBox.getItems().add(currentitterationpatient.getOrders().toString());
          }
  
      } catch (SQLException e1) {
  
          e1.printStackTrace();
      }



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

       

            String RadiologistQuery = "Select id from radiologists where full_name = '"+ RadiologistChoiceBox.getValue() + "'";
            Statement statement2 = connectDB.createStatement();
            ResultSet RadiologistsID = statement2.executeQuery(RadiologistQuery);

         
                   


             while (RadiologistsID.next()) {
                Integer  RadiologistID = RadiologistsID.getInt("id");

                String InsertIntoUsersTableQuery = "insert into diagnostic_reports (order_id,  radiologist, diagnostic) values ('"+ OrdersChoiceBox.getValue() + "', '" + RadiologistID + "', '"+ ReportArea.getText() + "');";
                Statement statement = connectDB.createStatement();
                statement.execute(InsertIntoUsersTableQuery);
                Stage stage = (Stage) CreateDiagnosticReportButton.getScene().getWindow();
    
                stage.close();
                BlurBox.setEffect(new BoxBlur(0, 0, 0));

                FXApp.setRoot("ADMIN_AdminPanel");

          }



          

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
                anchorpane.getChildren().add(UploadLabel);
                anchorpane.getChildren().add(OrderLabel);
                anchorpane.getChildren().add(horizontalline);
                anchorpane.getChildren().add(OrdersChoiceBox);
                anchorpane.getChildren().add(RadiologistChoiceBox);
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
























































        // CREATES NEW USER
        NewUserButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BlurBox.setEffect(new BoxBlur(5, 10, 10));

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
             
                horizontalline.setOpacity(.3);

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

                Label UserPassword = new Label("Password:");
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
                                    } else if (UserRole.getValue().equals("TECHNICIAN")) {
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
                            BlurBox.setEffect(new BoxBlur(0, 0, 0));
                            stage.close();
                            

                            FXApp.setRoot("ADMIN_AdminPanel");
                            
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
                            BlurBox.setEffect(new BoxBlur(0, 0, 0));

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
                BlurBox.setEffect(new BoxBlur(5, 10, 10));

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
                horizontalline.setOpacity(.3);
                

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
                            BlurBox.setEffect(new BoxBlur(0, 0, 0));


                            FXApp.setRoot("ADMIN_AdminPanel");

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
        });// CLOSES NEW ORDER





        // CREATES NEW PATIENT AND WINDOW
        NewPatient.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BlurBox.setEffect(new BoxBlur(5, 10, 10));

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
                horizontalline.setOpacity(.3);

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
                            FXApp.setRoot("ADMIN_AdminPanel");                         
                               BlurBox.setEffect(new BoxBlur(0, 0, 0));

                        } catch (SQLException | IOException e1) {

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
                Button button = new Button("Select");

                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");
    
//Modifys Selected Modality
            button.setOnAction(new EventHandler<ActionEvent>() {
    
                @Override
                public void handle(ActionEvent event) {
                    BlurBox.setEffect(new BoxBlur(5, 10, 10));

        Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
       

        Label CreateNewModalityLabel = new Label("Update Modality");
        CreateNewModalityLabel.setLayoutX(46);
        CreateNewModalityLabel.setLayoutY(47);
        CreateNewModalityLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label ModalityName = new Label("Modality Name:");
        ModalityName.setStyle("-fx-font: normal bold 16px 'arial';");
        ModalityName.setLayoutX(47);
        ModalityName.setLayoutY(192);

        Label modalityPriceLabel = new Label("Modality Price:");
        modalityPriceLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        modalityPriceLabel.setLayoutX(350);
        modalityPriceLabel.setLayoutY(192);
     

        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

  
    
        TextField ModalityNameTextField = new TextField();
        ModalityNameTextField.setMinHeight(35);
        ModalityNameTextField.setMinWidth(145);
        ModalityNameTextField.setLayoutX(47);
        ModalityNameTextField.setLayoutY(227);
        ModalityNameTextField.setText(modalitynamequery);



       
        
        
        
        TextField ModalityPriceTextField = new TextField();
        ModalityPriceTextField.setMinHeight(35);
        ModalityPriceTextField.setMinWidth(145);
        ModalityPriceTextField.setLayoutX(350);
        ModalityPriceTextField.setLayoutY(227);
        ModalityPriceTextField.setText(modalitypricequery);
     




      Button CreateNewModalityButton = new Button("Save");
        CreateNewModalityButton.setPrefHeight(42);
        CreateNewModalityButton.setPrefWidth(102);
        CreateNewModalityButton.setLayoutX(565);
        CreateNewModalityButton.setLayoutY(338);
        CreateNewModalityButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        CreateNewModalityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
  
                try {
                   
                   
                    String InstertIntoModalitiesTable = "update modalities set name = '" + ModalityNameTextField.getText() + "', price = '" + ModalityPriceTextField.getText() + "' where modality_id = '" + modalityidquery + "';";

                    Statement statement = connectDB.createStatement();
                    statement.execute(InstertIntoModalitiesTable);

                  


                    Stage stage = (Stage) CreateNewModalityButton.getScene().getWindow();
                    stage.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                    FXApp.setRoot("ADMIN_AdminPanel");
                    
                } catch (SQLException e1) {

                    e1.printStackTrace();
          
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
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

                anchorpane.getChildren().add(CreateNewModalityLabel);
                anchorpane.getChildren().add(ModalityName);
                anchorpane.getChildren().add(modalityPriceLabel);
                anchorpane.getChildren().add(horizontalline);
                anchorpane.getChildren().add(ModalityPriceTextField);
      
                anchorpane.getChildren().add(ModalityNameTextField);
                anchorpane.getChildren().add(CancelButton);
                anchorpane.getChildren().add(CreateNewModalityButton);

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
// Closes Modify Modality

























                    
                }
                
            });


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



// Modalities Search Bar Functionality Start
FilteredList<TABLEModalitiesTableController> ModalitiesFilteredData = new FilteredList<>(
    ModalitiesTableObservableList);

    searchModalities.textProperty().addListener((observable, oldValue, newValue) -> {
            ModalitiesFilteredData.setPredicate(TABLEModalitiesTableController -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (TABLEModalitiesTableController.getModalityname().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;

                } else if (TABLEModalitiesTableController.getModalityprice().toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                    return true;

                }  else {
                    return false; 
                }

            });

            });

            SortedList<TABLEModalitiesTableController> ModalitiesTableSortedData = new SortedList<>(
                ModalitiesFilteredData);

            // Binds the sorted resultswith the Table
            ModalitiesTableSortedData.comparatorProperty().bind(ModalitiesTable.comparatorProperty());

            ModalitiesTable.setItems(ModalitiesTableSortedData);
//Modalities Search Bar Functionality End


        } catch (Exception e) {
            System.out.println("error in modalities");
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
                Button button = new Button("Select");

                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");
    
          
//Modifies Selected Patient Alert
button.setOnAction(new EventHandler<ActionEvent>() {

   
    @Override
    public void handle(ActionEvent event) {
        BlurBox.setEffect(new BoxBlur(5, 10, 10));

         
        Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
       

        Label CreateNewPatientAlertLabel = new Label("Update Patient Alert");
        CreateNewPatientAlertLabel.setLayoutX(46);
        CreateNewPatientAlertLabel.setLayoutY(47);
        CreateNewPatientAlertLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label ModalityName = new Label("Patient Alert Name:");
        ModalityName.setStyle("-fx-font: normal bold 16px 'arial';");
        ModalityName.setLayoutX(47);
        ModalityName.setLayoutY(192);



        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

  
    
        TextField PatientAlertNameField = new TextField();
        PatientAlertNameField.setMinHeight(35);
        PatientAlertNameField.setMinWidth(145);
        PatientAlertNameField.setLayoutX(47);
        PatientAlertNameField.setLayoutY(227);
        PatientAlertNameField.setText(alertnamequery);



       
        
        
     




      Button CreateNewModalityButton = new Button("Save");
        CreateNewModalityButton.setPrefHeight(42);
        CreateNewModalityButton.setPrefWidth(102);
        CreateNewModalityButton.setLayoutX(565);
        CreateNewModalityButton.setLayoutY(338);
        CreateNewModalityButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        CreateNewModalityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
  
           

                try {
                    String InsertIntoAlerts = "update alerts set alert_name = '" + PatientAlertNameField.getText() + "' where alert_id = '"+ alertidquery+"';";
                    Statement statement = connectDB.createStatement();
                    statement.execute(InsertIntoAlerts);

                    Stage stage = (Stage) CreateNewModalityButton.getScene().getWindow();
                    stage.close();
                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                    FXApp.setRoot("ADMIN_AdminPanel");
                    
                } catch (SQLException e1) {

                    e1.printStackTrace();
          
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
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

                anchorpane.getChildren().add(CreateNewPatientAlertLabel);
                anchorpane.getChildren().add(ModalityName);
               
                anchorpane.getChildren().add(horizontalline);
             
                anchorpane.getChildren().add(CancelButton);
                anchorpane.getChildren().add(CreateNewModalityButton);
                anchorpane.getChildren().add(PatientAlertNameField);

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
});// Closes Modified Patient Alert


                AlertsTableObservableList.add(

                        new TABLEPatientAlertsTableController(alertidquery, alertnamequery, button));
            }

            PatientAlertsIDColulm.setCellValueFactory(new PropertyValueFactory<>("Alertid"));
            PatientsAlertsColumn.setCellValueFactory(new PropertyValueFactory<>("Alertname"));
            PatientAlertsModifyColumn.setCellValueFactory(new PropertyValueFactory<>("Button"));

            PatientAlertsTable.setItems(null);
            PatientAlertsTable.setItems(AlertsTableObservableList);

//  Search Bar Functionality Start
FilteredList<TABLEPatientAlertsTableController> PatientsAlertsFilteredData = new FilteredList<>(
    AlertsTableObservableList);

    searchPatientAlerts.textProperty().addListener((observable, oldValue, newValue) -> {
        PatientsAlertsFilteredData.setPredicate(TABLEPatientAlertsTableController -> {
        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
            return true;
        }

        String searchKeyword = newValue.toLowerCase();

        if (TABLEPatientAlertsTableController.getAlertname().toLowerCase().indexOf(searchKeyword) > -1) {
                return true;
        }
          else {
            return false; // no match found
        }

    });

});

SortedList<TABLEPatientAlertsTableController> PatientsAlertsSortedData = new SortedList<>(PatientsAlertsFilteredData);

// Binds the sorted resultswith the Table
PatientsAlertsSortedData.comparatorProperty().bind(PatientAlertsTable.comparatorProperty());

PatientAlertsTable.setItems(PatientsAlertsSortedData);
// Search Bar Functionality End


        } catch (Exception e) {
            System.out.println("error in patient alerts");
            e.printStackTrace();
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
                String Ethnicityquery = queryOutput.getString("Ethnicity");
                String Sexquery  = queryOutput.getString("Sex");
                String Racequery = queryOutput.getString("Race");
                Button button = new Button("Select");

                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");
    
                    //Starts Modify Patient Button
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
            
                            Label PatientOverviewLabe = new Label("Change Order");
                            PatientOverviewLabe.setStyle("-fx-font: normal bold 32px 'arial';");
                            PatientOverviewLabe.setLayoutX(25);
                            PatientOverviewLabe.setLayoutY(27);
                            PatientOverviewLabe.setMinHeight(55);
                            PatientOverviewLabe.setMinWidth(281);
                            Line horizontalline = new Line(-100.0f, 0.0f, 700.0f, 0.0f);
                            horizontalline.setTranslateX(100);
                            horizontalline.setTranslateY(110);
                            horizontalline.setOpacity(.3);
            
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
            
                            TextField lastNamefield = new TextField();
                            lastNamefield.setMinHeight(35);
                            lastNamefield.setMinWidth(210);
                            lastNamefield.setLayoutX(287);
                            lastNamefield.setLayoutY(43);
                            lastNamefield.setText(lastnamequery);
            
                            DatePicker dateofbirth = new DatePicker();
                            dateofbirth.setMinHeight(35);
                            dateofbirth.setMinWidth(210);
                            dateofbirth.setLayoutX(543);
                            dateofbirth.setLayoutY(43);
                            dateofbirth.setValue(dobquery.toLocalDate());
            
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
                            Ethnicity.setText(Ethnicityquery);
            
                            ChoiceBox<String> sexChange = new ChoiceBox<String>();
                            sexChange.setPrefHeight(35);
                            sexChange.setPrefWidth(128);
                            sexChange.setLayoutX(35);
                            sexChange.setLayoutY(43);
                            sexChange.setValue(Sexquery);
            
                            sexChange.getItems().add("Male");
                            sexChange.getItems().add("Female");
                            sexChange.getItems().add("Other");
            
                            ChoiceBox<String> RaceChange = new ChoiceBox<String>();
                            RaceChange.setPrefHeight(35);
                            RaceChange.setPrefWidth(259);
                            RaceChange.setLayoutX(196);
                            RaceChange.setLayoutY(43);
                            RaceChange.setValue(Racequery);
            
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
                            EthnicityChange.setValue(Ethnicityquery);
            
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
            
                            Button SaveModifiedPatient = new Button("Save");
                            SaveModifiedPatient.setPrefHeight(42);
                            SaveModifiedPatient.setPrefWidth(102);
                            SaveModifiedPatient.setLayoutX(509);
                            SaveModifiedPatient.setLayoutY(147);
                            SaveModifiedPatient.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");
            
                            SaveModifiedPatient.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent e) {
            
                                    try {
                                        DatabaseConnection connectNow = new DatabaseConnection();
                                        Connection connectDB = connectNow.getConnection();

                                        String PlacedOrdersTableQuery = "update patients set first_name = '" + firstNameField.getText() + "', last_name = '" + lastNamefield.getText() + "', dob = '" + dateofbirth.getValue() + "', sex = '" + sexChange.getValue() + "', race = '" + RaceChange.getValue() + "', ethnicity = '" + EthnicityChange.getValue() + "' where patient_id = '" + patient_id + "';";
        
                                        Statement statement = connectDB.createStatement();
                                        statement.execute(PlacedOrdersTableQuery);

                                        Stage stage = (Stage) SaveModifiedPatient.getScene().getWindow();
                                        stage.close();
                                        FXApp.setRoot("ADMIN_AdminPanel");
                                        BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                        
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
            
                            BottomPane.getChildren().add(SaveModifiedPatient);
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
                    });// CLOSES Modify Patient 

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

//  Search Bar Functionality Start
FilteredList<TABLEPatientsTableController> PatientsFilteredData = new FilteredList<>(
    PatientsTableObservableList);

    searchPatients.textProperty().addListener((observable, oldValue, newValue) -> {
            PatientsFilteredData.setPredicate(TABLEPatientsTableController -> {
        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
            return true;
        }

        String searchKeyword = newValue.toLowerCase();

        if (TABLEPatientsTableController.getFirstname().toLowerCase().indexOf(searchKeyword) > -1) {
                return true;

        } else if (TABLEPatientsTableController.getLastname().toLowerCase().indexOf(searchKeyword) > -1) {
                return true;
        }

          else {
            return false; // no match found
        }

    });

});

SortedList<TABLEPatientsTableController> PatientsSortedData = new SortedList<>(PatientsFilteredData);

// Binds the sorted resultswith the Table
PatientsSortedData.comparatorProperty().bind(PatientsTable.comparatorProperty());

PatientsTable.setItems(PatientsSortedData);
// Search Bar Functionality End


        } catch (Exception e) {
            System.out.println("error om patients");
        }





















        /*
         *
         * File Uploads
         * 
         */

        String FileUploadsTableQuery = "select * from file_uploads;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(FileUploadsTableQuery);

            while (queryOutput.next()) {

                Integer uploadidquery = queryOutput.getInt("file_upload_id");
                String filenamequery = queryOutput.getString("file_name");
                String filetypequery = queryOutput.getString("file_type");
                Integer ordernumberquery = queryOutput.getInt("order_id");
                Boolean isopenquery = queryOutput.getBoolean("is_active");
                String file_path = queryOutput.getString("upload_path");
                Button button = new Button("Select");

                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");


//Modify File Upload
button.setOnAction(new EventHandler<ActionEvent>() {

    String extension;
    String fileName;
   
    @Override
    public void handle(ActionEvent event) {

        BlurBox.setEffect(new BoxBlur(5, 10, 10));

        Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
      

        Label CreateFileLabel = new Label("Change File");
        CreateFileLabel.setLayoutX(46);
        CreateFileLabel.setLayoutY(47);
        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label UploadLabel = new Label("Upload:");
        UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        UploadLabel.setLayoutX(47);
        UploadLabel.setLayoutY(192);

        Label OrderLabel = new Label("Order:");
        OrderLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        OrderLabel.setLayoutX(459);
        OrderLabel.setLayoutY(192);
     

        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

        FileChooser fil_chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");

       
        fil_chooser.getExtensionFilters().add(extFilter);

       
     
        Label label = new Label("No file chosen");
        label.setPrefHeight(30);
        label.setPrefWidth(340);
        label.setLayoutX(127);
        label.setLayoutY(227);
        label.setText(file_path);
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
        
        
        ChoiceBox<String> OrdersChoiceBox = new ChoiceBox<String>();
        OrdersChoiceBox.setPrefHeight(30);
        OrdersChoiceBox.setPrefWidth(150);
        OrdersChoiceBox.setLayoutX(459);
        OrdersChoiceBox.setLayoutY(227);
        OrdersChoiceBox.setValue(ordernumberquery.toString());
  
        // Adds Orders to the Box
        try {
          DatabaseConnection connectNow = new DatabaseConnection();
          Connection connectDB = connectNow.getConnection();
  
          String GetChoiceBoxQuery = "Select * from orders";
          Statement statement = connectDB.createStatement();
          ResultSet OrdersOutput = statement.executeQuery(GetChoiceBoxQuery);
  
          while (OrdersOutput.next()) {
              Orders currentitterationpatient = new Orders(OrdersOutput.getInt("order_id"));
              OrdersChoiceBox.getItems().add(currentitterationpatient.getOrders().toString());
          }
  
      } catch (SQLException e1) {
  
          e1.printStackTrace();
      }




      Button FileModifyButton = new Button("Save");
        FileModifyButton.setPrefHeight(42);
        FileModifyButton.setPrefWidth(102);
        FileModifyButton.setLayoutX(565);
        FileModifyButton.setLayoutY(338);
        FileModifyButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        FileModifyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
  
                




                try {
                    DatabaseConnection connectNow = new DatabaseConnection();
                    Connection connectDB = connectNow.getConnection();
        
                    int index =  label.getText().lastIndexOf('.');
                 
                    if(index > 0) {
                      extension  = label.getText().substring(index + 1);
                
                    } 
                    if(index > 0) {
                   
                        java.nio.file.Path path = Paths.get(label.getText());         
                       fileName = path.getFileName().toString();
                    }


        
                        String InsertIntoFileUploadQuery = "update file_uploads set order_id = '" + OrdersChoiceBox.getValue() + "', file_name = '" + fileName + "', file_type = '"+ extension + "', is_active = " +"true" + ", upload_path = '" + label.getText() + "' where file_upload_id = '" + uploadidquery + "';";
                        Statement statement = connectDB.createStatement();
                        statement.execute(InsertIntoFileUploadQuery);
                        Stage stage = (Stage) FileModifyButton.getScene().getWindow();
            
                        stage.close();
                        BlurBox.setEffect(new BoxBlur(0, 0, 0));

                        FXApp.setRoot("ADMIN_AdminPanel");
        
                  
        
        
        
                  
        
                }
                catch (SQLException e2){
        
                    e2.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
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
                anchorpane.getChildren().add(UploadLabel);
                anchorpane.getChildren().add(OrderLabel);
                anchorpane.getChildren().add(horizontalline);
                anchorpane.getChildren().add(OrdersChoiceBox);
                anchorpane.getChildren().add(button);
                anchorpane.getChildren().add(label);
                anchorpane.getChildren().add(CancelButton);
                anchorpane.getChildren().add(FileModifyButton);

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
});// CLOSES EDIT FILE UPLOAD

                FileUploadsObservableList.add(

                        new TABLEFileUploadsTableController(uploadidquery, filenamequery, filetypequery, ordernumberquery, isopenquery, button));
            }

            FilesUploadsID.setCellValueFactory(new PropertyValueFactory<>("uploadid"));
            FileUploadsName.setCellValueFactory(new PropertyValueFactory<>("filename"));
            FileUploadsType.setCellValueFactory(new PropertyValueFactory<>("filetype"));
            FileUploadsOrderNumber.setCellValueFactory(new PropertyValueFactory<>("ordernumber"));
            FileUploadsOpenNewWindow.setCellValueFactory(new PropertyValueFactory<>("isopen"));
            FileUploadsModify.setCellValueFactory(new PropertyValueFactory<>("button"));

            FileUploadsTable.setItems(null);
            FileUploadsTable.setItems(FileUploadsObservableList);

            // Search Bar Functionality Start
FilteredList<TABLEFileUploadsTableController> FileUploadsFilteredData = new FilteredList<>(
    FileUploadsObservableList);

    searchFileUploads.textProperty().addListener((observable, oldValue, newValue) -> {
        FileUploadsFilteredData.setPredicate(TABLEFileUploadsTableController -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (TABLEFileUploadsTableController.getFilename().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;

                } else if (TABLEFileUploadsTableController.getFiletype().toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                    return true;

                }  else {
                    return false; 
                }

            });

            });

            SortedList<TABLEFileUploadsTableController> FileUploadsSortedData = new SortedList<>(
                FileUploadsFilteredData);

            // Binds the sorted resultswith the Table
            FileUploadsSortedData.comparatorProperty().bind(FileUploadsTable.comparatorProperty());

            FileUploadsTable.setItems(FileUploadsSortedData);
// Search Bar Functionality End

        } catch (Exception e) {
            System.out.println("error");
        }



/*
     *
     * Populates Orders
     * 
     */ 

    String OrdersTableQuery = "select o.order_id, p.first_name, p.last_name, rmd.full_name, m.name, o.notes, os.order_name from orders as o join patients as p on p.patient_id = o.patient join referralmds as rmd on rmd.id = o.referral_md join modalities as m on m.modality_id = o.modality join order_status as os on os.order_status_id = o.status;";

    try {

        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(OrdersTableQuery);

        while (queryOutput.next()) {
        
            Integer order_id = queryOutput.getInt("order_id");
            String firstnamequery = queryOutput.getString("first_name");
            String lastnamequery = queryOutput.getString("last_name");
            String fullname = firstnamequery + " " + lastnamequery;
            String referral_mdquery = queryOutput.getString("full_name");
            String modalityquery = queryOutput.getString("name");
            String notesquery = queryOutput.getString("notes");
            String statusquery = queryOutput.getString("order_name");
            Button  button = new Button("Select");


            button.setStyle(
                "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

       // Modifies Selected Order
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

            Label PatientOverviewLabe = new Label("Change Order");
            PatientOverviewLabe.setStyle("-fx-font: normal bold 32px 'arial';");
            PatientOverviewLabe.setLayoutX(25);
            PatientOverviewLabe.setLayoutY(27);
            PatientOverviewLabe.setMinHeight(55);
            PatientOverviewLabe.setMinWidth(281);

            Line horizontalline = new Line(-100.0f, 0.0f, 700.0f, 0.0f);
            horizontalline.setTranslateX(100);
            horizontalline.setTranslateY(110);
            horizontalline.setOpacity(.3);
            

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
            SelectedPatientField.setValue(fullname);

            ChoiceBox<String> SelectedDoctorField = new ChoiceBox<String>();
            SelectedDoctorField.setStyle("-fx-font: normal bold 16px 'arial';");
            SelectedDoctorField.setMinHeight(35);
            SelectedDoctorField.setMaxWidth(210);
            SelectedDoctorField.setLayoutX(287);
            SelectedDoctorField.setLayoutY(43);
            SelectedDoctorField.setPrefWidth(210);
            SelectedDoctorField.setValue(referral_mdquery);

            ChoiceBox<String> SelectedStatusField = new ChoiceBox<String>();
            SelectedStatusField.setStyle("-fx-font: normal bold 16px 'arial';");
            SelectedStatusField.setMinHeight(35);
            SelectedStatusField.setMaxWidth(210);
            SelectedStatusField.setLayoutX(543);
            SelectedStatusField.setLayoutY(43);
            SelectedStatusField.setPrefHeight(210);
            SelectedStatusField.setMaxHeight(35);
            SelectedStatusField.setPrefWidth(210);
            SelectedStatusField.setValue(statusquery);

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
            ModalityChoiceBox.setValue(modalityquery);
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
            ReferralTextField.setText(notesquery);

            RolePane.getChildren().add(ModalityLabel);
            RolePane.getChildren().add(ModalityChoiceBox);
            RolePane.getChildren().add(ReferralTextField);
            RolePane.getChildren().add(RefNotes);

            Pane BottomPane = new Pane();
            BottomPane.setPrefHeight(223);
            NamesPane.setPrefWidth(800);

            Button CreateOrderButton = new Button("Save");
            CreateOrderButton.setPrefHeight(42);
            CreateOrderButton.setPrefWidth(102);
            CreateOrderButton.setLayoutX(509);
            CreateOrderButton.setLayoutY(147);
            CreateOrderButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

            CreateOrderButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    try{

                            String[] firstandlastnames = SelectedPatientField.getValue().toString().split(" ", 2);
                            String GetReferralID = "select id from referralmds where full_name = '" + SelectedDoctorField.getValue() + "';";
                            String GetModalityID = "select modality_id from modalities where name = '" + ModalityChoiceBox.getValue() + "';";
                            String GetStatusID = "select order_status_id from order_status where order_name = '" + SelectedStatusField.getValue() + "';";

                            String InsertQueries = "Select patient_id from patients where first_name = '"
                                    + firstandlastnames[0] + "' and last_name = '" + firstandlastnames[1] + "'";

                            Statement statement = connectDB.createStatement();
                            Statement statement2 = connectDB.createStatement();
                            Statement statement3 = connectDB.createStatement();
                            Statement statement4 = connectDB.createStatement();

                            ResultSet PatientIDOutput = statement.executeQuery(InsertQueries);
                            ResultSet ReferralIDOutput = statement2.executeQuery(GetReferralID);
                            ResultSet ModalityIDOutput = statement3.executeQuery(GetModalityID);
                            ResultSet StatusIDOutput = statement4.executeQuery(GetStatusID);

                            while (PatientIDOutput.next() && ReferralIDOutput.next() && ModalityIDOutput.next() && StatusIDOutput.next()) {
                                 Integer patient_id = PatientIDOutput.getInt("patient_id");
                                Integer modality_id = ModalityIDOutput.getInt("modality_id");
                                Integer referral_id = ReferralIDOutput.getInt("id");
                                Integer status_id = StatusIDOutput.getInt("order_status_id");

                                String UpdateOrdersQuery = "update orders set patient = '" + patient_id + "', referral_md = '" + referral_id + "', modality = '" + modality_id + "', notes = '" + ReferralTextField.getText() + "', status = '" + status_id + "' where order_id = '" + order_id + "';";

                                Statement statement5 = connectDB.createStatement();
                                statement5.execute(UpdateOrdersQuery);

                                Stage stage = (Stage) CreateOrderButton.getScene().getWindow();
    
                                stage.close();
                                BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                FXApp.setRoot("ADMIN_AdminPanel");

                            }
                        


                    }catch(SQLException e1){

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
    });// CLOSES NEW ORDER










            OrdersTableObservableList.add(
                    
            new TABLEOrdersTableController(order_id, fullname, referral_mdquery, modalityquery, notesquery, statusquery, button)); 
        }

        OrdersIDColumn.setCellValueFactory(new PropertyValueFactory<>("orderid"));               
        OrdersPatientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patient"));
        OrdersReferralDoctorColumn.setCellValueFactory(new PropertyValueFactory<>("referraldoctor"));       
        OrdersModalityColumn.setCellValueFactory(new PropertyValueFactory<>("modality"));
        OrdersNotesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        OrdersStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));           
        OrdersModifyColumn.setCellValueFactory(new PropertyValueFactory<>("button"));
                
        OrdersTable.setItems(null);
        OrdersTable.setItems(OrdersTableObservableList);

        // Search Bar Functionality Start
FilteredList<TABLEOrdersTableController> OrdersFilteredData = new FilteredList<>(
    OrdersTableObservableList);

    searchOrders.textProperty().addListener((observable, oldValue, newValue) -> {
        OrdersFilteredData.setPredicate(TABLEOrdersTableController -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (TABLEOrdersTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;

                } else if (TABLEOrdersTableController.getReferraldoctor().toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                    return true;

                }  

                  else if (TABLEOrdersTableController.getModality().toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                            return true;

                }
                  else if (TABLEOrdersTableController.getNotes().toLowerCase()
                .indexOf(searchKeyword) > -1) {
                return true;

                }
                else if (TABLEOrdersTableController.getStatus().toLowerCase()
                .indexOf(searchKeyword) > -1) {
                return true;
                }
                else {
                    return false; 
                }

            });

            });

            SortedList<TABLEOrdersTableController> OrdersSortedData = new SortedList<>(
                OrdersFilteredData);

            // Binds the sorted resultswith the Table
            OrdersSortedData.comparatorProperty().bind(OrdersTable.comparatorProperty());

            OrdersTable.setItems(OrdersSortedData);
// Search Bar Functionality End

    } catch (Exception e) {
        System.out.println("error");
    }

/*
     *
     * Appointments Populated
     * 
     */ 

    String AppointmentsTableQuery = "select a.appointment_id, p.first_name, p.last_name, a.order_id, a.date_time, r.full_name, a.phone_number, a.email_address, a.modality  from appointments as a join patients as p on p.patient_id = a.patient join radiologists as r on r.id = a.radiologist;";

    try {

        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(AppointmentsTableQuery);

        while (queryOutput.next()) {
        
            Integer appointmentIdquery = queryOutput.getInt("appointment_id");
            String patientquery = queryOutput.getString("first_name")+ " " + queryOutput.getString("last_name");
            Integer ordernumberquery = queryOutput.getInt("order_id");
            java.sql.Date datetimequery = queryOutput.getDate("date_time");
            Time datetimequeryTIME = queryOutput.getTime("date_time");



            String radiologistquery = queryOutput.getString("full_name");
            String phoneNumbeQuery = queryOutput.getString("phone_number");
            String email_addressQuery = queryOutput.getString("email_address");
            Button  button = new Button("Select");
            String modalityquery = queryOutput.getString("modality");

            button.setStyle(
                "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

        
 // Modifies Selected Appointment
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

        Label CreateNewAppointmentsLabel = new Label("Change Appointment");
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
      
        phoneNumberField.setText(phoneNumbeQuery);

        TextField emailAddressField = new TextField();
        emailAddressField.setMinHeight(35);
        emailAddressField.setMinWidth(145);
        emailAddressField.setLayoutX(209);
        emailAddressField.setLayoutY(160);
   
        emailAddressField.setText(email_addressQuery);

        DatePicker AppointmentDatePicker = new DatePicker();
        AppointmentDatePicker.setMinHeight(35);
        AppointmentDatePicker.setMinWidth(166);
        AppointmentDatePicker.setLayoutX(396);
        AppointmentDatePicker.setLayoutY(160);
        AppointmentDatePicker.setValue(datetimequery.toLocalDate());


        ChoiceBox<String> SelectedAppointmentTime = new ChoiceBox<String>();
        SelectedAppointmentTime.setStyle("-fx-font: normal bold 16px 'arial';");
        SelectedAppointmentTime.setMinHeight(35);
        SelectedAppointmentTime.setMaxWidth(170);
        SelectedAppointmentTime.setLayoutX(599);
        SelectedAppointmentTime.setLayoutY(160);
        SelectedAppointmentTime.setPrefHeight(210);
        SelectedAppointmentTime.setMaxHeight(35);
        SelectedAppointmentTime.setPrefWidth(170);




      

   SelectedAppointmentTime.setValue(datetimequeryTIME.toString());





        SelectedAppointmentTime.getItems().add("01:00:00");
        SelectedAppointmentTime.getItems().add("02:00:00");
        SelectedAppointmentTime.getItems().add("03:00:00");
        SelectedAppointmentTime.getItems().add("04:00:00");
        SelectedAppointmentTime.getItems().add("05:00:00");
        SelectedAppointmentTime.getItems().add("06:00:00");
        SelectedAppointmentTime.getItems().add("07:00:00");
        SelectedAppointmentTime.getItems().add("08:00:00");
        SelectedAppointmentTime.getItems().add("09:00:00");
        SelectedAppointmentTime.getItems().add("10:00:00");
        SelectedAppointmentTime.getItems().add("11:00:00");
        SelectedAppointmentTime.getItems().add("12:00:00");
        SelectedAppointmentTime.getItems().add("13:00:00");
        SelectedAppointmentTime.getItems().add("14:00:00");
        SelectedAppointmentTime.getItems().add("15:00:00");
        SelectedAppointmentTime.getItems().add("16:00:00");
        SelectedAppointmentTime.getItems().add("17:00:00");
        SelectedAppointmentTime.getItems().add("18:00:00");
        SelectedAppointmentTime.getItems().add("19:00:00");
        SelectedAppointmentTime.getItems().add("20:00:00");
        SelectedAppointmentTime.getItems().add("21:00:00");
        SelectedAppointmentTime.getItems().add("22:00:00");
        SelectedAppointmentTime.getItems().add("23:00:00");
        SelectedAppointmentTime.getItems().add("24:00:00");




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
     


      TextField patientfortheorder = new TextField();
      patientfortheorder.setPrefHeight(35);
      patientfortheorder.setPrefWidth(170);
      patientfortheorder.setLayoutX(260);
      patientfortheorder.setLayoutY(270);
      patientfortheorder.setEditable(false);
      patientfortheorder.setText(patientquery);

  

        
       
        


      ChoiceBox<String> OrdersChoiceBox = new ChoiceBox<String>();
      OrdersChoiceBox.setPrefHeight(35);
      OrdersChoiceBox.setPrefWidth(170);
      OrdersChoiceBox.setLayoutX(22);
      OrdersChoiceBox.setLayoutY(160);
      OrdersChoiceBox.setValue(ordernumberquery.toString());

      // Adds Orders to the Box
      try {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String GetChoiceBoxQuery = "SELECT * FROM orders";
        Statement statement = connectDB.createStatement();
        ResultSet OrdersOutput = statement.executeQuery(GetChoiceBoxQuery);

        while (OrdersOutput.next()) {
            Orders currentitterationpatient = new Orders(OrdersOutput.getInt("order_id"));
            OrdersChoiceBox.getItems().add(currentitterationpatient.getOrders().toString());
        }

    } catch (SQLException e1) {

        e1.printStackTrace();
    }

      
      ChoiceBox<String> RadiologistChoiceBox = new ChoiceBox<String>();
      RadiologistChoiceBox.setPrefHeight(35);
      RadiologistChoiceBox.setPrefWidth(170);
      RadiologistChoiceBox.setLayoutX(522);
      RadiologistChoiceBox.setLayoutY(160);
      RadiologistChoiceBox.setValue(radiologistquery);

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



        OfficeInfoPane.getChildren().add(OrderLabel);
        OfficeInfoPane.getChildren().add(OfficeInfoLabel);
        OfficeInfoPane.getChildren().add(HorizontalLineOfficeIn);
        OfficeInfoPane.getChildren().add(ModalityLabel);
        OfficeInfoPane.getChildren().add(RadiologistLabel);
        OfficeInfoPane.getChildren().add(EstimatedCostsLabel);
        OfficeInfoPane.getChildren().add(OrdersChoiceBox);
        OfficeInfoPane.getChildren().add(RadiologistChoiceBox);
        OfficeInfoPane.getChildren().add(PatientLabel);
        OfficeInfoPane.getChildren().add(patientfortheorder);
        OfficeInfoPane.getChildren().add(EstinatedCosts);
        OfficeInfoPane.getChildren().add(ModalityField);
     
        Pane BottomPane = new Pane();
        BottomPane.setPrefHeight(70);
        BottomPane.setPrefWidth(800);

        Button SaveUserButton = new Button("Save");
        SaveUserButton.setPrefHeight(42);
        SaveUserButton.setPrefWidth(102);
        SaveUserButton.setLayoutX(472);
        SaveUserButton.setLayoutY(15);
        SaveUserButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

        SaveUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                try {
                    
                    String GetRadiologistIDQuery = "select id from radiologists where full_name = '" + RadiologistChoiceBox.getValue() + "';";
                    String GetOrderInfoQuery = "select patient, modality from orders where order_id = '" + OrdersChoiceBox.getValue() + "';";

                    Statement statement = connectDB.createStatement();
                    Statement statement2 = connectDB.createStatement();

                    ResultSet GetRadiologistID = statement.executeQuery(GetRadiologistIDQuery);
                    ResultSet GetOrderInfo = statement2.executeQuery(GetOrderInfoQuery);
                    while(GetRadiologistID.next() && GetOrderInfo.next()){

                        Integer radiologistID = GetRadiologistID.getInt("id");
                        Integer patientID = GetOrderInfo.getInt("patient");
                        Integer modalityID = GetOrderInfo.getInt("modality");

                        String UpdateAppointmentsQuery = "update appointments set phone_number = '" + phoneNumberField.getText() + "', email_address = '" + emailAddressField.getText() + "', date_time = '" + AppointmentDatePicker.getValue() + " " + SelectedAppointmentTime.getValue() + "', order_id = '" + OrdersChoiceBox.getValue() + "', radiologist = '" + radiologistID + "', patient = '" + patientID + "', modality = '" + modalityID + "' where appointment_id = '" + appointmentIdquery + "';";
                        String UpdateOrdersQuery = "update orders set appointment = '" + appointmentIdquery + "' where order_id = '" + OrdersChoiceBox.getValue() + "';";
                        String UpdateOrdersQuery2 = "update orders set appointment = null where order_id = '" + ordernumberquery + "';";

                        Statement statement3 = connectDB.createStatement();
                        Statement statement4 = connectDB.createStatement(); 
                        Statement statement5 = connectDB.createStatement();

                        statement3.execute(UpdateAppointmentsQuery);
                        statement4.execute(UpdateOrdersQuery);
                        statement5.execute(UpdateOrdersQuery2);

                        Stage stage = (Stage) SaveUserButton.getScene().getWindow();
    
                                stage.close();
                                BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                FXApp.setRoot("ADMIN_AdminPanel");

                    }

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
               
                  
                        Stage stage = (Stage) SaveUserButton.getScene().getWindow();
            
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
}); //Closes Modift Appointment





            AppointmentsTableObservableList.add(

            new TABLEAppointmentsTableController(appointmentIdquery, patientquery, ordernumberquery, datetimequery, radiologistquery, button)); 
        }

        AppointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));               
        AppintmentPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        AppopintmentsOrderNumber.setCellValueFactory(new PropertyValueFactory<>("ordernumber"));       
        AppointmentsDateandtime.setCellValueFactory(new PropertyValueFactory<>("datetime"));          
        AppointmentsRadiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));
        AppointmentsModify.setCellValueFactory(new PropertyValueFactory<>("button"));
    
        AppointmentsTable.setItems(null);
        AppointmentsTable.setItems(AppointmentsTableObservableList);


       // Search Bar Functionality Start
FilteredList<TABLEAppointmentsTableController> AppointmentsFilteredData = new FilteredList<>(
    AppointmentsTableObservableList);

    searchAppointments.textProperty().addListener((observable, oldValue, newValue) -> {
        AppointmentsFilteredData.setPredicate(TABLEAppointmentsTableController -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (TABLEAppointmentsTableController.getPatient().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;

                } else if (TABLEAppointmentsTableController.getRadiologist().toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                    return true;

                }  else {
                    return false; 
                }

            });

            });

            SortedList<TABLEAppointmentsTableController> AppointmentsTableSortedData = new SortedList<>(
                AppointmentsFilteredData);

            // Binds the sorted resultswith the Table
            AppointmentsTableSortedData.comparatorProperty().bind(AppointmentsTable.comparatorProperty());

            AppointmentsTable.setItems(AppointmentsTableSortedData);
// Search Bar Functionality End


    } catch (Exception e ) {
      e.printStackTrace();
    }










    
        // ALL USERES TABLE POPULATION



        String UsersTableQuery = "select u.user_id, u.full_name, u.username, u.email, ur.role_id, r.name, u.password from users as u left join users_roles as ur on ur.user_id = u.user_id left join roles as r on r.role_id = ur.role_id;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(UsersTableQuery);

            while (queryOutput.next()) {

                Integer userIDquery = queryOutput.getInt("user_id");
                String usernamequery = queryOutput.getString("username");
                String displaynamequery = queryOutput.getString("full_name");
                String emailquery = queryOutput.getString("email");
                String rolequery = queryOutput.getString("name");
                Button button = new Button("Select");
                String password = queryOutput.getString("password");
                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");
    
          


        // Modifies User
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

                Label PatientOverviewLabe = new Label("Change User");
                PatientOverviewLabe.setStyle("-fx-font: normal bold 32px 'arial';");
                PatientOverviewLabe.setLayoutX(25);
                PatientOverviewLabe.setLayoutY(27);
                PatientOverviewLabe.setMinHeight(55);
                PatientOverviewLabe.setMinWidth(281);

                Line horizontalline = new Line(-100.0f, 0.0f, 700.0f, 0.0f);
                horizontalline.setTranslateX(100);
                horizontalline.setTranslateY(110);
             
                horizontalline.setOpacity(.3);

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
                UsernameField.setText(usernamequery);

                TextField displayNameField = new TextField();
                displayNameField.setMinHeight(35);
                displayNameField.setMinWidth(210);
                displayNameField.setLayoutX(287);
                displayNameField.setLayoutY(43);
                displayNameField.setText(displaynamequery);

                TextField EmailAddressField = new TextField();
                EmailAddressField.setMinHeight(35);
                EmailAddressField.setMinWidth(210);
                EmailAddressField.setLayoutX(543);
                EmailAddressField.setLayoutY(43);
                EmailAddressField.setText(emailquery);

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
                UserRole.setValue(rolequery);
                UserRole.setDisable(true);

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
                PasswordField.setText(password);

                RolePane.getChildren().add(UserPassword);
                RolePane.getChildren().add(UserRole);
                RolePane.getChildren().add(PasswordField);
                RolePane.getChildren().add(UserRoleLabel);

                Pane BottomPane = new Pane();
                BottomPane.setPrefHeight(223);
                NamesPane.setPrefWidth(800);

                Button SaveUserButton = new Button("Save");
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
        
               
                        String InsertIntoUsersTableQuery = "update users set username = '" + UsernameField.getText() + "', full_name = '" + displayNameField.getText() + "', email = '" + EmailAddressField.getText() + "', password = '" + PasswordField.getText() + "' where user_id = '" + userIDquery + "';";
                        String UpdateRadiologistTableQuery = "update radiologists set full_name = '" + displayNameField.getText() + "' where user_id = '" + userIDquery + "';";
                        String UpdateRefferalmdTableQuery = "update referralmds  set full_name = '" + displayNameField.getText() + "' where user_id = '" + userIDquery + "';";



                        Statement statement = connectDB.createStatement();
                        statement.execute(InsertIntoUsersTableQuery);

                        Statement statement2 = connectDB.createStatement();
                        statement2.execute(UpdateRadiologistTableQuery);
                        
                        Statement statement3 = connectDB.createStatement();
                        statement3.execute(UpdateRefferalmdTableQuery);
                        
                        
                        Stage stage = (Stage) SaveUserButton.getScene().getWindow();
            
                        stage.close();
                        BlurBox.setEffect(new BoxBlur(0, 0, 0));

                        FXApp.setRoot("ADMIN_AdminPanel");
        
        
                }
                catch (SQLException e2){
        
                    e2.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
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
                            BlurBox.setEffect(new BoxBlur(0, 0, 0));
                        }
                    }
                });
                newWindow.show();
            }
        });// Closes Modify User




                
                UsersTableObservableList.add(

                        new TABLESystemUsersTableController(userIDquery, usernamequery, displaynamequery, emailquery,
                                rolequery, button));
            }

            Users_UserId.setCellValueFactory(new PropertyValueFactory<>("userid"));
            UsersUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
            UsersDisplayName.setCellValueFactory(new PropertyValueFactory<>("displayname"));
            UsersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            UsersRole.setCellValueFactory(new PropertyValueFactory<>("role"));
            UsersModifyButton.setCellValueFactory(new PropertyValueFactory<>("button"));

            SystemUsersTable.setItems(null);
            SystemUsersTable.setItems(UsersTableObservableList);



           //  Search Bar Functionality Start
            FilteredList<TABLESystemUsersTableController> SystemUsersFilteredData = new FilteredList<>(
                    UsersTableObservableList);

                    searchSystemUsers.textProperty().addListener((observable, oldValue, newValue) -> {
                SystemUsersFilteredData.setPredicate(TABLESystemUsersTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLESystemUsersTableController.getUsername().toLowerCase().indexOf(searchKeyword) > -1) {
                            return true;

                    } else if (TABLESystemUsersTableController.getDisplayname().toLowerCase().indexOf(searchKeyword) > -1) {
                            return true;

                    } else if (TABLESystemUsersTableController.getEmail().toLowerCase().indexOf(searchKeyword) > -1) {
                                return true;

                    } else if (TABLESystemUsersTableController.getRole().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    }

                      else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TABLESystemUsersTableController> SystemUsersSortedData = new SortedList<>(SystemUsersFilteredData);

            // Binds the sorted resultswith the Table
            SystemUsersSortedData.comparatorProperty().bind(SystemUsersTable.comparatorProperty());

            SystemUsersTable.setItems(SystemUsersSortedData);
            // Search Bar Functionality End



        } catch (Exception e) {
            System.out.println("error");
        }



         /*
         *
         * Diagnostic Reports
         * 
         */


        String DiagnosticReportsTableQuery = "select dr.diagnostic_report_id, r.full_name, dr.order_id, dr.diagnostic from diagnostic_reports as dr join radiologists as r on r.id = dr.radiologist;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(DiagnosticReportsTableQuery);

            while (queryOutput.next()) {

                Integer reportidquery = queryOutput.getInt("diagnostic_report_id");
                String radiologistquery = queryOutput.getString("full_name");
                Integer ordernumberquery = queryOutput.getInt("order_id");
                String reportquery = queryOutput.getString("diagnostic");
                Button button = new Button("Select");

                button.setStyle(
                    "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");
    
//Modift Diagnostic Report
button.setOnAction(new EventHandler<ActionEvent>() {

    
   
    @Override
    public void handle(ActionEvent event) {

        BlurBox.setEffect(new BoxBlur(5, 10, 10));

           Stage newWindow = new Stage();
     
        AnchorPane anchorpane = new AnchorPane();
   

        Label CreateFileLabel = new Label("Change Report");
        CreateFileLabel.setLayoutX(46);
        CreateFileLabel.setLayoutY(47);
        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");
        

        Label UploadLabel = new Label("Radiologist:");
        UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        UploadLabel.setLayoutX(47);
        UploadLabel.setLayoutY(192);

        Label OrderLabel = new Label("Order:");
        OrderLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        OrderLabel.setLayoutX(247);
        OrderLabel.setLayoutY(192);

        Label ReportLabel = new Label("Report:");
        ReportLabel.setStyle("-fx-font: normal bold 16px 'arial';");
        ReportLabel.setLayoutX(459);
        ReportLabel.setLayoutY(192);
     

        
        TextArea ReportArea = new TextArea();
        ReportArea.setPrefHeight(100);
        ReportArea.setPrefWidth(260);
        ReportArea.setLayoutX(459);
        ReportArea.setLayoutY(227);
        ReportArea.setText(reportquery);


        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
        horizontalline.setOpacity(.3);
        horizontalline.setTranslateY(100);

        ChoiceBox<String> RadiologistChoiceBox = new ChoiceBox<String>();
        RadiologistChoiceBox.setPrefHeight(30);
        RadiologistChoiceBox.setPrefWidth(150);
        RadiologistChoiceBox.setLayoutX(47);
        RadiologistChoiceBox.setLayoutY(227);
        RadiologistChoiceBox.setValue(radiologistquery);
  
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
        



        ChoiceBox<String> OrdersChoiceBox = new ChoiceBox<String>();
        OrdersChoiceBox.setPrefHeight(30);
        OrdersChoiceBox.setPrefWidth(150);
        OrdersChoiceBox.setLayoutX(247);
        OrdersChoiceBox.setLayoutY(227);
        OrdersChoiceBox.setValue(ordernumberquery.toString());
  
        // Adds Orders to the Box
        try {
          DatabaseConnection connectNow = new DatabaseConnection();
          Connection connectDB = connectNow.getConnection();
  
          String GetChoiceBoxQuery = "Select * from orders";
          Statement statement = connectDB.createStatement();
          ResultSet OrdersOutput = statement.executeQuery(GetChoiceBoxQuery);
  
          while (OrdersOutput.next()) {
              Orders currentitterationpatient = new Orders(OrdersOutput.getInt("order_id"));
              OrdersChoiceBox.getItems().add(currentitterationpatient.getOrders().toString());
          }
  
      } catch (SQLException e1) {
  
          e1.printStackTrace();
      }



      Button CreateDiagnosticReportButton = new Button("Save");
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

       

            String RadiologistQuery = "select id from radiologists where full_name = '" + RadiologistChoiceBox.getValue() + "';";
            Statement statement2 = connectDB.createStatement();
            ResultSet RadiologistsID = statement2.executeQuery(RadiologistQuery);

         
                   


             while (RadiologistsID.next()) {
                Integer  RadiologistID = RadiologistsID.getInt("id");

                String InsertIntoUsersTableQuery = "update diagnostic_reports set order_id = '" + OrdersChoiceBox.getValue() + "', radiologist = '" + RadiologistID + "', diagnostic = '"+ ReportArea.getText() + "' where diagnostic_report_id = '" + reportidquery + "';";
                Statement statement = connectDB.createStatement();
                statement.execute(InsertIntoUsersTableQuery);
                Stage stage = (Stage) CreateDiagnosticReportButton.getScene().getWindow();
    
                stage.close();
                BlurBox.setEffect(new BoxBlur(0, 0, 0));

                FXApp.setRoot("ADMIN_AdminPanel");

          }



          

        }
        catch (SQLException e2){

            e2.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
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
                anchorpane.getChildren().add(UploadLabel);
                anchorpane.getChildren().add(OrderLabel);
                anchorpane.getChildren().add(horizontalline);
                anchorpane.getChildren().add(OrdersChoiceBox);
                anchorpane.getChildren().add(RadiologistChoiceBox);
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
});//END OF MODIFYING DIAGNOSTIC REPORT


                DiagnosticReportsObservableList.add(

                        new TABLEDiagnosticReportsTableController(reportidquery, radiologistquery, ordernumberquery, reportquery, button));
            }

            ReportsID.setCellValueFactory(new PropertyValueFactory<>("reportid"));
            ReportsRadiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));
            ReportsOrderNumber.setCellValueFactory(new PropertyValueFactory<>("ordernumber"));
            ReportsReport.setCellValueFactory(new PropertyValueFactory<>("report"));
            ReportsModify.setCellValueFactory(new PropertyValueFactory<>("button"));

            DiagnosticReportsTable.setItems(null);
            DiagnosticReportsTable.setItems(DiagnosticReportsObservableList);


            // Search Bar Functionality Start
FilteredList<TABLEDiagnosticReportsTableController> DiagnosticReportsFilteredData = new FilteredList<>(
    DiagnosticReportsObservableList);

    searchDiagnosticReports.textProperty().addListener((observable, oldValue, newValue) -> {
        DiagnosticReportsFilteredData.setPredicate(TABLEDiagnosticReportsTableController -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (TABLEDiagnosticReportsTableController.getRadiologist().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;

                } else if (TABLEDiagnosticReportsTableController.getReport().toLowerCase()
                        .indexOf(searchKeyword) > -1) {
                    return true;

                }  else {
                    return false; 
                }

            });

            });

            SortedList<TABLEDiagnosticReportsTableController> DiagnosticReportSortedData = new SortedList<>(
                DiagnosticReportsFilteredData);

            // Binds the sorted resultswith the Table
            DiagnosticReportSortedData.comparatorProperty().bind(DiagnosticReportsTable.comparatorProperty());

            DiagnosticReportsTable.setItems(DiagnosticReportSortedData);
// Search Bar Functionality End

        } catch (Exception e) {
            System.out.println("error");
        }



    }

}
