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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;

public class ADMIN_TABLE_CONTROLLER  implements Initializable {
                                //Placed Orders
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                //Checked-In Appointments
   @FXML 
   private TableView<CheckedInAppointmentsTableController> CheckedInAppointmentsTable;

   @FXML
   private TableColumn<CheckedInAppointmentsTableController, Integer> CheckedInAppointments_Patient;

   @FXML
   private TableColumn<CheckedInAppointmentsTableController, Integer> CheckedInAppointments_Modality;

   @FXML
   private TableColumn<CheckedInAppointmentsTableController, String> CheckedInAppointments_Price;

   @FXML
   private TableColumn<CheckedInAppointmentsTableController, Date> CheckedInAppointments_DateandTime;

   @FXML
   private TableColumn<CheckedInAppointmentsTableController, Integer> CheckedInAppointments_Radiologist;

   @FXML
   private TableColumn<CheckedInAppointmentsTableController, Integer> CheckedInAppointments_Technician;

   ObservableList<CheckedInAppointmentsTableController> CheckedInAppointmentsObservableList =  FXCollections.observableArrayList();

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                //Today's Appointments
   @FXML 
   private TableView<TodaysAppointmentsTableController> TodaysAppointmentsTable;

   @FXML
   private TableColumn<TodaysAppointmentsTableController, Integer> TodaysAppointments_Patient1;

   @FXML
   private TableColumn<TodaysAppointmentsTableController, Integer> TodaysAppointmentsTable_Modality;

   @FXML
   private TableColumn<TodaysAppointmentsTableController, String> TodaysAppointmentsTable_Prices;

   @FXML
   private TableColumn<TodaysAppointmentsTableController, Date> TodaysAppointmentsTable_DateandTime;

   @FXML
   private TableColumn<TodaysAppointmentsTableController, Integer> TodaysAppointmentsTable_Radiologist;

   @FXML
   private TableColumn<TodaysAppointmentsTableController, Integer> TodaysAppointmentsTable_Technician;

   ObservableList<TodaysAppointmentsTableController> TodaysAppointmentsObservableList =  FXCollections.observableArrayList();   


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                //Unscheduled Orders
   @FXML 
   private TableView<UnscheduledOrdersTableController> UnscheduledOrdersTable;

   @FXML
   private TableColumn<UnscheduledOrdersTableController, Integer> UnscheduledOrdersTable_Patient;

   @FXML
   private TableColumn<UnscheduledOrdersTableController, Integer> UnscheduledOrdersTable_ReferralMD;

   @FXML
   private TableColumn<UnscheduledOrdersTableController, Integer> UnscheduledOrdersTable_Modality;

   @FXML
   private TableColumn<UnscheduledOrdersTableController, String> UnscheduledOrdersTable_Notes;

   ObservableList<UnscheduledOrdersTableController> UnscheduledOrdersObservableList =  FXCollections.observableArrayList();


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML 
    private TableView<ReviewImagingOrdersTableController> ReviewImagingOrdersTable;

    @FXML
    private TableColumn<ReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_Patient;

    @FXML
    private TableColumn<ReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_RefferalMD;

    @FXML
    private TableColumn<ReviewImagingOrdersTableController, Integer> ReviewImagingOrdersTable_Modality;

    @FXML
    private TableColumn<ReviewImagingOrdersTableController, String> ReviewImagingOrdersTable_Notes;

