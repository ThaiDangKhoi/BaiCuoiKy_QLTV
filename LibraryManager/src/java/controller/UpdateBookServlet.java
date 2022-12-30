package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Book;
import model.bo.service.AdminService;
import tool.Convert;

@WebServlet(name = "UpdateBookServlet", urlPatterns = {"/UpdateBookServlet"})
public class UpdateBookServlet extends HttpServlet {

    String srcHome = "/admin/page/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String remove = request.getParameter("remove");

        if (remove != null) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            int result = AdminService.deleteBook(bookId);
        } else {

            String btnUpdate = (String) request.getParameter("btnUpdate");
            String btnRemove = (String) request.getParameter("btnRemove");
            int bookId = Integer.parseInt(request.getParameter("txtBookId"));
            int authorId = Integer.parseInt(request.getParameter("txtAuthorId"));
            int bookCategoryId = Integer.parseInt(request.getParameter("txtCategoryId"));
            String bookName = (String) request.getParameter("txtBookName");
            LocalDate nxb = Convert.convertDate((String) request.getParameter("txtNxb"));
            String description = (String) request.getParameter("txtDescription");
            String imageSrc = (String) request.getParameter("txtImageSrc");

            int result = AdminService.updateBook(new Book(bookId, authorId, bookCategoryId, bookName,
                    nxb, description, imageSrc));
        }

        getServletContext().getRequestDispatcher(srcHome)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
