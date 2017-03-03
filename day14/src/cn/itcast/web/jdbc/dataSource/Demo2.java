package cn.itcast.web.jdbc.dataSource;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo2 {

	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		 Long start = System.currentTimeMillis();
		ComboPooledDataSource cds = new ComboPooledDataSource();
		for(int i = 0;i<100000;i++)
		{
			conn =cds.getConnection();
			if(conn!=null){
			System.out.println(i+"取得连接");
			}
			conn.close();
		}
		 Long end = System.currentTimeMillis();
	        System.out.println("共用"+(end-start)/1000+"s");
	}

}
