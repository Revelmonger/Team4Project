
package com.example.application.TableConstructors;

import java.sql.Date;

import javafx.scene.control.Button;

public class TABLETodaysAppointmentsTableController {

    String patient;
    String modality;
    Date date_time; // price
    String radiologist;
    String price;
    Button button;

    public TABLETodaysAppointmentsTableController(String patient, String modality, Date date_time, String radiologist,
            String price, Button button) {

        this.patient = patient;
        this.modality = modality;
        this.date_time = date_time; // price
        this.radiologist = radiologist;
        this.price = price;
        this.button = button;
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

    public Button getButton() {
        return button;
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

    public void setButton(Button button) {
        this.button = button;
    }

}
