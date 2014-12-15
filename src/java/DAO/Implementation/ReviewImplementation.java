/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Implementation;

import Bean.ReviewBean;
import DAO.Interface.ReviewInterface;
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
public class ReviewImplementation implements ReviewInterface{
    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;
    
    public void addCustomerProductReview(ReviewBean bean) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO review(review,reviewDate,userID,productID) VALUES (?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(query);
            
            LocalDateTime ldt  = LocalDateTime.now();
            Timestamp ts = new Timestamp(ldt.toDate().getTime());
         
            //prep.setInt(1, bean.getOrderID());
            prep.setString(1, bean.getReview());
            prep.setTimestamp(2, ts);
            prep.setInt(3, bean.getUserID());
            prep.setInt(4, bean.getProductID());

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<ReviewBean> getAllCustomersReviews() 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM review";
            PreparedStatement ps = connection.prepareStatement(query);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<ReviewBean> beans = new ArrayList<ReviewBean>();
            while (resultSet.next()) 
            {
                ReviewBean bean = new ReviewBean();
                bean.setReviewID(resultSet.getInt("reviewID"));     
                bean.setReview(resultSet.getString("review"));   
                bean.setReviewDate(new LocalDateTime(resultSet.getTimestamp("reviewDate")));
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<ReviewBean> getReviewByCustomerID(int userid) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM review WHERE userID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userid);
            
            ResultSet resultSet = ps.executeQuery();
             ArrayList<ReviewBean> beans = new ArrayList<ReviewBean>();
            while (resultSet.next()) 
            {
                ReviewBean bean = new ReviewBean();
                 bean.setReviewID(resultSet.getInt("reviewID"));     
                bean.setReview(resultSet.getString("review"));   
                bean.setReviewDate(new LocalDateTime(resultSet.getTimestamp("reviewDate")));
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    public ArrayList<ReviewBean> getReviewByProductID(int prodid) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM review WHERE productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, prodid);
            
            ResultSet resultSet = ps.executeQuery();
             ArrayList<ReviewBean> beans = new ArrayList<ReviewBean>();
             ReviewBean bean;
            while (resultSet.next()) 
            {
                bean = new ReviewBean();
                bean.setReviewID(resultSet.getInt("reviewID"));     
                bean.setReview(resultSet.getString("review"));   
                bean.setReviewDate(new LocalDateTime(resultSet.getTimestamp("reviewDate")));
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
  /*  
    public ArrayList<ReviewBean> getReviewByProductName(String title) //get from summary 
    {
        try
        {
           dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from product,review where product.prodcutID = review.productID and product.title like '%?%'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, title);
 
            ResultSet resultSet = ps.executeQuery();
            ReviewBean bean = new ReviewBean();
            ArrayList<ReviewBean> beans = new ArrayList<ReviewBean>();
            while (resultSet.next()) 
            {
                bean.setProductID(resultSet.getInt("productID"));
                bean.setTitle(resultSet.getString("title"));
                bean.setSummary(resultSet.getString("summary"));
                bean.setPrice(resultSet.getFloat("price"));
                bean.setStock(resultSet.getFloat("stock"));
                bean.setPstatus(resultSet.getInt("pstatus"));
                //bean.setCategoryID(resultSet.getInt("categoryID"));
                beans.add(bean);
            }
            return beans;
        } 
         
        catch (SQLException ex) 
        {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    */
    public ArrayList<ReviewBean> getReviewsByDate(Date date) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM review where date(reviewDate) = ?"; //or date(logDate) = '2014-11-26'
            PreparedStatement ps = connection.prepareStatement(query);
            //LocalDateTime ldt  = LocalDateTime.now();
            //Timestamp ts = new Timestamp(date.toDate().getTime());
            java.sql.Date ts = new java.sql.Date(date.getTime());
            
            ps.setDate(1, ts);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<ReviewBean> beans = new ArrayList<ReviewBean>();
            while (resultSet.next()) 
            {
                ReviewBean bean = new ReviewBean();
                bean.setReviewID(resultSet.getInt("reviewID"));     
                bean.setReview(resultSet.getString("review"));   
                bean.setReviewDate(new LocalDateTime(resultSet.getTimestamp("reviewDate")));
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<ReviewBean> getTodayOrders() 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM review where date(reviewDate) = ? order by reviewDate desc"; //or date(logDate) = '2014-11-26'
            PreparedStatement ps = connection.prepareStatement(query);
            
	   //get current date time with Date()
            java.util.Date now = new java.util.Date();
           java.sql.Date today = new java.sql.Date(now.getTime()); 
           
          /*  LocalDateTime ldt  = LocalDateTime.now();
            Timestamp ts = new Timestamp(ldt.toDate().getTime());
            */
            ps.setDate(1, today);
            
            ResultSet resultSet = ps.executeQuery();
            ArrayList<ReviewBean> beans = new ArrayList<ReviewBean>();
            while (resultSet.next()) 
            {
                ReviewBean bean = new ReviewBean();
                bean.setReviewID(resultSet.getInt("reviewID"));     
                bean.setReview(resultSet.getString("review"));   
                bean.setReviewDate(new LocalDateTime(resultSet.getTimestamp("reviewDate")));
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
               
                beans.add(bean);
            }
            return beans;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    public ReviewBean getCusotmerReview(int id) 
    {
        try 
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM review WHERE reviewID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            ReviewBean bean = new ReviewBean();
            while (resultSet.next()) 
            {
                bean.setReviewID(resultSet.getInt("reviewID"));     
                bean.setReview(resultSet.getString("review"));   
                bean.setReviewDate(new LocalDateTime(resultSet.getTimestamp("reviewDate")));
                bean.setUserID(resultSet.getInt("userID"));
                bean.setProductID(resultSet.getInt("productID"));
            }
            return bean;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
     public void editCustomerReview(int userID, int prodID, String review) 
    {
        try
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE review SET review = ? WHERE userID = ? AND productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);
 
            prep.setString(1, review);
            prep.setInt(2, userID);
            prep.setInt(3, prodID);
 
            prep.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void deleteReview(int reviewID) 
    {
        try
        {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "DELETE FROM review WHERE reviewID = ?";
            PreparedStatement prep = connection.prepareStatement(query);
 
            prep.setInt(1, reviewID);
            prep.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(ReviewImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
