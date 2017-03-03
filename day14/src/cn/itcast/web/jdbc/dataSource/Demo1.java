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
         //���������ļ�
         InputStream is = Demo1.class.getClassLoader().getResourceAsStream("cn/itcast/web/jdbc/config/dbcp.properties");
         Properties pros = new Properties();
         pros.load(is);
         //������ӳع���
         BasicDataSourceFactory bfactory = new BasicDataSourceFactory();
         //������ӳ�
         DataSource ds = bfactory.createDataSource(pros);
			for(int i=0;i<100000;i++){
				//�������
			   conn = ds.getConnection();
			   System.out.println(i+":ȡ������");
			   conn.close();
			}
		  Long end = System.currentTimeMillis();
	        System.out.println("����"+(end-start)/1000+"s");

	}
}
