// -*- coding = utf-8 -*-
// @Time : 2022/10/3 15:48
// @Author : 李兆堃
// @File : viewHistoryBean.java
// @Software : IntelliJ IDEA

package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewHistoryBean
{
    private ResultSet rs;
    private Connection conn;
    private PreparedStatement pstmt;

    public ViewHistoryBean(){}

    public ResultSet getHistory(String userName)
    {
        history(userName);
        return rs;
    }

    public void history(String userName)
    {
        try
        {
            ConnectionBean connection = new ConnectionBean();
            conn = connection.getConnect();

            String  sql = "SELECT * FROM viewhistory WHERE(userName = ?)";

            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            rs=pstmt.executeQuery();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void disconnect() throws SQLException {
        pstmt.close();
        conn.close();
    }
}
