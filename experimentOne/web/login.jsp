<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/3
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div align="center">
        <h2>欢迎来到登录页面！</h2>
        <form action="loginResult.jsp" method="post">
            <p>
                <label for="username">在此处输入账号</label>
                <input id="username" name="userName" type="text">
            </p>
            <p>
                <label for="password">在此处输入密码</label>
                <input id="password" name="password" type="password">
            </p>
            <p>
                <input type="submit" value="登录">
                <input type="reset" value="清除">
                <a href="register.jsp"><button type="button">注册</button></a>
            </p>
        </form>
    </div>
</body>
</html>
