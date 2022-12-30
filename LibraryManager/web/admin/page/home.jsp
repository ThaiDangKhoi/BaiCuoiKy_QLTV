<%@page import="model.bean.Setting" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin home</title>
        <link rel="stylesheet" href="admin/style/home.css">
    </head>

    <body>
        <div class="container">
            <div class="header">
                <ul>
                    <a href="ControlAdServlet?id=1"><li>Book</li></a>
                    <a href="ControlAdServlet?id=2"><li>Author</li></a>
                    <a href="ControlAdServlet?id=3"><li>Category</li></a>
                    <a href="ControlAdServlet?id=0"><li>Borrow request</li></a>
                    <a href="ControlAdServlet?id=4"><li>Borrowing books</li></a>
                    <a href="ControlAdServlet?id=5"><li>Statistical</li></a>
                </ul>
            </div>

            <div class="content">
                <%
                    int id = (int)session.getAttribute(Setting.SESSION_ID_ADMIN);
                    if(id == 1 ||
                            id == 2 ||
                            id == 3){
                %>
                <i id="btnEdit" onclick="editON()"></i>
                <%
                    } 
                %>

                <%
                    switch ((int) session.getAttribute(Setting.SESSION_ID_ADMIN)) {
                        case 0:
                %>
                <%@include file="borrowRequest.jsp" %>
                <% break;
                    case 1: %>
                <%@include file="book.jsp" %>
                <% break;
                    case 2:
                %>
                <%@include file="author.jsp" %>
                <% break;
                    case 3: %>
                <%@include file="category.jsp" %>
                <% break;
                    case 4: %>
                <%@include file="borrowingBooks.jsp" %>
                <% break;
                    case 5: %>
                <%@include file="statistical.jsp" %>
                <% break;
                    }%>
            </div>

        </div>
        <script src="admin/js/home.js"></script>
    </body>

</html>