<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form action="/MishaBet" method="post">

        <select name="eventId">

            <c:forEach var="i" begin="0" end="${eventsList.size() - 1}">
                <option value="${eventsList.get(i).id}">
                    <c:out value="${eventsList.get(i).team1}"/> vs <c:out value="${eventsList.get(i).team2}"/>
                    <br/>
                    <c:out value="${eventsList.get(i).startTime}"/>
                    <br/>
                    <c:out value="${eventsList.get(i).sportType.name()}"/>
                    <br/>
                </option>
            </c:forEach>

        </select>


        score 1  - <input type="number" name="score1" value="">
        score 2  - <input type="number" name="score2" value="">
        <input type="hidden" name="command" value="setScore">
        <input type="submit" value="eee">

    </form>

</body>
</html>
