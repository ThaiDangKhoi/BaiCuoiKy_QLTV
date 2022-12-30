package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.bean.Account;
import model.bean.User;
import model.dao.DB;
import tool.Convert;

public class GetUser {
    public ArrayList<User> getUserList(){
       ArrayList<User> result = new ArrayList<User>();
       try{
           DB db = new DB();
           String columns = "email, fullName, birthday, address, phone";
           String sql = "select " + columns + " from tb_userInfo;";
           ResultSet rs = db.query(sql);
           while(rs.next()){
               result.add(new User(rs.getString(1), 
                       rs.getString(2), 
                       Convert.convertDate(rs.getString(3)), 
                       rs.getString(4), 
                       rs.getString(5)));
           }
       } catch (SQLException se){
           System.err.println("ERROR GET USER");
       }
       return result;
    }
    
}
