package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class USER implements Initializable {

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
        FXApp.setRoot("USER");
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
        FXApp.setRoot("USER_UserInfo");
    }

    @FXML
    public void UserInfoButtonEntered() {

        UserInfoButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void UserInfoButtonExited() {

        UserInfoButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {

    }

}