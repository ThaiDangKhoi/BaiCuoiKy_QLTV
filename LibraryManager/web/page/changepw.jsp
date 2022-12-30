<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <form action="ChangePwServlet" method="GET">
        <table>
            <tr>
                <td><label for="">Current password</label></td>
                <td><input type="password" name="txtOldPass" id="" placeholder="Type current password" required></td>
            </tr>
            <tr>
                <td><label for="">New password</label></td>
                <td><input type="password" name="txtNewPass" id="" placeholder="Type new password" required></td>
            </tr>
        </table>
            <button name="btnChangePW">Change password</button>
        <input type="button" name="btnHome" id="" value="Home" onclick="back()">
    </form>
    <script>
        function back(){
            history.back();
        }
    </script>
    </body>
</html>
