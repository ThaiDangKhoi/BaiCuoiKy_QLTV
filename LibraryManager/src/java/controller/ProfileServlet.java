package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Setting;
import model.bean.User;
import model.bo.service.UserService;
import tool.Convert;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

    String srcProfile = "/page/profile.jsp";
    String srcHome = "/page/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
        }

        if (id == 0) { // update profile
            String txtFullName = (String) request.getParameter("txtFullName");
            String txtAddress = (String) request.getParameter("txtAddress");
            String txtBirthday = (String) request.getParameter("txtBirthday");
            String txtPhone = (String) request.getParameter("txtPhone");

            int result = UserService.updateUser(new User(
                    (String) request.getSession().getAttribute(Setting.SESSION_EMAIL),
                    txtFullName,
                    Convert.convertDate(txtBirthday),
                    txtAddress,
                    txtPhone
            ));

            if (result == 1) {
                request.getSession().setAttribute(Setting.SESSION_USER, txtFullName);
                getServletContext().getRequestDispatcher(srcHome)
                .forward(request, response);
            }
        }
        
        User user = UserService.getUser((String) request.getSession().getAttribute(Setting.SESSION_EMAIL));

        request.setAttribute("user", user);

        getServletContext().getRequestDispatcher(srcProfile)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
