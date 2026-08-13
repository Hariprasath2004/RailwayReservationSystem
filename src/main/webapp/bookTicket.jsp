<%@ page contentType="text/html;charset=UTF-8"%>

<%
String trainId = request.getParameter("trainId");

if(trainId == null){
    trainId = "";
}
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Passenger Details</title>

<style>

body{
    font-family:Arial;
    background:#f5f5f5;
}

.container{

    width:420px;
    margin:60px auto;
    background:white;
    padding:25px;
    border-radius:10px;
    box-shadow:0 0 10px gray;

}

h2{
    text-align:center;
}

input,select{

    width:100%;
    padding:10px;
    margin-top:8px;
    margin-bottom:15px;

}

input[type=submit]{

    background:#1976d2;
    color:white;
    border:none;
    cursor:pointer;

}

input[type=submit]:hover{

    background:#0d47a1;

}

</style>

</head>

<body>

<div class="container">

<h2>Passenger Details</h2>

<form action="bookTicket" method="post">

<input
type="hidden"
name="trainId"
value="<%=trainId%>">

<label>Passenger Name</label>

<input
type="text"
name="passengerName"
required>

<label>Age</label>

<input
type="number"
name="age"
required>

<label>Gender</label>

<select name="gender">

<option>Male</option>

<option>Female</option>

<option>Other</option>

</select>

<input
type="submit"
value="Confirm Booking">

</form>

</div>

</body>

</html>