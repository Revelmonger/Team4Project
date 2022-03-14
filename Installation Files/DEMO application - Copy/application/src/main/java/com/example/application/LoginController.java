package com.example.application;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {


    //IF USER IS VALIDATED CALL THIS FUNCTION TO SWITCH SCENES TO THE VALIDATED USER
    @FXML
    private void switchToSecondary() throws IOException {

        /*
            Pull Username and password from FXML forms into controler
            Query Databse for users with a matching pair username and passworrd returning the primary key
            Query Database for user_role associated with the users primary key
            Once we know the user Role we can populate the setRoot command with the appropriate string name associated with the user_role's fxml file
        */





        FXApp.setRoot("USER"); // set root to a diffrent fxml file depending on the credentials entered is user_role = admin input admininto .setRoot
    }
}
