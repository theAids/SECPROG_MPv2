/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Bean.CustomerBean;
import Bean.UserBean;
import DAO.Interface.SignlogInterface;
import DAO.Interface.UserDAOInterface;
import DB.Connection.DBConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kimberly
 */
public class UserDAOImplementation implements UserDAOInterface {
    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;
    
    public void addCustomerAccount(CustomerBean bean) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO foo_user(username, fname, minitial, lname, pword, email, ustatus, userType, billingAddress, deliveryAddress,date_created) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(query);

            //prep.setInt(1, bean.getUserID());
            prep.setString(1, bean.getUsername());
            prep.setString(2, bean.getFname());
            prep.setString(3, bean.getMinitial());
            prep.setString(4, bean.getLname());
            prep.setString(5, bean.getPassword());
            prep.setString(6, bean.getEmail());
            prep.setInt(7, 1);
            prep.setString(8, "Customer");
            prep.setString(9, bean.getbAddress());
            prep.setString(10, bean.getdAddress());
            Timestamp today = new Timestamp(System.currentTimeMillis());
            prep.setTimestamp(11, today);

            prep.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public UserBean getUser(String username){
        UserBean u = null;
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_user where username = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setString(1, username);
            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                u = new UserBean();
                u.setUserID(resultSet.getInt("userID"));
                u.setUsername(resultSet.getString("username"));
                u.setFname(resultSet.getString("fname"));
                u.setMinitial(resultSet.getString("minitial"));
                u.setLname(resultSet.getString("lname"));
                u.setPassword(resultSet.getString("pword"));
                u.setEmail(resultSet.getString("email"));
                u.setStatus(resultSet.getInt("ustatus"));
                
                /*if(resultSet.getString("userType").equals("customer")){
                    CustomerBean c = (CustomerBean) u;
                    c.setbAddress(resultSet.getString("billingAddress"));
                    c.setdAddress(resultSet.getString("deliveryAddress"));
                    u = (UserBean) c;
                }
                */
            }
            //connection.close();
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public UserBean getUser(int userID){
        UserBean u = null;
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_user where userID = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, userID);
            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                u = new UserBean();
                u.setUserID(resultSet.getInt("userID"));
                u.setUsername(resultSet.getString("username"));
                u.setFname(resultSet.getString("fname"));
                u.setMinitial(resultSet.getString("minitial"));
                u.setLname(resultSet.getString("lname"));
                u.setPassword(resultSet.getString("pword"));
                u.setEmail(resultSet.getString("email"));
                u.setStatus(resultSet.getInt("ustatus"));
                
