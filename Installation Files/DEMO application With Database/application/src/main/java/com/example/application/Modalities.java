package com.example.application;

public class Modalities {
    String Modalityname;
    Integer int1;

    public Modalities(int int1, String Modalityname) {
        this.Modalityname = Modalityname;
        this.int1 =int1;
    }


    public String getModalityname() {
        return Modalityname;
    }

    public Integer getModalityID() {
        return int1;
    }


}
