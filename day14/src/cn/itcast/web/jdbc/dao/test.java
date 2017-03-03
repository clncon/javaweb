package cn.itcast.web.jdbc.dao;

import cn.itcast.web.jdbc.service.thransferService;

public class test {

	
	public static void main(String[] args) {
		thransferService ts = new thransferService();
		try {
			ts.transfer(1, 2, 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
