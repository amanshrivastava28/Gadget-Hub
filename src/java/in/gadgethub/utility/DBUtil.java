/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.utility;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author pramo
 */
public class DBUtil {
    private static Connection conn;
    public static void openConnection(String dbUrl,String username,String password){
        if(conn==null){
            try{
            
    conn=DriverManager.getConnection(dbUrl, username,password);
            System.out.println("Gadgethub Connection opened");
        }catch(SQLException ex){
            System.out.println("Error in opening connection");
            ex.printStackTrace();
        }
        }
    }
     public static void closeConnection() { try {
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException ex) {
        System.out.println("Error closing connection: " + ex);
        ex.printStackTrace();
    }
}

     public static Connection provideConnection(){
         
         return conn;
     }
     public static void closeResultSet(ResultSet rs){
         if(rs!=null){
     
         try{
         rs.close();
     }catch(SQLException ex) {
             System.out.println("Error in closing ResultSet");
             ex.printStackTrace();
     }
     }
     }
     public static void closeStatement(Statement st){
         if(st!=null){
     
         try{
             st.close();
         } catch(SQLException ex) {
             System.out.println("Error in closing Statement");
             ex.printStackTrace();
     }
         }
     }
    
    
}
