package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	/*
	 * isDO�����ӱ�ǩ���Ƿ���Ҫִ�У�ִֻ��һ����ǩ��
	 * false:��ʾδִ�У�Ĭ��Ϊfalse
	 * true:��ʾִ�й�
	 * */
	 private boolean isDo;

	public boolean isDo() {
		return isDo;
	}

	public void setDo(boolean isDo) {
		this.isDo = isDo;
	}


	public void doTag() throws JspException, IOException {
		  //ִ�б�ǩ��
		 this.getJspBody().invoke(null);
	}
	 
	 
	
}
