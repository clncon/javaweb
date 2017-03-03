package cn.itcast.web.session;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Expires", "-1");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		BufferedImage bi = new BufferedImage(50,25,BufferedImage.TYPE_3BYTE_BGR);
		Graphics gi =  bi.getGraphics();
		String checkcode = Token.getNum();
		gi.drawString(checkcode, 15, 15);
		//增加干扰线
		for(int i=0;i<9;i++){
			int x1 = new Random().nextInt(50);
			int y1 = new Random().nextInt(25);
			gi.drawLine(x1, y1, x1+4, y1+4);
		}
		HttpSession session = request.getSession();
		session.setAttribute("CHECKCODE", checkcode);
		OutputStream os = response.getOutputStream();
		ImageIO.write(bi, "JPG", os);
		//将验证码放入域对象中（session）
		

		
	}
	

}
class Token{
	public static String getNum(){
		String random=null;
		Random ran = new Random();
		 int ss = ran.nextInt(10000);
		 random = String.valueOf(ss);
		 if(random.length()==1){
			 random = "000"+random;
		 }
		 else if (random.length()==2){
			 random="00"+random;
		 }
		 else if(random.length()==3){
			 random = "0"+random;
		 }
		return random;
	}
	
}
