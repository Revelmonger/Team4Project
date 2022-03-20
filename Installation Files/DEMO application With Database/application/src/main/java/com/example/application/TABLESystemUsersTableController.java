package com.example.application;

import javafx.scene.control.Button;

public class TABLESystemUsersTableController {
    
    Integer userID;
    String username;
    String displayname;
    String email;
    String role;    
    Button button;                       

    public TABLESystemUsersTableController (Integer userID, String username, String displayname, String  email, String role, Button button){
             
        this.userID = userID;
        this.username = username;
        this.displayname = displayname;
        this.email = email;
        this.role = role;
        this.button = button;
    }

    public Integer getUserID() {

        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayname() {
        return displayname;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public Button getButton() {

        return button;
    }



    

    public void setUserID(Integer userID) {
    this.userID = userID;
    }

    public void setUsername(String username) {
    this.username = username;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setButton(Button button) {
        this.button = button;
        }
}
