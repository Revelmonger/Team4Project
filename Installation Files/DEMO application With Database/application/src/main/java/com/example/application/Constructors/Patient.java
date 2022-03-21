package com.example.application.Constructors;

public class Patient {

  Integer patient_id;
  String first_name;
  String last_name;

    public Patient(int patient_id, String first_name, String last_name) {

       
        this.patient_id = patient_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    

    public Integer getPatientid() {

        return patient_id;
    }


    public String getFirstname() {

        return first_name;
    }

    public String getLastname() {

        return last_name;
    }

    


public void setPatient(Integer patient_id) {
    this.patient_id = patient_id;
}

public void setModality(String first_name) {
    this.first_name = first_name;
}

public void setNotes(String last_name) {
    this.last_name = last_name;
}



}