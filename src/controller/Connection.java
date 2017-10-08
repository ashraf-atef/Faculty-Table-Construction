/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ashraf Atef
 */
public class Connection {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static java.sql.Connection conn = null;
   
      
   
    void conn(String user_name, String password,String ip) throws ClassNotFoundException, SQLException {
        String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
       
        final String DB_URL = "jdbc:mysql://" + ip + "/faculty_table";
        final String USER = user_name;
        final String PASS = password;

      
        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(DB_URL + unicode, USER, PASS);
        
       
    }
    
}
