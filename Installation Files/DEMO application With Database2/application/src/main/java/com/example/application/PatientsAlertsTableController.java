package com.example.application;

public class PatientsAlertsTableController {

    private String firstName = null;

    public PatientsAlertsTableController() {
    }

    public PatientsAlertsTableController(String firstName) {
        this.firstName = firstName;
  
    }

  
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   
    }
