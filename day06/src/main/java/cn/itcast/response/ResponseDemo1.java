package cn.itcast.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 1、在servlet用getOutputStream输出中文问题
 */
public class ResponseDemo1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        //test1(response);
        //test2(response);
        //test3(response);
        test4(response);
    }

    @SuppressWarnings("unused")
    private void test1(HttpServletResponse response) throws IOException, UnsupportedEncodingException {

        String data = "中国 ";
        /**
         * 程序以什么码表输出，程序就一定要控制浏览器以什么码表打开(浏览器默认是按gb2312打开)
         */
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //response.setCharacterEncoding("UTF-8"); //这样也可以，同时getBytes()方法里不要再设置编码了
        OutputStream out = response.getOutputStream();
        out.write(data.getBytes());
    }

    @SuppressWarnings("unused")
    private void test2(HttpServletResponse response) throws IOException, UnsupportedEncodingException {

        String data = "中国test2";
        //用html技术中的 <meta>标签模拟一个http响应头，来控制浏览器的行为
        OutputStream out = response.getOutputStream();
        out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
        out.write(data.getBytes("UTF-8"));
    }

    //细节1
    @SuppressWarnings("unused")
    private void test3(HttpServletResponse response) throws IOException, UnsupportedEncodingException {

        String data = "中国 ";
        //注意：这里写错了;改成,了，浏览器会提示下载   (实验没下载，乱码)
        response.setHeader("content-type", "text/html,charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(data.getBytes("UTF-8"));
    }

    //细节2
    @SuppressWarnings("unused")
    private void test4(HttpServletResponse response) throws IOException, UnsupportedEncodingException {

        OutputStream out = response.getOutputStream();
        //直接输出数字，浏览器收到65回去查gb2312码表，查到的是A，说浏览器输入A了
        out.write(65);  //write()被重载3次
        out.write(new byte[]{65, 66, 67, 10});
    }
}
