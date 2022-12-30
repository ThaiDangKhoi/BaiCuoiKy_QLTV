<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ERROR</title>
    </head>
    <body>
        <h1><%=(String)request.getAttribute("error")%></h1>
        <h3><%=(String)request.getAttribute("errorContent")%></h3>
        <style>
            h3{
                color: red;
            }
        </style>
    </body>
</html>