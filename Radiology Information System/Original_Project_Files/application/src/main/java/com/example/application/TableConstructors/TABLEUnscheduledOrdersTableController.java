
package com.example.application.TableConstructors;

import javafx.scene.control.Button;

public class TABLEUnscheduledOrdersTableController {

    String patient;
    String referral_md;
    String modality;
    String notes;
    Button button;

    public TABLEUnscheduledOrdersTableController(String patient, String referral_md, String modality, String notes, Button button) {

        this.patient = patient;
        this.referral_md = referral_md;
        this.modality = modality;
        this.notes = notes;
        this.button = button;
    }

    public String getModality() {

        return modality;
    }

    public String getNotes() {

        return notes;
    }

    public String getReferral_md() {

        return referral_md;
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

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setReferral_md(String referral_md) {
        this.referral_md = referral_md;
    }

    public void setButton(Button button) {
        this.button = button;
    }

}
