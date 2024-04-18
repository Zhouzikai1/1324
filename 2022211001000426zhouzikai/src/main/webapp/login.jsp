<%--
  Created by IntelliJ IDEA.
  User: MR
  Date: 2024/4/6
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="header.jsp"%>
  <title>Login Page</title>
</head>
<body>
<% String loginMessage = (String) request.getAttribute("loginMessage"); %>
<% if (loginMessage != null) { %>
<div style="margin: auto; text-align: center; padding: 20px;">
  <%= loginMessage %>
</div>
<% } %>

<form action="${pageContext.request.contextPath}/login" method="post">
  <label for="username">Username:</label>
  <input type="text" name="username" id="username" required>
  <br>
  <label for="password">Password:</label>
  <input type="password" name="password" id="password" required>
  <br>
  <input type="submit" value="login">
</form>

<%@ include file="footer.jsp"%>
</body>
</html>