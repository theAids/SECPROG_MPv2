/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import org.joda.time.LocalDateTime;

/**
 *
 * @author kimberly
 */
public class SignLogBean extends UserBean{
    private int userID;
    private LocalDateTime logDate;
    private int lstatus;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public int getLstatus() {
        return lstatus;
    }

    public void setLstatus(int lstatus) {
        this.lstatus = lstatus;
    }
}
