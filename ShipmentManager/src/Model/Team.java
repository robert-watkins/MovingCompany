package Model;

import java.sql.*;

/**
 * @filename    Team.java
 * @date        Apr 28, 2017
 * @author      rwatkins
 */
public class Team {
    private int team_id;
    private int employee_id;
    private Date last_update;

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
