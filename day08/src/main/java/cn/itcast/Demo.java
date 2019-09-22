package cn.itcast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Demo {

    public static void main(String[] args) throws Exception {
        write();
        read();
    }

    //提交http请求给服务器
    public static void write() throws Exception {

        URL url = new java.net.URL("http://localhost:8088/day08/servlet/ServletDemo1");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestProperty("xxx", "yyy");

        OutputStream out = conn.getOutputStream();
        out.write("name=flx".getBytes());

        int status = conn.getResponseCode();
        System.out.println(status);
    }

    //获取http响应
    public static void read() throws Exception {
        java.net.URL url = new java.net.URL("http://localhost:8088/day08/1.jsp");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        System.out.println(conn.getResponseCode());
        System.out.println(conn.getHeaderField("Server"));

        InputStream inputStream = conn.getInputStream(); //把响应结果读到内存里
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            System.out.println(line);
        }
        //System.out.println(sb.toString());
    }

}
