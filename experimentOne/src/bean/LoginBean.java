// -*- coding = utf-8 -*-
// @Time : 2022/10/3 11:39
// @Author : 李兆堃
// @File : LoginBean.java
// @Software : IntelliJ IDEA
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean
{
    private String username;
    private String password;
    private boolean registerResult;
    private boolean loginResult;

    public LoginBean(){};

    public void setUserName(String userName) {
        this.username = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public boolean getRegisterResult() {
        register();
        return registerResult;
    }

    public boolean getLoginResult() {
        login();
        return loginResult;
    }
    private void register()        // 注册功能
    {

        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            String  sql = "INSERT INTO user(userName, password) VALUE(?, ?)";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int rs=pstmt.executeUpdate();

            if(rs > 0) registerResult= true;
            else registerResult= false;

            pstmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void login()
    {
        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            String  sql = "SELECT * FROM user WHERE(userName = ? AND password = ?)";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs=pstmt.executeQuery();

            loginResult = rs.next();

            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
