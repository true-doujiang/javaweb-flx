package com.yhh.jdbc.utils;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//sun公司的Connection接口，MySQL、Oracle的connection都是它的实现类
import java.sql.Connection;
//如果用的是MySQL数据库，导入这个类也是没错的，但是要在切换到Oracle后，又要换Oracle的connection。
//所以为了兼容性，使用sun公司的connection接口
//import com.mysql.jdbc.Connection;

public class JdbcUtils {

    private static Properties config = new Properties();

    static{
        try {
            config.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            Class.forName(config.getProperty("driver"));
        } catch (Exception e) {
            //抛出初始化错误
            throw new ExceptionInInitializerError(e);
        }
    }

    //获取链接			工具类的异常可以直接抛出去，也可以转型下再抛出去
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
    }
    //释放资源
    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                rs.close();   //throw new
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;//确保释放
        }
        if(st!=null){
            try{
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            st = null;//确保释放
        }
        if(conn!=null){
            try{
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;//确保释放
        }
    }
}
