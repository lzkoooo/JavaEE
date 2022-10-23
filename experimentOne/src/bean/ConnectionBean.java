// -*- coding = utf-8 -*-
// @Time : 2022/10/3 12:02
// @Author : 李兆堃
// @File : dataConnection.java
// @Software : IntelliJ IDEA

package bean;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBean
{
    private String driverName = "com.mysql.jdbc.Driver";   //驱动程序名
    private String dataUserName = "root";       //数据库用户名
    private String dataUserPassword = "123456";      //密码
    private String dbName = "experimentOne";        //数据库名
    private String url1="jdbc:mysql://localhost:3306/"+dbName;
    private String url2 ="?user="+ dataUserName +"&password="+dataUserPassword;
    private String url3="&useUnicode=true&characterEncoding=UTF-8";
    private String loginUrl =url1+url2+url3;
    private Connection conn;

    public ConnectionBean(){};

    public Connection getConnect()
    {
        try
        {
            Class.forName(driverName);
            conn= DriverManager.getConnection(loginUrl);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    public void disconnect()
    {
        try
        {
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
