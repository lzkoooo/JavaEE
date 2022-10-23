// @Time : 2022/10/19 0:54
// @Author : 李兆堃
// @File : ChooseServlet.java
// @Software : IntelliJ IDEA

import bean.ChooseClassBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChooseServlet extends HttpServlet
{
    private String function = " ";
    private String[] choose;
    ChooseClassBean bean = new ChooseClassBean();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        if(request.getParameter("function") != null)
        {
            if(request.getParameter("function").equals("选课"))
            {
                bean.searchClass();
                request.setAttribute("cid", bean.getCid());
                request.setAttribute("classes", bean.getClasses());
                request.setAttribute("teachers", bean.getTeachers());
                request.setAttribute("choose", bean.getChoose());
                request.setAttribute("max", bean.getMax());
                request.getRequestDispatcher("ChooseClass.jsp").forward(request, response);
            }
        }
        else if(request.getParameterValues("choose") != null)
        {
            choose = request.getParameterValues("choose").clone();

            request.setAttribute("choose", choose);
            request.setAttribute("result", bean.addClass(choose, (String) session.getAttribute("id")));

            request.getRequestDispatcher("Result.jsp").forward(request, response);
        }

    }
}
