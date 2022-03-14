package com.example.application;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {


    //IF USER IS VALIDATED CALL THIS FUNCTION TO SWITCH SCENES TO THE VALIDATED USER
    @FXML
    private void switchToSecondary() throws IOException {
        FXApp.setRoot("secondary");
    }
}
