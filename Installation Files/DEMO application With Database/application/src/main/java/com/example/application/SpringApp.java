package com.example.application;


import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringApp {
    public static void main(String[] args) {
        Application.launch(FXApp.class, args);
    }
}


