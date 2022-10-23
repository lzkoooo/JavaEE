<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/22
  Time: 14:16
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

              if(session.getAttribute("status").equals("student"))
              {
                  String[] result = (String[]) request.getAttribute("result");
                  if(result[0].equals("0"))
                      out.print("<span>选课失败！！！</span>");
                  else
                  {
                      out.print("<span>选课成功！！！</span>");
                      out.print("<span>共选上 " + result[0] + " 门课程!</span>");
                      out.print("<span>选课列表：</span>");
                      for(int i = 1; i <= parseInt(result[0], 10); i++)
                          out.print("<span>" + result[i] + "</span>");
                  }
              }
              else if(session.getAttribute("status").equals("teacher"))
              {
                  if (request.getAttribute("id1").equals("[][]"))
                  {
                      int i = 0;
                      String[][] result = (String[][]) request.getAttribute("result");
                      out.print("<span>选课学生信息：</span>");
                      out.print("<table>");
                      out.print("<thead>");
                      out.print("</thead>");
                      out.print("<tbody>");
                      while(result[i][0] != null)
                      {
                          out.print("<tr>");

                          out.print("<td>");
                          out.print("" + result[i][0]);
                          out.print("<td>");

                          out.print("<td>");
                          out.print("" + result[i][1]);
                          out.print("<td>");

                          out.print("<td>");
                          out.print("" + result[i][2]);
                          out.print("<td>");

                          out.print("<td>");
                          out.print("" + result[i][3]);
                          out.print("<td>");

                          out.print("<td>");
                          out.print("" + result[i][4]);
                          out.print("<td>");

                          out.print("</tr>");
                          i++;
                      }
                      out.print("</tbody>");
                      out.print("</table>");
                  }
                  else
                  {
                      String[] result = (String[]) request.getAttribute("result");
                      if(result[0].equals("0"))
                          out.print("<span>添加课程失败！！！</span>");
                      else
                      {
                          out.print("<span>添加课程成功！！！</span>");
                          out.print("<span>共添加 " + result[0] + " 门课程!</span>");
                      }
                      out.print("<span>添加课程名称：" + result[1] + "</span>");
                  }
              }
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
