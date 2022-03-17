package com.example.application;




public class PlacedOrdersTableController {

    Integer patient;
    Integer modality;
    String notes;
    Integer status;

    public PlacedOrdersTableController (Integer patient, Integer modality, String notes, Integer status){

        this.patient = patient;
        this.modality = modality;
        this.notes = notes;
        this.status = status;
    }

    public Integer getModality() {

        return modality;
    }


    public String getNotes() {

        return notes;
    }

    public Integer getStatus() {

        return status;
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

public void setNotes(String notes) {
    this.notes = notes;
}

public void setStatus(Integer status) {
    this.status = status;
}


}
