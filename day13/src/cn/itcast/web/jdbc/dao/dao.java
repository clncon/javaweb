package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import cn.itcast.web.jdbc.entity.person;

public class dao {
	
	public void save(person p ){
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlA = "insert into person(name)values(?)";
		String sqlB = "insert into card(location,pid)values(?,?)";
		
		//��person��ȡֵ
		try {
			conn = jdbcUtils.getMySqlConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sqlA,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,p.getName());
			pstmt.executeUpdate();
			//��ȡ����ֵ
			rs = pstmt.getGeneratedKeys();
			int pid = 0;
			if(rs.next()){
				Long temp = (Long) rs.getObject(1);
				pid = temp.intValue();
			}
			//��card�����һ����¼
			pstmt = (PreparedStatement) conn.prepareStatement(sqlB);
			pstmt.setString(1,p.getCard().getLocation());
			pstmt.setInt(2, pid);
			int i = pstmt.executeUpdate();
			System.out.println(i>0 ? "�ɹ�":"ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
