package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {
     private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	
	public void doTag() throws JspException, IOException {
		//获得父标签
		ChooseTag chooseTag = (ChooseTag) this.getParent();
		//获得父标签的属性状态值
		boolean isDo = chooseTag.isDo();
		//判断
		if(!isDo){
			 if(this.test){
				 chooseTag.setDo(true);
				 this.getJspBody().invoke(null);
				 
			 }
			}
		}
     
     
}
