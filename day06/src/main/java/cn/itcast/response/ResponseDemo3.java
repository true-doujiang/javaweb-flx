package cn.itcast.response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 3、通过response实现文件下载
 */
public class ResponseDemo3 extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        //test1(response);
        test2(response);
    }

    @SuppressWarnings("unused")
    private void test1(HttpServletResponse response) throws FileNotFoundException, IOException {
        //第一个/代表web应用根目录
        String path = this.getServletContext().getRealPath("/download/new.jpg");
        System.out.println(path);
        String filename = path.substring(path.lastIndexOf("\\") + 1);
        //应该加上content-Type头控制是word、image、PDF.....
        //response.setContentType("application/msword");  但是我加了也不行，读的是什么文件下载的就是什么文件类型，不可以换
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        InputStream in = null;
        OutputStream out = null;
        in = new FileInputStream(path);
        int len = 0;
        byte buffer[] = new byte[1024];
        out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
    }

    private void test2(HttpServletResponse response) throws FileNotFoundException, IOException {

        String path = this.getServletContext().getRealPath("/download/新图片.jpg");
        String filename = path.substring(path.lastIndexOf("\\") + 1);
        //如果下载文件是中文文件，则 文件名 需要经过url编码
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        InputStream in = null;
        OutputStream out = null;
        System.out.println(filename);
        in = new FileInputStream(path);
        out = response.getOutputStream();

        int len = 0;
        byte buffer[] = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
    }


}
