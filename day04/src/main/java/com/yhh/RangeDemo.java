package com.yhh;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RangeDemo {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/servlet/ServletDemo1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //测试Range头
        connection.setRequestProperty("Range", "bytes=10-");

        InputStream inputStream = connection.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("e:\\httprange.txt", true);
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        inputStream.close();
        outputStream.close();
        System.out.println("下载 完成!");

        //-----------------------------//
//		String path = System.getProperty("user.dir"); //C:\Users\Administrator\Workspaces\MyEclipse 8.5\day04
//		String path2 = System.getProperty("src");
//		System.out.println(path);
    }

}

