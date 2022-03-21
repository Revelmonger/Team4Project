package com.example.application;

public class TABLEPlacedOrdersTableController {

    String patient;
    String modality;
    String notes;
    String status;

    public TABLEPlacedOrdersTableController(String patient, String modality, String notes, String status) {

        this.patient = patient;
        this.modality = modality;
        this.notes = notes;
        this.status = status;
    }

    public String getModality() {

        return modality;
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
