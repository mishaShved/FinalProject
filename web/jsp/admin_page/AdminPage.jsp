<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/styles.css">


<html>
<head>
    <title>MBet</title>
</head>
<body>

    <div class="content">

        <jsp:include page="../header/AdminHeader.jsp"/>

        <div class="admin-choice">

            <form action="/MishaBet" method="get">
                <input type="hidden" name="command" value="goToSetScorePage">
                <input type="submit" value="Set score">
            </form>

            <form action="/MishaBet" method="get">

                <input type="hidden" name="command" value="goToCreateOddPage">
                <input type="submit" value="Create Odd">

            </form>

            <form action="/MishaBet" method="get">

                <input type="hidden" name="command" value="goToCreateEventPage">
                <input type="submit" value="Create Event">

            </form>
        </div>
    </div>

    <jsp:include page="../footer/Footer.jsp"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
