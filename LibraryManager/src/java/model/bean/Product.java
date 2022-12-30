package model.bean;

import java.time.LocalDate;

public class Product {
    private int bookId;
    private String bookName;
    private String authorName;
    private String bookCategoryName;
    private LocalDate nxb;
    private String description;
    private String imageSrc;
    private String authorAddress;
    private LocalDate birthday; 
    private LocalDate borrowDay;
    
    public Product(int bookId, String bookName, String authorName, 
            String bookCategoryName, LocalDate nxb, String description, 
            String imageSrc, String authorAddress, LocalDate birthday, LocalDate borrowDay) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookCategoryName = bookCategoryName;
        this.nxb = nxb;
        this.description = description;
        this.imageSrc = imageSrc;
        this.authorAddress = authorAddress;
        this.birthday = birthday;
        this.borrowDay = borrowDay;
    }

    public LocalDate getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(LocalDate borrowDay) {
        this.borrowDay = borrowDay;
    }

    public Product(int bookId, String bookName, String authorName, String bookCategoryName, LocalDate nxb, String description, String imageSrc, String authorAddress, LocalDate birthday) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookCategoryName = bookCategoryName;
        this.nxb = nxb;
        this.description = description;
        this.imageSrc = imageSrc;
        this.authorAddress = authorAddress;
        this.birthday = birthday;
    }
    

    public Product(int bookId, String bookName, String authorName, String bookCategoryName, LocalDate nxb, String description, String imageSrc) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookCategoryName = bookCategoryName;
        this.nxb = nxb;
        this.description = description;
        this.imageSrc = imageSrc;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookCategoryName() {
        return bookCategoryName;
    }

    public void setBookCategoryName(String bookCategoryName) {
        this.bookCategoryName = bookCategoryName;
    }

    public LocalDate getNxb() {
        return nxb;
    }

    public void setNxb(LocalDate nxb) {
        this.nxb = nxb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
    
    
}
