package cn.itcast.java.proxy.exe3;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolTest {

	
	public static void main(String[] args) throws Exception {
		int size;
		 //�������ӳ�
		Pool pool = new Pool();
		//�������ӳ������ӵĸ���
		  size = pool.getSize();
         System.out.println("���ӳص����Ӹ���:"+size);
         //ȡ�����ӳ��е�һ������
          Connection conn = pool.getConnection();
          //��ӡ��ʱ���ӳ��е����Ӹ���
          size = pool.getSize();
          System.out.println("���ӳص����Ӹ���:"+size);
          //�ر�����
           conn.close();
           //��ӡ��ʱ�����Ӹ���
           size = pool.getSize();
           System.out.println("���ӳص����Ӹ���:"+size);
           
	}

}
