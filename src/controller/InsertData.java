/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.*;

/**
 *
 * @author Ashraf Atef
 */
public  class InsertData {
    
  public  DatabaseMethods dbm=new DatabaseMethods();
   public GeneralInformation GINFO ;
   public List<Course> ListCourse;
   public List<models.Class> ListClass;
   public List<ClassCourse> ListClassCourse;
   public List <Place> places ;
   public List<TableCell>table ;
   public List<Doctor> List_doctors ;
   public List<Doctor>List_mo3id ;
  
  public  void insert ()
    {
       
   // get general info
     GINFO = dbm.get_general_info();
        
        // inser courses
         ListCourse=dbm.GetCourses() ;
       
//        for (int i=1 ; i<=5 ;i++)
//        {
//        Course course=new Course();
//        course.setCourseId(i);
//        course.setCourseName("Course"+i);
//        course.setCourseSerial("S"+i);
//        if (i%2==0)course.setMax_Couse_section_Numbers(1);
//        else course.setMax_Couse_section_Numbers(3);
//        if (i==1) course.setGeneralLab(0);
//        else course.setGeneralLab(1);
//        ListCourse.add(course);
//        }
        
        //insert classes
        
        ListClass =dbm.GetClasses() ;
//        models.Class class1=new models.Class();
//        class1.setClassId(1);
//        class1.setClassName("First Class");
//        class1.setClass_Members_Number(320);
//        class1.setClass_Section_Number(12);
//        class1.setType("General");
//        ListClass.add(class1);
        
        // insert class cource
       ListClassCourse=dbm.GetClassCourse() ;
        
//        for (int i=0 ; i<ListCourse.size() ; i++)
//        {
//            for (int v=0 ; v<ListClass.size() ; v++)
//            {
//                ClassCourse classcourse=new ClassCourse();
//                classcourse.setCourse(ListCourse.get(i));
//                classcourse.setmClass(ListClass.get(v));
//                classcourse.setID(0);
//                ListClassCourse.add(classcourse);
//            }
//        }
        
        // insert places
        places=dbm.getplaces();
//        for (int i=1 ; i<=5 ; i++)
//        {
//            Place place=new Place();
//            place.setPlaceName("lab 50"+i);
//            place.setMax_Place_Number(35);
//            place.setPlace_Full_Avilability(1);
//            place.setPlace_Generality(1);
//            place.setPlaceId(i);
//            places.add(place);
//        }
//        
//       Place place=new Place();
//       place.setPlaceId(6);
//       place.setPlaceName("Stage 1");
//       place.setMax_Place_Number(350);
//       place.setPlace_Full_Avilability(0);
//       place.setPlace_Generality(1);
//       PlaceAvilablePeriod pAp=new PlaceAvilablePeriod();
//       pAp.setID(1);
//       pAp.setDay(String.valueOf(DAYS.SATURDAY));
//       pAp.setFrom(9);
//       pAp.setTO(14);
//       
//       place.getPlace_avilable_period().add(pAp);
//        pAp=new PlaceAvilablePeriod();
//       pAp.setID(2);
//       pAp.setDay(String.valueOf(DAYS.TUESDAY));
//       pAp.setFrom(9);
//       pAp.setTO(16.5);
//       place.getPlace_avilable_period().add(pAp);
//        pAp=new PlaceAvilablePeriod();
//       pAp.setID(3);
//       pAp.setDay(String.valueOf(DAYS.MONDAY));
//       pAp.setFrom(9);
//       pAp.setTO(14);
//       place.getPlace_avilable_period().add(pAp);
//        pAp=new PlaceAvilablePeriod();
//       pAp.setID(4);
//       pAp.setDay(String.valueOf(DAYS.WEDNESDAY));
//       pAp.setFrom(9);
//       pAp.setTO(16.5);
//       place.getPlace_avilable_period().add(pAp);
//       places.add(place);
//       
//       place=new Place();
//       place.setPlaceId(7);
//       place.setPlaceName("Lab course1");
//       place.setPlace_Full_Avilability(1);
//       place.setMax_Place_Number(35);
//       place.setPlace_Generality(0);
//       
//       PlaceCourse pc=new PlaceCourse();
//       pc.setID(1);
//       pc.setCourse(ListCourse.get(0));
//       place.getPlace_course().add(pc);
//       
//       places.add(place);
//       
       
        
        
        // table list
        
       table=new ArrayList<>();
        
        for (int i=0 ; i<ListClassCourse.size() ; i++)
        {
       int SectionNumber=(int)Math.ceil((double)ListClassCourse.get(i).getmClass().getClass_Section_Number()/(double)ListClassCourse.get(i).getCourse().getMax_Couse_section_Numbers()) ;
                  
        TableCell tablecell=new TableCell();
             tablecell.setCourse(ListClassCourse.get(i).getCourse());
             tablecell.setMclass(ListClassCourse.get(i).getmClass());
             tablecell.setStartSection(1);
             tablecell.setEndSection(ListClassCourse.get(i).getmClass().getClass_Section_Number());
             tablecell.setType("Lecture");
             table.add(tablecell);
           
       for (int c=0 ; c<SectionNumber ; c++)
            {
               
              tablecell=new TableCell();
             tablecell.setCourse(ListClassCourse.get(i).getCourse());
             tablecell.setMclass(ListClassCourse.get(i).getmClass());
             tablecell.setStartSection((c*ListClassCourse.get(i).getCourse().getMax_Couse_section_Numbers())+1);
                if ((c * ListClassCourse.get(i).getCourse().getMax_Couse_section_Numbers()) + ListClassCourse.get(i).getCourse().getMax_Couse_section_Numbers()
                        > ListClassCourse.get(i).getmClass().getClass_Section_Number()) {
                    tablecell.setEndSection(ListClassCourse.get(i).getmClass().getClass_Section_Number());
                } else {
                    tablecell.setEndSection((c * ListClassCourse.get(i).getCourse().getMax_Couse_section_Numbers()) + ListClassCourse.get(i).getCourse().getMax_Couse_section_Numbers());

                }
             tablecell.setType("Section");
             table.add(tablecell);
              
            }
        }
        
        
   
        
       // insert doctors 
         List_doctors =dbm.getDoctors("Doctor");
//        for (int i=1 ; i<=2 ; i++)
//        {
//            Doctor doctor=new Doctor();
//            doctor.setDoctorId(i);
//            doctor.setDoctorName("doctor"+i);
//            doctor.setDoctorMail("@yahoo");
//            doctor.setDoctorStatus("Professor");
//            doctor.setDoctorAvilability(1);
//            List_doctors.add(doctor);
//        }
//        Doctor doctor=new Doctor();
//           doctor.setDoctorId(3);
//            doctor.setDoctorName("doctor"+3);
//            doctor.setDoctorMail("@yahoo");
//            doctor.setDoctorStatus("Professor");
//            doctor.setDoctorAvilability(0);
//            
//            DoctorConstrain dc=new DoctorConstrain();
//            dc.setID(1);
//            dc.setDay(String.valueOf(DAYS.SATURDAY));
//            dc.setFrom(9);
//            dc.setTo(11.5);
//             doctor.getDoctor_constrains().add(dc);
//             
//             dc=new DoctorConstrain();
//            dc.setID(1);
//            dc.setDay(String.valueOf(DAYS.SUNDAY));
//            dc.setFrom(9);
//            dc.setTo(16.5);
//             doctor.getDoctor_constrains().add(dc);
//             
//             dc=new DoctorConstrain();
//            dc.setID(1);
//            dc.setDay(String.valueOf(DAYS.MONDAY));
//            dc.setFrom(9);
//            dc.setTo(14);
//             doctor.getDoctor_constrains().add(dc);
//             
//             dc=new DoctorConstrain();
//            dc.setID(1);
//            dc.setDay(String.valueOf(DAYS.THURSDAY));
//            dc.setFrom(9);
//            dc.setTo(14);
//            doctor.getDoctor_constrains().add(dc);
//           List_doctors.add(doctor);
            
            
            
            
            
      List_mo3id=dbm.getDoctors("Demonstrator");
//        for (int i=1 ; i<=10 ; i++)
//        {
//             doctor=new Doctor();
//            doctor.setDoctorId(i);
//            doctor.setDoctorName("mo3id"+i);
//            doctor.setDoctorMail("@yahoo");
//            doctor.setDoctorStatus("Doctor");
//                 doctor.setDoctorAvilability(1);
//            List_mo3id.add(doctor);
//        }
     
    
    } 
  public void Random_insert(){
      
      int l =0; int s=0 ;
       for (int i=0 ; i<table.size() ; i++)
       {
           if (table.get(i).getType().equals("Lecture"))
           {
               table.get(i).setDoctor(List_doctors.get(l++%3));
           }
           else
           {
               table.get(i).setDoctor(List_mo3id.get(s++%10));
           }
       }
      }
     public List<TableCell> insert2(){           
        // make  probabilites independantlly
        for (int i = 0; i < table.size(); i++) {
            
            for (int v = 0; v < places.size(); v++) {
               
                
                
                 // check if place can take num
                int num_person = 0;
                if (table.get(i).getType().equals("Section")) {
                    num_person = (int) (((double) (table.get(i).getEndSection() - table.get(i).getStartSection() + 1) / (double) table.get(i).getMclass().getClass_Section_Number()) * table.get(i).getMclass().getClass_Members_Number());
                } else {
                    num_person = table.get(i).getMclass().getClass_Members_Number();
                }
              
                if (places.get(v).getMax_Place_Number() >= num_person) {
                    
                    
                    
//                   JOptionPane.showMessageDialog(null, table.get(i).getDoctor().getDoctorName()+"\n"+table.get(i).getDoctor().getDoctorAvilability()+"\n"+
//                           table.get(i).getCourse().getCourseName()+"\n"+ table.get(i).getCourse().getGeneralLab()+"\n"
//                   +places.get(v).getPlaceName()+"\n"+ places.get(v).getPlace_Full_Avilability()+"\n"
//                   + places.get(v).getPlace_Generality()+"\n");
                   
                   
                   if (table.get(i).getType().equals("Lecture"))
                   {
                       
                       
                       
                       
                       
                       
                       if ( places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //get all probabilites
                        
                        if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties(places.get(v),table.get(i).getType() ) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                           List<PossibleProbabilityPlace> ppp_list=get_all_properties(places.get(v),table.get(i).getType() ) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places().add(ppp_list.get(iiv));
                        }
                        
                    }
                    else  if ( places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //get all probabilites of doctor time
                         if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                              List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor(places.get(v),table.get(i).getDoctor(),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                               List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor(places.get(v),table.get(i).getDoctor(),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places( ).add(ppp_list.get(iiv));
                        }
                        
                    }
                    else  if ( places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //get all probabilites place time
                        
                          if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_place(places.get(v),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                               List<PossibleProbabilityPlace> ppp_list=get_all_properties_place(places.get(v),table.get(i).getType()) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places().add(ppp_list.get(iiv));
                        }
                        
                    }
                    else  if ( places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //get all prpbabilites of place and doctor time 
                           if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                              List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor_place(places.get(v),table.get(i).getDoctor(),table.get(i).getType()) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor_place(places.get(v),table.get(i).getDoctor(),table.get(i).getType()) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places( ).add(ppp_list.get(iiv));
                        }
                        
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                   else  if ( places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //get all probabilites
                       List<PossibleProbabilityPlace> ppp_list=get_all_properties(places.get(v),table.get(i).getType() ) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                       table.get(i).getPossible_prpbability_places_bad_mood_places_generality().add(ppp_list.get(iiv));
                        
                    }
                    else  if ( places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //get all probabilites of doctor time
                        List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor(places.get(v),table.get(i).getDoctor(),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                          table.get(i).getPossible_prpbability_places_bad_mood_places_generality().add(ppp_list.get(iiv));
                        
                    }
                    else  if ( places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //get all probabilites place time
                          List<PossibleProbabilityPlace> ppp_list=get_all_properties_place(places.get(v),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                          table.get(i).getPossible_prpbability_places_bad_mood_places_generality().add(ppp_list.get(iiv));
                        
                    }
                    else  if ( places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //get all prpbabilites of place and doctor time 
                         List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor_place(places.get(v),table.get(i).getDoctor(),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                          table.get(i).getPossible_prpbability_places_bad_mood_places_generality().add(ppp_list.get(iiv));
                        
                    }
                    

                  
                       
                       
                       
                       
                   }
                   else
                   {
                    if (table.get(i).getCourse().getGeneralLab() == 1 && places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //get all probabilites
                        
                        if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                           List<PossibleProbabilityPlace> ppp_list=get_all_properties(places.get(v),table.get(i).getType()) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv) );
                        }
                        else
                        {
                           List<PossibleProbabilityPlace> ppp_list=get_all_properties(places.get(v),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places().add(ppp_list.get(iiv));
                        }
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 1 && places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //get all probabilites of doctor time
                         if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor(places.get(v),table.get(i).getDoctor(),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor(places.get(v),table.get(i).getDoctor(),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places( ).add(ppp_list.get(iiv));
                        }
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 1 && places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //get all probabilites place time
                        
                          if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_place(places.get(v),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_place(places.get(v),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places( ).add(ppp_list.get(iiv));
                        }
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 1 && places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //get all prpbabilites of place and doctor time 
                           if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor_place(places.get(v),table.get(i).getDoctor(),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                              List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor_place(places.get(v),table.get(i).getDoctor(),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places( ).add(ppp_list.get(iiv));
                        }
                        
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                   else  if (table.get(i).getCourse().getGeneralLab() == 1 && places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //get all probabilites
                         List<PossibleProbabilityPlace> ppp_list=get_all_properties(places.get(v),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                       table.get(i).getPossible_prpbability_places_bad_mood_places_generality().add(ppp_list.get(iiv));
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 1 && places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //get all probabilites of doctor time
                        List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor(places.get(v),table.get(i).getDoctor(),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                          table.get(i).getPossible_prpbability_places_bad_mood_places_generality().add(ppp_list.get(iiv));
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 1 && places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //get all probabilites place time
                         List<PossibleProbabilityPlace> ppp_list=get_all_properties_place(places.get(v),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                          table.get(i).getPossible_prpbability_places_bad_mood_places_generality().add(ppp_list.get(iiv));
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 1 && places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //get all prpbabilites of place and doctor time 
                          List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor_place(places.get(v),table.get(i).getDoctor(),table.get(i).getType());
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                          table.get(i).getPossible_prpbability_places_bad_mood_places_generality().add(ppp_list.get(iiv));
                        
                    }
                    

                    
                    
                    
                    
                    
                    else  if (table.get(i).getCourse().getGeneralLab() == 0 && places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //do noting
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 0 && places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //do noting
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 0 && places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        //do noting
                        
                    }
                    else  if (table.get(i).getCourse().getGeneralLab() == 0 && places.get(v).getPlace_Generality() == 1
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                        //do noting
                        
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                     else  if ( check_if_course_in_place_courses(places.get(v),table.get(i).getCourse()) && table.get(i).getCourse().getGeneralLab() == 0 && places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                         if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                            List<PossibleProbabilityPlace> ppp_list=get_all_properties(places.get(v),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                              List<PossibleProbabilityPlace> ppp_list=get_all_properties(places.get(v),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places().add(ppp_list.get(iiv));
                        }
                        
                        
                    }
                    else  if (check_if_course_in_place_courses(places.get(v),table.get(i).getCourse()) &&table.get(i).getCourse().getGeneralLab() == 0 && places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 1 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                    
                  
                        //get all probabilites of doctor time
                         if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor(places.get(v),table.get(i).getDoctor(),table.get(i).getType() );
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor(places.get(v),table.get(i).getDoctor(),table.get(i).getType() ) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places().add(ppp_list.get(iiv));
                        }
                        
                   
                        
                    }
                    else  if (check_if_course_in_place_courses(places.get(v),table.get(i).getCourse()) &&table.get(i).getCourse().getGeneralLab() == 0 && places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 1) {
                        
                        
                        //get all probabilites place time
                        
                          if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                              List<PossibleProbabilityPlace> ppp_list=get_all_properties_place(places.get(v),table.get(i).getType() ) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_place(places.get(v),table.get(i).getType() ) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places().add(ppp_list.get(iiv));
                        }
                        
                   
                      
                        
                    }
                    else  if (check_if_course_in_place_courses(places.get(v),table.get(i).getCourse()) &&table.get(i).getCourse().getGeneralLab() == 0 && places.get(v).getPlace_Generality() == 0
                            && places.get(v).getPlace_Full_Avilability() == 0 && table.get(i).getDoctor().getDoctorAvilability() == 0) {
                       
                        
                          //get all prpbabilites of place and doctor time 
                           if ((int)(places.get(v).getMax_Place_Number()/2)>num_person)
                        {
                             List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor_place(places.get(v),table.get(i).getDoctor(),table.get(i).getType()) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                            table.get(i).getPossible_prpbability_places_bad_mood_places_number().add(ppp_list.get(iiv));
                        }
                        else
                        {
                              List<PossibleProbabilityPlace> ppp_list=get_all_properties_doctor_place(places.get(v),table.get(i).getDoctor(),table.get(i).getType()) ;
                           for (int iiv=0 ; iiv<ppp_list.size() ; iiv++)
                              table.get(i).getPossible_prpbability_places( ).add(ppp_list.get(iiv));
                        }
                        
                        
                        
                    }
                    
                   
                    
                }
                   
                   
                }
            }
            
//             System.out.println(table.get(i).getMclass().getClassName()+" * "+table.get(i).getCourse().getCourseName()+" * "+table.get(i).getStartSection()+" * "
//            +table.get(i).getEndSection()+" * "+table.get(i).getType()+" * "+table.get(i).getDoctor().getDoctorName());
//            System.out.println("**************** possible places *******************************");
//            for (int v=0 ; v<table.get(i).getPossible_prpbability_places().size() ; v++)
//            {
//                
//                  System.out.println(table.get(i).getPossible_prpbability_places().get(v).getPlace().getPlaceName()
//                +"-"+table.get(i).getPossible_prpbability_places().get(v).getDay()
//                +"-"+table.get(i).getPossible_prpbability_places().get(v).getFrom()
//                +"-"+table.get(i).getPossible_prpbability_places().get(v).getTo());
//            }
//              System.out.println("**************** possible places bad mood number *******************************");
//            for (int v=0 ; v<table.get(i).getPossible_prpbability_places_bad_mood_places_number().size() ; v++)
//            {
//               
//                 System.out.println(table.get(i).getPossible_prpbability_places_bad_mood_places_number().get(v).getPlace().getPlaceName()
//                +"-"+table.get(i).getPossible_prpbability_places_bad_mood_places_number().get(v).getDay()
//                +"-"+table.get(i).getPossible_prpbability_places_bad_mood_places_number().get(v).getFrom()
//                +"-"+table.get(i).getPossible_prpbability_places_bad_mood_places_number().get(v).getTo());
//            }
//               System.out.println("**************** possible places bad mood general *******************************");
//            for (int v=0 ; v<table.get(i).getPossible_prpbability_places_bad_mood_places_generality().size() ; v++)
//            {
//                System.out.println(table.get(i).getPossible_prpbability_places_bad_mood_places_generality().get(v).getPlace().getPlaceName()
//                +"-"+table.get(i).getPossible_prpbability_places_bad_mood_places_generality().get(v).getDay()
//                +"-"+table.get(i).getPossible_prpbability_places_bad_mood_places_generality().get(v).getFrom()
//                +"-"+table.get(i).getPossible_prpbability_places_bad_mood_places_generality().get(v).getTo());
//            }
//            System.out.println("");
//            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println("");

        }
        
        
         List<TableCell>SortedTable=new ArrayList<>();
         int index_min= 0 ;
         
        for (int i= 0 ; i<table.size() ; )
        {
            index_min=0 ;
            for (int v=1 ; v<table.size() ; v++)
            {
                if (table.get(index_min).getPossible_prpbability_places().size()+table.get(index_min).getPossible_prpbability_places_bad_mood_places_generality().size()+table.get(index_min).getPossible_prpbability_places_bad_mood_places_number().size()
                        >table.get(v).getPossible_prpbability_places().size()+table.get(v).getPossible_prpbability_places_bad_mood_places_generality().size()+table.get(v).getPossible_prpbability_places_bad_mood_places_number().size())
                {
                    index_min=v ;
                }
            }
            SortedTable.add(table.get(index_min));
            table.remove(index_min);
        }
        table=null;
        
      
       
        
        
        
        
        
        // get probabilites dependantlly 
        
       
        
        for (int st=0 ; st<SortedTable.size() ; st++) // for make place for each period
        { boolean flag=false ;
            for (int pro=0 ; pro<SortedTable.get(st).getPossible_prpbability_places().size() ; pro++) // for choose probability of alot of probabilities
            {
                flag=true ;
                for (int Dst= 0 ; Dst<st ; Dst++)  // for check if probability first time tooken
                {

                    if (SortedTable.get(Dst).getPlace()!=null)
                    {
                    if (
                            (SortedTable.get(Dst).getPlace().getPlaceId()==SortedTable.get(st).getPossible_prpbability_places().get(pro).getPlace().getPlaceId()
                            &&
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places().get(pro).getDay() )
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places().get(pro).getTo())
                            )
                            ||
                            (SortedTable.get(Dst).getDoctor().getDoctorId()==SortedTable.get(st).getDoctor().getDoctorId()
                            &&
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places().get(pro).getDay() )
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places().get(pro).getTo())
                            )
                            ||
                            (SortedTable.get(Dst).getMclass().getClassId()==SortedTable.get(st).getMclass().getClassId()
                            &&
                           
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places().get(pro).getDay() )
                            &&
//                             (
//                              SortedTable.get(Dst).getStartSection()==SortedTable.get(st).getStartSection()
//                            ||
//                              SortedTable.get(Dst).getEndSection()==SortedTable.get(st).getEndSection()
//                            ||
//                              ( SortedTable.get(Dst).getEndSection()>SortedTable.get(st).getEndSection()&& SortedTable.get(Dst).getStartSection()<SortedTable.get(st).getStartSection())
//                             )
                             SectionCompare( SortedTable.get(Dst).getStartSection(),  SortedTable.get(Dst).getEndSection(),
                                      SortedTable.get(Dst).getStartSection(), SortedTable.get(Dst).getEndSection())
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places().get(pro).getTo())
                            )
                        )
                    {
                       flag=false ; 
                       break ; 
                    }
                    }
                }
                if (flag==true)
                {
                    SortedTable.get(st).setPlace(SortedTable.get(st).getPossible_prpbability_places().get(pro).getPlace());
                     SortedTable.get(st).setDay(SortedTable.get(st).getPossible_prpbability_places().get(pro).getDay());
                    SortedTable.get(st).setStartTime(SortedTable.get(st).getPossible_prpbability_places().get(pro).getFrom());
                    SortedTable.get(st).setEndTime(SortedTable.get(st).getPossible_prpbability_places().get(pro).getTo());
                    break ;
                }
            }
            if (flag==false)
            {
                for (int pro=0 ; pro<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().size() ; pro++) // for choose probability of alot of probabilities
            {
                flag=true ;
                for (int Dst= 0 ; Dst<st ; Dst++)  // for check if probability first time tooken
                {

                    if (SortedTable.get(Dst).getPlace()!=null)
                    {
                   
                        if (
                            (SortedTable.get(Dst).getPlace().getPlaceId()==SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getPlace().getPlaceId()
                            &&
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getDay() )
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getTo())
                            )
                            ||
                            (SortedTable.get(Dst).getDoctor().getDoctorId()==SortedTable.get(st).getDoctor().getDoctorId()
                            &&
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getDay() )
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getTo())
                            )
                            ||
                            (SortedTable.get(Dst).getMclass().getClassId()==SortedTable.get(st).getMclass().getClassId()
                            &&
                           
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getDay() )
                            &&
//                             (
//                              SortedTable.get(Dst).getStartSection()==SortedTable.get(st).getStartSection()
//                            ||
//                              SortedTable.get(Dst).getEndSection()==SortedTable.get(st).getEndSection()
//                            ||
//                              ( SortedTable.get(Dst).getEndSection()>SortedTable.get(st).getEndSection()&& SortedTable.get(Dst).getStartSection()<SortedTable.get(st).getStartSection())
//                             )
                             SectionCompare( SortedTable.get(Dst).getStartSection(),  SortedTable.get(Dst).getEndSection(),
                                      SortedTable.get(Dst).getStartSection(), SortedTable.get(Dst).getEndSection())
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getTo())
                            )
                        )
                    {
                       flag=false ; 
                       break ; 
                    }
                    }
                }
                if (flag==true)
                {
                    SortedTable.get(st).setPlace(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getPlace());
                     SortedTable.get(st).setDay(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getDay());
                    SortedTable.get(st).setStartTime(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getFrom());
                    SortedTable.get(st).setEndTime(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getTo());
                    break ;
                }
            }
            }
            if (flag==false)
            {
                 for (int pro=0 ; pro<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().size() ; pro++) // for choose probability of alot of probabilities
            {
                flag=true ;
                for (int Dst= 0 ; Dst<st ; Dst++)  // for check if probability first time tooken
                {

                    if (SortedTable.get(Dst).getPlace()!=null)
                    {
                    
                        
                        if (
                            (SortedTable.get(Dst).getPlace().getPlaceId()==SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getPlace().getPlaceId()
                            &&
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getDay() )
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getTo())
                            )
                            ||
                            (SortedTable.get(Dst).getDoctor().getDoctorId()==SortedTable.get(st).getDoctor().getDoctorId()
                            &&
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getDay() )
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getTo())
                            )
                            ||
                            (SortedTable.get(Dst).getMclass().getClassId()==SortedTable.get(st).getMclass().getClassId()
                            &&
                           
                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getDay() )
                            &&
                             
                              SectionCompare( SortedTable.get(Dst).getStartSection(),  SortedTable.get(Dst).getEndSection(),
                                      SortedTable.get(Dst).getStartSection(), SortedTable.get(Dst).getEndSection())
                           
                            &&
                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getTo())
                            )
                        )
                        
                    {
                       flag=false ; 
                       break ; 
                    }
                    }
                }
                if (flag==true)
                {
                    SortedTable.get(st).setPlace(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getPlace());
                     SortedTable.get(st).setDay(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getDay());
                    SortedTable.get(st).setStartTime(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getFrom());
                    SortedTable.get(st).setEndTime(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getTo());
                    break ;
                }
            }
            }
             String place_name="";
            Time from = null , to = null; String Day="";
           if (SortedTable.get(st).getPlace()!=null) 
           { place_name=SortedTable.get(st).getPlace().getPlaceName() ; from=SortedTable.get(st).getStartTime() ;to=SortedTable.get(st).getEndTime() ;Day=SortedTable.get(st).getDay() ;}
             System.out.println(SortedTable.get(st).getMclass().getClassName()+" * "+SortedTable.get(st).getCourse().getCourseName()+" * "+SortedTable.get(st).getStartSection()+" * "
            +SortedTable.get(st).getEndSection()+" * "+SortedTable.get(st).getType()+" * "+SortedTable.get(st).getDoctor().getDoctorName()+" * "
             +place_name+" * "+Day+" * "+from+" * "+to);
            System.out.println("**************** possible places *******************************");
            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places().size() ; v++)
            {
                
                  System.out.println(SortedTable.get(st).getPossible_prpbability_places().get(v).getPlace().getPlaceName()
                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getDay()
                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getFrom()
                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getTo());
            }
              System.out.println("**************** possible places bad mood number *******************************");
            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().size() ; v++)
            {
               
                 System.out.println(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getPlace().getPlaceName()
                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getDay()
                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getFrom()
                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getTo());
            }
               System.out.println("**************** possible places bad mood general *******************************");
            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().size() ; v++)
            {
                System.out.println(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getPlace().getPlaceName()
                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getDay()
                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getFrom()
                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getTo());
            }
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");

            
            
        }
        
        
