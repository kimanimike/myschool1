package mySchool;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
//import javax.swing.text.html.ImageView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import  java.text.SimpleDateFormat;
import  java.util.Calendar;

import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * Created by kmip on 27-Mar-17.
 */
public class AdmissionsController {

    @FXML
    Button btnUploadImage;
    @FXML
    ImageView passport;
    @FXML
    TextField firstname, surname, secondname, admno, classofregistration, residentialarea, guardianname, guardiantel;
    @FXML
    RadioButton gendermale, genderfemale;
    @FXML
    DatePicker dob;

    @FXML Label lbldateofregistration;
    String time;

    DbConnect dbConnect = new DbConnect();
    ResultSet rs = null;
    PreparedStatement pst ;
    Connection conn = null;
    Image image;
    File studentPassport;
    String firstName, surName, secondName, admissionNumber, classofRegistration, dateofBirth, residentailArea;
      String       guardianName, guardianTel, dateofRegistration ;
    FileInputStream fis;
    String gender ;

    StudentDetailsControler studentDetailsControler = new StudentDetailsControler();






    public  void ImageUpload(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
         studentPassport = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(studentPassport);
               image = SwingFXUtils.toFXImage(bufferedImage, null);
            passport.setImage(image);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong Image Type");
            alert.setHeaderText("Wrong Username or Password");
            String info = "Please re enter you login details";
            alert.setContentText(info);
            alert.showAndWait();
        }
    }



    public  void RegisterStudent(ActionEvent event) throws Exception{

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
        firstName = firstname.getText();
         surName = surname.getText();
         secondName = secondname.getText();
         admissionNumber = admno.getText();
        classofRegistration = classofregistration.getText();
        LocalDate localDate = dob.getValue();
         dateofBirth = localDate.toString();
         residentailArea = residentialarea.getText();
        guardianName = guardianname.getText();
        guardianTel = guardiantel.getText();
        Date date = new Date();

         dateofRegistration = date.toString();

        lbldateofregistration.setText(dateofRegistration);




        if(gendermale.isSelected()){

            gender = "Male";

        }
        if(genderfemale.isSelected()){

            gender = "female";

        }


        try {


            String  sql =  "insert into studentsdetails(FirstName, Surname, SecondName," +
                    "AdmNo, DOB, dateofregistration, Class, Gender, ResidentialAddress, guardianName, guardianTelNo, passportphoto )value(?,?,?,?,?,?,?,?,?,?,?,?)";

            pst=conn.prepareStatement(sql);


            pst.setString(1, firstName);
            pst.setString(2, surName);
            pst.setString(3, secondName);
            pst.setString(4, admissionNumber);
            pst.setString(5, dateofBirth);
            pst.setString(6, dateofRegistration);

            pst.setString(7, classofRegistration);
            pst.setString(8, gender);
            pst.setString(9, residentailArea);

            pst.setString(10, guardianName);
            pst.setString(11, guardianTel);
        //    pst.setBytes(12, image);
             fis = new FileInputStream(studentPassport) ;

            pst.setBinaryStream(12, fis, studentPassport.length());

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("STUDENT SAVED SUCCESSFULLY");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();






        }
        catch (Exception e){


            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NOT SAVED");
            alert.setHeaderText("Please Try again");
            alert.showAndWait();

        }

    }
    public ObservableList<Student> getStudent(){

        ObservableList<Student> students = FXCollections.observableArrayList();
        students.add(new Student(

               firstName, surName, secondName, admissionNumber, classofRegistration, dateofBirth, gender,
                residentailArea, fis, guardianName, guardianTel, dateofRegistration


        ));


 return  students;
    }

    public void stdsDetails(ActionEvent event){
        try {
            studentDetailsControler.getStudents();
        }catch(Exception e){

            e.printStackTrace();

        }

    }


    }


