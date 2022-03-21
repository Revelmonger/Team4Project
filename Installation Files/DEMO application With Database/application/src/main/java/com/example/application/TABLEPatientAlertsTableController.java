package com.example.application;

import javafx.scene.control.Button;

public class TABLEPatientAlertsTableController {

    Integer Alertid;
    String Alertname;
    Button Button;

    public TABLEPatientAlertsTableController(Integer Alertid, String Alertname, Button Button) {

        this.Alertid = Alertid;
        this.Alertname = Alertname;
        this.Button = Button;
    }

    public String getAlertname() {

        return Alertname;
    }

    public Button getButton() {

        return Button;
    }

    public Integer getAlertid() {

        return Alertid;
    }

    public void setAlertid(Integer Alertid) {
        this.Alertid = Alertid;
    }

    public void setAlertname(String Alertname) {
        this.Alertname = Alertname;
    }

    public void setButton(Button Button) {
        this.Button = Button;
    }
}
