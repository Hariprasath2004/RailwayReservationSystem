<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>View Trains</title>

<style>

body{
    font-family:Arial;
    background:#f4f4f4;
}

.container{
    width:95%;
    margin:30px auto;
}

h2{
    text-align:center;
    color:#1976d2;
}

table{
    width:100%;
    border-collapse:collapse;
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
    border:1px solid #ddd;
}

tr:nth-child(even){
    background:#f9f9f9;
}

.back{
    margin-top:20px;
    text-align:center;
}

a{
    text-decoration:none;
    color:#1976d2;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="container">

<h2>All Trains</h2>

<table>

<tr>
    <th>ID</th>
    <th>Train No</th>
    <th>Train Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Journey Date</th>
    <th>Departure</th>
    <th>Arrival</th>
    <th>Total Seats</th>
    <th>Available Seats</th>
    <th>Fare</th>
    <th>Action</th>
</tr>

<s:iterator value="trainList">>

<tr>

<td><s:property value="id"/></td>

<td><s:property value="trainNo"/></td>

<td><s:property value="trainName"/></td>

<td><s:property value="source"/></td>

<td><s:property value="destination"/></td>

<td><s:property value="journeyDate"/></td>

<td><s:property value="departureTime"/></td>

<td><s:property value="arrivalTime"/></td>

<td><s:property value="totalSeats"/></td>

<td><s:property value="availableSeats"/></td>

<td>₹ <s:property value="fare"/></td>

<td>

<form action="deleteTrain" method="post"
      onsubmit="return confirm('Delete this train?');">

    <input type="hidden" name="id" value="<s:property value='id'/>">

    <button type="submit"
            style="background:red;color:white;padding:6px 12px;border:none;border-radius:4px;cursor:pointer;">
        Delete
    </button>

</form>

</td>

</tr>

</s:iterator>

</table>

<div class="back">

<a href="adminDashboard.jsp">⬅ Back to Dashboard</a>

</div>

</div>

</body>
</html>