<%--
  Created by IntelliJ IDEA.
  User: 12526
  Date: 2022/10/11
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" %>
<html>
<head>
  <title>JSP+JavaBean实例</title>
  <link rel="stylesheet" href="./view_style.css">
</head>
<body>
  <div>
    <jsp:useBean id="DB" class="bean.Conn" />
    <%
      Connection conn = DB.getConn();
      Statement stmt = DB.getStatement(conn);
      ResultSet rs = DB.getResultSet(stmt,"select * from users");
      try{
        out.println("<table cellspacing=0;>");
        out.println("<tbody>");
        while(rs.next())
        {
          out.println("<tr>");
          out.println("<td>"+rs.getInt("sno")+"</td>");
          out.println("<td>"+rs.getString("name")+"</td>");
          out.println("<td>"+rs.getString("score")+"</td>");
          out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
      }catch (SQLException e){
        e.printStackTrace();
      }finally {
        DB.close(conn);
        DB.close(stmt);
        DB.close(rs);
      }
    %>
  </div>
</body>
</html>