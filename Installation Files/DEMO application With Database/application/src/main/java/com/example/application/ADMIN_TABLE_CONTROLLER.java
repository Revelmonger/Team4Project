package com.example.application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.hibernate.boot.jaxb.hbm.internal.GenerationTimingConverter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.*;
import javafx.event.ActionEvent;

public class ADMIN_TABLE_CONTROLLER  implements Initializable {
    

    @FXML 
    private TableView<PlacedOrdersTableController> PlacedOrdersTable;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Patient;

    @FXML
    private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Modality;

    @FXML
    private TableColumn<PlacedOrdersTableController, String> placed_orders_Notes;

   @FXML
   private TableColumn<PlacedOrdersTableController, Integer> placed_orders_Status;

   @FXML
   private Button logoutButton;

   @FXML
   private Label logoutLabel;

   @FXML
   public void ButtonEntered(){
       logoutButton.setStyle("-fx-font: normal bold 24px 'arial'; -fx-background-color: transparent;");
   }
   @FXML
   public void ButtonExited(){
    logoutButton.setStyle("-fx-font: normal bold 23px 'arial'; -fx-background-color: transparent;");
   }

   ObservableList<PlacedOrdersTableController> PlacedOrdersTableObservableList =  FXCollections.observableArrayList();






    @Override
    public void initialize(URL url, ResourceBundle resource) {






        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PlacedOrdersTableQuery = "select patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.status,  order_status.order_name  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PlacedOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                String statusquery = queryOutput.getString("order_name");



                

                //query for patient name modality name and status stirng reassign to values to be placed into the contructor

                PlacedOrdersTableObservableList.add(new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery));
            }

        placed_orders_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

        placed_orders_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

        placed_orders_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
        
        placed_orders_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

        PlacedOrdersTable.setItems(null);
        PlacedOrdersTable.setItems(PlacedOrdersTableObservableList);

            
        } catch (Exception e) {
          System.out.println("error");
        }




        
        
    }



    public void logout(ActionEvent e) throws IOException{
        FXApp.setRoot("login");
    }

    
}