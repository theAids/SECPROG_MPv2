/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.DvdBean;
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
public class editDVD extends HttpServlet {

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
            if (acl.getEDIT_DVD() == 1) {
                ProductInterface pi = new ProductImplementation();
                ProductlogInterface pli = new ProductlogImplementation();
                ProductBean pb = new ProductBean();
                DvdBean db = new DvdBean();
                ProductLogBean plb = new ProductLogBean();
              
                //get which row
                String orig = request.getParameter("origDVDtitle");
                pb.setProductID(pi.getProductByTitle(orig).getProductID());
                //checks for changes
                String title = request.getParameter("editDVDtitle");
                if (title.length() > 0) {
                    pi.editProductByTitle(pb.getProductID(), title);
                    plb.setActivity("E- DVD");
                    pli.addProductLog(user, pb, plb);
                }
                String summary = request.getParameter("editDVDSummary");
                if (summary.length() > 0) {
                    pi.editProductBySummary(pb.getProductID(), summary);
                    plb.setActivity("E- DVSUM");
                    pli.addProductLog(user, pb, plb);
                }
                String price = request.getParameter("editDVDPrice");
                if (price.length() > 0) {
                    pi.editProductByPrice(pb.getProductID(), Float.parseFloat(price));
                    plb.setActivity("E- DVPRi");
                    pli.addProductLog(user, pb, plb);
                }
                String stock = request.getParameter("editDVDStock");
                if (stock.length() > 0) {
                    pi.editProductByStock(pb.getProductID(), Float.parseFloat(stock));
                    plb.setActivity("E- DVSto");
                    pli.addProductLog(user, pb, plb);
                }
                String status = request.getParameter("editDVDPstatus");
                if (status.length() > 0) {
                    pi.editProductByStatus(pb.getProductID(), status);
                    plb.setActivity("E- DVSta");
                    pli.addProductLog(user, pb, plb);
                }
                String director = request.getParameter("editDVDDirector");
                if (director.length() > 0) {
                    pi.editDVDByDirector(pb.getProductID(), director);
                    plb.setActivity("E- DVDDir");
                    pli.addProductLog(user, pb, plb);
                }
                try (PrintWriter out = response.getWriter()) {
                    out.println("edited successfully");
                    //response.sendRedirect("DVDManagement.jsp");
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editDVD</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editDVD at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
