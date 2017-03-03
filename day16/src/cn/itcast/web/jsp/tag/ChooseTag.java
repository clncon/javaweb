package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	/*
	 * isDO表是子标签体是否需要执行，只执行一个标签体
	 * false:表示未执行，默认为false
	 * true:表示执行过
	 * */
	 private boolean isDo;

	public boolean isDo() {
		return isDo;
	}

	public void setDo(boolean isDo) {
		this.isDo = isDo;
	}


	public void doTag() throws JspException, IOException {
		  //执行标签体
		 this.getJspBody().invoke(null);
	}
	 
	 
	
}
