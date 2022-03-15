package com.example.application;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class Controller implements Initializable {

    @FXML
    private Button Login_ButtonID;

    @FXML
    private TextField UsernameFieldID;

    @FXML
    private PasswordField PasswordFieldID;
    



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Login_ButtonID.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              
                    try {
                        DBUtils.LogInUser(event, UsernameFieldID.getText(), PasswordFieldID.getText());
                    } catch (IOException e) {
                        
                        System.out.println("error!!!!!!!!!!!!!!!!!!!!!!!");
                        /*e.printStackTrace();*/
                    }
               
            }
        });

    }
    
}
