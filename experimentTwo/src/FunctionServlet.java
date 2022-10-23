// @Time : 2022/10/20 17:15
// @Author : 李兆堃
// @File : FunctionServlet.java
// @Software : IntelliJ IDEA

import bean.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FunctionServlet extends HttpServlet
{
    private String function;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        function = request.getParameter("function");

        if(function.equals("修改个人信息") || function.equals("查看个人信息"))
        {
            request.getRequestDispatcher("PersonServlet").forward(request, response);
        }
        else if(session.getAttribute("status").equals("student"))
        {
            if(function.equals("选课"))
            {
                request.getRequestDispatcher("ChooseServlet").forward(request, response);
            }
            else if(function.equals("浏览课程信息"))
            {
                request.getRequestDispatcher("CourseInformationServlet").forward(request, response);
            }
        }
        else if(session.getAttribute("status").equals("teacher"))
        {
            if(function.equals("添加课程") || function.equals("浏览选课学生信息"))
            {
                request.getRequestDispatcher("CourseInformationServlet").forward(request, response);
            }
        }
    }
}
