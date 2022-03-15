package com.example.application;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    
public Connection databaselink;


    public Connection getConnection(){
        String datbaseName = "db_ris";
        String datbaseUser = "root";
        String databasePassword = "0288";

        String url = "jdbc:mysql://localhost/" + datbaseName; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, datbaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaselink;


    }
}
