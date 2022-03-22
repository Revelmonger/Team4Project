
package com.example.application.TableConstructors;

public class TABLEUnscheduledOrdersTableController {

    String patient;
    String referral_md;
    String modality;
    String notes;

    public TABLEUnscheduledOrdersTableController(String patient, String referral_md, String modality, String notes) {

        this.patient = patient;
        this.referral_md = referral_md;
        this.modality = modality;
        this.notes = notes;
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

}
