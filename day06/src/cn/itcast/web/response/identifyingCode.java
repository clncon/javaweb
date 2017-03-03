package cn.itcast.web.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class identifyingCode extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		    
		//���ڴ�������һ��ͼ��
		BufferedImage bi = new BufferedImage(80,25,BufferedImage.TYPE_INT_RGB);
		//ȡ��GGraphics����
		Graphics gs =  bi.getGraphics();
		//��������Ĵ�С����ɫ
		//������ɫ
		gs.setColor(Color.green);
		//���ô�С
		gs.setFont(new Font("����",Font.BOLD,22));
		/* //����һ��������ַ���
	          String random =  UUID.randomUUID().toString();*/
		//�����ַ���
		gs.drawString(getIdentifyCode(), 20, 20);
		//��ͼƬ������������
		ImageIO.write(bi, "JPG", response.getOutputStream());

	}
	public String getIdentifyCode(){
		String str = "";
		String numberAndLetter = "123456789qwertyuiopasdfghjklzxcvbnmZXCVBNMASDFGHJKLQWERTYUIOP";
		int Length = numberAndLetter.length();
		for(int i=1;i<=4;i++){
			if(i==1||i==2){//������
				while(true){
					Random random = new Random();
					int index = random.nextInt(Length);
					String value = numberAndLetter.substring(index, index+1);
					if(value.matches("[0-9]")){
						str += value;
						break;
					}


				}


			}
			else if(i==3||i==4){//���ַ�
				while(true){
					Random random = new Random();
					int index = random.nextInt(Length);
					String value = numberAndLetter.substring(index,index+1);
					if(value.matches("[a-zA-Z]")){
						str+=value;
						break;
					}
				}
			}
		}

		return str;
	}

}
