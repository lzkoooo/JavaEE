<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/9/29
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    if(session.getAttribute("userName") == null)
    {
%>
        <jsp:forward page="login.jsp"/>
<%
    }
%>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <div align="center">
        <form action = "show.jsp">
            <h2>欢迎来到进制转换页面！</h2><br>
            在此处输入数据：<input type="text" name="numBefore">
            <p>
                <input type="radio" name="numSystem" id="twoToTen" value="二进制转十进制" checked>
                <label for="twoToTen">二进制转十进制</label>

                <input type="radio" name="numSystem" id="tenToTwo" value="十进制转二进制">
                <label for="tenToTwo">十进制转二进制</label>
            </p>
            <p>
                <input type="submit" name="submit" value="提交">
                <input type="reset" name="clear" value="清除">
                <a href="viewHistory.jsp"><button type="button" name="viewHistory">查看历史记录</button></a>
            </p>
        </form>
    </div>

</body>
</html>
