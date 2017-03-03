package cn.itcast.web.jsp.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FilterTag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException {
		  //�������������ݴ��ǩ�������
		 StringWriter write = new StringWriter();
		 //��ñ�ǩ������ݣ������뻺����
		 this.getJspBody().invoke(write);
		  String temp = write.toString();
		 //����ǩ�����ݽ���ת��
		 temp = filter(temp);
		 //ȡ��PageContext����󣬲������ǩ�������
	      PageContext pageContext = (PageContext) this.getJspContext();
	       pageContext.getOut().write(temp);
	      
	}
	  public String filter(String message) {

	        if (message == null)
	            return (null);

	        char content[] = new char[message.length()];
	        message.getChars(0, message.length(), content, 0);
	        StringBuilder result = new StringBuilder(content.length + 50);
	        for (int i = 0; i < content.length; i++) {
	            switch (content[i]) {
	            case '<':
	                result.append("&lt;");
	                break;
	            case '>':
	                result.append("&gt;");
	                break;
	            case '&':
	                result.append("&amp;");
	                break;
	            case '"':
	                result.append("&quot;");
	                break;
	            default:
	                result.append(content[i]);
	            }
	        }
	        return (result.toString());

	    }   
	
	 
}
