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
  
    public ArrayList getShipments() {
        ArrayList<Shipment> ships = new ArrayList();
        PreparedStatement getShips;
        try {
            getShips = con.prepareStatement("SELECT Shipments.*, Customers.first_name, "
                    + "Customers.last_name FROM Shipments\n"
                    + "JOIN Customers ON Shipments.customer_id=Customers.customer_id;");
            ResultSet results = getShips.executeQuery();
            while (results.next()) {
                ships.add(new Shipment(
                        results.getInt("shipment_id"),
                        results.getInt("customer_id"),
                        results.getString("last_name"),
                        results.getString("first_name"),
                        results.getDate("order_date"),
                        results.getInt("truck_id"),
                        results.getInt("team_id"),
                        results.getString("status"),
                        results.getDouble("weight"),
                        results.getDate("date_in"),
                        results.getDate("date_out")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ships;
    }

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
