/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.CustomerBean;
import Bean.UserBean;
import DAO.Implementation.UserDAOImplementation;
import DAO.Interface.UserDAOInterface;
import Security.Authenticator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author earleenjanefuentes
 */
@WebServlet(name = "editAccount", urlPatterns = {"/editAccount"})
public class editAccount extends HttpServlet {

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
             
             
             int userID = Integer.parseInt(request.getParameter("userID"));
             UserBean user = userIM.getUser(userID);
             
             //CustomerBean cbean = new CustomerBean();
             String username = request.getParameter("username");
             String fname = request.getParameter("firstname");
             String lname = request.getParameter("lastname");
             String mname = request.getParameter("middleI");
             String email = request.getParameter("email");
             String password = request.getParameter("password");
             
             String bAdd = request.getParameter("badd");
             String bpostal = request.getParameter("bpostal");
             String bcountry = request.getParameter("bcountry");
             
             String dAdd = request.getParameter("dadd");
             String dpostal = request.getParameter("dpostal");
             String dcountry = request.getParameter("dcountry");
             
             String bAddr = bAdd + " " + bpostal + " " + bcountry;
             String dAddr = dAdd + " " + dpostal + " " + dcountry;
             
             if(userIM.getUserType(user).equals("Customer")){
                 CustomerBean cbean = userIM.getCustomer(Integer.parseInt(request.getParameter("userID")));
                 //out.println(cbean.getUsername());
                 cbean.setUsername(username);
                 cbean.setFname(fname);
                 cbean.setLname(lname);
                 cbean.setMinitial(mname);
                 cbean.setbAddress(bAddr);
                 cbean.setdAddress(dAddr);
                 cbean.setEmail(email);
                 userIM.editCustomer(cbean);
             }else{
                 user.setUsername(username);
                 user.setFname(fname);
                 user.setMinitial(mname);
                 user.setLname(lname);
                 user.setEmail(email);
                 userIM.editAdministrativeAccount(user);
             }
            
             response.sendRedirect("ViewProfile.jsp");
             //out.println("REGISTRATION SUCCESS!");
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
