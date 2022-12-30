<%@page import="model.bo.service.AdminService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Statistical</h1>\
<table border="1" style="width: 100%;">
    <%
        int userQuantity = AdminService.getUserQuantity();
        int borrowedBookQuantity = AdminService.getBorrowedBookQuantity();
        int borrowedUserQuantity = AdminService.getBorrowedUserQuantity();
    %>
    <tr>
        <td>User quantity</td>
        <td><%=userQuantity%></td>
    </tr>
    <tr>
        <td>Book borrowed quantity</td>
        <td><%=borrowedBookQuantity%></td>
    </tr>
    <tr>
        <td>User borrowed quantity</td>
        <td><%=borrowedUserQuantity%></td>
    </tr>
</table>