package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Account;
import model.bean.User;
import model.bo.service.UserService;
import tool.CheckString;
import tool.Convert;
import model.bean.Setting;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    String srcRegister = "/page/register.jsp";
    String srcHome = "/page/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isLogin = (boolean) request.getSession().getAttribute("isLogin");
        int id = 1;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            id = 0;
        }
        if (!isLogin) {
            if (id == 1) {
                getServletContext().getRequestDispatcher(srcRegister)
                        .forward(request, response);
            } else {
                boolean enable = true;
                String txtEmail = (String) request.getParameter("txtEmail");
                String txtFullName = (String) request.getParameter("txtFullName");
                String txtAddress = (String) request.getParameter("txtAddress");
                String txtBirthday = (String) request.getParameter("txtBirthday");
                String txtPhone = (String) request.getParameter("txtPhone");
                String txtPassword = (String) request.getParameter("txtPassword");
                String txtPass = (String) request.getParameter("txtPass");

                if (!txtPassword.equals(txtPass)) {
                    enable = false;
                }

                if (enable) {
                    if (!CheckString.checkPhoneLength(txtPhone)
                            || !CheckString.checkAllNumber(txtPhone)) {
                        enable = false;
                    }
                }

                if (enable) {
                    enable = !UserService.checkExist(txtEmail);
                }

                if (enable) {
                    int result = UserService.Register(new Account(txtEmail, txtPass),
                            new User(txtEmail, txtFullName, Convert.convertDate(txtBirthday), txtAddress, txtPhone));
                    if (result != 0) {
                        request.getSession().setAttribute(Setting.SESSION_ISLOGIN, true);
                        request.getSession().setAttribute(Setting.SESSION_USER, txtFullName);
                        request.getSession().setAttribute(Setting.SESSION_EMAIL, txtEmail);
                        getServletContext().getRequestDispatcher(srcHome)
                                .forward(request, response);
                    }
                }
                
                getServletContext().getRequestDispatcher(srcRegister)
                        .forward(request, response);

            }
        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
