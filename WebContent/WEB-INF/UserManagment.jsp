<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="GC">
<link rel="icon"
	href="http://www.iconeasy.com/icon/png/Game/Super%20Mario%201/Retro%20Mushroom%20Super%202.png">

<title>Login</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
	function submitForm(met) {
		document.myForm.action = met;
		document.getElementById("myForm").submit();
	}
</script>

</head>

<body>
<%@ page import="entities.User" %>
<%
String userName = ((User) session.getAttribute("usuario")).getUsuario();
 %>
	<div class="container">
		<center><h1>Welcome <%=userName.toUpperCase()%></h1></center>
		<form class="form-inline" role="form" id="myForm" name="myForm"
			action="" method="post">
			<h2 class="form-signin-heading">User Managment:</h2>
			<label for="inputEmail" class="sr-only">User</label> <input
				email="email" id="inputEmail" class="form-control"
				placeholder="Email" required="" autofocus="" type="email"> <label
				for="inputUsername" class="sr-only">User</label> <input
				name="username" id="inputUsername" class="form-control"
				placeholder="Username" required="" autofocus="" type=""> <label
				for="inputPassword" class="sr-only">User</label> <input
				name="password" id="inputPassword" class="form-control"
				placeholder="Password" required="" autofocus="" type="password">
			<button class="btn btn-lg "
				onclick="javascript: submitForm('persona/consulta')">Search</button>
			<button class="btn btn-lg "
				onclick="javascript: submitForm('persona/alta')">New</button>
			<button class="btn btn-lg "
				onclick="javascript: submitForm('persona/modificacion')">Edit</button>
			<button class="btn btn-lg "
				onclick="javascript: submitForm('persona/baja')">Delete</button>
		</form>
	</div>
	<!-- /container -->
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="style/ie10-viewport-bug-workaround.js"></script>
</body>
</html>