package com.example.application.TableConstructors;

import javafx.scene.control.Button;

public class TABLEFileUploadsTableController {
    
Integer uploadid;
String filename;
String filetype;
Integer ordernumber;
Boolean isopen;
Button button;




public TABLEFileUploadsTableController(Integer uploadid, String filename, String filetype, Integer ordernumber, Boolean isopen, Button button) {

this.uploadid = uploadid;
this.filename = filename;
this.filetype = filetype;
this.ordernumber = ordernumber;
this.isopen = isopen;
this.button = button;

}

public Integer getUploadid() {
    return uploadid;
}

public String getFilename() {
    return filename;
}

public String getFiletype() {
    return filetype;
}

public Integer getOrdernumber() {
    return ordernumber;
}

public Boolean getIsopen() {
    return isopen;
}

public Button getButton() {
    return button;
}

public void setUploadid(Integer uploadid) {
    this.uploadid = uploadid;
}

public void setFilename(String filename) {
    this.filename = filename;
}

public void setFiletype(String filetype) {
    this.filetype = filetype;
}

public void setOrdernumber(Integer ordernumber) {
    this.ordernumber = ordernumber;
}

public void setIsopen(Boolean isopen) {
    this.isopen = isopen;
}

public void setButton(Button button) {
    this.button = button;
}



}
