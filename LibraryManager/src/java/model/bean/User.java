package model.bean;

import java.time.LocalDate;

public class User {
    private String email;
    private String fullName;
    private LocalDate birthday;
    private String address;
    private String phone;

    public User(String email, String fullName, LocalDate birthday, String address, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
