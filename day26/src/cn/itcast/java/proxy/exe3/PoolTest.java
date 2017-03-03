package cn.itcast.java.proxy.exe3;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolTest {

	
	public static void main(String[] args) throws Exception {
		int size;
		 //创建连接池
		Pool pool = new Pool();
		//返回连接池中连接的个数
		  size = pool.getSize();
         System.out.println("连接池的连接个数:"+size);
         //取得连接池中的一个连接
          Connection conn = pool.getConnection();
          //打印此时连接池中的连接个数
          size = pool.getSize();
          System.out.println("连接池的连接个数:"+size);
          //关闭连接
           conn.close();
           //打印此时的连接个数
           size = pool.getSize();
           System.out.println("连接池的连接个数:"+size);
           
	}

}
