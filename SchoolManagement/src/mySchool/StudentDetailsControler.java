package mySchool;

;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by kmip on 29-Mar-17.
 */
public class StudentDetailsControler  {


    ResultSet rs = null;
    PreparedStatement pst ;
    Connection conn = null;

        ObservableList<ObservableList> students = FXCollections.observableArrayList();

    TableView tableView = new TableView();

    TextField txtfldsearch = new TextField();

    Button btnSearch = new  Button();


public void getStudents() throws Exception{


    try {
        String dbname = "school_management";
        String usernme = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/";
        String Driver = "com.mysql.jdbc.Driver";

        Class.forName(Driver);

        conn = DriverManager.getConnection(url + dbname, usernme, pass);

    } catch (Exception e) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Connection");
        alert.setHeaderText(" No Connection");
        String info = "Please turn on Xamp";
        alert.setContentText(info +" " + e);
        alert.showAndWait();
        return;
    }

    try{



        String sql = "Select * from studentsdetails ";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();


        for(int i=0 ; i<rs.getMetaData().getColumnCount()-1; i++){

            //We are using non property style for making dynamic table

            final int j = i;

            TableColumn  col = new TableColumn(rs.getMetaData().getColumnName(i+1));

            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){

                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {

                    return new SimpleStringProperty(param.getValue().get(j).toString());

                }

            });



            System.out.println("Column ["+i+"] ");
            tableView.getColumns().addAll(col);


        }

      while(rs.next()) {


        /* String Num = rs.getString("No");
          String fName  = rs.getString("FirstName");
            String surName = rs.getString("Surname");
            String secondName = rs.getString("secondName");
            String admno = rs.getString("AdmNo");
                String dob = rs.getString("DOB");
            String dor = rs.getString("dateofregistration");
            String classofreg = rs.getString("Class");
            String gender= rs.getString("gender");
            String residentialAddress = rs.getString("ResidentialAddress");
            String guardianName = rs.getString("GuardianName");
            String guardianTelNo = rs.getString("GuardianTelNo");
*/
            /*///////////////////////Tble Columns ////////////////
           TableColumn noCol = new TableColumn("Num");
            TableColumn firstNameCol = new TableColumn("First Name");
            //firstNameCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(fName));

            TableColumn surNameCol = new TableColumn("Sur Name");
            //surNameCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(surName));

            TableColumn secondNameCol = new TableColumn("Second Name");
            //secondNameCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(secondName));


            TableColumn admnoCol = new TableColumn("ADM No");
           //admnoCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(admno));

            TableColumn classeCol = new TableColumn("Class");
            //classeCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(classofreg));

            TableColumn dobCol = new TableColumn("DOB");
            //dobCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(dob));
            TableColumn dorCol = new TableColumn("DOR");
            //dorCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(dor));

            TableColumn genderCol = new TableColumn("Gender");
            //genderCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(gender));

            TableColumn residentailCol = new TableColumn("R Area");
            //residentailCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(residentialAddress));

            TableColumn guardianNameCol = new TableColumn("Guardian");
            //guardianNameCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(guardianName));
            TableColumn guardianTelCol = new TableColumn("Phone");
            //guardianTelCol.setCellValueFactory(new PropertyValueFactory<ObservableList, String>(guardianTelNo));
           */


          //tableView.getColumns().addAll( noCol, firstNameCol, surNameCol,secondNameCol,admnoCol, classeCol,
            //      dobCol,dorCol,genderCol,residentailCol, guardianNameCol, guardianTelCol);





           ///

          ObservableList<String> row = FXCollections.observableArrayList();


            for(int i = 1 ; i<=rs.getMetaData().getColumnCount()-1; i++){

                row.add(rs.getString(i));

            }
          students.add(row);

           System.out.println("student added[1] added "+students );

           System.out.println("Row [1] added "+row );

        }

        tableView.setItems(students);

        txtfldsearch.setPrefWidth(500);
        txtfldsearch.setPromptText("Search Student");
        txtfldsearch.setPrefSize(300, 20);

        btnSearch.setText("Search");
        Stage primaryStage = new Stage();
        VBox root = new VBox();
        //mySchool/login.fxml
        //mySchool/studentMagement.fxml

        primaryStage.setTitle("Students Details");
        root.setPadding( new Insets(10, 10, 10, 10));
        root.setSpacing(10);
        root.getChildren().addAll( txtfldsearch, btnSearch, tableView);
        Scene scene = new Scene(root );
        root.setPrefHeight(900);

        primaryStage.setScene(scene );
        primaryStage.show();

    }
    catch (Exception e){

e.printStackTrace();

    }

    //txtfldsearch.setOnKeyReleased(EventHandler<>);

    /*////////////////////////*
    vBox.setSpacing(5);
    vBox.setPadding(new Insets(10,0,0,10));
    vBox.getChildren().add(tableView);
    ((Group) scene.getRoot()).getChildren().addAll(vBox);
    primaryStage.setScene(scene);
    primaryStage.show();


    *//////////////////////////////////////////







}

}
