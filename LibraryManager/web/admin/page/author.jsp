<%@page import="model.bo.service.AdminService"%>
<%@page import="model.bean.Author"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Author</h1>
<table border="1" style="width: 100%;">
    <thead class="text-center" style="font-weight: bold;">
        <tr>
            <td>Number</td>
            <td>Author id</td>
            <td>Author name</td>
            <td>Address</td>
            <td>Birthday</td>
        </tr>
    </thead>
    <tbody>
        <%
            ArrayList<Author> authorList = (ArrayList<Author>) AdminService.getAuthorList();
            int counterAuthor = 0;
            int maxAuthorId = authorList.get(0).getAuthorId();
            for (Author item : authorList) {
                counterAuthor++;
                if(maxAuthorId < item.getAuthorId()){maxAuthorId = item.getAuthorId();}
        %>
        <tr class="view">
            <td class="text-center"><%=counterAuthor%></td>
            <td class="text-center"><%=item.getAuthorId()%></td>
            <td><%=item.getAuthorName()%></td>
            <td><%=item.getAuthorAddress()%></td>
            <td class="text-center"><%=item.getBirthday()%></td>
        </tr>
        <tr class="edit">
            <form action="UpdateAuthorServlet">
            <td class="text-center"><%=counterAuthor%></td>
            <td class="text-center"><input type="text" name="txtAuthorId" id="" value="<%=item.getAuthorId()%>"></td>
            <td><input type="text" name="txtAuthorName" id="" value="<%=item.getAuthorName()%>"></td>
            <td><input type="text" name="txtAuthorAddress" id="" value="<%=item.getAuthorAddress()%>"></td>
            <td><input type="date" name="txtBirthday" id="" value="<%=item.getBirthday()%>"></td>
            <td><button value="btnUpdate" name="btnUpdate">Update</button></td>
            <td><a href="UpdateAuthorServlet?remove=true&authorId=<%=item.getAuthorId()%>">Remove</a></td>
        </form>
        </tr>
        <%            }
        %>
        <tr class="edit">
            <form action="AddAuthorServlet" method="GET">
                <td class="text-center"><%=counterAuthor+1%></td>
                <td class="text-center"><input type="text" name="txtAuthorId" id="" value="<%=maxAuthorId+1%>"></td>
                <td><input type="text" name="txtAuthorName" id="" value="" placeholder="Author name"></td>
                <td><input type="text" name="txtAuthorAddress" id="" value="" placeholder="Author address"></td>
                <td><input type="date" name="txtBirthday"></td>
                <td><button>Add</button></td>
            </form>
        </tr>
    </tbody>
</table>
