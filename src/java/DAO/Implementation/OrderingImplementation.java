/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Implementation;

import Bean.OrderingBean;
import DAO.Interface.OrderingInterface;
import DB.Connection.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kimberly
 */
public class OrderingImplementation implements OrderingInterface{
    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;
    
    
    @Override
    public void addOrderProduct(OrderingBean bean) 
    {
        try
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO ordering(orderID,productID,price,quantity) VALUES (?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(query);
            
            prep.setInt(1, bean.getOrderID());
            prep.setInt(2, bean.getProductID());
            prep.setFloat(3, bean.getPrice());
            prep.setFloat(4, bean.getQuantity());
             
            prep.executeUpdate();
            /*
            query = "SELECT * FROM product WHERE productID = ?";
            prep = connect.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            
            while (result.next()) {
                prodID = result.getInt("productID");
            }*/
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(OrderingImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<OrderingBean> getAllOrderProducts(){
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM ordering";
            PreparedStatement ps = connection.prepareStatement(query);
                //ps.setString(1, name);

            ResultSet result = ps.executeQuery();
            ArrayList<OrderingBean> beans = new ArrayList<OrderingBean>();
            while (result.next()) {
                OrderingBean bean = new OrderingBean();
                bean.setOrderID(result.getInt("orderID"));
                bean.setProductID(result.getInt("productID"));
                bean.setPrice(result.getFloat("price"));
                bean.setQuantity(result.getInt("quantity")); 
                beans.add(bean);
            }
            return beans;
        } catch (SQLException ex) {
            Logger.getLogger(OrderingImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    public ArrayList<OrderingBean> getOrderByIDProducts(int orderid) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM ordering WHERE orderID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, orderid);
            
            ResultSet resultSet = ps.executeQuery();
             ArrayList<OrderingBean> beans = new ArrayList<OrderingBean>();
            while (resultSet.next()) 
            {
                OrderingBean bean = new OrderingBean();
                bean.setOrderID(resultSet.getInt("orderID"));
                bean.setProductID(resultSet.getInt("productID"));
                bean.setPrice(resultSet.getFloat("price"));
                bean.setQuantity(resultSet.getInt("quantity")); 
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(OrderingImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
     public void editOrderedProductQuantity(int quantity, int orderID, int prodID) 
    {
        try
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE ordering SET quantity = ? WHERE orderID = ? AND productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);
 
            prep.setInt(1, quantity);
            prep.setInt(2, orderID);
            prep.setInt(3, prodID);
 
            prep.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(OrderingImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteOrderedProduct(int orderID, int productID) 
    {
        try
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "DELETE FROM ordering WHERE orderID = ? AND productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);
 
            prep.setInt(1, orderID);
            prep.setInt(2, productID);
            prep.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(OrderingImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
