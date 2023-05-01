<%@ page import="java.util.List" %>
<%@ page import="com.model.Author" %>
<%@ page import="com.model.User" %>
<%@ page import="com.model.UserType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Authors</title>
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
<%
    List<Author> authors = (List<Author>) request.getAttribute("authors");
    User user = (User) session.getAttribute("user");
%>
<body>
<div class="limiter">

    <a href="/home" style="font-size: 30px">
        Home
    </a>
    <div class="container-login100">
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Email</th>
                    <th scope="col">Age</th>
                    <%if(user.getUserType() == UserType.ADMIN){%>
                    <th scope="col">Action</th>
                    <%}%>
                </tr>
                </thead>
                <tbody>
                <% if (authors != null && !authors.isEmpty()){%>
                <% for (Author author : authors) { %>
                <tr>
                    <th scope="row"><%=author.getId()%></th>
                    <td><%=author.getName()%></td>
                    <td><%=author.getSurname()%></td>
                    <td><%=author.getEmail()%></td>
                    <td><%=author.getAge()%></td>
                    <%if(user.getUserType() == UserType.ADMIN){%>
                    <td><a href="deleteAuthor?id=<%=author.getId()%>">Delete</a> / <a href="editAuthor?id=<%=author.getId()%>">Edit</a></td>
                    <%}%>
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
