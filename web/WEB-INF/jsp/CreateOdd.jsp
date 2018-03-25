<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

spisok oddov
spisok var stavok


    <form action="/MishaBet" method="post">

        <select name="oddType">

            <c:forEach var="i" begin="0" end="${oddTypesCount}">
                <option value="${oddTypes[i]}">
                    <c:out value="${oddTypes[i]}"/>
                </option>
            </c:forEach>

        </select>

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

        <input type="text" name="koef" value="">

        <input type="text" name="param" value="">

        <input type="hidden" name="command" value="createOdd">

        <input type="submit" value="Create">

    </form>


</body>
</html>
