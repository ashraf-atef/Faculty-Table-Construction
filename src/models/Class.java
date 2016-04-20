/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Ashraf Atef
 */
public class Class {
    private int ClassId ;
    private String ClassName ;
    private int Class_Section_Number ; 
    private String Type ;
    private int Class_Members_Number ;

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int ClassId) {
        this.ClassId = ClassId;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public int getClass_Section_Number() {
        return Class_Section_Number;
    }

    public void setClass_Section_Number(int Class_Section_Number) {
        this.Class_Section_Number = Class_Section_Number;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getClass_Members_Number() {
        return Class_Members_Number;
    }

    public void setClass_Members_Number(int Class_Members_Number) {
        this.Class_Members_Number = Class_Members_Number;
    }
    
    
}
