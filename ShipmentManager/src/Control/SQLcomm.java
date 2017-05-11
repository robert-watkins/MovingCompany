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
    int empss;
    int eid;

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
                        results.getString("order_date"),
                        results.getInt("truck_id"),
                        results.getInt("team_id"),
                        results.getString("status"),
                        results.getDouble("weight"),
                        results.getString("date_in"),
                        results.getString("date_out")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ships;
    }
    
    //**************************************************************************
    // Get Shipment for manager and team dashboard
    //**************************************************************************
  
    public ArrayList getShipments(String search) {
        ArrayList<Shipment> ships = new ArrayList();
        PreparedStatement getShips;
        try {
            getShips = con.prepareStatement("SELECT Shipments.*, "
                    + "Shipments.shipment_id, Customers.first_name, "
                    + "Customers.last_name FROM Shipments JOIN Customers ON "
                    + "Shipments.customer_id=Customers.customer_id where "
                    + "Customers.last_name like ? or Customers.first_name "
                    + "like ? or Shipments.shipment_id = ?");
            getShips.setString(1, "%"+search+"%");
            getShips.setString(2, "%"+search+"%");
            getShips.setString(3, search);
            ResultSet results = getShips.executeQuery();
            while (results.next()) {
                ships.add(new Shipment(
                        results.getInt("shipment_id"),
                        results.getInt("customer_id"),
                        results.getString("last_name"),
                        results.getString("first_name"),
                        results.getString("order_date"),
                        results.getInt("truck_id"),
                        results.getInt("team_id"),
                        results.getString("status"),
                        results.getDouble("weight"),
                        results.getString("date_in"),
                        results.getString("date_out")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ships;
    }

    //**************************************************************************
    // Get Shipment
    //**************************************************************************
    
    public Shipment getShipment(int shipId){
        Shipment ship = null;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from Shipments where shipment_id = ?");
            ps.setInt(1, shipId);
            ResultSet rs = ps.executeQuery();
            ship = new Shipment(
                    rs.getInt("shipment_id"), 
                    rs.getInt("customer_id"), 
                    rs.getString("order_date"), 
                    rs.getInt("truck_id"), 
                    rs.getInt("team_id"), 
                    rs.getString("status"), 
                    rs.getDouble("weight"), 
                    rs.getString("date_in"), 
                    rs.getString("date_out")
            );
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ship;
    }

    //**************************************************************************
    // Get Shipment
    //**************************************************************************
    
    public Customer getCustomer(int custId){
        Customer cust = null;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from Customers where customer_id = ?");
            ps.setInt(1, custId);
            ResultSet rs = ps.executeQuery();
            cust = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("first_name"), 
                    rs.getString("last_name"), 
                    rs.getInt("social_security") 
            );
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cust;
    }
    
    //**************************************************************************
    // update shipment
    //**************************************************************************
    
    public void updateShipment(Shipment ship){
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("UPDATE `Shipments` SET `order_date`= ?, "
                    + "`truck_id`=?,`team_id`=?,`status`=?,`weight`=?,`date_in`=?, "
                    + "`date_out`=? WHERE shipment_id = ?");
            ps.setString(1, ship.getOrder_date());
            ps.setInt(2, ship.getTruck_id());
            ps.setInt(3, ship.getTeam_id());
            ps.setString(4, ship.getStatus());
            ps.setDouble(5, ship.getWeight());
            ps.setString(6, ship.getDate_out());
            ps.setString(7, ship.getDate_in());
            ps.setInt(8, ship.getShipment_id());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    //**************************************************************************
    // create Customer
    //**************************************************************************
    
    public void createCustomer(Customer cust){
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO Customers "
                    + "(`first_name`, `last_name`, `social_security`) "
                    + "VALUES (?, ?, ?); ");
            ps.setString(1, cust.getFirst_name());
            ps.setString(2, cust.getLast_name());
            ps.setInt(3, cust.getSocial_security());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    
    //**************************************************************************
    // create Shipment
    //**************************************************************************
    
    public void createShipment(Shipment ship){
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO Shipments "
                    + "(`customer_id`, `order_date`, `truck_id`, `team_id`, `status`, `weight`, `date_in`, `date_out`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?); ");
            ps.setInt(1, ship.getCustomer_id());
            ps.setString(2, ship.getOrder_date());
            ps.setInt(3, ship.getTruck_id());
            ps.setInt(4, ship.getTeam_id());
            ps.setString(5, ship.getStatus());
            ps.setDouble(6, ship.getWeight());
            ps.setString(7, ship.getDate_in());
            ps.setString(8, ship.getDate_out());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
                
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
    
    //**************************************************************************
    // create Employee
    //**************************************************************************
    
    public void createEmployee(Employee emp){
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO Employees "
                    + "(`first_name`, `last_name`, `social_security`) "
                    + "VALUES (?, ?, ?); ");
            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setString(3, emp.getSocial_security());
            ps.executeUpdate();
            empss = Integer.parseInt(emp.getSocial_security());
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    //**************************************************************************
    // get employee id from social security
    //**************************************************************************
    
    public int getId(int ss){
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from Employees where social_security = ?");
            ps.setInt(1, ss);
            ResultSet re = ps.executeQuery();
            if(re.next()){
                eid = re.getInt("employee_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return eid;
    }
    
    //**************************************************************************
    // get employee id from social security
    //**************************************************************************
    
    public int getCustomerId(int ss){
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from Customers where social_security = ?");
            ps.setInt(1, ss);
            ResultSet re = ps.executeQuery();
            if(re.next()){
                eid = re.getInt("customer_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return eid;
    }
    
    
    //**************************************************************************
    // create User
    //**************************************************************************
    
    public void createUser(User usr){
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO Users "
                    + "(`employee_id`, `user_name`, `authentication`, `clearance`) "
                    + "VALUES ( ?, ?, ?, ?); ");
            
            ps.setInt(1, usr.getEmployee_id());
            ps.setString(2, usr.getUser_name());
            ps.setString(3, usr.getAuthentication());
            ps.setString(4, usr.getClearance());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public static void main(String[] args) {
        SQLcomm sql = new SQLcomm();
        System.out.println(sql.isValid("rwatkins"));
        
        //User user = sql.getAuth("rwatkins");
        //System.out.print(user.getUser_name()+","+user.getAuthentication());
        
    }
}
