<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Product"%>
<%@page import="model.bean.Product"%>
<%@page import="model.bean.Setting"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrowed Books</title>
        <link rel="stylesheet" href="style/home.css">
        
    </head>
    <body style="background-color: antiquewhite;">
        <!-- container -->
        <div class="container">
            <!-- Tabbar -->
            <div class="navbar">
                <!-- Banner -->
                <img src="res/image/banner/library.png" id="banner" alt="">
                <!-- Home Icon -->
                <a href="HomeServlet"><i class="icon home-icon inline-block"></i></a>
                <!-- Search -->
                <div class="search inline-block">
                    <form action="">
                        <input type="text" name="txtSearch" id="txtSearch"
                               placeholder="Search: book, author, category">
                        <button style="display: none;"></button>
                    </form>
                </div>
                <!-- User -->
                <div class="user inline-block">
                    <!-- User Icon -->
                    <i class="icon user-icon" id="userIcon"></i>
                    <!-- User Name -->
                    <label for="">
                        <% if (!(boolean) session.getAttribute(Setting.SESSION_ISLOGIN)) {
                                out.print("Login");
                            } else {
                                out.print((String) session.getAttribute(Setting.SESSION_USER).toString().toUpperCase());
                            } %>
                    </label>
                    <!--  -->
                    <div class="user-area" id="userArea">
                        <ul>
                            <a href="UserControlServlet">
                                <li>
                                    <% if ((boolean) session.getAttribute(Setting.SESSION_ISLOGIN)) {
                                            out.print("Logout");
                                        } else {
                                            out.print("Login");
                                        } %>
                                </li>
                            </a>
                            <% if ((boolean) session.getAttribute(Setting.SESSION_ISLOGIN)) { %>
                            <hr>
                            <a href="ProfileServlet?id=1">
                                <li>Profile</li>
                            </a>
                            <a href="ChangePwServlet?id=1">
                                <li>Change password</li>
                            </a>
                            <% } else {%>
                            <a href="RegisterServlet?id=1">
                                <li>Register</li>
                            </a>
                            <% }%>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Content -->
            
            <div class="content" style="padding: 5%; background-color: antiquewhite;">
                <table border="1" style="width: 100%;">
                    <thead style="text-align: center; font-weight: bold;">
                        <tr>
                            <td>Number</td>
                            <td>Book name</td>
                            <td>Author</td>
                            <td>Author address</td>
                            <td>Author birthday</td>
                            <td>Category</td>
                            <td>Publication date</td>
                            <td>Description</td>
                            <td>Borrow date</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Product> borroweds = (ArrayList<Product>)request.getAttribute("borroweds");
                                int counter = 0;
                                for(Product p : borroweds){
                                    counter++;
                        %>
                                <tr>
                                    <td style="text-align: center;"><%=counter%></td>
                                    <td><%=p.getBookName()%></td>
                                    <td><%=p.getAuthorName()%></td>
                                    <td><%=p.getAuthorAddress()%></td>
                                    <td style="text-align: center;"><%=p.getBirthday()%></td>
                                    <td><%=p.getBookCategoryName()%></td>
                                    <td style="text-align: center;"><%=p.getNxb()%></td>
                                    <td><%=p.getDescription()%></td>
                                    <td style="text-align: center;"><%=p.getBorrowDay()%></td>
                                </tr>
                        <%
                            }
                        %>
                    </tbody>
                    
                </table>
            </div>
            <!-- Footer -->
            <div class="footer">
                <%@include file="footer.jsp" %>
            </div>
        </div>

        <script src="js/home.js"></script>
        <script src="js/productHandler.js"></script>
    </body>
</html>
