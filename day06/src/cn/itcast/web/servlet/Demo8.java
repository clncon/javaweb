package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Demo8 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得字符输出对象
         PrintWriter pw = response.getWriter();
         //读取初始化参数
         ServletContext context = this.getServletContext();
         InputStream is = context.getResourceAsStream("/WEB-INF/classes/cn/itcast/web/servlet/config/config.properties");
         Properties props = new Properties();
         props.load(is);
         String rowParam = props.getProperty("row");
         String colParam = props.getProperty("col");
         int row = Integer.parseInt(rowParam);
         int col = Integer.parseInt(colParam);
         //建立表单
         
         pw.write("<table align = 'center' border = '1'>");
         for(int i=1;i<=row;i++)
         {
        	 if(i%2==0){
        		 pw.write("<tr style = 'color:red'>");
        		 
        	 }
        	 else{
        		 pw.write("<tr style = 'color:blUe'>");
        	 }
        	 for(int j=0;j<col;j++){
        		 pw.write("<td>");
         		 pw.write("&#x25C7");
        		 pw.write("</td");
        	 }
        	 pw.write("</tr>");
         }
         pw.write("</table>");
         
         
	}

}
