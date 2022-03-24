package com.example.application.TableConstructors;

import javafx.scene.control.Button;

public class TABLEDiagnosticReportsTableController {

Integer reportid;
String radiologist;
Integer ordernumber;
String report;
Button button;



public TABLEDiagnosticReportsTableController(Integer reportid, String radiologist, Integer ordernumber, String report, Button button) {

this.reportid = reportid;
this.radiologist = radiologist;
this.ordernumber = ordernumber;
this.report = report;
this.button = button;


}

public Integer getReportid() {
    return reportid;
}

public String getRadiologist() {
    return radiologist;
}

public Integer getOrdernumber() {
    return ordernumber;
}

public String getReport() {
    return report;
}

public Button getButton() {
    return button;
}


public void setReportid(Integer reportid) {
    this.reportid = reportid;
}

public void setRadiologist(String radiologist) {
    this.radiologist = radiologist;
}

public void setOrdernumber(Integer ordernumber) {
    this.ordernumber = ordernumber;
}

public void setReport(String report) {
    this.report = report;
}

public void setButton(Button button) {
    this.button = button;
}












    
}
