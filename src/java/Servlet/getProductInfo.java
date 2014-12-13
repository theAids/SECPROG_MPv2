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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aids
 */
@WebServlet(name = "getProductInfo", urlPatterns = {"/getProductInfo"})
public class getProductInfo extends HttpServlet {

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
            
            String param = request.getParameter("param");
            ProductImplementation prodImpl = new ProductImplementation();
            ProductBean prod = new ProductBean();
            prod = prodImpl.getProductByTitle(param);
            
            /*
            if(prod.getCategory().equals("book")){
                BookBean bean = new BookBean();
                bean = prodImpl.getBookById(prod.getProductID());
                
            }else if(prod.getCategory().equals("magazine")){
                MagBean bean = new MagBean();
                bean = prodImpl.getMagById(prod.getProductID());
                
                
            }else if(prod.getCategory().equals("cd")){
                CDBean bean = new CDBean();
                bean = prodImpl.getCDById(prod.getProductID());
                
                
            }else if(prod.getCategory().equals("dvd")){
                DVDBean bean = new DVDBean();
                bean = prodImpl.getDVDById(prod.getProductID());
                
            }*/
            session.setAttribute("product", prod);
            response.sendRedirect("Product.jsp");
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
