// @Time : 2022/10/2 16:42
// @Author : 李兆堃
// @File : Conversion.java
// @Software : IntelliJ IDEA
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class ConversionBean
{
    private int numBefore, numAfter;
    private String numSystem;

    public ConversionBean(){}

    public void setNumBefore(int numBefore) {
        this.numBefore = numBefore;
    }
    public void setNumSystem(String numSystem) {
        this.numSystem = numSystem;
    }

    public int getNumBefore() {
        return numBefore;
    }
    public int getNumAfter(String userName) {
        conversion(userName);
        return numAfter;
    }
    public String getNumSystem() {
        return numSystem;
    }

    private void conversion(String userName)
    {
        if(Objects.equals(numSystem, "二进制转十进制"))
            numAfter = Integer.valueOf(String.valueOf(numBefore), 2);
        else
            numAfter = Integer.parseInt(Integer.toBinaryString(numBefore));
        saveHistory(userName);
    }

    private void saveHistory(String userName)
    {
        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            String  sql = "INSERT INTO viewhistory(userName, inputNumber, operate, result) VALUES(?, ?, ?, ?)";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, String.valueOf(numBefore));
            pstmt.setString(3, numSystem);
            pstmt.setString(4, String.valueOf(numAfter));
            int rs = pstmt.executeUpdate();

            if(rs > 0) System.out.println("添加成功");
            pstmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteHistory(String userName)
    {
        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            String  sql = "DELETE FROM viewhistory WHERE userName=?";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
