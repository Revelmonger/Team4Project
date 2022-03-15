package com.example.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class LoginController {

    @FXML
    private Button LoginButton;

public void connectButton(ActionEvent event) {
  
    DatabaseConnection connectNow = new DatabaseConnection();
    
    Connection connectDB = connectNow.getConnection(); 
    String connectQuery = "SELECT * FROM users";
  

    try {
        
        Statement statement = connectDB.createStatement();
       
        ResultSet queryOutput = statement.executeQuery(connectQuery);
       System.out.println(queryOutput);
    } catch (Exception e) {
       System.out.println("error");
        e.getStackTrace();
    }


}   


}
