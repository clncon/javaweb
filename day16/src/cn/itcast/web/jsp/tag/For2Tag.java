package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//<simple:for2 count="10">标签处理类
public class For2Tag extends SimpleTagSupport {
	private int count;

	public void setCount(int count) {
		this.count = count;
	}

	
	public void doTag() throws JspException, IOException {
		  JspFragment context = this.getJspBody();
		  
		  for(int i=0;i<this.count;i++){
			  context.invoke(null);
		  }
	}
	
	

}
