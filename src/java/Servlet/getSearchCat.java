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
@WebServlet(name = "getSearchCat", urlPatterns = {"/getSearchCat"})
public class getSearchCat extends HttpServlet {

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
        
        try{
            
            String cat = request.getParameter("cat");
            HttpSession session = request.getSession();
            
            ProductImplementation prodImpl = new ProductImplementation();
            int i;
            
            if(cat.equals("Books")){
                ArrayList<BookBean> products = new ArrayList<BookBean>();
                products = prodImpl.getAllBooks();
                
                for(i=1; i<=products.size(); i++){
                    out.append("<tr>");
                    out.append("<td>").append(Integer.toString(i)).append("</td>");
                    out.append("<td><a id='link' onClick='link()'>").append(products.get(i-1).getTitle()).append("</a></td>");
                    out.append("<td>").append(Float.toString(products.get(i-1).getPrice())).append("</td>");
                    if(products.get(i-1).getPstatus().equals("Available")){
                        out.append("<td>").append("Available").append("</td>");
                    }else{
                        out.append("<td>").append("Unavailable").append("</td>");
                    }
                    out.append("</tr>");          
                }
                
            }else if(cat.equals("Magazines")){
                ArrayList<MagBean> products = new ArrayList<MagBean>();
                products = prodImpl.getAllMags();
                for(i=1; i<=products.size(); i++){
                    out.append("<tr>");
                    out.append("<td>").append(Integer.toString(i)).append("</td>");
                    out.append("<td><a id='link' onClick='link()'>").append(products.get(i-1).getTitle()).append("</a></td>");
                    out.append("<td>").append(Float.toString(products.get(i-1).getPrice())).append("</td>");
                    if(products.get(i-1).getPstatus().equals("Available")){
                        out.append("<td>").append("Available").append("</td>");
                    }else{
                        out.append("<td>").append("Unavailable").append("</td>");
                    }
                    out.append("</tr>");          
                }
            }else if(cat.equals("Audio CDs")){
                ArrayList<CDBean> products = new ArrayList<CDBean>();
                products = prodImpl.getAllCDs();
                for(i=1; i<=products.size(); i++){
                    out.append("<tr>");
                    out.append("<td>").append(Integer.toString(i)).append("</td>");
                    out.append("<td><a id='link' onClick='link()'>").append(products.get(i-1).getTitle()).append("</a></td>");
                    out.append("<td>").append(Float.toString(products.get(i-1).getPrice())).append("</td>");
                    if(products.get(i-1).getPstatus().equals("Available")){
                        out.append("<td>").append("Available").append("</td>");
                    }else{
                        out.append("<td>").append("Unavailable").append("</td>");
                    }
                    out.append("</tr>");          
                }
            }else if(cat.equals("DVDs")){
                ArrayList<DvdBean> products = new ArrayList<DvdBean>();
                products = prodImpl.getAllDvds();
                for(i=1; i<=products.size(); i++){
                    out.append("<tr>");
                    out.append("<td>").append(Integer.toString(i)).append("</td>");
                    out.append("<td><a id='link' onClick='link()'>").append(products.get(i-1).getTitle()).append("</a></td>");
                    out.append("<td>").append(Float.toString(products.get(i-1).getPrice())).append("</td>");
                    if(products.get(i-1).getPstatus().equals("Available")){
                        out.append("<td>").append("Available").append("</td>");
                    }else{
                        out.append("<td>").append("Unavailable").append("</td>");
                    }
                    out.append("</tr>");          
                }
            }
                 
        }finally {            
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
