<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="RegisterServlet" method="GET">
        <table>
            <tr>
                <td><label for="">Email</label></td>
                <td><input type="email" name="txtEmail" id="" 
                           placeholder="Type email" required></td>
            </tr>
            <tr>
                <td><label for="">Fullname</label></td>
                <td><input type="text" name="txtFullName" id="" 
                           placeholder="Type fullname" required></td>
            </tr>
            <tr>
                <td><label for="">Address</label></td>
                <td><input type="text" name="txtAddress" id="" 
                           placeholder="Type address" required></td>
            </tr>
            <tr>
                <td><label for="">Birthday</label></td>
                <td><input type="date" name="txtBirthday" id="" 
                           placeholder="Type birthday" required></td>
            </tr>
            <tr>
                <td><label for="">Phone</label></td>
                <td><input type="text" name="txtPhone" id="" 
                           placeholder="Type phone" required></td>
            </tr>
            <tr>
                <td><label for="">Password</label></td>
                <td><input type="password" name="txtPassword" id="" placeholder="Type password" required></td>
            </tr>
            <tr>
                <td><label for="">Password</label></td>
                <td><input type="password" name="txtPass" id="" placeholder="Re type password" required></td>
            </tr>
        </table>
        <button>Register</button>
        <a href="index.jsp"><input type="button" name="btnHome" id="" value="Home"></a>
    </form>
</body>
</html>