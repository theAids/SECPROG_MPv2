
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.MagBean;
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
public class addMagazines extends HttpServlet {

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
            if (acl.getADD_MAGAZINE() == 1) {
                ProductInterface pi = new ProductImplementation();
                ProductlogInterface pli = new ProductlogImplementation();
                ProductBean pb = new ProductBean();
                MagBean mb = new MagBean();
                ProductLogBean plb = new ProductLogBean();
                mb.setTitle(request.getParameter("addMagtitle"));
                mb.setSummary(request.getParameter("addMagSummary"));
                mb.setPrice(Float.parseFloat(request.getParameter("addMagPrice")));
                mb.setStock(Float.parseFloat(request.getParameter("addMagStock")));
                mb.setPstatus(request.getParameter("addMagPstatus"));
                mb.setVolNo(Integer.parseInt(request.getParameter("addMagVolumeNumber")));
                mb.setIssueNo(Integer.parseInt(request.getParameter("addMagIssueNumber")));
                pb.setPrice(mb.getPrice());
                pb.setPstatus(mb.getPstatus());
                pb.setStock(mb.getStock());
                pb.setSummary(mb.getSummary());
                pb.setTitle(mb.getTitle());
                plb.setActivity("Added New Magazine");
                plb.setUserID(user.getUserID());
                pi.addProduct(pb);
                mb.setProductID(pi.getProductBytitle(pb.getTitle()).getProductID());
                pb.setProductID(mb.getProductID());
                pi.addMagazine(mb);
                pli.addProductLog(user, pb, plb);
                try (PrintWriter out = response.getWriter()) {
                    out.println("added successfully");
                }
                response.sendRedirect("MagazineManagement.jsp");
            } else {
                response.sendRedirect("Unauthorized.jsp");
            }
            //end of authorized below is to catch user without a session 
        } else {
            response.sendRedirect("Unauthorized.jsp");
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<h1>Servlet addMagazines at " + request.getContextPath() + "</h1>");

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
