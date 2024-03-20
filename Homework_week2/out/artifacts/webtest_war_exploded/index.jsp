<%--
  Created by IntelliJ IDEA.
  User: MR
  Date: 2024/3/5
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>User Registration</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $(document).ready(function(){
      $('#registrationForm').submit(function(){
        // Perform form validation here
        var username = $('#username').val();
        var password = $('#password').val();
        var email = $('#email').val();
        var birthdate = $('#birthdate').val();

        // Perform validation checks
        // Example checks (you should add more as needed)
        if(username == ''){
          alert('Username is required.');
          return false;
        }
        if(password == ''){
          alert('Password is required.');
          return false;
        }
        // Add more validation checks for other fields

        return true; // Submit the form if all checks pass
      });
    });
  </script>
</head>
<body>
<h1>User Registration</h1>
<form id="registrationForm" action="registrationServlet" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required minlength="8"><br>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required><br>
  <form action="submitForm.jsp" method="post">
    <input type="radio" name="gender" value="male" id="male">
    <label for="male">Male</label>

    <input type="radio" name="gender" value="female" id="female">
    <label for="female">Female</label><br>


  <label for="birthdate">Birthdate (YYYY-MM-DD):</label>
  <input type="text" id="birthdate" name="birthdate" required pattern="\d{4}-\d{2}-\d{2}"><br>

  <input type="submit" value="Register">
</>
</body>
</html>