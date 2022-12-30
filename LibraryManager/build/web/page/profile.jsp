<%@page import="model.bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <form action="ProfileServlet" method="GET">
            <table>
                <tr>
                    <td><label for="">Email</label></td>
                    <td><label><%=user.getEmail()%></label></td>
                </tr>
                <tr>
                    <td><label for="">Fullname</label></td>
                    <td><input type="text" name="txtFullName" id="" value="<%=user.getFullName()%>" required placeholder="Fullname"></td>
                </tr>
                <tr>
                    <td><label for="">Address</label></td>
                    <td><input type="text" name="txtAddress" id="" value="<%=user.getAddress()%>" required placeholder="Address"></td>
                </tr>
                <tr>
                    <td><label for="">Birthday</label></td>
                    <td><input type="date" name="txtBirthday" id="" value="<%=user.getBirthday()%>" required></td>
                </tr>
                <tr>
                    <td><label for="">Phone</label></td>
                    <td><input type="text" name="txtPhone" id="" value="<%=user.getPhone()%>" required placeholder="Phone"></td>
                </tr>
            </table>
            <button name="btnUpdate">Update</button>
            <input type="button" name="" id="" value="Back" onclick="history.back()">
        </form>
    </body>
</html>
