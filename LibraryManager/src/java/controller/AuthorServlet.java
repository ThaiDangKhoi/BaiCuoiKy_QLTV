package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Author;
import model.bo.AuthorAccess;


@WebServlet(name = "AuthorServlet", urlPatterns = {"/AuthorServlet"})
public class AuthorServlet extends HttpServlet {
    
    String srcAuthor = "/page/author.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Author> authorList = (new AuthorAccess()).getAuhtorList();
        request.setAttribute("authorList", authorList);
        getServletContext().getRequestDispatcher(srcAuthor)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
