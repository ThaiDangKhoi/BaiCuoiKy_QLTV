<%@page import="model.bo.service.AdminService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.BorrowBook" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<h1>Borrow request</h1>
<table style="width: 100%;" border="1">
    <thead class="text-center">
        <tr>
            <td>Number</td>
            <td>Email</td>
            <td>User name</td>
            <td>Book Id</td>
            <td>Book name</td>
            <td>Borrowd date</td>
            <td>Cofirm</td>
        </tr>
    </thead>
    <tbody>
        <% ArrayList<BorrowBook> bbList = AdminService.getBorrowBookList(true);
            int counter = 0;
            for (BorrowBook bb : bbList) {
                counter++;
        %>
        <tr>
            <td class="text-center">
                <%=counter%>
            </td>
            <td>
                <%=bb.getEmail()%>
            </td>
            <td>
                <%=bb.getFullName()%>
            </td>
            <td class="text-center">
                <%=bb.getBookId()%>
            </td>
            <td>
                <%=bb.getBookName()%>
            </td>
            <td class="text-center">
                <%=bb.getBorrowDay()%>
            </td>
            <td class="text-center">
                <a href="CofirmBorrowRequestAdServlet?email=<%=bb.getEmail()%>&bookId=<%=bb.getBookId()%>">
                    <button>Cofirm</button></a></td>
        </tr>
        <%}%>
    </tbody>
</table>