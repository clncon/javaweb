package cn.itcast.web.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
//�ü��������ڼ���JaveBean���󣬸�֪�����ʱ���󶨵�session����ʱ��session�н����
//�ü�����������XML������
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
