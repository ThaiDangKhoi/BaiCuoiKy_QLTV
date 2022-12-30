package model.bean;

import java.time.LocalDate;

public class Book {
    private int bookId;
    private int authorId;
    private int bookCategoryId;
    private String bookName;
    private LocalDate nxb;
    private String description;
    private String imageSrc;

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", authorId=" + authorId + ", bookCategoryId=" + bookCategoryId + ", bookName=" + bookName + ", nxb=" + nxb + ", description=" + description + ", imageSrc=" + imageSrc + '}';
    }

    public Book(int bookId, int authorId, int bookCategoryId, String bookName, LocalDate nxb, 
            String description, String imageSrc) {
        this.bookId = bookId;
        this.authorId = authorId;
        this.bookCategoryId = bookCategoryId;
        this.bookName = bookName;
        this.nxb = nxb;
        this.description = description;
        this.imageSrc = imageSrc;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(int bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
