package com.example.application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.example.application.TableConstructors.TABLEReviewImagingOrdersTableController;
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

public class RADIOLOGIST implements Initializable {

    @FXML
    private ScrollPane BlurBox;

    String user_id1 = LOGIN.LoggedInUserID;

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
        FXApp.setRoot("RADIOLOGIST");
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

        FXApp.setRoot("RADIOLOGIST_UserInfo");
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
        FXApp.setRoot("RADIOLOGIST_Apppointments");
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
        FXApp.setRoot("RADIOLOGIST_AllOrders");
    }

    @FXML
    public void OrdersButtonEntered() {

        OrdersButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void OrdersButtonExited() {

        OrdersButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    /*
     * 
     * Review Imaging Orders Imports
     * 
     */

    @FXML
    private TableView<TABLEReviewImagingOrdersTableController> ReviewImagingOrdersTable;

    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_Patient;

    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_RefferalMD;

    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_Modality;

    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, String> ReviewImagingOrdersTable_Notes;

    @FXML
    private TextField searchReviewImagineOrders;
    @FXML
    private TableColumn<TABLEReviewImagingOrdersTableController, Button> ReviewOrderColumn;

    ObservableList<TABLEReviewImagingOrdersTableController> ReviewImagingOrdersObservableList = FXCollections
            .observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        /*
         * 
         * Review Imaging Orders Table
         * 
         */
        String ReviewImagingOrdersTableQuery = "select * from orders as o join patients as p on p.patient_id = o.patient join appointments as a on a.appointment_id = o.appointment join modalities as m on m.modality_id = o.modality join referralmds as rmd on rmd.id = o.referral_md join radiologists as r on r.id = a.radiologist where a.closed = true and report IS NULL and r.user_id = "
                + user_id1 + ";";
        try {

            Statement statement5 = connectDB.createStatement();
            ResultSet queryOutput = statement5.executeQuery(ReviewImagingOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String referral_mdquery = queryOutput.getString("full_name");
                Integer radiologistID = queryOutput.getInt("radiologist");
                String modalityquery = queryOutput.getString("name"); // might need to change types
                String notesquery = queryOutput.getString("notes");
                Button button = new Button("Review Order");
                Integer OrderID = queryOutput.getInt("order_id");
                Integer patientID = queryOutput.getInt("patient");
                button.setStyle(
                        "-fx-font: normal bold 16px 'arial'; -fx-background-color: transparent; -fx-text-fill: #001eff;");

            
                button.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        BlurBox.setEffect(new BoxBlur(5, 10, 10));

                        Stage newWindow = new Stage();

                        AnchorPane anchorpane = new AnchorPane();

                        Label CreateFileLabel = new Label("Create Diagnostic Report");
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
                   

                        Button CreateDiagnosticReportButton = new Button("Create Report");
                        CreateDiagnosticReportButton.setPrefHeight(42);
                        CreateDiagnosticReportButton.setPrefWidth(102);
                        CreateDiagnosticReportButton.setLayoutX(565);
                        CreateDiagnosticReportButton.setLayoutY(338);
                        CreateDiagnosticReportButton.setStyle("-fx-background-color: #566aff; -fx-text-fill: white;");

                        CreateDiagnosticReportButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {

                                if (ReportArea.getText().isEmpty()) {

                                }

                                else {

                                    try {
                                        DatabaseConnection connectNow = new DatabaseConnection();
                                        Connection connectDB = connectNow.getConnection();

                                        String InsertIntoOrdersReport = "update orders set report = '1', status = '3' where order_id = '"
                                                + OrderID + "';";

                                        String InsertIntoUsersTableQuery = "insert into diagnostic_reports (order_id,  patient,radiologist, diagnostic) values ('"
                                                + OrderID + "', '" + patientID + "', '" + radiologistID + "', '"
                                                + ReportArea.getText().trim() + "');";
                                        Statement statement = connectDB.createStatement();
                                        Statement statement2 = connectDB.createStatement();

                                        statement.execute(InsertIntoUsersTableQuery);

                                        statement2.execute(InsertIntoOrdersReport);

                                        Stage stage = (Stage) CreateDiagnosticReportButton.getScene().getWindow();

                                        stage.close();
                                        BlurBox.setEffect(new BoxBlur(0, 0, 0));

                                        FXApp.setRoot("RADIOLOGIST");

                                    } catch (SQLException e2) {

                                        e2.printStackTrace();
                                    } catch (IOException e1) {

                                        e1.printStackTrace();
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

                            }
                        });

                        anchorpane.getChildren().add(CreateFileLabel);

                        anchorpane.getChildren().add(horizontalline);

                        anchorpane.getChildren().add(CancelButton);
                        anchorpane.getChildren().add(CreateDiagnosticReportButton);
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

                ReviewImagingOrdersObservableList.add(new TABLEReviewImagingOrdersTableController(patientquery,
                        referral_mdquery, modalityquery, notesquery, button));
            }

            ReviewImagingOrdersTable_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            ReviewImagingOrdersTable_RefferalMD.setCellValueFactory(new PropertyValueFactory<>("referral_md"));

            ReviewImagingOrdersTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

            ReviewImagingOrdersTable_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
            ReviewOrderColumn.setCellValueFactory(new PropertyValueFactory<>("button"));

            ReviewImagingOrdersTable.setItems(null);
            ReviewImagingOrdersTable.setItems(ReviewImagingOrdersObservableList);

            // Search Bar Functionality Start
            FilteredList<TABLEReviewImagingOrdersTableController> ReviewImagingOrdersFilteredData = new FilteredList<>(
                    ReviewImagingOrdersObservableList);

            searchReviewImagineOrders.textProperty().addListener((observable, oldValue, newValue) -> {
                ReviewImagingOrdersFilteredData.setPredicate(TABLEReviewImagingOrdersTableController -> {
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (TABLEReviewImagingOrdersTableController.getPatient().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else if (TABLEReviewImagingOrdersTableController.getNotes().toLowerCase()
                            .indexOf(searchKeyword) > -1) {
                        return true;

                    } else {
                        return false; // no match found
                    }

                });

            });

            SortedList<TABLEReviewImagingOrdersTableController> ReviewImagingOrdersSortedData = new SortedList<>(
                    ReviewImagingOrdersFilteredData);

            // Binds the sorted resultswith the Table
            ReviewImagingOrdersSortedData.comparatorProperty().bind(ReviewImagingOrdersTable.comparatorProperty());

            ReviewImagingOrdersTable.setItems(ReviewImagingOrdersSortedData);
            // Search Bar Functionality End

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}