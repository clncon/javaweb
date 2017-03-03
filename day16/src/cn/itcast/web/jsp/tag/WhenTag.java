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
		//��ø���ǩ
		ChooseTag chooseTag = (ChooseTag) this.getParent();
		//��ø���ǩ������״ֵ̬
		boolean isDo = chooseTag.isDo();
		//�ж�
		if(!isDo){
			 if(this.test){
				 chooseTag.setDo(true);
				 this.getJspBody().invoke(null);
				 
			 }
			}
		}
     
     
}
