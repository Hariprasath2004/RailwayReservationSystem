<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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

table{

    margin:auto;
    border-collapse:collapse;
    background:white;

}

th,td{

    border:1px solid black;
    padding:12px;

}

th{

    background:#1976d2;
    color:white;

}

</style>

</head>

<body>

<h2>PNR Status</h2>

<table>

<tr>
<th>PNR</th>
<td><s:property value="booking.pnr"/></td>
</tr>

<tr>
<th>Passenger</th>
<td><s:property value="booking.passengerName"/></td>
</tr>

<tr>
<th>Train ID</th>
<td><s:property value="booking.trainId"/></td>
</tr>

<tr>
<th>Status</th>
<td><s:property value="booking.status"/></td>
</tr>

<tr>
<th>Booked On</th>
<td><s:property value="booking.bookingDate"/></td>
</tr>

</table>

<br>

<a href="dashboard.jsp">

Back to Dashboard

</a>

</body>

</html>