<%@page import="model.bean.Setting"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.setAttribute(Setting.SESSION_ISLOGIN, false);
    session.setAttribute(Setting.SESSION_USER, "");
    session.setAttribute(Setting.SESSION_ID, 0);
    getServletContext().getRequestDispatcher("/page/home.jsp")
            .forward(request, response);
%>