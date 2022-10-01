// @Time : 2022/9/28 23:33
// @Author : 李兆堃
// @File : verify.java
// @Software : IntelliJ IDEA

import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Verify extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String driverName = "com.mysql.jdbc.Driver";   //驱动程序名
        String userName = "root";       //数据库用户名
        String userPwd = "123456";      //密码
        String dbName = "user";        //数据库名
        String url1="jdbc:mysql://localhost:3306/"+dbName;
        String url2 ="?user="+userName+"&password="+userPwd;
        String url3="&useUnicode=true&characterEncoding=UTF-8";
        String url =url1+url2+url3;
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("xm");
        String pw=request.getParameter("mm");
        RequestDispatcher dis=null;//设置转发的对象
        try {
            Class.forName(driverName);
            Connection conn=DriverManager.getConnection(url);
            String  sql="select * from user_b  where(uname=? and upassword=?)";
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,pw);
            ResultSet  rs=pstmt.executeQuery();
            if(rs.next()){
                if(rs!=null)rs.close();
                if(pstmt!=null)pstmt.close();
                if(conn!=null)conn.close();
                dis=request.getRequestDispatcher("success.jsp");
                dis .forward(request,response);
            }
            else{
                if(rs!=null)rs.close();
                if(pstmt!=null)pstmt.close();
                if(conn!=null)conn.close();
                dis=request.getRequestDispatcher("success_no.jsp");
                dis.forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}