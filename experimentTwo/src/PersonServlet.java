// @Time : 2022/10/22 15:28
// @Author : 李兆堃
// @File : PersonServlet.java
// @Software : IntelliJ IDEA


import bean.PersonBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PersonServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        PersonBean bean = new PersonBean();

        if(request.getParameter("function").equals("修改个人信息"))
        {
            if(request.getParameterValues("choose") == null)
                request.getRequestDispatcher("PersonAlter.jsp").forward(request, response);
            else
            {
                bean.alterPerson((String) session.getAttribute("status"), (String) session.getAttribute("id"), request.getParameterValues("choose"), request.getParameterValues("input"));
            }
        }
        request.setAttribute("result", bean.searchPerson((String) session.getAttribute("status"), (String) session.getAttribute("id")));
        request.getRequestDispatcher("PersonResult.jsp").forward(request, response);
    }
}
