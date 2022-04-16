package com.example.application.TableConstructors;

import javafx.scene.control.Button;

public class ClosedOrders {

    //private String firstName = null;
    //private Integer patient = null;

    String patient;
    String modality;
    String notes;
    String status;
    Button button;

 
    public ClosedOrders(String patient, String modality, String notes, String status, Button button) {
        this.patient = patient;
        this.modality = modality;
        this.notes = notes;
        this.status = status;
        this.button = button;
    }

    public String getModality() {

        return modality;
    }
    public Button getButton() {

        return button;
    }

    public String getNotes() {

        return notes;
    }

    public String getStatus() {

        return status;
    }

    public String getPatient() {

        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
    public void setButton(Button button) {
        this.button = button;
    }
    public void setModality(String modality) {
        this.modality = modality;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    

    }