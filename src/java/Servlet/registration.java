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
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author earleenjanefuentes
 */
@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class registration extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             HttpSession session = request.getSession();
             
             UserDAOInterface userIM = new UserDAOImplementation();
             
             CustomerBean cbean = new CustomerBean();
             String username = request.getParameter("username");
             String fname = request.getParameter("firstname");
             String lname = request.getParameter("lastname");
             String mname = request.getParameter("middleI");
             String email = request.getParameter("email");
             String password = request.getParameter("password");
             
             String bhouse = request.getParameter("bhouse");
             String bstreet = request.getParameter("bstreet");
             String bsubdivision = request.getParameter("bstreet");
             String bcity = request.getParameter("bcity");
             String bpostal = request.getParameter("bpostal");
             String bcountry = request.getParameter("bcountry");
             
             String dhouse = request.getParameter("dhouse");
             String dstreet = request.getParameter("dstreet");
             String dsubdivision = request.getParameter("dstreet");
             String dcity = request.getParameter("dcity");
             String dpostal = request.getParameter("dpostal");
             String dcountry = request.getParameter("dcountry");
             
             String bsub;
             String dsub;
             if(bsubdivision != null){
                 bsub = "";
             }else{
                 bsub = bsubdivision + " ";
             }
             
             if(dsubdivision != null){
                 dsub = "";
             }else{
                 dsub = "dsubdivision" + " ";
             }
             
             String bAdd = bhouse + " " + bstreet + " " + bsub + bcity + " " + bpostal + " " + bcountry;
             String dAdd = dhouse + " " + dstreet + " " + dsub + dcity + " " + dpostal + " " + dcountry;
             
             cbean.setUsername(username);
             cbean.setFname(fname);
             cbean.setLname(lname);
             cbean.setMinitial(mname);
             //cbean.setPassword(password);
             cbean.setbAddress(bAdd);
             cbean.setdAddress(dAdd);
             cbean.setEmail(email);
             
             /* HASH PASSWORD */
             Authenticator authenticator = new Authenticator();
             cbean.setPassword(authenticator.hashPassword(password));
             
             userIM.addCustomerAccount(cbean);
             response.sendRedirect("Login.jsp");
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
        }
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
