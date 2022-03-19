
package com.example.application;



public class LoggedInUser {

 
    public String user_id;

    public LoggedInUser(String user_id) {

        this.user_id = user_id;

    }

    public String getCurrentUser() {

        return user_id;
    }

    public void setCurrentUser(String user_id) {
        this.user_id = user_id;
    }

}


