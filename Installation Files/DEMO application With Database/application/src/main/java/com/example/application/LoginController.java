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


public class LoginController {

    Boolean CertifiedLoggedIn = false;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField NameField;

    @FXML
    private PasswordField PassField;

    @FXML
    private Label warningLabel;


public void connectButton(ActionEvent event) {
  
    DatabaseConnection connectNow = new DatabaseConnection();
    
    Connection connectDB = connectNow.getConnection(); 
    String connectQuery = "select * from db_ris.users where username = " + "'" + NameField.getText() + "'";


    try {
        
        Statement statement = connectDB.createStatement();
       if(NameField.getText().isEmpty() || PassField.getText().isEmpty()){
        warningLabel.setText("Please enter valid username and password!");
       }
        ResultSet queryOutput = statement.executeQuery(connectQuery);
        writeResultSet(queryOutput);

        
    } catch (Exception e) {
        e.getStackTrace();
    }

}   





private void writeResultSet(ResultSet resultSet) throws SQLException, IOException {
   
    while (resultSet.next()) {
       
         String password = resultSet.getString("password");
         if ( password.equals(PassField.getText())) {
           




            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection(); 
            String  loginQuery = "select * from db_ris.users where username = " + "'" + NameField.getText() + "'";
            try {
                Statement statement = connectDB.createStatement();             
                ResultSet queryOutput = statement.executeQuery(loginQuery);                 
                while (queryOutput.next()) {        
                String user_id = queryOutput.getString("user_id");
                queryOutput.close();
              


               
                loginQuery = "select * from db_ris.user_roles where user_id = " + user_id;
               
                try {
                   
                    connectNow = new DatabaseConnection();
                    connectDB = connectNow.getConnection(); 
                     statement = connectDB.createStatement();         

                    ResultSet queryOutput2 = statement.executeQuery(loginQuery); 
                    System.out.println("No");                
                    while (queryOutput.next()) {    
                        System.out.println("Hello");    
                    String role_id = queryOutput.getString("role_id");
                    queryOutput2.close();
                    System.out.println("World");
    
    
                    loginQuery = "select * from db_ris.roles where role_id = " + role_id;
                    try {
                        connectNow = new DatabaseConnection();
                        connectDB = connectNow.getConnection(); 
                        statement = connectDB.createStatement();             
                        ResultSet queryOutput3 = statement.executeQuery(loginQuery);                 
                        while (queryOutput.next()) {        
                        String role_name = queryOutput.getString("name");
                        queryOutput3.close();
                            
                        FXApp.setRoot(role_name);
        
        
        
        
        
        
                       
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





        }
        else{
        warningLabel.setText("Please enter valid username and password");
        }
            
    }
    
}
}



/*

/

             
    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection(); 
  
    String  loginQuery = "select users.username, users_roles.role_id, roles.name from users left join users_roles ON users.user_id = users_roles.user_id right join roles on roles.role_id = users_roles.role_idwhere username = " + "'" + NameField.getText() + "'";
        try {
            String role_id = resultSet.getString("role_id");
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(loginQuery);
            writeResultSet(queryOutput);
            FXApp.setRoot(role_id);

        } catch (Exception e) {

            e.getStackTrace();
        }       

*/