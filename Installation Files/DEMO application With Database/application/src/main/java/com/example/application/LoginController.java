package com.example.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField UserField;

    @FXML
    private PasswordField PassField;


public void connectButton(ActionEvent event) {
  
    DatabaseConnection connectNow = new DatabaseConnection();
    
    Connection connectDB = connectNow.getConnection(); 
    String connectQuery = "select * from db_ris.users where username = 'doc'"; //+ "'" + UserField.getText() + "'";


    try {
        
        Statement statement = connectDB.createStatement();
       
        ResultSet queryOutput = statement.executeQuery(connectQuery);
        writeResultSet(queryOutput);

        
    } catch (Exception e) {
       System.out.println("error");
        e.getStackTrace();
    }


}   
private void writeResultSet(ResultSet resultSet) throws SQLException, IOException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
       
        String password = resultSet.getString("password");
    
        System.out.println("password: " + password);
        System.out.println(PassField.getText());
       
        if ( password.equals(PassField.getText())) {
            FXApp.setRoot("USER");
        }
    }
}



}
