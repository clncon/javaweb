import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class MySqlConversion {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		

		String sql = "create table student(Id int(11) primary key, Name varchar(20), Gender varchar(5), myClass varchar(20), English int(11), Math int(11), Chinese int(11))";

		
	
		
		String regex = ",([^,]*)(?=,)";
		File file = new File("H://Student.csv");
		BufferedReader br = null;
		FileReader fr = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb3", "root", "root");
			
			//ɾ�������������
			stat = conn.createStatement();
			try {
				stat.execute("drop table Student");
			} catch (SQLException e) {
				System.out.println("��ʼɾ��ʧ��!");
			}
			stat.execute(sql);
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			//����
			String aaa = br.readLine();
			System.out.println(aaa);
			
			//pstat = conn.prepareStatement("insert into Student (ksh,xm,xb,xh,xzb,zymc,xy,sfzh,cc,xz,tddw,wyyzdm,dqdm,kslb,mz,zzmm,csrq,ks,kstz,tc,lxdh,yzbm,jtdz,byzx) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			int count = 0;
			while ((aaa=br.readLine()) != null) {
				int i = 0;
				boolean flag = true;
				
				pstat = conn.prepareStatement("insert into student (Id, Name, Gender, myClass, English, Math, Chinese) values (?, ?, ?, ?, ?, ?, ?)");
				//pstat = conn.prepareStatement("insert into Student (ksh,xm,xb,xh,xzb,zymc,xy,sfzh,cc,xz,tddw,wyyzdm,dqdm,kslb,mz,zzmm,csrq,ks,kstz,tc,lxdh,yzbm,jtdz,byzx) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				aaa = ","+aaa+",";
//				System.out.println(aaa);
				
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(aaa);
				matcher.find();
				while (matcher.find()) {
					String temp = matcher.group(1);
		//System.out.println((i+1) + "    " + temp);
					++i;
					
					if (i == 4) {
						pstat.setObject(1, temp);
					}
					if (i == 2) {
						pstat.setObject(2, temp);
					}
					if (i == 3) {
						pstat.setObject(3, temp);
					}
					/*if (i == 5) {
						if (temp.endsWith("��")) {
						int position = temp.length()-2;
						String classStr = "0" + temp.substring(position);
		System.out.println("�༶ �� " + classStr);	
						pstat.setObject(4, classStr);
						} else {
							flag = false;
							break;
						}
					} */
					
					if (i == 5) {
						if(count <= 50) {
							temp = "01��";
						} else if (count<=100) {
							temp = "02��";
						} else if (count<=150) {
							temp = "03��";
						} else if (count<=200) {
							temp = "04��";
						} else if (count<=250) {
							temp = "05��";
						} else if (count<=300) {
							temp = "06��";
						} else if (count<=350) {
							temp = "07��";
						} else if (count<=400) {
							temp = "08��";
						} else if (count<=450) {
							temp = "09��";
						} else if (count<=500) {
							temp = "10��";
						}
						
						pstat.setObject(4, temp);
					}
					
					//break;
					
					int english = (int)(Math.random()*50+51);
					int math = (int)(Math.random()*50+51);
					int chinese = (int)(Math.random()*50+51);
					pstat.setInt(5, english);
					pstat.setInt(6, math);
					pstat.setInt(7, chinese);
//					
//					
////				    pstat.setString(i, temp);
////				    System.out.println(i + "    " + temp);
//					if (i>=24) break;
				}
//				if (flag) {
//					
//					pstat.executeUpdate();
//				}
				pstat.executeUpdate();
				pstat.close();
				pstat = null;
				count++;
				System.out.println("�������" + count + "����¼!");
				
				if (count > 500) {
					break;
				}
				
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ȱ��Oracle��������");
		} catch (SQLException e) {
			//System.out.println("Oracleִ�г���");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("��ȡ�ļ������ڣ�");
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
				System.out.println("���ӹرմ���");
			}
		}
	}

}
