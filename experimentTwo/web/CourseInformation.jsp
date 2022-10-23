<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/22
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>

<html>
<head>
  <title>ChooseClassResult</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Choose.css">
</head>
<body>
  <div class="first">
    <form>
      <fieldset>
        <legend>课程信息</legend>
        <table cellspacing="0">
            <thead>
              <tr class="title">
                <td>
                  课程名称
                </td>
                <td>
                  授课教师名称
                </td>
              </tr>
          </thead>
          <tbody>
            <%
              String[] classes ;
              String[] teachers ;
              int i = 0;


              classes = Arrays.copyOf((String[]) request.getAttribute("classes"), 100);
              teachers = Arrays.copyOf((String[]) request.getAttribute("teachers"), 100);

              while(classes[i] != null)
              {
                out.print("<tr>");

                out.print("<td class=\"td-text class-name\">");
                out.print("" + classes[i]);
                out.print("</td>");

                out.print("<td class=\"td-text teacher-name\">");
                out.print("" + teachers[i]);
                out.print("</td>");

                out.print("</tr>");
                i++;
              }
            %>
            </tbody>
        </table>
        <div class="area-button">
          <a href="${pageContext.request.contextPath}/StudentHomePage.jsp"  class="button" id="a">返回首页</a>
        </div>
      </fieldset>
    </form>
  </div>
</body>
</html>
