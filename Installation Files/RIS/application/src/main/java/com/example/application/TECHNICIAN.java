package com.example.application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.example.application.TableConstructors.PatientsAlertsTableController;
import com.example.application.TableConstructors.TECHCheckedInAppointmentsTableController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TECHNICIAN extends Application implements Initializable {

    String user_id1 = LOGIN.LoggedInUserID;

    @FXML
    private ScrollPane BlurBox;

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
        FXApp.setRoot("TECHNICIAN");
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
        FXApp.setRoot("TECHNICIAN_UserInfo");
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
    private Button AppointmentsButton;

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("TECHNICIAN_Apppointments");
    }

    @FXML
    public void AppointentsButtonEntered() {

        AppointmentsButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void AppointmentsButtonExited() {

        AppointmentsButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    /*
     * 
     * TECH Checked-In Appointments Imports
     * 
     */
    @FXML
    private TableView<TECHCheckedInAppointmentsTableController> TECHNICIANCheckedInAppointmentsTable1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Integer> CheckedInAppointments_Patient1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Integer> CheckedInAppointments_Modality1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, String> CheckedInAppointments_Price1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Date> CheckedInAppointments_DateandTime1;

    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Integer> CheckedInAppointments_Radiologist1;
    @FXML
    private TableColumn<TECHCheckedInAppointmentsTableController, Button> TechCheckedInCompleteOrder;// TABLECheckedInAppointmentsTableController

    @FXML
    private TextField searchCheckedInAppointments1;

    ObservableList<TECHCheckedInAppointmentsTableController> TECHCheckedInAppointmentsObservableList = FXCollections
            .observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        /*
         * 
         * Checked-In Appointments TECH Table
         * 
         */

        String TECHCheckedInAppointmentsTableQuery = "select p.patient_id, a.appointment_id, a.checked_in, a.patient, a.date_time, p.first_name, p.last_name, m.name, m.price, r.full_name, a.order_id, cf.form_id from appointments as a left join patients as p on a.patient = p.patient_id left join modalities as m on a.modality = m.modality_id left join radiologists as r on a.radiologist = r.id left join consent_forms as cf on cf.order_id = a.order_id where checked_in = 1 AND (closed = 0 || closed IS NULL) order by date_time;";

        try {

            Statement statement2 = connectDB.createStatement();
            ResultSet queryOutput = statement2.executeQuery(TECHCheckedInAppointmentsTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String pricequery = queryOutput.getString("price");
                Date date_timequery = queryOutput.getDate("date_time"); 
                String radiologistquery = queryOutput.getString("full_name");
                Boolean checkedinquestion = queryOutput.getBoolean("checked_in");
                Integer Order_id = queryOutput.getInt("order_id");
                Integer appointment_id = queryOutput.getInt("appointment_id");
                Integer consentFormID = queryOutput.getInt("form_id");
                Integer patients_id = queryOutput.getInt("patient_id");

                String DoesThisPatientHaveAnAlert = "Select * from patients_alerts where patient_id = '" + patients_id
                        + "'";
                Statement statement3 = connectDB.createStatement();
                ResultSet queryOutput3 = statement3.executeQuery(DoesThisPatientHaveAnAlert);
                Button button;
                // If There is no Alert
                if (!queryOutput3.isBeforeFirst()) {
                    button = new Button("Complete Order");
                    button.setStyle(
                            "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");
                    // Completes Order
                    button.setOnAction(new EventHandler<ActionEvent>() {

                        String extension;
                        String fileName;

                        @Override
                        public void handle(ActionEvent event) {

                            if (consentFormID == 0) {
                                BlurBox.setEffect(new BoxBlur(5, 10, 10));

                                Stage newWindow = new Stage();

                                AnchorPane anchorpane = new AnchorPane();

                                Label CreateFileLabel = new Label("Upload Consent Form");
                                CreateFileLabel.setLayoutX(46);
                                CreateFileLabel.setLayoutY(47);
                                CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                                Label UploadLabel = new Label("Upload:");
                                UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                                UploadLabel.setLayoutX(47);
                                UploadLabel.setLayoutY(192);

                                Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                                horizontalline.setOpacity(.3);
                                horizontalline.setTranslateY(100);

                                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF File",
                                        "*.pdf");

                                FileChooser fil_chooser = new FileChooser();
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

                                Button ContinueOrderButton = new Button("Continue order");
                                ContinueOrderButton.setPrefHeight(42);
                                ContinueOrderButton.setPrefWidth(102);
                                ContinueOrderButton.setLayoutX(565);
                                ContinueOrderButton.setLayoutY(338);
                                ContinueOrderButton.setDisable(true);
                                ContinueOrderButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

                                    public void handle(ActionEvent e) {

                                        File file = fil_chooser.showOpenDialog(newWindow);

                                        if (file != null) {

                                            label.setText(file.getAbsolutePath());

                                            ContinueOrderButton.setDisable(false);
                                        }
                                    }
                                };
                                button.setOnAction(event1);

                                Button showImage = new Button("View Form");
                                showImage.setPrefHeight(42);
                                showImage.setPrefWidth(100);
                                showImage.setLayoutX(170);
                                showImage.setLayoutY(280);
                                showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                showImage.setOnAction(new EventHandler<ActionEvent>() {

                                    /************** SHOWS IMAGE IN NEW WINDOW *********************************/
                                    @Override
                                    public void handle(ActionEvent e) {

                                        String UploadPath = label.getText();

                                        HostServices hs = getHostServices();
                                        hs.showDocument(UploadPath);

                                    }
                                });

                                ContinueOrderButton.setOnAction(new EventHandler<ActionEvent>() {

                                    @Override
                                    public void handle(ActionEvent event) {

                                        if (label.getText() == "No file chosen") {

                                        }

                                        else {

                                            newWindow.close();

                                            try {

                                                try {

                                                    int index = label.getText().lastIndexOf('.');

                                                    if (index > 0) {
                                                        extension = label.getText().substring(index + 1);

                                                    }
                                                    if (index > 0) {

                                                        java.nio.file.Path path = Paths.get(label.getText());
                                                        fileName = path.getFileName().toString();
                                                    }

                                                    DatabaseConnection connectNow = new DatabaseConnection();
                                                    Connection connectDB = connectNow.getConnection();

                                                    PreparedStatement statement2 = null;

                                                    statement2 = connectDB.prepareStatement(
                                                            "insert into consent_forms (order_id, file_name, file_type, upload_path, is_active) values (?, ?, ?, ?, ?)");
                                                    statement2.setInt(1, Order_id);
                                                    statement2.setString(2, fileName);
                                                    statement2.setString(3, extension);
                                                    statement2.setString(4, label.getText());
                                                    statement2.setBoolean(5, true);
                                                    statement2.executeUpdate();

                                                    Stage stage = (Stage) ContinueOrderButton.getScene().getWindow();

                                                    stage.close();
                                                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                                } catch (SQLException e1) {

                                                    e1.printStackTrace();
                                                }

                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }

                                        }

                                        BlurBox.setEffect(new BoxBlur(5, 10, 10));

                                        Stage newWindow = new Stage();

                                        AnchorPane anchorpane = new AnchorPane();

                                        Label CreateFileLabel = new Label("Upload Files to Order");
                                        CreateFileLabel.setLayoutX(46);
                                        CreateFileLabel.setLayoutY(47);
                                        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                                        Label UploadLabel = new Label("Upload:");
                                        UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                                        UploadLabel.setLayoutX(47);
                                        UploadLabel.setLayoutY(192);

                                        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                                        horizontalline.setOpacity(.3);
                                        horizontalline.setTranslateY(100);

                                        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                                                "Image Files", "*.jpg", "*.png", "*.jpeg");

                                        FileChooser fil_chooser = new FileChooser();
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

                                        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

                                            public void handle(ActionEvent e) {

                                                File file = fil_chooser.showOpenDialog(newWindow);

                                                if (file != null) {

                                                    label.setText(file.getAbsolutePath());
                                                }
                                            }
                                        };
                                        button.setOnAction(event1);

                                        Button showImage = new Button("Show Image");
                                        showImage.setPrefHeight(42);
                                        showImage.setPrefWidth(100);
                                        showImage.setLayoutX(170);
                                        showImage.setLayoutY(280);
                                        showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                        showImage.setOnAction(new EventHandler<ActionEvent>() {

                                            /************** SHOWS IMAGE IN NEW WINDOW *********************************/
                                            @Override
                                            public void handle(ActionEvent e) {

                                                String UploadPath = label.getText();
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
                                        });

                                        Button UploadFileButton = new Button("Complete Order");
                                        UploadFileButton.setPrefHeight(42);
                                        UploadFileButton.setPrefWidth(102);
                                        UploadFileButton.setLayoutX(565);
                                        UploadFileButton.setLayoutY(338);
                                        UploadFileButton
                                                .setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                        UploadFileButton.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent e) {

                                                if (label.getText() == "No file chosen") {

                                                }

                                                else {

                                                    try {

                                                        try {

                                                            int index = label.getText().lastIndexOf('.');

                                                            if (index > 0) {
                                                                extension = label.getText().substring(index + 1);

                                                            }
                                                            if (index > 0) {

                                                                java.nio.file.Path path = Paths.get(label.getText());
                                                                fileName = path.getFileName().toString();
                                                            }

                                                            DatabaseConnection connectNow = new DatabaseConnection();
                                                            Connection connectDB = connectNow.getConnection();

                                                            String UpdateAppointmentsTable = "update appointments set closed = true where appointment_id = "
                                                                    + appointment_id + ";";
                                                            Statement statement = connectDB.createStatement();
                                                            PreparedStatement statement2 = null;

                                                            statement2 = connectDB.prepareStatement(
                                                                    "insert into file_uploads (order_id, file_name, file_type, is_active, upload_path) values (?, ?, ?, ?, ?)");
                                                            statement2.setInt(1, Order_id);
                                                            statement2.setString(2, fileName);
                                                            statement2.setString(3, extension);
                                                            statement2.setBoolean(4, true);
                                                            statement2.setString(5, label.getText());
                                                            statement2.executeUpdate();

                                                            statement.execute(UpdateAppointmentsTable);

                                                            Stage stage = (Stage) UploadFileButton.getScene()
                                                                    .getWindow();

                                                            stage.close();
                                                            BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                                            FXApp.setRoot("TECHNICIAN");

                                                        } catch (SQLException e1) {

                                                            e1.printStackTrace();
                                                        }

                                                    } catch (Exception e2) {
                                                        e2.printStackTrace();
                                                    }

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
                                                try {
                                                    FXApp.setRoot("TECHNICIAN");
                                                } catch (IOException e1) {
                                                    e1.printStackTrace();
                                                }

                                            }
                                        });

                                        anchorpane.getChildren().add(CreateFileLabel);
                                        anchorpane.getChildren().add(UploadLabel);

                                        anchorpane.getChildren().add(horizontalline);

                                        anchorpane.getChildren().add(button);
                                        anchorpane.getChildren().add(label);
                                        anchorpane.getChildren().add(CancelButton);
                                        anchorpane.getChildren().add(UploadFileButton);
                                        anchorpane.getChildren().add(showImage);

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
                                                    try {
                                                        FXApp.setRoot("TECHNICIAN");
                                                    } catch (IOException e1) {
                                                        e1.printStackTrace();
                                                    }

                                                }
                                            }
                                        });
                                        newWindow.show();
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

                                anchorpane.getChildren().add(horizontalline);

                                anchorpane.getChildren().add(button);
                                anchorpane.getChildren().add(label);
                                anchorpane.getChildren().add(CancelButton);
                                anchorpane.getChildren().add(ContinueOrderButton);
                                anchorpane.getChildren().add(showImage);

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

                            } else {

                                BlurBox.setEffect(new BoxBlur(5, 10, 10));

                                Stage newWindow = new Stage();

                                AnchorPane anchorpane = new AnchorPane();

                                Label CreateFileLabel = new Label("Upload Files to Order");
                                CreateFileLabel.setLayoutX(46);
                                CreateFileLabel.setLayoutY(47);
                                CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                                Label UploadLabel = new Label("Upload:");
                                UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                                UploadLabel.setLayoutX(47);
                                UploadLabel.setLayoutY(192);

                                Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                                horizontalline.setOpacity(.3);
                                horizontalline.setTranslateY(100);

                                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                                        "Image Files", "*.jpg", "*.png", "*.jpeg");

                                FileChooser fil_chooser = new FileChooser();
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

                                EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

                                    public void handle(ActionEvent e) {

                                        File file = fil_chooser.showOpenDialog(newWindow);

                                        if (file != null) {

                                            label.setText(file.getAbsolutePath());
                                        }
                                    }
                                };
                                button.setOnAction(event1);

                                Button showImage = new Button("Show Image");
                                showImage.setPrefHeight(42);
                                showImage.setPrefWidth(100);
                                showImage.setLayoutX(170);
                                showImage.setLayoutY(280);
                                showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                showImage.setOnAction(new EventHandler<ActionEvent>() {

                                    /************** SHOWS IMAGE IN NEW WINDOW *********************************/
                                    @Override
                                    public void handle(ActionEvent e) {

                                        String UploadPath = label.getText();
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
                                });

                                Button UploadFileButton = new Button("Complete Order");
                                UploadFileButton.setPrefHeight(42);
                                UploadFileButton.setPrefWidth(102);
                                UploadFileButton.setLayoutX(565);
                                UploadFileButton.setLayoutY(338);
                                UploadFileButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                UploadFileButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent e) {

                                        if (label.getText() == "No file chosen") {

                                        }

                                        else {

                                            try {

                                                try {

                                                    int index = label.getText().lastIndexOf('.');

                                                    if (index > 0) {
                                                        extension = label.getText().substring(index + 1);

                                                    }
                                                    if (index > 0) {

                                                        java.nio.file.Path path = Paths.get(label.getText());
                                                        fileName = path.getFileName().toString();
                                                    }

                                                    DatabaseConnection connectNow = new DatabaseConnection();
                                                    Connection connectDB = connectNow.getConnection();

                                                    String UpdateAppointmentsTable = "update appointments set closed = true where appointment_id = "
                                                            + appointment_id + ";";
                                                    Statement statement = connectDB.createStatement();
                                                    PreparedStatement statement2 = null;

                                                    statement2 = connectDB.prepareStatement(
                                                            "insert into file_uploads (order_id, file_name, file_type, is_active, upload_path) values (?, ?, ?, ?, ?)");
                                                    statement2.setInt(1, Order_id);
                                                    statement2.setString(2, fileName);
                                                    statement2.setString(3, extension);
                                                    statement2.setBoolean(4, true);
                                                    statement2.setString(5, label.getText());
                                                    statement2.executeUpdate();

                                                    statement.execute(UpdateAppointmentsTable);

                                                    Stage stage = (Stage) UploadFileButton.getScene().getWindow();

                                                    stage.close();
                                                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                                    FXApp.setRoot("TECHNICIAN");

                                                } catch (SQLException e1) {

                                                    e1.printStackTrace();
                                                }

                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }

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
                                        try {
                                            FXApp.setRoot("TECHNICIAN");
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }

                                    }
                                });

                                anchorpane.getChildren().add(CreateFileLabel);
                                anchorpane.getChildren().add(UploadLabel);

                                anchorpane.getChildren().add(horizontalline);

                                anchorpane.getChildren().add(button);
                                anchorpane.getChildren().add(label);
                                anchorpane.getChildren().add(CancelButton);
                                anchorpane.getChildren().add(UploadFileButton);
                                anchorpane.getChildren().add(showImage);

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
                                            try {
                                                FXApp.setRoot("TECHNICIAN");
                                            } catch (IOException e1) {
                                                e1.printStackTrace();
                                            }

                                        }
                                    }
                                });
                                newWindow.show();

                            }
                        }

                    });// CLOSES Complete Order

                }
                // If there is an alert
                else {
                    button = new Button("Alert!");
                    button.setStyle(
                            "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #d32525;");

                    button.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            if (consentFormID == 0) {
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

                                TableColumn<PatientsAlertsTableController, String> column1 = new TableColumn<>(
                                        "Alerts");
                                column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                                column1.setPrefWidth(500);

                                tableView.getColumns().add(column1);
                                try {
                                    DatabaseConnection connectNow = new DatabaseConnection();
                                    Connection connectDB = connectNow.getConnection();

                                    String alert_nameTableQuery = " select * from patients_alerts as pa join alerts as a on a.alert_id = pa.alert_id where patient_id = "
                                            + patients_id + ";";

                                    Statement statement = connectDB.createStatement();
                                    ResultSet queryOutput = statement.executeQuery(alert_nameTableQuery);

                                    while (queryOutput.next()) {
                                        Integer AlertID = queryOutput.getInt("alert_id");
                                        String AlertName = queryOutput.getString("alert_name");

                                        tableView.getItems().add(new PatientsAlertsTableController(AlertName));

                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                Button ContinueWithOrderButton = new Button("Complete Order");
                                ContinueWithOrderButton.setPrefHeight(42);
                                ContinueWithOrderButton.setPrefWidth(120);
                                ContinueWithOrderButton.setLayoutX(300);
                                ContinueWithOrderButton.setLayoutY(585);
                                ContinueWithOrderButton
                                        .setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                ContinueWithOrderButton.setOnAction(new EventHandler<ActionEvent>() {

                                    String extension;
                                    String fileName;

                                    @Override
                                    public void handle(ActionEvent event) {

                                        newWindow.close();

                                        BlurBox.setEffect(new BoxBlur(5, 10, 10));

                                        Stage newWindow = new Stage();

                                        AnchorPane anchorpane = new AnchorPane();

                                        Label CreateFileLabel = new Label("Upload Consent Form");
                                        CreateFileLabel.setLayoutX(46);
                                        CreateFileLabel.setLayoutY(47);
                                        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                                        Label UploadLabel = new Label("Upload:");
                                        UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                                        UploadLabel.setLayoutX(47);
                                        UploadLabel.setLayoutY(192);

                                        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                                        horizontalline.setOpacity(.3);
                                        horizontalline.setTranslateY(100);

                                        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                                                "PDF File",
                                                "*.pdf");

                                        FileChooser fil_chooser = new FileChooser();
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

                                        Button ContinueOrderButton = new Button("Continue order");
                                        ContinueOrderButton.setPrefHeight(42);
                                        ContinueOrderButton.setPrefWidth(102);
                                        ContinueOrderButton.setLayoutX(565);
                                        ContinueOrderButton.setLayoutY(338);
                                        ContinueOrderButton.setDisable(true);
                                        ContinueOrderButton
                                                .setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

                                            public void handle(ActionEvent e) {

                                                File file = fil_chooser.showOpenDialog(newWindow);

                                                if (file != null) {

                                                    label.setText(file.getAbsolutePath());
                                                    ContinueOrderButton.setDisable(false);
                                                }
                                            }
                                        };
                                        button.setOnAction(event1);

                                        Button showImage = new Button("Show Image");
                                        showImage.setPrefHeight(42);
                                        showImage.setPrefWidth(100);
                                        showImage.setLayoutX(170);
                                        showImage.setLayoutY(280);
                                        showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                        showImage.setOnAction(new EventHandler<ActionEvent>() {

                                            /************** SHOWS IMAGE IN NEW WINDOW *********************************/
                                            @Override
                                            public void handle(ActionEvent e) {

                                                String UploadPath = label.getText();
                                                // File file = new File(UploadPath);

                                                HostServices hs = getHostServices();
                                                hs.showDocument(UploadPath);

                                            }
                                        });

                                        ContinueOrderButton.setOnAction(new EventHandler<ActionEvent>() {

                                            @Override
                                            public void handle(ActionEvent event) {

                                                if (label.getText() == "No file chosen") {

                                                }

                                                else {

                                                    try {

                                                        try {

                                                            int index = label.getText().lastIndexOf('.');

                                                            if (index > 0) {
                                                                extension = label.getText().substring(index + 1);

                                                            }
                                                            if (index > 0) {

                                                                java.nio.file.Path path = Paths.get(label.getText());
                                                                fileName = path.getFileName().toString();
                                                            }

                                                            DatabaseConnection connectNow = new DatabaseConnection();
                                                            Connection connectDB = connectNow.getConnection();

                                                            PreparedStatement statement2 = null;

                                                            statement2 = connectDB.prepareStatement(
                                                                    "insert into consent_forms (order_id, file_name, file_type, upload_path, is_active) values (?, ?, ?, ?, ?)");
                                                            statement2.setInt(1, Order_id);
                                                            statement2.setString(2, fileName);
                                                            statement2.setString(3, extension);
                                                            statement2.setString(4, label.getText());
                                                            statement2.setBoolean(5, true);
                                                            statement2.executeUpdate();

                                                            newWindow.close();
                                                            BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                                        } catch (SQLException e1) {

                                                            e1.printStackTrace();
                                                        }

                                                    } catch (Exception e2) {
                                                        e2.printStackTrace();
                                                    }

                                                }

                                                BlurBox.setEffect(new BoxBlur(5, 10, 10));

                                                Stage newWindow = new Stage();

                                                AnchorPane anchorpane = new AnchorPane();

                                                Label CreateFileLabel = new Label("Upload Files to Order");
                                                CreateFileLabel.setLayoutX(46);
                                                CreateFileLabel.setLayoutY(47);
                                                CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                                                Label UploadLabel = new Label("Upload:");
                                                UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                                                UploadLabel.setLayoutX(47);
                                                UploadLabel.setLayoutY(192);

                                                Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                                                horizontalline.setOpacity(.3);
                                                horizontalline.setTranslateY(100);

                                                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                                                        "Image Files", "*.jpg", "*.png", "*.jpeg");

                                                FileChooser fil_chooser = new FileChooser();
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

                                                EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

                                                    public void handle(ActionEvent e) {

                                                        File file = fil_chooser.showOpenDialog(newWindow);

                                                        if (file != null) {

                                                            label.setText(file.getAbsolutePath());
                                                        }
                                                    }
                                                };
                                                button.setOnAction(event1);

                                                Button showImage = new Button("Show Image");
                                                showImage.setPrefHeight(42);
                                                showImage.setPrefWidth(100);
                                                showImage.setLayoutX(170);
                                                showImage.setLayoutY(280);
                                                showImage.setStyle(
                                                        "-fx-background-color: #566aff; -fx-text-fill: white;");

                                                showImage.setOnAction(new EventHandler<ActionEvent>() {

                                                    /**************
                                                     * SHOWS IMAGE IN NEW WINDOW
                                                     *********************************/
                                                    @Override
                                                    public void handle(ActionEvent e) {

                                                        String UploadPath = label.getText();
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
                                                });

                                                Button UploadFileButton = new Button("Complete Order");
                                                UploadFileButton.setPrefHeight(42);
                                                UploadFileButton.setPrefWidth(102);
                                                UploadFileButton.setLayoutX(565);
                                                UploadFileButton.setLayoutY(338);
                                                UploadFileButton
                                                        .setStyle(
                                                                "-fx-background-color: #566aff; -fx-text-fill: white;");

                                                UploadFileButton.setOnAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent e) {

                                                        if (label.getText() == "No file chosen") {

                                                        }

                                                        else {

                                                            try {

                                                                try {

                                                                    int index = label.getText().lastIndexOf('.');

                                                                    if (index > 0) {
                                                                        extension = label.getText()
                                                                                .substring(index + 1);

                                                                    }
                                                                    if (index > 0) {

                                                                        java.nio.file.Path path = Paths
                                                                                .get(label.getText());
                                                                        fileName = path.getFileName().toString();
                                                                    }

                                                                    DatabaseConnection connectNow = new DatabaseConnection();
                                                                    Connection connectDB = connectNow.getConnection();

                                                                    String UpdateAppointmentsTable = "update appointments set closed = true where appointment_id = "
                                                                            + appointment_id + ";";
                                                                    Statement statement = connectDB.createStatement();
                                                                    PreparedStatement statement2 = null;

                                                                    statement2 = connectDB.prepareStatement(
                                                                            "insert into file_uploads (order_id, file_name, file_type, is_active, upload_path) values (?, ?, ?, ?, ?)");
                                                                    statement2.setInt(1, Order_id);
                                                                    statement2.setString(2, fileName);
                                                                    statement2.setString(3, extension);
                                                                    statement2.setBoolean(4, true);
                                                                    statement2.setString(5, label.getText());
                                                                    statement2.executeUpdate();

                                                                    statement.execute(UpdateAppointmentsTable);

                                                                    Stage stage = (Stage) UploadFileButton.getScene()
                                                                            .getWindow();

                                                                    stage.close();
                                                                    BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                                                    FXApp.setRoot("TECHNICIAN");

                                                                } catch (SQLException e1) {

                                                                    e1.printStackTrace();
                                                                }

                                                            } catch (Exception e2) {
                                                                e2.printStackTrace();
                                                            }

                                                        }

                                                    }
                                                });

                                                Button CancelButton = new Button("Cancel");
                                                CancelButton.setPrefHeight(42);
                                                CancelButton.setPrefWidth(102);
                                                CancelButton.setLayoutX(680);
                                                CancelButton.setLayoutY(338);
                                                CancelButton
                                                        .setStyle(
                                                                "-fx-background-color: #d32525; -fx-text-fill: white;");

                                                CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent e) {
                                                        Stage stage = (Stage) CancelButton.getScene().getWindow();
                                                        stage.close();
                                                        BlurBox.setEffect(new BoxBlur(0, 0, 0));
                                                        try {
                                                            FXApp.setRoot("TECHNICIAN");
                                                        } catch (IOException e1) {
                                                            e1.printStackTrace();
                                                        }

                                                    }
                                                });

                                                anchorpane.getChildren().add(CreateFileLabel);
                                                anchorpane.getChildren().add(UploadLabel);

                                                anchorpane.getChildren().add(horizontalline);

                                                anchorpane.getChildren().add(button);
                                                anchorpane.getChildren().add(label);
                                                anchorpane.getChildren().add(CancelButton);
                                                anchorpane.getChildren().add(UploadFileButton);
                                                anchorpane.getChildren().add(showImage);

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

                                        anchorpane.getChildren().add(horizontalline);

                                        anchorpane.getChildren().add(button);
                                        anchorpane.getChildren().add(label);
                                        anchorpane.getChildren().add(CancelButton);
                                        anchorpane.getChildren().add(ContinueOrderButton);
                                        anchorpane.getChildren().add(showImage);

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
                                });// CLOSES Complete Order

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
                                        BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                    }
                                });

                                anchorpane.getChildren().add(CreateNewPatientAlertLabel);

                                anchorpane.getChildren().add(horizontalline);

                                anchorpane.getChildren().add(CancelButton);
                                anchorpane.getChildren().add(tableView);
                                anchorpane.getChildren().add(ContinueWithOrderButton);
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
                            } else {

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

                                TableColumn<PatientsAlertsTableController, String> column1 = new TableColumn<>(
                                        "Alerts");
                                column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                                column1.setPrefWidth(500);

                                tableView.getColumns().add(column1);
                                try {
                                    DatabaseConnection connectNow = new DatabaseConnection();
                                    Connection connectDB = connectNow.getConnection();

                                    String alert_nameTableQuery = " select * from patients_alerts as pa join alerts as a on a.alert_id = pa.alert_id where patient_id = "
                                            + patients_id + ";";

                                    Statement statement = connectDB.createStatement();
                                    ResultSet queryOutput = statement.executeQuery(alert_nameTableQuery);

                                    while (queryOutput.next()) {
                                        Integer AlertID = queryOutput.getInt("alert_id");
                                        String AlertName = queryOutput.getString("alert_name");

                                        tableView.getItems().add(new PatientsAlertsTableController(AlertName));

                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                Button ContinueWithOrderButton = new Button("Complete Order");
                                ContinueWithOrderButton.setPrefHeight(42);
                                ContinueWithOrderButton.setPrefWidth(120);
                                ContinueWithOrderButton.setLayoutX(300);
                                ContinueWithOrderButton.setLayoutY(585);
                                ContinueWithOrderButton
                                        .setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                ContinueWithOrderButton.setOnAction(new EventHandler<ActionEvent>() {

                                    String extension;
                                    String fileName;

                                    @Override
                                    public void handle(ActionEvent event) {

                                        newWindow.close();

                                        BlurBox.setEffect(new BoxBlur(5, 10, 10));

                                        Stage newWindow = new Stage();

                                        AnchorPane anchorpane = new AnchorPane();

                                        Label CreateFileLabel = new Label("Upload Files to Order");
                                        CreateFileLabel.setLayoutX(46);
                                        CreateFileLabel.setLayoutY(47);
                                        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                                        Label UploadLabel = new Label("Upload:");
                                        UploadLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                                        UploadLabel.setLayoutX(47);
                                        UploadLabel.setLayoutY(192);

                                        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                                        horizontalline.setOpacity(.3);
                                        horizontalline.setTranslateY(100);

                                        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                                                "Image Files", "*.jpg", "*.png", "*.jpeg");

                                        FileChooser fil_chooser = new FileChooser();
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

                                        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

                                            public void handle(ActionEvent e) {

                                                File file = fil_chooser.showOpenDialog(newWindow);

                                                if (file != null) {

                                                    label.setText(file.getAbsolutePath());
                                                }
                                            }
                                        };
                                        button.setOnAction(event1);

                                        Button showImage = new Button("Show Image");
                                        showImage.setPrefHeight(42);
                                        showImage.setPrefWidth(100);
                                        showImage.setLayoutX(170);
                                        showImage.setLayoutY(280);
                                        showImage.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                        showImage.setOnAction(new EventHandler<ActionEvent>() {

                                            /**************
                                             * SHOWS IMAGE IN NEW WINDOW
                                             *********************************/
                                            @Override
                                            public void handle(ActionEvent e) {

                                                String UploadPath = label.getText();
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
                                        });

                                        Button UploadFileButton = new Button("Complete Order");
                                        UploadFileButton.setPrefHeight(42);
                                        UploadFileButton.setPrefWidth(102);
                                        UploadFileButton.setLayoutX(565);
                                        UploadFileButton.setLayoutY(338);
                                        UploadFileButton
                                                .setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                                        UploadFileButton.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent e) {

                                                if (label.getText() == "No file chosen") {

                                                }

                                                else {

                                                    try {

                                                        try {

                                                            int index = label.getText().lastIndexOf('.');

                                                            if (index > 0) {
                                                                extension = label.getText().substring(index + 1);

                                                            }
                                                            if (index > 0) {

                                                                java.nio.file.Path path = Paths
                                                                        .get(label.getText());
                                                                fileName = path.getFileName().toString();
                                                            }

                                                            DatabaseConnection connectNow = new DatabaseConnection();
                                                            Connection connectDB = connectNow.getConnection();

                                                            String UpdateAppointmentsTable = "update appointments set closed = true where appointment_id = "
                                                                    + appointment_id + ";";
                                                            Statement statement = connectDB.createStatement();
                                                            PreparedStatement statement2 = null;

                                                            statement2 = connectDB.prepareStatement(
                                                                    "insert into file_uploads (order_id, file_name, file_type, is_active, upload_path) values (?, ?, ?, ?, ?)");
                                                            statement2.setInt(1, Order_id);
                                                            statement2.setString(2, fileName);
                                                            statement2.setString(3, extension);
                                                            statement2.setBoolean(4, true);
                                                            statement2.setString(5, label.getText());
                                                            statement2.executeUpdate();

                                                            statement.execute(UpdateAppointmentsTable);

                                                            Stage stage = (Stage) UploadFileButton.getScene()
                                                                    .getWindow();

                                                            stage.close();
                                                            BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                                            FXApp.setRoot("TECHNICIAN");

                                                        } catch (SQLException e1) {

                                                            e1.printStackTrace();
                                                        }

                                                    } catch (Exception e2) {
                                                        e2.printStackTrace();
                                                    }

                                                }

                                            }
                                        });

                                        Button CancelButton = new Button("Cancel");
                                        CancelButton.setPrefHeight(42);
                                        CancelButton.setPrefWidth(102);
                                        CancelButton.setLayoutX(680);
                                        CancelButton.setLayoutY(338);
                                        CancelButton
                                                .setStyle("-fx-background-color: #d32525; -fx-text-fill: white;");

                                        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent e) {
                                                Stage stage = (Stage) CancelButton.getScene().getWindow();
                                                stage.close();
                                                BlurBox.setEffect(new BoxBlur(0, 0, 0));
                                                try {
                                                    FXApp.setRoot("TECHNICIAN");
                                                } catch (IOException e1) {
                                                    e1.printStackTrace();
                                                }

                                            }
                                        });

                                        anchorpane.getChildren().add(CreateFileLabel);
                                        anchorpane.getChildren().add(UploadLabel);

                                        anchorpane.getChildren().add(horizontalline);

                                        anchorpane.getChildren().add(button);
                                        anchorpane.getChildren().add(label);
                                        anchorpane.getChildren().add(CancelButton);
                                        anchorpane.getChildren().add(UploadFileButton);
                                        anchorpane.getChildren().add(showImage);

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
                                                    try {
                                                        FXApp.setRoot("TECHNICIAN");
                                                    } catch (IOException e1) {
                                                        e1.printStackTrace();
                                                    }

                                                }
                                            }
                                        });
                                        newWindow.show();

                                    }
                                });// CLOSES Complete Order

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
                                        BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                    }
                                });

                                anchorpane.getChildren().add(CreateNewPatientAlertLabel);

                                anchorpane.getChildren().add(horizontalline);

                                anchorpane.getChildren().add(CancelButton);
                                anchorpane.getChildren().add(tableView);
                                anchorpane.getChildren().add(ContinueWithOrderButton);
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
                        }
                    });// Closes New Patient Alert

                }

                TECHCheckedInAppointmentsObservableList.add(new TECHCheckedInAppointmentsTableController(patientquery,
                        modalityquery, date_timequery, radiologistquery, pricequery, checkedinquestion, button));
            }

            CheckedInAppointments_Patient1.setCellValueFactory(new PropertyValueFactory<>("patient"));

            CheckedInAppointments_Modality1.setCellValueFactory(new PropertyValueFactory<>("modality"));

            CheckedInAppointments_DateandTime1.setCellValueFactory(new PropertyValueFactory<>("date_time")); // price

            CheckedInAppointments_Radiologist1.setCellValueFactory(new PropertyValueFactory<>("radiologist"));

            CheckedInAppointments_Price1.setCellValueFactory(new PropertyValueFactory<>("price"));
            TechCheckedInCompleteOrder.setCellValueFactory(new PropertyValueFactory<>("button"));

            TECHNICIANCheckedInAppointmentsTable1.setItems(null);
            TECHNICIANCheckedInAppointmentsTable1.setItems(TECHCheckedInAppointmentsObservableList);

            // Search Bar Functionality Start
            FilteredList<TECHCheckedInAppointmentsTableController> TECHCheckedInAppointmentsFilteredData = new FilteredList<>(
                    TECHCheckedInAppointmentsObservableList);

            searchCheckedInAppointments1.textProperty().addListener((observable, oldValue, newValue) -> {
                TECHCheckedInAppointmentsFilteredData.setPredicate(TECHCheckedInAppointmentsTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TECHCheckedInAppointmentsTableController.getPatient().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TECHCheckedInAppointmentsTableController.getModality().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TECHCheckedInAppointmentsTableController.getRadiologist().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (TECHCheckedInAppointmentsTableController.getPrice().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    }

                    else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TECHCheckedInAppointmentsTableController> TECHCheckedInAppointmentsSortedData = new SortedList<>(
                    TECHCheckedInAppointmentsFilteredData);

            // Binds the sorted resultswith the Table
            TECHCheckedInAppointmentsSortedData.comparatorProperty()
                    .bind(TECHNICIANCheckedInAppointmentsTable1.comparatorProperty());

            TECHNICIANCheckedInAppointmentsTable1.setItems(TECHCheckedInAppointmentsSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage arg0) throws Exception {

    }

}