// -*- coding = utf-8 -*-
// @Time : 2022/10/23 1:24
// @Author : 李兆堃
// @File : PersonBean.java
// @Software : IntelliJ IDEA
package bean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBean
{
    public PersonBean(){};

    public String[] searchPerson(String status, String id)
    {
        String[] result = new String[5];
        String sql = "";
        try{
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            if(status.equals("student"))
                sql = "SELECT * FROM student WHERE sid = ?";
            else if(status.equals("teacher"))
                sql = "SELECT * FROM teacher WHERE tid = ?";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs=pstmt.executeQuery();

            rs.next();
            if(status.equals("student")){
                result[0] = rs.getString("sid");
                result[1] = rs.getString("name");
                result[2] = rs.getString("gender");
                result[3] = rs.getString("class");
                result[4] = rs.getString("major");
            }
            else if(status.equals("teacher"))
            {
                result[0] = rs.getString("tid");
                result[1] = rs.getString("name");
                result[2] = rs.getString("gender");
                result[3] = rs.getString("college");
                result[4] = rs.getString("title");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public void alterPerson(String status, String id, String[] choose, String[] input)
    {
        int i = 0;
        String sql = "";
        PreparedStatement pstmt;

        try{
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            while(i < choose.length)
            {
                if(status.equals("student"))
                    sql = "UPDATE student SET " + choose[i] + " = ? WHERE sid = ?";
                else
                    sql = "UPDATE teacher SET " + choose[i] + " = ? WHERE tid = ?";
                pstmt= conn.prepareStatement(sql);
                pstmt.setString(1, input[i]);
                pstmt.setString(2, id);

                pstmt.executeUpdate();
                i++;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
