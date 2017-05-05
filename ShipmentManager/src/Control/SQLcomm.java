package Control;

import java.sql.*;
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shipments",
                    "root",
                    "<password>");
        } catch (SQLException ex) {
            Logger.getLogger(SQLcomm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //**************************************************************************
    // Get shipment 
    //**************************************************************************
    
    
    public static void main(String[] args) {
        
        
        
    }
}
