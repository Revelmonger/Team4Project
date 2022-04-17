package com.example.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LOGIN extends EncryptDecrypt{

    Boolean CertifiedLoggedIn = false;

    public static String LoggedInUserID = "";

    @FXML
    private Button LoginButton;

    @FXML
    private TextField NameField;

    @FXML
    private PasswordField PassField;

    @FXML
    private Label warningLabel;

    @FXML
    private Button CloseApplicationButton;

    public void CloseApplication(ActionEvent event) {
        Stage stage = (Stage) CloseApplicationButton.getScene().getWindow();

        stage.close();

    }

    public void connectButton(ActionEvent event) {

        DatabaseConnection connectNow = new DatabaseConnection();

        Connection connectDB = connectNow.getConnection();
        String connectQuery = "select * from db_ris.users where username = " + "'" + NameField.getText() + "'";

        try {

            Statement statement = connectDB.createStatement();
            if (NameField.getText().isEmpty() || PassField.getText().isEmpty()) {
                warningLabel.setText("Please enter valid username and password!");
            }
            ResultSet queryOutput = statement.executeQuery(connectQuery);
            writeResultSet(queryOutput);

            connectDB.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    private void writeResultSet(ResultSet resultSet) throws SQLException, IOException {

        while (resultSet.next()) {

            String password = resultSet.getString("password");
         
            if (Decrypt(password).equals(PassField.getText())) {

                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                String loginQuery = "select user_id from db_ris.users where username = " + "'" + NameField.getText()
                        + "'";
                try {
                    Statement statement = connectDB.createStatement();
                    ResultSet queryOutput = statement.executeQuery(loginQuery);
                    while (queryOutput.next()) {
                        String user_id = queryOutput.getString("user_id").trim();
                        LoggedInUserID = user_id;
                        queryOutput.close();

                        loginQuery = "select role_id from db_ris.users_roles where user_id = " + "'" + user_id + "'";
                        try {
                            statement = connectDB.createStatement();
                            queryOutput = statement.executeQuery(loginQuery);
                            while (queryOutput.next()) {
                                String role_id = queryOutput.getString("role_id").trim();

                                queryOutput.close();

                                loginQuery = "select name from db_ris.roles where role_id = " + "'" + role_id + "'";
                                try {
                                    statement = connectDB.createStatement();
                                    queryOutput = statement.executeQuery(loginQuery);
                                    while (queryOutput.next()) {
                                        String role_name = queryOutput.getString("name").trim();

                                        queryOutput.close();

                                        try {
                                            FXApp.setRoot(role_name);

                                        } catch (Exception e) {
                                            e.getStackTrace();
                                        }

                                    }
                                } catch (Exception e) {
                                    e.getStackTrace();
                                }

                            }
                        } catch (Exception e) {
                            e.getStackTrace();
                        }

                    }
                } catch (Exception e) {
                    e.getStackTrace();
                }

                connectDB.close();
            } else {
                warningLabel.setText("Please enter valid username and password");
            }

        }

    }
}
