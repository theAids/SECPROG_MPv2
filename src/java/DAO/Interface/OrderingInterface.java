/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Bean.OrderingBean;
import java.util.ArrayList;

/**
 *
 * @author kimberly
 */
public interface OrderingInterface {
    public void addOrderProduct(OrderingBean bean);
    public ArrayList<OrderingBean> getAllOrderProducts();
    public ArrayList<OrderingBean> getOrderByIDProducts(int orderid);
    public void editOrderedProductQuantity(int quantity, int orderID, int prodID);
    public void deleteOrderedProduct(int orderID, int productID);
}
