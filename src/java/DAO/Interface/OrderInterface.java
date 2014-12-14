/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Bean.OrderBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kimberly
 */
public interface OrderInterface {
    public void addCustomerOrder(int userid);
    public ArrayList<OrderBean> getAllCustomerOrders();
   // public OrderBean getCustomerOrder(int id); //ArrayList<OrderBean>
    public ArrayList<OrderBean> getCustomerOrder(int id);
    public ArrayList<OrderBean> getOrdersByDate(Date date);
    public ArrayList<OrderBean> getTodayOrders();
    public OrderBean getCart(int userid);
    public void deleteOrder(int orderID);
    public void editOrderStatus(int orderID, String status);
}
