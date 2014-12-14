/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Bean.SignLogBean;
import Bean.UserBean;
import DAO.Interface.SignlogInterface;
import DB.Connection.DBConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDateTime;

/**
 *
 * @author joechua
 */
public class SignlogImplementation implements SignlogInterface {

    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;
    
    @Override
    public void addLog(UserBean bean, int s) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO signLog(userID, lStatus) VALUES (?,?);";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, bean.getUserID());
           // Timestamp today = new Timestamp(System.currentTimeMillis());
            //prep.setTimestamp(1, today);
            prep.setInt(2, s); //0 if fail, 1 if success...
            

            prep.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int checkLock(UserBean bean){
        int i = 0;
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select count(*) from signLog where logDate >= now() - interval 15 minute and userID = ? && lstatus = 0";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, bean.getUserID());
            ResultSet resultSet = prep.executeQuery();
            
            while(resultSet.next()){
                i = resultSet.getInt("count(*)");
            }
            //connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }
    public ArrayList<SignLogBean> getAllUserLogs() 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM signlog order by logDate desc";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<SignLogBean> beans = new ArrayList<SignLogBean>();
            while (resultSet.next()) 
            {
                SignLogBean bean = new SignLogBean();
                bean.setUserID(resultSet.getInt("userID"));
                bean.setLogDate(new LocalDateTime(resultSet.getTimestamp("logDate")));
                bean.setLstatus(resultSet.getInt("lstatus"));
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SignlogImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
