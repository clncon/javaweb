package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherWiseTag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException {
		 //��ø���ǩ
		 ChooseTag chooseTag = (ChooseTag) this.getParent();
		 //�ж�chooseTag�Ƿ�ִ��
		 if(!chooseTag.isDo()){
			 this.getJspBody().invoke(null);
		 }
	}
        
	  
}
