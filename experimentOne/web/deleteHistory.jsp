<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/6
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
  <jsp:useBean id="bean" class="bean.ConversionBean"/>
  <div align="center">
    <% bean.deleteHistory((String) session.getAttribute("userName")); %>
    <p>清除成功</p>
    <a href="homePage.jsp"><button type="button">返回主页面</button></a>
  </div>

</body>
</html>
