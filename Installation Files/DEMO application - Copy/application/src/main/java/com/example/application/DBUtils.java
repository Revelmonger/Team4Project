package com.example.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class DBUtils {


   
    @FXML
    public static void LogInUser(ActionEvent event, String username, String password) throws IOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_ris","root","0288" );
                preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
                preparedStatement.setString(1, username);
                resultSet =  preparedStatement.executeQuery();               
                if (!resultSet.isBeforeFirst()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Provided credentials are incorrect");
                    alert.show();    
                } else {
                    while (resultSet.next()) {
                        String retrievedPassword = resultSet.getString("password");
                        if (retrievedPassword.equals(password)) {
                            //Type code here that finds the user_role and usethat in fxml
                            FXApp.setRoot("USER");
                        }
                    }
                }

        }  catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
