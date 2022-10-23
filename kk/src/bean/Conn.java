package bean;

import java.sql.*;

public class Conn {
    public Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage","root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public PreparedStatement prepare(Connection conn,String sql){
        PreparedStatement pstmt = null;
        try{
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  pstmt;
    }
    public Statement getStatement(Connection conn){
        Statement stmt = null;
        try{
            if (conn != null) {
                stmt = conn.createStatement();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return stmt;
    }
    public ResultSet getResultSet(Statement stmt,String sql){
        ResultSet rs = null;
        if(stmt!=null){
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return rs;
    }
    public void excuteUpdate(Statement stmt,String sql){
        if(stmt!=null){
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            conn=null;
        }
    }
    public void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            rs=null;
        }
    }
    public void close(Statement stmt){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            stmt=null;
        }
    }
}