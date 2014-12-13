/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Security;

import Bean.UserBean;
import DAO.Implementation.SignlogImplementation;
import DAO.Implementation.UserDAOImplementation;
import DAO.Interface.SignlogInterface;
import DAO.Interface.UserDAOInterface;
//import com.sun.istack.logging.Logger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.User;
import org.owasp.esapi.errors.AuthenticationException;
import org.owasp.esapi.errors.EncryptionException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Kaye
 */
public class Authenticator implements org.owasp.esapi.Authenticator {

    @Override
    public void clearCurrent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login() throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserBean login(HttpServletRequest hsr, HttpServletResponse hsr1) throws AuthenticationException {
        UserDAOInterface userIM = new UserDAOImplementation();
        SignlogInterface signlogIM = new SignlogImplementation();
        
        int userID = -1;
        String userName = null;
        String userPassword = null;
        UserBean u = null;
        int i;
      
        ArrayList<UserBean> aUsers = userIM.getAllUser();
      
        userName = hsr.getParameter("username");
        userPassword = hsr.getParameter("password");
        System.out.println(userPassword);
        
        /* CHECK LOGIN ATTEMPTS */
        UserBean user = userIM.getUser(userName);
        int nAttempts = signlogIM.checkLock(user);
        
        if(user != null && nAttempts >= 5){
            userIM.lockUser(user);
            
            user = userIM.getUser(userName);
           
            return user;
        }
        
        /* hash password */
        try {
            userPassword = hashPassword(userPassword);
        } catch (NoSuchAlgorithmException ex) {
            java.util.logging.Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }

        //traverse the arrayList
        for (i = 0; i < aUsers.size(); i++) {
            if (userName.equals(aUsers.get(i).getUsername())) {
                if(userPassword.equals(aUsers.get(i).getPassword())){
                     aUsers.get(i).setIsLoggedIn(true);
                    //log
                    //System.out.println("YES");
                    signlogIM.addLog(aUsers.get(i), 1);
                    return aUsers.get(i);
                }else{
                    System.out.println("NO");
                    
                    signlogIM.addLog(aUsers.get(i), 0);
                    return aUsers.get(i);
                }        
            }
        }
        
        System.out.println("NAY");
        u.setUserID(-1); //-1 means non-existent user
        signlogIM.addLog(u, 0);
        return null;
    }

    public static void reAuthenticateUser(HttpSession userSession, String clientAddress) throws AuthenticationException, NoSuchAlgorithmException,UnsupportedEncodingException{
        String challenge = "";
        User loggedInUser = null;
        String storedSalt = "";
        String clientToken = "";
        Hash hashGenerator = null;
        loggedInUser = (User)userSession.getAttribute("client_user");
        
        if(loggedInUser == null || !loggedInUser.isLoggedIn()) {
            
        }
        else {
            storedSalt = (String)userSession.getAttribute("client_salt");
            hashGenerator = new Hash();
            hashGenerator.updateHash(clientAddress, "UTF-8");
            hashGenerator.updateHash(storedSalt,"UTF-8");
            challenge = hashGenerator.getHashBASE64();
            clientToken = (String)userSession.getAttribute("client_token");
            if(clientToken == null || !clientToken.equals(challenge)){
                //tell user to log in again because session is invalid or expired
            }
        }
    }
        
    @Override
    public boolean verifyPassword(User user, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User createUser(String string, String string1, String string2) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateStrongPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generateStrongPassword(User user, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePassword(User user, String string, String string1, String string2) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(long l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set getUserNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getCurrentUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCurrentUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String hashPassword(String string, String string1) throws EncryptionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUser(String string) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verifyAccountNameStrength(String string) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verifyPasswordStrength(String string, String string1, User user) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String hashPassword(String p) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        /*MessageDigest hasher;
        hasher = MessageDigest.getInstance("MD5");
        hasher.reset();
        hasher.update(p.getBytes("UTF-8"));
        return new BASE64Encoder().encode(hasher.digest());*/
        
        Hash hasher = new Hash();
        hasher.updateHash(p, "UTF-8");
        
        return hasher.getHashBASE64();
    }
    
    
}
