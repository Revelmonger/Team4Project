package com.example.application;

public class AllAlertsChoiceBoxController {
    String alertName;
    Integer alertdId;

    public AllAlertsChoiceBoxController(int alertdId, String alertName) {
        this.alertName = alertName;
        this.alertdId = alertdId;
    }

    public String getalertName() {
        return alertName;
    }

    public Integer getalertId() {
        return alertdId;
    }

}
