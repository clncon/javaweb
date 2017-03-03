package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SkipTag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException {
		 //��ñ�ǩ�������
		  JspFragment context = this.getJspBody();
		  //����ǩ������ݴ�ӡ�������
		  context.invoke(null);
		  //�׳�SkipPageExcetion�쳣����ֹ����ִ��
		  throw new SkipPageException();
	}
      
}
