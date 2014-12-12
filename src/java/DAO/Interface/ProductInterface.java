/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Interface;

import Bean.BookBean;
import Bean.CDBean;
import Bean.DvdBean;
import Bean.MagBean;
import Bean.ProductBean;
import java.util.ArrayList;

/**
 *
 * @author kimberly
 */
public interface ProductInterface {
    public void addProduct(ProductBean bean); 
    public void addBook(BookBean bean);
    public void addCD(CDBean bean);
    public void addDvd(DvdBean bean);
    public void addMagazine(MagBean bean);
    public ArrayList<ProductBean> getAllProducts();
    public ArrayList<BookBean> getAllBooks();
    public ArrayList<CDBean> getAllCDs();
    public ArrayList<DvdBean> getAllDvds();
    public ArrayList<MagBean> getAllMags();
    public ProductBean getProductById(int productID);
    public ArrayList<ProductBean> getProductByName(String title);
    public void editProductByTitle(int id, String title);
    public void editProductBySummary(int id, String title);
    public void editProductByPrice(int id, float price);
    public void editProductByStock(int id, float stock);
    public void editProductByStatus(int id, int pstatus);
    public void editBookByAuthor(int id, String author);
    public void editCDByArtist(int id, String artist);
    public void editDVDByDirector(int id, String director);
    public void editMagByVolNo(int id, int volNo);
    public void editMagByIssueNo(int id, int issueNo);
    public void deleteBook(int productID);
    public void deleteCD(int productID);
    public void deleteDVD(int productID);
    public void deleteMag(int productID);
    public ProductBean getProductByTitle(String title);
    public BookBean getBookById(int id);
    public CDBean getCDById(int id);
    public DvdBean getDVDById(int id);
    public MagBean getMagById(int id);
}
