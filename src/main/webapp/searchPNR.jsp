<%@ page contentType="text/html;charset=UTF-8"%>

<%
String username = (String) session.getAttribute("userName");

if (username == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>PNR Status</title>

<style>

body{

    font-family:Arial;
    background:#f4f4f4;
    text-align:center;

}

.container{

    width:400px;
    margin:80px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;

}

input{

    width:90%;
    padding:10px;
    margin:15px 0;

}

button{

    padding:10px 25px;
    background:#1976d2;
    color:white;
    border:none;
    cursor:pointer;

}

</style>

</head>

<body>

<div class="container">

<h2>PNR Status</h2>

<form action="searchPNR" method="post">

<input type="text"
       name="pnr"
       placeholder="Enter PNR Number"
       required>

<br>

<button type="submit">

Search

</button>

</form>

<br>

<a href="dashboard.jsp">

Back to Dashboard

</a>

</div>

</body>

</html>