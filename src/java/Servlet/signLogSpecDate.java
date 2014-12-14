/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Bean.SignLogBean;
import Bean.UserBean;
import DAO.Implementation.SignlogImplementation;
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
@WebServlet(name = "signLogSpecDate", urlPatterns = {"/signLogSpecDate"})
public class signLogSpecDate extends HttpServlet {

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
           String title = null;
           UserDAOImplementation user = new UserDAOImplementation();
           SignlogImplementation userlogs = new SignlogImplementation();
           ArrayList<UserBean> userbean = new ArrayList<UserBean>();
           ArrayList<SignLogBean> userlogbean = new ArrayList<SignLogBean>();

            UserBean ubean = new UserBean(); 

            userlogbean = userlogs.getAllUserLogs();
            userbean = user.getAllUser();
       
       out.println("<thead>");
          out.println("<tr>");
            out.println("<th>Log Date and Timestamp</th>");
            out.println("<th>Username</th>");
          out.println("</tr>");
          
          out.println("<tr>");
            out.println("<th>Log Date and Timestamp</th>");
            out.println("<th>Username</th>");
          out.println("</tr>");
        out.println("</thead>");
            
        for (int i=0;i<userlogbean.size();i++){
            if(date.equals(userlogbean.get(i).getLogDate().toString("MM/dd/yyyy"))){
       out.print("<tr>");
            out.print("<td>"+userlogbean.get(i).getLogDate().toString("MM/dd/yyyy HH:mm:ss")+"</td>");
            //out.print("<td>"+userlogbean.get(i).getUserID()+"</td>");
            for(int j=0;j<userbean.size();j++){
                 if(userlogbean.get(i).getUserID() == userbean.get(j).getUserID())
                 title = userbean.get(j).getUsername();
             } 
            out.println("<td>"+title+"</td>");
        out.print("</tr>");
            }
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
