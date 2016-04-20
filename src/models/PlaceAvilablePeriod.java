/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Time;

/**
 *
 * @author Ashraf Atef
 */
public class PlaceAvilablePeriod {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

   

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    private int ID ;
  
    private String Day ;
    private Time From ;
    private Time TO ;

    public Time getFrom() {
        return From;
    }

    public void setFrom(Time From) {
        this.From = From;
    }

    public Time getTO() {
        return TO;
    }

    public void setTO(Time TO) {
        this.TO = TO;
    }
    
    
}
