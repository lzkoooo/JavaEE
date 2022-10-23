// @Time : 2022/10/22 15:28
// @Author : 李兆堃
// @File : ViewServlet.java
// @Software : IntelliJ IDEA

import bean.ChooseClassBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CourseInformationServlet extends HttpServlet
{

    private String function;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        ChooseClassBean bean = new ChooseClassBean();

        if(request.getParameter("function") != null)
            function = request.getParameter("function");

        if(function.equals("浏览课程信息"))
        {
            bean.searchChoose();
            request.setAttribute("classes", bean.getClasses());
            request.setAttribute("teachers", bean.getTeachers());
            request.getRequestDispatcher("CourseInformation.jsp").forward(request, response);
        }
        else if(function.equals("添加课程"))
        {
            request.getRequestDispatcher("TeacherAddCourse.jsp").forward(request, response);
        }
        else if(function.equals("浏览选课学生信息"))
        {
            request.setAttribute("result", bean.searchStudent((String) session.getAttribute("id")));
            request.setAttribute("id1", "[][]");
            request.getRequestDispatcher("Result.jsp").forward(request, response);
        }
        else if(function.equals("AddCourse"))
        {
            String cid, name;
            int max;

            cid = request.getParameter("cid");
            name = request.getParameter("name");
            max = Integer.parseInt(request.getParameter("max"));
            request.setAttribute("result", bean.addCourse(cid, name, (String) session.getAttribute("id"), max));

            request.getRequestDispatcher("Result.jsp").forward(request, response);
        }
    }

}
