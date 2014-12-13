

import Bean.BookBean;
import Bean.CustomerBean;
import Bean.ProductBean;
import Bean.UserBean;
import DAO.Implementation.ProductImplementation;
import DAO.Implementation.SignlogImplementation;
import DAO.Implementation.UserDAOImplementation;
import DAO.Interface.SignlogInterface;
import DAO.Interface.UserDAOInterface;
import Security.Hash;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kimberly
 */
public class Driver {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
       
        
      
        UserDAOInterface userIM = new UserDAOImplementation();
        SignlogInterface signlogIM = new SignlogImplementation();
        ArrayList<UserBean> aUsers = userIM.getAllUser();
        
        for(UserBean u: aUsers){
            System.out.println(u.getUsername());
        }
      /*  
        UserBean u = userIM.getUser("reginag_");
        CustomerBean c = userIM.getCustomer("reginag_");
        int n = signlogIM.checkLock(u);
        System.out.println(n);
<<<<<<< HEAD
<<<<<<< HEAD
        */     
        /*      CustomerBean cbean = new CustomerBean();
=======
=======
>>>>>>> 5ea3b09187885431c2dcc7036f865f30e42adc40
        
        System.out.println(userIM.getUserType(c).equals("Customer"));
        System.out.println(c.getbAddress());
             
        /*     CustomerBean cbean = new CustomerBean();
>>>>>>> 5ea3b09187885431c2dcc7036f865f30e42adc40
             String username = "eyjane";
             String fname = "earleen";
             String lname = "fuentes";
             String mname = "p";
             String email = "earleen@fls.sda";
             String password = "sarah";
             int m = 1;
             int d = 3;
             int y = 11;
             
             String bhouse = "1";
             String bstreet = "1";
             String bsubdivision = "";
             String bcity = "1";
             String bpostal = "132";
             String bcountry = "PH";
             
             String dhouse = "1";
             String dstreet = "1";
             String dsubdivision = "1";
             String dcity = "1";
             String dpostal = "1";
             String dcountry = "US";
             
             String bsub;
             String dsub;
             if(bsubdivision.equals("")){
                 bsub = "";
             }else{
                 bsub = bsubdivision + " ";
             }
             
             if(dsubdivision.equals("")){
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
             cbean.setPassword(password);
             cbean.setbAddress(bAdd);
             cbean.setdAddress(dAdd);
             cbean.setEmail(email);
             
             
             userIM.addCustomerAccount(cbean);
        */
        //Hash hasher = new Hash();
        //hasher.updateHash("hello", "UTF-8");
        
        //System.out.println(hasher.getHashBASE64());

    }
}