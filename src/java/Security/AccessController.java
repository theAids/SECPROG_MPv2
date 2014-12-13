/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Security;

import Bean.UserBean;
import org.owasp.esapi.errors.AccessControlException;

/**
 *
 * @author Kaye
 */
public class AccessController implements org.owasp.esapi.AccessController {

    private int CREATE_USER;
    private int EDIT_USER;
    private int DELETE_USER;
    private int REGISTER_USER;
    private int UNLOCK_USER;
    //private int POST_REVIEW;
    private int ADD_BOOK;
    private int DELETE_BOOK;
    private int EDIT_BOOK;
    private int ADD_CD;
    private int DELETE_CD;
    private int EDIT_CD;
    private int ADD_DVD;
    private int DELETE_DVD;
    private int EDIT_DVD;
    private int ADD_MAGAZINE;
    private int DELETE_MAGAZINE;
    private int EDIT_MAGAZINE;
    private int VIEW_FINANCE;
    
    protected UserBean loggedInUser;

    public AccessController(int CREATE_USER, int EDIT_USER, int DELETE_USER, int REGISTER_USER, int UNLOCK_USER, int ADD_BOOK, int DELETE_BOOK, int EDIT_BOOK, int ADD_CD, int DELETE_CD, int EDIT_CD, int ADD_DVD, int DELETE_DVD, int EDIT_DVD, int ADD_MAGAZINE, int DELETE_MAGAZINE, int EDIT_MAGAZINE, int VIEW_FINANCE, UserBean loggedInUser) {
        this.CREATE_USER = CREATE_USER;
        this.EDIT_USER = EDIT_USER;
        this.DELETE_USER = DELETE_USER;
        this.REGISTER_USER = REGISTER_USER;
        this.UNLOCK_USER = UNLOCK_USER;
        this.ADD_BOOK = ADD_BOOK;
        this.DELETE_BOOK = DELETE_BOOK;
        this.EDIT_BOOK = EDIT_BOOK;
        this.ADD_CD = ADD_CD;
        this.DELETE_CD = DELETE_CD;
        this.EDIT_CD = EDIT_CD;
        this.ADD_DVD = ADD_DVD;
        this.DELETE_DVD = DELETE_DVD;
        this.EDIT_DVD = EDIT_DVD;
        this.ADD_MAGAZINE = ADD_MAGAZINE;
        this.DELETE_MAGAZINE = DELETE_MAGAZINE;
        this.EDIT_MAGAZINE = EDIT_MAGAZINE;
        this.VIEW_FINANCE = VIEW_FINANCE;
        this.loggedInUser = loggedInUser;
    }

    public int getADD_BOOK() {
        return ADD_BOOK;
    }

    public int getADD_CD() {
        return ADD_CD;
    }

    public int getADD_DVD() {
        return ADD_DVD;
    }

    public int getADD_MAGAZINE() {
        return ADD_MAGAZINE;
    }

    public int getDELETE_BOOK() {
        return DELETE_BOOK;
    }

    public int getDELETE_CD() {
        return DELETE_CD;
    }

    public int getDELETE_DVD() {
        return DELETE_DVD;
    }

    public int getDELETE_MAGAZINE() {
        return DELETE_MAGAZINE;
    }

    public int getEDIT_BOOK() {
        return EDIT_BOOK;
    }

    public int getEDIT_CD() {
        return EDIT_CD;
    }

    public int getEDIT_DVD() {
        return EDIT_DVD;
    }

    public int getEDIT_MAGAZINE() {
        return EDIT_MAGAZINE;
    }

    public int getVIEW_FINANCE() {
        return VIEW_FINANCE;
    }

    public void setADD_BOOK(int ADD_BOOK) {
        this.ADD_BOOK = ADD_BOOK;
    }

    public void setADD_CD(int ADD_CD) {
        this.ADD_CD = ADD_CD;
    }

    public void setADD_DVD(int ADD_DVD) {
        this.ADD_DVD = ADD_DVD;
    }

    public void setADD_MAGAZINE(int ADD_MAGAZINE) {
        this.ADD_MAGAZINE = ADD_MAGAZINE;
    }

    public void setDELETE_BOOK(int DELETE_BOOK) {
        this.DELETE_BOOK = DELETE_BOOK;
    }

    public void setDELETE_CD(int DELETE_CD) {
        this.DELETE_CD = DELETE_CD;
    }

    public void setDELETE_DVD(int DELETE_DVD) {
        this.DELETE_DVD = DELETE_DVD;
    }

    public void setDELETE_MAGAZINE(int DELETE_MAGAZINE) {
        this.DELETE_MAGAZINE = DELETE_MAGAZINE;
    }

    public void setEDIT_BOOK(int EDIT_BOOK) {
        this.EDIT_BOOK = EDIT_BOOK;
    }

    public void setEDIT_CD(int EDIT_CD) {
        this.EDIT_CD = EDIT_CD;
    }

    public void setEDIT_DVD(int EDIT_DVD) {
        this.EDIT_DVD = EDIT_DVD;
    }

    public void setEDIT_MAGAZINE(int EDIT_MAGAZINE) {
        this.EDIT_MAGAZINE = EDIT_MAGAZINE;
    }

    public void setVIEW_FINANCE(int VIEW_FINANCE) {
        this.VIEW_FINANCE = VIEW_FINANCE;
    }
    
    public int getCREATE_USER() {
        return CREATE_USER;
    }

    public int getDELETE_USER() {
        return DELETE_USER;
    }

    public int getEDIT_USER() {
        return EDIT_USER;
    }

    public UserBean getLoggedInUser() {
        return loggedInUser;
    }

    public int getREGISTER_USER() {
        return REGISTER_USER;
    }

    public int getUNLOCK_USER() {
        return UNLOCK_USER;
    }

    public void setCREATE_USER(int CREATE_USER) {
        this.CREATE_USER = CREATE_USER;
    }

    public void setDELETE_USER(int DELETE_USER) {
        this.DELETE_USER = DELETE_USER;
    }

    public void setEDIT_USER(int EDIT_USER) {
        this.EDIT_USER = EDIT_USER;
    }

    public void setLoggedInUser(UserBean loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setREGISTER_USER(int REGISTER_USER) {
        this.REGISTER_USER = REGISTER_USER;
    }

    public void setUNLOCK_USER(int UNLOCK_USER) {
        this.UNLOCK_USER = UNLOCK_USER;
    }

    public AccessController() {
        this.CREATE_USER = 0;
        this.EDIT_USER = 0;
        this.DELETE_USER = 0;
        this.REGISTER_USER = 0;
        this.UNLOCK_USER = 0;
        this.loggedInUser = null;
    }
 
    @Override
    public boolean isAuthorized(Object o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorized(Object o, Object o1) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForURL(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForFunction(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForData(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForFile(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForService(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForURL(String string) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForFunction(String string) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForData(String string, Object o) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForFile(String string) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForService(String string) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
