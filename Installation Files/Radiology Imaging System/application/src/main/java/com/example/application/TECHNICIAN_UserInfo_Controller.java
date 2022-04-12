package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TECHNICIAN_UserInfo_Controller extends EncryptDecrypt implements Initializable {
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
    private Button AppointmentsButton;
    @FXML
    private Button SaveButton;
    @FXML
    private TextField usernamefield;
    @FXML
    private TextField emailfield;
    @FXML
    private TextField displaynamefield;
    @FXML
    private TextField passwordfield;
    @FXML
    private ChoiceBox<String> userrollfield;
    @FXML
    private Label submitionresponcebutton;

    @FXML
    private AnchorPane BlurBox;

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
    public void LogoutButtonOnMouseEntered() {

        logoutButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void LogoutButtonOnMouseExited() {

        logoutButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

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
        FXApp.setRoot("TECHNICIAN");
    }

    public void userInfo(ActionEvent e) throws IOException {
        FXApp.setRoot("TECHNICIAN_UserInfo");
    }

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("TECHNICIAN_Apppointments");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String GetUserInfo = "select*from users as u join users_roles as ur on ur.user_id = u.user_id join roles as r on ur.role_id = r.role_id where u.user_id = "
                + userid + ";";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(GetUserInfo);

            while (queryOutput.next()) {

                String username = queryOutput.getString("username");
                String displayname = queryOutput.getString("full_name");
                String email = queryOutput.getString("email");
                String rolename = queryOutput.getString("name");
                String password = queryOutput.getString("password");

                usernamefield.setText(username);
                emailfield.setText(email);
                displaynamefield.setText(displayname);
                passwordfield.setText(Decrypt(password));

                userrollfield.getItems().add(rolename);

                userrollfield.setValue(rolename);

            }
        } catch (Exception e) {

        }

        SaveButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override

            public void handle(ActionEvent e) {

                if (usernamefield.getText().isEmpty() || emailfield.getText().isEmpty()
                        || displaynamefield.getText().isEmpty() || passwordfield.getText().isEmpty()) {

                }

                else {

                    String UpdateUserWithPassword = "update users set email = '" + emailfield.getText().trim()
                            + "', full_name = '" + displaynamefield.getText().trim() + "', username = '"
                            + usernamefield.getText().trim() + "', password = '"
                            + Encrypt(passwordfield.getText().trim()) + "' where user_id = " + userid + ";";
                    try {

                        Statement statement = connectDB.createStatement();

                        statement.execute(UpdateUserWithPassword);

                        Integer role_id;

                        String GetUserRole = "select * from users_roles where user_id = " + userid + ";";

                        try {

                            statement = connectDB.createStatement();
                            ResultSet queryOutput = statement.executeQuery(GetUserRole);

                            while (queryOutput.next()) {

                                role_id = queryOutput.getInt("role_id");

                                if (role_id == 6) {

                                    String UpdateRadiologistTable = "update radiologists set full_name = '"
                                            + displaynamefield.getText().trim() + "' where user_id = '" + userid + "';";

                                    statement.execute(UpdateRadiologistTable);
                                }

                                if (role_id == 3) {

                                    String UpdateReferralmdsTable = "update referralmds set full_name = '"
                                            + displaynamefield.getText().trim() + "' where user_id = '" + userid + "';";

                                    statement.execute(UpdateReferralmdsTable);
                                }

                            }
                        } catch (Exception e2) {
                        }

                        submitionresponcebutton.setText("Submission Successful");

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }

            }

        });

    }

}
