package cn.itcast.web.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

//监听器
public class KickListener implements HttpSessionAttributeListener {
	public void attributeAdded(HttpSessionBindingEvent se) {
		String name = se.getName();//name="username"
		String value = (String) se.getValue();//value="jack"
		if(name.equals("username")){
			//取得该用户对应的HttpSession
			HttpSession session = se.getSession();
			//取得该web应用的SerlvetContext对象
			ServletContext context = session.getServletContext();
			Map<String,HttpSession> map = (Map<String, HttpSession>) context.getAttribute("map");
			if(map==null){
				map = new HashMap<String,HttpSession>();
			}
			map.put(value,session);
			context.setAttribute("map",map);
		}
	}
	public void attributeRemoved(HttpSessionBindingEvent se) {
	}
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}
}
