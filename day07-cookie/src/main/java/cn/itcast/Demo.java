package cn.itcast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String token = "kudshfkshdsfsdfsdas的鬼地个dfdfdfdfdfs";
        MessageDigest md = MessageDigest.getInstance("md5");
        byte md5[] = md.digest(token.getBytes());  // 0100101001  00101001

        BASE64Encoder encoder = new BASE64Encoder();
        String base64Str = encoder.encode(md5);

        System.out.println(base64Str);

        //找个base64编码/解码网页测试
        System.out.println(encoder.encode("aaaa".getBytes()));
    }
}
