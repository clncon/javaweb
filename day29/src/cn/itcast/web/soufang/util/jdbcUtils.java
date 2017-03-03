package cn.itcast.web.soufang.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtils {
     private  static ComboPooledDataSource dataSoure;
     
     static{
    	 
    	 dataSoure = new ComboPooledDataSource();
     }

	public static ComboPooledDataSource getDataSoure() {
		return dataSoure;
	}
     
     
}
