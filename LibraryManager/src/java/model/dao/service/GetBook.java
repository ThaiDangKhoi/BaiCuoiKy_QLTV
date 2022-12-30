package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Book;
import model.dao.DB;
import tool.Convert;

public class GetBook {

    public ArrayList<Book> getBookList() {
        ArrayList<Book> result = new ArrayList<Book>();

        try {
            DB db = new DB();
            String columns = "bookId, authorId, bookCategoryId, bookName, nxb, description, imageSrc";
            String sql = "select " + columns + " from tb_book;";
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                result.add(new Book(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        Convert.convertDate(rs.getString(5)),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (SQLException e) {
            System.err.println("ERROR GET BOOK LIST");
        }

        return result;
    }

    // get book by id
    public Book getBookById(int bookId) {
        try {
            DB db = new DB();
            String columns = "bookId, authorId, bookCategoryId, bookName, nxb, description, imageSrc";
            String sql = "select " + columns + " from tb_book "
                    + "where bookId = " + bookId
                    + ";";
            ResultSet rs = db.query(sql);
            rs.next();
            return new Book(rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    Convert.convertDate(rs.getString(5)),
                    rs.getString(6),
                    rs.getString(7)
            );
        } catch (SQLException e) {
            System.err.println("ERROR GET BOOK BY ID");
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println((new GetBook()).getBookById(1).toString());
    }
}
