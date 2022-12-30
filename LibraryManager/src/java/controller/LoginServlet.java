package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Setting;
import model.bo.service.LoginService;
import model.bo.service.UserService;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    String srcHome = "/page/home.jsp";
    String srcLogin = "/page/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String txtEmail = request.getParameter("txtEmail");
        String txtPassword = request.getParameter("txtPassword");
        boolean isLogin = LoginService.login(txtEmail, txtPassword);
        if (!isLogin) {
            getServletContext().getRequestDispatcher(srcLogin)
                    .forward(request, response);
        } else {
            request.getSession().setAttribute(Setting.SESSION_ISLOGIN, isLogin);
            request.getSession().setAttribute(Setting.SESSION_USER, UserService.getUserName(txtEmail));
            request.getSession().setAttribute(Setting.SESSION_EMAIL, txtEmail);
            getServletContext().getRequestDispatcher(srcHome)
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
