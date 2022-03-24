
package com.example.application.TableConstructors;

import javafx.scene.control.Button;

public class TABLEReviewImagingOrdersTableController {

    String patient;
    Integer referral_md;
    Integer modality;
    String notes;
    Button button;

    public TABLEReviewImagingOrdersTableController(String patient, Integer referral_md, Integer modality, String notes, Button button) {

        this.patient = patient;
        this.referral_md = referral_md;
        this.modality = modality;
        this.notes = notes;
        this.button = button;
    }

    public TABLEReviewImagingOrdersTableController(Integer patientquery, Integer referral_mdquery, Integer modalityquery,
            Integer notesquery, Button button2) {
    }

    public Integer getModality() {

        return modality;
    }
    public Button getButton() {

        return button;
    }

    public String getNotes() {

        return notes;
    }

    public Integer getReferral_md() {

        return referral_md;
    }

    public String getPatient() {

        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public void setModality(Integer modality) {
        this.modality = modality;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setButton(Button button) {
        this.button = button;
    }
    public void setReferral_md(Integer referral_md) {
        this.referral_md = referral_md;
    }

}
