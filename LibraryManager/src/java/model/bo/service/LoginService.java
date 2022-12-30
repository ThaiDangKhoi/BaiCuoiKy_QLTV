package model.bo.service;

import model.dao.service.Login;

public class LoginService {
    
    public static boolean login(String email, String password){
        Login lg = new Login();
        return lg.login(email, password);
    }
    
    public static boolean loginAdmin(String email, String password){
        Login lg = new Login();
        return lg.loginAdmin(email, password);
    }

}
