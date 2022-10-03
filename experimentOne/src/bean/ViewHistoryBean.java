package bean;// -*- coding = utf-8 -*-
// @Time : 2022/10/3 15:48
// @Author : 李兆堃
// @File : viewHistory.java
// @Software : IntelliJ IDEA

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewHistoryBean
{
    private String userName;
    private ResultSet rs;

    public ViewHistoryBean(){}

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public ResultSet getHistory()
    {
        history();
        return rs;
    }

    public void history()
    {
        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            String  sql = "SELECT * FROM viewhistory WHERE(userName = ?)";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            rs=pstmt.executeQuery();

            pstmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
