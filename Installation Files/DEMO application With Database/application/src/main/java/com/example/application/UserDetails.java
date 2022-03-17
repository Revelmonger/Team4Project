package com.example.application;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class UserDetails {

    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty department;

    // Default Constructor
    public UserDetails(String name, String email, String department) {
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.department = new SimpleStringProperty(department);
    }

    // Getters
    public String getName() {

        return name.get();
    }

    public String getEmail() {

        return email.get();
    }

    public String getDepartment() {

        return department.get();
    }

    // Setters
    public void setName(String value) {
        name.set(value);
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public void setDepartment(String value) {
        department.set(value);
    }

    // Property values
    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty DepartmentProperty() {
        return department;
    }
}
