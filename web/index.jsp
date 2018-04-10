<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="/css/styles.css" rel="stylesheet">
<html>
  <head>
      <title>MishaBet</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>

    <form action="/MishaBet" method="post">

        Name
        <input type="text" value="" name="name">
        <br/>
        Password
        <input type="password" value="" name="password">
        <br/>
        E-mail
        <input type="email" value="" name ="email">
        <br/>

        <input type="hidden" value="registration" name="command">
        <input type="submit" value="Зарегистрироваться">


    </form>

    <form action="/MishaBet" method="post">

        Account
        <input type="number" value="" name="id">
        <br/>
        Password
        <input type="password" value="" name="password">
        <br/>

        <input type="hidden" value="login" name="command">
        <input type="submit" value="Войти">

    </form>


    <c:redirect url="/MishaBet"/>

    <%--<c:redirect url="/jsp/StartPage.jsp"/>--%>



  </body>
</html>
