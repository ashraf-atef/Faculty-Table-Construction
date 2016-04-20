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
public class Place {
    private int PlaceId ;
    private String PlaceName ;
    private int Max_Place_Number;
    private int Place_Full_Avilability ;
    private int Place_Generality ;
    private List<PlaceAvilablePeriod>place_avilable_period=new ArrayList<>() ;
    private List<PlaceCourse>place_course =new ArrayList<>();

   

    public int getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(int PlaceId) {
        this.PlaceId = PlaceId;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String PlaceName) {
        this.PlaceName = PlaceName;
    }

    public int getMax_Place_Number() {
        return Max_Place_Number;
    }

    public void setMax_Place_Number(int Max_Place_Number) {
        this.Max_Place_Number = Max_Place_Number;
    }

    public int getPlace_Full_Avilability() {
        return Place_Full_Avilability;
    }

    public void setPlace_Full_Avilability(int Place_Full_Avilability) {
        this.Place_Full_Avilability = Place_Full_Avilability;
    }

    public int getPlace_Generality() {
        return Place_Generality;
    }

    public void setPlace_Generality(int Place_Generality) {
        this.Place_Generality = Place_Generality;
    }
    
     public List<PlaceAvilablePeriod> getPlace_avilable_period() {
        return place_avilable_period;
    }

    public void setPlace_avilable_period(List<PlaceAvilablePeriod> place_avilable_period) {
        this.place_avilable_period = place_avilable_period;
    }

    public List<PlaceCourse> getPlace_course() {
        return place_course;
    }

    public void setPlace_course(List<PlaceCourse> place_course) {
        this.place_course = place_course;
    }
    
    
}
