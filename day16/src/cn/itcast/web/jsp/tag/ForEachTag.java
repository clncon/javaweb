package cn.itcast.web.jsp.tag;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {
	   /*
	    * var���û����ظ���ǩ��ֵ
	    * items:������ʱ����ֵ����������ת��map����list
	    * collection:�����ռ�list��map��ֵ
	    * */
        private String var;
        private Object items;
        private Collection collection;
		public void setVar(String var) {
			this.var = var;
		}
		
     
		public void setItems(Object items) {
			this.items = items;
			//�ж�items�Ƿ�ΪCollection
			if(this.items instanceof Collection){
				this.collection = (Collection) this.items;
			}
			//�ж�items�Ƿ�ΪMap
			else if(this.items instanceof Map){
				Map map = (Map) this.items;
				 this.collection = map.entrySet();
			}
		}




		public void doTag() throws JspException, IOException {
			//�������ϻ�Map�е�ֵ
			 Iterator<Object> it =this. collection.iterator();
			 while(it.hasNext()){
				 //��������ÿһ��ֵ���󶨵�PageContext��
				 Object context = it.next();
				 PageContext pageContext = (PageContext) this.getJspContext();
				 pageContext.setAttribute(this.var,context);
				 this.getJspBody().invoke(null);

			 }
		}
        
        
}
