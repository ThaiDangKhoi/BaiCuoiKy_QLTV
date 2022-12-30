<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="LoginServlet" method="GET">
        <table>
            <tr>
                <td><label for="">Email</label></td>
                <td><input type="email" name="txtEmail" id="" 
                           placeholder="Type email" required></td>
            </tr>
            <tr>
                <td><label for="">Password</label></td>
                <td><input type="password" name="txtPassword" id="" placeholder="Type password" required></td>
            </tr>
        </table>
        <button name="btnLogin">Login</button>
        <a href="index.jsp"><input type="button" name="btnHome" id="" value="Home"></a>
    </form>
</body>
</html>