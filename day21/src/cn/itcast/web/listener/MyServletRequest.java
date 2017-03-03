package cn.itcast.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequest implements ServletRequestListener {


	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("requestDestroyed:");
	}


	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("requestInitialized:");

	}

}
