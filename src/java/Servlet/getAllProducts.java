/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

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
 * @author kimberly
 */
@WebServlet(name = "getAllProducts", urlPatterns = {"/getAllProducts"})
public class getAllProducts extends HttpServlet {

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
            //String search = request.getParameter("search");
            HttpSession session = request.getSession();
            ProductImplementation products = new ProductImplementation();

            ArrayList<ProductBean> productbean = new ArrayList<ProductBean>();
            productbean = products.getAllProducts();
            
           out.println("<select name='products' id='products' class='form-control' onchange='loadXMLDoc3(this.value)'>");
           out.println("<option value=''>Select Product:</option>");
           for(int i=0; i<=productbean.size(); i++){
                
                    out.println("<option value=" +productbean.get(i).getProductID() + ">" +productbean.get(i).getTitle() + "</option>");
                

               //out.println("<option value=" +productbean.get(i).getTitle() + ">" +productbean.get(i).getTitle() + "</option>");
                        
                 
             //out.append("<option value=" +productbean.get(i).getTitle() + ">" +productbean.get(i).getTitle() + "</option>");         
             }
           out.println("</select>");
             
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
