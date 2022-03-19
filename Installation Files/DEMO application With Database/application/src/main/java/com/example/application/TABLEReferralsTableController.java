package com.example.application;

import java.sql.Date;

public class TABLEReferralsTableController {
    
    String firstname;
    String lastname;
    Date dob;                             //price

    public TABLEReferralsTableController (Date dob, String firstname, String lastname){

        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;             
    }

    public String getFirstName() {

        return firstname;
    }


    public Date getDOB() {

        return dob;
    }

    public String getLastName() {

        return lastname;
    }



public void setFirstName(String firstname) {
    this.firstname = firstname;
}

public void setLastName(String lastname) {
    this.lastname = lastname;
}

public void setDOB(Date dob) {
    this.dob = dob;
}


}
