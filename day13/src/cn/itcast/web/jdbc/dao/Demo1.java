package cn.itcast.web.jdbc.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.mysql.jdbc.PreparedStatement;

public class Demo1 {

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
					 getResource("cn/itcast/web/jdbc/config/62.txt");
			 String path = url.getPath();
			 File file = new File(path);
			 Reader reader = new FileReader(file);
			 pstmt.setString(1, id);
			 pstmt.setCharacterStream(2, reader, (int)file.length());
			 int i = pstmt.executeUpdate();
			 System.out.println(i>0? "³É¹¦":"Ê§°Ü");
			 reader.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			jdbcUtils.close(pstmt);
			jdbcUtils.close(conn);
		}
	
	}
	public void read(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Reader reader = null;
		Writer writer=null;
		String sql = "select * from test_clob";
		try {
			conn = jdbcUtils.getMySqlConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				reader = rs.getCharacterStream("content");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			jdbcUtils.close(pstmt);
			jdbcUtils.close(conn);
			jdbcUtils.close(rs);
		}
		
		try {
			writer = new FileWriter("d:\\62.txt");
			char[] cuff = new char[1024];
		    int len = 0;
		    while((len = reader.read(cuff))>0){
		    	writer.write(cuff,0, len);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	}
	
	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		demo1.read();
	}

}
