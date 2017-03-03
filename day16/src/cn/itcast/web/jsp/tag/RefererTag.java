package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//������������ǩ
public class RefererTag extends SimpleTagSupport {
	//�ӿͻ��˴�������url
	 private String url;
	 private String error;
	 
	 
	
	public void setError(String error) {
		this.error = error;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	 
	
	public void doTag() throws JspException, IOException {
		//��ȡrequest&&response����
		PageContext pagecontext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pagecontext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pagecontext.getResponse();
		//��ȡ�ͻ��˴���ı�ǩͷ
		 String referer = request.getHeader("referer");
		 //�ж�����url�Ƿ����
		 if(referer!=null&&referer.equals(this.url)){
			 //ת����ȷ��ҳ��
			 this.getJspBody().invoke(null);
			 
		 }else{
			 //������
			  try {
				request.getRequestDispatcher(this.error).forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			}
		 }
		
	}



}
