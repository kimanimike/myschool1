package mySchool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {

    ResultSet rs = null;
    PreparedStatement pst ;
    Connection conn = null;


    @FXML
     TextField tf_userName;
    @FXML
    PasswordField tf_Password;

    @FXML
    Button btn_login, btn_cancel;
    DbConnect dbConnect = new DbConnect();


public  void login(ActionEvent event){

    try {

        String dbname = "school_management";
        String usernme = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/";
        String Driver = "com.mysql.jdbc.Driver";

        Class.forName(Driver);

        conn = DriverManager.getConnection(url + dbname, usernme, pass);



        String sql2 = "select * from users where username=? and password=? ";

        pst = conn.prepareStatement(sql2);

         pst.setString(1,tf_userName.getText()  );

      pst.setString(2, tf_Password.getText());

        rs = pst.executeQuery();

        if (rs.next()) {

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/mySchool/studentMagement.fxml"));
            //mySchool/login.fxml
            //mySchool/studentMagement.fxml

            primaryStage.setTitle("Student Managment");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();





        }
        else
        {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong Username or Password");
            alert.setHeaderText("Wrong Username or Password");
            String info = "Please re enter you login details";
            alert.setContentText(info);
            alert.showAndWait();
        }
    }
        catch(Exception e){

            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Connection");
            alert.setHeaderText(" Something went Wrong "+ e);
            String info = "Something went Wrong";
            alert.setContentText(info + e);
            alert.showAndWait();
        }



}


}
