// @Time : 2022/9/22 9:42
// @Author : 李兆堃
// @File : servlet922.java
// @Software : IntelliJ IDEA

// @Time : 2022/9/22 9:07
// @Author : 李兆堃
// @File : servlet22.java
// @Software : IntelliJ IDEA

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class servlet922 extends HttpServlet
{
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
    public void  doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body bgcolor=cyan>");
        String s=request.getParameter("number");
        String []a=s.split("[,，]+");

        double sum = 0;
        for(String item:a)
        {
            if(item.length() >= 1)
                sum+=Double.parseDouble(item);
        }
        out.print("<h2>用户的请求方式是" + request.getMethod() + "<br>");
        for(String item:a)
        {
            if(item.length() >= 1)
                out.print(item+" ");
        }
        out.print("<br>的和是" + sum);
        out.println("</h2></body></html>");
    }

    public  void  doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<html><body bgcolor=yellow>");
        String s=request.getParameter("number");
        String []a=s.split("[,，]+");

        double product = 1;

        for(String item:a)
        {
            if(item.length() >= 1)
                product*=Double.parseDouble(item);
        }
        out.print("<h2>用户的请求方式是" + request.getMethod() + "<br>");
        for(String item:a)
        {
            if(item.length()>=1)
                out.print(item+" ");
        }
        out.print("<br>的乘积是" + product);
        out.println("<h2></body></html>");
    }
}
