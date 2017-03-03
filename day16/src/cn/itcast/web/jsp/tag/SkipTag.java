package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SkipTag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException {
		 //获得标签体的内容
		  JspFragment context = this.getJspBody();
		  //将标签体的内容打印到浏览器
		  context.invoke(null);
		  //抛出SkipPageExcetion异常，终止程序执行
		  throw new SkipPageException();
	}
      
}
