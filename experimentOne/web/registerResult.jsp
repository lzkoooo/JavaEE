<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/3
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="register" class="bean.LoginBean"/>
<jsp:setProperty name="register" property="*"/>
<html>
<head>
    <title>Login Result</title>
</head>
<body>
<div align="center">
    <h3>注册结果页面</h3><br>

    <%
        if(register.getRegisterResult())
        {
            session.setAttribute("userName", register.getUserName());
            request.setAttribute("userName", register.getUserName());
    %>
    <p>恭喜你注册成功</p>
    <a href="homePage.jsp"><button type="button" name="conversion">开始使用功能</button></a>
    <%
    }
    else
    {
    %>
    <p>抱歉，注册失败</p>
    <a href="login.jsp"><button type="button" name="conversion">返回注册页面</button></a>
    <%
    }
    %>
</div>
</body>
</html>
