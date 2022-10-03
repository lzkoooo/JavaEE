<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/2
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Result</title>
</head>
<body>
    <jsp:useBean id="bean" class="bean.ConversionBean"/>
    <jsp:setProperty name="bean" property="*" />
    <div align="center">
        <p><%= bean.getNumBefore() %>经过<%= bean.getNumSystem() %>后的结果是：</p>
        <p>结果：<%= bean.getNumAfter((String) session.getAttribute("userName")) %></p>
        <a href="homePage.jsp"><button type="button">返回主页面</button></a>
    </div>
</body>
</html>
