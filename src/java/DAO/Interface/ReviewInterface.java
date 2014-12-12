/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Bean.ReviewBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kimberly
 */
public interface ReviewInterface {
    public void addCustomerProductReview(ReviewBean bean);
    public ArrayList<ReviewBean> getAllCustomersReviews();
    public ArrayList<ReviewBean> getReviewByCustomerID(int userid);
    public ArrayList<ReviewBean> getReviewByProductID(int prodid);
    //public ArrayList<ReviewBean> getReviewByProductName(String title);
    public ArrayList<ReviewBean> getReviewsByDate(Date date);
    public ArrayList<ReviewBean> getTodayOrders();
    public ReviewBean getCusotmerReview(int id);
    public void editCustomerReview(int userID, int prodID, String review);
    public void deleteReview(int reviewID);
}
