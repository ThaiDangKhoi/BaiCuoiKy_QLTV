<%@page import="model.bean.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Book> bookList = (ArrayList<Book>)request.getAttribute("bookList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
    </head>
    <body>
        <h1>Book</h1>
        <table>
            <% for(Book b : bookList){ %>
            <tr>
                <td><%=b.getBookId()%></td>
                <td><%=b.getAuthorId()%></td>
                <td><%=b.getBookCategoryId()%></td>
                <td><%=b.getBookName()%></td>
                <td><%=b.getNxb()%></td>
                <td><%=b.getImageSrc()%></td>
                <td><%=b.getDescription()%></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
