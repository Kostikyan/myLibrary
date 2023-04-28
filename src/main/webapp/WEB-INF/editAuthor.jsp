<%@ page import="com.model.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author Info</title>
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
<% Author author = (Author) request.getAttribute("author"); %>
<body>

<div class="limiter">
  <a href="/home" style="font-size: 30px">
    Home
  </a>
  <div class="container-login100">
    <div class="wrap-login100" style="justify-content: center; margin-bottom: 30px; padding-bottom: 100px; padding-top: 100px">
      <form class="login100-form validate-form" action="editAuthor" method="post">
					<span class="login100-form-title">
						Edit Author
					</span>
        <input name="id" type="hidden" value="<%=author.getId()%>">
        <div class="wrap-input100 validate-input" data-validate = "">
          <input class="input100" type="text" name="name" value="<%=author.getName()%>">
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="wrap-input100 validate-input" data-validate = "">
          <input class="input100" type="text" name="surname" value="<%=author.getSurname()%>">
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
          <input class="input100" type="text" name="email" value="<%=author.getEmail()%>">
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="wrap-input100 validate-input" data-validate = "Only int!">
          <input class="input100" type="number" name="age" value="<%=author.getAge()%>">
          <span class="focus-input100"></span>
          <span class="symbol-input100">

						</span>
        </div>

        <div class="container-login100-form-btn">
          <input class="login100-form-btn" type="submit" value="Update">
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
