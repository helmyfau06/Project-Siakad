/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksiData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class koneksi {
    private static Connection conn;
    public static Connection getConnection(){
       if(conn == null){
           try{
               DriverManager.registerDriver(new com.mysql.jdbc.Driver());
               conn=DriverManager.getConnection("jdbc:mysql://localhost/db_penilaian", "root", "");
           }catch (SQLException ex){
               Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return conn;
    }
    
}
