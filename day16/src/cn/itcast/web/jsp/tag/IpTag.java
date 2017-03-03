package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IpTag extends SimpleTagSupport {
	//�Զ����ǩ
    private PageContext pagecontext;
	public void setJspContext(JspContext pc) {
		pagecontext = (PageContext) pc;
	}
	
	public void doTag() throws JspException, IOException {
	         //���request����
		      HttpServletRequest request = (HttpServletRequest) pagecontext.getRequest();
		      //���ip��ַ
		      String ip = request.getRemoteAddr();
		      //��ӡip��ַ
		       JspWriter out = pagecontext.getOut();
		       out.write(ip);
	}

	
	

}
