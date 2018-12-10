package mySchool;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by kmip on 27-Mar-17.
 */
public class StudentManagerController {

    StudentDetailsControler studentDetailsControler = new StudentDetailsControler();

    public void RegisterStudent(ActionEvent event) throws  Exception{

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/mySchool/admissions.fxml"));
        //mySchool/login.fxml
        //mySchool/studentMagement.fxml

        primaryStage.setTitle("Student Managment");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    public  void ViewStudents( ActionEvent event){

        try {
            studentDetailsControler.getStudents();
        }catch(Exception e){

            e.printStackTrace();

        }

      //  Stage primaryStage = new Stage();
        //Parent root = FXMLLoader.load(getClass().getResource("/mySchool/admissions.fxml"));
        //mySchool/login.fxml
        //mySchool/studentMagement.fxml

        //primaryStage.setTitle("Student Managment");
        //primaryStage.setScene(new Scene(root));
        //primaryStage.show();


    }

}
