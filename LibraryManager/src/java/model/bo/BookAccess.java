package model.bo;

import java.util.ArrayList;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;

import model.bean.Book;

import model.dao.DB;
import tool.Convert;

public class BookAccess {
    
    public ArrayList<Book> getBookList(){
        ArrayList<Book> result = new ArrayList<Book>();
        DB db = new DB();
        try{
            String columns = "bookId, authorId, bookCategoryId, bookName, nxb,"
                    + "description, imageSrc";
            String sql = "select " + columns + " from tb_book";
            ResultSet rs = db.query(sql);
            while(rs.next()){
                result.add(new Book(rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                Convert.convertDate(rs.getString(5)),
                rs.getString(6),
                rs.getString(7)));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args){
        String content = "";
        
        ArrayList<Book> books = (new BookAccess()).getBookList();
        
        for(Book b : books){
            System.out.println(b.getNxb().getDayOfMonth());
        }
        
        System.out.println(content);
    }
}
