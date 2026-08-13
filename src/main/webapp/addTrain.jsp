<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Add Train</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f4f4f4;
}

.container{
    width:450px;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;
}

h2{
    text-align:center;
    color:#1976d2;
}

input{
    width:95%;
    padding:10px;
    margin:10px 0;
    font-size:15px;
}

button{
    width:100%;
    padding:12px;
    background:#1976d2;
    color:white;
    border:none;
    cursor:pointer;
    font-size:16px;
}

button:hover{
    background:#125ea8;
}

.success{
    color:green;
    text-align:center;
}

.error{
    color:red;
    text-align:center;
}

.back{
    text-align:center;
    margin-top:20px;
}

</style>

</head>

<body>

<div class="container">

<h2>Add Train</h2>

<s:actionmessage cssClass="success"/>
<s:actionerror cssClass="error"/>

<form action="addTrain" method="post">

<input
type="text"
name="trainNo"
placeholder="Train Number"
required>

<input
type="text"
name="trainName"
placeholder="Train Name"
required>

<input
type="text"
name="source"
placeholder="Source"
required>

<input
type="text"
name="destination"
placeholder="Destination"
required>

<input
type="date"
name="journeyDate"
required>

<input
type="time"
name="departureTime"
required>

<input
type="time"
name="arrivalTime"
required>

<input
type="number"
name="totalSeats"
placeholder="Total Seats"
required>

<input
type="number"
name="fare"
placeholder="Fare"
step="0.01"
required>

<button type="submit">
Add Train
</button>

</form>

<div class="back">
    <a href="adminDashboard.jsp">⬅ Back to Dashboard</a>
</div>

</div>

</body>

</html>