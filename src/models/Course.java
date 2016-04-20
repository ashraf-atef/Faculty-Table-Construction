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
public class Course {
    private int CourseId ;
    private String CourseName ;
    private String CourseSerial ;
    private int Max_Couse_section_Numbers ;
    private int GeneralLab ;

    public int getGeneralLab() {
        return GeneralLab;
    }

    public void setGeneralLab(int GeneralLab) {
        this.GeneralLab = GeneralLab;
    }
    

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getCourseSerial() {
        return CourseSerial;
    }

    public void setCourseSerial(String CourseSerial) {
        this.CourseSerial = CourseSerial;
    }

    public int getMax_Couse_section_Numbers() {
        return Max_Couse_section_Numbers;
    }

    public void setMax_Couse_section_Numbers(int Max_Couse_section_Numbers) {
        this.Max_Couse_section_Numbers = Max_Couse_section_Numbers;
    }
    
}
