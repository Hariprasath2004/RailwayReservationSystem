<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Admin Login</title>

<style>

body{
    font-family:Arial;
    background:#f4f4f4;
}

.container{

    width:380px;
    margin:100px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;
    text-align:center;

}

input{

    width:90%;
    padding:10px;
    margin:10px;

}

button{

    width:95%;
    padding:10px;
    background:#1976d2;
    color:white;
    border:none;
    cursor:pointer;

}

.error{

    color:red;

}

</style>

</head>

<body>

<div class="container">

<h2>Admin Login</h2>

<s:actionerror cssClass="error"/>

<form action="adminLogin" method="post">

<input
type="email"
name="email"
placeholder="Admin Email"
required>

<input
type="password"
name="password"
placeholder="Password"
required>

<button type="submit">

Login

</button>

</form>

<br>

<a href="login.jsp">

User Login

</a>

</div>

</body>

</html>