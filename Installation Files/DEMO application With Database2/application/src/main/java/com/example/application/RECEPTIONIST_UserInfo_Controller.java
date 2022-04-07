package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.SubmissionPublisher;

import javax.persistence.criteria.Predicate.BooleanOperator;

import com.example.application.Constructors.Modalities;
import com.example.application.Constructors.OrderStatuses;
import com.example.application.Constructors.Patient;
import com.example.application.Constructors.ReferralDoctor;
import com.example.application.TableConstructors.TABLEReferralsTableController;

import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.*;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableValue;



public class RECEPTIONIST_UserInfo_Controller extends EncryptDecrypt implements Initializable {
    ObservableList<String> selectedItems;

    String userid = LOGIN.LoggedInUserID;
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
    @FXML
    private Button SaveButton;
    @FXML
    private TextField usernamefield;
    @FXML
    private TextField emailfield;
    @FXML
    private TextField displaynamefield;
    @FXML
    private TextField passwordfield;
    @FXML
    private ChoiceBox<String> userrollfield;
    @FXML
    private Label submitionresponcebutton;
    

    @FXML
    private AnchorPane BlurBox;

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

    /*
     * 
     * Button Logic
     * 
     */

    public void logout(ActionEvent e) throws IOException {

        FXApp.setRoot("LOGIN");
    }

    public void home(ActionEvent e) throws IOException {
        FXApp.setRoot("RECEPTIONIST");
    }

    public void userInfo(ActionEvent e) throws IOException {
        FXApp.setRoot("RECEPTIONIST_UserInfo");
    }



    public void orders(ActionEvent e) throws IOException {
        FXApp.setRoot("RECEPTIONIST_AllOrders");
    }

    public void appointments(ActionEvent e) throws IOException {
        FXApp.setRoot("RECEPTIONIST_Apppointments");
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String GetUserInfo = "select*from users as u join users_roles as ur on ur.user_id = u.user_id join roles as r on ur.role_id = r.role_id where u.user_id = " + userid + ";";

                
       
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(GetUserInfo);

            while(queryOutput.next()){

                String username = queryOutput.getString("username");
                String displayname = queryOutput.getString("full_name");
                String email = queryOutput.getString("email");
                String rolename = queryOutput.getString("name");
                String password = queryOutput.getString("password");
        
                usernamefield.setText(username);
                emailfield.setText(email);
                displaynamefield.setText(displayname);
                passwordfield.setText(Decrypt(password));
            

                userrollfield.getItems().add(rolename);

                userrollfield.setValue(rolename);

                

            }
        } catch (Exception e) {

        }





        SaveButton.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            
            public void handle(ActionEvent e){

                if(usernamefield.getText().isEmpty() || emailfield.getText().isEmpty() || displaynamefield.getText().isEmpty() || passwordfield.getText().isEmpty()){

                }

                else{

                    String UpdateUserWithPassword = "update users set email = '" + emailfield.getText().trim() + "', full_name = '" + displaynamefield.getText().trim() + "', username = '" + usernamefield.getText().trim() + "', password = '" + Encrypt(passwordfield.getText().trim()) + "' where user_id = " + userid + ";";
                try {

                    Statement statement = connectDB.createStatement();

                    statement.execute(UpdateUserWithPassword);
     



                    

                    Integer role_id ;

        String GetUserRole = "select * from users_roles where user_id = " + userid + ";"; 

        try {

            statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(GetUserRole);

            while(queryOutput.next()){

                role_id = queryOutput.getInt("role_id");

                if(role_id == 6){
                        
                    String UpdateRadiologistTable = "update radiologists set full_name = '" + displaynamefield.getText().trim() + "' where user_id = '" + userid + "';";
                    
                    statement.execute(UpdateRadiologistTable);
                }

                if(role_id == 3){
                    
                    String UpdateReferralmdsTable = "update referralmds set full_name = '" + displaynamefield.getText().trim() + "' where user_id = '" + userid + "';";
                    
                    statement.execute(UpdateReferralmdsTable);
                }


            }
    } catch (Exception e2) {
    }     

                submitionresponcebutton.setText("Submission Successful");
                   
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                }

                

                
                
            }
        

            

        });


     

    }


}
