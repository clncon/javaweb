package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IpTag extends SimpleTagSupport {
	//自定义标签
    private PageContext pagecontext;
	public void setJspContext(JspContext pc) {
		pagecontext = (PageContext) pc;
	}
	
	public void doTag() throws JspException, IOException {
	         //获得request对象
		      HttpServletRequest request = (HttpServletRequest) pagecontext.getRequest();
		      //获得ip地址
		      String ip = request.getRemoteAddr();
		      //打印ip地址
		       JspWriter out = pagecontext.getOut();
		       out.write(ip);
	}

	
	

}