//        System.out.println("  #########################################################################################################################################################################" );
//         for (int st=0 ; st<SortedTable.size() ; st++) // for make place for each period
//        {   
//             if (SortedTable.get(st).getPlace()==null)
//             {
//            for (int pro=0 ; pro<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().size() ; pro++) // for choose probability of alot of probabilities
//            {
//                flag=true ;
//                for (int Dst= 0 ; Dst<SortedTable.size() ; Dst++)  // for check if probability first time tooken
//                {
//
//                    if (SortedTable.get(Dst).getPlace()!=null)
//                    {
//                   
//                        if (
//                            (SortedTable.get(Dst).getPlace().getPlaceId()==SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getPlace().getPlaceId()
//                            &&
//                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getDay() )
//                            &&
//                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
//                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getTo())
//                            )
//                            ||
//                            (SortedTable.get(Dst).getDoctor().getDoctorId()==SortedTable.get(st).getDoctor().getDoctorId()
//                            &&
//                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getDay() )
//                            &&
//                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
//                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getTo())
//                            )
//                            ||
//                            (SortedTable.get(Dst).getMclass().getClassId()==SortedTable.get(st).getMclass().getClassId()
//                            &&
//                           
//                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getDay() )
//                            &&
////                             (
////                              SortedTable.get(Dst).getStartSection()==SortedTable.get(st).getStartSection()
////                            ||
////                              SortedTable.get(Dst).getEndSection()==SortedTable.get(st).getEndSection()
////                            ||
////                              ( SortedTable.get(Dst).getEndSection()>SortedTable.get(st).getEndSection()&& SortedTable.get(Dst).getStartSection()<SortedTable.get(st).getStartSection())
////                             )
//                             SectionCompare( SortedTable.get(Dst).getStartSection(),  SortedTable.get(Dst).getEndSection(),
//                                      SortedTable.get(Dst).getStartSection(), SortedTable.get(Dst).getEndSection())
//                            &&
//                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
//                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getTo())
//                            )
//                        )
//                    {
//                       flag=false ; 
//                       break ; 
//                    }
//                    }
//                }
//                if (flag==true)
//                {
//                    SortedTable.get(st).setPlace(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getPlace());
//                     SortedTable.get(st).setDay(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getDay());
//                    SortedTable.get(st).setStartTime(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getFrom());
//                    SortedTable.get(st).setEndTime(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(pro).getTo());
//                    break ;
//                }
//            } 
//           
//             String place_name="";
//            Time from = null , to = null; String Day="";
//           if (SortedTable.get(st).getPlace()!=null) 
//           { place_name=SortedTable.get(st).getPlace().getPlaceName() ; from=SortedTable.get(st).getStartTime() ;to=SortedTable.get(st).getEndTime() ;Day=SortedTable.get(st).getDay() ;}
//             System.out.println(SortedTable.get(st).getMclass().getClassName()+" * "+SortedTable.get(st).getCourse().getCourseName()+" * "+SortedTable.get(st).getStartSection()+" * "
//            +SortedTable.get(st).getEndSection()+" * "+SortedTable.get(st).getType()+" * "+SortedTable.get(st).getDoctor().getDoctorName()+" * "
//             +place_name+" * "+Day+" * "+from+" * "+to);
//            System.out.println("**************** possible places *******************************");
//            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places().size() ; v++)
//            {
//                
//                  System.out.println(SortedTable.get(st).getPossible_prpbability_places().get(v).getPlace().getPlaceName()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getDay()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getFrom()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getTo());
//            }
//              System.out.println("**************** possible places bad mood number *******************************");
//            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().size() ; v++)
//            {
//               
//                 System.out.println(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getPlace().getPlaceName()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getDay()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getFrom()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getTo());
//            }
//               System.out.println("**************** possible places bad mood general *******************************");
//            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().size() ; v++)
//            {
//                System.out.println(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getPlace().getPlaceName()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getDay()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getFrom()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getTo());
//            }
//            System.out.println("");
//            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println("");
//
//            
//         }
//        }
//         
//                 System.out.println("  ################################################################################################################################################################" );
//         
//         for (int st=0 ; st<SortedTable.size() ; st++) // for make place for each period
//        {   
//             if (SortedTable.get(st).getPlace()==null)
//             {
//            for (int pro=0 ; pro<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().size() ; pro++) // for choose probability of alot of probabilities
//            {
//                flag=true ;
//                for (int Dst= 0 ; Dst<SortedTable.size() ; Dst++)  // for check if probability first time tooken
//                {
//
//                    if (SortedTable.get(Dst).getPlace()!=null)
//                    {
//                    
//                        
//                        if (
//                            (SortedTable.get(Dst).getPlace().getPlaceId()==SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getPlace().getPlaceId()
//                            &&
//                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getDay() )
//                            &&
//                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
//                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getTo())
//                            )
//                            ||
//                            (SortedTable.get(Dst).getDoctor().getDoctorId()==SortedTable.get(st).getDoctor().getDoctorId()
//                            &&
//                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getDay() )
//                            &&
//                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
//                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getTo())
//                            )
//                            ||
//                            (SortedTable.get(Dst).getMclass().getClassId()==SortedTable.get(st).getMclass().getClassId()
//                            &&
//                           
//                            SortedTable.get(Dst).getDay().equals(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getDay() )
//                            &&
//                             
//                              SectionCompare( SortedTable.get(Dst).getStartSection(),  SortedTable.get(Dst).getEndSection(),
//                                      SortedTable.get(Dst).getStartSection(), SortedTable.get(Dst).getEndSection())
//                           
//                            &&
//                             TimeCompare(SortedTable.get(Dst).getStartTime(), SortedTable.get(Dst).getEndTime(), 
//                             SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getFrom(), SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getTo())
//                            )
//                        )
//                        
//                    {
//                       flag=false ; 
//                       break ; 
//                    }
//                    }
//                }
//                if (flag==true)
//                {
//                    SortedTable.get(st).setPlace(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getPlace());
//                     SortedTable.get(st).setDay(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getDay());
//                    SortedTable.get(st).setStartTime(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getFrom());
//                    SortedTable.get(st).setEndTime(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(pro).getTo());
//                    break ;
//                }
//            }
//            
//             
//            String place_name="";
//            Time from = null , to = null; String Day="";
//           if (SortedTable.get(st).getPlace()!=null) 
//           { place_name=SortedTable.get(st).getPlace().getPlaceName() ; from=SortedTable.get(st).getStartTime() ;to=SortedTable.get(st).getEndTime() ;Day=SortedTable.get(st).getDay() ;}
//             System.out.println(SortedTable.get(st).getMclass().getClassName()+" * "+SortedTable.get(st).getCourse().getCourseName()+" * "+SortedTable.get(st).getStartSection()+" * "
//            +SortedTable.get(st).getEndSection()+" * "+SortedTable.get(st).getType()+" * "+SortedTable.get(st).getDoctor().getDoctorName()+" * "
//             +place_name+" * "+Day+" * "+from+" * "+to);
//            System.out.println("**************** possible places *******************************");
//            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places().size() ; v++)
//            {
//                
//                  System.out.println(SortedTable.get(st).getPossible_prpbability_places().get(v).getPlace().getPlaceName()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getDay()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getFrom()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places().get(v).getTo());
//            }
//              System.out.println("**************** possible places bad mood number *******************************");
//            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().size() ; v++)
//            {
//               
//                 System.out.println(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getPlace().getPlaceName()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getDay()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getFrom()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_number().get(v).getTo());
//            }
//               System.out.println("**************** possible places bad mood general *******************************");
//            for (int v=0 ; v<SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().size() ; v++)
//            {
//                System.out.println(SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getPlace().getPlaceName()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getDay()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getFrom()
//                +"-"+SortedTable.get(st).getPossible_prpbability_places_bad_mood_places_generality().get(v).getTo());
//            }
//            System.out.println("");
//            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println("");
//
//            
//             
//           
//             }   
//        }
//        
//        
//        
//        
//        
//        
        
        
        
        
        
        
        
        
        
        
        
        
        

            // display table
        
