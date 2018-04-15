<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

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
                       <th>Event</th>
                       <th>Outcome</th>
                       <th>Coefficient</th>
                       <th>Money</th>
                   </tr>

                </thead>
                <tbody class="table-body-class">

                    <tr>

                        <td> <c:out value="${oddInfo}"/> </td>
                        <td> <c:out value="${oddOutcome}"/></td>
                        <td> <c:out value="${coef}"/></td>
                        <td>
                            <form action="/MishaBet" method="post">
                                <input type="number" required="required" name="money" value=""/>
                                <input type="hidden" name="command" value="createStake"/>
                                <input type="hidden" name="oddId" value="${oddId}"/>
                                <button type="submit" class="btn btn-primary">Make bet</button>
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
