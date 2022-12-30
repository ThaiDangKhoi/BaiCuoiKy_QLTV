<%@page import="model.bo.service.AdminService"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Category</h1>
<table border="1" style="width: 100%;">
    <thead class="text-center" style="font-weight: bold;">
        <tr>
            <td>Number</td>
            <td>Category id</td>
            <td>Category name</td>

        </tr>
    </thead>
    <tbody>
        <%
            ArrayList<Category> categoryList = (ArrayList<Category>) AdminService.getCategoryList();
            int counterCategory = 0;
            for (Category c : categoryList) {
                counterCategory++;

        %>
        <tr>
            <td class="text-center"><%=counterCategory%></td>
            <td class="text-center"><%=c.getBookCategoryId()%></td>
            <td><%=c.getBookCategoryName()%></td>

        </tr>
        <%            }
        %>
    </tbody>
</table>