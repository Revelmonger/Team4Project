package com.example.application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection databaselink;

    public Connection getConnection() {
        String datbaseName = "db_ris";
        String datbaseUser = "root";
        String databasePassword = "doctor";

        String url = "jdbc:mysql://34.75.6.139:3306/" + datbaseName;

        try {

            databaselink = DriverManager.getConnection(url, datbaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaselink;

    }
}
