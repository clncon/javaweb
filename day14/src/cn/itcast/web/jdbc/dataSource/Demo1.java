package cn.itcast.web.jdbc.dataSource;


import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;




public class Demo1 {
	
		
	public static void main(String[] args) throws Exception {
         Connection conn;
         Long start = System.currentTimeMillis();
         //加载属性文件
         InputStream is = Demo1.class.getClassLoader().getResourceAsStream("cn/itcast/web/jdbc/config/dbcp.properties");
         Properties pros = new Properties();
         pros.load(is);
         //获得连接池工厂
         BasicDataSourceFactory bfactory = new BasicDataSourceFactory();
         //获得连接池
         DataSource ds = bfactory.createDataSource(pros);
			for(int i=0;i<100000;i++){
				//获得连接
			   conn = ds.getConnection();
			   System.out.println(i+":取得连接");
			   conn.close();
			}
		  Long end = System.currentTimeMillis();
	        System.out.println("共用"+(end-start)/1000+"s");

	}
}
