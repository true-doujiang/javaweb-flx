package com.yhh.socket;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


    private static String PATH = Server.class.getClassLoader().getResource("1.html").getPath();

    /** 网络程序模拟web服务器访问你的web应用。
     *
     *	http://localhost:9999
     */
    public static void main(String[] args) throws Exception {
        //监听9999端口
        ServerSocket server = new ServerSocket(9999);
        //建立与客户机的socket
        Socket sock = server.accept();
        FileInputStream in = new FileInputStream(PATH);
        OutputStream out = sock.getOutputStream();
        int len = 0;
        byte buffer[] = new byte[in.available()];
        while((len = in.read(buffer))>0){
            System.out.println("len=" + len);
            System.out.println(new String(buffer,0,len));
            for(byte i : buffer){
                System.out.print(i + " ");
            }
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
        sock.close();
        server.close();
        System.out.println("启动完成!");
    }


}
