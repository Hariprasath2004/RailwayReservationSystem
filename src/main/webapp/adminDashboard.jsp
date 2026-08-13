<%@ page contentType="text/html;charset=UTF-8"%>

<%
String adminName = (String)session.getAttribute("adminName");

if(adminName==null){

    response.sendRedirect("adminLogin.jsp");
    return;

}
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Admin Dashboard</title>

<style>

body{
    font-family: Arial;
    background:#f4f4f4;
}

.box{
    width:500px;
    margin:80px auto;
    padding:30px;
    background:white;
    border-radius:10px;
    box-shadow:0 0 10px gray;
    text-align:center;
}

form{
    margin:15px 0;
}

button{
    width:100%;
    padding:12px;
    background:#1976d2;
    color:white;
    border:none;
    font-size:18px;
    cursor:pointer;
    border-radius:5px;
}

button:hover{
    background:#1565c0;
}

</style>

</head>

<body>

<div style="padding:15px;background:#1976d2;color:white;">

    <h2>🚆 Railway Reservation System - Admin Panel</h2>

    <a href="index.jsp" style="color:white;text-decoration:none;font-weight:bold;">
        🏠 Home
    </a>

    &nbsp;&nbsp;&nbsp;

   <form action="logout" method="post" style="display:inline;">
    <button type="submit"
        style="background:none;
               border:none;
               color:white;
               font-weight:bold;
               cursor:pointer;
               font-size:16px;">
        🚪 Logout
    </button>
</form>

</div>

<div class="box">

<h2>Welcome Admin</h2>

<h3><%=adminName%></h3>

<hr>

<form action="addTrain.jsp" method="get">
    <button type="submit">Add Train</button>
</form>

<form action="viewTrains" method="post">
    <button type="submit">View Trains</button>
</form>

<form action="viewAllBookings" method="post">
    <button type="submit">View Bookings</button>
</form>

</div>

</body>

</html>