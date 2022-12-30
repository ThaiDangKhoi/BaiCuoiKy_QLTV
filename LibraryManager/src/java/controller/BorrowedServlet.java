package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Setting;
import model.bo.service.UserService;

@WebServlet(name = "BorrowedServlet", urlPatterns = {"/BorrowedServlet"})
public class BorrowedServlet extends HttpServlet {

    String srcBorrowed = "/page/borrowed.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("borroweds", UserService.getProduct(
                (String)request.getSession().getAttribute(Setting.SESSION_EMAIL)));
        getServletContext().getRequestDispatcher(srcBorrowed)
                .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
}