                /*if(resultSet.getString("userType").equals("customer")){
                    CustomerBean c = (CustomerBean) u;
                    c.setbAddress(resultSet.getString("billingAddress"));
                    c.setdAddress(resultSet.getString("deliveryAddress"));
                    u = (UserBean) c;
                }
                */
            }
            connection.close();
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public CustomerBean getCustomer(int userID){
        CustomerBean u = null;
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_user where userID = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, userID);
            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                u = new CustomerBean();
                u.setUserID(resultSet.getInt("userID"));
                u.setUsername(resultSet.getString("username"));
                u.setFname(resultSet.getString("fname"));
                u.setMinitial(resultSet.getString("minitial"));
                u.setLname(resultSet.getString("lname"));
                u.setPassword(resultSet.getString("pword"));
                u.setEmail(resultSet.getString("email"));
                u.setStatus(resultSet.getInt("ustatus"));
                u.setbAddress(resultSet.getString("billingAddress"));
                u.setdAddress(resultSet.getString("deliveryAddress"));
                u.setCreated(resultSet.getTimestamp("date_created"));
                /*if(resultSet.getString("userType").equals("customer")){
                    CustomerBean c = (CustomerBean) u;
                    c.setbAddress(resultSet.getString("billingAddress"));
                    c.setdAddress(resultSet.getString("deliveryAddress"));
                    u = (UserBean) c;
                }
                */
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    @Override
    public CustomerBean getCustomer(String username){
        CustomerBean u = null;
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_user where username = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setString(1, username);
            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                u = new CustomerBean();
                u.setUserID(resultSet.getInt("userID"));
                u.setUsername(resultSet.getString("username"));
                u.setFname(resultSet.getString("fname"));
                u.setMinitial(resultSet.getString("minitial"));
                u.setLname(resultSet.getString("lname"));
                u.setPassword(resultSet.getString("pword"));
                u.setEmail(resultSet.getString("email"));
                u.setStatus(resultSet.getInt("ustatus"));
                u.setbAddress(resultSet.getString("billingAddress"));
                u.setdAddress(resultSet.getString("deliveryAddress"));
                u.setCreated(resultSet.getTimestamp("date_created"));
                /*if(resultSet.getString("userType").equals("customer")){
                    CustomerBean c = (CustomerBean) u;
                    c.setbAddress(resultSet.getString("billingAddress"));
                    c.setdAddress(resultSet.getString("deliveryAddress"));
                    u = (UserBean) c;
                }
                */
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
    
    
    
    @Override
    public ArrayList<UserBean> getAllUser(){
        ArrayList<UserBean> aUsers = new ArrayList<UserBean>();
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_user";
            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                UserBean u = new UserBean();
                u.setUserID(resultSet.getInt("userID"));
                u.setUsername(resultSet.getString("username"));
                u.setFname(resultSet.getString("fname"));
                u.setMinitial(resultSet.getString("minitial"));
                u.setLname(resultSet.getString("lname"));
                u.setPassword(resultSet.getString("pword"));
                u.setEmail(resultSet.getString("email"));
                u.setStatus(resultSet.getInt("ustatus"));
                u.setCreated(resultSet.getTimestamp("date_created"));
                
                /*if(resultSet.getString("userType").equals("customer")){
                    CustomerBean c = (CustomerBean) u;
                    c.setbAddress(resultSet.getString("billingAddress"));
                    c.setdAddress(resultSet.getString("deliveryAddress"));
                    u = (UserBean) c;
                }
                */
                aUsers.add(u);
            }
            
            //connection.close();
            return aUsers;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean addAdministrativeAccount(UserBean u, String type) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO foo_user(username, fname, minitial, lname, pword, email, ustatus, userType, date_created) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(query);

            //prep.setInt(1, bean.getUserID());
            prep.setString(1, u.getUsername());
            prep.setString(2, u.getFname());
            prep.setString(3, u.getMinitial());
            prep.setString(4, u.getLname());
            prep.setString(5, u.getPassword());
            prep.setString(6, u.getEmail());
            prep.setInt(7, 2); //2 if PENDING
            prep.setString(8, type);
            Timestamp today = new Timestamp(System.currentTimeMillis());
            prep.setTimestamp(9, today);

            prep.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public String getUserType(UserBean bean){
        String type = null;
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM foo_user where userID = ?";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, bean.getUserID());
            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                
                type = (resultSet.getString("userType"));
              
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return type;
    }
    
    @Override
    public void lockUser(UserBean bean){
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE foo_user SET ustatus = 2 WHERE userID = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, bean.getUserID());
            prep.executeUpdate();
            
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void unlockUser(UserBean bean){
        SignlogInterface signLogIM = new SignlogImplementation();
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE foo_user SET ustatus = 1 WHERE userID = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, bean.getUserID());
            prep.executeUpdate();
            
            signLogIM.addLog(bean, 2);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void unlockUser(String username){
        SignlogInterface signLogIM = new SignlogImplementation();
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE foo_user SET ustatus = 1 WHERE username = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setString(1, username);
            prep.executeUpdate();
            //System.out.println("SUCCESS UNLOCKING");
            UserBean bean = getUser(username);
            signLogIM.addLog(bean, 2);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void expireUser(String username){
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE foo_user SET ustatus = 0 WHERE username = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setString(1, username);
            prep.executeUpdate();
            
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void expireUser(UserBean u){
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE foo_user SET ustatus = 0 WHERE userID = ?;";
            PreparedStatement prep = connection.prepareStatement(query);
            prep.setInt(1, u.getUserID());
            prep.executeUpdate();
            
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void editCustomer(CustomerBean c){
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE foo_user SET username = ?, fname = ?, minitial = ?, lname = ?, pword = ?, email = ?, billingAddress = ?, deliveryAddress = ? WHERE userID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, c.getUsername());
            preparedStatement.setString(2, c.getFname());
            preparedStatement.setString(3, c.getMinitial());
            preparedStatement.setString(4, c.getLname());
            preparedStatement.setString(5, c.getPassword());
            preparedStatement.setString(6, c.getEmail());
            preparedStatement.setString(7, c.getbAddress());
            preparedStatement.setString(8, c.getdAddress());
            preparedStatement.setInt(9, c.getUserID());
            
            preparedStatement.executeUpdate();
            connection.close();
            //return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return false;
    }
    
    @Override
    public void editAdministrativeAccount(UserBean u){
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE foo_user SET username = ?, fname = ?, minitial = ?, lname = ?, pword = ?, email = ?, ustatus=? WHERE userID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getFname());
            preparedStatement.setString(3, u.getMinitial());
            preparedStatement.setString(4, u.getLname());
            preparedStatement.setString(5, u.getPassword());
            preparedStatement.setString(6, u.getEmail());
            preparedStatement.setInt(7, u.getStatus());
            
            preparedStatement.setInt(8, u.getUserID());
            
            preparedStatement.executeUpdate();
            connection.close();
            //return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
/*
    public void addManagerAccount(UserBean bean) {
        try {
            Connector con = new Connector();
            Connection connect = con.getConnection();
            String query = "INSERT INTO foo_user(userID, username, fname, lname, pword, email, ustatus, userType, billingAddress, deliveryAddress) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep = connect.prepareStatement(query);

            prep.setInt(1, bean.getUserID());
            prep.setString(2, bean.getUsername());
            prep.setString(3, bean.getFname());
            prep.setString(4, bean.getLname());
            prep.setString(5, bean.getPword());
            prep.setString(6, bean.getEmail());
            prep.setInt(7, bean.getUstatus());
            prep.setString(8, bean.getUserType());
            prep.setString(9, bean.getBillingAddress());
            prep.setString(10, bean.getDeliveryAddress());

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    
}
