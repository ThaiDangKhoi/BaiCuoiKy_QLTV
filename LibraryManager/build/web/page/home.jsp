<%@page import="model.bo.service.UserService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.Product" %>
<%@page import="model.bean.Setting" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/home.css">
    </head>

    <body>
        <!-- container -->
        <div class="container">
            <!-- Tabbar -->
            <div class="navbar">
                <!-- Banner -->
                <img src="res/image/banner/library.png" id="banner" alt="">
                <!-- Home Icon -->
                <a href="HomeServlet"><i class="icon home-icon inline-block"></i></a>
                <!-- Title -->
                <div class="title inline-block">
                    <%=(String) session.getAttribute(Setting.SESSION_TITLE)%>
                </div>
                <!-- Search -->
                <div class="search inline-block">
                    <form action="SearchServlet" method="GET">
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
                            <a href="BorrowedServlet">
                                <li>Borrowed books</li>
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
            <div class="content">
                <!-- Menu -->
                <div class="menu inline-block">
                    MENU
                </div>
                <!-- SubContent -->
                <div class="sub-content inline-block">
                    <% ArrayList<Product> productList = new ArrayList<Product>();
                        try {
                            productList = UserService.getProduct();
                        } catch (Exception e) {
                            request.setAttribute("error", "Server error");
                            request.setAttribute("errorContent", "Not access to database");
                            getServletContext().getRequestDispatcher("/page/error.jsp")
                                    .forward(request, response);
                        }

                        try {
                            if (((String) session.getAttribute(Setting.SESSION_SEARCH)).equals("search")) {
                                productList = (ArrayList<Product>) request.getAttribute("products");
                            }
                        } catch (Exception e) {
                        }

                        for (Product p : productList) {
                    %>                    <div class="product inline-block" title="<%=p.getAuthorName()%>">
                        <img src="res/image/books/<%=p.getImageSrc()%>" alt="alt"
                             class="imgProduct" onclick="showInfo('<%=p.getBookId()%>')"/>
                        <span class="name">
                            <%=p.getBookName()%>
                        </span>
                    </div>

                    <!-- product info -->
                    <div class="product-info" id="product<%=p.getBookId()%>">
                        <i class="icon info-close" onclick="closeInfo('product<%=p.getBookId()%>')"></i>
                        <div class="info inline-block">
                            <table>
                                <tr>
                                    <td>Book name:</td>
                                    <td><%=p.getBookName()%></td>
                                </tr>
                                <tr>
                                    <td>Author:</td>
                                    <td><%=p.getAuthorName()%></td>
                                </tr>
                                <tr>
                                    <td>Author birthday:</td>
                                    <td><%=p.getBirthday()%></td>
                                </tr>
                                <tr>
                                    <td>Author address</td>
                                    <td><%=p.getAuthorAddress()%></td>
                                </tr>
                                <tr>
                                    <td>Category:</td>
                                    <td><%=p.getBookCategoryName()%></td>
                                </tr>
                                <tr>
                                    <td>Publication date:</td>
                                    <td><%=p.getNxb()%></td>
                                </tr>
                                <tr>
                                    <td>Description:</td>
                                    <td><%=p.getDescription()%></td>
                                </tr>
                            </table>
                        </div>
                        <div class="inline-block photo">
                            <div><img src="res/image/books/<%=p.getImageSrc()%>" alt="" class="book"></div>
                        </div>
                        <form action="BorrowServlet" method="GET">
                            <input type="text" name="bookId" value="<%=p.getBookId()%>">
                            <button id="btnBorrow">Borrow book</button>
                        </form>
                    </div> 
                    <% }%>

                </div>
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