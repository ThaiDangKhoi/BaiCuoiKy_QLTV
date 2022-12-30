package model.bo.service;

import model.bean.Book;
import model.dao.service.GetBook;

public class BookService {
    // get book by id
    public static Book getBookById(int bookId) {
        return (new GetBook()).getBookById(bookId);
    }
}
