<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Bookings</title>

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
    margin:auto;
    border-collapse:collapse;
    background:white;
}

th{
    background:#1976d2;
    color:white;
    padding:12px;
}

td{
    padding:10px;
    text-align:center;
}

tr:nth-child(even){
    background:#eeeeee;
}

.cancelBtn{
    background:red;
    color:white;
    border:none;
    padding:8px 15px;
    border-radius:5px;
    cursor:pointer;
}

.back{
    text-align:center;
    margin-top:20px;
}

form{
    margin:0;
}

</style>

</head>

<body>

<h2>My Bookings</h2>

<table>

<tr>
    <th>PNR</th>
    <th>Train ID</th>
    <th>Passenger</th>
    <th>Age</th>
    <th>Gender</th>
    <th>Status</th>
    <th>Booked On</th>
    <th>Action</th>
</tr>

<s:iterator value="bookingList">

<tr>

<td><s:property value="pnr"/></td>

<td><s:property value="trainId"/></td>

<td><s:property value="passengerName"/></td>

<td><s:property value="age"/></td>

<td><s:property value="gender"/></td>

<td><s:property value="status"/></td>

<td><s:property value="bookingDate"/></td>

<td>

<s:if test="status.equals('BOOKED')">

<form action="cancelTicket" method="post">

<input type="hidden"
       name="bookingId"
       value="<s:property value='bookingId'/>"/>

<input type="submit"
       value="Cancel"
       class="cancelBtn"/>

</form>

</s:if>

<s:else>

Cancelled

</s:else>

</td>

</tr>

</s:iterator>

</table>

<div class="back">

<br>

<a href="dashboard.jsp">⬅ Back to Dashboard</a>

</div>

</body>

</html>