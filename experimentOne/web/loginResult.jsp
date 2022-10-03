<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/3
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Result</title>
</head>
<body>
    <jsp:useBean id="login" class="bean.LoginBean"/>
    <jsp:setProperty name="login" property="*"/>
    <div align="center">
        <h3>登录结果页面</h3><br>

        <%
            if(login.getLoginResult())
        {
            session.setAttribute("userName", login.getUserName());
            request.setAttribute("userName", login.getUserName());
        %>
            <p>恭喜你！登录成功！</p>
            <a href="homePage.jsp"><button type="button" name="conversion">开始使用功能</button></a>
        <%
        }
            else
        {
        %>
            <p>抱歉！登录失败！</p>
            <a href="login.jsp"><button type="button" name="conversion">返回登录页面</button></a>
        <%
        }
        %>
    </div>
</body>
</html>
