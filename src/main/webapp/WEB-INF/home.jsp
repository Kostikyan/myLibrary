<%@ page import="com.model.User" %>
<%@ page import="com.model.UserType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
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
    <style>
        .wrap-login100 span:hover{
            font-size: 51px;
            opacity: 0.9;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="limiter">
    <a href="logout" style="font-size: 30px">
        Logout
    </a>
    <div class="container-login100">
        <div class="wrap-login100">

            <a href="authors">
                <span class="login100-form-title" style="
                    font-size: 50px;
                ">
                    AUTHORS
                </span>
            </a>
            <a href="addAuthor">
                <%if(((User) session.getAttribute("user")).getUserType() == UserType.ADMIN){%>
                <span class="login100-form-title" style="
                    font-size: 50px;
                ">
                    ADD AUTHOR
                </span>
                <%}%>
            </a>
            <a href="books">
                <span class="login100-form-title" style="
                    font-size: 50px;
                    padding-bottom: 95px;
                ">
                    BOOKS
                </span>
            </a>
            ㅤ<a href="addBook">
                <span class="login100-form-title" style="
                    font-size: 50px;
                ">
                    ADD BOOK
                </span>
        </a>
        </div>
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