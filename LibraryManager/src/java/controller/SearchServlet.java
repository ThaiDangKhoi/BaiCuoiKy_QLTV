package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Product;
import model.bean.Setting;
import model.bo.service.UserService;

@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    String srcHome = "/page/home.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String txtSearch = (String)request.getParameter("txtSearch");
        
        request.getSession().setAttribute(Setting.SESSION_SEARCH, "search");
        
        ArrayList<Product> products = UserService.getProductListByName(txtSearch);
        
        request.setAttribute("products", products);
        
        getServletContext().getRequestDispatcher(srcHome)
                                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
