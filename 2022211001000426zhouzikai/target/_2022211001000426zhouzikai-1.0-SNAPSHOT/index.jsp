<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="header.jsp"%>
  <title>JSP - Hello World</title>
</head>
<body>

<h1><%= "Welcome to my home page" %></h1>
<form method="get" action="${pageContext.request.contextPath}/search" target="_blank">
  <label>
    <input type="text" name="txt" size="30">
    Choose your search engine:
    <select name="search">
      <option value="baidu">Baidu</option>
      <option value="bing">Bing</option>
      <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
  </label>
</form>
<br/>
<a href="hello-servlet">Hello Servlet week1</a>
<br/>
<a href="hello-world">Student Info Servlet-week2</a>
<br/>
<a href="life">Hello Servlet week3</a>
<br/>
<a href="register.jsp">Register-getParameter-week3</a>
<br/>
<a href="config">config parameter-week4</a>
<br/>
<a href="register.jsp">Register JDBC -week4</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="Login.jsp">Login-week5</a>
<%@ include file="footer.jsp"%>
</body>
</html>