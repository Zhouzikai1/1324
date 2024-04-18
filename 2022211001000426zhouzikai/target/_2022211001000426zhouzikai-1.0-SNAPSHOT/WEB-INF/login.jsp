<%--
  Created by IntelliJ IDEA.
  User: MR
  Date: 2024/4/6
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<h1><%= "Login" %>
</h1>

<form method="post" action="login">

  UserName<input type="text" name="username"/><br/>
  Password<input type="password" name="password"/><br/>

  <input type="submit" value="login"/>
</form>
<%@include file="footer.jsp" %>