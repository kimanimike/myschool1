package mySchool;

import java.io.FileInputStream;

/**
 * Created by kmip on 28-Mar-17.
 */
public class Student {

    String fName;
    String surName;
    String secondName;
    String admno;
    String classofreg;
    String dateofBirth ;
    String gender;
    String residentailArea;
    //String passport;
    String guardianName;
    String guardianTel;
    String dob;
    String dor;
    FileInputStream fis;


    public  Student(){
        this.fName = "";
        this.surName = "";
        this.secondName = "";
        this.admno = "";
        this.classofreg = "";
        this.dateofBirth = "";
        this.residentailArea = "";
        this.fis = null;
        this.guardianName = "";
        this.guardianTel = "";

        this.dor = "";

    }
    public  Student( String fName, String surName, String secondName,
    String admno, String classofreg, String dateofBirth, String gender, String residentailArea,FileInputStream fis,
                     String guardianName, String guardianTel, String dor){
        this.fName = fName;
        this.surName = surName;
        this.secondName = secondName;
        this.admno = admno;
        this.classofreg = classofreg;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.residentailArea = residentailArea;
        this.fis = fis;
        this.guardianName = guardianName;
        this.guardianTel = guardianTel;
        this.dor =  dor;


    }

    public String getfName() {
        return fName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAdmno() {
        return admno;
    }

    public void setAdmno(String admno) {
        this.admno = admno;
    }

    public String getClassofreg() {
        return classofreg;
    }

    public void setClassofreg(String classofreg) {
        this.classofreg = classofreg;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getResidentailArea() {
        return residentailArea;
    }

    public void setResidentailArea(String residentailArea) {
        this.residentailArea = residentailArea;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianTel() {
        return guardianTel;
    }

    public void setGuardianTel(String guardianTel) {
        this.guardianTel = guardianTel;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }
}
