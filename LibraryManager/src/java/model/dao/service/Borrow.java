package model.dao.service;

import java.sql.SQLException;
import model.bean.BorrowBook;
import model.dao.DB;
import tool.Convert;

public class Borrow {

    public int bookBorrow(BorrowBook bb) {
        int result = 0;
        DB db = new DB();
        String columns = "email, bookId, borrowDay";
        String sql = "insert into tb_borrow_book(" + columns + ") value ("
                + Convert.ConvertPattern(bb.getEmail()) + ", "
                + bb.getBookId() + ", "
                + Convert.ConvertPattern(bb.getBorrowDay().toString())
                + ");";
        result = db.update(sql);
        return result;
    }
    
    public int bookBorrowRequest(BorrowBook bb) {
        int result = 0;
        DB db = new DB();
        String columns = "email, bookId, borrowDay";
        String sql = "insert into tb_borrow_request(" + columns + ") value ("
                + Convert.ConvertPattern(bb.getEmail()) + ", "
                + bb.getBookId() + ", "
                + Convert.ConvertPattern(bb.getBorrowDay().toString())
                + ");";
        result = db.update(sql);
        return result;
    }
    
    // update request state
    public int bookBorrowRequestUpdate(BorrowBook bb) {
        int result = 0;
        DB db = new DB();
        String sql = "update tb_borrow_request set state = 1 where email = "
                + Convert.ConvertPattern(bb.getEmail()) + " and bookId = "
                + bb.getBookId() + ";";
        System.out.println(sql);
        result = db.update(sql);
        
        if(result == 1){
            result = bookBorrow(bb);
        }
        return result;
    }
    
    public static void main(String[] args){
        System.out.println((new Borrow()).bookBorrowRequestUpdate(
                new BorrowBook("abc@gmail.com", 4, Convert.convertDate("2022-12-26"))));
    }
}
