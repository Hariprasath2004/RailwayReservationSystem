<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Available Trains</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f5f5f5;
}

h2{
    text-align:center;
}

table{
    margin:auto;
    border-collapse:collapse;
    width:90%;
    background:white;
}

th{
    background:#1976d2;
    color:white;
    padding:10px;
}

td{
    padding:10px;
    text-align:center;
}

input[type=submit]{

    background:#28a745;
    color:white;
    border:none;
    padding:8px 18px;
    cursor:pointer;
    border-radius:5px;

}

input[type=submit]:hover{

    background:#1e7e34;

}

.back{

    display:block;
    text-align:center;
    margin-top:25px;

}

</style>

</head>

<body>

<h2>Available Trains</h2>

<table border="1">

<tr>

<th>Train No</th>
<th>Train Name</th>
<th>Source</th>
<th>Destination</th>
<th>Journey Date</th>
<th>Departure</th>
<th>Arrival</th>
<th>Available Seats</th>
<th>Action</th>

</tr>

<s:iterator value="trainList">

<tr>

<td><s:property value="trainNo"/></td>

<td><s:property value="trainName"/></td>

<td><s:property value="source"/></td>

<td><s:property value="destination"/></td>

<td><s:property value="journeyDate"/></td>

<td><s:property value="departureTime"/></td>

<td><s:property value="arrivalTime"/></td>
<td><s:property value="availableSeats"/></td>

<td>

<form action="bookTicket.jsp" method="get">

<input
type="hidden"
name="trainId"
value="<s:property value='id'/>">

<input
type="submit"
value="Book Ticket">

</form>

</td>

</tr>

</s:iterator>

</table>

<div class="back">

<a href="dashboard.jsp">⬅ Back to Dashboard</a>

</div>

</body>

</html>