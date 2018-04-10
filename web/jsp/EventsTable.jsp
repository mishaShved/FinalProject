<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

<html>
<head>
    <title>Title</title>
</head>
<body>

<ul class="nav nav-tabs nav-tabs-center" id="sport-type" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" id="football-tab" data-toggle="tab" href="#football" role="tab" aria-controls="football" aria-selected="true">Football</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="hockey-tab" data-toggle="tab" href="#hockey" role="tab" aria-controls="hockey" aria-selected="false">Ice Hockey</a>
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

<%--<div class="tab-content">--%>
<%--<div class="tab-pane active" id="football" role="tabpanel" aria-labelledby="football-tab">1</div>--%>
<%--<div class="tab-pane" id="hockey" role="tabpanel" aria-labelledby="hockey-tab">2</div>--%>
<%--<div class="tab-pane" id="tennis" role="tabpanel" aria-labelledby="tennis-tab">3</div>--%>
<%--<div class="tab-pane" id="volleyball" role="tabpanel" aria-labelledby="volleyball-tab">4</div>--%>
<%--<div class="tab-pane" id="basketball" role="tabpanel" aria-labelledby="basketball-tab">3</div>--%>
<%--<div class="tab-pane" id="handball" role="tabpanel" aria-labelledby="handball-tab">4</div>--%>
<%--<div class="tab-pane" id="cybersport" role="tabpanel" aria-labelledby="cybersport-tab">4</div>--%>
<%--</div>--%>


<table class="table table-condensed center-table-class">
    <thead class="table-thead">
    <tr>
        <th>Event</th>
        <th>1</th>
        <th>X</th>
        <th>2</th>
    </tr>
    </thead>
    <tbody class="table-body-class">
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    <tr>
        <td>NaVi VP</td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
        <td><a href="#">2.3</a></td>
    </tr>
    </tbody>
</table>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../script/ChangeSportType.js"></script>
<script type="text/javascript" src="../script/UpdateTable.js"></script>

</body>
</html>
