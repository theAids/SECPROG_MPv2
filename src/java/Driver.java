

import Bean.BookBean;
import Bean.CustomerBean;
import Bean.DvdBean;
import Bean.ProductBean;
import Bean.ProductLogBean;
import Bean.UserBean;
import DAO.Implementation.ProductImplementation;
import DAO.Implementation.ProductlogImplementation;
import DAO.Implementation.SignlogImplementation;
import DAO.Implementation.UserDAOImplementation;
import DAO.Interface.ProductlogInterface;
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

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
       
        
      
        UserDAOInterface userIM = new UserDAOImplementation();
        SignlogInterface signlogIM = new SignlogImplementation();
        ArrayList<UserBean> aUsers = userIM.getAllUser();
        
        UserBean u = userIM.getCustomer("eyjaneh_");
        System.out.println(u.getCreated());
        
        userIM.unlockUser(u.getUsername());
        
        //for(UserBean u: aUsers){
        //    System.out.println(u.getUsername());
        //}
        /*UserBean ub= new UserBean();
        ub.setUserID(1);
        ProductBean pb =new ProductBean();
        pb.setProductID(8);
        DvdBean db=new DvdBean();*/
        //db.setProductID(6);
        //db.setDirector("liam neeson");
        /*ProductImplementation pi=new ProductImplementation();
        pi.deleteBook(pi.getProductByTitle("harry prouy").getProductID());
        BookBean bb =new BookBean();
        bb.setProductID(8);*/
       // bb.setAuthor("pen");
        //pi.addBook(bb);
       //ProductLogBean plb=new ProductLogBean();
        //plb.setActivity("d-Book");
       // ProductlogInterface pli=new ProductlogImplementation();
       // pli.addProductLog(ub, pb, plb);
        
        
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
