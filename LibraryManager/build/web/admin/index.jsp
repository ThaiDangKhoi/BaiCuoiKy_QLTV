<%@page import="model.bean.Setting"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.setAttribute(Setting.SESSION_ISLOGIN_ADMIN, false);
    session.setAttribute(Setting.SESSION_EMAIL_ADMIN, "");
    session.setAttribute(Setting.SESSION_ID_ADMIN, 0);
    getServletContext().getRequestDispatcher("/admin/page/login.jsp")
            .forward(request, response);
%>