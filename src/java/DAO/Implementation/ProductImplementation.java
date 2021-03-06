
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implementation;

import Bean.BookBean;
import Bean.CDBean;
import Bean.DvdBean;
import Bean.MagBean;
import Bean.ProductBean;
import DAO.Interface.ProductInterface;
import DB.Connection.DBConnectionFactory;
//import DBConnection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kimberly
 */
public class ProductImplementation implements ProductInterface {

    private Connection connection;
    private DBConnectionFactory dBConnectionFactory;

    public void addProduct(ProductBean bean) {
        //int prodID = 0;
        try {
            //gets date and time of today
          /*  java.util.Date now = new java.util.Date();
             java.sql.Date today = new java.sql.Date(now.getTime());*/

            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO  product(title,summary,price,stock,pstatus,category) VALUES (?,?,?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setString(1, bean.getTitle());
            prep.setString(2, bean.getSummary());
            prep.setFloat(3, bean.getPrice());
            prep.setFloat(4, bean.getStock());
            prep.setString(5, bean.getPstatus()); //check availability(low stock)
            prep.setString(6, bean.getCategory());
            prep.executeUpdate();
            /*
             query = "SELECT * FROM product WHERE productID = ?";
             prep = connect.prepareStatement(query);
             ResultSet result = prep.executeQuery();
            
             while (result.next()) {
             prodID = result.getInt("productID");
             }*/

        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return prodID;
    }

    public void addBook(BookBean bean) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO  book(productID, author) VALUES (?,?)";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setInt(1, bean.getProductID());
            prep.setString(2, bean.getAuthor());
            prep.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addCD(CDBean bean) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO  cd(productID, artist) VALUES (?,?)";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setInt(1, bean.getProductID());
            prep.setString(2, bean.getArtist());
            prep.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addDvd(DvdBean bean) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO  dvd(productID, director) VALUES (?,?)";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setInt(1, bean.getProductID());
            prep.setString(2, bean.getDirector());
            prep.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addMagazine(MagBean bean) {
        System.out.println("issue num:" + bean.getIssueNo());
        System.out.println("vol num:" + bean.getVolNo());
        System.out.println("prod num:" + bean.getProductID());
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "INSERT INTO  mag(productID, volNo, issueNo) VALUES (?,?,?)";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setInt(1, bean.getProductID());
            prep.setInt(2, bean.getVolNo());
            prep.setInt(3, bean.getIssueNo());
            prep.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<ProductBean> getAllProducts() {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM product";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, name);

            ResultSet result = ps.executeQuery();
            ArrayList<ProductBean> beans = new ArrayList<ProductBean>();
            while (result.next()) {
                ProductBean bean = new ProductBean();
                bean.setProductID(result.getInt("productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                beans.add(bean);
            }
            return beans;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<BookBean> getAllBooks() {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM book, product WHERE book.productID = product.productID ";
             //String query = "SELECT * FROM book, product WHERE book.productID = product.productID and pstatus = 'Available'";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, name);

            ResultSet result = ps.executeQuery();
            ArrayList<BookBean> beans = new ArrayList<BookBean>();
            while (result.next()) {
                BookBean bean = new BookBean();
                bean.setProductID(result.getInt("book.productID"));
                bean.setAuthor(result.getString("author"));
                bean.setProductID(result.getInt("product.productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
                beans.add(bean);
            }
            return beans;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<CDBean> getAllCDs() {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM cd, product WHERE cd.productID = product.productID";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, name);

            ResultSet result = ps.executeQuery();
            ArrayList<CDBean> beans = new ArrayList<CDBean>();
            while (result.next()) {
                CDBean bean = new CDBean();
                bean.setProductID(result.getInt("cd.productID"));
                bean.setArtist(result.getString("artist"));
                bean.setProductID(result.getInt("product.productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
                beans.add(bean);
            }
            return beans;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<DvdBean> getAllDvds() {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM dvd, product WHERE dvd.productID = product.productID";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, name);

            ResultSet result = ps.executeQuery();
            ArrayList<DvdBean> beans = new ArrayList<DvdBean>();
            while (result.next()) {
                DvdBean bean = new DvdBean();
                bean.setProductID(result.getInt("dvd.productID"));
                bean.setDirector(result.getString("director"));
                bean.setProductID(result.getInt("product.productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
                beans.add(bean);
            }
            return beans;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MagBean> getAllMags() {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM mag, product WHERE mag.productID = product.productID";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1, name);

            ResultSet result = ps.executeQuery();
            ArrayList<MagBean> beans = new ArrayList<MagBean>();
            while (result.next()) {
                MagBean bean = new MagBean();
                bean.setProductID(result.getInt("mag.productID"));
                bean.setVolNo(result.getInt("volNo"));
                bean.setIssueNo(result.getInt("issueNo"));
                bean.setProductID(result.getInt("product.productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
                beans.add(bean);
            }
            return beans;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ProductBean getProductById(int productID) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM product WHERE productID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, productID);

            ResultSet result = ps.executeQuery();
            ProductBean bean = new ProductBean();
            while (result.next()) {
                bean.setProductID(result.getInt("product.productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<ProductBean> getProductByName(String title) //get from summary 
    {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "select * from product where title like ? or summary like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + title + "%");
            ps.setString(2, "%" + title + "%");

            ResultSet resultSet = ps.executeQuery();
            ProductBean bean;
            ArrayList<ProductBean> beans = new ArrayList<ProductBean>();

            while (resultSet.next()) {
                bean = new ProductBean();
                bean.setProductID(resultSet.getInt("productID"));
                bean.setTitle(resultSet.getString("title"));
                bean.setSummary(resultSet.getString("summary"));
                bean.setPrice(resultSet.getFloat("price"));
                bean.setStock(resultSet.getFloat("stock"));
                bean.setPstatus(resultSet.getString("pstatus"));
                bean.setCategory(resultSet.getString("category"));
                beans.add(bean);
            }
            return beans;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void editProductByTitle(int id, String title) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE product SET title = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setString(1, title);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProductBySummary(int id, String title) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE product SET summary = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setString(1, title);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProductByPrice(int id, float price) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE product SET price = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setFloat(1, price);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProductByStock(int id, float stock) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE product SET stock = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setFloat(1, stock);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProductByStatus(int id, String pstatus) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE product SET pstatus = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setString(1, pstatus);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editBookByAuthor(int id, String author) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE book SET author = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setString(1, author);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCDByArtist(int id, String artist) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE cd SET artist = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setString(1, artist);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editDVDByDirector(int id, String director) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE book SET director = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setString(1, director);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editMagByVolNo(int id, int volNo) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE mag SET volNo = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setInt(1, volNo);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editMagByIssueNo(int id, int issueNo) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "UPDATE mag SET issueNo = ? WHERE productID = ?";
            PreparedStatement prep = connection.prepareStatement(query);

            prep.setInt(1, issueNo);
            prep.setInt(2, id);

            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteBook(int productID) {
        //try {
            /*dBConnectionFactory = DBConnectionFactory.getInstance();
         connection = dBConnectionFactory.getConnection();
         String query = "DELETE FROM book WHERE book.productID = ?";
         PreparedStatement prep = connection.prepareStatement(query);

         prep.setInt(1, productID);
         prep.executeUpdate();

         String query2 = "DELETE FROM product WHERE productID = ?";
         PreparedStatement prep2 = connection.prepareStatement(query2);
         prep2.setInt(1, productID);
         prep2.executeUpdate();
         */

        //} catch (SQLException ex) {
        //    Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        //}
        editProductByStatus(productID, "Deleted");
    }

    public void deleteCD(int productID) {
        editProductByStatus(productID, "Deleted");
    }

    public void deleteDVD(int productID) {
        editProductByStatus(productID, "Deleted");
    }

    public void deleteMag(int productID) {
        editProductByStatus(productID, "Deleted");
    }

    @Override
    public ProductBean getProductByTitle(String title) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM product WHERE title = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, title);

            ResultSet result = ps.executeQuery();
            ProductBean bean = new ProductBean();
            while (result.next()) {
                bean.setProductID(result.getInt("productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public BookBean getBookById(int id) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM book, product WHERE product.productID = ? and book.productID = product.productID";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            BookBean bean = new BookBean();

            while (result.next()) {
                bean.setProductID(result.getInt("product.productID"));
                bean.setAuthor(result.getString("author"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public CDBean getCDById(int id) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM cd, product WHERE product.productID = ? and cd.productID = product.productID";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            CDBean bean = new CDBean();
            
            while (result.next()) {
                bean.setProductID(result.getInt("product.productID"));
                bean.setArtist(result.getString("artist"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public DvdBean getDVDById(int id) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM dvd, product WHERE product.productID = ? and dvd.productID = product.productID";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            DvdBean bean = new DvdBean();
            while (result.next()) {
                bean.setProductID(result.getInt("dvd.productID"));
                bean.setDirector(result.getString("director"));
                bean.setProductID(result.getInt("product.productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MagBean getMagById(int id) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM mag, product WHERE product.productID = ? and mag.productID = product.productID";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            MagBean bean = new MagBean();
            while (result.next()) {
                bean.setProductID(result.getInt("mag.productID"));
                bean.setVolNo(result.getInt("volNo"));
                bean.setIssueNo(result.getInt("issueNo"));
                bean.setProductID(result.getInt("product.productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
                bean.setCategory(result.getString("category"));
            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ProductBean getProductBytitle(String title) {
        try {
            dBConnectionFactory = DBConnectionFactory.getInstance();
            connection = dBConnectionFactory.getConnection();
            String query = "SELECT * FROM product WHERE title = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, title);

            ResultSet result = ps.executeQuery();
            ProductBean bean = new ProductBean();
            while (result.next()) {
                bean.setProductID(result.getInt("product.productID"));
                bean.setTitle(result.getString("title"));
                bean.setSummary(result.getString("summary"));
                bean.setPrice(result.getFloat("price"));
                bean.setStock(result.getFloat("stock"));
                bean.setPstatus(result.getString("pstatus"));
            }
            return bean;
        } catch (SQLException ex) {
            Logger.getLogger(ProductImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
