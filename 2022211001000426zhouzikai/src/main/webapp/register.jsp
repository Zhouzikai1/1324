<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <%@ include file="header.jsp"%>
    <style>
        #registeredUsersTable {
            width: 100%;
            overflow-x: auto;
        }
        #registeredUsersTable table {
            width: 100%;
            border-collapse: collapse;
        }
    </style>
    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<body>


<h2>用户注册表单</h2>
<form action="<%=request.getContextPath()%>/register" method="post">
    <label for="id">学号：</label>
    <input type="text" name="id" id="id" required>
    <br>

    <label for="username">用户名：</label>
    <input type="text" name="username" id="username" required>
    <br>

    <label for="password">密码：</label>
    <input type="password" name="password" id="password" required>
    <br>

    <label for="email">邮箱：</label>
    <input type="email" name="email" id="email" required>
    <br>

    <label for="gender">性别：</label>
    <select name="gender" id="gender" required>
        <option value="">请选择性别</option>
        <option value="male">男</option>
        <option value="female">女</option>
    </select>
    <br>

    <label for="birthdate">出生日期（格式：YYYY-MM-DD）：</label>
    <input type="text" name="birthdate" id="birthdate" required>
    <br>

    <input type="submit" value="注册">
    <%@ include file="footer.jsp"%>
</form>

</body>
</html>