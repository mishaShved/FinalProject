<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="local.startPage.time" var="time"/>
    <fmt:message key="local.startPage.team1" var="team1"/>
    <fmt:message key="local.startPage.team2" var="team2"/>
</fmt:bundle>


    <thead class="table-thead">
    <tr>
        <th width="60%">${time}</th>
        <th width="20%">${team1}</th>
        <th width="20%">${team2}</th>
    </tr>
    </thead>
    <tbody class="table-body-class">

        <c:if test="${events.size() > 0}">

        <c:forEach var="i" begin="0" end="${events.size() - 1}" step="1">
            <tr onclick="window.location.href='${urlPrefix}/MishaBet?command=showOdds&eventId='+${events.get(i).id};
                return false" class="clickable-row">
            <td><c:out value="${events.get(i).startTime}"/></td>
            <td><c:out value="${events.get(i).team1}"/></td>
            <td><c:out value="${events.get(i).team2}"/></td>
            </tr>
        </c:forEach>

        </c:if>

    </tbody>





