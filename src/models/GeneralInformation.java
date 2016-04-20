/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.InsertData;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashraf Atef
 */
public class GeneralInformation {


    public GeneralInformation() {
    
    }
    
     private Time DayHours ;
    private Time SectionPeriod ;
    private Time LecturePeriod ;
    private Time StartTime ;
    private Time EndTime ;

    public int getMaxGroupNumber() {
        return MaxGroupNumber;
    }

    public void setMaxGroupNumber(int MaxGroupNumber) {
        this.MaxGroupNumber = MaxGroupNumber;
    }
    private  int MaxGroupNumber ;
    private List<String> Days=new ArrayList<>();

    public Time getDayHours() {
        return DayHours;
    }

    public void setDayHours(Time DayHours) {
        this.DayHours = DayHours;
    }

    public Time getSectionPeriod() {
        return SectionPeriod;
    }

    public void setSectionPeriod(Time SectionPeriod) {
        this.SectionPeriod = SectionPeriod;
    }

    public Time getLecturePeriod() {
        return LecturePeriod;
    }

    public void setLecturePeriod(Time LecturePeriod) {
        this.LecturePeriod = LecturePeriod;
    }

    public Time getStartTime() {
        return StartTime;
    }

    public void setStartTime(Time StartTime) {
        this.StartTime = StartTime;
    }

    public Time getEndTime() {
        return EndTime;
    }

    public void setEndTime(Time EndTime) {
        this.EndTime = EndTime;
    }

    public List<String> getDays() {
        return Days;
    }

    public void setDays(List<String> Days) {
        this.Days = Days;
    }
    
}
