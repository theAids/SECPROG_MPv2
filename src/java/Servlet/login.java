/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.UserBean;
import DAO.Implementation.UserDAOImplementation;
import DAO.Interface.UserDAOInterface;
import Security.AccessController;
import Security.Authenticator;
import Security.Hash;
import Security.Randomizer;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.User;
import org.owasp.esapi.errors.AuthenticationException;

/**
 *
 * @author earleenjanefuentes
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            throws ServletException, IOException, AuthenticationException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            UserBean loggedInUser = null;
            String clientAddress = null;
            String clientSalt = null;
            String clientToken = null;
            
            UserDAOInterface userIM = new UserDAOImplementation();
            HttpSession userSession = null;
            
            Hash hashGenerator = new Hash();
            Randomizer randomGenerator = new Randomizer();
            
            Authenticator authenticator = new Authenticator();
            loggedInUser = (UserBean) authenticator.login(request, response);
            
            /* check if account is locked...*/
            if (loggedInUser != null && loggedInUser.getStatus() == 3) {
                response.sendRedirect("Lockout.jsp");
                return;
            }

            /* check if account will expire */
            if (loggedInUser != null && loggedInUser.getStatus() == 2) {
                /*Timestamp now = new Timestamp(System.currentTimeMillis());
                long time_elapsed = compareTwoTimeStamps(now, loggedInUser.getCreated());
                
                if(time_elapsed > 1440){
                    userIM.expireUser(loggedInUser);
                    response.sendRedirect("Expire.jsp");
                    return;
                }else{*/
                    
                //}
                
            
            }

            if (loggedInUser != null && loggedInUser.isLoggedIn()) {
                //out.println("I AM HERE");
                request.getSession().invalidate();

                userSession = request.getSession(true);

                userSession.setMaxInactiveInterval(600);
                userSession.setMaxInactiveInterval(300); // recommended by owasp for hv app https://www.owasp.org/index.php/Session_Management
                
                /* HASH CLIENT TOKEN */
                clientAddress = request.getRemoteAddr();
                clientSalt = Long.toString(randomGenerator.getRandomLong());
                hashGenerator.updateHash(clientAddress, "UTF-8");
                hashGenerator.updateHash(clientSalt, "UTF-8");
                clientToken = hashGenerator.getHashBASE64();
                userSession.setAttribute("client_user", loggedInUser);
                userSession.setAttribute("client_token", clientToken);
                
                AccessController acl = new AccessController();
                //UserDAOInterface userIM = new UserDAOImplementation();
                String type = userIM.getUserType(loggedInUser);
                if (type.equals("Customer")) {
                    acl.setLoggedInUser(loggedInUser);
                } else if (type.equals("Administrator")) {
                    acl.setLoggedInUser(loggedInUser);
                    acl.setCREATE_USER(1);
                    acl.setDELETE_USER(1);
                    acl.setUNLOCK_USER(1);
                    
                    if(loggedInUser.getStatus() == 2){
                    response.sendRedirect("ActivateAccount.jsp");
                    return;
                    }/*else{
                        response.sendRedirect("CreateManager.jsp");
                        return;
                    }*/
                    
                    
                } else if (type.equals("Book")) {
                    acl.setLoggedInUser(loggedInUser);
                    acl.setADD_BOOK(1);
                    acl.setDELETE_BOOK(1);
                    acl.setEDIT_BOOK(1);
                } else if (type.equals("CD")) {
                    acl.setLoggedInUser(loggedInUser);
                    acl.setADD_CD(1);
                    acl.setDELETE_CD(1);
                    acl.setEDIT_CD(1);
                } else if (type.equals("DVD")) {
                    acl.setLoggedInUser(loggedInUser);
                    acl.setADD_DVD(1);
                    acl.setDELETE_DVD(1);
                    acl.setEDIT_DVD(1);
                } else if (type.equals("Magazine")) {
                    acl.setLoggedInUser(loggedInUser);
                    acl.setADD_MAGAZINE(1);
                    acl.setDELETE_MAGAZINE(1);
                    acl.setEDIT_MAGAZINE(1);
                } else {
                    acl.setLoggedInUser(loggedInUser);
                    acl.setVIEW_FINANCE(1);
                }

                userSession.setAttribute("acl", acl);
                //loggedInUser.addSession(userSession);
                
                if(loggedInUser.getStatus() == 2){
                    response.sendRedirect("ActivateAccount.jsp");
                    return;
                }

                //redirect it to somewhere...
                response.sendRedirect("SearchPage.jsp");
            } else {
                //log
                response.sendRedirect("Login.jsp");
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
        try {
            processRequest(request, response);
        } catch (AuthenticationException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (AuthenticationException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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

    public static long compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime) {
        long milliseconds1 = oldTime.getTime();
        long milliseconds2 = currentTime.getTime();

        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffMinutes;
    }

}
