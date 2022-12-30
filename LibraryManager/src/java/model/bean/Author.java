package model.bean;

import java.time.LocalDate;

public class Author {
    private int authorId;
    private String authorName;
    private String authorAddress;
    private LocalDate birthday;

    public Author(int authorId, String authorName, String authorAddress, LocalDate birthday) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorAddress = authorAddress;
        this.birthday = birthday;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
    
    
}
