package model.dao.service;

import java.sql.SQLException;
import model.bean.Account;
import model.bean.User;
import model.dao.DB;
import tool.Convert;

public class RegisterUser {

    public int register(Account account, User user) {
        int result = 0;

        DB db = new DB();
        String columns = "email, password";
        String sql = "insert into tb_userAccount(" + columns + ") value ("
                + Convert.ConvertPattern(account.getUser()) + ","
                + Convert.ConvertPattern(account.getPass())
                + ");";
        result = db.update(sql);
        
        if(result != 0){
            columns = "email, fullName, birthday, address, phone";
            sql = "insert into tb_userInfo("
                    + columns +") value ("
                    + Convert.ConvertPattern(user.getEmail()) + ","
                    + Convert.ConvertPattern(user.getFullName()) + ","
                    + Convert.ConvertPattern(user.getBirthday().toString()) + ","
                    + Convert.ConvertPattern(user.getAddress()) + ","
                    + Convert.ConvertPattern(user.getPhone())
                    +");";
            result = db.update(sql);
        }

        return result;
    }
}
