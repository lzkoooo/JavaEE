<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/20
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>

<html>
<head>
    <title>ChooseClass</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Choose.css">
</head>
<body>
    <div class="first">
        <form action="ChooseServlet" name="chooseClasses" method="post">
            <fieldset>
                <legend>可选课程</legend>
                <table cellspacing="0">
                    <thead>
                        <tr class="title">
                            <td>
                                选择框
                            </td>
                            <td>
                                课程名称
                            </td>
                            <td>
                                授课教师名称
                            </td>
                            <td>
                                已选课人数
                            </td>
                            <td class="right">
                                最大选课人数
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String[] cid ;
                            String[] classes ;
                            String[] teachers ;
                            int[] choose ;
                            int[] max ;
                            int i = 0;


                            cid = Arrays.copyOf((String[]) request.getAttribute("cid"), 100);
                            classes = Arrays.copyOf((String[]) request.getAttribute("classes"), 100);
                            teachers = Arrays.copyOf((String[]) request.getAttribute("teachers"), 100);
                            choose = Arrays.copyOf((int[]) request.getAttribute("choose"), 100);
                            max = Arrays.copyOf((int[]) request.getAttribute("max"), 100);

                            while(classes[i] != null)
                            {
                                out.print("<tr>");

                                out.print("<td class=\"td-checkitem\">");
                                out.print("<input type=\"checkbox\" name=\"choose\" value=\"" + cid[i] + "\" class=\"checkitem\" id=\"checkbox" + i + "\">");
                                out.print("<label for=\"checkbox" + i + "\"> ");
                                out.print("</label>");
                                out.print("</td>");

                                out.print("<td class=\"td-text class-name\">");
                                out.print("" + classes[i]);
                                out.print("</td>");

                                out.print("<td class=\"td-text teacher-name\">");
                                out.print("" + teachers[i]);
                                out.print("</td>");

                                out.print("<td class=\"td-text choose-number\">");
                                out.print("" + choose[i]);
                                out.print("</td>");

                                out.print("<td class=\"td-text max-number right\">");
                                out.print("" + max[i]);
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
            </fieldset>

        </form>
    </div>
    <div class="second"></div>
</body>
</html>
