<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Your balance = <c:out value="${balance}"/>
you = <c:out value="${sessionScope.user.name}"/>
<form action="/MishaBet" method="post">

    <input type="hidden" name="command" value="deposit">
    <input type="number" name="value" value="">
    <input type="submit" value="Deposit">

</form>

<form action="/MishaBet" method="post">

    <input type="hidden" name="command" value="withdraw">
    <input type="number" name="value" value="">
    <input type="submit" value="Withdraw">

</form>

<form action="/MishaBet" method="post">

    <input type="hidden" name="command" value="createEvent">
    <input type="date" name="date" value="">
    <input type="time" name="time" value="00:00">
    <input type="submit" value="create">

    <select name="sport">
        <option value="HOCKEY">
            HOCKEY
        </option>
        <option value="FOOTBALL">
            FOOTBALL
        </option>
        <option value="BASKETBALL">
            BASKETBALL
        </option>
        <option value="VOLLEYBALL">
            VOLLEYBALL
        </option>
        <option value="TENNIS">
            TENNIS
        </option>
        <option value="CYBERSPORT">
            CYBERSPORT
        </option>
        <option value="HANDBALL">
            HANDBALL
        </option>


    </select>

    <\br>
    <input type="text" name="team1" value="">
    <input type="text" name="team2" value="">

</form>

<form action="/MishaBet" method="post">

    <input type="hidden" name="command" value="showEvents">
    <input type="submit" value="Show Events">

</form>

<form action="/MishaBet" method="post">

    <input type="hidden" name="command" value="showEventsBySport">

    <select name="sportType">
        <option value="HOCKEY">
            HOCKEY
        </option>
        <option value="FOOTBALL">
            FOOTBALL
        </option>
        <option value="BASKETBALL">
            BASKETBALL
        </option>
        <option value="VOLLEYBALL">
            VOLLEYBALL
        </option>
        <option value="TENNIS">
            TENNIS
        </option>
        <option value="CYBERSPORT">
            CYBERSPORT
        </option>
        <option value="HANDBALL">
            HANDBALL
        </option>


    </select>

    <input type="submit" value="Show Events">

</form>



</body>
</html>
