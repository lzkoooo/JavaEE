<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/9/28
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
    <head><title>用户登录提交页面</title></head>
    <body>
        <form  action="Verify_Servlet" method="post">
            用  户  名：<input type="text" name="xm"><br><br>
            用户密码：<input type="password" name="mm"><br><br>
            <input type="submit" value="登录">
        </form>
    </body>
</html>