<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alert</title>
    </head>
    <body>
        <h1><%=(String)request.getAttribute("notific")%></h1>
        <h3><%=(String)request.getAttribute("alertContent")%></h3>
        <style>
            h3{
                color: red;
            }
        </style>
        <form action="HomeServlet">
            <button>Home</button>
        </form>
        <form action="BorrowedServlet">
            <button>Borrowed books</button>
        </form>
    </body>
</html>
