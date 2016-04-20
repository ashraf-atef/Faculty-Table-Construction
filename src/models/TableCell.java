/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashraf Atef
 */
public class TableCell {

    public Class getMclass() {
        return mclass;
    }

    public void setMclass(Class mclass) {
        this.mclass = mclass;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

   

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getStartSection() {
        return StartSection;
    }

    public void setStartSection(int StartSection) {
        this.StartSection = StartSection;
    }

    public int getEndSection() {
        return EndSection;
    }

    public void setEndSection(int EndSection) {
        this.EndSection = EndSection;
    }

   

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }
     public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private Class mclass ;
    private Course course ;
    private List<PossibleProbabilityPlace> possible_prpbability_places =new ArrayList<>() ;
     private List<PossibleProbabilityPlace> possible_prpbability_places_bad_mood_places_generality =new ArrayList<>() ;
     private List<PossibleProbabilityPlace> possible_prpbability_places_bad_mood_places_number =new ArrayList<>() ;

    public List<PossibleProbabilityPlace> getPossible_prpbability_places_bad_mood_places_generality() {
        return possible_prpbability_places_bad_mood_places_generality;
    }

    public void setPossible_prpbability_places_bad_mood_places_generality(List<PossibleProbabilityPlace> possible_prpbability_places_bad_mood_places_generality) {
        this.possible_prpbability_places_bad_mood_places_generality = possible_prpbability_places_bad_mood_places_generality;
    }

    public List<PossibleProbabilityPlace> getPossible_prpbability_places_bad_mood_places_number() {
        return possible_prpbability_places_bad_mood_places_number;
    }

    public void setPossible_prpbability_places_bad_mood_places_number(List<PossibleProbabilityPlace> possible_prpbability_places_bad_mood_places_number) {
        this.possible_prpbability_places_bad_mood_places_number = possible_prpbability_places_bad_mood_places_number;
    }

    public List<PossibleProbabilityPlace> getPossible_prpbability_places() {
        return possible_prpbability_places;
    }

    public void setPossible_prpbability_places(List<PossibleProbabilityPlace> possible_prpbability_places) {
        this.possible_prpbability_places = possible_prpbability_places;
    }
    private Doctor doctor ;
    private Place place ;
    private int StartSection ;
    private int EndSection ;
    private Time StartTime ;
    private Time EndTime ;

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
    private String Day ;
   private String type ;
    
            
}
