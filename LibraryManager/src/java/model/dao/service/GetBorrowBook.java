package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.BorrowBook;
import model.dao.DB;
import tool.Convert;

public class GetBorrowBook {
    
    public ArrayList<BorrowBook> getBorrowBookList() {
         ArrayList<BorrowBook> result = new ArrayList<BorrowBook>();
        try {
            DB db = new DB();
            String columns = "tb_userInfo.email, tb_book.bookId, borrowDay, fullName, bookName";
            String sql = "select " + columns
                    + " from tb_borrow_request inner join tb_userInfo on tb_borrow_request.email = tb_userInfo.email "
                    + "inner join tb_book on tb_borrow_request.bookId = tb_book.bookId;";

            ResultSet rs = db.query(sql);
            while (rs.next()) {
                result.add(new BorrowBook(
                        rs.getString(1),
                        rs.getInt(2),
                        Convert.convertDate(rs.getString(3)),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
            
        } catch (SQLException se) {
            System.err.println("ERROR GET PRODUCT LIST");
        }
        return result;
    }
    
    public ArrayList<BorrowBook> getBorrowBookList(boolean state) {
         ArrayList<BorrowBook> result = new ArrayList<BorrowBook>();
        try {
            DB db = new DB();
            String columns = "tb_userInfo.email, tb_book.bookId, borrowDay, fullName, bookName";
            String sql = "select " + columns
                    + " from tb_borrow_request inner join tb_userInfo on tb_borrow_request.email = tb_userInfo.email "
                    + "inner join tb_book on tb_borrow_request.bookId = tb_book.bookId "
                    + "where state = 0;";

            ResultSet rs = db.query(sql);
            while (rs.next()) {
                result.add(new BorrowBook(
                        rs.getString(1),
                        rs.getInt(2),
                        Convert.convertDate(rs.getString(3)),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
            
        } catch (SQLException se) {
            System.err.println("ERROR GET PRODUCT LIST");
        }
        return result;
    }
    
    public static void main(String[] args){
        GetBorrowBook gbb = new GetBorrowBook();
        ArrayList<BorrowBook> ps = gbb.getBorrowBookList();
        System.out.println(ps.size());
    }
}
