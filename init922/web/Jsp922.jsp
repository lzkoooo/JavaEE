<%--
  Created by IntelliJ IDEA.
  User: 16240
  Date: 2022/9/22
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding = "utf-8" %>
<style>
    #textStyle{
        font-family:宋体;font-size:36;color:blue
    }
</style>
<HTML>
    <body bgcolor=#ffccff>
        <form action="sumORproduct" id =textStyle method=post>
            输入数字，用逗号分隔提交给servlet(post方式)：
            <br><input type=text id =textStyle name="number"/>
            <input type=submit id =textStyle value="提交">
        </form>
        <form action="sumORproduct" id =textStyle method=get>
            输入数字，用逗号分隔提交给servlet(get方式)：
            <br><input type=text id =textStyle name="number"/>
            <input type=submit id =textStyle value="提交"/>
        </form>
    </body>
</HTML>
