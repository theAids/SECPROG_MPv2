/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Bean.CustomerBean;
import Bean.UserBean;
import java.util.ArrayList;

/**
 *
 * @author kimberly
 */
public interface UserDAOInterface {
    public void addCustomerAccount(CustomerBean bean);
    public ArrayList<UserBean> getAllUser();
    public UserBean getUser(String username);
    public UserBean getUser(int userID);
    public CustomerBean getCustomer(int userID);
    public CustomerBean getCustomer(String username);
    
    public boolean addAdministrativeAccount(UserBean u, String type);
    public String getUserType(UserBean bean);
    public void lockUser(UserBean u);
    public void unlockUser(UserBean u);
    public void unlockUser(String username);
    public void expireUser(UserBean u);
    public void expireUser(String username);
    public void editCustomer(CustomerBean c);
    public void editAdministrativeAccount(UserBean u);
    
//    public void addManagerAccount(UserBean bean);
    /*public void editCustomerPassword(UserBean bean, String pass);
    public void editManagerPassword(UserBean bean, String pass);
    public void editAdminPassword(UserBean bean, String pass);
    public void editCustomerDeliveryAdd(UserBean bean, String deliveryAdd);
    public void editCustomerBillingAdd(UserBean bean, String billingAdd);
    public UserBean getCustomer(String username);
    public ArrayList <UserBean> getAllCustomers();
    public void updateCustomerStatus(UserBean customer);*/
}
