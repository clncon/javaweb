package cn.itcast.bbs.encode;

import java.security.MessageDigest;

public class Encode {
	  private static String[] data = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	  
	  
	  
	  public static String encodeByMd5(String password) throws Exception {
			 //创建MD5的加密器
			 MessageDigest md = MessageDigest.getInstance("md5");
			 //将明文加密
			   byte[] buff = md.digest(password.getBytes());
			   //将字符数组转成字符串
			return  ArrayToString(buff);
			  
			
		}
	    //将字符数组转成字符串
		private static String ArrayToString(byte[] buff) {
			 StringBuffer sb = new StringBuffer();
			for(int i=0;i<buff.length;i++){
				//将每个字符转成十六进制的字符串
				  sb.append(bytetoString(buff[i]));
			}
			return sb.toString();
		}
	    //将每个字符转成十六进制的字符串
		private static String bytetoString(byte b) {
			int temp = b;
			if(temp<0){
				temp = 255+temp;
			}
			int r1 = temp/16;
			int r2 = temp%16;
			/*System.out.println(r1+":"+r2);
			System.out.println(data[r1]+":"+data[r2]);*/
			return data[r1]+data[r2];
		}
}
