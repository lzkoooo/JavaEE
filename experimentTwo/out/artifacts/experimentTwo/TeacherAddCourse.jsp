<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/10/22
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>

<html>
<head>
    <title>AddCourse</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/TeacherAddCourse.css">
</head>
<body>
<div class="back">
    <form action="CourseInformationServlet" method="post">
        <fieldset>
            <legend>添加课程</legend>
            <div class="div-input">
                <div class="inputbox first">
                    <label for="cidInput">课程编号：</label>
                    <input type="text" name="cid" class="input" id="cidInput">
                </div>
                <div class="inputbox second">
                    <label for="nameInput">课程名称：</label>
                    <input type="text" name="name" class="input" id="nameInput">
                </div>
                <div class="inputbox third">
                    <label for="maxInput">最大选课人数：</label>
                    <input type="number" min="0" step="1" name="max" class="input" id="maxInput">
                </div>
                <input type="hidden" name="function" value="AddCourse">
            </div>
            <div class="area-button">

                <input type="submit" formaction="TeacherHomePage" class="button" value="回到首页">
                <input type="reset" class="button" value="重置">
                <input type="submit" class="button" value="提交">
            </div>
        </fieldset>
    </form>
</div>
<div class="second"></div>
</body>
</html>

