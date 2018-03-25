<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border ="1">
    <tr>
        <td>Id</td>
        <td>Time</td>
        <td>Team1</td>
        <td>Team2</td>
        <td>Sport</td>
    </tr>
    <c:forEach var="i" begin="0" end="${events.size() - 1}" step="1">

            <tr>
                <td><c:out value="${events.get(i).id}"/> </td>
                <td><c:out value="${events.get(i).startTime}"/></td>
                <td><c:out value="${events.get(i).team1}"/></td>
                <td><c:out value="${events.get(i).team2}"/></td>
                <td><c:out value="${events.get(i).sportType}"/></td>
                <td>
                    <form action="/MishaBet" method="post">
                        <input type="hidden" name="eventId" value="${events.get(i).id}">
                        <input type="hidden" name="command" value="showOdds">
                        <input type="submit" value="showOdds">
                    </form>
            </tr>


    </c:forEach>


</table>

</body>
</html>
