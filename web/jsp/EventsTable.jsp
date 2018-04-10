<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

<html>
<head>
    <title>Title</title>
</head>
<body onload="update('FOOTBALL');">

<ul class="nav nav-tabs nav-tabs-center" id="sport-type" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" id="football-tab" data-toggle="tab" href="#football" role="tab" aria-controls="football" aria-selected="true">Football</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="hockey-tab" data-toggle="tab" href="#hockey" role="tab" aria-controls="hockey" aria-selected="false">Hockey</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="tennis-tab" data-toggle="tab" href="#tennis" role="tab" aria-controls="tennis" aria-selected="false">Tennis</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="volleyball-tab" data-toggle="tab" href="#volleyball" role="tab" aria-controls="volleyball" aria-selected="false">Volleyball</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="basketball-tab" data-toggle="tab" href="#basketball" role="tab" aria-controls="basketball" aria-selected="false">Basketball</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="handball-tab" data-toggle="tab" href="#handball" role="tab" aria-controls="handball" aria-selected="false">Handball</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="cybersport-tab" data-toggle="tab" href="#cybersport" role="tab" aria-controls="cybersport" aria-selected="false">Cybersport</a>
    </li>
</ul>



<table class="table table-condensed center-table-class" id="events-table" >

</table>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../script/ChangeSportType.js"></script>
<script type="text/javascript" src="../script/UpdateTable.js"></script>


</body>
</html>
