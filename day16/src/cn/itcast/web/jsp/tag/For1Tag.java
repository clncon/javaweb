package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class For1Tag extends SimpleTagSupport {

	
	public void doTag() throws JspException, IOException {
		JspFragment context = this.getJspBody();
		for(int i=0;i<10;i++){
			context.invoke(null);
		}
	}
    
}
