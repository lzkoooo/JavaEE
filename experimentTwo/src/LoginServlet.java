// @Time : 2022/10/18 23:25
// @Author : 李兆堃
// @File : LoginServlet.java
// @Software : IntelliJ IDEA

import bean.LoginBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet
{
    private String userId;
    private String password;
    private String loginButton;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        LoginBean loginBean = new LoginBean();

        boolean loginResult = false;

        this.userId = request.getParameter("userId");
        this.password = request.getParameter("password");
        this.loginButton = request.getParameter("loginButton");


        if(loginButton.equals("学生登录"))
            loginResult = loginBean.getLoginResult("student", "sid", userId, password);
        else if(loginButton.equals("教师登录"))
            loginResult = loginBean.getLoginResult("teacher", "tid", userId, password);

        if(loginResult)
        {
            if(loginButton.equals("学生登录"))
            {
                session.setAttribute("status", "student");
                session.setAttribute("id", userId);
                response.sendRedirect("StudentHomePage.jsp");
//                request.getRequestDispatcher("StudentHomePage.jsp").forward(request,response);
            }
            else if(loginButton.equals("教师登录"))
            {
                session.setAttribute("status", "teacher");
                session.setAttribute("id", userId);
                response.sendRedirect("TeacherHomePage.jsp");
//                request.getRequestDispatcher("TeacherHomePage.jsp").forward(request,response);
            }

        }
        else
            response.sendRedirect("Login.jsp");



    }
}
