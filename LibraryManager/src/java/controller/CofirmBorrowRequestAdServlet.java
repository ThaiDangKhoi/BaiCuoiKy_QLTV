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
import model.bo.service.AdminService;

@WebServlet(name = "CofirmBorrowRequestAdServlet", urlPatterns = {"/CofirmBorrowRequestAdServlet"})
public class CofirmBorrowRequestAdServlet extends HttpServlet {

    String srcHome = "/admin/page/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = (String)request.getParameter("email");
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        LocalDate borrowDay = LocalDate.now();
        
        int result = AdminService.bookBorrowRequestUpdate(
                new BorrowBook(email, bookId, borrowDay));
        
        getServletContext().getRequestDispatcher(srcHome)
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
