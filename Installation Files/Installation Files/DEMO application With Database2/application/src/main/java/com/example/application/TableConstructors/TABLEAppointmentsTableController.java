package com.example.application.TableConstructors;

import java.sql.Date;

import javafx.scene.control.Button;

public class TABLEAppointmentsTableController {
    
    Integer appointmentId;
    String patient;
    Integer ordernumber;
    Date dateTime;
    String radiologist;
    Button button;                       

    public TABLEAppointmentsTableController (Integer appointmentId, String patient, Integer ordernumber, Date dateTime, String radiologist, Button button){

        this.appointmentId = appointmentId;
        this.patient = patient;             
        this.ordernumber = ordernumber;
        this.radiologist = radiologist;
        this.button = button;
        this.dateTime = dateTime;
    }

   public Integer getAppointmentid() {
       return appointmentId;
   }

    public String getPatient() {

        return patient;
    }


    public Integer getOrdernumber() {

        return ordernumber;
    }

    public Date getDatetime() {

        return dateTime;
    }

    public String getRadiologist() {

        return radiologist;
    }


    public Button getButton() {

        return button;
    }



    
public void setAppointmentid(Integer appointmentId) {
       
        this.appointmentId = appointmentId;
}

public void setPatient(String patient) {
        
        this.patient = patient;
}

public void setOrdernumber(Integer ordernumber) {
        
        this.ordernumber = ordernumber;
}

public void setDatetime(Date dateTime) {
        
        this.dateTime = dateTime;
}

public void setRadiologist(String radiologist) {
        
        this.radiologist = radiologist;
}
    
public void setButton(Button button) {
        
        this.button = button;
}

}

