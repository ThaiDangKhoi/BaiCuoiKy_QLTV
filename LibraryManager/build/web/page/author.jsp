<%@page import="model.bean.Author"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Author> authorList = (ArrayList<Author>)request.getAttribute("authorList");
%>
<table>
    <% for(Author a : authorList){ %>
    <tr>
        <td><%=a.getAuthorId()%></td>
        <td><%=a.getAuthorName()%></td>
        <td><%=a.getAuthorAddress()%></td>
        <td><%=a.getBirthday()%></td>
    </tr>
    <% } %>
</table>