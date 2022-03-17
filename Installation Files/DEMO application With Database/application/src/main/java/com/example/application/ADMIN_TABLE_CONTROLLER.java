package com.example.application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.hibernate.boot.jaxb.hbm.internal.GenerationTimingConverter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.*;

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

   ObservableList<PlacedOrdersTableController> PlacedOrdersTableObservableList =  FXCollections.observableArrayList();






    @Override
    public void initialize(URL url, ResourceBundle resource) {






        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String PlacedOrdersTableQuery = "SELECT patient, modality, notes, status FROM db_ris.orders";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PlacedOrdersTableQuery);



            while (queryOutput.next()) {

                Integer patientquery = queryOutput.getInt("patient");
                Integer modalityquery = queryOutput.getInt("modality");
                String notesquery = queryOutput.getString("notes").trim();
                Integer statusquery = queryOutput.getInt("status");
            



                


                PlacedOrdersTableObservableList.add(new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery));
            }

        placed_orders_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

        placed_orders_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));

        placed_orders_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
        
        placed_orders_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

        PlacedOrdersTable.setItems(null);
        PlacedOrdersTable.setItems(PlacedOrdersTableObservableList);

            
        } catch (Exception e) {
            e.getStackTrace();
        }





        
        
    }

    
}