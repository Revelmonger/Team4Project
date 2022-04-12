
package com.example.application.TableConstructors;

import java.sql.Date;

import javafx.scene.control.Button;

public class TABLECheckedInAppointmentsTableController {

    String patient;
    String modality;
    String price;
    Date date_time; // price
    String radiologist;
    Boolean bool;
    String inprogress;

    public TABLECheckedInAppointmentsTableController(String patient, String modality, Date date_time, String radiologist, String price, Boolean bool, String inprogress) {

        this.patient = patient;
        this.modality = modality;
        this.date_time = date_time; // price
        this.radiologist = radiologist;
        this.price = price;
        this.bool = bool;
        this.inprogress = inprogress;
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

    public String getPrice() {

        return price;
    }

    public String getPatient() {

        return patient;
    }

    public String getInprogress() {
        return inprogress;
    }
   
    
    public Boolean getBool() {

        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
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

    public void setPrice(String price) {
        this.price = price;
    }

    public void setInprogress(String inprogress) {
        this.inprogress = inprogress;
    }
 
}
