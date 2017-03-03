package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherWiseTag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException {
		 //获得父标签
		 ChooseTag chooseTag = (ChooseTag) this.getParent();
		 //判断chooseTag是否执行
		 if(!chooseTag.isDo()){
			 this.getJspBody().invoke(null);
		 }
	}
        
	  
}
