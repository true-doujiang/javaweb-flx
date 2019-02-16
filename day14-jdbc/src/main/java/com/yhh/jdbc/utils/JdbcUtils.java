package com.yhh.jdbc.utils;


import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static Properties config = new Properties();

    static {
        try {
            config.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            Class.forName(config.getProperty("driver"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
    }


    public static void release (Connection conn, Statement st, ResultSet rs) {
        if(rs!=null){
            try{
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            //确保释放
            rs = null;
        }
        if(st!=null){
            try{
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            //确保释放
            st = null;
        }
        if(conn!=null){
            try{
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            //确保释放
            conn = null;
        }
    }

}
