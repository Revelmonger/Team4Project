package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

public class ADMIN_AdminPanel_Controller implements Initializable{

   
    String user_id1 = LoginController.LoggedInUserID;
   
    
    /*
     * 
     * Button Imports
     * 
     */
    @FXML
    private Button logoutButton;
    @FXML
    private Button HomeButton;
    @FXML
    private Button UserInfoButton;
    @FXML
    private Button AdminButton;
    @FXML
    private Button ReferralsButton;
    @FXML
    private Button AppointmentsButton;
    @FXML
    private Button OrdersButton;


     /*
     * 
     * Button Logic
     * 
     */

    public void logout(ActionEvent e) throws IOException {
       
        FXApp.setRoot("LOGIN");
    }

    public void home(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN");
    }

    public void userInfo(ActionEvent e) throws IOException {
        System.out.println("The Current user is " + user_id1);
        FXApp.setRoot("LOGIN");
    }

    public void admin(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_AdminPanel");
    }

    public void referrals(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_Referrals");
    }

    public void orders(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMIN_AllOrders");
    }

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("ADMINAPPOINTMENTS");
    }

    /*
     * 
     * Button Listener Events
     * 
     */

    @FXML
    public void HomeButtonEntered() {
       
        HomeButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void HomeButtonExited() {

        HomeButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void UserInfoButtonEntered() {

        UserInfoButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void UserInfoButtonExited() {

        UserInfoButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void AdminButtonEntered() {

        AdminButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void AdminButtonExited() {

        AdminButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void ReferralsButtonEntered() {

        ReferralsButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void ReferralsButtonExited() {

        ReferralsButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void AppointentsButtonEntered() {

        AppointmentsButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void AppointmentsButtonExited() {

        AppointmentsButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void OrdersButtonEntered() {

        OrdersButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void OrdersButtonExited() {

        OrdersButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    public void LogoutButtonOnMouseEntered() {

        logoutButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
    }

    @FXML
    public void LogoutButtonOnMouseExited() {

        logoutButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");

    }

    @FXML
    private TableView<TABLESystemUsersTableController> SystemUsersTable;

    @FXML
    private TableColumn<TABLESystemUsersTableController, Integer> Users_UserId;

    @FXML
    private TableColumn<TABLESystemUsersTableController, String> UsersUsername;

    @FXML
    private TableColumn<TABLESystemUsersTableController, String> UsersDisplayName;

    @FXML
    private TableColumn<TABLESystemUsersTableController, String> UsersEmail;

    @FXML
    private TableColumn<TABLESystemUsersTableController, Integer> UsersRole;

    @FXML
    private TableColumn<TABLESystemUsersTableController, Button> ModifyButton;

    @FXML
    private TextField searchUsers;

    ObservableList<TABLESystemUsersTableController> UsersTableObservableList = FXCollections
            .observableArrayList();


   
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        

        String UsersTableQuery = "select u.user_id, u.full_name, u.username, u.email, ur.role_id, r.name from users as u left join users_roles as ur on ur.user_id = u.user_id left join roles as r on r.role_id = ur.role_id;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(UsersTableQuery);

            while (queryOutput.next()) {
            
                Integer userIDquery = queryOutput.getInt("user_id");
                String usernamequery = queryOutput.getString("username");
                String displaynamequery = queryOutput.getString("full_name");
                String emailquery = queryOutput.getString("email");
                String rolequery = queryOutput.getString("name");
                Button button = new Button("Modify");
            
                UsersTableObservableList.add(
                                new TABLESystemUsersTableController(userIDquery, usernamequery, displaynamequery, emailquery, rolequery, button));
            }

            Users_UserId.setCellValueFactory(new PropertyValueFactory<>("userID"));
            UsersUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
            UsersDisplayName.setCellValueFactory(new PropertyValueFactory<>("displayname"));
            UsersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            UsersRole.setCellValueFactory(new PropertyValueFactory<>("role"));
            ModifyButton.setCellValueFactory(new PropertyValueFactory<>("button"));

            
            SystemUsersTable.setItems(null);
            SystemUsersTable.setItems(UsersTableObservableList);


        } catch (Exception e) {
            System.out.println("error");
        }
    }



   
    
}
