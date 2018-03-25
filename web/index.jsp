<%@ page import="by.tc.epam.model.dao.impl.UserDAOImpl" %>
<%@ page import="by.tc.epam.model.dao.exception.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>MishaBet</title>
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




  </body>
</html>
