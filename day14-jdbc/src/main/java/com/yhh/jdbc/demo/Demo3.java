package com.yhh.jdbc.demo;


import com.yhh.jdbc.domain.User;
import com.yhh.jdbc.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 尤欢欢
 * 日期： 2018年2月22日 下午3:44:37
 * 描述： 增删改查基本方法学习
 */
public class Demo3 {


    public static void main(String[] args) throws SQLException {

    }

    @Test
    public void insert() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "insert into users(id,name,password,email,birthday) values(7,'中国','123','ee@sina.com','1990-02-01')";
            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println(num+"插入成功！！！");
            }else{
                System.out.println(num+"插入失败！！！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() throws SQLException{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "update users set name='fff' where id='6'";
            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println("更新成功！！");
            }
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Test
    public void delete() throws SQLException{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "delete from users where id=5";
            int num = st.executeUpdate(sql);
            if(num>0){
                System.out.println("删除成功！！");
            }
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Test
    public void find() throws SQLException{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "select id,name,password,email,birthday from users where id=1";
            rs  = st.executeQuery(sql);
            User user = null;
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
            }
            System.out.println(user);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Test
    public void getAll() throws SQLException{
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "select id,name,password,email,birthday from users";
            rs  = st.executeQuery(sql);
            List<User> list = new ArrayList<User>();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                list.add(user);
            }
            System.out.println(list);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

}
