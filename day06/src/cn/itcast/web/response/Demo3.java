package cn.itcast.web.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   response.setHeader("Expires", "-1");
		   response.setHeader("Cache-Control", "no-cache");
		   response.setHeader("Pragma", "no-cache");
		    
             //从内存中生成一幅图像
	          BufferedImage bi = new BufferedImage(500,25,BufferedImage.TYPE_INT_RGB);
	          //取得GGraphics画笔
	          Graphics gs =  bi.getGraphics();
	          //设置字体的大小和颜色
	          //设置颜色
	          gs.setColor(Color.green);
	          //设置大小
	          gs.setFont(new Font("黑体",Font.BOLD,22));
	          //产生一个随机的字符串
	          String random =  UUID.randomUUID().toString();
	          //绘制字符串
	          gs.drawString(random, 20, 20);
	          //将图片输出到浏览器中
	          ImageIO.write(bi, "JPG", response.getOutputStream());
	}

}
