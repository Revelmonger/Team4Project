package com.example.application;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;
import java.io.IOException;

public class FXApp extends Application {


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

   
        scene = new Scene(loadFXML("login"), 640, 480);

        //THIS CODE CLOSES THE STAGE WHEN ESCAPE IS PRESSED ~Chase//
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event){

                switch(event.getCode()){
                    case ESCAPE:
                    stage.close();
                    break;
                }
            }
        });




       
        stage.setTitle("RIS");
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    
    }




    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXApp.class.getResource(fxml + ".fxml"));
        
        return fxmlLoader.load();
    }
    


    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        
    }
}