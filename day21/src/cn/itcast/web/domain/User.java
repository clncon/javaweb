package cn.itcast.web.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
//该监听器用于监听JaveBean对象，感知对象何时被绑定到session，何时从session中解除绑定
//该监听器无需在XML中配置
public class User implements HttpSessionBindingListener {
    private String username;
	public User(String username){
		this.username = username;
	}
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("valueBound");
	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("valueUnbound");
	}

}
