<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/23
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>ChooseClass</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Choose.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Person.css">
</head>
<body>
<div class="first">
  <form action="PersonServlet" name="chooseClasses" method="post">
    <fieldset>
      <legend>可选课程</legend>
      <table cellspacing="0">
        <thead>
        <tr class="title">
          <td>
            选择框
          </td>
          <td>
            选择项目
          </td>
          <td class="right">
            修改后的值
          </td>
        </tr>
        </thead>
        <tbody>
        <%
          int i = 0;
          String[] str;
          String[] str2;

          if(session.getAttribute("status").equals("student"))
          {
            str = new String[]{"name", "gender", "class", "major", "password"};
            str2 = new String[]{"姓名", "性别", "班级", "专业", "密码"};
          }
          else
          {
            str = new String[]{"name", "gender", "college", "title", "password"};
            str2 = new String[]{"姓名", "性别", "学院", "职称","密码"};
          }

          while(i < 5)
          {
            out.print("<tr>");
            //复选框
            out.print("<td class=\"td-checkitem\">");
            out.print("<input type=\"checkbox\" name=\"choose\" value=\"" + str[i] + "\" class=\"checkitem\" id=\"checkbox" + i + "\">");
            out.print("<label for=\"checkbox" + i + "\"> ");
            out.print("</label>");
            out.print("</td>");
            //修改项目名
            out.print("<td class=\"td-text class-name\">");
            out.print("" + str2[i]);
            out.print("</td>");
            //修改框
            out.print("<td class=\"td-text max-number right\">");
            out.print("<input type=\"text\" name=\"input\" class=\"inputbox\">");
            out.print("</td>");

            out.print("</tr>");
            i++;
          }
        %>
        </tbody>
      </table>
      <div class="area-button">
        <input type="submit" class="button" value="回到首页">
        <input type="reset" class="button" value="重置">
        <input type="submit" class="button" value="提交">
      </div>
      <input type="hidden" name="function" value="修改个人信息">
    </fieldset>
  </form>
</div>
<div class="second"></div>
</body>
</html>
