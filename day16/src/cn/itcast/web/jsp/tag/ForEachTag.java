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
	    * var：用户返回给标签的值
	    * items:用于临时接收值，根据类型转换map或者list
	    * collection:用于收集list和map的值
	    * */
        private String var;
        private Object items;
        private Collection collection;
		public void setVar(String var) {
			this.var = var;
		}
		
     
		public void setItems(Object items) {
			this.items = items;
			//判断items是否为Collection
			if(this.items instanceof Collection){
				this.collection = (Collection) this.items;
			}
			//判断items是否为Map
			else if(this.items instanceof Map){
				Map map = (Map) this.items;
				 this.collection = map.entrySet();
			}
		}




		public void doTag() throws JspException, IOException {
			//遍历集合或Map中的值
			 Iterator<Object> it =this. collection.iterator();
			 while(it.hasNext()){
				 //将集合中每一个值，绑定到PageContext中
				 Object context = it.next();
				 PageContext pageContext = (PageContext) this.getJspContext();
				 pageContext.setAttribute(this.var,context);
				 this.getJspBody().invoke(null);

			 }
		}
        
        
}
