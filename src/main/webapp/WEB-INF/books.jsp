<%@ page import="java.util.List" %>
<%@ page import="com.model.Author" %>
<%@ page import="com.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Books</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
</head>
<% List<Book> books = (List<Book>) request.getAttribute("books");%>
<body>
<div class="limiter">
    <a href="/home" style="font-size: 30px">
        Home
    </a>
    <div class="container-login100">
        <div class="wrap-input100 validate-input" data-validate="">
            <form action="searchBook" method="get">
                <input class="input100" type="text" name="searchText" placeholder="Search" style="width: 300px; padding-left: 10px; padding-right: 0;">
                <input class="input100" type="submit" value="SEARCH" style="width: 300px; margin-top: 10px; text-align: center; padding-left: 0; padding-right: 0; cursor: pointer;">
            </form>
        </div>
        <table class="table table-dark" style="margin-top: -100px">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Title</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Author Name</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <% if (books != null && !books.isEmpty()){%>
            <% for (Book book : books) { %>
            <tr>
                <th scope="row"><%=book.getId()%></th>
                <td><%=book.getTitle()%></td>
                <td><%=book.getDescription()%></td>
                <td><%=book.getPrice()%></td>
                <td><%=book.getAuthor().getName()%></td>
                <td><a href="deleteBook?id=<%=book.getId()%>">Delete</a> / <a href="editBook?id=<%=book.getId()%>">Edit</a></td>
            </tr>
            <%}}%>
            </tbody>
        </table>
    </div>
</div>


<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/tilt/tilt.jquery.min.js"></script>
<script>
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>
