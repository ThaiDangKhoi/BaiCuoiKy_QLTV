package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Setting;
import model.bean.Title;
import tool.GetRandom;
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        Cookie bookId = new Cookie(Setting.COOKIE_BOOK_ID, request.getParameter(Setting.COOKIE_BOOK_ID));
//        bookId.setMaxAge(24 * 60 * 60);
//        response.addCookie(bookId);

        request.getSession().setAttribute(Setting.SESSION_SEARCH, "");
        
        request.getSession().setAttribute(Setting.SESSION_TITLE,
                Title.titleList().get(GetRandom.getRandom(0, Title.titleList().size()-1)));
        getServletContext().getRequestDispatcher("/page/home.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
