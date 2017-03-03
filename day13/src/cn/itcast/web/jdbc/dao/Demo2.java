package cn.itcast.web.jdbc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.mysql.jdbc.PreparedStatement;

public class Demo2 {

    public void write() throws IOException{
    	Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into test_clob(id,content) values(?,?)";
		try {
			conn = jdbcUtils.getMySqlConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			 String id = UUID.randomUUID().toString();
			 URL url =Demo1.
					 class.getClassLoader().
					 getResource("cn/itcast/web/jdbc/config/Strangers.mp3");
			 String path = url.getPath();
			 File file = new File(path);
			 InputStream is  = new FileInputStream(file);
			 pstmt.setString(1, id);
			 pstmt.setBinaryStream(2, is, file.length());
			 long i = pstmt.executeUpdate();
			 System.out.println(i>0? "³É¹¦":"Ê§°Ü");
			 is.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			jdbcUtils.close(pstmt);
			jdbcUtils.close(conn);
		}
    }
    public boolean write(String filepath) throws IOException{
    	boolean flag = false;
    	Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "insert into test_clob(id,content) values(?,?)";
		
		try {
			conn = jdbcUtils.getMySqlConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			 String id = UUID.randomUUID().toString();
			 File file = new File(filepath);
			 InputStream is  = new FileInputStream(file);
			 pstmt.setString(1, id);
			 pstmt.setBinaryStream(2, is, file.length());
			 long i = pstmt.executeUpdate();
			  if(i>0){
				  flag = true;
			  }
			 is.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			jdbcUtils.close(pstmt);
			jdbcUtils.close(conn);
		}
      return flag;
    	
    }
    public void read(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os =null;
		String sql = "select * from test_clob";
		try {
			conn = jdbcUtils.getMySqlConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				is = rs.getBinaryStream("content");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			jdbcUtils.close(pstmt);
			jdbcUtils.close(conn);
			jdbcUtils.close(rs);
		}
		
		try {
			 os = new FileOutputStream("d:\\strangers.mp3");
			byte[] buff = new byte[1024];
		    int len = 0;
		    while((len = is.read(buff))>0){
		    	os.write(buff,0, len);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	}
	public static void main(String[] args) {
		Demo2 demo2 = new Demo2();
		demo2.read();
	}

}
