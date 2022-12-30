<%@page import="model.bo.service.AdminService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Books</h1>
<table border="1" style="width: 100%;">
    <thead class="text-center" style="font-weight: bold;">
        <tr>
            <td>Number</td>
            <td>Book id</td>
            <td>Author id</td>
            <td>Category id</td>
            <td>Book name</td>
            <td>Publication date</td>
            <td>Description</td>
            <td>Photo</td>

        </tr>
    </thead>
    <tbody>
        <%
            ArrayList<Book> bookList = (ArrayList<Book>) AdminService.getBookList();
            int counterBook = 0;
            int maxBookId = bookList.get(0).getBookId();
            for (Book b : bookList) {
                counterBook++;
                if(maxBookId < b.getBookId()){maxBookId = b.getBookId();}
        %>
        <tr class="view">
            <td class="text-center"><%=counterBook%></td>
            <td class="text-center"><%=b.getBookId()%></td>
            <td class="text-center"><%=b.getAuthorId()%></td>
            <td class="text-center"><%=b.getBookCategoryId()%></td>
            <td><%=b.getBookName()%></td>
            <td class="text-center"><%=b.getNxb()%></td>
            <td><%=b.getDescription()%></td>
            <td><%=b.getImageSrc()%></td>

        </tr>
        <tr class="edit">
            <form action="UpdateBookServlet">
            <td class="text-center"><%=counterBook%></td>
            <td class="text-center"><input type="text" name="txtBookId" id="" value="<%=b.getBookId()%>"></td>
            <td class="text-center"><input type="text" name="txtAuthorId" id="" value="<%=b.getAuthorId()%>"></td>
            <td class="text-center"><input type="text" name="txtCategoryId" id="" value="<%=b.getBookCategoryId()%>"></td>
            <td><input type="text" name="txtBookName" id="" value="<%=b.getBookName()%>"></td>
            <td class="text-center"><input type="text" name="txtNxb" id="" value="<%=b.getNxb()%>"></td>
            <td><input type="text" name="txtDescription" id="" value="<%=b.getDescription()%>"></td>
            <td><input type="file" name="txtImageSrc" id="" value="<%=b.getImageSrc()%>"></td>
            <td><button value="btnUpdate" name="btnUpdate">Update</button></td>
            <td><a href="UpdateBookServlet?remove=true&bookId=<%=b.getBookId()%>">Remove</a></td>
        </form>
        </tr>
        <%            }
        %>
        <tr class="edit">
            <form action="AddBookServlet" method="GET">
                <td class="text-center"><%=counterBook+1%></td>
                <td class="text-center"><input type="text" name="txtBookId" id="" value="<%=maxBookId+1%>" style=""></td>
                <td class="text-center"><input type="text" name="txtAuthorId" id="" value="" placeholder="Author id"></td>
                <td class="text-center"><input type="text" name="txtCategoryId" id="" value="" placeholder="Category id"></td>
                <td><input type="text" name="txtBookName" id="" value="" placeholder="Book name"></td>
                <td class="text-center"><input type="date" name="txtNxb" id="" value=""></td>
                <td><input type="text" name="txtDescription" id="" value="" placeholder="Description"></td>
                <td><input type="file" name="txtImageSrc" id="" value=""></td>
                <td><button>Add</button></td>
            </form>
        </tr>
    </tbody>
</table>

