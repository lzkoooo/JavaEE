// @Time : 2022/9/26 11:13
// @Author : 李兆堃
// @File : ServletOne.java
// @Software : IntelliJ IDEA

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ServletOne extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        String s1=request.getParameter("shuju1");
        String s2=request.getParameter("shuju2");

        int d1=Integer.parseInt(s1);
        int d2=Integer.parseInt(s2);
        int sum = 0;
        int x = d1;

        while(x <= d2)
        {
            sum += x;
            ++x;
        }

        request.setAttribute("sum",sum);
        request.getRequestDispatcher("return926.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
