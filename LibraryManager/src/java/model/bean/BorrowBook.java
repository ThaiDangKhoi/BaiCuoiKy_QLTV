package model.bean;

import java.time.LocalDate;

public class BorrowBook {
    private String email;
    private int bookId;
    private LocalDate borrowDay;
    private String fullName;
    private String bookName;

    public BorrowBook(String email, int bookId, LocalDate borrowDay) {
        this.email = email;
        this.bookId = bookId;
        this.borrowDay = borrowDay;
    }

    public BorrowBook(String email, int bookId, LocalDate borrowDay, String fullName, String bookName) {
        this.email = email;
        this.bookId = bookId;
        this.borrowDay = borrowDay;
        this.fullName = fullName;
        this.bookName = bookName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public BorrowBook() {
        this.email = "";
        this.bookId = -1;
        this.borrowDay = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(LocalDate borrowDay) {
        this.borrowDay = borrowDay;
    }
    
    
}