//        for (int i=0 ; i<table.size() ; i++)
//        {
//            System.out.println(table.get(i).getMclass().getClassName()+" * "+table.get(i).getCourse().getCourseName()+" * "+table.get(i).getStartSection()+" * "
//            +table.get(i).getEndSection()+" * "+table.get(i).getType()+" * "+table.get(i).getDoctor().getDoctorName());
//            System.out.println("**************** possible places *******************************");
//            for (int v=0 ; v<table.get(i).getPossible_prpbability_places().size() ; v++)
//            {
//                System.out.println(table.get(i).getPossible_prpbability_places().get(v));
//            }
//              System.out.println("**************** possible places bad mood number *******************************");
//            for (int v=0 ; v<table.get(i).getPossible_prpbability_places_bad_mood_places_number().size() ; v++)
//            {
//                System.out.println(table.get(i).getPossible_prpbability_places_bad_mood_places_number().get(v));
//            }
//               System.out.println("**************** possible places bad mood general *******************************");
//            for (int v=0 ; v<table.get(i).getPossible_prpbability_places_bad_mood_places_generality().size() ; v++)
//            {
//                System.out.println(table.get(i).getPossible_prpbability_places_bad_mood_places_generality().get(v));
//            }
//            System.out.println("");
//            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println("");
//        }
      
         return SortedTable ;
    }
    
   
