package com.example.application;

import java.sql.Date;

public class TABLEAllAppointmentsTableController {
    String patient;
    String modality;
    Date date_time;                           
    String radiologist;

    public TABLEAllAppointmentsTableController (String patient, String modality, Date date_time, String radiologist){

        this.patient = patient;
        this.modality = modality;
        this.date_time = date_time;             
        this.radiologist = radiologist;
    }

    public String getModality() {

        return modality;
    }


    public Date getDate_time() {

        return date_time;
    }

    public String getRadiologist() {

        return radiologist;
    }

    public String getPatient() {

        return patient;
    }


public void setPatient(String patient) {
    this.patient = patient;
}

public void setModality(String modality) {
    this.modality = modality;
}

public void setDate_time(Date date_time) {
    this.date_time = date_time;
}

public void setRadiologist(String radiologist) {
    this.radiologist = radiologist;
}

}
