<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/css/login.css">
</head>
<body>
<div class="wrapper">
    <form class="form-signin ">       
      <h1 class="form-signin-heading">Customer Login</h1>
      <input type="text" class="form-control" name="username" placeholder="Email" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      

      <button class="btn btn-md  btn-dark" type="submit">Login</button>   
      <a class="forgot-password" href="#">Forgot your password?</a>
    </form>
  </div>
</body>
</html>