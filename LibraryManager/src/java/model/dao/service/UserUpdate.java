package model.dao.service;

import model.bean.Account;
import model.bean.User;
import model.dao.DB;
import tool.Convert;

public class UserUpdate {
    public int changePw(Account ac){
        int result = 0;
        
        DB db = new DB();
        String sql = "update tb_userAccount set password = "
                + Convert.ConvertPattern(ac.getPass())
                + " where email = "
                + Convert.ConvertPattern(ac.getUser()) + ";";
        result = db.update(sql);
        
        return result;
    }
    
    public int updateUser(User user){
        int result = 0;
        
        DB db = new DB();
        String sql = "update tb_userInfo set fullName = "
                + Convert.ConvertPattern(user.getFullName()) + ", "
                + "address = " + Convert.ConvertPattern(user.getAddress()) + ", "
                + "phone = " + Convert.ConvertPattern(user.getPhone()) + ", "
                + "birthday = " + Convert.ConvertPattern(user.getBirthday().toString())
                + " where email = " + Convert.ConvertPattern(user.getEmail())
                + ";";
        result = db.update(sql);
        
        return result;
    }
    
    
}
