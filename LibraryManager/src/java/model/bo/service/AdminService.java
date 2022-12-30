package model.bo.service;

import java.util.ArrayList;
import model.bean.Author;
import model.bean.Book;
import model.bean.BorrowBook;
import model.bean.Category;
import model.bean.EntitySatistic;
import model.dao.service.Borrow;
import model.dao.service.EntityUpdate;
import model.dao.service.GetAuthor;
import model.dao.service.GetBook;
import model.dao.service.GetBorrowBook;
import model.dao.service.GetCategory;
import model.dao.service.Satistic;
import tool.Convert;

public class AdminService {
    public static ArrayList<BorrowBook> getBorrowBookList(){
        return (new GetBorrowBook()).getBorrowBookList();
    }
    
    public static ArrayList<BorrowBook> getBorrowBookList(boolean state){
        return (new GetBorrowBook()).getBorrowBookList(state);
    }
    
    // borrow the book
    public static int bookBorrow(BorrowBook bb){
        return (new Borrow()).bookBorrow(bb);
    }
    
    // update db
    public static int bookBorrowRequestUpdate(BorrowBook bb){
        return (new Borrow()).bookBorrowRequestUpdate(bb);
    }
    
    
    // get book list
    public static ArrayList<Book> getBookList(){
        return (new GetBook()).getBookList();
    }
    
    // get author list
    public static ArrayList<Author> getAuthorList(){
        return (new GetAuthor()).getAuthorList();
    }
    
    // get author list
    public static ArrayList<Category> getCategoryList(){
        return (new GetCategory()).getCategoryList();
    }
    
    // get statistic
    public static ArrayList<EntitySatistic> getBorrowingBookStatistic(){
        return (new Satistic()).getBorrowingBookStatistic();
    }
    
    // get quantity user
    public static int getUserQuantity(){
        return (new Satistic()).getUserStatistic().getQuantity();
    }
    
    // get quantity user
    public static int getBorrowedBookQuantity(){
        return (new Satistic()).getBorrowedBookQuantity();
    }
    
    // get quantity user
    public static int getBorrowedUserQuantity(){
        return (new Satistic()).getBorrowedUserQuantity();
    }
    
    // update book
    public static int updateBook(Book book){
        return (new EntityUpdate()).updateBook(book);
    }
    
    // delete book
    public static int deleteBook(int bookId){
        return (new EntityUpdate()).deleteBook(bookId);
    }
    
    // add book
    public static int addBook(Book book){
        return (new EntityUpdate()).addBook(book);
    }
    
    // delete author
    public static int deleteAuthor(int authorId){
        return (new EntityUpdate()).deleteAuthor(authorId);
    }
    
    // update author
    public static int updateAuthor(Author author){
        return (new EntityUpdate()).updateAuthor(author);
    }
    
    // add author
    public static int addAuthor(Author author){
        return (new EntityUpdate()).addAuthor(author);
    }
    
    public static void main(String[] args){
        System.out.println(getBookList().size());
    }
}
