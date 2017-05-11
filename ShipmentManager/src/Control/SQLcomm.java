package Control;

import Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @filename    SQLcomm.java
 * @date        Apr 28, 2017
 * @author      rwatkins
 */
public class SQLcomm {

    Connection con = null;

    public SQLcomm() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://watkins.network:3306/shipping_manager",
                    "rwatkins",
                    "444#ishZ");
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //**************************************************************************
    // Get Shipment for manager and team dashboard
    //**************************************************************************
    
    
    
    //**************************************************************************
    // Get Authentication
    //**************************************************************************
    
    public User getAuth(String username){
        User user = null;
        
        PreparedStatement getUsers;
        try {
            getUsers = con.prepareStatement("select * from Users where user_name = ? ");
            getUsers.setString(1, username);
            ResultSet results = getUsers.executeQuery();
            while(results.next()){
                user = new User(
                        results.getInt("user_id"), 
                        results.getInt("employee_id"), 
                        results.getString("user_name"),
                        results.getString("authentication"), 
                        results.getString("clearance")
                );
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        return user;
    }
    
    //**************************************************************************
    // isValid - checks to see if username is valid
    //**************************************************************************
   
    public boolean isValid(String user_name){
        boolean bool = false;
        ArrayList array = new ArrayList();
        
        PreparedStatement getUser_names;
        try {
            getUser_names = con.prepareStatement("select user_name from Users; ");
            
            ResultSet results = getUser_names.executeQuery();
            while(results.next()){
                array.add(results.getString("user_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(array.contains(user_name)){
            bool=true;
        }
        
        return bool;
    }
    
    public static void main(String[] args) {
        SQLcomm sql = new SQLcomm();
        System.out.println(sql.isValid("rwatkins"));
        
        //User user = sql.getAuth("rwatkins");
        //System.out.print(user.getUser_name()+","+user.getAuthentication());
        
    }
}
