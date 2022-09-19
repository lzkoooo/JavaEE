package DataSource.Druid;

import DataSource.Druid.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //定义sql语句
            String sql = "insert into account value(null,?,?)";
            //获取PreparedStatement对象
            pstmt = conn.prepareStatement(sql);
            //给占位符（？）赋值
            pstmt.setString(1,"王五");
            pstmt.setDouble(2,3000);
            //执行sql语句
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.close(pstmt,conn);
        }
    }
}