<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="header.jsp"%>
    <title>User Information Page</title>
</head>
<body>
<h1>Welcome, <%= session.getAttribute("loggedInUser") %>!</h1>
<p>This is the user information page where you can show more details about the logged-in user.</p>

<table>
    <tr>
        <th>Email</th>
        <td><%= (String) session.getAttribute("userEmail") %></td>
    </tr>
    <tr>
        <th>Gender</th>
        <td><%= (String) session.getAttribute("userGender") %></td>
    </tr>

    <td><%= (String) session.getAttribute("userBirthdate") %></td>
    </tr> -->
</table>

<%@ include file="footer.jsp"%>
</body>
</html>