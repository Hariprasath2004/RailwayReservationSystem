<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="true"%>
<%
String username = (String) session.getAttribute("userName");

if (username == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Dashboard</title>

<style>

body{

    font-family:Arial;
    background:#f4f4f4;
    text-align:center;

}

.container{

    width:500px;
    margin:60px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;

}

a{

    display:block;
    margin:15px;
    padding:12px;
    text-decoration:none;
    background:#1976d2;
    color:white;
    border-radius:5px;

}

a:hover{

    background:#0d47a1;

}

h1{

    color:#1976d2;

}

</style>

</head>

<body>

<div class="container">

<h1> Railway Reservation System</h1>

<h3>

Welcome, <%= username %>

</h3>

<hr>

<a href="searchTrain.jsp">Search Train</a>

<a href="myBookings">My Bookings</a>

<a href="searchPNR.jsp">PNR Status</a>

<a href="index.jsp">Home</a>

<a href="logout">Logout</a>

</div>

</body>

</html>