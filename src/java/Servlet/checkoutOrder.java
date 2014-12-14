/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.OrderingBean;
import Bean.ProductBean;
import DAO.Implementation.OrderImplementation;
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
@WebServlet(name = "checkoutOrder", urlPatterns = {"/checkoutOrder"})
public class checkoutOrder extends HttpServlet {

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
            ArrayList<OrderingBean> cart = new ArrayList<>();
            
            ProductImplementation prodIM = new ProductImplementation();
            OrderImplementation order = new OrderImplementation();
                    
            
            ProductBean prod = new ProductBean();
            cart = (ArrayList<OrderingBean>) session.getAttribute("cart");

            for (OrderingBean bean : cart) {
                prod = prodIM.getProductById(bean.getProductID());
                prodIM.editProductByStock(bean.getProductID(), prod.getStock()-bean.getQuantity());
                
                prod = prodIM.getProductById(bean.getProductID());
                if(prod.getStock() == 0){
                    prodIM.editProductByStatus(bean.getProductID(), "Unavailable");
                }
                
                order.editOrderStatus(bean.getOrderID(), "sold");
                
            }
            
            response.sendRedirect("Transactions.jsp");

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
