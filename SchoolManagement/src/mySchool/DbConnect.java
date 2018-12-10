package mySchool;

/**
 * Created by kmip on 23-Mar-17.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Dialog;
import  javafx.scene.control.DialogPane;

public class DbConnect {


    Connection conn = null;


    public void connectdb() {

        try {
            String dbname = "admin";
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
    }
}