    ObservableList<ReviewImagingOrdersTableController> ReviewImagingOrdersObservableList =  FXCollections.observableArrayList();


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void initialize(URL url, ResourceBundle resource) {


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        // Populates the Placed Orders Table
        String PlacedOrdersTableQuery = "select patients.patient_id, patients.first_name, patients.last_name, modalities.modality_id, modalities.name, orders.notes, orders.status,  order_status.order_name  from orders  join patients on orders.patient = patients.patient_id  join modalities on orders.modality = modalities.modality_id join order_status on orders.status = order_status.order_status_id;";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(PlacedOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("first_name") + " " + queryOutput.getString("last_name");
                String modalityquery = queryOutput.getString("name");
                String notesquery = queryOutput.getString("notes").trim();
                String statusquery = queryOutput.getString("order_name");

                PlacedOrdersTableObservableList.add(new PlacedOrdersTableController(patientquery, modalityquery, notesquery, statusquery));
            }

        placed_orders_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        placed_orders_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));
        placed_orders_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
        placed_orders_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

        PlacedOrdersTable.setItems(null);
        PlacedOrdersTable.setItems(PlacedOrdersTableObservableList);

            //Adding Search Bar Filter Here
            FilteredList<PlacedOrdersTableController> filteredData = new FilteredList<>(PlacedOrdersTableObservableList);


            
        } catch (Exception e) {
          System.out.println("error");
        }
                                                                                                                                                                //join price modalities.price
        String CheckedInAppointmentsTableQuery = "SELECT patient, modality, date_time, radiologist, technician FROM db_ris.appointments"; //change to just like orders select statement
                                                                            //still need price
        try{

            Statement statement2 = connectDB.createStatement();
            ResultSet queryOutput = statement2.executeQuery(CheckedInAppointmentsTableQuery);

            while (queryOutput.next()) {

                Integer patientquery = queryOutput.getInt("patient");
                Integer modalityquery = queryOutput.getInt("modality");
                Date date_timequery = queryOutput.getDate("date_time");             //price //may need to change types
                Integer radiologistquery = queryOutput.getInt("radiologist");
                Integer technicianquery = queryOutput.getInt("technician");




                

                CheckedInAppointmentsObservableList.add(new CheckedInAppointmentsTableController(patientquery, modalityquery, date_timequery, radiologistquery, technicianquery));
            }

            CheckedInAppointments_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            CheckedInAppointments_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));
                
            CheckedInAppointments_DateandTime.setCellValueFactory(new PropertyValueFactory<>("date_time"));         //price

            CheckedInAppointments_Radiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));
            
            CheckedInAppointments_Technician.setCellValueFactory(new PropertyValueFactory<>("technician"));
    
            CheckedInAppointmentsTable.setItems(null);
            CheckedInAppointmentsTable.setItems(CheckedInAppointmentsObservableList);
    
                
            } catch (Exception e) {
              System.out.println("error");
            }
        
            String TodaysAppointmentsTableQuery = "SELECT patient, modality, date_time, radiologist, technician FROM db_ris.appointments";


                                                            //date time for todays date!


        try{

            Statement statement3 = connectDB.createStatement();
            ResultSet queryOutput = statement3.executeQuery(TodaysAppointmentsTableQuery);

            while (queryOutput.next()) {

                Integer patientquery = queryOutput.getInt("patient");
                Integer modalityquery = queryOutput.getInt("modality");
                Date date_timequery = queryOutput.getDate("date_time");             //price //may need to change types
                Integer radiologistquery = queryOutput.getInt("radiologist");
                Integer technicianquery = queryOutput.getInt("technician");




          

                TodaysAppointmentsObservableList.add(new TodaysAppointmentsTableController(patientquery, modalityquery, date_timequery, radiologistquery, technicianquery));
            }

            TodaysAppointments_Patient1.setCellValueFactory(new PropertyValueFactory<>("patient"));

            TodaysAppointmentsTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));
          
            TodaysAppointmentsTable_DateandTime.setCellValueFactory(new PropertyValueFactory<>("date_time"));         //price

            TodaysAppointmentsTable_Radiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));
      
            TodaysAppointmentsTable_Technician.setCellValueFactory(new PropertyValueFactory<>("technician"));

            TodaysAppointmentsTable.setItems(null);
            TodaysAppointmentsTable.setItems(TodaysAppointmentsObservableList);

          
        }   catch (Exception e) {
            System.out.println("error");
        }

        String UnscheduledOrdersTableQuery = "SELECT patient, referral_md, modality, notes FROM db_ris.orders"; //change to just like orders select statement


        try{

            Statement statement4 = connectDB.createStatement();
            ResultSet queryOutput = statement4.executeQuery(UnscheduledOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("patient");
                String referral_mdquery = queryOutput.getString("referral_md");
                String modalityquery = queryOutput.getString("modality");             //might need to change types
                String notesquery = queryOutput.getString("notes");



        

                UnscheduledOrdersObservableList.add(new UnscheduledOrdersTableController(patientquery, referral_mdquery, modalityquery, notesquery));
            }

            UnscheduledOrdersTable_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            UnscheduledOrdersTable_ReferralMD.setCellValueFactory(new PropertyValueFactory<>("referral_md"));

            UnscheduledOrdersTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));        

            UnscheduledOrdersTable_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
    

            UnscheduledOrdersTable.setItems(null);
            UnscheduledOrdersTable.setItems(UnscheduledOrdersObservableList);

        
        }   catch (Exception e) {
            System.out.println("error");
        }

        String ReviewImagingOrdersTableQuery = "SELECT patient, referral_md, modality, notes FROM db_ris.orders"; //change to just like orders select statement


        try{

            Statement statement5 = connectDB.createStatement();
            ResultSet queryOutput = statement5.executeQuery(ReviewImagingOrdersTableQuery);

            while (queryOutput.next()) {

                String patientquery = queryOutput.getString("patient");
                String referral_mdquery = queryOutput.getString("referral_md");
                String modalityquery = queryOutput.getString("modality");             //might need to change types
                String notesquery = queryOutput.getString("notes");



        

                ReviewImagingOrdersObservableList.add(new ReviewImagingOrdersTableController(patientquery, referral_mdquery, modalityquery, notesquery));
            }

            ReviewImagingOrdersTable_Patient.setCellValueFactory(new PropertyValueFactory<>("patient"));

            ReviewImagingOrdersTable_RefferalMD.setCellValueFactory(new PropertyValueFactory<>("referral_md"));
        
            ReviewImagingOrdersTable_Modality.setCellValueFactory(new PropertyValueFactory<>("modality"));         
            
            ReviewImagingOrdersTable_Notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
    

            ReviewImagingOrdersTable.setItems(null);
            ReviewImagingOrdersTable.setItems(ReviewImagingOrdersObservableList);

        
        }   catch (Exception e) {
            System.out.println("error");
        }

    }

    
}