package Model;

import java.sql.*;

/**
 * @filename    Shipment.java
 * @date        Apr 28, 2017
 * @author      rwatkins
 */
public class Shipment {
    private int shipment_id;
    private int customer_id;
    private String last_name;
    private String first_name;
    private Date order_date; 
    private int truck_id;
    private int team_id;

    private String status;
    private double weight;
    private Date date_in;
    private Date date_out;
    private Date last_update;

    public Shipment(int shipment_id, int customer_id, String last_name, 
            String first_name, Date order_date, int truck_id, int team_id, 
            String status, double weight, Date date_in, 
            Date date_out){
        this.shipment_id = shipment_id;
        this.customer_id = customer_id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.order_date = order_date;
        this.truck_id = truck_id;
        this.team_id = team_id;

        this.status = status;
        this.weight = weight;
        this.date_in = date_in;
        this.date_out = date_out;
        
    }
    /**
     * @return the shipment_id
     */
    public int getShipment_id() {
        return shipment_id;
    }

    /**
     * @param shipment_id the shipment_id to set
     */
    public void setShipment_id(int shipment_id) {
        this.shipment_id = shipment_id;
    }

    /**
     * @return the customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the order_date
     */
    public Date getOrder_date() {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

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
     * @return the team_id
     */
    public int getTeam_id() {
        return team_id;
    }

    /**
     * @param team_id the team_id to set
     */
    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the date_in
     */
    public Date getDate_in() {
        return date_in;
    }

    /**
     * @param date_in the date_in to set
     */
    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    /**
     * @return the date_out
     */
    public Date getDate_out() {
        return date_out;
    }

    /**
     * @param date_out the date_out to set
     */
    public void setDate_out(Date date_out) {
        this.date_out = date_out;
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
    
    
    
}
