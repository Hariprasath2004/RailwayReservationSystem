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
    margin:0;
    font-family:Arial, sans-serif;
    background:#f4f4f4;
}

/* Top Header */
.header{
    padding:25px;
    background:#1976d2;
    color:white;
}

.header h2{
    margin:0;
    font-size:26px;
}

/* Main Admin Box */
.box{
    width:500px;
    margin:70px auto;
    padding:30px;
    background:white;
    border-radius:10px;
    box-shadow:0 0 10px gray;
    text-align:center;
}

.box h2{
    margin-bottom:10px;
}

.box h3{
    margin-top:0;
    color:#555;
}

hr{
    margin:20px 0;
    border:0;
    border-top:1px solid #ddd;
}

/* Main Buttons */
form{
    margin:15px 0;
}

.main-button{
    width:100%;
    padding:12px;
    background:#1976d2;
    color:white;
    border:none;
    font-size:18px;
    cursor:pointer;
    border-radius:5px;
}

.main-button:hover{
    background:#1565c0;
}

/* Bottom Buttons */
.bottom-buttons{
    margin-top:25px;
    padding-top:20px;
    border-top:1px solid #ddd;
}

.home-button,
.logout-button{
    display:inline-block;
    padding:9px 25px;
    margin:5px;
    border:none;
    border-radius:5px;
    font-size:15px;
    cursor:pointer;
    text-decoration:none;
}

.home-button{
    background:#eeeeee;
    color:#333;
}

.home-button:hover{
    background:#dddddd;
}

.logout-button{
    background:#eeeeee;
    color:#333;
}

.logout-button:hover{
    background:#c62828;
}

</style>

</head>

<body>

<!-- Header -->

<div class="header">

    <h2>Railway Reservation System - Admin Panel</h2>

</div>


<!-- Admin Dashboard -->

<div class="box">

    <h2>Welcome Admin</h2>

    <h3><%=adminName%></h3>

    <hr>


    <!-- Add Train -->

    <form action="addTrain.jsp" method="get">

        <button type="submit" class="main-button">
            Add Train
        </button>

    </form>


    <!-- View Trains -->

    <form action="viewTrains" method="post">

        <button type="submit" class="main-button">
            View Trains
        </button>

    </form>


    <!-- View Bookings -->

    <form action="viewAllBookings" method="post">

        <button type="submit" class="main-button">
            View Bookings
        </button>

    </form>


    <!-- Home and Logout -->

    <div class="bottom-buttons">

        <a href="index.jsp" class="home-button">
            Home
        </a>


        <form action="logout" method="post" style="display:inline;">

            <button type="submit" class="logout-button">
                Logout
            </button>

        </form>

    </div>

</div>

</body>

</html>