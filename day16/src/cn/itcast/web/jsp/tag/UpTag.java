package cn.itcast.web.jsp.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UpTag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException {
		//取得标签体的内容
		JspFragment context = this.getJspBody();
		 //定义一个缓冲区,存储标签体的内容
		StringWriter write = new StringWriter();
		context.invoke(write);
		//将缓冲区的字符串取出
		String buffer = write.getBuffer().toString();
		//将字符串装换成大写
		String bigBuffer = buffer.toUpperCase();
		//打印该大写的字符串到浏览器
		PageContext pageContext = (PageContext) this.getJspContext();
		JspWriter out = pageContext.getOut();
		out.write("<font color='red'>"+bigBuffer+"</font>");
	}
     
}
