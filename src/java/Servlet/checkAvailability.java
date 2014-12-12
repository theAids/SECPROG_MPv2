/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.UserBean;
import DAO.Implementation.UserDAOImplementation;
import DAO.Interface.UserDAOInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author earleenjanefuentes
 */
@WebServlet(name = "checkAvailability", urlPatterns = {"/checkAvailability"})
public class checkAvailability extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            UserDAOInterface userIM = new UserDAOImplementation();
            
            ArrayList<UserBean> aUsers = userIM.getAllUser();
            String username = request.getParameter("uname");
            String email = request.getParameter("email");
            
            int avail = 0;
            
            System.out.println(username);
            int i;
            /* check for username & email is used */
             for(i=0; i < aUsers.size(); i++){
                 if(username.equals(aUsers.get(i).getUsername())){
                     avail = 1; //1 if only username is in use
                     System.out.println("HERE!");
                     if(email.equals(aUsers.get(i).getEmail())){
                         avail = 3; //3 if both have been used
                     }
                     break;
                 }else{
                     if(email.equals(aUsers.get(i).getEmail())){
                         avail = 2; // 2 if only email is in use
                         break;
                     }else{
                         avail = 0; //0 if none is in use
                         //break;
                     }
                     
                 }
             }
             System.out.println("AVAIL: " + avail);
             
             if(avail == 0){
                 out.println("none");
             }else if(avail == 1){
                 
                 out.println("username");
             }else if(avail == 2){
                 out.println("email");
             }else{
                 out.println("both");
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
