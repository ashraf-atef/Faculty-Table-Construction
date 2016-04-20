/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;

/**
 *
 * @author Ashraf Atef
 */
public class DatabaseMethods {

    public Connection conn_ob = new Connection();

    public void connect_to_database() {
        try {
            conn_ob.conn("root", "", "127.0.0.1");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Course> GetCourses() {
        List<Course> Courses_list = new ArrayList<>();
        try {
            PreparedStatement stmt = conn_ob.conn.prepareStatement("select * from Course");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                course.setCourseSerial(rs.getString(3));
                course.setMax_Couse_section_Numbers(rs.getInt(4));
                course.setGeneralLab(rs.getInt(5));
                Courses_list.add(course);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Courses_list;
    }

    public List<models.Class> GetClasses() {
        List<models.Class> class_list = new ArrayList<>();
        try {
            PreparedStatement stmt = conn_ob.conn.prepareStatement("select * from class");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                models.Class mclass = new models.Class();
                mclass.setClassId(rs.getInt(1));
                mclass.setClassName(rs.getString(2));
                mclass.setClass_Members_Number(rs.getInt(3));
                mclass.setType(rs.getString(4));
                mclass.setClass_Section_Number(rs.getInt(5));
                class_list.add(mclass);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return class_list;
    }

    public List<ClassCourse> GetClassCourse() {
        List<ClassCourse> class_course_list = new ArrayList<>();
        try {
            PreparedStatement stmt = conn_ob.conn.prepareStatement("select * from ClassCourse "
                    + "left join class on classcourse.classid=class.classid "
                    + " left join course on classcourse.courseid=course.courseid ");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClassCourse classcourse = new ClassCourse();
                classcourse.setID(rs.getInt(1));

                models.Class mclass = new models.Class();
                mclass.setClassId(rs.getInt(4));
                mclass.setClassName(rs.getString(5));
                mclass.setClass_Members_Number(rs.getInt(6));
                mclass.setType(rs.getString(7));
                mclass.setClass_Section_Number(rs.getInt(8));
                classcourse.setmClass(mclass);

                Course course = new Course();
                course.setCourseId(rs.getInt(9));
                course.setCourseName(rs.getString(10));
                course.setCourseSerial(rs.getString(11));
                course.setMax_Couse_section_Numbers(rs.getInt(12));
                course.setGeneralLab(rs.getInt(13));
                classcourse.setCourse(course);

                class_course_list.add(classcourse);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return class_course_list;
    }

    public List<Place> getplaces() {
        List<Place> place_list = new ArrayList<>();
        try {
            PreparedStatement stmt = conn_ob.conn.prepareStatement("select * from place ");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Place place = new Place();
                place.setPlaceId(rs.getInt(1));
                place.setPlaceName(rs.getString(2));
                place.setMax_Place_Number(rs.getInt(3));
                place.setPlace_Full_Avilability(rs.getInt(4));
                place.setPlace_Generality(rs.getInt(5));

                if (place.getPlace_Full_Avilability() == 0) {
                    PreparedStatement stmt_place_constrains = conn_ob.conn.prepareStatement("select * from placeconstrains where "
                            + "placeid= " + rs.getInt(1));
                    ResultSet rs_place_constrains = stmt_place_constrains.executeQuery();
                    while (rs_place_constrains.next()) {
                        PlaceAvilablePeriod pap = new PlaceAvilablePeriod();
                        pap.setID(rs_place_constrains.getInt(1));
                        // pap.setPlaceId(rs_place_constrains.getInt(2));
                        pap.setDay(rs_place_constrains.getString(3));
                        pap.setFrom(rs_place_constrains.getTime(4));
                        pap.setTO(rs_place_constrains.getTime(5));
                        place.getPlace_avilable_period().add(pap);

                    }
                }

                if (place.getPlace_Generality() == 0) {
                    PreparedStatement stmt_place_course_constrains = conn_ob.conn.prepareStatement("select * from placecourseconstrains "
                            + "left join course on placecourseconstrains.courseid=course.courseid "
                            + "where placeid= " + rs.getInt(1));
                    ResultSet rs_place_course_constrains = stmt_place_course_constrains.executeQuery();
                    while (rs_place_course_constrains.next()) {
                        PlaceCourse pc = new PlaceCourse();
                        pc.setID(rs_place_course_constrains.getInt(1));

                        Course course = new Course();
                        course.setCourseId(rs_place_course_constrains.getInt(4));
                        course.setCourseName(rs_place_course_constrains.getString(5));
                        course.setCourseSerial(rs_place_course_constrains.getString(6));
                        course.setMax_Couse_section_Numbers(rs_place_course_constrains.getInt(7));
                        course.setGeneralLab(rs_place_course_constrains.getInt(8));
                        pc.setCourse(course);

                        place.getPlace_course().add(pc);

                    }
                }

                place_list.add(place);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return place_list;
    }

    public List<Doctor> getDoctors(String type) {
        List<Doctor> doctor_list = new ArrayList<>();
        try {
            PreparedStatement stmt = conn_ob.conn.prepareStatement("select * from doctor where DoctorStatus='" + type + "'");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt(1));
                doctor.setDoctorName(rs.getString(2));
                doctor.setDoctorPhone(rs.getString(3));
                doctor.setDoctorStatus(rs.getString(4));
                doctor.setDoctorMail(rs.getString(5));
                doctor.setDoctorAvilability(rs.getInt(6));

                if (doctor.getDoctorAvilability() == 0) {
                    PreparedStatement stmt_doctor_constrains = conn_ob.conn.prepareStatement("select * from doctorconstrains where "
                            + "doctorid= " + rs.getInt(1));
                    ResultSet rs_doctor_constrains = stmt_doctor_constrains.executeQuery();
                    while (rs_doctor_constrains.next()) {
                        DoctorConstrain dc = new DoctorConstrain();
                        dc.setID(rs_doctor_constrains.getInt(1));
                        dc.setDay(rs_doctor_constrains.getString(3));
                        dc.setFrom(rs_doctor_constrains.getTime(4));
                        dc.setTo(rs_doctor_constrains.getTime(5));
                        doctor.getDoctor_constrains().add(dc);

                    }
                }

                doctor_list.add(doctor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctor_list;
    }
    public List<Doctor> getalltDoctors() {
        List<Doctor> doctor_list = new ArrayList<>();
        try {
            PreparedStatement stmt = conn_ob.conn.prepareStatement("select * from doctor ");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt(1));
                doctor.setDoctorName(rs.getString(2));
                doctor.setDoctorPhone(rs.getString(3));
                doctor.setDoctorStatus(rs.getString(4));
                doctor.setDoctorMail(rs.getString(5));
                doctor.setDoctorAvilability(rs.getInt(6));

                if (doctor.getDoctorAvilability() == 0) {
                    PreparedStatement stmt_doctor_constrains = conn_ob.conn.prepareStatement("select * from doctorconstrains where "
                            + "doctorid= " + rs.getInt(1));
                    ResultSet rs_doctor_constrains = stmt_doctor_constrains.executeQuery();
                    while (rs_doctor_constrains.next()) {
                        DoctorConstrain dc = new DoctorConstrain();
                        dc.setID(rs_doctor_constrains.getInt(1));
                        dc.setDay(rs_doctor_constrains.getString(3));
                        dc.setFrom(rs_doctor_constrains.getTime(4));
                        dc.setTo(rs_doctor_constrains.getTime(5));
                        doctor.getDoctor_constrains().add(dc);

                    }
                }

                doctor_list.add(doctor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctor_list;
    }

    public GeneralInformation get_general_info() {
        GeneralInformation gi = new GeneralInformation();
        try {

            PreparedStatement stmt = conn_ob.conn.prepareStatement("select * from generalinformation ");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                gi.setDayHours(rs.getTime(1));
                gi.setSectionPeriod(rs.getTime(2));
                gi.setLecturePeriod(rs.getTime(3));
                gi.setStartTime(rs.getTime(4));
                gi.setEndTime(rs.getTime(5));
                gi.setMaxGroupNumber(rs.getInt(6));
            }

            stmt = conn_ob.conn.prepareStatement("select * from workingdays ");
            rs = stmt.executeQuery();
            while (rs.next()) {
                gi.getDays().add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gi;
    }

        public static void main(String[] args) {
        
            
            DatabaseMethods db=new DatabaseMethods();
          db.connect_to_database();  db.gettable("2015") ;
            
    }
        
        
    public boolean check_int(String num) {
        boolean flag = true;
        try {
            int int_num = Integer.parseInt(num);
            flag = true;
            //joptionpanee.showMessageDialog(null,num);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    public List<TableCell> gettable(String Year)
    {List <TableCell> table=new ArrayList<>();
        try {
            
            
            PreparedStatement stmt = conn_ob.conn.prepareStatement("select * from FacultyTable ft left join class on class.classid=ft.classid "
                    + " left join course on course.courseid=ft.courseid "
                    + " left join doctor on doctor.doctorid=ft.doctorid "
                    + "left join place on place.placeid=ft.placeid "
                  
                    + " where year=?");
            stmt.setString(1, Year);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                TableCell tc=new TableCell();
                tc.setStartSection(rs.getInt(6));
                tc.setEndSection(rs.getInt(7));
                tc.setStartTime(rs.getTime(8));
                tc.setEndTime(rs.getTime(9));
                tc.setDay(rs.getString(10));
                tc.setType(rs.getString(11));
                
                models.Class mclass=new models.Class();
                mclass.setClassId(rs.getInt(13));
                mclass.setClassName(rs.getString(14));
                mclass.setClass_Members_Number(rs.getInt(15));
                mclass.setType(rs.getString(16));
                mclass.setClass_Section_Number(rs.getInt(17));
                tc.setMclass(mclass);
                
                Course course=new Course();
                course.setCourseId(rs.getInt(18));
                course.setCourseName(rs.getString(19));
                course.setCourseSerial(rs.getString(20));
                course.setMax_Couse_section_Numbers(rs.getInt(21));
                course.setGeneralLab(rs.getInt(22));
                tc.setCourse(course);
                
                Doctor docter=new Doctor();
                docter.setDoctorId(rs.getInt(23));
                docter.setDoctorName(rs.getString(24));
                docter.setDoctorPhone(rs.getString(25));
                docter.setDoctorStatus(rs.getString(26));
                docter.setDoctorMail(rs.getString(27));
                docter.setDoctorAvilability(rs.getInt(28));
                tc.setDoctor(docter);
                
                Place place = null;
             
               if (rs.getString(5)!=null)
               {
                place= place=new Place();
                place.setPlaceId(rs.getInt(29));
                place.setPlaceName(rs.getString(30));
                place.setMax_Place_Number(rs.getInt(31));
                place.setPlace_Full_Avilability(rs.getInt(32));
                place.setPlace_Generality(rs.getInt(33));
               
               }
                tc.setPlace(place);
                
                
            PreparedStatement stmt_pro = conn_ob.conn.prepareStatement("select * from tableitemsprobabilities tip "
                    + "left join place on tip.placeid=place.placeid where tip.Cellid=?"
                   );
              
            stmt_pro.setInt(1, rs.getInt(1));
            ResultSet rs_pro = stmt_pro.executeQuery();
            while(rs_pro.next())
            {
                    Place place1 = new Place();
                    place1.setPlaceId(rs_pro.getInt(8));
                    place1.setPlaceName(rs_pro.getString(9));
                    place1.setMax_Place_Number(rs_pro.getInt(10));
                    place1.setPlace_Full_Avilability(rs_pro.getInt(11));
                    place1.setPlace_Generality(rs_pro.getInt(12));
                    
                    PossibleProbabilityPlace ppp=new PossibleProbabilityPlace();
                    ppp.setDay(rs_pro.getString(4));
                    ppp.setFrom(rs_pro.getTime(5));
                    ppp.setTo(rs_pro.getTime(6));
                    ppp.setPlace(place1);
                  
                if (rs_pro.getString(7).equals("Good"))
                {
                   
                    tc.getPossible_prpbability_places().add(ppp);
                }
                else if (rs_pro.getString(7).equals("Bad Mood Place Generality"))
                {
                   
                    tc.getPossible_prpbability_places_bad_mood_places_generality().add(ppp);
                }
                 else if (rs_pro.getString(7).equals("Bad Mood Place Number"))
                {
                    
                    tc.getPossible_prpbability_places_bad_mood_places_number().add(ppp);
                }
                
            }
                
                
                
                
                table.add(tc);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
     return table ;
    }
    


}
