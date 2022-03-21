package com.example.application;

import javafx.scene.control.Button;

public class TABLEModalitiesTableController {

    Integer Modalityid;
    String Modalityname;
    String Modalityprice;
    Button Button;

    public TABLEModalitiesTableController(Integer Modalityid, String Modalityname, String Modalityprice,
            Button Button) {

        this.Modalityid = Modalityid;
        this.Modalityname = Modalityname;
        this.Modalityprice = Modalityprice;
        this.Button = Button;
    }

    public String getModalityname() {

        return Modalityname;
    }

    public String getModalityprice() {

        return Modalityprice;
    }

    public Button getButton() {

        return Button;
    }

    public Integer getModalityid() {

        return Modalityid;
    }

    public void setModalityid(Integer Modalityid) {
        this.Modalityid = Modalityid;
    }

    public void setModalityname(String Modalityname) {
        this.Modalityname = Modalityname;
    }

    public void setModalityprice(String Modalityprice) {
        this.Modalityprice = Modalityprice;
    }

    public void setButton(Button Button) {
        this.Button = Button;
    }

}
