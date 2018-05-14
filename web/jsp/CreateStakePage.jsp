<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="local.createStake.event" var="event"/>
    <fmt:message key="local.createStake.outcome" var="outcome"/>
    <fmt:message key="local.createStake.coef" var="coefficient"/>
    <fmt:message key="local.createStake.money" var="money"/>
    <fmt:message key="local.createStake.makeBet" var="makeBet"/>
    <fmt:message key="local.createStake.smallBalance" var="smallBalanceAlert"/>
</fmt:bundle>

<html>

    <head>
        <title>MBET</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="${urlPrefix}/css/styles.css">
    </head>


    <body>

        <div class="content">

            <jsp:include page="header/RegistredUserHeader.jsp">
                <jsp:param value="${balance}" name="balance"/>
            </jsp:include>


            <table class="table table-condensed center-table-class">

                <thead class="table-thead">

                   <tr>
                       <th>${event}</th>
                       <th>${outcome}</th>
                       <th>${coefficient}</th>
                       <th>${money}</th>
                   </tr>

                </thead>
                <tbody class="table-body-class">

                    <tr>

                        <td> <c:out value="${oddInfo}"/> </td>
                        <td> <c:out value="${oddOutcome}"/></td>
                        <td> <c:out value="${coef}"/></td>
                        <td>
                            <form action="${urlPrefix}/MishaBet" method="post">
                                <input required pattern="\d+(\.\d{0,2})?" name="money" value=""/>
                                <c:if test="${sessionScope.smallBalance == true}">
                                    <p style="color: #fc2a2a; font-size: 14px">${smallBalanceAlert}</p>
                                </c:if>
                                <input type="hidden" name="command" value="createStake"/>
                                <input type="hidden" name="oddId" value="${oddId}"/>
                                <button type="submit" class="btn btn-primary">${makeBet}</button>
                            </form>
                        </td>

                    </tr>

                </tbody>

            </table>


        </div>

        <jsp:include page="footer/Footer.jsp"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </body>


</html>
