package model.bo.service;

import java.util.ArrayList;
import model.bean.Account;
import model.bean.BorrowBook;
import model.bean.Product;
import model.bean.User;
import model.dao.service.Borrow;
import model.dao.service.GetProduct;
import model.dao.service.GetUser;
import model.dao.service.RegisterUser;
import model.dao.service.UserUpdate;
import tool.Convert;

public class UserService {
    
    public static String getUserName(String email){
        for(User user : (new GetUser()).getUserList()){
            if(user.getEmail().equals(email)){
                return user.getFullName();
            }
        }
        return null;
    }
    
    public static boolean checkExist(String email){
        for(User user : (new GetUser()).getUserList()){
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    
    public static int Register(Account ac, User user){
        return (new RegisterUser()).register(ac, user);
    }
    
    public static int changePw(Account ac){
        return (new UserUpdate()).changePw(ac);
    }
    
    public static User getUser(String email){
        for(User user : (new GetUser()).getUserList()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
    
    public static int updateUser(User user){
        return (new UserUpdate()).updateUser(user);
    }
    
    public static ArrayList<Product> getProduct(){
        return (new GetProduct()).getProductList();
    }
    
    // borrowed
    public static ArrayList<Product> getProduct(String email){
        return (new GetProduct()).getProductList(email);
    }
    
    // borrow the book
    public int bookBorrow(BorrowBook bb){
        return (new Borrow()).bookBorrow(bb);
    }
    
    // borrow request the book
    public int bookBorrowRequest(BorrowBook bb){
        return (new Borrow()).bookBorrowRequest(bb);
    }
    
    // search
    public static ArrayList<Product> getProductListByName(String bookName) {
        return (new GetProduct()).getProductListByName(bookName);
    }
    
    public static void main(String[] args){
        System.out.println((new UserService()).bookBorrow(
                new BorrowBook("abc@gmail.com", 1, Convert.convertDate("2022-12-12"))));
    }
}
