package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ExecuteTag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException {
		 //��ñ�ǩ�������
		 JspFragment context =  this.getJspBody();
		 //����ǩ���������������
		 context.invoke(null);
	}
          
}
