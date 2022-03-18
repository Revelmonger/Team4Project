
package com.example.application;

import java.sql.Date;

public class TABLECheckedInAppointmentsTableController {

    Integer patient;
    Integer modality;
    Date date_time;                             //price
    Integer radiologist;
    Integer technician;

    public TABLECheckedInAppointmentsTableController (Integer patient, Integer modality, Date date_time, Integer radiologist, Integer technician){

        this.patient = patient;
        this.modality = modality;
        this.date_time = date_time;             //price
        this.radiologist = radiologist;
        this.technician = technician;
    }

    public Integer getModality() {

        return modality;
    }


    public Date getDate_time() {

        return date_time;
    }

    public Integer getRadiologist() {

        return radiologist;
    }

    public Integer getTechnician() {

        return technician;
    }

    public Integer getPatient() {

        return patient;
    }


public void setPatient(Integer patient) {
    this.patient = patient;
}

public void setModality(Integer modality) {
    this.modality = modality;
}

public void setDate_time(Date date_time) {
    this.date_time = date_time;
}

public void setRadiologist(Integer radiologist) {
    this.radiologist = radiologist;
}

public void setTechnician(Integer technician) {
    this.technician = technician;
}


}
