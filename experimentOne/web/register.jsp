<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/3
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <div align="center">
        <h3>欢迎来到注册界面！</h3><br>
        <form action="registerResult.jsp" method="post">
            <p>
                <label for="username">在此处输入账号</label>
                <input id="username" name="userName" type="text">
            </p>
            <p>
                <label for="password">在此处输入密码</label>
                <input id="password" name="password" type="password">
            </p>
            <p>
                <input type="submit" value="注册">
                <input type="reset" value="清除">
            </p>
        </form>
    </div>
</body>
</html>
