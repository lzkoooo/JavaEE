<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/9/26
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
    <head>  <title>提交任意2个整数给Servlet的JSP页面</title> </head>

    <body>
        <h3> 按下列格式要求，输入两个数据：</h3><br>
        <form action="ServletOne" method="post">
            开始数据1：<input name="shuju1"><br><br>
            结束数据2：<input name="shuju2"><br><br>
            <input type=submit  value="提交">
        </form>
    </body>
</html>
