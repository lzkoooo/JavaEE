<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/9/26
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
    <head>  <title>利用Servlet+JSP求两数和及连接串的显示页面</title> </head>

    <body>
        <%
            String s1=request.getParameter("shuju1");
            String s2=request.getParameter("shuju2");
            Integer sum=(Integer)request.getAttribute("sum");
        %>
        <p> <%=s1%> 加到<%= s2%>的和值是: <%=sum%> </p>
        <p> 现在的时间是: <%= new Date() %> </p>
    </body>
</html>
