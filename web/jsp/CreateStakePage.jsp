<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

<fmt:bundle basename="locale">
    <fmt:message key="local.createStake.event" var="event"/>
    <fmt:message key="local.createStake.outcome" var="outcome"/>
    <fmt:message key="local.createStake.coef" var="coef"/>
    <fmt:message key="local.createStake.money" var="money"/>
    <fmt:message key="local.createStake.makeBet" var="makeBet"/>
</fmt:bundle>

<html>

    <head>
        <title>MBET</title>
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
                       <th>${coef}</th>
                       <th>${money}</th>
                   </tr>

                </thead>
                <tbody class="table-body-class">

                    <tr>

                        <td> <c:out value="${oddInfo}"/> </td>
                        <td> <c:out value="${oddOutcome}"/></td>
                        <td> <c:out value="${coef}"/></td>
                        <td>
                            <form action="/MishaBet" method="post">
                                <input required pattern="\d+(\.\d{0,2})?" name="money" value=""/>
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
