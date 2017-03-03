package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//开发防盗链标签
public class RefererTag extends SimpleTagSupport {
	//从客户端传过来的url
	 private String url;
	 private String error;
	 
	 
	
	public void setError(String error) {
		this.error = error;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	 
	
	public void doTag() throws JspException, IOException {
		//获取request&&response对象
		PageContext pagecontext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pagecontext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pagecontext.getResponse();
		//获取客户端传输的标签头
		 String referer = request.getHeader("referer");
		 //判断两个url是否相等
		 if(referer!=null&&referer.equals(this.url)){
			 //转向正确的页面
			 this.getJspBody().invoke(null);
			 
		 }else{
			 //防盗链
			  try {
				request.getRequestDispatcher(this.error).forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			}
		 }
		
	}



}
