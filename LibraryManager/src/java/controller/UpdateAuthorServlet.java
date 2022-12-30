package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Author;
import model.bo.service.AdminService;
import tool.Convert;

@WebServlet(name = "UpdateAuthorServlet", urlPatterns = {"/UpdateAuthorServlet"})
public class UpdateAuthorServlet extends HttpServlet {

    String srcHome = "/admin/page/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String remove = request.getParameter("remove");

        if (remove != null) {
            int authorId = Integer.parseInt(request.getParameter("authorId"));
            int result = AdminService.deleteAuthor(authorId);
        } else {

            int authorId = Integer.parseInt(request.getParameter("txtAuthorId"));
            String authorName = (String) request.getParameter("txtAuthorName"); 
            String address = (String) request.getParameter("txtAuthorAddress");
            LocalDate birthday = Convert.convertDate(request.getParameter("txtBirthday"));

            int result = AdminService.updateAuthor(new Author(authorId, authorName, address, birthday));
        }

        getServletContext().getRequestDispatcher(srcHome)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
