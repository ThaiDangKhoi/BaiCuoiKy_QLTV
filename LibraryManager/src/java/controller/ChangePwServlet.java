package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Account;
import model.bean.Setting;
import model.bo.service.LoginService;
import model.bo.service.UserService;

@WebServlet(name = "ChangePwServlet", urlPatterns = {"/ChangePwServlet"})
public class ChangePwServlet extends HttpServlet {

    String srcChangePw = "/page/changepw.jsp";
    String srcHome = "/page/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {

        }

        if (id == 1) {
            getServletContext().getRequestDispatcher(srcChangePw)
                    .forward(request, response);
        } else if (id == 0) {
            String txtOlPass = request.getParameter("txtOldPass");
            String txtNewPass = request.getParameter("txtNewPass");
            boolean enable = true;
            if (txtNewPass.equals(txtOlPass)) {
                enable = false;
            }

            if (enable) {
                enable = LoginService.login((String) request.getSession().getAttribute(Setting.SESSION_EMAIL),
                        txtOlPass);
            }
            if (enable) {
                int result = UserService.changePw(new Account(
                        (String)request.getSession().getAttribute(Setting.SESSION_EMAIL),
                        txtNewPass
                ));
                if (result == 1) {
                    getServletContext().getRequestDispatcher(srcHome)
                            .forward(request, response);
                }
            }
            getServletContext().getRequestDispatcher(srcChangePw)
                    .forward(request, response);
        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
