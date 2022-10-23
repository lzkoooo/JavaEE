<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/23
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static java.lang.Integer.parseInt" %>

<html>
<head>
    <title>ChooseClassResult</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ChooseResult.css">
</head>
<body>
<section>
    <div class="back">
        <div class="text">
            <%
                    String[] result = (String[]) request.getAttribute("result");

                    out.print("<span>个人信息：</span>");

                    out.print("<table>");
                    out.print("<thead>");
                    out.print("</thead>");
                    out.print("<tbody>");

                    out.print("<tr>");

                    out.print("<td>");
                    out.print("" + result[0]);
                    out.print("<td>");

                    out.print("<td>");
                    out.print("" + result[1]);
                    out.print("<td>");

                    out.print("<td>");
                    out.print("" + result[2]);
                    out.print("<td>");

                    out.print("<td>");
                    out.print("" + result[3]);
                    out.print("<td>");

                    out.print("<td>");
                    out.print("" + result[4]);
                    out.print("<td>");

                    out.print("</tr>");

                    out.print("</tbody>");
                    out.print("</table>");
            %>
        </div>
        <%
            if(session.getAttribute("status").equals("student"))
                out.print("<a href=\"/StudentHomePage.jsp\">返回首页</a>");
            else
                out.print("<a href=\"/TeacherHomePage.jsp\">返回首页</a>");
        %>

    </div>
</section>
</body>
</html>