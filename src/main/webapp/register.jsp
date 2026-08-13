<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>

<h2>User Registration</h2>

<form action="register" method="post">

    <label>Name</label>
    <input type="text" name="name">
    <br><br>

    <label>Email</label>
    <input type="email" name="email">
    <br><br>

    <label>Password</label>
    <input type="password" name="password">
    <br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>