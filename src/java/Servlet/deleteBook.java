
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BookBean;
import Bean.ProductBean;
import Bean.ProductLogBean;
import Bean.UserBean;
import DAO.Implementation.ProductImplementation;
import DAO.Implementation.ProductlogImplementation;
import DAO.Interface.ProductInterface;
import DAO.Interface.ProductlogInterface;
import Security.AccessController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joechua
 */
public class deleteBook extends HttpServlet {

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
        HttpSession session = request.getSession(false); //to ensure that no new session will be created
        String referer = request.getHeader("Referer");
        if (session != null) {
            UserBean user = (UserBean) session.getAttribute("client_user");
            //String clientToken = (String) session.getAttribute("client_token"); //unused
            AccessController acl = (AccessController) session.getAttribute("acl"); //unused
            //UserDAOInterface userIM = new UserDAOImplementation();
            // String type = userIM.getUserType(user);
            if (acl.getDELETE_BOOK() == 1) {
                ProductInterface pi = new ProductImplementation();
                ProductlogInterface pli = new ProductlogImplementation();
                ProductBean pb = new ProductBean();
                BookBean bb = new BookBean();
                ProductLogBean plb = new ProductLogBean();
                bb.setTitle(request.getParameter("delBooktitle"));
                plb.setUserID(user.getUserID());
                bb.setProductID(pi.getProductBytitle(bb.getTitle()).getProductID());
                pb.setProductID(bb.getProductID());
                plb.setActivity("d- Book");
                pi.deleteBook(bb.getProductID());
                pli.addProductLog(user, pb, plb);
                try (PrintWriter out = response.getWriter()) {
                    out.println("deleted successfully");
                    //response.sendRedirect("BookManagement.jsp");
                }

            } else {
                response.sendRedirect("Unauthorized.jsp");
            }
            //end of authorized below is to catch user without a session 
        } else {
            response.sendRedirect("Unauthorized.jsp");
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<h1>Servlet addBook at " + request.getContextPath() + "</h1>");

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

