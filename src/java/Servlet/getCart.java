/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.OrderBean;
import Bean.OrderingBean;
import Bean.ProductBean;
import DAO.Implementation.OrderingImplementation;
import DAO.Implementation.ProductImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aids
 */
@WebServlet(name = "getCart", urlPatterns = {"/getCart"})
public class getCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            
            
            ProductImplementation prodIM = new ProductImplementation();
            ArrayList<OrderingBean> cart = new ArrayList<OrderingBean>();
            ArrayList<ProductBean> items = new ArrayList<ProductBean>();
            ProductBean item;
            
            cart = (ArrayList<OrderingBean>) session.getAttribute("cart");
            
            for(OrderingBean bean: cart){
                item = new ProductBean();
                item = prodIM.getProductById(bean.getProductID());
                items.add(item);
            }
                 
            for(int i=1; i<=items.size(); i++){
                    out.append("<tr>");
                    out.append("<td>").append(Integer.toString(i)).append("</td>");
                    out.append("<td><a id='link' onClick='link()'>").append(items.get(i-1).getTitle()).append("</a></td>");
                    out.append("<td>").append(items.get(i-1).getCategory()).append("</td>");
                    out.append("<td>").append(Integer.toString(cart.get(i-1).getQuantity())).append("</td>");
                    out.append("<td>").append(Float.toString(cart.get(i-1).getPrice()*cart.get(i-1).getQuantity())).append("</td>");
                    out.append("<td>").append("<button class='btn btn-danger'>Remove</button").append("</td>");
                    
                    out.append("</tr>");          
                }
            
        } 
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
