package com.example.application;

import java.sql.Date;

import javafx.scene.control.Button;

public class TABLEPatientsTableController {
    
    Integer patientID;
    String firstname;
    String lastname;
    Date dob;    
    Button button;                       

    public TABLEPatientsTableController (Integer patientID, Date dob, String firstname, String lastname, Button button){

        this.patientID = patientID;
        this.dob = dob;             
        this.firstname = firstname;
        this.lastname = lastname;
        this.button = button;
    }

   public Integer getPatientID() {
       return patientID;
   }

    public String getFirstname() {

        return firstname;
    }


    public Date getDob() {

        return dob;
    }

    public String getLastname() {

        return lastname;
    }

    public Button getButton() {

        return button;
    }



    
    public void setPatientID(Integer patientID) {
       
        this.patientID = patientID;
    }

    public void setFirstname(String firstname) {
        
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        
        this.lastname = lastname;
    }

    public void setDob(Date dob) {
        
        this.dob = dob;
    }
    
    public void setButton(Button button) {
        
        this.button = button;
        }

}
