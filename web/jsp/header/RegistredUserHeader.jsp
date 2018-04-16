<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/styles.css">
<html>
<head>
    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-default nav-class">
    <div class="container-fluid">
        <div class="navbar-header icon-class">
            <a href="/MishaBet">
                MBET
            </a>
        </div>
        <ul class="nav navbar-nav nav-rigth-class">
            <li><a href="#">Settings</a></li>
            <li>
                <a href="/MishaBet?command=showStakes&page=1">Account history</a>
            </li>
            <li>
                <a href="/MishaBet?command=goToDepositWithdrawPage">Deposit/Withdraw</a>
            </li>
            <li><p><c:out value="${sessionScope.user.name}"/>
                    Account number:<c:out value="${sessionScope.user.id}"/>
                    <br/>Balance : <c:out value="${balance}"/></p></li>
            <li>
    <a href="/MishaBet?command=logout">Logout</a></li>
        </ul>
    </div>
</nav>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>
</html>
