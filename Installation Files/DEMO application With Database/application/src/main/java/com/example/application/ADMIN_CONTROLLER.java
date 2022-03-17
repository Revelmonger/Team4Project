package com.example.application;




import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ADMIN_CONTROLLER  implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TableView<UserDetails> tableUser;

    @FXML
    private TableColumn<UserDetails, String> columnName;

    @FXML
    private TableColumn<UserDetails, String> columnEmail;

    @FXML
    private TableColumn<UserDetails, String> columnDepartment;

    @FXML
    private Button btnLoad;

    // Initialize Observable list to hold out database data
    private ObservableList<UserDetails>data;
    private DatabaseConnection dc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DatabaseConnection();
    }

    @FXML
    private void loadDataFromDatabase(ActionEvent event) {

        try {
            Connection conn = dc.getConnection();
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM USER_INFO"); // sql command
            while (rs.next()) {
                // get string from DB any way
                data.add(new UserDetails(rs.getString(2), rs.getString(3), rs.getString(4)));
            }

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        //Set cell value factory to tableview
        //NB.PropertyValue Factory must be the same with the one set in model class
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));

        tableUser.setItems(null);
        tableUser.setItems(data);

    }

}