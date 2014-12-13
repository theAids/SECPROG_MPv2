/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Implementation;

import Bean.OrderBean;
import DAO.Interface.OrderInterface;
import DB.Connection.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDateTime;

/**
 *
 * @author kimberly
 */
public class OrderImplementation implements OrderInterface{
    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;
    @Override
    public void addCustomerOrder(OrderBean bean) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO foo_order(userID) VALUES (?)";
            PreparedStatement prep = connection.prepareStatement(query);

            //java.util.Date utilDate = new java.util.Date();
            //java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
            //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            
           //  LocalDateTime ldt  = LocalDateTime.now();
           // Timestamp ts = new Timestamp(ldt.toDate().getTime());
         
            //prep.setInt(1, bean.getOrderID());
            //prep.setTimestamp(1, ts);
            prep.setInt(1, bean.getUserID());

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  public ArrayList<OrderBean> getAllCustomerOrders() 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_order";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<OrderBean> beans = new ArrayList<OrderBean>();
            while (resultSet.next()) 
            {
                OrderBean bean = new OrderBean();
                bean.setOrderID(resultSet.getInt("orderID"));                
                bean.setOrderDate(new LocalDateTime(resultSet.getTimestamp("orderDate")));
                bean.setUserID(resultSet.getInt("userID"));
                bean.setStatus(resultSet.getString("status"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OrderImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  /*
  public OrderBean getCustomerOrder(int id) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_order WHERE userID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            OrderBean bean = new OrderBean();
            while (resultSet.next()) 
            {
                bean.setOrderID(resultSet.getInt("orderID"));
                bean.setOrderDate(new LocalDateTime(resultSet.getTimestamp("orderDate")));
                bean.setUserID(resultSet.getInt("userID"));
            }
            return bean;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OrderImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } */
  
    public ArrayList<OrderBean> getCustomerOrder(int id) 
    {
        try 
        {
           dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_order WHERE userID = ?"; 
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<OrderBean> beans = new ArrayList<OrderBean>();
            while (resultSet.next()) 
            {
                OrderBean bean = new OrderBean();
                bean.setOrderID(resultSet.getInt("orderID"));
                bean.setOrderDate(new LocalDateTime(resultSet.getTimestamp("orderDate")));
                bean.setUserID(resultSet.getInt("userID"));
                bean.setStatus(resultSet.getString("status"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OrderImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
  
    public ArrayList<OrderBean> getOrdersByDate(Date date) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_order where date(orderDate) = ?"; //date(logDate) = '2014-11-26'
            PreparedStatement ps = connection.prepareStatement(query);
            //LocalDateTime ldt  = LocalDateTime.now();
            //Timestamp ts = new Timestamp(date.toDate().getTime());
            java.sql.Date ts = new java.sql.Date(date.getTime());
            
            ps.setDate(1, ts);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<OrderBean> beans = new ArrayList<OrderBean>();
            while (resultSet.next()) 
            {
                OrderBean bean = new OrderBean();
                bean.setOrderID(resultSet.getInt("orderID"));
                bean.setOrderDate(new LocalDateTime(resultSet.getTimestamp("orderDate")));
                bean.setUserID(resultSet.getInt("userID"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OrderImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<OrderBean> getTodayOrders() 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_order where date(orderDate) = ? order by orderDate desc"; //or date(logDate) = '2014-11-26'
            PreparedStatement ps = connection.prepareStatement(query);
            
	   //get current date time with Date()
            java.util.Date now = new java.util.Date();
           java.sql.Date today = new java.sql.Date(now.getTime()); 
           
          /*  LocalDateTime ldt  = LocalDateTime.now();
            Timestamp ts = new Timestamp(ldt.toDate().getTime());
            */
            ps.setDate(1, today);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<OrderBean> beans = new ArrayList<OrderBean>();
            while (resultSet.next()) 
            {
                OrderBean bean = new OrderBean();
                bean.setOrderID(resultSet.getInt("orderID"));
                bean.setOrderDate(new LocalDateTime(resultSet.getTimestamp("orderDate")));
                bean.setUserID(resultSet.getInt("userID"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OrderImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
  
    public void deleteOrder(int orderID) 
    {
        try
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "DELETE FROM foo_order WHERE orderID = ?";
            PreparedStatement prep = connection.prepareStatement(query);
 
            prep.setInt(1, orderID);
            prep.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(OrderImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
