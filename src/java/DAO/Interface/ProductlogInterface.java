/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Bean.ProductBean;
import Bean.ProductLogBean;
import Bean.UserBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kimberly
 */
public interface ProductlogInterface {
    public void addProductLog(UserBean ubean, ProductBean pbean, ProductLogBean plogbean);
    public ArrayList<ProductLogBean> getAllProductLogs();
    public ProductLogBean getUserProductLog(int id);
    public ArrayList<ProductLogBean> getTodayProductLog();
    public ArrayList<ProductLogBean> getSpecificProductLogByDate(Date date);
}
