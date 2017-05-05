package Model;

import java.sql.*;

/**
 * @filename    Truck.java
 * @date        Apr 28, 2017
 * @author      rwatkins
 */
public class Truck {
    private int truck_id;
    private String vehicle_id;
    private int employee_id;
    private Date last_update;

    /**
     * @return the truck_id
     */
    public int getTruck_id() {
        return truck_id;
    }

    /**
     * @param truck_id the truck_id to set
     */
    public void setTruck_id(int truck_id) {
        this.truck_id = truck_id;
    }

    /**
     * @return the vehicle_id
     */
    public String getVehicle_id() {
        return vehicle_id;
    }

    /**
     * @param vehicle_id the vehicle_id to set
     */
    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
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
