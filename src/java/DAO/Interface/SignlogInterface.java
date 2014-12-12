/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Bean.UserBean;
import java.sql.Timestamp;

/**
 *
 * @author joechua
 */
public interface SignlogInterface {
    public void addLog(UserBean bean, int s);
    public int checkLock(UserBean bean);
    
}
