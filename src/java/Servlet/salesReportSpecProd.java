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
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
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
@WebServlet(name = "salesReportSpecProd", urlPatterns = {"/salesReportSpecProd"})
public class salesReportSpecProd extends HttpServlet {

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
            String prod = request.getParameter("prod");
            HttpSession session = request.getSession();
            int prodID = 0;
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
                for (int j = 0; j < productbean.size(); j++) {
                    for (int k = 0; k < orderingbean.size(); k++) {
                        if (orderingbean.get(k).getOrderID() == orderbean.get(i).getOrderID() && parseInt(prod) == productbean.get(j).getProductID() && parseInt(prod) == orderingbean.get(k).getProductID()) {
                            out.print("<tr>");
                            out.print("<td>" + orderbean.get(i).getOrderDate().toString("MM/dd/yyyy HH:mm:ss") + "</td>");
                            for (int a = 0; a < userbean.size(); a++) {
                                if (orderbean.get(i).getUserID() == userbean.get(a).getUserID()) {
                                    out.print("<td>" + userbean.get(a).getUsername() + "</td>");
                                }
                            }
                            out.print("<td>" + productbean.get(j).getTitle() + "</td>");
                            out.print("<td>" + orderingbean.get(k).getQuantity() + "</td>");
                            out.print("<td>" + orderingbean.get(k).getPrice() + "</td>");
                            total = total + orderingbean.get(k).getPrice();

                            //out.print("<td>"+total+"</td>");    
                            out.print("</tr>");
                        }
                    }
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
