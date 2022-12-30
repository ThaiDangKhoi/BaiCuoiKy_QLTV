package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Product;
import model.dao.DB;
import tool.Convert;

public class GetProduct {

    public ArrayList<Product> getProductList() {
        ArrayList<Product> result = new ArrayList<Product>();
        try {
            DB db = new DB();
            String columns = "bookId, bookName, authorName, bookCategoryName, nxb, description, imageSrc, "
                    + "authorAddress, birthday";
            String sql = "select " + columns
                    + " from tb_book inner join tb_author on tb_book.authorId = tb_author.authorId "
                    + "inner join tb_bookCategory on tb_bookCategory.bookCategoryId = tb_book.bookCategoryId";
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                result.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        Convert.convertDate(rs.getString(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        Convert.convertDate(rs.getString(9))
                ));
            }
        } catch (SQLException se) {
            System.err.println("ERROR GET PRODUCT LIST");
        }
        return result;
    }

    public ArrayList<Product> getProductList(String email) {
         ArrayList<Product> result = new ArrayList<Product>();
        try {
            DB db = new DB();
            String columns = "tb_book.bookId, bookName, authorName, bookCategoryName, nxb, description, imageSrc, "
                    + "authorAddress, birthday, borrowDay";
            String sql = "select " + columns
                    + " from tb_book inner join tb_author on tb_book.authorId = tb_author.authorId "
                    + "inner join tb_bookCategory on tb_bookCategory.bookCategoryId = tb_book.bookCategoryId "
                    + "inner join tb_borrow_book on tb_borrow_book.bookId = tb_book.bookId "
                    + "where email = " + Convert.ConvertPattern(email) + ";";

            ResultSet rs = db.query(sql);
            while (rs.next()) {
                result.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        Convert.convertDate(rs.getString(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        Convert.convertDate(rs.getString(9)),
                        Convert.convertDate(rs.getString(10))
                ));
            }
        } catch (SQLException se) {
            System.err.println("ERROR GET PRODUCT LIST");
        }
        return result;
    }
    
    public ArrayList<Product> getProductListByName(String bookName) { 
        ArrayList<Product> result = new ArrayList<Product>();
        try {
            DB db = new DB();
            String columns = "bookId, bookName, authorName, bookCategoryName, nxb, description, imageSrc, "
                    + "authorAddress, birthday";
            String sql = "select " + columns
                    + " from tb_book inner join tb_author on tb_book.authorId = tb_author.authorId "
                    + "inner join tb_bookCategory on tb_bookCategory.bookCategoryId = tb_book.bookCategoryId "
                    + "where bookName like " + Convert.ConvertPattern(bookName, true) + ";";
            
            System.out.println(sql);
            
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                result.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        Convert.convertDate(rs.getString(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        Convert.convertDate(rs.getString(9))
                ));
            }
        } catch (SQLException se) {
            System.err.println("ERROR GET PRODUCT LIST");
        }
        return result;
    }
    
    public static void main(String[] args){
        GetProduct gp = new GetProduct();
        ArrayList<Product> ps = gp.getProductListByName("nha");
        for(Product p : ps){
            System.out.println(p.getBookName());
        }
    }
}
