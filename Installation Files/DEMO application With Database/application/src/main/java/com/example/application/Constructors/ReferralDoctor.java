package com.example.application.Constructors;

public class ReferralDoctor {

    String Referraldoctor;
    Integer Referraldoctorid;

    public ReferralDoctor(String Referraldoctor, int Referraldoctorid) {
        this.Referraldoctor = Referraldoctor;
        this.Referraldoctorid = Referraldoctorid;
    }

    public String getReferraldoctor() {

        return Referraldoctor;
    }

    public Integer getReferraldoctorid() {
        return Referraldoctorid;
    }

}
