/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.OrderBean;
import Bean.OrderingBean;
import Bean.ProductBean;
import Bean.UserBean;
import DAO.Implementation.OrderImplementation;
import DAO.Implementation.OrderingImplementation;
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
@WebServlet(name = "addtoCart", urlPatterns = {"/addtoCart"})
public class addtoCart extends HttpServlet {

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
            
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            ProductBean product = (ProductBean) session.getAttribute("product");

            UserBean user = (UserBean) session.getAttribute("client_user");

            OrderImplementation order = new OrderImplementation();
            OrderingImplementation cart = new OrderingImplementation();

            ArrayList<OrderBean> purchases = new ArrayList<OrderBean>();

           // purchases = order.getCustomerOrder(user.getUserID());

            OrderingBean prod = new OrderingBean();
            OrderBean trans = new OrderBean() ;


           
            if(order.getCart(user.getUserID()).getStatus()==null){
                order.addCustomerOrder(user.getUserID());
                
            }
           
            trans = order.getCart(user.getUserID());
            
            prod.setOrderID(trans.getOrderID());
            prod.setPrice(product.getPrice());
            prod.setQuantity(quantity);
            prod.setProductID(product.getProductID());
            
            cart.addOrderProduct(prod);
            
            
         
            
            ArrayList<OrderingBean> items = new ArrayList<OrderingBean>();
            
            items = cart.getOrderByIDProducts(trans.getOrderID());
            
            purchases = order.getCustomerOrder(user.getUserID());
            
            session.setAttribute("cart", items);
            response.sendRedirect("Cart.jsp");

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
