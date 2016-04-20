/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashraf Atef
 */
public class Doctor {
    private int DoctorId;
    private String DoctorName ;
    private String DoctorPhone ;
    private String DoctorStatus ;
    private String DoctorMail ;
    private int DoctorAvilability ;
    private List<DoctorConstrain>Doctor_constrains=new ArrayList<>();

    public List<DoctorConstrain> getDoctor_constrains() {
        return Doctor_constrains;
    }

    public void setDoctor_constrains(List<DoctorConstrain> Doctor_constrains) {
        this.Doctor_constrains = Doctor_constrains;
    }

    public int getDoctorAvilability() {
        return DoctorAvilability;
    }

    public void setDoctorAvilability(int DoctorAvilability) {
        this.DoctorAvilability = DoctorAvilability;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(int DoctorId) {
        this.DoctorId = DoctorId;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }

    public String getDoctorPhone() {
        return DoctorPhone;
    }

    public void setDoctorPhone(String DoctorPhone) {
        this.DoctorPhone = DoctorPhone;
    }

    public String getDoctorStatus() {
        return DoctorStatus;
    }

    public void setDoctorStatus(String DoctorStatus) {
        this.DoctorStatus = DoctorStatus;
    }

    public String getDoctorMail() {
        return DoctorMail;
    }

    public void setDoctorMail(String DoctorMail) {
        this.DoctorMail = DoctorMail;
    }
    
}
