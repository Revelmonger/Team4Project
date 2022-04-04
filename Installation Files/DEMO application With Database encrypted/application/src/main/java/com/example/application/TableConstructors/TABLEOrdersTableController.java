
package com.example.application.TableConstructors;


import javafx.scene.control.Button;

public class TABLEOrdersTableController {
    
    Integer orderid;
    String patient;
    String referralDoctor;
    String modality;    
    String notes;
    String status;    
    Button button;                        

    public TABLEOrdersTableController (Integer orderid, String patient, String referralDoctor, String modality, String notes, String status, Button button){

        this.orderid = orderid;
        this.patient = patient;             
        this.referralDoctor = referralDoctor;
        this.modality = modality;
        this.notes = notes;
        this.status = status;
        this.button = button;
    }

   public Integer getOrderid() {
       return orderid;
   }

    public String getPatient() {

        return patient;
    }


    public String getReferraldoctor() {

        return referralDoctor;
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


    public Button getButton() {

        return button;
    }



    
    public void setOrderid(Integer orderid) {
       
        this.orderid = orderid;
    }

    public void setPatient(String patient) {
        
        this.patient = patient;
    }

    public void setReferraldoctor(String referralDoctor) {
        
        this.referralDoctor = referralDoctor;
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
    
    public void setButton(Button button) {
        
        this.button = button;
        }

}