//   
//public enum DAYS {
//   SUNDAY ,MONDAY ,TUESDAY ,WEDNESDAY ,THURSDAY  ,SATURDAY ;
//  
//
//}
 

  List get_all_properties(Place place , String type )
{
    List<PossibleProbabilityPlace> poosible_places=new ArrayList<>();
    for (int i=0 ; i<GINFO.getDays().size() ; i++)
    {
        for (Time v=GINFO.getStartTime() ; v.before(GINFO.getEndTime()) ; )
        {
           
            PossibleProbabilityPlace ppp =new PossibleProbabilityPlace();
            ppp.setPlace(place);
            ppp.setDay(GINFO.getDays().get(i));
            ppp.setFrom(v);
            if (type.equals("Lecture"))
            {
                ppp.setTo(time_add_hour(v, GINFO.getLecturePeriod()));
                v=time_add_hour(v, GINFO.getLecturePeriod()) ;
            }
            else
            {
                ppp.setTo(time_add_hour(v, GINFO.getSectionPeriod()));
                v=time_add_hour(v, GINFO.getSectionPeriod()) ;
            }
            poosible_places.add(ppp);
            
        }
    }
    return poosible_places ;
}
 
  List get_all_properties_doctor(Place place, Doctor doctor , String type )
{
    List<PossibleProbabilityPlace> poosible_places=new ArrayList<>();
    for (int i=0 ; i<doctor.getDoctor_constrains().size() ; i++)
    {
        for (Time v=doctor.getDoctor_constrains().get(i).getFrom() ; v.before(doctor.getDoctor_constrains().get(i).getTo()) ; )
        {
           
            PossibleProbabilityPlace ppp =new PossibleProbabilityPlace();
            ppp.setPlace(place);
            ppp.setDay(doctor.getDoctor_constrains().get(i).getDay());
            ppp.setFrom(v);
            if (type.equals("Lecture"))
            {
                 ppp.setTo(time_add_hour(v, GINFO.getLecturePeriod()));
                v=time_add_hour(v, GINFO.getLecturePeriod()) ;
            }
            else
            {
                 ppp.setTo(time_add_hour(v, GINFO.getSectionPeriod()));
                v=time_add_hour(v, GINFO.getSectionPeriod()) ;
            }
            poosible_places.add(ppp);
            
        }
    }
    return poosible_places ;
}
   List get_all_properties_place(Place place, String type )
{
    List<PossibleProbabilityPlace> poosible_places=new ArrayList<>();
    for (int i=0 ; i<place.getPlace_avilable_period().size() ; i++)
    {
        for (Time v=place.getPlace_avilable_period().get(i).getFrom() ; v.before(place.getPlace_avilable_period().get(i).getTO()) ; )
        {
            
            PossibleProbabilityPlace ppp =new PossibleProbabilityPlace();
            ppp.setPlace(place);
            ppp.setDay(place.getPlace_avilable_period().get(i).getDay());
            ppp.setFrom(v);
           
            if (type.equals("Lecture"))
            {
               
                ppp.setTo(time_add_hour(v, GINFO.getLecturePeriod()));
                v=time_add_hour(v, GINFO.getLecturePeriod()) ;
                
            }
            else
            {
                ppp.setTo(time_add_hour(v, GINFO.getSectionPeriod()));
                v=time_add_hour(v, GINFO.getSectionPeriod()) ;
            }
               
            poosible_places.add(ppp);
            
        }
    }
    return poosible_places ;
}
  
    List get_all_properties_doctor_place(Place place, Doctor doctor , String type )
{
    
  
    
    List<PossibleProbabilityPlace> poosible_places=new ArrayList<>();
    
    for (int i=0 ; i<doctor.getDoctor_constrains().size() ; i++)
    {
          for (int ii=0 ; ii<place.getPlace_avilable_period().size() ; ii++)
    {
        if (doctor.getDoctor_constrains().get(i).getDay().equals(place.getPlace_avilable_period().get(ii).getDay()))
        {
            
           Time from , to  ;
           if (doctor.getDoctor_constrains().get(i).getFrom().before(place.getPlace_avilable_period().get(ii).getFrom()))
           {
             
               from=place.getPlace_avilable_period().get(ii).getFrom() ;
           }
           else
           {
               from=doctor.getDoctor_constrains().get(i).getFrom() ;
           }
           
           if (doctor.getDoctor_constrains().get(i).getTo().after(place.getPlace_avilable_period().get(ii).getTO()))
           {
               to=place.getPlace_avilable_period().get(ii).getTO();
           }
           else
           {
               to=doctor.getDoctor_constrains().get(i).getTo() ;
           }
           
           
            for (Time v=from ; v.before(to) ; )
            {

                PossibleProbabilityPlace ppp =new PossibleProbabilityPlace();
                ppp.setPlace(place);
                ppp.setDay(doctor.getDoctor_constrains().get(i).getDay());
                ppp.setFrom(v);
                if (type.equals("Lecture"))
                {
                 ppp.setTo(time_add_hour(v, GINFO.getLecturePeriod()));
                v=time_add_hour(v, GINFO.getLecturePeriod()) ;
                }
                else
                {
                    ppp.setTo(time_add_hour(v, GINFO.getSectionPeriod()));
                v=time_add_hour(v, GINFO.getSectionPeriod()) ;
                }
                poosible_places.add(ppp);

            }
            
            break;
        
        }
    }
    }
    return poosible_places ;
}
 public static boolean check_if_course_in_place_courses(Place place , Course course)
   {
       for (int i=0 ; i<place.getPlace_course().size() ;i++)
       {
          if (place.getPlace_course().get(i).getCourse().getCourseName().equals(course.getCourseName())) 
          {
              return true ;
          }
       }
       return false ;
   }
 
 
 
 
 public static Time time_add_hour(Time time, Time period) {

    
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.HOUR_OF_DAY, period.getHours());
        cal.add(Calendar.MINUTE, period.getMinutes());
        Time ret = new Time(1,0,0) ;
       ret.setTime(cal.getTimeInMillis());

        return ret ;
    }

   public  boolean TimeCompare(Time timecell_start , Time timecell_end , Time timepro_start , Time timepro_end)
    {
        if (       timecell_start.equals(timepro_start) 
                || timecell_end.equals(timepro_end) 
                ||( timecell_start.before(timepro_start)&&timecell_end.after(timepro_start) )
                ||( timecell_start.before(timepro_end)&&timecell_end.after(timepro_end) )
                ||( timepro_start.before(timecell_start)&&timepro_end.after(timecell_start) )
                ||( timepro_start.before(timecell_end)&&timepro_end.after(timecell_end) )
           )
        {
            return true ;
        }
        
        return false ;
    }
    public  boolean SectionCompare( int start_section_det , int end_section_der , int start_section_st ,int end_section_st )
    {
        if (       start_section_det==start_section_st
                || end_section_der==end_section_st
                ||( start_section_det<start_section_st&&start_section_st<end_section_der )
                ||( start_section_det<end_section_st&&end_section_st<end_section_der )
                ||( start_section_st<start_section_det&&start_section_det<end_section_st )
                ||( start_section_st<end_section_der&&end_section_der<end_section_st )
           )
        {
            return true ;
        }
        
        return false ;
    }
    public Time convert_string_to_time(String stime) {
        String h_m[] = stime.split(":");
        Time time = new Time(Integer.parseInt(h_m[0]), Integer.parseInt(h_m[1]), 0);
        return time;

    }
//    public Time get_union_time(Time time1 , Time time2)
//    {
//        Time time_union=new Time(0, 0, 0);
//        if (time1.before(time2))
//        {
//            for (int i=0 ;i<time1. )
//        }
//    }
    
      public static void main(String[] args) {
    InsertData in=new InsertData();
//  
        in.dbm.connect_to_database();
//        
//        in.insert();
          System.out.println(in.SectionCompare(1, 1, 2, 2));
       //   System.out.println(in.TimeCompare(new Time(11, 30, 00), new Time(12, 30, 00), new Time(9, 30, 00), new Time(14, 30, 00)));
    }
      
    public Doctor get_doctor_from_list(int DoctorId)
    {
        for (int i=0 ; i<List_doctors.size() ; i++ )
        {
            if (DoctorId==List_doctors.get(i).getDoctorId())
            {
                return List_doctors.get(i) ;
            }
        }
        
        return null ;
    }
    public Doctor get_mo3id_from_list(int mo3idId)
    {
        for (int i=0 ; i<List_mo3id.size() ; i++ )
        {
            if (mo3idId==List_mo3id.get(i).getDoctorId())
            {
                return List_mo3id.get(i) ;
            }
        }
        
        return null ;
    }
    

}

