package model.dao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Account;
import model.dao.DB;

public class Login {
    
    public boolean login(String email, String password){
        boolean result = false;
        try{
            DB db = new DB();
            String columns = "email, password";
            String sql = "select " + columns + " from tb_userAccount;";
            ResultSet rs = db.query(sql);
            Account user = new Account(email, password);
            while(rs.next()){
                Account ac = new Account(rs.getString(1), rs.getString(2));
                if(ac.equals(user)){
                    result = true;
                    break;
                }
            }
        } catch (SQLException se){
            se.printStackTrace();
        }
        return result;
    }
    
    public boolean loginAdmin(String email, String password){
        boolean result = false;
        try{
            DB db = new DB();
            String columns = "email, password";
            String sql = "select " + columns + " from tb_adminAccount;";
            ResultSet rs = db.query(sql);
            Account admin = new Account(email, password);
            while(rs.next()){
                Account ac = new Account(rs.getString(1), rs.getString(2));
                if(ac.equals(admin)){
                    result = true;
                    break;
                }
            }
        } catch (SQLException se){
            se.printStackTrace();
        }
        return result;
    }
}
