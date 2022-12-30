package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserControlServlet", urlPatterns = {"/UserControlServlet"})
public class UserControlServlet extends HttpServlet {

    String srcLogin = "/page/login.jsp";
    String srcIndex = "/index.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isLogin = (boolean)request.getSession().getAttribute("isLogin");
        if(isLogin){
            getServletContext().getRequestDispatcher(srcIndex)
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
