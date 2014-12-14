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
import DAO.Implementation.ProductImplementation;
import DAO.Implementation.UserDAOImplementation;
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
 * @author kimberly
 */
@WebServlet(name = "salesReportSpecDate", urlPatterns = {"/salesReportSpecDate"})
public class salesReportSpecDate extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            String date = request.getParameter("date");
           HttpSession session = request.getSession();
            float total = 0;
            String title = null;
            OrderImplementation order = new OrderImplementation();
            OrderingImplementation ordering = new OrderingImplementation();
            ProductImplementation product = new ProductImplementation();
            UserDAOImplementation user = new UserDAOImplementation();
            ArrayList<OrderBean> orderbean = new ArrayList<OrderBean>();
            ArrayList<OrderingBean> orderingbean = new ArrayList<OrderingBean>();
            ArrayList<ProductBean> productbean = new ArrayList<ProductBean>();
            ArrayList<UserBean> userbean = new ArrayList<UserBean>();

            orderbean = order.getAllCustomerOrders();
            orderingbean = ordering.getAllOrderProducts();
            productbean = product.getAllProducts();
            userbean = user.getAllUser();

            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Log Date and Timestamp</th>");
            out.println("<th>Username</th>");
            out.println("<th>Product Name</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Price</th>");
            out.println("<th>Total Sales</th>");;
            out.println("</tr>");

            out.println("<tr>");
            out.println("<th>Log Date and Timestamp</th>");
            out.println("<th>Username</th>");
            out.println("<th>Product Name</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Price</th>");
            out.println("<th>Total Sales</th>");
            out.println("</tr>");
            out.println("</thead>");

            for (int i = 0; i < orderbean.size(); i++) {
                
                if (date.equals(orderbean.get(i).getOrderDate().toString("MM/dd/yyyy"))) {
                    out.print("<tr>");
                    for (int j = 0; j < orderingbean.size(); j++) {
                        if (orderbean.get(i).getOrderID() == orderingbean.get(j).getOrderID()) {
                            out.print("<td>" + orderbean.get(i).getOrderDate().toString("MM/dd/yyyy HH:mm:ss") + "</td>");
                            for (int k = 0; k < userbean.size(); k++) {
                                if (orderbean.get(i).getUserID() == userbean.get(k).getUserID()) {
                                    out.print("<td>" + userbean.get(k).getUsername() + "</td>");
                                }
                            }
                            for (int k = 0; k < productbean.size(); k++) {
                                if (orderingbean.get(j).getProductID() == productbean.get(k).getProductID()) {
                                    out.print("<td>" + productbean.get(k).getTitle() + "</td>");
                                }
                            }
                            out.print("<td>" + orderingbean.get(j).getQuantity() + "</td>");
                            total = total + orderingbean.get(j).getPrice();
                            out.print("<td>" + orderingbean.get(j).getPrice() + "</td>");
               //out.print("<td>"+orderbean.get(i).getUserID() +"</td>");
                            // out.print("<td>"+orderingbean.get(j).getProductID() +"</td>");
                            out.print("</tr>");
                        }
                    }

        //out.print("<td>"+total+"</td>");    
                    // out.print("</tr>");
                }
            }
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td>" + total + "</td>");
        } finally {
            out.close();
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
