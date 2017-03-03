package cn.itcast.web.zhuangbei.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtils {
      private static  ComboPooledDataSource datasource;
      
      static{
    	  
    	  datasource = new ComboPooledDataSource();
      }

	public static ComboPooledDataSource getDatasource() {
		return datasource;
	}
      
}
