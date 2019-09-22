package cn.itcast.form;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;


//1、负责产生表单
public class FormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String token = TokenProccessor.getInstance().makeToken();
        //在服务器端保存token
        request.getSession().setAttribute("token", token);
        System.out.println("token: " + token);
        request.getRequestDispatcher("/form.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

/**
 * md5算法用途:
 * 1、校验数据的完整性
 * ....等等
 * <p>
 * base64应用场景也特别多
 */
class TokenProccessor {    //令牌
    /**
     * 单态设计模式（保证类的对象在内存中只有一个）
     * 1、把类的构造函数私有
     * 2、自己创建一个类的对象
     * 3、对外提供一个公共的方法，返回类的对象
     */
    private TokenProccessor() {
    }  //1

    private static final TokenProccessor instance = new TokenProccessor(); //2

    public static TokenProccessor getInstance() {  //3
        return instance;
    }

    public String makeToken() {  //checkException
        //  7346734837483  834u938493493849384  43434384   数据的长度可能不固定
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            //数据指纹的长度固定   128位长   16个字节  md5
            MessageDigest md = MessageDigest.getInstance("md5"); //md5算法是得到数据的指纹，而不是对数据加密
            byte md5[] = md.digest(token.getBytes());   //返回128个二进制位  16个字节
            BASE64Encoder encoder = new BASE64Encoder(); //base64编码,将3个字节变成4个字节(每个字节的最大数63)，然后去查base64码表
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
