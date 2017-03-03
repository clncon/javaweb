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
		//ȡ�ñ�ǩ�������
		JspFragment context = this.getJspBody();
		 //����һ��������,�洢��ǩ�������
		StringWriter write = new StringWriter();
		context.invoke(write);
		//�����������ַ���ȡ��
		String buffer = write.getBuffer().toString();
		//���ַ���װ���ɴ�д
		String bigBuffer = buffer.toUpperCase();
		//��ӡ�ô�д���ַ����������
		PageContext pageContext = (PageContext) this.getJspContext();
		JspWriter out = pageContext.getOut();
		out.write("<font color='red'>"+bigBuffer+"</font>");
	}
     
}
