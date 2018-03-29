<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach var="i" begin="0" end="${stackes.size() - 1}">


    <c:out value="${stackes.get(i).sportType}"/>

    <br/>

    <c:out value="${stackes.get(i).team1}"/>
    <c:out value="${stackes.get(i).team2}"/>

    <br/>

    <c:out value="${stackes.get(i).betSum}"/>
    <c:out value="${stackes.get(i).koef}"/>

    <br/>

    <c:out value="${stackes.get(i).stakeType}"/> <c:out value="${stackes.get(i).param}"/>

    <c:if test="${stackes.get(i).score1 != -1}">
        <c:out value="${stackes.get(i).score1}"/> :  <c:out value="${stackes.get(i).score2}"/>
    </c:if>



    <c:if test="${stackes.get(i).score1 == -1}">
        processing...
    </c:if>
    <c:if test="${stackes.get(i).score1 != -1 && stackes.get(i).isWon() == true}">
        Won <c:out value="${stackes.get(i).betSum * stackes.get(i).koef}"/>
    </c:if>
    <c:if test="${stackes.get(i).score1 != -1 && stackes.get(i).isWon() == false}">
        Lost
    </c:if>

    <br/>
    <br/>

</c:forEach>

</body>
</html>
