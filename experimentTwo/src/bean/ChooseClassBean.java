package bean;// -*- coding = utf-8 -*-
// @Time : 2022/10/21 16:57
// @Author : 李兆堃
// @File : ChooseClassBean.java
// @Software : IntelliJ IDEA

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChooseClassBean
{
    private String[] cid = new String[100];
    private String[] classes = new String[100];
    private String[] teachers = new String[100];
    private int[] choose = new int[100];
    private int[] max = new int[100];

    public ChooseClassBean(){};

    public String[] getCid() {
        return cid;
    }

    public String[] getClasses() {
        return classes;
    }

    public String[] getTeachers() {
        return teachers;
    }

    public int[] getChoose() {
        return choose;
    }

    public int[] getMax() {
        return max;
    }

    public void searchClass()
    {
        int i = 0;
        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();
            String sql = "SELECT * FROM course";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();

            while (rs.next())
            {
                cid[i] = rs.getString("cid");
                classes[i] = rs.getString("name");
                teachers[i] = rs.getString("teacher");
                choose[i] = rs.getInt("choose");
                max[i] = rs.getInt("max");
                i++;
            }

            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String[] addClass(String[] chooseCid, String userId)
    {
        int i = -1, count = 0;
        int[] resultNum = new int[2];
        String[] result = new String[100];

        ResultSet rs;

        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;

        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();
            while(i < (chooseCid.length-1))
            {
                i++;
                //获取当前选课人数和人数上限
                String sql2 = "SELECT choose,max FROM course WHERE cid=?";
                pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1, chooseCid[i]);
                rs = pstmt2.executeQuery();
                rs.next();
                count = rs.getInt("choose");
                count++;
                // 若人数超过，则未选上的课数量+1
                if(count > rs.getInt("max"))
                {
                    resultNum[1]++;
                    continue;
                }
                pstmt2 = conn.prepareStatement("SELECT * FROM choose WHERE sid = ? AND cid = ?");
                pstmt2.setString(1, userId);
                pstmt2.setString(2, chooseCid[i]);

                // 若该课已选过，则未选上的课数量+1
                if(pstmt2.executeQuery().next())
                {
                    resultNum[1]++;
                    continue;
                }

                // 修改选课人数+1
                String sql = "UPDATE course SET choose = ? WHERE cid = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, count);
                pstmt.setString(2, chooseCid[i]);
                pstmt.executeUpdate();

                // 选课信息添加
                sql = "INSERT INTO choose(sid, cid) VALUES(?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userId);
                pstmt.setString(2, chooseCid[i]);
                resultNum[0] += pstmt.executeUpdate();
                result[resultNum[0]] = chooseCid[i];


            }
            result[0] = String.valueOf(resultNum[0]);
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public String[] addCourse(String cid, String name, String userId, int max)
    {
        String teacher;

        String[] result = new String[2];
        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();

            ResultSet rs;

            PreparedStatement pstmt = null;
            PreparedStatement pstmt2 = null;

            //查找教师名称
            pstmt2 = conn.prepareStatement("SELECT * FROM teacher WHERE tid = ?");
            pstmt2.setString(1, userId);
            rs = pstmt2.executeQuery();
            rs.next();
            teacher = rs.getString("name");

            // 判断该课是否已添加，若已添加则跳过
            pstmt2 = conn.prepareStatement("SELECT * FROM course WHERE cid = ? AND teacher = ?");
            pstmt2.setString(1, cid);
            pstmt2.setString(2, teacher);

            if(!pstmt2.executeQuery().next())
            {
                String sql = "INSERT INTO course(cid, name, choose, teacher, max ) VALUES(?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, cid);
                pstmt.setString(2, name);
                pstmt.setInt(3, 0);
                pstmt.setString(4, teacher);
                pstmt.setInt(5, max);

                result[0] = String.valueOf(pstmt.executeUpdate());

                result[1] = name;
            }
            else
            {
                result[0] = String.valueOf(0);

                result[1] = name;
            }
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public void searchChoose()
    {
        int i = 0;
        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();
            String sql = "SELECT * FROM choose INNER JOIN course ON(choose.cid = course.cid)";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();

            while (rs.next())
            {
                classes[i] = rs.getString("name");
                teachers[i] = rs.getString("teacher");
                i++;
            }

            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String[][] searchStudent(String tid)
    {
        int i = 0;
        String[][] result = new String[100][5];

        try
        {
            ConnectionBean connection = new ConnectionBean();
            Connection conn = connection.getConnect();
            String sql = "SELECT course.name,student.name,student.gender,class,major FROM choose INNER JOIN course ON(choose.cid = course.cid) INNER JOIN teacher ON(course.teacher = teacher.name) INNER JOIN student ON(choose.sid = student.sid) WHERE teacher.tid = ? GROUP BY course.name;";

            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, tid);
            ResultSet rs=pstmt.executeQuery();

            while (rs.next())
            {
                result[i][0] = rs.getString("course.name");
                result[i][1] = rs.getString("student.name");
                result[i][2] = rs.getString("student.gender");
                result[i][3] = rs.getString("class");
                result[i][4] = rs.getString("major");
                i++;
            }

            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}



