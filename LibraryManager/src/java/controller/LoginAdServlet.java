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

@WebServlet(name = "LoginAdServlet", urlPatterns = {"/LoginAdServlet"})
public class LoginAdServlet extends HttpServlet {

    String srcLogin = "/admin/page/login.jsp";
    String srcHome = "/admin/page/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtEmail = request.getParameter("txtEmail");
        String txtPassword = request.getParameter("txtPassword");
        boolean isLogin = LoginService.loginAdmin(txtEmail, txtPassword);
        if (!isLogin) {
            getServletContext().getRequestDispatcher(srcLogin)
                    .forward(request, response);
        } else {
            request.getSession().setAttribute(Setting.SESSION_ISLOGIN_ADMIN, isLogin);
//            request.getSession().setAttribute(Setting.SESSION_USER, UserService.getUserName(txtEmail));
            request.getSession().setAttribute(Setting.SESSION_EMAIL_ADMIN, txtEmail);
            getServletContext().getRequestDispatcher(srcHome)
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
