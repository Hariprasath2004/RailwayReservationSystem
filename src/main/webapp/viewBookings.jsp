<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>View Bookings</title>

<style>

body{
    font-family:Arial;
    background:#f4f4f4;
}

h2{
    text-align:center;
    color:#1976d2;
}

table{
    width:95%;
    margin:20px auto;
    border-collapse:collapse;
    background:white;
}

th,td{
    border:1px solid #ccc;
    padding:10px;
    text-align:center;
}

th{
    background:#1976d2;
    color:white;
}

.back{
    text-align:center;
    margin-top:20px;
}

.back a{
    text-decoration:none;
    color:#1976d2;
    font-weight:bold;
}

</style>

</head>

<body>

<h2>All Bookings</h2>

<table>

<tr>

<th>ID</th>
<th>PNR</th>
<th>User ID</th>
<th>Train ID</th>
<th>Passenger</th>
<th>Age</th>
<th>Gender</th>
<th>Status</th>
<th>Booked At</th>

</tr>

<s:iterator value="bookingList">

<tr>

<td><s:property value="bookingId"/></td>

<td><s:property value="pnr"/></td>

<td><s:property value="userId"/></td>

<td><s:property value="trainId"/></td>

<td><s:property value="passengerName"/></td>

<td><s:property value="age"/></td>

<td><s:property value="gender"/></td>

<td><s:property value="status"/></td>

<td><s:property value="bookingDate"/></td>

</tr>

</s:iterator>

</table>

<div class="back">

<a href="adminDashboard.jsp">⬅ Back to Dashboard</a>

</div>

</body>

</html>