package com.example.application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.example.application.TableConstructors.PatientsAlertsTableController;
import com.example.application.TableConstructors.PlacedOrdersTableController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class REFERRAL_DOCTOR implements Initializable {

    String userid = LOGIN.LoggedInUserID;

    @FXML
    private ScrollPane BlurBox;

    /*
     * 
     * Button Logic
     * 
     */

    // Logout Button Logic
    @FXML
    private Button logoutButton;

    @FXML
    public void LogoutButtonOnMouseEntered() {

        logoutButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void LogoutButtonOnMouseExited() {

        logoutButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    public void logout(ActionEvent e) throws IOException {

        FXApp.setRoot("LOGIN");
    }

    // Home Button Logic
    @FXML
    private Button HomeButton;

    @FXML
    public void HomeButtonEntered() {

        HomeButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void HomeButtonExited() {

        HomeButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    public void home(ActionEvent e) throws IOException {
        FXApp.setRoot("REFERRAL_DOCTOR");
    }

    // User Info Button Logic
    @FXML
    private Button UserInfoButton;

    @FXML
    public void UserInfoButtonEntered() {

        UserInfoButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void UserInfoButtonExited() {

        UserInfoButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    public void userInfo(ActionEvent e) throws IOException {

        FXApp.setRoot("REFERRAL_DOCTOR_UserInfo");
    }

    // Referrals Button Logic
    @FXML
    private Button ReferralsButton;

    @FXML
    public void ReferralsButtonEntered() {

        ReferralsButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void ReferralsButtonExited() {

        ReferralsButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    public void referrals(ActionEvent e) throws IOException {
        FXApp.setRoot("REFERRAL_DOCTOR_Referrals");
    }

    // Help Button Logic
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
     * Placed Orders Imports
     */
    @FXML
    private TableView<PlacedOrdersTableController> PlacedOrdersTable;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Patient;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Modality;

    @FXML
    private TableColumn<PlacedOrdersTableController, String> placed_orders_Notes;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Status;
    @FXML
    private TableColumn<PlacedOrdersTableController, Button> ResultsTable;

    @FXML
    private TextField searchPlacedOrders;

    ObservableList<PlacedOrdersTableController> PlacedOrdersTableObservableList = FXCollections
            .observableArrayList();

    /*
     * Completed Orders Imports
     */
    @FXML
    private TableView<PlacedOrdersTableController> CompletedOrdersTable;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> CompletedOrdersPatient;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> CompletedOrdersModality;

    @FXML
    private TableColumn<PlacedOrdersTableController, String> CompletedOrdersNotes;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> CompletedOrdersStatus;
    @FXML
    private TableColumn<PlacedOrdersTableController, Button> CompletedOrdersResults;

    @FXML
    private TextField searchCompletedOrders;

    ObservableList<PlacedOrdersTableController> completedOrdersObservableList = FXCollections
            .observableArrayList();

    /*
     * Closed Orders
     */
    @FXML
    private TableView<PlacedOrdersTableController> OldOrdersTable;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> OldOrdersPatients;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> OldOrdersModality;

    @FXML
    private TableColumn<PlacedOrdersTableController, String> OldOrdersNotes;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> OldOrdersStatus;
    @FXML
    private TableColumn<PlacedOrdersTableController, Button> OldOrdersResults;

    @FXML
    private TextField ClosedOrdersSearch;

    ObservableList<PlacedOrdersTableController> closedOrdersObservableList = FXCollections
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
        String PlacedOrdersTableQuery = "select patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.status,  order_status.order_name, referralmds.user_id from orders join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id join referralmds on referralmds.id = orders.referral_md WHERE (status = 4 || status = 1) and referralmds.user_id = "
                + userid + ";";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PlacedOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                String statusquery = queryOutput.getString("order_name");
                Integer patients_id = queryOutput.getInt("patient_id");

                String DoesThisPatientHaveAnAlert = "Select * from patients_alerts where patient_id = '" + patients_id
                        + "'";
                statement = connectDB.createStatement();
                ResultSet queryOutput2 = statement.executeQuery(DoesThisPatientHaveAnAlert);

                Button button;

                if (!queryOutput2.isBeforeFirst()) {
                    button = new Button("");
                    button.setStyle(
                            "-fx-background-color: transparent; ");
                }

                else {
                    button = new Button("Alert!");
                    button.setStyle(
                            "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #d32525;");

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

                                String alert_nameTableQuery = " select * from patients_alerts as pa join alerts as a on a.alert_id = pa.alert_id where patient_id = "
                                        + patients_id + ";";

                                Statement statement = connectDB.createStatement();
                                ResultSet queryOutput = statement.executeQuery(alert_nameTableQuery);

                                while (queryOutput.next()) {
                                    String AlertName = queryOutput.getString("alert_name");

                                    tableView.getItems().add(new PatientsAlertsTableController(AlertName));

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

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

                PlacedOrdersTableObservableList.add(
                        new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery, button));
            }

            placed_orders_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            placed_orders_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            placed_orders_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));

            placed_orders_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

            ResultsTable.setCellValueFactory(new PropertyValueFactory<>("button"));

            PlacedOrdersTable.setItems(null);
            PlacedOrdersTable.setItems(PlacedOrdersTableObservableList);

            // Search Bar Functionality Start
            FilteredList<PlacedOrdersTableController> PlacedOrdersFilteredData = new FilteredList<>(
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

            SortedList<PlacedOrdersTableController> PlacedOrdersSortedData = new SortedList<>(
                    PlacedOrdersFilteredData);

            // Binds the sorted resultswith the Table
            PlacedOrdersSortedData.comparatorProperty().bind(PlacedOrdersTable.comparatorProperty());

            PlacedOrdersTable.setItems(PlacedOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         *
         * Completed Orders Table
         * 
        */

        String CompletedOrdersTableQuery = "select diagnostic, patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.order_id, orders.status, order_status.order_name, referralmds.user_id  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id join diagnostic_reports on orders.order_id = diagnostic_reports.order_id join referralmds on referralmds.id = orders.referral_md where status = 3 and referralmds.user_id = "
                + userid + ";";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(CompletedOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                Integer OrderID = queryOutput.getInt("order_id");
                String statusquery = queryOutput.getString("order_name");
                Button button = new Button("Review Order");
                String diagnostic = queryOutput.getString("diagnostic");
                button.setStyle(
                        "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        BlurBox.setEffect(new BoxBlur(5, 10, 10));

                        Stage newWindow = new Stage();

                        AnchorPane anchorpane = new AnchorPane();

                        Label CreateFileLabel = new Label("View Completed Order");
                        CreateFileLabel.setLayoutX(46);
                        CreateFileLabel.setLayoutY(47);
                        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                        Label ReportLabel = new Label("Report:");
                        ReportLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                        ReportLabel.setLayoutX(275);
                        ReportLabel.setLayoutY(120);

                        TextArea ReportArea = new TextArea();
                        ReportArea.setPrefHeight(200);
                        ReportArea.setPrefWidth(400);
                        ReportArea.setLayoutX(350);
                        ReportArea.setLayoutY(120);
                        ReportArea.setEditable(false);
                        ReportArea.setText(diagnostic);

                        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                        horizontalline.setOpacity(.3);
                        horizontalline.setTranslateY(100);

                        Button showImage = new Button("Show Image");
                        showImage.setPrefHeight(42);
                        showImage.setPrefWidth(100);
                        showImage.setLayoutX(70);
                        showImage.setLayoutY(120);
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

                        Button CloseOrderButton = new Button("Close Order");
                        CloseOrderButton.setPrefHeight(42);
                        CloseOrderButton.setPrefWidth(102);
                        CloseOrderButton.setLayoutX(558);
                        CloseOrderButton.setLayoutY(338);
                        CloseOrderButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                        CloseOrderButton.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent e) {

                                String UpdateOrderStatus = "update orders set status = 2 where order_id = " + OrderID;

                                try {

                                    Statement statement5 = connectDB.createStatement();
                                    statement5.execute(UpdateOrderStatus);
                                    Stage stage = (Stage) CloseOrderButton.getScene().getWindow();
                                    stage.close();
                                    FXApp.setRoot("REFERRAL_DOCTOR");

                                } catch (SQLException | IOException e1) {

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

                        anchorpane.getChildren().add(horizontalline);

                        anchorpane.getChildren().add(CancelButton);
                        anchorpane.getChildren().add(showImage);
                        anchorpane.getChildren().add(ReportArea);
                        anchorpane.getChildren().add(ReportLabel);
                        anchorpane.getChildren().add(CloseOrderButton);

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

                completedOrdersObservableList.add(
                        new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery, button));
            }

            CompletedOrdersPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            CompletedOrdersModality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            CompletedOrdersNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));

            CompletedOrdersStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            CompletedOrdersResults.setCellValueFactory(new PropertyValueFactory<>("button"));

            CompletedOrdersTable.setItems(null);
            CompletedOrdersTable.setItems(completedOrdersObservableList);

            // Search Bar Functionality Start
            FilteredList<PlacedOrdersTableController> CompletedOrdersFilteredData = new FilteredList<>(
                    completedOrdersObservableList);

            searchCompletedOrders.textProperty().addListener((observable, oldValue, newValue) -> {
                CompletedOrdersFilteredData.setPredicate(TABLEPlacedOrdersTableController -> {
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

            SortedList<PlacedOrdersTableController> CompletedOrdersSortedData = new SortedList<>(
                    CompletedOrdersFilteredData);

            // Binds the sorted resultswith the Table
            CompletedOrdersSortedData.comparatorProperty().bind(CompletedOrdersTable.comparatorProperty());

            CompletedOrdersTable.setItems(CompletedOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         *
         * Old Orders Table
         * 
        */

        String OldOrdersTableQuery = "select patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.order_id, orders.status,  order_status.order_name, referralmds.user_id  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id join referralmds on referralmds.id = orders.referral_md where status = 2 and referralmds.user_id = "
                + userid + ";";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(OldOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                Integer OrderID = queryOutput.getInt("order_id");
                String statusquery = queryOutput.getString("order_name");
                Button button = new Button("Review Order");
                button.setStyle(
                        "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        BlurBox.setEffect(new BoxBlur(5, 10, 10));

                        Stage newWindow = new Stage();

                        AnchorPane anchorpane = new AnchorPane();

                        Label CreateFileLabel = new Label("View Old Report");
                        CreateFileLabel.setLayoutX(46);
                        CreateFileLabel.setLayoutY(47);
                        CreateFileLabel.setStyle("-fx-font: normal bold 36px 'arial';");

                        Label ReportLabel = new Label("Report:");
                        ReportLabel.setStyle("-fx-font: normal bold 16px 'arial';");
                        ReportLabel.setLayoutX(275);
                        ReportLabel.setLayoutY(120);

                        TextArea ReportArea = new TextArea();
                        ReportArea.setPrefHeight(200);
                        ReportArea.setPrefWidth(400);
                        ReportArea.setLayoutX(350);
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

                        Line horizontalline = new Line(50.0f, 0.0f, 750.0f, 0.0f);
                        horizontalline.setOpacity(.3);
                        horizontalline.setTranslateY(100);

                        Button showImage = new Button("Show Image");
                        showImage.setPrefHeight(42);
                        showImage.setPrefWidth(100);
                        showImage.setLayoutX(70);
                        showImage.setLayoutY(120);
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

                closedOrdersObservableList.add(
                        new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery, button));
            }

            OldOrdersPatients.setCellValueFactory(new PropertyValueFactory<>("patient"));

            OldOrdersModality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            OldOrdersNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));

            OldOrdersStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            OldOrdersResults.setCellValueFactory(new PropertyValueFactory<>("button"));

            OldOrdersTable.setItems(null);
            OldOrdersTable.setItems(closedOrdersObservableList);

            // Search Bar Functionality Start
            FilteredList<PlacedOrdersTableController> ClosedOrdersFilteredData = new FilteredList<>(
                    closedOrdersObservableList);

            ClosedOrdersSearch.textProperty().addListener((observable, oldValue, newValue) -> {
                ClosedOrdersFilteredData.setPredicate(TABLEPlacedOrdersTableController -> {
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

            SortedList<PlacedOrdersTableController> ClosedOrdersSortedData = new SortedList<>(
                    ClosedOrdersFilteredData);

            // Binds the sorted resultswith the Table
            ClosedOrdersSortedData.comparatorProperty().bind(OldOrdersTable.comparatorProperty());

            OldOrdersTable.setItems(ClosedOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}