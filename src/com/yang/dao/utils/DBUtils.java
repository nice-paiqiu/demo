package com.yang.dao.utils;

import java.sql.*;

/***
 * jdbc帮助类
 */
public class DBUtils {
    private final static String DRIVERCLASS="com.mysql.jdbc.Driver";
    private final static String USERNAME="root";
    private final static String PASSWORD="123";
    private final static String URL="jdbc:mysql:///student?characterEncoding=utf8";
    static{
        try {
            Class.forName(DRIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void close(ResultSet rs, PreparedStatement pst,Connection con){
        try {
            if(rs!=null)
                rs.close();
            if(pst!=null)
                pst.close();
            if(con!=null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
