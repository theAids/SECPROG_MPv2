/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author earleenjanefuentes
 */
public class CustomerBean extends UserBean {
    protected String bAddress;
    protected String dAddress;

    public CustomerBean(){
        
    }
    public CustomerBean(int userID, String username, String fname, String minitial, String lname, String email, String password, int status) {
        super(userID, username, fname, minitial, lname, email, password, status);
    }

    public CustomerBean(String bAddress, String dAddress, int userID, String username, String fname, String minitial, String lname, String email, String password, int status) {
        super(userID, username, fname, minitial, lname, email, password, status);
        this.bAddress = bAddress;
        this.dAddress = dAddress;
    }

    @Override
    public String getMinitial() {
        return super.getMinitial(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMinitial(String minitial) {
        super.setMinitial(minitial); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFname() {
        return super.getFname(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLname() {
        return super.getLname(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStatus() {
        return super.getStatus(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUserID() {
        return super.getUserID(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUsername() {
        return super.getUsername(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getbAddress() {
        return bAddress;
    }

    public String getdAddress() {
        return dAddress;
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFname(String fname) {
        super.setFname(fname); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLname(String lname) {
        super.setLname(lname); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserID(int userID) {
        super.setUserID(userID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username); //To change body of generated methods, choose Tools | Templates.
    }

    public void setbAddress(String bAddress) {
        this.bAddress = bAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
    }
    
     
}
