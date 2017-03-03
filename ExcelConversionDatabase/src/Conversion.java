import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class Conversion {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		

		String sql = "create table Student (ksh number(20),xm varchar2(20) not null,xb varchar2(10),xh number(8) primary key,xzb varchar2(20),"
				      + "zymc varchar2(50),xy varchar2(30),sfzh varchar2(18),cc varchar2(10),xz number(2),tddw varchar2(20),wyyzdm varchar2(10),"
			          + "dqdm varchar2(20),kslb varchar2(10),mz varchar2(10),zzmm varchar2(20),csrq number(10),ks varchar2(5),kstz varchar2(100),"
				      + "tc varchar2(100),lxdh varchar2(50),yzbm varchar2(20),jtdz varchar2(70),byzx varchar2(50))";

		
	
		
		String regex = ",([^,]*)(?=,)";
		File file = new File("E://Student.csv");
		BufferedReader br = null;
		FileReader fr = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/sera", "root", "jerry");
			
			//删除表，创建表语句
			stat = conn.createStatement();
			try {
				stat.execute("drop table Student");
			} catch (SQLException e) {
				System.out.println("初始删表失败!");
			}
			stat.execute(sql);
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			//标题
			String aaa = br.readLine();
			System.out.println(aaa);
			
			//pstat = conn.prepareStatement("insert into Student (ksh,xm,xb,xh,xzb,zymc,xy,sfzh,cc,xz,tddw,wyyzdm,dqdm,kslb,mz,zzmm,csrq,ks,kstz,tc,lxdh,yzbm,jtdz,byzx) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			int count = 0;
			while ((aaa=br.readLine()) != null) {
				int i = 0;
				
				pstat = conn.prepareStatement("insert into Student (ksh,xm,xb,xh,xzb,zymc,xy,sfzh,cc,xz,tddw,wyyzdm,dqdm,kslb,mz,zzmm,csrq,ks,kstz,tc,lxdh,yzbm,jtdz,byzx) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				aaa = ","+aaa+",";
//				System.out.println(aaa);
				
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(aaa);
				matcher.find();
				while (matcher.find()) {
					String temp = matcher.group(1);
					++i;
				    pstat.setString(i, temp);
//				    System.out.println(i + "    " + temp);
					if (i>=24) break;
				}
				pstat.executeUpdate();
				pstat.close();
				pstat = null;
				count++;
				System.out.println("正插入第" + count + "条记录!");
				
			}
		} catch (ClassNotFoundException e) {
			System.out.println("缺少Oracle驱动程序！");
		} catch (SQLException e) {
			//System.out.println("Oracle执行出错！");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("读取文件不存在！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				} 
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("连接关闭错误");
			}
		}
	}

}
