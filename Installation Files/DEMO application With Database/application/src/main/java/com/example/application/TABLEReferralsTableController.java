package com.example.application;

import java.sql.Date;

import javafx.scene.control.Button;

public class TABLEReferralsTableController {
    
    String firstname;
    String lastname;
    Date dob;    
    Button button;                         //price

    public TABLEReferralsTableController (Date dob, String firstname, String lastname, Button button){

        this.dob = dob;             
        this.firstname = firstname;
        this.lastname = lastname;
        this.button = button;
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
