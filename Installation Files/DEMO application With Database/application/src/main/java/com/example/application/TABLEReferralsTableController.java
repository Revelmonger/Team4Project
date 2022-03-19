package com.example.application;

import java.sql.Date;

public class TABLEReferralsTableController {
    
    String firstname;
    String lastname;
    Date dob;                             //price

    public TABLEReferralsTableController (Date dob, String firstname, String lastname){

        this.dob = dob;             
        this.firstname = firstname;
        this.lastname = lastname;
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



    public void setFirstname(String firstname) {
    this.firstname = firstname;
    }

    public void setLastname(String lastname) {
    this.lastname = lastname;
    }

    public void setDob(Date dob) {
    this.dob = dob;
    }


}
