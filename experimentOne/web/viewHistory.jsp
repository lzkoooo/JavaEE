<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/2
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>

<html>
<head>
    <title>History</title>
</head>
<body>
    <h3>历史查询记录页面</h3>
    <jsp:useBean id="history" class="bean.ViewHistoryBean"/>
    <jsp:setProperty name="history" property="userName" value=<%session.getAttribute("userName")%>/>
    <%
        ResultSet rs;
        rs = history.getHistory();
        out.println(session.getAttribute("userName") + "的历史转换记录:");
        out.println("查询数据          查询操作           查询结果");
        try
        {
            while (rs.next())
            {
                out.print(rs.getString("inputNumber"));
                out.print("          ");
                out.print(rs.getString("operate"));
                out.print("          ");
                out.print(rs.getString("result"));
                out.println();
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    %>
</body>
</html>
