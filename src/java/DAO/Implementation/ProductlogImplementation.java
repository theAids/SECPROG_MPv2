/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Implementation;

import Bean.ProductBean;
import Bean.ProductLogBean;
import Bean.UserBean;
import DAO.Interface.ProductInterface;
import DAO.Interface.ProductlogInterface;
import DB.Connection.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

/**
 *
 * @author kimberly
 */
public class ProductlogImplementation implements ProductlogInterface{
    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;
    
    public void addProductLog(UserBean ubean, ProductBean pbean, ProductLogBean plogbean) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO productlog(userID,productID,logDate,activity) VALUES (?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(query);

           // java.util.Date now = new java.util.Date();
            //java.sql.Date today = new java.sql.Date(now.getTime());
            
            LocalDateTime ldt  = LocalDateTime.now();
            Timestamp ts = new Timestamp(ldt.toDate().getTime());
            //System.out.println(sdf.format(sq));
            prep.setInt(1, ubean.getUserID());
            prep.setInt(2, pbean.getProductID());
            prep.setTimestamp(3, ts);
            prep.setString(4, plogbean.getActivity());

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductlogImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public ArrayList<ProductLogBean> getAllProductLogs() 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM productlog order by logDate desc";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<ProductLogBean> beans = new ArrayList<ProductLogBean>();
            while (resultSet.next()) 
            {
                ProductLogBean bean = new ProductLogBean();
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
                bean.setLogDate(new LocalDateTime(resultSet.getTimestamp("logDate")));
                bean.setActivity(resultSet.getString("activity"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ProductlogImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     public ProductLogBean getUserProductLog(int id) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM productlog WHERE userID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            ProductLogBean bean = new ProductLogBean();
            while (resultSet.next()) 
            {
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
                bean.setLogDate(new LocalDateTime(resultSet.getTimestamp("logDate")));
                bean.setActivity(resultSet.getString("activity"));
            }
            return bean;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ProductlogImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
     
    public ArrayList<ProductLogBean> getTodayProductLog() 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM productlog where date(logDate) = ? order by logDate desc"; //or date(logDate) = '2014-11-26'
            PreparedStatement ps = connection.prepareStatement(query);
            
	   //get current date time with Date()
            java.util.Date now = new java.util.Date();
           java.sql.Date today = new java.sql.Date(now.getTime()); 
           
          /*  LocalDateTime ldt  = LocalDateTime.now();
            Timestamp ts = new Timestamp(ldt.toDate().getTime());
            */
            ps.setDate(1, today);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<ProductLogBean> beans = new ArrayList<ProductLogBean>();
            while (resultSet.next()) 
            {
                ProductLogBean bean = new ProductLogBean();
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
                bean.setLogDate(new LocalDateTime(resultSet.getTimestamp("logDate")));
                bean.setActivity(resultSet.getString("activity"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ProductlogImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
     public ArrayList<ProductLogBean> getSpecificProductLogByDate(Date date) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM productlog where date(logDate) = ?"; //or date(logDate) = '2014-11-26'
            PreparedStatement ps = connection.prepareStatement(query);
            //LocalDateTime ldt  = LocalDateTime.now();
            //Timestamp ts = new Timestamp(date.toDate().getTime());
            java.sql.Date ts = new java.sql.Date(date.getTime());
            
            ps.setDate(1, ts);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<ProductLogBean> beans = new ArrayList<ProductLogBean>();
            while (resultSet.next()) 
            {
                ProductLogBean bean = new ProductLogBean();
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
                bean.setLogDate(new LocalDateTime(resultSet.getTimestamp("logDate")));
                bean.setActivity(resultSet.getString("activity"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ProductlogImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
}
