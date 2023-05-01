<%@ page import="com.model.Author" %>
<%@ page import="com.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Book</title>
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
<% List<Author> authors = (List<Author>) request.getAttribute("authors");%>
<body>


<div class="limiter">
  <a href="/home" style="font-size: 30px;">
    Home
  </a>
  <div class="container-login100">
    <div class="wrap-login100"
         style="justify-content: center; margin-bottom: 30px; padding-bottom: 100px; padding-top: 100px">
            <span class="login100-form-title">
                Add Book
            </span>
      <form class="login100-form validate-form" action="addBook" method="post" enctype="multipart/form-data">

        <div class="wrap-input100 validate-input" data-validate="">
          <input class="input100" type="text" name="title" placeholder="Title">
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="wrap-input100 validate-input" data-validate="">
          <input class="input100" type="text" name="description" placeholder="Description">
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="wrap-input100 validate-input" data-validate="Only int!">
          <input class="input100" type="number" name="price" placeholder="Price">
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="wrap-input100 validate-input" data-validate="">
          <select class="input100" name="authorId">
            <% for (Author author : authors) { %>
            <option value="<%=author.getId()%>"><%=author.getName()%> <%=author.getSurname()%>
            </option>
            <%}%>
          </select>
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="wrap-input100">
          <input class="input100" type="file" name="picture" placeholder="Picture">
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="container-login100-form-btn">
          <input class="login100-form-btn" type="submit" value="Add">
        </div>

      </form>
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
