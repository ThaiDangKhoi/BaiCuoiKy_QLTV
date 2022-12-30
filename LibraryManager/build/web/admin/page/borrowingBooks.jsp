<%@page import="model.bo.service.BookService"%>
<%@page import="model.bean.Book"%>
<%@page import="model.bo.service.AdminService"%>
<%@page import="model.bean.EntitySatistic"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Borrowing books</h1>
<table border="1" style="width: 100%;">
    <thead class="text-center" style="font-weight: bold;">
        <tr>
            <td>Book id</td>
            <td>Book name</td>
            <td>Quantity borrowed</td>
        </tr>
    </thead>
    <tbody>
        <%
            ArrayList<EntitySatistic> EntitySatistic = 
                    (ArrayList<EntitySatistic>) AdminService.getBorrowingBookStatistic();
            int counterEntity = 0;
            for (EntitySatistic eb : EntitySatistic) {
                counterEntity++;
                Book b = BookService.getBookById((int)eb.getEntity());
        %>
        <tr>
            <td><%=b.getBookId()%></td>
            <td><%=b.getBookName()%></td>
            <td><%=eb.getQuantity()%></td>
        </tr>
        <%            }
        %>
    </tbody>
</table>