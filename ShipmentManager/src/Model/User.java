package Model;

import java.sql.*;

/**
 * @filename    User.java
 * @date        Apr 28, 2017
 * @author      rwatkins
 */
public class User {
    private int user_id;
    private int employee_id;
    private String user_name;
    private String authentication;
    private String clearance;
    private Date last_update;
    
    public User(int user_id, int employee_id, String user_name, String authentication, String clearance){
        this.user_id = user_id;
        this.employee_id = employee_id;
        this.user_name = user_name;
        this.authentication = authentication;
        this.clearance = clearance;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the employee_id
     */
    public int getEmployee_id() {
        return employee_id;
    }

    /**
     * @param employee_id the employee_id to set
     */
    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the authentication
     */
    public String getAuthentication() {
        return authentication;
    }

    /**
     * @param authentication the authentication to set
     */
    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    /**
     * @return the last_update
     */
    public Date getLast_update() {
        return last_update;
    }

    /**
     * @param last_update the last_update to set
     */
    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    /**
     * @return the clearance
     */
    public String getClearance() {
        return clearance;
    }

    /**
     * @param clearance the clearance to set
     */
    public void setClearence(String clearance) {
        this.clearance = clearance;
    }

}
