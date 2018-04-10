<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



    <thead class="table-thead">
    <tr>
        <th>Time</th>
        <th>Team1</th>
        <th>Team2</th>
    </tr>
    </thead>
    <tbody class="table-body-class">

        <c:forEach var="i" begin="0" end="${events.size() - 1}" step="1">
            <tr onclick="window.location.href='/MishaBet?command=showOdds&eventId='+${events.get(i).id};
                return false" class="clickable-row">
            <td><c:out value="${events.get(i).startTime}"/></td>
            <td><c:out value="${events.get(i).team1}"/></td>
            <td><c:out value="${events.get(i).team2}"/></td>
            </tr>
        </c:forEach>

    </tbody>





