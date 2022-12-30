package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import model.bean.Author;
import model.bean.Book;
import model.dao.DB;
import tool.Convert;

public class EntityUpdate {

    public int updateBook(Book book) {
        int result = 0;

        String sql = "update tb_book set "
                + "authorId = " + book.getAuthorId() + ", "
                + "bookCategoryId = " + book.getBookCategoryId() + ", "
                + "bookName = " + Convert.ConvertPattern(book.getBookName()) + ", "
                + "nxb = " + Convert.ConvertPattern(book.getNxb().toString()) + ", "
                + "description = " + Convert.ConvertPattern(book.getDescription()) + ", "
                + "imageSrc = " + Convert.ConvertPattern(book.getImageSrc())
                + " where bookId = " + book.getBookId() + ";";

        System.out.println(sql);

        DB db = new DB();
        result = db.update(sql);

        return result;
    }

    public int deleteBook(int bookId) {
        int result = 0;

        DB db = new DB();

        String sql = "delete from tb_borrow_book where bookId = " + bookId + ";";
//                + "delete from tb_borrow_request where bookId = " + bookId +"; "
//                + "delete from tb_book where bookId = " + bookId +"; ";

        result = db.update(sql);

        sql = "delete from tb_borrow_request where bookId = " + bookId + ";";
        result = db.update(sql);
        sql = "delete from tb_book where bookId = " + bookId + ";";
        result = db.update(sql);

        return result;
    }

    public int addBook(Book book) {
        int result = 0;

        String columns = "bookId, authorId, bookCategoryId, bookName, nxb, description, imageSrc";

        String sql = "insert into tb_book (" + columns + ") value ("
                + book.getBookId() + ", "
                + book.getAuthorId() + ", "
                + book.getBookCategoryId() + ", "
                + Convert.ConvertPattern(book.getBookName()) + ", "
                + Convert.ConvertPattern(book.getNxb().toString()) + ", "
                + Convert.ConvertPattern(book.getDescription()) + ", "
                + Convert.ConvertPattern(book.getImageSrc())
                + ");";

        System.out.println(sql);

        DB db = new DB();
        result = db.update(sql);

        return result;
    }

    // delete author
    public int deleteAuthor(int authorId) {
        int result = 0;

        DB db = new DB();
        int bookId = -1;
        String sql = "select bookId from tb_book where authorId = " + authorId + ";";
        try {
            ResultSet rs = db.query(sql);
            rs.next();
            bookId = rs.getInt(1);
        } catch (SQLException e) {
        }
        sql = "delete from tb_borrow_book where bookId = " + bookId + ";";
        result = db.update(sql);
        sql = "delete from tb_borrow_request where bookId = " + bookId + ";";
        result = db.update(sql);
        sql = "delete from tb_book where bookId = " + bookId + ";";
        result = db.update(sql);

        sql = "delete from tb_book where authorId = " + authorId + ";";
        result = db.update(sql);

        sql = "delete from tb_author where authorId = " + authorId + ";";
        result = db.update(sql);

        return result;
    }

    // update author
    public int updateAuthor(Author author) {
        int result = 0;

        String sql = "update tb_author set "
                + "authorName = " + Convert.ConvertPattern(author.getAuthorName()) + ", "
                + "authorAddress = " + Convert.ConvertPattern(author.getAuthorAddress()) + ", "
                + "birthday = " + Convert.ConvertPattern(author.getBirthday().toString())
                + " where authorId = " + author.getAuthorId() + ";";

        System.out.println(sql);

        DB db = new DB();
        result = db.update(sql);

        return result;
    }

    // add author
    public int addAuthor(Author author) {
        int result = 0;

        String columns = "authorId, authorName, authorAddress, birthday";

        String sql = "insert into tb_author (" + columns + ") value ("
                + author.getAuthorId() + ", "
                + Convert.ConvertPattern(author.getAuthorName()) + ", "
                + Convert.ConvertPattern(author.getAuthorAddress()) + ", "
                + Convert.ConvertPattern(author.getBirthday().toString())
                + ");";

        DB db = new DB();
        
        result = db.update(sql);

        return result;
    }

    public static void main(String[] args) {

//        System.out.println((new EntityUpdate()).updateAuthor(new ));
    }
}
