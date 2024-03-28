<%@ page import="java.util.List" %>
<%@page import="Zhouzikai.week3.demo.emp" %>
<!-- WEEK 5 -->
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024/3/28
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有用户信息</title>
</head>
<body>
<table border="1" bordercolor="#000000">
    <caption>users information</caption>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birthdate</th>
    </tr>


    <%
        List<emp> list=(List<emp>) request.getAttribute("list");
        if(list==null|| list.isEmpty()){
            System.out.print("没有信息！");
        }else {
            for(emp info:list){

    %>
    <tr>
        <td><%=info.getId()%></td>
        <td><%=info.getUsername()%></td>
        <td><%=info.getPassword()%></td>
        <td><%=info.getEmail()%></td>
        <td><%=info.getGender()%></td>
        <td><%=info.getUserbirth()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>