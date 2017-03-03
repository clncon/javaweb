package com.dream.comm;

import java.io.*;

import java.awt.Color;

import java.awt.Font;

import java.awt.Graphics;

import java.awt.GraphicsEnvironment;

import java.awt.image.BufferedImage;

import java.io.IOException;

import java.util.Random;

import javax.imageio.IIOImage;

import javax.imageio.ImageIO;

import javax.imageio.ImageWriter;

import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

import javax.imageio.stream.ImageOutputStream;

import javax.servlet.*;

import javax.servlet.http.*;

/**
 * Servlet名:RandomImage
 * 实现:产生验证码

web.xml文件

<!-begin 验证码 -->
	<servlet>
		<servlet-name>RandomImages</servlet-name>
		<servlet-class>
			myhr.sysmanage.web.servlet.RandomImages
		</servlet-class>
		<load-on-startup>0</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>RandomImages</servlet-name>
		<url-pattern>/servlet/RandomImages</url-pattern>
	</servlet-mapping>

<!--end 验证码 -->




页面	

<img src="servlet/RandomImages" height="20" />


 *  */
public class RandomImage extends HttpServlet {

	private static final int IMAGE_WIDTH = 48;

	private static final int IMAGE_HEIGHT = 18;

	private static final int FONT_HEIGHT = 16;

	private static final String SVG_SOURCE1 = "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.0//EN\" \"http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd\">"
			+ "<svg width=\""
			+ IMAGE_WIDTH
			+ "\" height=\""
			+ IMAGE_HEIGHT
			+ "\" XMLns=\"http://www.w3.org/2000/svg\">"
			+ "<text x=\"0\" y=\""
			+ IMAGE_HEIGHT
			+ "\" font-family=\"Arial\" font-size=\""
			+ IMAGE_HEIGHT + "\" fill=\"black\">";

	private static final String SVG_SOURCE2 = "</text></svg>";

	private boolean svgMode = false;

	private PrintWriter out = null;

	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
//		if (sn == null)
//			return;
		arg1.addHeader("Cache-Control", "no-cache");
		arg1.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
		String vcode = sn2vcode();
		arg0.getSession().setAttribute("sRand", vcode);// 代码内容写入session中
		//System.out.println("现在的验证码是：" + vcode + "session中是" + (String)arg0.getSession().getAttribute("sRand"));
		if (svgMode)
			outSVG(vcode, arg1);
		else
			outJPEG(vcode, arg1);
	}

	private void outSVG(String vcode, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("image/svg+xml");
		resp.getOutputStream().print(SVG_SOURCE1 + vcode + SVG_SOURCE2);
	}

	private void outJPEG(String vcode, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Random random = new Random();
		Graphics g = image.getGraphics();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		g.setFont(new Font("Times New Roman", Font.HANGING_BASELINE, 18));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(IMAGE_WIDTH);
			int y = random.nextInt(IMAGE_HEIGHT);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		for (int i = 1; i <= 4; i++) {
			String rand = vcode.substring(i - 1, i);
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * (i - 1) + 0, 16);
		}

		ImageWriter writer = (ImageWriter) ImageIO.getImageWritersByFormatName(
				"jpeg").next();
		JPEGImageWriteParam params = new JPEGImageWriteParam(null);
		ImageOutputStream ios = ImageIO.createImageOutputStream(resp
				.getOutputStream());
		writer.setOutput(ios);
		writer.write(null, new IIOImage(image, null, null), params);
		writer.dispose();
		ios.close();
	}

	static String sn2vcode() {
		String sRand = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
		}
		return sRand;
	}

	public void init() throws ServletException {
		try {
			GraphicsEnvironment.getLocalGraphicsEnvironment();
		} catch (Throwable e) {
			// run under linux console???
			svgMode = true;
		}
	}

	public Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
