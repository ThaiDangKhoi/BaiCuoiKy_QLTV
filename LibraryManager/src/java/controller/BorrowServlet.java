package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.BorrowBook;
import model.bean.Setting;
import model.bo.service.UserService;

@WebServlet(name = "BorrowServlet", urlPatterns = {"/BorrowServlet"})
public class BorrowServlet extends HttpServlet {
    
    String srcLogin = "/page/login.jsp";
    String srcHome = "/page/home.jsp";
    String srcAlert = "/page/alert.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isLogin = (boolean) request.getSession().getAttribute(Setting.SESSION_ISLOGIN);
        if (isLogin) {
            int bookId = Integer.parseInt((String) request.getParameter("bookId"));
            String email = (String) request.getSession().getAttribute(Setting.SESSION_EMAIL);
            LocalDate borrowDate = LocalDate.now();

            int result = (new UserService()).bookBorrowRequest(new BorrowBook(email, bookId, borrowDate));
            if(result == 1){
                request.setAttribute("notific", "Borrow book");
                request.setAttribute("alertContent", "Request to borrow a book has been sent");
            } else {
                request.setAttribute("notific", "Borrow book");
                request.setAttribute("alertContent", "Can not borrow book");
            }
            getServletContext().getRequestDispatcher(srcAlert)
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(srcLogin)
                    .forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
