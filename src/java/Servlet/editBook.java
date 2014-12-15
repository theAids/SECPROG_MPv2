/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BookBean;
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
public class editBook extends HttpServlet {

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
            if (acl.getEDIT_BOOK() == 1) {
                ProductInterface pi = new ProductImplementation();
                ProductlogInterface pli = new ProductlogImplementation();
                ProductBean pb = new ProductBean();
                BookBean db = new BookBean();
                ProductLogBean plb = new ProductLogBean();

                //get which row
                String orig = request.getParameter("origBooktitle");
                pb.setProductID(pi.getProductByTitle(orig).getProductID());
                if (pb.getProductID() != 0) {
                    //checks for changes
                    String title = request.getParameter("editBooktitle");
                    if (title.length() > 0) {
                        pi.editProductByTitle(pb.getProductID(), title);
                        plb.setActivity("E- Book");
                        pli.addProductLog(user, pb, plb);
                    }
                    String summary = request.getParameter("editBookSummary");
                    if (summary.length() > 0) {
                        pi.editProductBySummary(pb.getProductID(), summary);
                        plb.setActivity("E- BooSUM");
                        pli.addProductLog(user, pb, plb);
                    }
                    String price = request.getParameter("editBookPrice");
                    if (price.length() > 0) {
                        pi.editProductByPrice(pb.getProductID(), Float.parseFloat(price));
                        plb.setActivity("E- BooPRi");
                        pli.addProductLog(user, pb, plb);
                    }
                    String stock = request.getParameter("editBookStock");
                    if (stock.length() > 0) {
                        pi.editProductByStock(pb.getProductID(), Float.parseFloat(stock));
                        plb.setActivity("E- BooSto");
                        pli.addProductLog(user, pb, plb);
                    }
                    String status = request.getParameter("editBookPstatus");
                    if (status.length() > 0) {
                        pi.editProductByStatus(pb.getProductID(), status);
                        plb.setActivity("E- BooSta");
                        pli.addProductLog(user, pb, plb);
                    }
                    String author = request.getParameter("editBookAuthor");
                    if (author.length() > 0) {
                        pi.editBookByAuthor(pb.getProductID(), author);
                        plb.setActivity("E- BooAut");
                        pli.addProductLog(user, pb, plb);
                    }
                    try (PrintWriter out = response.getWriter()) {
                        out.println("edited successfully");
                        //response.sendRedirect("BookManagement.jsp");
                    }
                }
                else{
                try (PrintWriter out = response.getWriter()) {
                        out.println("No such book exist");
                        //response.sendRedirect("BookManagement.jsp");
                    }
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
            out.println("<title>Servlet editBook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editBook at " + request.getContextPath() + "</h1>");
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
