package cn.itcast.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 4、输出一串数字
 */
public class ResponseDemo4 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 120;
    public static final int HEIGHT = 25;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        //1设置背景色
        setBackGround(g);

        //2设置边框
        setBorder(g);

        //3画干扰线
        setRandomLine(g);

        //4写随机数
        setRandomNum(g);

        //5图形写给浏览器
        response.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    private void setRandomNum(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("宋体", Font.BOLD, 20));
        for (int i = 0; i < 4; i++) {

        }
    }

    private void setRandomLine(Graphics g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < 5; i++) {
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);
            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    private void setBorder(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    private void setBackGround(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}