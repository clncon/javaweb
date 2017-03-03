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
		    
             //���ڴ�������һ��ͼ��
	          BufferedImage bi = new BufferedImage(500,25,BufferedImage.TYPE_INT_RGB);
	          //ȡ��GGraphics����
	          Graphics gs =  bi.getGraphics();
	          //��������Ĵ�С����ɫ
	          //������ɫ
	          gs.setColor(Color.green);
	          //���ô�С
	          gs.setFont(new Font("����",Font.BOLD,22));
	          //����һ��������ַ���
	          String random =  UUID.randomUUID().toString();
	          //�����ַ���
	          gs.drawString(random, 20, 20);
	          //��ͼƬ������������
	          ImageIO.write(bi, "JPG", response.getOutputStream());
	}

}
