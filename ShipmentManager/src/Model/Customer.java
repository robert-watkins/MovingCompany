package Model;

import java.sql.*;

/**
 * @filename    Customer.java
 * @date        Apr 28, 2017
 * @author      rwatkins
 */
public class Customer {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private int social_security;
    private String pickup_address;
    private String delivery_address;
    private Date last_update;

    public Customer(String first, String last, int social) {
        this.first_name = first;
        this.last_name = last;
        this.social_security = social;
    }
    
    public Customer(int customerId, String first, String last, int social) {
        this.customer_id = customerId;
        this.first_name = first;
        this.last_name = last;
        this.social_security = social;
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
     * @return the middle_name
     */
    public String getMiddle_name() {
        return middle_name;
    }

    /**
     * @param middle_name the middle_name to set
     */
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    /**
     * @return the social_security
     */
    public int getSocial_security() {
        return social_security;
    }

    /**
     * @param social_security the social_security to set
     */
    public void setSocial_security(int social_security) {
        this.social_security = social_security;
    }

    /**
     * @return the pickup_address
     */
    public String getPickup_address() {
        return pickup_address;
    }

    /**
     * @param pickup_address the pickup_address to set
     */
    public void setPickup_address(String pickup_address) {
        this.pickup_address = pickup_address;
    }

    /**
     * @return the delivery_address
     */
    public String getDelivery_address() {
        return delivery_address;
    }

    /**
     * @param delivery_address the delivery_address to set
     */
    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
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
