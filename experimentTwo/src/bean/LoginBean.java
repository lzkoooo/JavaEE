// @Time : 2022/10/18 23:31
// @Author : 李兆堃
// @File : bean.LoginBean.java
// @Software : IntelliJ IDEA

package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean
{
    public LoginBean(){};

    public boolean getLoginResult(String tableName, String id, String username, String password)
    {
        boolean loginResult = false;
        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            String  sql = "SELECT * FROM " + tableName + " WHERE(" + id + " = ? AND password = ?)";

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

        return loginResult;
    }
}