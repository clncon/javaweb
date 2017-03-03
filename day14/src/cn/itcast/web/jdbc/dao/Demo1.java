package cn.itcast.web.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import cn.itcast.web.jdbc.util.jdbcUtils;

public class Demo1 {
     //ʹ��jdbc�����洢����
	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement  cstmt = null;
		ResultSet rs = null;
		//���ô洢���̵�sql���
		String sql = "{call add_pro(?,?,?)}";
		
		try {
			//��ȡ���ݿ�����
			conn = jdbcUtils.getMySqlConnection();
			cstmt = conn.prepareCall(sql);
			//���ò���ֵ
			cstmt.setInt(1, 100);
			cstmt.setInt(2, 100);
			//ע���������
			cstmt.registerOutParameter(3, Types.INTEGER);
			//ִ�и�sql���
			boolean flag = cstmt.execute();
			//ȡ���������ֵ
			
				int out = cstmt.getInt(3);
				System.out.println("flag="+flag);
				System.out.println("out="+out);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.close(rs);
			jdbcUtils.close(cstmt);
			jdbcUtils.close(conn);
			
		}

	}

}
