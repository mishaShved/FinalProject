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
            MBET
        </div>
        <ul class="nav navbar-nav nav-rigth-class">
            <li><a href="#">Settings</a></li>
            <li>
                <form action="/MishaBet" method="get">

                <input type="hidden" name="command" value="showStakes">
                <input type="submit" value="Show Stakes">

                </form>
            </li>
            <li>
                <form action="/MishaBet" method="get">
                    <input type="submit" value="Deposit/Withdraw">
                    <input type="hidden" name="command" value="goToDepositWithdrawPage">
                </form>
            </li>
            <li><p><c:out value="${sessionScope.user.name}"/> <br/>Balance : <c:out value="${balance}"/></p></li>
            <li><a href="#">Logout</a></li>
        </ul>
    </div>
</nav>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
