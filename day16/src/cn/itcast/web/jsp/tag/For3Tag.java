package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class For3Tag extends SimpleTagSupport {
	private String var;
	private int begin;
	private int end;
	private int step;
	public void setVar(String var) {
		this.var = var;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	
	public void doTag() throws JspException, IOException {
		
		  for(int i=this.begin;i<=this.end;i+=this.step){
			  //获得pageContext对象
			  PageContext pagecontext = (PageContext) this.getJspContext();
			  //将i存入pageContext对象
			  pagecontext.setAttribute(this.var, i);
			  this.getJspBody().invoke(null);
		  }
	}
    
	
}
