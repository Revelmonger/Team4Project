package com.example.application;

import javafx.scene.control.Button;

public class TABLESystemUsersTableController {

    Integer Userid;
    String Username;
    String Displayname;
    String Email;                           
    String Role;
    Button Button;

    public TABLESystemUsersTableController (Integer Userid, String Username, String Displayname, String Email, String Role, Button Button){

        this.Userid = Userid;
        this.Username = Username;
        this.Displayname = Displayname;            
        this.Email = Email;
        this.Role = Role;
        this.Button = Button;
    }

    public String getUsername() {

        return Username;
    }


    public String getDisplayname() {

        return Displayname;
    }

    public String getEmail() {

        return Email;
    }

    public String getRole() {

        return Role;
    }

    public Integer getUserid() {

        return Userid;
    }

    public Button getButton() {
        return Button;
    }


public void setUserid(Integer Userid) {
    this.Userid = Userid;
}

public void setUsername(String Username) {
    this.Username = Username;
}

public void setDisplayname(String Displayname) {
    this.Displayname = Displayname;
}

public void setEmail(String Email) {
    this.Email = Email;
}

public void setRole(String Role) {
    this.Role = Role;
}

public void setButton(Button Button) {
    this.Button = Button;
}
}
