package Model;

import java.sql.*;

/**
 * @filename    Employee.java
 * @date        Apr 28, 2017
 * @author      rwatkins
 */
public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String social_security;
    private Date last_update;

    
    public Employee(String first_name, String last_name, String social_security){

        this.first_name = first_name;
        this.last_name = last_name;
        this.social_security = social_security;
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
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the social_security
     */
    public String getSocial_security() {
        return social_security;
    }

    /**
     * @param social_security the social_security to set
     */
    public void setSocial_security(String social_security) {
        this.social_security = social_security;
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


}
