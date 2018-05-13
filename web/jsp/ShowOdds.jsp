<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="local.stakeTypes.W1" var="W1"/>
    <fmt:message key="local.stakeTypes.W2" var="W2"/>
    <fmt:message key="local.stakeTypes.X" var="X"/>
    <fmt:message key="local.stakeTypes.1X" var="X1"/>
    <fmt:message key="local.stakeTypes.2X" var="X2"/>
    <fmt:message key="local.stakeTypes.12" var="NOTX"/>
    <fmt:message key="local.stakeTypes.TM" var="TM"/>
    <fmt:message key="local.stakeTypes.TL" var="TL"/>
    <fmt:message key="local.stakeTypes.F1" var="F1"/>
    <fmt:message key="local.stakeTypes.F2" var="F2"/>
</fmt:bundle>


<html>
<head>

    <title>MBet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPrefix}/css/styles.css">

</head>

<body>

    <div class="content">

        <c:if test="${sessionScope.user == null}">
            <jsp:include page="header/GuestHeader.jsp"/>
        </c:if>

        <c:if test="${sessionScope.user != null}">
            <jsp:include page="header/RegistredUserHeader.jsp">
                <jsp:param name="balance" value="${balance}"/>
            </jsp:include>
        </c:if>




        <table class="table table-condensed table-odds" id="table">
                <caption align="left" class="teams-on-odds-list"> <c:out value="${odds.getOdd(0).team1}"/><br/><c:out value="${odds.getOdd(0).team2}"/></caption>
                <tr>
                    <td>${W1}</td>
                    <td>${X}</td>
                    <td>${W2}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('W1').id}">
                            <c:out value="${odds.getOdd('W1').koef}"/>
                        </a>
                    </td>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('X').id}">
                            <c:out value="${odds.getOdd('X').koef}"/>
                        </a>
                    </td>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('W2').id}">
                            <c:out value="${odds.getOdd('W2').koef}"/>
                        </a>
                    </td>
                </tr>

                <tr>
                    <td colspan="3" bgcolor="#d3d3d3"></td>
                </tr>

                <tr>
                    <td>${X1}</td>
                    <td>${NOTX}</td>
                    <td>${X2}</td>
                </tr>
                <tr>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('X1').id}">
                            <c:out value="${odds.getOdd('X1').koef}"/>
                        </a>
                    </td>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('NOTX').id}">
                            <c:out value="${odds.getOdd('NOTX').koef}"/>
                        </a>
                    </td>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('X2').id}">
                            <c:out value="${odds.getOdd('X2').koef}"/>
                        </a>
                    </td>
                </tr>

                <tr>
                    <td colspan="3" bgcolor="#d3d3d3"></td>
                </tr>

                <tr>
                    <td><p>${TM}  <c:out value="${odds.getOdd('TM').param}"/> </p></td>
                    <td></td>
                    <td><p>${TL} <c:out value="${odds.getOdd('TL').param}"/> </p></td>
                </tr>
                <tr>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('TM').id}">
                            <c:out value="${odds.getOdd('TM').koef}"/>
                        </a>
                    </td>
                    <td></td>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('TL').id}">
                            <c:out value="${odds.getOdd('TL').koef}"/>
                        </a>
                    </td>
                </tr>

                <tr>
                    <td colspan="3" bgcolor="#d3d3d3"></td>
                </tr>

                <tr>
                    <td><p>${F1}  <c:out value="${odds.getOdd('F1').param}"/> </p></td>
                    <td></td>
                    <td><p>${F2}  <c:out value="${odds.getOdd('F2').param}"/> </p></td>
                </tr>
                <tr>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('F1').id}">
                            <c:out value="${odds.getOdd('F1').koef}"/>
                        </a>
                    </td>
                    <td></td>
                    <td>
                        <a href="${urlPrefix}/MishaBet?command=goToCreateStakePage&oddId=${odds.getOdd('F2').id}">
                            <c:out value="${odds.getOdd('F2').koef}"/>
                        </a>
                    </td>
                </tr>

        </table>

    </div>

    <jsp:include page="footer/Footer.jsp"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
