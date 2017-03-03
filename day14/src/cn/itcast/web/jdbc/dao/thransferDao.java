package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.web.jdbc.domian.Account;
import cn.itcast.web.jdbc.util.jdbcUtils;
//查看数据库中是否有该id号
public class thransferDao {
	public static Account findAccountById(int id,Connection conn){
		//Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;
	    String sql = "select * from account where id = ?";	
		  try {
			 // conn  = jdbcUtils.getMySqlConnection();
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, id);
			 rs =  pstmt.executeQuery();
			  if(rs.next()){
				  account = new Account();
				  account.setId(rs.getInt("id"));
				  account.setName(rs.getString("name"));
				  account.setSalary(rs.getFloat("salary"));
			  }
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			jdbcUtils.close(rs);
			jdbcUtils.close(pstmt);
			//jdbcUtils.close(conn);
		}
		
		
		return account;
		
	}
    //更新数据库中指定id号的薪水值
	public static void updateAccountById(Account newaccount,Connection conn) throws SQLException{
		    //Connection conn  = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    String sql = "update account set salary = ? where id = ?";
		    try {
		    	//conn = jdbcUtils.getMySqlConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1,newaccount.getSalary() );
				pstmt.setInt(2, newaccount.getId());
			    pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}finally{
				jdbcUtils.close(rs);
				jdbcUtils.close(pstmt);
				//jdbcUtils.close(conn);
			}
	}

}
