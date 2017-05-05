package Model;

import java.sql.*;

/**
 * @filename    Inventory.java
 * @date        Apr 28, 2017
 * @author      rwatkins
 */
public class Inventory {
    private int inventory_id;
    private String[] inventory;
    private Date last_update;

    /**
     * @return the inventory_id
     */
    public int getInventory_id() {
        return inventory_id;
    }

    /**
     * @param inventory_id the inventory_id to set
     */
    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    /**
     * @return the inventory
     */
    public String[] getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(String[] inventory) {
        this.inventory = inventory;
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
