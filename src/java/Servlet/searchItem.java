/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BookBean;
import Bean.CDBean;
import Bean.DvdBean;
import Bean.MagBean;
import Bean.ProductBean;
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
@WebServlet(name = "searchItem", urlPatterns = {"/searchItem"})
public class searchItem extends HttpServlet {

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

            String search = request.getParameter("search");
            HttpSession session = request.getSession();

            ProductImplementation prodImpl = new ProductImplementation();
            int i;

            ArrayList<ProductBean> products = new ArrayList<ProductBean>();
            products = prodImpl.getProductByName(search);
            
            
      
             for(i=1; i<=products.size(); i++){
             out.append("<tr>");
            // out.append("<td>").append(Integer.toString(products.size())).append("</td>");
             out.append("<td>").append(Integer.toString(i)).append("</td>");
             out.append("<td><a href='getProductInfo?id="+products.get(i-1).getProductID()+"'>").append(products.get(i-1).getTitle()).append("</a></td>");
             out.append("<td>").append(products.get(i-1).getCategory()).append("</td>");
             out.append("<td>").append(Float.toString(products.get(i-1).getPrice())).append("</td>");
             if(products.get(i-1).getPstatus().equals("Available")){
                        out.append("<td>").append("<p style='color:#5BC236'>Available</p>").append("</td>");
                    }else{
                        out.append("<td>").append("<p style='color:red'>Unavailable</p>").append("</td>");
                    }
             out.append("</tr>");          
             }
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
