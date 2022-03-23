package com.example;

import javafx.application.Application;

import com.example.application.FXApp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FXApp_Springboot {
    public static void main(String[] args) {
        Application.launch(FXApp.class, args);
    }
}
